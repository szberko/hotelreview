package com.symphony.hotelreview.repository.model;

public enum Opinion {

    LIKE("like"),
    DISSLIKE("dislike");

    private String opinion;

    Opinion(String opinion) {
        this.opinion = opinion;
    }

    public String getOpinion() {
        return opinion;
    }
}
