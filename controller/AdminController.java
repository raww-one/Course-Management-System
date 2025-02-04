package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

import frames.AdminPanelFrame;
import model.Admin;
import model.User;


public class AdminController {
    public static final String FILE = ".\\Data\\admin_data.txt";
    public static boolean login(String username, String password) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE));
            String line;
            while ((line = reader.readLine()) != null) {
                String x = line.substring(0, 4);
                if (x.equals("Name")) {
                    String _username = line.split(" : ")[1]; // User Name
                    String _password = (line = reader.readLine()).split(" : ")[1]; // Password
                    if (!username.equals(_username) && !password.equals(_password)) 
                        continue;

                    return true;
                }
            }
        } catch (Exception ex) {
			ex.printStackTrace(System.out);
            
        }
        return false;
    }
}