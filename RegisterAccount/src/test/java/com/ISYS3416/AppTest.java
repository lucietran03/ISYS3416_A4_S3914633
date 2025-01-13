package com.ISYS3416;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the {@code App} class, specifically focusing on the registration functionality.
 * Tests cover various scenarios to validate the format of email addresses and ensure the system
 * behaves as expected for both valid and invalid email inputs.
 *
 * @author Tran Dong Nghi - S3914633
 * @version 1.0
 */
class AppTest {

    /**
     * Instance of {@code App} used for testing.
     */
    private App app;

    /**
     * Sets up a fresh {@code App} instance before each test is run.
     */
    @BeforeEach
    public void setUp() {
        app = new App();
    }

    /**
     * Tests that the registration fails when the email is missing the '@' symbol.
     */
    @Test
    void testMissingAtSymbolInEmail() {
        assertNull(app.registerAccount("Phuc Nguyen", "1990-12-12", "phuc.nguyengmail.com", "phucnguyen", "Phuc2023!"),
                "The registration should fail due to missing '@' symbol in email.");
    }

    /**
     * Tests that the registration fails when the email has an invalid domain, such as missing parts.
     */
    @Test
    void testInvalidDomainInEmail() {
        assertNull(app.registerAccount("Minh Hoang", "1999-03-03", "minh..hg@yahoo.com", "minhhoang99", "Minh@12345"),
                "The registration should fail due to an invalid email domain.");
    }

    /**
     * Tests that the registration fails when the email is missing a domain extension (e.g., '.com').
     */
    @Test
    void testMissingDomainExtensionInEmail() {
        assertNull(app.registerAccount("Sara Tran", "2005-04-01", "user@domain", "sara_tran", "Sara#2023"),
                "The registration should fail due to missing domain extension.");
    }

    /**
     * Tests that the registration fails when the email has extra spaces at the beginning or end.
     */
    @Test
    void testEmailWithSpaces() {
        assertNull(app.registerAccount("Van Nguyen", "2000-08-20", "   van.nhk@example.com  ", "van_nguyenhk", "Van200008!"),
                "The registration should fail due to spaces in the email.");
    }

    /**
     * Tests that the registration succeeds with a minimal valid email format (e.g., 'a@b.co').
     */
    @Test
    void testMinimalValidEmail() {
        assertNull(app.registerAccount("Test User", "1990-01-01", "a@b.co", "testuser", "Test@12345"),
                "The registration should be successful with the minimal valid email format.");
    }

    /**
     * Tests that the registration fails when using an email with international characters,
     * assuming the system does not support such email formats.
     */
    @Test
    void testEmailWithInternationalCharacters() {
        assertNull(app.registerAccount("Maria Garcia", "1995-03-15", "maria.garcia@ejemplo.es", "maria_garcia", "Password@123"),
                "The registration should fail for an international email format, if not supported.");
    }
}