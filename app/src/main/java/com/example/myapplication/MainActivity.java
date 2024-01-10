package com.example.myapplication;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Spinner;


import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    private EditText editTextTask;
    private EditText editTextDescription;
    private Button buttonSetDueDate;
    private ListView listViewTasks;
    private ArrayAdapter<String> tasksAdapter;
    private TaskDbHelper dbHelper;
    private Calendar dueDateCalendar;
    private Spinner spinnerPriority;
    private Spinner spinnerStatus;
    private Spinner spinnerCategory;
    private ArrayAdapter<CharSequence> priorityAdapter;
    private ArrayAdapter<CharSequence> statusAdapter;
    private ArrayAdapter<CharSequence> categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new TaskDbHelper(this);
        dueDateCalendar = Calendar.getInstance();

        editTextTask = findViewById(R.id.editTextTask);
        editTextDescription = findViewById(R.id.editTextDescription);
        spinnerPriority = findViewById(R.id.spinnerPriority);
        spinnerStatus = findViewById(R.id.spinnerStatus);
        spinnerCategory = findViewById(R.id.spinnerCategory);
        Button buttonAddTask = findViewById(R.id.buttonAddTask);
        buttonSetDueDate = findViewById(R.id.buttonSetDueDate);
        listViewTasks = findViewById(R.id.listViewTasks);
        priorityAdapter = ArrayAdapter.createFromResource(this, R.array.priority_array, android.R.layout.simple_spinner_item);
        priorityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPriority.setAdapter(priorityAdapter);
        statusAdapter = ArrayAdapter.createFromResource(this, R.array.status_array, android.R.layout.simple_spinner_item);
        statusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStatus.setAdapter(statusAdapter);
        categoryAdapter = ArrayAdapter.createFromResource(this, R.array.category_array, android.R.layout.simple_spinner_item);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(categoryAdapter);



        loadTasks();

        tasksAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, loadTasks());
        listViewTasks.setAdapter(tasksAdapter);

        buttonAddTask.setOnClickListener(v -> addTask());

        buttonSetDueDate.setOnClickListener(v -> showDatePickerDialog());
    }


    private void addTask() {
        String task = editTextTask.getText().toString().trim();
        String description = editTextDescription.getText().toString().trim();
        String priority = spinnerPriority.getSelectedItem().toString();
        String status = spinnerStatus.getSelectedItem().toString();
        String category = spinnerCategory.getSelectedItem().toString();
        if (!task.isEmpty()) {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(TaskContract.TaskEntry.COL_TASK_TITLE, task);
            values.put(TaskContract.TaskEntry.COL_TASK_DESCRIPTION, description);
            values.put(TaskContract.TaskEntry.COL_PRIORITY, priority);
            values.put(TaskContract.TaskEntry.COL_STATUS, status);
            values.put(TaskContract.TaskEntry.COL_CATEGORY, category);
            values.put(TaskContract.TaskEntry.COL_DUE_DATE, getFormattedDate());
            db.insertWithOnConflict(TaskContract.TaskEntry.TABLE,
                    null,
                    values,
                    SQLiteDatabase.CONFLICT_REPLACE);
            db.close();
            tasksAdapter.clear();
            tasksAdapter.addAll(loadTasks());
            editTextTask.setText("");
            editTextDescription.setText("");
            tasksAdapter.notifyDataSetChanged();// Clear the description field
        }
    }

    private ArrayList<String> loadTasks() {
        ArrayList<String> taskList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TaskContract.TaskEntry.TABLE,
                new String[]{TaskContract.TaskEntry.COL_TASK_TITLE, TaskContract.TaskEntry.COL_TASK_DESCRIPTION, TaskContract.TaskEntry.COL_PRIORITY,TaskContract.TaskEntry.COL_STATUS,TaskContract.TaskEntry.COL_CATEGORY,TaskContract.TaskEntry.COL_DUE_DATE},
                null,
                null,
                null,
                null,
                null);

        while (cursor.moveToNext()) {
            int titleIndex = cursor.getColumnIndex(TaskContract.TaskEntry.COL_TASK_TITLE);
            int descIndex = cursor.getColumnIndex(TaskContract.TaskEntry.COL_TASK_DESCRIPTION);
            int priorityIndex = cursor.getColumnIndex(TaskContract.TaskEntry.COL_PRIORITY);
            int dateIndex = cursor.getColumnIndex(TaskContract.TaskEntry.COL_DUE_DATE);
            int statusIndex = cursor.getColumnIndex(TaskContract.TaskEntry.COL_STATUS);
            int categoryIndex = cursor.getColumnIndex(TaskContract.TaskEntry.COL_CATEGORY);
            String taskTitle = cursor.getString(titleIndex);
            String taskDesc = cursor.getString(descIndex);
            String priority = cursor.getString(priorityIndex);
            String dueDate = cursor.getString(dateIndex);
            String status = cursor.getString(statusIndex);
            String category = cursor.getString(categoryIndex);

            StringBuilder taskStringBuilder = new StringBuilder(" Task: "+taskTitle);
            taskStringBuilder.append("\n");
            if (taskDesc != null && !taskDesc.isEmpty()) {
                taskStringBuilder.append(" Description: ").append(taskDesc);
            }
            taskStringBuilder.append("\n");
            if (priority != null && !priority.isEmpty()) {
                taskStringBuilder.append(" Priority: ").append(priority);
            }
                taskStringBuilder.append("\n");
            if (status != null && !status.isEmpty()) {
                taskStringBuilder.append(" Status: ").append(status);
            }
            taskStringBuilder.append("\n");
            if (category != null && !category.isEmpty()) {
                taskStringBuilder.append(" Category: ").append(category);
            }
            taskStringBuilder.append("\n");
            if (dueDate != null && !dueDate.isEmpty()) {
                taskStringBuilder.append(" Due: ").append(dueDate);
            }



            taskList.add(taskStringBuilder.toString());


        }

        cursor.close();
        db.close();

        return taskList;
    }


    private void showDatePickerDialog() {
        new DatePickerDialog(this, dateSetListener,
                dueDateCalendar.get(Calendar.YEAR),
                dueDateCalendar.get(Calendar.MONTH),
                dueDateCalendar.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            dueDateCalendar.set(Calendar.YEAR, year);
            dueDateCalendar.set(Calendar.MONTH, month);
            dueDateCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        }
    };

    private String getFormattedDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return dateFormat.format(dueDateCalendar.getTime());
    }
}
