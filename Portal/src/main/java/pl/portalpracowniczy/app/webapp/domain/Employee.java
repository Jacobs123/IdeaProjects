package pl.portalpracowniczy.app.webapp.domain;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private int id;
    @Column(name = "employee_name") //Nie moze zawierac cyfr
    private String name;
    @Column(name = "employee_surname") // Nie moze zawierać cyft
    private String surname;

    /* authorization data */
    private String login;
    private String password;
    private int active;


    /*Relathionship*/
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "employee_roles", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<EmployeeRole> roles;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Set<EmployeeRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<EmployeeRole> roles) {
        this.roles = roles;
    }
}
