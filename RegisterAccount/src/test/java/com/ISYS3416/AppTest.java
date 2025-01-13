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

    // Test case for email with missing '@' symbol
    @Test
    void testMissingAtSymbolInEmail() {
        assertNull(app.registerAccount("Phuc Nguyen", "1990-12-12", "phuc.nguyengmail.com", "phucnguyen", "Phuc2023!"),
                "The registration should fail due to missing '@' symbol in email.");
    }

    // Test case for email with invalid domain (e.g., missing domain part)
    @Test
    void testInvalidDomainInEmail() {
        assertNull(app.registerAccount("Minh Hoang", "1999-03-03", "minh..hg@yahoo.com", "minhhoang99", "Minh@12345"),
                "The registration should fail due to an invalid email domain.");
    }

    // Test case for email with missing domain extension
    @Test
    void testMissingDomainExtensionInEmail() {
        assertNull(app.registerAccount("Sara Tran", "2005-04-01", "user@domain", "sara_tran", "Sara#2023"),
                "The registration should fail due to missing domain extension.");
    }

    // Edge case: Test for an email with correct format but with extra spaces
    @Test
    void testEmailWithSpaces() {
        assertNull(app.registerAccount("Van Nguyen", "2000-08-20", "   van.nhk@example.com  ", "van_nguyenhk", "Van200008!"),
                "The registration should fail due to spaces in the email.");
    }

    // Edge case: Test for an email with minimal valid domain
    @Test
    void testMinimalValidEmail() {
        assertNull(app.registerAccount("Test User", "1990-01-01", "a@b.co", "testuser", "Test@12345"),
                "The registration should be successful with the minimal valid email format.");
    }

    @Test
    void testEmailWithInternationalCharacters() {
        assertNull(app.registerAccount("Maria Garcia", "1995-03-15", "maria.garcia@ejemplo.es", "maria_garcia", "Password@123"),
                "The registration should fail for an international email format, if not supported.");
    }
}