package edu.universidadmodelo.feedback.controller;

import edu.universidadmodelo.feedback.model.Feedback;
import edu.universidadmodelo.feedback.service.FeedbackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/feedbacks")
    public List<Feedback> getAllFeedback() {
        return feedbackService.getAllFeedbackFromDb();
    }

    @PostMapping("/feedbacks")
    public Feedback createFeedback(@RequestBody Feedback input) {
        log.info("Creating new Feedback with data: {}", input.toString());
        return feedbackService.createFeedback(input);
    }

    @PutMapping("/feedbacks/{id}")
    public Feedback updateFeedback(@RequestBody Feedback input,@PathVariable String id){
        //return feedbackService.updateFeedback();
        return null;
    }
}
