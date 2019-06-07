package com.symphony.hotelreview.controller.converter;

import com.symphony.hotelreview.controller.dto.ReviewRequest;
import org.springframework.stereotype.Component;

@Component("controllerReviewRequestController")
public class ReviewRequestConverter implements ControllerDTOConverter<ReviewRequest, com.symphony.hotelreview.service.dto.ReviewRequest> {

    @Override
    public com.symphony.hotelreview.service.dto.ReviewRequest convert(ReviewRequest input) {
        return new com.symphony.hotelreview.service.dto.ReviewRequest(input.getReview(), input.getRating(), input.getUserId());
    }
}
