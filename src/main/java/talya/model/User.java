package talya.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends GeneratedIdentifierEntity{

    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column(name = "full_name", length = 30)
    private String fullName;

    @OneToMany(mappedBy = "owner", cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private Set<Contact> contacts = new HashSet<Contact>();

    public User() {
    }

    public User(String login, String password, String fullName) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }
}
