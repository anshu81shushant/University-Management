# University Management System

A Java-based desktop application designed to streamline university operations, including managing student and faculty records, examination marks, leave applications, and fee structures. This system provides a user-friendly interface for administrators, faculty, and students to interact with university data efficiently.

## Features
- **Student Management**: Add, update, and view student details (e.g., name, roll number, course, Aadhar number).
- **Faculty Management**: Add, update, and view faculty details (e.g., employee ID, qualifications, department).
- **Examination Management**: Enter and view student marks, calculate CGPA, and generate result reports.
- **Fee Structure**: Display fee details for various courses.
- **User Interface**: Intuitive GUI with login authentication, splash screen, and dynamic elements like scrolling welcome text.
- **Database Integration**: Uses MySQL to store and retrieve data securely.



## Prerequisites
- **Java**: JDK 8 or higher
- **MySQL**: Version 8.0 or later
- **MySQL JDBC Driver**: For database connectivity
- **IDE**: IntelliJ IDEA, Eclipse, or any Java-compatible IDE (optional)
- **Image Files**: Icons referenced in the code (e.g., `about.jpg`, `exam.jpg`) in `src/icons/`

## Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/UniversityManagementSystem.git
cd UniversityManagementSystem

2. Set Up MySQL Database

Install MySQL and ensure it’s running.
Create a database named universitymanagementsystem:CREATE DATABASE universitymanagementsystem;


Create the required tables (example schema, adjust as needed):-- Students table
CREATE TABLE student (
    name VARCHAR(50),
    fname VARCHAR(50),
    rollno VARCHAR(20) PRIMARY KEY,
    dob VARCHAR(20),
    address VARCHAR(100),
    phone VARCHAR(15),
    email VARCHAR(50),
    x VARCHAR(10),
    xii VARCHAR(10),
    aadhar VARCHAR(15),
    course VARCHAR(50),
    branch VARCHAR(50)
);

-- Teachers table
CREATE TABLE teacher (
    name VARCHAR(50),
    fname VARCHAR(50),
    empId VARCHAR(20) PRIMARY KEY,
    dob VARCHAR(20),
    address VARCHAR(100),
    phone VARCHAR(15),
    email VARCHAR(50),
    gradcgpa VARCHAR(10),
    postgradcgpa VARCHAR(10),
    aadhar VARCHAR(15),
    course VARCHAR(50),
    branch VARCHAR(50)
);

-- Subjects table
CREATE TABLE subject (
    rollno VARCHAR(20),
    semester VARCHAR(20),
    subject1 VARCHAR(50),
    subject2 VARCHAR(50),
    subject3 VARCHAR(50),
    subject4 VARCHAR(50),
    subject5 VARCHAR(50),
    FOREIGN KEY (rollno) REFERENCES student(rollno)
);

-- Marks table
CREATE TABLE marks (
    rollno VARCHAR(20),
    semester VARCHAR(20),
    marks1 VARCHAR(10),
    marks2 VARCHAR(10),
    marks3 VARCHAR(10),
    marks4 VARCHAR(10),
    marks5 VARCHAR(10),
    FOREIGN KEY (rollno) REFERENCES student(rollno)
);

-- Fee table
CREATE TABLE fee (
    course_name VARCHAR(50),
    semester1 VARCHAR(10),
    semester2 VARCHAR(10),
    semester3 VARCHAR(10),
    semester4 VARCHAR(10),
    semester5 VARCHAR(10),
    semester6 VARCHAR(10),
    semester7 VARCHAR(10),
    semester8 VARCHAR(10)
);

-- Login table
CREATE TABLE login (
    username VARCHAR(50),
    password VARCHAR(50)
);

-- Example login credentials
INSERT INTO login (username, password) VALUES ('admin', 'admin123');


Save the above SQL commands in a schema.sql file and execute it in MySQL:mysql -u root -p universitymanagementsystem < schema.sql


Update the database credentials in Conn.java:c = DriverManager.getConnection("jdbc:mysql:///universitymanagementsystem", "root", "your_password");

Replace "your_password" with your MySQL root password.

3. Add Icon Files

Place the required image files (about.jpg, exam.jpg, first.jpg, second.jpg, third.jpg) in the src/icons/ directory.
If images are unavailable, modify the code to handle missing files (e.g., use default icons or remove image references).

4. Compile and Run

Open the project in an IDE or use the command line.
Compile the Java files:javac -d . src/university/management/system/*.java


Run the application:java university.management.system.Splash


Log in using the credentials from the login table (e.g., username: admin, password: admin123).

Usage

Splash Screen: Displays a welcome interface with options to log in or view information.
Login: Authenticate using admin credentials to access the dashboard (Project.java).
Dashboard: Use the menu bar to:
Add/view/update student and faculty details.
Enter marks and view results.
Check fee structures.
Access utilities like Notepad and Calculator.
View the About page for developer information.



Dependencies

Java Swing: For GUI components.
MySQL Connector/J: JDBC driver for MySQL (download from MySQL website).
JCalendar: For date picker (JDateChooser in AddStudent.java, AddTeacher.java). Download from Toedter and add to the classpath.
RS2XML: For table data binding (DbUtils in ExaminationDetails.java, FeeStructure.java, StudentDetails.java). Download from SourceForge and add to the classpath.

Troubleshooting

Database Connection Errors: Ensure MySQL is running, credentials in Conn.java are correct, and the database/tables exist.
Missing Icons: Place images in src/icons/ or update code to skip image loading.
Library Issues: Add jcalendar.jar and rs2xml.jar to the project’s build path in your IDE or classpath.
Compilation Errors: Verify the package structure and ensure all files are in src/university/management/system/.

Contributing
Contributions are welcome! Please fork the repository, make changes, and submit a pull request. Ensure code follows Java naming conventions and includes comments for clarity.
Developers

Jyotika (220BTCCSE132)
Kashish (220BTCCSE044)
Deepali (231BTCSEAM003)
Tanish (220BTCCSE037)
Anshu (220BTCCSE043)

License
This project is licensed under the MIT License. See the LICENSE file for details.

Version: 1.0 | Developed for Delhi Technical University```
