# GRADE 12 IT PAT 2020 - Home Affairs System

You can find the files on my google drive from phase 2: https://drive.google.com/drive/folders/15GQAnlBpw5esaAMstPHUhA_nnxFR_T4w?usp=sharing

In 2020, my Information Technology Practical Assessment Task (IT PAT) was aimed at developing an online system to streamline services at Home Affairs. The objective was to reduce the time applicants spend in long queues, improve the efficiency of processing Smart IDs, Passport Renewals, and Unabridged Birth Certificates, and make it easier for staff to manage these processes. This system provides distinct roles for applicants, staff members, and administrators, all connected through a user-friendly interface and supported by a robust database. Through phases 1, 2, and 4 of the project, I developed, tested, and refined this system, ensuring it met user needs and operated efficiently.

### Phase 1: Initial System Design and Specifications

In the **introduction** of Phase 1, the motivation for the project was rooted in the technological advancements that have transformed industries globally, yet Home Affairs lagged behind. Many people are reluctant to waste time standing in long lines for essential services like passport renewals or obtaining Smart IDs. The aim was to address this problem by creating an **online booking system** for Home Affairs, providing convenience for users and improving the efficiency of operations. 

The **specifications of the program functions** were central to achieving this goal. The system was designed to allow applicants to book services, view or modify their bookings, and manage their personal details. Staff members had the added ability to retrieve applicant information and monitor daily bookings, while administrators could manage staff and ensure smooth operations. The program had to verify user authenticity with a login screen for applicants, staff, and administrators, ensuring secure access to the system. Moreover, it featured error handling and help functions to assist users and improve the overall experience.

The **applicant interface** was intentionally designed to be simple, featuring easy-to-navigate buttons and screens, with the Home Affairs logo to maintain branding. Internal help features were embedded in the program, providing guidance when errors occurred, and an external PDF manual was made available for additional support. Data storage was handled through a series of relational database tables, such as `tblSmartID`, `tblPassport`, and `tblBooking`, all stored in **Microsoft Access**. This ensured the information was well-organized, easily retrievable, and secure. The system requirements, including minimum and recommended hardware configurations, were also clearly defined to ensure smooth operation on most devices.

### Phase 2: Building and Managing Core Functions

Phase 2 focused on the **implementation of key functions and data validation**. The system included **critical algorithms** that allowed applicants to book appointments for services like Smart IDs, Passport Renewals, and Unabridged Birth Certificates. The **booking process** was the core of the system’s functionality, ensuring that users could select appropriate times, upload required documents, and receive confirmation for their bookings. Without this capability, the system would not fulfill its primary purpose of reducing congestion at Home Affairs.

The **Database Manager Class** provided by my IT teacher was crucial in Phase 2. This externally sourced class allowed the program to connect to and manipulate the Microsoft Access database tables. The manager classes, including `ApplicantManager` and `BookingManager`, interacted with the database to perform essential functions such as retrieving applicant information, storing bookings, and managing staff details. The use of this class made the system's data management robust and efficient, ensuring that information could be accessed and modified without issues.

Phase 2 also saw the development of several **interface screens** for booking Smart IDs, checking document uploads, and verifying applicant information. For example, when an applicant booked a Smart ID, the program ensured that necessary documents were uploaded, and error messages were displayed if something was missing. Each step of the process was validated, ensuring that incorrect or missing data was flagged immediately, and users were prompted to provide the required information before proceeding. This was a critical step in ensuring the program’s accuracy and reliability.

### Phase 3: Coding

Phase 3 contained the code used for each application process, including `ActionPerformedScreen`, `AddStaffMember`, `AdministratorHomeScreen`, `Applicant`, `ApplicantManager`, `Appointment`, `AppointmentManager`, `Category`, `DatabaseManager` and `EditDetails`. This coding shows how I handle adding a new staff member, dealing with an applicant, etc.

### Phase 4: Advanced Features and Testing

Phase 4 introduced **advanced techniques** to further enhance the functionality and user experience of the system. I implemented **menu bars** to declutter the screen, ensuring users could easily navigate between different sections of the system. **Ghost text** was used to guide users in filling out forms, reducing errors by providing input hints directly in text fields. A **help button** linked to an external website with live chat support, offering real-time assistance to users facing difficulties.

Another important feature was the ability for applicants to upload **photos** and documents, such as copies of their IDs, birth certificates, or proof of residence. This capability reduced the need for physical visits to Home Affairs, allowing much of the verification to happen online. These uploaded documents were stored securely in the database, associated with each applicant’s ID number. This improved the efficiency of the system, minimizing the time spent at Home Affairs and significantly reducing in-person congestion.

The final part of Phase 4 involved creating a **test plan** and evaluating the system’s performance using different types of data—normal, extreme, and abnormal inputs. Normal data was what the system expected, while extreme data included values that were technically valid but larger than normal, and abnormal data was intentionally incorrect (e.g., letters in numeric fields). Testing revealed that the system performed well with normal and extreme data, and the defensive programming techniques implemented successfully handled abnormal inputs by preventing errors and guiding users to correct them.

### Conclusion: A Robust and User-Centered System

Through the three phases of this project, the **Home Affairs online system** was developed to be a highly functional, user-friendly, and efficient tool for managing bookings and reducing congestion. By focusing on clear **specifications**, robust **data management**, and thorough **testing**, the system was able to provide real solutions to a pressing problem faced by many people. Advanced techniques like menu bars, ghost text, and help features ensured that users had a smooth and intuitive experience. With this system, the potential to reduce long lines and improve the operational efficiency of Home Affairs became a reality, showcasing how technology can be leveraged to solve real-world challenges.
