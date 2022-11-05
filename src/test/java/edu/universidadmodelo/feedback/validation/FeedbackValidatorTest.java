package edu.universidadmodelo.feedback.validation;

import edu.universidadmodelo.feedback.model.Feedback;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FeedbackValidatorTest {

    FeedbackValidator feedbackValidator = new FeedbackValidator();

    @Test
    public void testValidateFeedbackHappyPath() {
        // input
        Feedback controlledInput = new Feedback();
        controlledInput.setComment("test comment");
        controlledInput.setType("0");
        controlledInput.setLikes(2);
        controlledInput.setSubject("Test subject");

        // expected output
        Exception result = null;
        try {
            feedbackValidator.validate(controlledInput);
        } catch(Exception e) {
            result = e;
        }

        // Verify result
        assertNull(result);
    }


}