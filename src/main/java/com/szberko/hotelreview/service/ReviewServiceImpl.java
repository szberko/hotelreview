package com.szberko.hotelreview.service;

import com.szberko.hotelreview.repository.HotelRepository;
import com.szberko.hotelreview.repository.ReviewRepository;
import com.szberko.hotelreview.repository.model.Hotel;
import com.szberko.hotelreview.repository.model.Review;
import com.szberko.hotelreview.service.converter.ReviewRequestConverter;
import com.szberko.hotelreview.service.converter.ServiceDTOConverter;
import com.szberko.hotelreview.service.dto.ReviewRequest;
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
