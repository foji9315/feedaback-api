package edu.universidadmodelo.feedback.service;

import edu.universidadmodelo.feedback.exceptions.NotFoundException;
import edu.universidadmodelo.feedback.model.Feedback;
import edu.universidadmodelo.feedback.model.FeedbackUpdatableData;
import edu.universidadmodelo.feedback.repository.FeedbackRepository;
import edu.universidadmodelo.feedback.validation.FeedbackValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private FeedbackValidator feedbackValidator;

    public List<Feedback> getAllFeedbackFromDb() {
        return feedbackRepository.findAll();
    }

    public Feedback getFeedbackById(String id) {
        return feedbackRepository.findById(id)
                .orElseThrow(
                        () -> new NotFoundException("Feedback with id not found : " + id)
                );
    }

    public Feedback createFeedback(Feedback feedbackToCreate) {
        feedbackValidator.validate(feedbackToCreate);
        feedbackToCreate.setId(UUID.randomUUID().toString());
        feedbackToCreate.setUpdatedAt(LocalDateTime.now());
        return feedbackRepository.save(feedbackToCreate);
    }

    public Feedback updateFeedback(String id,
                                   FeedbackUpdatableData input) {
        feedbackValidator.validate(input);
        Feedback feedbackFound =
                feedbackRepository.findById(id).orElse(null);
        if (feedbackFound != null) {
            feedbackFound.setSubject(input.getSubject());
            feedbackFound.setComment(input.getComment());
            feedbackFound.setLikes(input.getLikes());
            feedbackFound.setType(input.getType());
            feedbackFound.setUpdatedAt(LocalDateTime.now());

            return feedbackRepository.save(feedbackFound);
        }
        throw new NotFoundException("Feedback with id not found : " + id);
    }

    public String deleteFeedback(String id) {
        if (feedbackRepository.existsById(id)) {
            feedbackRepository.deleteById(id);
            return id;
        }
        throw new NotFoundException("Feedback with id not found : " + id);
    }
}
