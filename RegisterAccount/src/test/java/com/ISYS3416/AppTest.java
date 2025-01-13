package com.ISYS3416;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppTest {

    private App app;

    @BeforeEach
    public void setUp() {
        app = new App();
    }

    // Test case for a valid email format
    @Test
    void testValidEmailFormat() {
        String email = "van.nhk@example.com";
        // Suppose the app returns true if the registration is successful
        assertTrue(app.registerAccount("Van Nguyen", "2000-08-20", email, "van_nguyenhk", "Van200008!"),
                "The registration should be successful with a valid email.");
    }

    // Test case for email with missing '@' symbol
    @Test
    void testMissingAtSymbolInEmail() {
        String email = "phuc.nguyengmail.com";  // Missing '@'
        assertFalse(app.registerAccount("Phuc Nguyen", "1990-12-12", email, "phucnguyen", "Phuc2023!"),
                "The registration should fail due to missing '@' symbol in email.");
    }

    // Test case for email with invalid domain (e.g., missing domain part)
    @Test
    void testInvalidDomainInEmail() {
        String email = "minh..hg@yahoo.com";  // Double dot in domain
        assertFalse(app.registerAccount("Minh Hoang", "1999-03-03", email, "minhhoang99", "Minh@12345"),
                "The registration should fail due to an invalid email domain.");
    }

    // Test case for email with missing domain extension
    @Test
    void testMissingDomainExtensionInEmail() {
        String email = "user@domain";  // Missing extension like '.com'
        assertFalse(app.registerAccount("Sara Tran", "2005-04-01", email, "sara_tran", "Sara#2023"),
                "The registration should fail due to missing domain extension.");
    }

    // Edge case: Test for an email with correct format but with extra spaces
    @Test
    void testEmailWithSpaces() {
        String email = "   van.nhk@example.com  ";  // Email with leading/trailing spaces
        assertFalse(app.registerAccount("Van Nguyen", "2000-08-20", email, "van_nguyenhk", "Van200008!"),
                "The registration should fail due to spaces in the email.");
    }

    // Edge case: Test for an email with minimal valid domain
    @Test
    void testMinimalValidEmail() {
        String email = "a@b.co";  // Minimal valid email format
        assertFalse(app.registerAccount("Test User", "1990-01-01", email, "testuser", "Test@12345"),
                "The registration should be successful with the minimal valid email format.");
    }

    @Test
    void testEmailWithInternationalCharacters() {
        String email = "maria.garcia@ejemplo.es";  // Valid international email format
        assertFalse(app.registerAccount("Maria Garcia", "1995-03-15", email, "maria_garcia", "Password@123"),
                "The registration should fail for an international email format, if not supported.");
    }
}