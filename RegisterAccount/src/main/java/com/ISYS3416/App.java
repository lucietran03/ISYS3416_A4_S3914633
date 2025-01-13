package com.ISYS3416;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The {@code App} class handles user account registration and input validation.
 * It ensures that user inputs such as full name, date of birth, email, username,
 * and password meet predefined constraints. Valid inputs result in the creation
 * of an {@code Account} object.
 *
 * This class includes methods for validation and provides error messages for invalid inputs.
 *
 * @author Tran Dong Nghi - S3914633
 * @version 1.0
 */
public class App {

    /**
     * Registers a new account by validating the provided inputs.
     * If any input fails validation, corresponding error messages are displayed.
     *
     * @param fullName The full name of the user.
     * @param dob      The date of birth of the user in yyyy-MM-dd format.
     * @param email    The email address of the user.
     * @param username The desired username for the account.
     * @param password The desired password for the account.
     * @return An Account object if registration is successful, null otherwise.
     */
    public Account registerAccount(String fullName, String dob, String email, String username, String password) {
        // List to accumulate error messages
        List<String> errorMessages = new ArrayList<>();

        // Validate full name
        String fullNameError = isValidFullName(fullName);
        if (fullNameError != null) {
            errorMessages.add(fullNameError);
        }

        // Validate date of birth
        String dobError = isValidDateOfBirth(dob);
        if (dobError != null) {
            errorMessages.add(dobError);
        }

        // Validate email format
        String emailError = isValidEmail(email);
        if (emailError != null) {
            errorMessages.add(emailError);
        }

        // Validate username
        String usernameError = isValidUsername(username);
        if (usernameError != null) {
            errorMessages.add(usernameError);
        }

        // Validate password
        String passwordError = isValidPassword(password);
        if (passwordError != null) {
            errorMessages.add(passwordError);
        }

        // Display all error messages if any validation fails
        if (!errorMessages.isEmpty()) {
            for (String errorMessage : errorMessages) {
                System.out.println(errorMessage);
            }
            return null; // Registration failed
        }

        // Create and return a new Account object if all validations pass
        Account account = new Account(fullName, Date.valueOf(dob), email, username, password);
        System.out.println("Registration successful!");
        return account;
    }

    /**
     * Validates the full name to ensure it is not null or empty.
     *
     * @param fullName The full name to validate.
     * @return An error message if validation fails, null otherwise.
     */
    private String isValidFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            return "Full name is required.";
        }
        return null;
    }

    /**
     * Validates the email format using a regular expression.
     *
     * @param email The email to validate.
     * @return An error message if validation fails, null otherwise.
     */
    private String isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(.*\\.)?(com|com\\.vn|edu\\.vn)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            return "Invalid email format.";
        }
        return null;
    }

    /**
     * Validates the date of birth to ensure it is in yyyy-MM-dd format.
     *
     * @param dob The date of birth to validate.
     * @return An error message if validation fails, null otherwise.
     */
    private String isValidDateOfBirth(String dob) {
        String dateRegex = "^\\d{4}-\\d{2}-\\d{2}$";
        Pattern pattern = Pattern.compile(dateRegex);
        Matcher matcher = pattern.matcher(dob);
        if (!matcher.matches()) {
            return "Invalid date of birth format. Use yyyy-MM-dd.";
        }
        return null;
    }

    /**
     * Validates the username to ensure it meets length and format requirements.
     *
     * @param username The username to validate.
     * @return An error message if validation fails, null otherwise.
     */
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
        return null;
    }

    /**
     * Validates the password to ensure it meets complexity requirements.
     *
     * @param password The password to validate.
     * @return An error message if validation fails, null otherwise.
     */
    private String isValidPassword(String password) {
        if (password == null || password.trim().isEmpty()) {
            return "Password is required.";
        }
        if (password.length() < 8) {
            return "Password must be at least 8 characters long.";
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }

        if (!(hasUpperCase && hasLowerCase && hasSpecialChar)) {
            return "Password must contain both uppercase and lowercase letters, and at least one special character.";
        }
        return null;
    }

    /**
     * Main method to test the registration functionality with sample user data.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        App app = new App();

        // Test data array containing sample user inputs
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

        // Process each test user
        for (Object[] user : users) {
            String fullName = (String) user[0];
            String dob = (String) user[1];
            String email = (String) user[2];
            String username = (String) user[3];
            String password = (String) user[4];

            System.out.println("Test for " + fullName);
            Account account = app.registerAccount(fullName, dob, email, username, password);
            System.out.println();
        }
    }
}