package com.example.myapplication;

import android.provider.BaseColumns;

class TaskContract {
    public static final String DB_NAME = "todolist.db";
    public static final int DB_VERSION = 13; // Update the version when schema changes

    public class TaskEntry implements BaseColumns {
        public static final String TABLE = "tasks";
        public static final String COL_TASK_TITLE = "title";
        public static final String COL_TASK_DESCRIPTION = "description"; // New column
        public static final String COL_DUE_DATE = "due_date";
        public static final String COL_PRIORITY = "priority";
        public static final String COL_STATUS = "status";
        public static final String COL_CATEGORY = "category";
    }
}
