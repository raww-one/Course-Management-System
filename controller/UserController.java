package controller;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import model.User;
import model.Admin;


public class UserController {
    public static final String FILE = ".\\Data\\user_data.txt";
    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE));
            String line;
            while ((line = reader.readLine()) != null) {
                String x = line.substring(0, 4);
                if (x.equals("User")) {
                    String username = line.split(" : ")[1]; // User Name
                    String password = (line = reader.readLine()).split(" : ")[1]; // Password
                    

                    String email = (line = reader.readLine()).split(" : ")[1]; // Email
                    String department = (line = reader.readLine()).split(" : ")[1]; // Department
                    String student_id = (line = reader.readLine()).split(" : ")[1]; // Student id
                    String date = (line = reader.readLine()).split(" : ")[1]; // Date and Time
                    User u = new User(username, password, email, department, student_id, date);
                    users.add(u);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return users;
    }
    public static User login(String username, String password) {
        List<User> users = getUsers();
        for (int i = 0; i < users.size(); i++) {
          User u = users.get(i);
          if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
            return u;
          }      
        }
        return null;
    }
    public static boolean register(User user) {
        try {
            File file = new File(FILE);

            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            PrintWriter pw = new PrintWriter(bw);

            pw.println("User Name : " + user.getUsername());
            pw.println("Password : " + user.getPassword());
            pw.println("Email : " + user.getEmail());
            pw.println("Department : " + user.getDepartment());
            pw.println("Student ID : " + user.getStudentId());
            pw.println("Time & Date : " + user.getDate());
            pw.println("===============================================");
            pw.close();
            return true;
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return false;
    }

    public static void delete(String username) {
        List<User> users = getUsers();

        // delete the old file
        try {
            PrintWriter writer = new PrintWriter(new File(FILE));
            writer.print("");
            writer.close();
        } catch (Exception ex) {
            System.out.print(ex);
        }



        for (int i = 0; i < users.size(); i++) {
          User u = users.get(i);
          // register all users again except deleted user
          if(!u.getUsername().equals(username)) {
            register(u);
          }
        }
    }
}