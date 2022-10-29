package edu.universidadmodelo.feedback.controller;

import edu.universidadmodelo.feedback.model.Feedback;
import edu.universidadmodelo.feedback.model.FeedbackUpdatableData;
import edu.universidadmodelo.feedback.service.FeedbackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/feedbacks")
@Slf4j
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Feedback> getAllFeedback() {
        return feedbackService.getAllFeedbackFromDb();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Feedback getFeedbackById(@PathVariable String id) {
        log.info("Getting Feedback with id: {}", id);
        return feedbackService.getFeedbackById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Feedback createFeedback(@RequestBody Feedback input) {
        log.info("Creating new Feedback with data: {}", input);
        return feedbackService.createFeedback(input);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Feedback updateFeedback(@RequestBody FeedbackUpdatableData input,
                                   @PathVariable String id) {
        log.info("Updating Feedback with id: {}", id);
        return feedbackService.updateFeedback(id, input);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteFeedbackById(@PathVariable String id) {
        log.info("Deleting Feedback with id: {}", id);
        return feedbackService.deleteFeedback(id);
    }
}
