package com.example.springsecurityjwtdemo.models;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
//  user is a keyword in SQL, hence renaming the table
@Table(name = "app_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String username;

    private String firstName;
    private String lastName;
    private String employeeId;
    private String designation;
    private String department;
    private String email;
    private String phoneNumber;
    private ZonedDateTime registeredOn;
    private ZonedDateTime lastLogin;
    private boolean isAdminBlock;
    private boolean isLoginBlock;
    private ZonedDateTime passwordResetOn;
    private ZonedDateTime loginBlockOn;
    private ZonedDateTime adminBlockOn;

    private String remarks;
    private String password;

    private String resetKey;
    private int failedAttempts;
    private ZonedDateTime lastFailedLogin;
    private ZonedDateTime passwordChangedOn;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "app_user_roles",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") })
    private Set<Role> roles = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ZonedDateTime getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(ZonedDateTime registeredOn) {
        this.registeredOn = registeredOn;
    }

    public ZonedDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(ZonedDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean isAdminBlock() {
        return isAdminBlock;
    }

    public void setAdminBlock(boolean adminBlock) {
        isAdminBlock = adminBlock;
    }

    public boolean isLoginBlock() {
        return isLoginBlock;
    }

    public void setLoginBlock(boolean loginBlock) {
        isLoginBlock = loginBlock;
    }

    public ZonedDateTime getPasswordResetOn() {
        return passwordResetOn;
    }

    public void setPasswordResetOn(ZonedDateTime passwordResetOn) {
        this.passwordResetOn = passwordResetOn;
    }

    public ZonedDateTime getLoginBlockOn() {
        return loginBlockOn;
    }

    public void setLoginBlockOn(ZonedDateTime loginBlockOn) {
        this.loginBlockOn = loginBlockOn;
    }

    public ZonedDateTime getAdminBlockOn() {
        return adminBlockOn;
    }

    public void setAdminBlockOn(ZonedDateTime adminBlockOn) {
        this.adminBlockOn = adminBlockOn;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getResetKey() {
        return resetKey;
    }

    public void setResetKey(String resetKey) {
        this.resetKey = resetKey;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(int failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    public ZonedDateTime getLastFailedLogin() {
        return lastFailedLogin;
    }

    public void setLastFailedLogin(ZonedDateTime lastFailedLogin) {
        this.lastFailedLogin = lastFailedLogin;
    }

    public ZonedDateTime getPasswordChangedOn() {
        return passwordChangedOn;
    }

    public void setPasswordChangedOn(ZonedDateTime passwordChangedOn) {
        this.passwordChangedOn = passwordChangedOn;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
