**OOP Project Description**

Introduction

We would like to begin by highlighting the fact that the main goal of this project was to fix all learned knowledge during Object – oriented programming course and to apply them while creating a “University Study System”. The following project was done in a group, so another goal was to develop our teamwork skills, so in the future we can apply them in real work. The main objective could be incarnated by utilizing all OOP concepts. In order to create a project, we followed a simple plan that consisted of UML diagram creation and Code implementation.
Overall, this project helped us to review covered topics and gave us a general idea about teamwork. 

Required classed are : ***User, Employee, Teacher, Manager, Student, Admin, Course, Mark, Lesson, Librarian OR ServiceDeskWorker (choose one of them)**.* Other classes are up to you.

Take into account these details:

- Lesson type - lecture/practice
- Students - bachelor. Master, PhD
- There can be more than 1 instructors per course 
- In the system, Teachers and Students CAN be researchers. Those teachers, who are professors and PhD students ARE always researchers. However, bachelor,master students and teachers, who are not professors(e.g., tutors, senior lectures, etc.) can also be researchers. And there can be an employee, who is neither a Teacher nor Student, but he is a Researcher. Researcher has a research projects(s), research papers (also an Object!), h-index, etc.
- Report generation (about marks, just simple statistics)
- Служебные записки (work messages)
- Library  or or Service Desk functionality 
- For a Service Desk, tech support workers need to be able to see new orders, accept/reject the. After acceptation, the order is not “new” anymore, view done and accepted(but not yet done) orders.
- For a Library, librarian(s) must have a list of books and their quantities. Students can borrow a book for some period (Max 6 months), return it.
- Diploma projects
- Elective courses 
- News with comments
- Service Desk (e.g., to fix a projector or printer)
- 3 or more  patterns

**General requirements:**

- OOP style
- Usage of Comparable, Comparators, equals, hashcode, toString, etc.
- Properly working serialization (think about Data Storage and some pattern)
- Any user should access the system via authentication
- Intuitive usage
- Consistency with UML
- Do not forget about proper usage of enumerations. You can use them to represent teachersʼ titles, for example - tutor, lector, senior\_lector, professor, etc.
- Proper and logically consistent usage of Collections
- Usage of java api (standard classes). Do not reinvent the bicycle.
- Documentation
- Low coupling, high cohesion

**Approximate Checklist:**

- **Admin**

Manage Users (Add, remove, update) See log files about user actions

- **Teacher**
- View Courses
- Manage Course files
- View Students, info about students
- Put marks
- Send  messages to other employees (actually, any employee can send the message to any employee)
- **Student**
- View Courses, Register for Courses
- View info about teacher of a specific course
- View Marks
- View Transcript
- Rate teachers
- Get Transcript
- Student organizations (e.g., OSIT). Student can be a member/ head.
- **Manager**
- Approve students registration, Add courses for registration (specify for which major/year of study the course is intended)
- Assign courses to teachers
- Manager types – OR, Deparments, etc. (use enumeration).
- Create statistical reports on academic performance. 
- Manage news
- View info about students and teachers (in different ways , e.g., sorted by gpa , alphabetically , etc)
- View requests from employees (they have to be signed by dean/rector)

**Important note:**

**Account for details! For example:**

- Students canʼt have more than 21 credits
- Students canʼt fail more than 3 times
- FIT Students canʼt have FOGI courses (only as electives)
- Mark consists of 1 , 2ⁿ  attestation, and final. 
- Many more, really … 

**MOST IMPORTANT FUNCTIONALITY** - course registration, putting marks. Finish it first.

**Bonus:**  Take into account as many details as possible (for valuable extra features you will get extra points, e.g. Schedule generation (take into account room load, room type, etc.), Attendance, Report generation option for teacher (about marks), advanced search by regular expressions, research teams and collaboration between researchers, etc. 
