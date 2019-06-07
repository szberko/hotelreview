package com.symphony.hotelreview.service;

import com.symphony.hotelreview.repository.HotelRepository;
import com.symphony.hotelreview.repository.ReviewRepository;
import com.symphony.hotelreview.repository.model.Hotel;
import com.symphony.hotelreview.repository.model.Review;
import com.symphony.hotelreview.service.converter.ReviewRequestConverter;
import com.symphony.hotelreview.service.converter.ServiceDTOConverter;
import com.symphony.hotelreview.service.dto.ReviewRequest;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final HotelRepository hotelRepository;
    private final ServiceDTOConverter<ReviewRequest, Review> serviceReviewRequestConverter;

    public ReviewServiceImpl(final ReviewRepository reviewRepository,
                             final HotelRepository hotelRepository,
                             final ReviewRequestConverter serviceReviewRequestConverter) {
        this.reviewRepository = reviewRepository;
        this.hotelRepository = hotelRepository;
        this.serviceReviewRequestConverter = serviceReviewRequestConverter;
    }

    @Override
    public void createReview(final long hotelId, final ReviewRequest reviewRequest) {
        final Review review = serviceReviewRequestConverter.convert(reviewRequest);
        final Hotel hotel = hotelRepository.getOne(hotelId);
        review.setHotel(hotel);
        reviewRepository.save(review);
    }
}
