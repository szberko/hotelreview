package com.szberko.hotelreview.service.converter;

import com.szberko.hotelreview.repository.UserRepository;
import com.szberko.hotelreview.repository.model.Review;
import com.szberko.hotelreview.repository.model.User;
import com.szberko.hotelreview.service.dto.ReviewRequest;
import org.springframework.stereotype.Component;

@Component("serviceReviewRequestConverter")
public class ReviewRequestConverter implements ServiceDTOConverter<ReviewRequest, Review> {

    private final UserRepository userRepository;

    public ReviewRequestConverter(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Review convert(ReviewRequest input) {
        final User reviewer = userRepository.getOne(input.getUserId());

        return new Review.Builder()
                .withReview(input.getReview())
                .withRating(input.getRating())
                .withReviewer(reviewer)
                .build();
    }
}
