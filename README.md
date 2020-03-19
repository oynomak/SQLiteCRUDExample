# Android SQLite Database Example – CRUD Operation in SQLite
Here is an Android SQLite Database Example. We have SQLite database in android that we can use as a local SQL Database for our android application.

This Android SQLite Database Example covers:
    - Creating Database,
    - Creating Tables,
    - Creating Records,
    - Reading Records,
    - Updating Records and
    - Deleting Records
in Android SQLite Database.

After going through this post you will be having a complete idea about using SQLite database for your Android Application.

### Employee table:
```
CREATE TABLE IF NOT EXISTS employee (
    `_id` INTEGER PRIMARY KEY AUTOINCREMENT,
    `name` varchar(200) NOT NULL,
    `department` varchar(200) NOT NULL,
    `joiningdate` datetime NOT NULL,
    `salary` double NOT NULL
);

```

## BONUS:

Send SMS functionality is added as a bonus to this example...

### SOURCES:
        - https://www.simplifiedcoding.net/android-sqlite-database-example/
        - https://mkyong.com/android/how-to-send-sms-message-in-android/