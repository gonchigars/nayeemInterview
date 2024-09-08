For your assignment using a SQL database, here’s a breakdown of the database tables you might need:

1. **Users Table**:

   - Stores information about users (admin or regular users).
   - Fields: `id`, `email`, `role` (e.g., 'admin' or 'user').

2. **Availability Table**:

   - Captures the availability slots for each user.
   - Fields: `id`, `user_id` (foreign key to Users), `day_of_week`, `start_time`, `end_time`, `interval_duration`.

3. **Sessions Table**:

   - Stores scheduled sessions and their details.
   - Fields: `id`, `admin_id` (foreign key to Users), `start_time`, `end_time`, `session_type` (one-on-one or group).

4. **Session_Attendees Table**:

   - Tracks the attendees of a session.
   - Fields: `session_id` (foreign key to Sessions), `user_id` (foreign key to Users), `status` (attended, cancelled, etc.).

5. **Notifications Table** (optional, for bonus points):

   - Tracks notifications for rescheduling or cancellation of sessions.
   - Fields: `id`, `user_id` (foreign key to Users), `session_id` (foreign key to Sessions), `notification_type` (email, SMS), `sent_at`.

6. **Roles Table** (optional, if you need more granular user roles):
   - Fields: `id`, `role_name`.

You will at least need 4 tables (Users, Availability, Sessions, and Session_Attendees) to meet the core functionality requirements.

========================
Basic Test cases

### **1. User Registration and Login**

**Test Case**: User can register using email and log in.

- **Scenario**: User tries to register using a valid email.
  - **Expected Outcome**: The user is successfully registered and can log in.
- **Scenario**: User tries to log in with valid credentials (email).
  - **Expected Outcome**: The user is successfully logged in.
- **Scenario**: User tries to log in with an unregistered email.
  - **Expected Outcome**: The user gets an error indicating the email is not registered.

---

### **2. User Availability Input**

**Test Case**: User can input their availability.

- **Scenario**: User inputs availability for Monday from 10 AM to 3 PM and 7 PM to 10 PM.

  - **Expected Outcome**: The availability is saved, and the user can view it in the availability dashboard.

- **Scenario**: User inputs overlapping availability (e.g., 1 PM to 3 PM and 2 PM to 4 PM on the same day).

  - **Expected Outcome**: System rejects overlapping slots or notifies the user of the overlap.

- **Scenario**: User updates their availability (e.g., changing Monday’s availability from 10 AM - 3 PM to 9 AM - 1 PM).

  - **Expected Outcome**: The availability is updated in the system without issues.

- **Scenario**: User deletes an availability slot.
  - **Expected Outcome**: The slot is deleted, and it no longer appears in the user’s dashboard.

---

### **3. Admin View of User Availability**

**Test Case**: Admin can view user availability.

- **Scenario**: Admin selects User A and views their availability.

  - **Expected Outcome**: Admin can see User A’s availability for each day of the week.

- **Scenario**: Admin selects multiple users and views their availability for specific days.
  - **Expected Outcome**: The availability of all selected users is displayed correctly.

---

### **4. Scheduling Sessions**

**Test Case**: Admin can schedule sessions based on user availability.

- **Scenario**: Admin selects User A’s available slot on Monday from 10 AM to 11 AM and schedules a session.

  - **Expected Outcome**: The session is successfully scheduled, and User A receives the session details.

- **Scenario**: Admin tries to schedule a session outside of User A’s availability.

  - **Expected Outcome**: The system prevents the session from being scheduled and displays a conflict message.

- **Scenario**: Admin schedules a group session with multiple participants.
  - **Expected Outcome**: The session is scheduled, and all participants are added to the session with no conflicts.

---

### **5. Session Conflict Management**

**Test Case**: System prevents scheduling conflicts.

- **Scenario**: Admin tries to schedule two sessions for the same user at overlapping times.
  - **Expected Outcome**: The system prevents the second session from being scheduled and provides a conflict warning.

---

### **6. Session Overview**

**Test Case**: Users and admins can view all scheduled sessions.

- **Scenario**: User logs in and views their upcoming sessions.

  - **Expected Outcome**: All future sessions are displayed with details (time, date, participants).

- **Scenario**: Admin views a summary of all scheduled sessions for a particular day.
  - **Expected Outcome**: A list of all sessions for that day is displayed, with details for each session.

---

### **7. Rescheduling and Cancellation of Sessions**

**Test Case**: Admin can reschedule or cancel a session.

- **Scenario**: Admin reschedules a session.

  - **Expected Outcome**: The new session time is saved, and all participants are notified of the change.

- **Scenario**: Admin cancels a session.
  - **Expected Outcome**: The session is removed from the schedule, and all participants are notified of the cancellation.

---

### **8. Notification Preferences (Bonus)**

**Test Case**: User can set notification preferences.

- **Scenario**: User sets notification preferences for email.
  - **Expected Outcome**: The system sends notifications via email for any scheduling or rescheduling events.

---

### **9. Time Block Selection**

**Test Case**: User can select time blocks in flexible intervals (e.g., 30-minute, 1-hour slots).

- **Scenario**: User selects 30-minute intervals for availability.
  - **Expected Outcome**: User can successfully input and manage availability using 30-minute intervals.
- **Scenario**: User selects hourly intervals for availability.
  - **Expected Outcome**: User can successfully input and manage availability using 1-hour intervals.

---

### **10. UI/UX Design**

**Test Case**: Application is responsive and intuitive.

- **Scenario**: User accesses the app from a mobile device.
  - **Expected Outcome**: The app adjusts to the screen size and remains fully functional.
- **Scenario**: User interacts with the time selection UI to set availability.
  - **Expected Outcome**: The time selection interface is easy to use and works without issues.

These test cases ensure the core functionality of the app, covering both user and admin perspectives, and validate the core features like availability input, scheduling, and session management.
