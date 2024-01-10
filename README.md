
**Title: Android To-Do List Application with SQLite Database**

**Description:**

The Android To-Do List Application is designed to help users organize and manage their tasks efficiently. The application uses SQLite as a local database to store and retrieve task-related information. Users can create, update, delete, and mark tasks as completed.

**Key Features:**

**Task Management:**

Create new tasks with a title, description,Priority and due date.

Edit existing tasks to modify details.

Mark tasks as completed or uncompleted.

Delete tasks that are no longer needed.

**SQLite Database:**

Utilize SQLite database to store task-related information locally on the device.

Use SQLite queries to perform CRUD (Create, Read, Update, Delete) operations on the database.

**User Interface:**

Design an intuitive and user-friendly interface for adding, editing, and viewing tasks.

Implement a RecyclerView to display the list of tasks with appropriate sorting options.

**Date and Time Handling:**

Include date and time pickers for setting due dates for tasks.

Implement logic to notify users about upcoming or overdue tasks.

**Data Validation:**

Validate user input to ensure that tasks have necessary information and are correctly formatted.

Handle potential errors gracefully to provide a smooth user experience.

**Instructions on how to setup and run the application:**

Setting up and running an Android application using an SQLite database involves several steps. Below is a general guide that assumes you have Android Studio installed and have basic knowledge of Android development:

**Step 1: Install Android Studio**

If you haven't installed Android Studio, download and install it from the official Android Developer website.

**Step 2: Create a New Android Project**

Open Android Studio.

Click on "Start a new Android Studio project."

Choose an appropriate template, such as "Empty Activity" or "Basic Activity."

Complete the project configuration by providing a name, package name, and other necessary details.

**Step 3: Design Database Schema**

Identify the entities in your application (e.g., Task).

Define the fields for each entity (e.g., id, title, description, due date, completion status).

Create a SQLite database schema in a separate class (e.g., DatabaseHelper) that extends SQLiteOpenHelper.

**Step 4: Implement Database Operations**

Write methods in the DatabaseHelper class to handle CRUD operations (Create, Read, Update, Delete).

Use SQLite queries to interact with the database.

**Step 5: Create UI Components**

Design the user interface using XML layout files in the res/layout directory.

Create appropriate UI components (e.g., EditText, Button) for task management.

**Step 6: Integrate Database with UI**

Instantiate the DatabaseHelper class in your main activity or relevant activity.

Use the database helper methods to perform database operations based on user actions (e.g., adding a task, updating a task).

**Step 7: Test Your Application**

Test the application on an emulator or a physical Android device.
Check for any errors or unexpected behavior.
Use Android Studio's debugging tools to identify and fix issues.

**Note:** Simply download zip code, import it into Android Studio and run on the emulator or physical device.



**User Interface**
![Screenshot_20240110_150150](https://github.com/vutukurikavya7/KekaTaskToDoList/assets/80099931/f4a42e16-30b9-4739-a721-cdf85d1b088d)

**Write task**

![Screenshot_20240110_150226](https://github.com/vutukurikavya7/KekaTaskToDoList/assets/80099931/6be6d80b-fc55-4124-8f29-3dde9519ce9f)

**Selecting Priority**

![Screenshot_20240110_150253](https://github.com/vutukurikavya7/KekaTaskToDoList/assets/80099931/4335c255-2c97-4f42-b5f5-b190ec2174b4)

**Selecting progress**
![Screenshot_20240110_150309](https://github.com/vutukurikavya7/KekaTaskToDoList/assets/80099931/f317bb9f-fa3a-4754-b850-0b1ecd68d4a2)

**selecting category**
![Screenshot_20240110_150331](https://github.com/vutukurikavya7/KekaTaskToDoList/assets/80099931/425a8e71-101a-474b-8202-f1b0dce03988)

**setting due date**
![Screenshot_20240110_150355](https://github.com/vutukurikavya7/KekaTaskToDoList/assets/80099931/8c65e59f-75fd-4241-a6d3-03ec4fd2bc07)


**adding first task**
![Screenshot_20240110_151113](https://github.com/vutukurikavya7/KekaTaskToDoList/assets/80099931/e00778a5-665b-4361-912e-6e98900d07f8)

**adding second task**
![Screenshot_20240110_151211](https://github.com/vutukurikavya7/KekaTaskToDoList/assets/80099931/dcf7d04e-9fd5-4162-a915-276afc5465cf)

**displaying 2 tasks**
![Screenshot_20240110_151234](https://github.com/vutukurikavya7/KekaTaskToDoList/assets/80099931/6be926fb-bf9c-4907-89a2-7d969d2e047d)

**deleting a task**
![Screenshot_20240110_151338](https://github.com/vutukurikavya7/KekaTaskToDoList/assets/80099931/4cba20c3-b77e-4cad-9314-c864e10d178a)

**displaying after deleting a task#**
![Screenshot_20240110_151644](https://github.com/vutukurikavya7/KekaTaskToDoList/assets/80099931/05dbf082-b397-48b4-8493-b7b8d0a4fc03)

**updating the task**
![Screenshot_20240110_151839](https://github.com/vutukurikavya7/KekaTaskToDoList/assets/80099931/2ae3a1c9-2eca-4b8c-8ae5-05a68fd96878)

