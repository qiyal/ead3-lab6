package spring.lab6.demo.entity;

import javax.persistence.*;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "admin_roles",
//            joinColumns = {
//                    @JoinColumn(name = "admin_id")
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "role_id")
//            }
//    )
//    private List<Role> roles;

    // empty constructor
    public Admin() {}

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
