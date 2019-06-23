package com.szberko.hotelreview.controller.converter;

import com.szberko.hotelreview.controller.dto.ReviewRequest;
import org.springframework.stereotype.Component;

@Component("controllerReviewRequestController")
public class ReviewRequestConverter implements ControllerDTOConverter<ReviewRequest, com.szberko.hotelreview.service.dto.ReviewRequest> {

    @Override
    public com.szberko.hotelreview.service.dto.ReviewRequest convert(ReviewRequest input) {
        return new com.szberko.hotelreview.service.dto.ReviewRequest(input.getReview(), input.getRating(), input.getUserId());
    }
}
