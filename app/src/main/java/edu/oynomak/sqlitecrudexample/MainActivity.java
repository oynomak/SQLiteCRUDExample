package edu.oynomak.sqlitecrudexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String DATABASE_NAME = "employeedb";

    TextView textViewViewEmployees, linkSendSMS;
    EditText editTextName, editTextSalary;
    Spinner spinnerDepartment;

    SQLiteDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewViewEmployees = (TextView) findViewById(R.id.textViewViewEmployees);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextSalary = (EditText) findViewById(R.id.editTextSalary);
        spinnerDepartment = (Spinner) findViewById(R.id.spinnerDepartment);
        linkSendSMS = (TextView) findViewById(R.id.btnSendSMS);

        // Setting CLICK-able useful tools on the form
        findViewById(R.id.buttonAddEmployee).setOnClickListener(this);
        textViewViewEmployees.setOnClickListener(this);
        linkSendSMS.setOnClickListener(this);

        // creating a database
        mDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);

        // Creating Employee table
        createEmployeeTable();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.options_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.sms_item:

                startActivity(new Intent(this, SendSMSActivity.class));

                return true;

            case R.id.email_item:

                startActivity(new Intent(this, SendMailActivity.class));

                return true;

            case R.id.map_item:

                startActivity(new Intent(this, GoogleMapsActivity.class));

                return true;

            default:

                return super.onOptionsItemSelected(item);

        }
    }

    //In this method we will do the create operation
    private void addEmployee() {

        String name = editTextName.getText().toString().trim();
        String salary = editTextSalary.getText().toString().trim();
        String dept = spinnerDepartment.getSelectedItem().toString();

        //getting the current time for joining date
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String joiningDate = sdf.format(cal.getTime());

        //validating the inputs
        if (inputsAreCorrect(name, salary)) {

            String insertSQL = "INSERT INTO employee \n" +
                    "(name, department, joiningdate, salary) \n" +
                    "VALUES \n" +
                    "(?, ?, ?, ?);";

            //using the same method execSQL for inserting values
            //this time it has two parameters
            //first is the sql string and second is the parameters that is to be binded with the query
            mDatabase.execSQL(insertSQL, new String[]{name, dept, joiningDate, salary});

            Toast.makeText(this, "Employee Added Successfully", Toast.LENGTH_SHORT).show();

            // Resetting form fields after saving...
            resetForm();
        }
    }

    //this method will create the table
    //as we are going to call this method everytime we will launch the application
    //I have added IF NOT EXISTS to the SQL
    //so it will only create the table when the table is not already created
    private void createEmployeeTable() {
        mDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS employee (\n" +
                        "    `_id` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                        "    `name` varchar(200) NOT NULL,\n" +
                        "    `department` varchar(200) NOT NULL,\n" +
                        "    `joiningdate` datetime NOT NULL,\n" +
                        "    `salary` double NOT NULL\n" +
                        ");"
        );
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.buttonAddEmployee:

                addEmployee();

                break;
            case R.id.textViewViewEmployees:

                startActivity(new Intent(this, EmployeeActivity.class));

                break;

            case R.id.btnSendSMS:

                startActivity(new Intent(this, BonusActivity.class));

                break;
        }
    }

    // Reset inputs values to blank
    private void resetForm(){

        editTextName.setText("");
        editTextSalary.setText("");
        spinnerDepartment.setSelection(0);
    }

    //this method will validate the name and salary
    //dept does not need validation as it is a spinner and it cannot be empty
    private boolean inputsAreCorrect(String name, String salary) {
        if (name.isEmpty()) {
            editTextName.setError("Please enter a name");
            editTextName.requestFocus();
            return false;
        }

        if (salary.isEmpty() || Integer.parseInt(salary) <= 0) {
            editTextSalary.setError("Please enter salary");
            editTextSalary.requestFocus();
            return false;
        }
        return true;
    }
}
