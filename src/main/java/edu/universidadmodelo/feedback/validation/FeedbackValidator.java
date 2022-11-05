package edu.universidadmodelo.feedback.validation;

import edu.universidadmodelo.feedback.exceptions.BadRequestException;
import edu.universidadmodelo.feedback.model.Feedback;
import edu.universidadmodelo.feedback.model.FeedbackUpdatableData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class FeedbackValidator {

    public void validate(Feedback objectToValidate) {
        validateComment(objectToValidate.getComment());
        validateLikes(objectToValidate.getLikes());
        validateSubject(objectToValidate.getSubject());
        validateType(Integer.parseInt(objectToValidate.getType()));
    }

    public void validate(FeedbackUpdatableData objectToValidate) {
        validateComment(objectToValidate.getComment());
        validateLikes(objectToValidate.getLikes());
        validateSubject(objectToValidate.getSubject());
        validateType(Integer.parseInt(objectToValidate.getType()));
    }

    private static void validateComment(String comment) {
        if (comment.trim().isEmpty()) {
            log.error("Error validating feedback: Empty comment");
            throw new BadRequestException("Comment must be not empty");
        }
    }

    private static void validateType(int type) {
        if (type < 0 || type > 3) {
            throw new BadRequestException("Type should be a number between 0 and 2");
        }
    }

    private static void validateLikes(int likes) {
        if (likes < 0) {
            throw new BadRequestException("Likes must be greater than 0");
        }
    }

    private static void validateSubject(String subject) {
        if (subject.trim().isEmpty()) {
            throw new BadRequestException("Subject should not be empty");
        }
    }
}
