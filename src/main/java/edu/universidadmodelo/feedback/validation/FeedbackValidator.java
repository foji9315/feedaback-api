package edu.universidadmodelo.feedback.validation;

import edu.universidadmodelo.feedback.exceptions.BadRequestException;
import edu.universidadmodelo.feedback.model.Feedback;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class FeedbackValidator {

    public void validate(Feedback objectToValidate){

        if(objectToValidate.getComment().trim().isEmpty()) {
            log.error("Error validating feedback: Empty comment");
            throw new BadRequestException("Comment must be not empty");
        }
    }
}
