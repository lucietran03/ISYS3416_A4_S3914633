package com.ISYS3416;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

    // Main registration function that validates the inputs
    public boolean registerAccount(String fullName, String dob, String email, String username, String password) {
        // Validate full name - it should not be null or empty
        if (fullName == null || fullName.trim().isEmpty()) {
            System.out.println("Error: Full name is required.");
            return false;
        }

        // Validate date of birth (basic format check yyyy-mm-dd)
        if (dob == null || !isValidDateOfBirth(dob)) {
            System.out.println("Error: Invalid date of birth format. Use yyyy-mm-dd.");
            return false;
        }

        // Validate email format using regex
        if (email == null || !isValidEmail(email)) {
            System.out.println("Error: Invalid email format.");
            return false;
        }

        // Validate username - it should not be null, empty, contain spaces, and should be between 6 and 20 characters
        if (username == null || username.trim().isEmpty() || username.contains(" ") || username.length() < 6 || username.length() > 20) {
            System.out.println("Error: Username is required, cannot contain spaces, and must be between 6 and 20 characters long.");
            return false;
        }

        // Validate password - it must be at least 8 characters long and contain both letters and numbers
        if (password == null || !isValidPassword(password)) {
            System.out.println("Error: Password must be at least 8 characters long and contain both letters and numbers.");
            return false;
        }

        // If all validations pass, registration is successful
        System.out.println("Registration successful!");
        return true;
    }

    // Helper method to validate email format using regex
    private boolean isValidEmail(String email) {
        // Regular expression to allow emails with specific domain extensions .com, .com.vn, .edu.vn
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(.*\\.)?(com|com\\.vn|edu\\.vn)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches(); // Returns true if email matches the regex
    }

    // Helper method to validate date of birth (basic check for yyyy-mm-dd format)
    private boolean isValidDateOfBirth(String dob) {
        // Regular expression to check if the date is in yyyy-mm-dd format
        String dateRegex = "^\\d{4}-\\d{2}-\\d{2}$";
        Pattern pattern = Pattern.compile(dateRegex);
        Matcher matcher = pattern.matcher(dob);
        return matcher.matches(); // Returns true if the date matches the format
    }

    // Helper method to validate password (minimum 8 characters, contains numbers and letters)
    private boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false; // Password should be at least 8 characters long
        }

        // Check if the password contains at least one letter and one number
        boolean hasLetter = false;
        boolean hasDigit = false;

        // Iterate through each character in the password
        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) {
                hasLetter = true; // Found a letter
            } else if (Character.isDigit(c)) {
                hasDigit = true; // Found a digit
            }
        }

        // Return true if both letter and digit are present
        return hasLetter && hasDigit;
    }

    // Main method to test the registration functionality
    public static void main(String[] args) {
        // Test data
        App app = new App();
        boolean result = app.registerAccount("John Doe", "1990-01-01", "john.doe@example.com", "johnDoe123", "Password123");
    }
}