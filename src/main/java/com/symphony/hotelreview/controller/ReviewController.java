package com.symphony.hotelreview.controller;

import com.symphony.hotelreview.controller.converter.ReviewRequestConverter;
import com.symphony.hotelreview.controller.dto.ReviewRequest;
import com.symphony.hotelreview.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Nonnull;
import javax.validation.Valid;

@RestController
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewRequestConverter controllerReviewRequestController;

    public ReviewController(final ReviewService reviewService,
                            final ReviewRequestConverter controllerReviewRequestController) {
        this.reviewService = reviewService;
        this.controllerReviewRequestController = controllerReviewRequestController;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/hotels/{hotelId}/reviews", produces = "application/json")
    public void createReview(@Valid @Nonnull @PathVariable final Long hotelId, @Valid @RequestBody final ReviewRequest payload){
        final com.symphony.hotelreview.service.dto.ReviewRequest reviewRequest = controllerReviewRequestController.convert(payload);
        reviewService.createReview(hotelId, reviewRequest);
    }
}
