package com.ISYS3416;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

    // Main registration function that validates the inputs and displays multiple errors
    public Account registerAccount(String fullName, String dob, String email, String username, String password) {
        // List to accumulate error messages
        List<String> errorMessages = new ArrayList<>();

        // Validate full name - it should not be null or empty
        String fullNameError = isValidFullName(fullName);
        if (fullNameError != null) {
            errorMessages.add(fullNameError);
        }

        // Validate date of birth (basic format check yyyy-mm-dd)
        String dobError = isValidDateOfBirth(dob);
        if (dobError != null) {
            errorMessages.add(dobError);
        }

        // Validate email format using regex
        String emailError = isValidEmail(email);
        if (emailError != null) {
            errorMessages.add(emailError);
        }

        // Validate username using the separate method
        String usernameError = isValidUsername(username);
        if (usernameError != null) {
            errorMessages.add(usernameError);
        }

        // Validate password - it must be at least 8 characters long, contain both letters (uppercase and lowercase), and at least one special character
        String passwordError = isValidPassword(password);
        if (passwordError != null) {
            errorMessages.add(passwordError);
        }

        // If there are any error messages, print them and return false
        if (!errorMessages.isEmpty()) {
            // Print all error messages
            for (String errorMessage : errorMessages) {
                System.out.println(errorMessage);
            }
            return null;
        }

        Account account = new Account(fullName, Date.valueOf(dob), email, username, password);

        // If all validations pass, registration is successful
        System.out.println("Registration successful!");
        return account;
    }

    // Helper method to validate full name (checks if it's not null or empty)
    private String isValidFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            return "Full name is required.";
        }
        return null; // No error
    }

    // Helper method to validate email format using regex
    private String isValidEmail(String email) {
        // Regular expression to allow emails with specific domain extensions .com, .com.vn, .edu.vn
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(.*\\.)?(com|com\\.vn|edu\\.vn)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            return "Invalid email format.";
        }
        return null; // No error
    }

    // Helper method to validate date of birth (basic check for yyyy-mm-dd format)
    private String isValidDateOfBirth(String dob) {
        // Regular expression to check if the date is in yyyy-mm-dd format
        String dateRegex = "^\\d{4}-\\d{2}-\\d{2}$";
        Pattern pattern = Pattern.compile(dateRegex);
        Matcher matcher = pattern.matcher(dob);
        if (!matcher.matches()) {
            return "Invalid date of birth format. Use yyyy-mm-dd.";
        }
        return null; // No error
    }

    // Helper method to validate username
    private String isValidUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            return "Username is required.";
        }
        if (username.contains(" ")) {
            return "Username cannot contain spaces.";
        }
        if (username.length() < 6 || username.length() > 20) {
            return "Error: Username must be between 6 and 20 characters long.";
        }
        return null; // No error
    }

    // Helper method to validate password (minimum 8 characters, contains uppercase, lowercase, and special character)
    private String isValidPassword(String password) {
        // Check if password is empty
        if (password == null || password.trim().isEmpty()) {
            return "Password is required.";
        }

        // Check if password length is at least 8 characters
        if (password.length() < 8) {
            return "Password must be at least 8 characters long.";
        }

        // Flags to check for required characters
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasSpecialChar = false;

        // Iterate through each character in the password to check conditions
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true; // Found an uppercase letter
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true; // Found a lowercase letter
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true; // Found a special character
            }
        }

        // Check if all conditions are met
        if (!(hasUpperCase && hasLowerCase && hasSpecialChar)) {
            return "Password must contain both uppercase and lowercase letters, and at least one special character.";
        }
        return null; // No error
    }

    // Main method to test the registration functionality
    public static void main(String[] args) {
        // Test data
        App app = new App();
        Object[][] users = {
                {"Van Nguyen", "2000-08-20", "van.nhk@example.com", "van_nguyenhk", "Van200008!"},
                {"Nghi Tran", "2005-08-03", "lucie.tran@yahoo.com", "lucietran03", "Rmit@030825"},
                {"Phuc Nguyen", "1990-12-12", "phuc.nguyengmail.com", "phucnguyen", "Phuc2023!"},
                {"Minh Hoang", "1999-03-03", "minh..hg@yahoo.com", "minhhoang99", "Minh@12345"},
                {"Hung Le", "01-01-2012", "hung.le@gmail.com", "hung_le", "Hung2023!"},
                {"Sara Tran", "2005-04-01", "sara.tran@rmit.edu.vn", "sara_tran", "Sara#2023"},
                {"Tran Dong Nghi", "2005-08-03", "nghi.tran@gmail.com", "nghi", "Nghi@1234"},
                {"Ngoc Nguyen", "1998-05-10", "ngoc.ng@gmail.com", "nguyenngoc1998", "password"},
                {"", "2004-06-15", "peter.le@example.com", "peterle", "Peter@123"},
                {"Khoi Nguyen", "2003-06-26", "khoi.nguyen@rmit.edu.vn", "", "", ""}
        };

        for (Object[] user : users) {
            String fullName = (String) user[0];
            String dob = (String) user[1];
            String email = (String) user[2];
            String username = (String) user[3];
            String password = (String) user[4];

            System.out.println("Test for " + fullName);
            // Get the list of error messages for each user registration
            Account account = app.registerAccount(fullName, dob, email, username, password);
            System.out.println();
        }
    }
}