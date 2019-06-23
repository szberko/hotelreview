package com.szberko.hotelreview.service;

import com.szberko.hotelreview.service.dto.ReviewRequest;

public interface ReviewService {

    void createReview(final long hotelId, final ReviewRequest reviewRequest);
}
