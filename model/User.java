package model;

public class User {
    private String username;
    private String password;
    private String email;
    private String department;
    private String student_id;
    private String date;

    public User() {}

    public User(String username, String password, String email, String department, String student_id, String date) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.department = department;
        this.student_id = student_id;
        this.date = date;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStudentId() {
        return student_id;
    }

    public void setStudentId(String student_id) {
        this.student_id = student_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
