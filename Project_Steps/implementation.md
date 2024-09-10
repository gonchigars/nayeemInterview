Below is a basic implementation for the required functionality in Spring Boot. It includes the necessary controller, service, repository, and model classes.

### 1. **Users Model**

```java
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String role;

    // Getters and Setters
}
```

### 2. **Availability Model**

```java
@Entity
@Table(name = "availability")
public class Availability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String dayOfWeek;

    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private LocalTime endTime;

    @Column(nullable = false)
    private int intervalDuration;

    // Getters and Setters
}
```

### 3. **Sessions Model**

```java
@Entity
@Table(name = "sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private User admin;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @Column(nullable = false)
    private String sessionType; // e.g., one-on-one or group

    // Getters and Setters
}
```

### 4. **Session_Attendees Model**

```java
@Entity
@Table(name = "session_attendees")
public class SessionAttendee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false)
    private Session session;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String status; // attended, cancelled, etc.

    // Getters and Setters
}
```

### 5. **User Repository**

```java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
```

### 6. **Availability Repository**

```java
@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
    List<Availability> findByUserId(Long userId);
}
```

### 7. **Session Repository**

```java
@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    List<Session> findByAdminId(Long adminId);
}
```

### 8. **SessionAttendee Repository**

```java
@Repository
public interface SessionAttendeeRepository extends JpaRepository<SessionAttendee, Long> {
    List<SessionAttendee> findBySessionId(Long sessionId);
}
```

### 9. **User Service**

```java
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
```

### 10. **Availability Service**

```java
@Service
public class AvailabilityService {
    @Autowired
    private AvailabilityRepository availabilityRepository;

    public Availability createAvailability(Availability availability) {
        return availabilityRepository.save(availability);
    }

    public List<Availability> getUserAvailability(Long userId) {
        return availabilityRepository.findByUserId(userId);
    }
}
```

### 11. **Session Service**

```java
@Service
public class SessionService {
    @Autowired
    private SessionRepository sessionRepository;

    public Session scheduleSession(Session session) {
        return sessionRepository.save(session);
    }

    public List<Session> getAdminSessions(Long adminId) {
        return sessionRepository.findByAdminId(adminId);
    }
}
```

### 12. **Session Attendee Service**

```java
@Service
public class SessionAttendeeService {
    @Autowired
    private SessionAttendeeRepository sessionAttendeeRepository;

    public void addAttendee(SessionAttendee sessionAttendee) {
        sessionAttendeeRepository.save(sessionAttendee);
    }
}
```

### 13. **User Controller**

```java
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        return userService.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
```

### 14. **Availability Controller**

```java
@RestController
@RequestMapping("/availability")
public class AvailabilityController {
    @Autowired
    private AvailabilityService availabilityService;

    @PostMapping
    public ResponseEntity<Availability> createAvailability(@RequestBody Availability availability) {
        return ResponseEntity.ok(availabilityService.createAvailability(availability));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Availability>> getUserAvailability(@PathVariable Long userId) {
        return ResponseEntity.ok(availabilityService.getUserAvailability(userId));
    }
}
```

### 15. **Session Controller**

```java
@RestController
@RequestMapping("/sessions")
public class SessionController {
    @Autowired
    private SessionService sessionService;

    @PostMapping
    public ResponseEntity<Session> scheduleSession(@RequestBody Session session) {
        return ResponseEntity.ok(sessionService.scheduleSession(session));
    }

    @GetMapping("/admin/{adminId}")
    public ResponseEntity<List<Session>> getAdminSessions(@PathVariable Long adminId) {
        return ResponseEntity.ok(sessionService.getAdminSessions(adminId));
    }
}
```

This setup provides the foundation for the scheduling system. You can extend these implementations to include features like validation, security, and more specific business logic.
