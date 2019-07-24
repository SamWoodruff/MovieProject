package io.qdivision.qtp.review;

public class ReviewConversions {
    public static Review toReview(ReviewEntity reviewEntity) {
        return Review.builder()
                .id(reviewEntity.getId())
                .userReview(reviewEntity.getUserReview())
                .rating(reviewEntity.getRating())
                .build();
    }

    public static ReviewEntity toReviewEntity(Review review){
        return ReviewEntity.builder()
                .id(review.getId())
                .userReview(review.getUserReview())
                .rating(review.getRating())
                .build();
    }
}
