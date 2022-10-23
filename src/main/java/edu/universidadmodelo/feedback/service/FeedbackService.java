package edu.universidadmodelo.feedback.service;

import edu.universidadmodelo.feedback.model.Feedback;
import edu.universidadmodelo.feedback.repository.FeedbackRepository;
import edu.universidadmodelo.feedback.validation.FeedbackValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private FeedbackValidator feedbackValidator;

    public List<Feedback> getAllFeedbackFromDb() {
        return feedbackRepository.findAll();
    }

    public Feedback createFeedback(Feedback feedbackToCreate) {
        feedbackValidator.validate(feedbackToCreate);
        return feedbackRepository.save(feedbackToCreate);
    }
}
