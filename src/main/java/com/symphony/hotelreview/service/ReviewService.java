package com.symphony.hotelreview.service;

import com.symphony.hotelreview.service.dto.ReviewRequest;

public interface ReviewService {

    void createReview(final long hotelId, final ReviewRequest reviewRequest);
}
