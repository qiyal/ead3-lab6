package spring.lab6.demo.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;

//    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
//    private Set<Notification> notifications;
//
//    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
//    private Set<Request> requests;

    // empty constructor
    public Member() {}

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public Set<Notification> getNotifications() {
//        return notifications;
//    }
//
//    public void setNotifications(Set<Notification> notifications) {
//        this.notifications = notifications;
//    }
//
//    public Set<Request> getRequests() {
//        return requests;
//    }
//
//    public void setRequests(Set<Request> requests) {
//        this.requests = requests;
//    }
}
