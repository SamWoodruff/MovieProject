package io.qdivision.qtp.review;

public class ReviewConversions {
    public static Review toReview(ReviewEntity reviewEntity) {
        return Review.builder()
                .id(reviewEntity.getId())
                .user_review(reviewEntity.getUser_review())
                .rating(reviewEntity.getRating())
                .build();
    }

    public static ReviewEntity toReviewEntity(Review review){
        return ReviewEntity.builder()
                .id(review.getId())
                .user_review(review.getUser_review())
                .rating(review.getRating())
                .build();
    }
}
