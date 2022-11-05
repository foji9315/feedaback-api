package edu.universidadmodelo.feedback.validation;

import edu.universidadmodelo.feedback.exceptions.BadRequestException;
import edu.universidadmodelo.feedback.model.Feedback;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FeedbackValidatorTest {

    FeedbackValidator feedbackValidator = new FeedbackValidator();

    @Test
    public void testValidateFeedbackHappyPath() {
        // input
        Exception expectedResult = null;
        Feedback controlledInput = getInstanceOfTestFeedback();

        // expected output
        Exception result = null;
        try {
            feedbackValidator.validate(controlledInput);
        } catch (Exception e) {
            result = e;
        }

        // Verify result
        assertEquals(null, result);
    }


    @Test
    public void testValidateFeedbackEmptyComment() {
        // input
        Feedback controlledInput = getInstanceOfTestFeedbackWithoutComment();

        // expected output
        Exception result = null;
        try {
            feedbackValidator.validate(controlledInput);
        } catch (Exception e) {
            result = e;
        }

        // Verify result
        assertTrue(result instanceof BadRequestException);
        assertEquals("Comment must be not empty", result.getMessage());
    }

    @Test
    public void testValidateFeedbackEmptySubject() {
        // input
        Feedback controlledInput = getInstanceOfTestFeedbackWithoutSubject();

        // expected output
        Exception result = null;
        try {
            feedbackValidator.validate(controlledInput);
        } catch (Exception e) {
            result = e;
        }

        // Verify result
        assertTrue(result instanceof BadRequestException);
        assertEquals("Subject should not be empty", result.getMessage());
    }

    @Test
    public void testValidateFeedbackInvalidLikes() {
        // input
        Feedback controlledInput = getInstanceOfTestFeedbackWithoutInvalidLikes();

        // expected output
        Exception result = null;
        try {
            feedbackValidator.validate(controlledInput);
        } catch (Exception e) {
            result = e;
        }

        // Verify result
        assertTrue(result instanceof BadRequestException);
        assertEquals("Likes must be greater than 0", result.getMessage());
    }

    @Test
    public void testValidateFeedbackInvalidType() {
        // input
        Feedback controlledInput = getInstanceOfTestFeedbackWithInvalidType();

        // expected output
        Exception result = null;
        try {
            feedbackValidator.validate(controlledInput);
        } catch (Exception e) {
            result = e;
        }

        // Verify result
        assertTrue(result instanceof BadRequestException);
        assertEquals("Type should be a number between 0 and 2", result.getMessage());
    }

    public static Feedback getInstanceOfTestFeedback(
            boolean hasComment,
            boolean hasSubject,
            boolean hasValidLikes,
            boolean hasValidType) {

        return Feedback.builder()
                .comment(hasComment ? "TestComment" : "")
                .likes(hasValidLikes ? 1 : -1)
                .subject(hasSubject ? "Test Subject" : "")
                .type(hasValidType ? "0" : "10")
                .build();
    }

    public static Feedback getInstanceOfTestFeedback() {
        return getInstanceOfTestFeedback(true, true, true, true);
    }

    public static Feedback getInstanceOfTestFeedbackWithoutComment() {
        return getInstanceOfTestFeedback(false, true, true, true);
    }

    public static Feedback getInstanceOfTestFeedbackWithoutSubject() {
        return getInstanceOfTestFeedback(true, false, true, true);
    }

    public static Feedback getInstanceOfTestFeedbackWithInvalidType() {
        return getInstanceOfTestFeedback(true, true, true, false);
    }

    public static Feedback getInstanceOfTestFeedbackWithoutInvalidLikes() {
        return getInstanceOfTestFeedback(true, true, false, true);
    }
}