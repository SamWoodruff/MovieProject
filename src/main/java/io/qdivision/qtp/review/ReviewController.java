package io.qdivision.qtp.review;

import io.qdivision.qtp.title.Title;
import io.qdivision.qtp.title.TitleEntity;
import io.qdivision.qtp.title.TitleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static io.qdivision.qtp.review.ReviewConversions.toReviewEntity;

@RestController
@RequestMapping("review")
public class ReviewController {
    ReviewRepository reviewRepository;
    TitleRepository titleRepository;
    public ReviewController(ReviewRepository reviewRepository, TitleRepository titleRepository){
        this.reviewRepository = reviewRepository;
        this.titleRepository = titleRepository;
    }

    @PostMapping
    @RequestMapping("{movieId}")
    public void createReview(@PathVariable("movieId") Long id, @RequestBody Review newReview){
        TitleEntity updatedTitle = titleRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        ReviewEntity review = toReviewEntity(newReview);
        reviewRepository.saveAndFlush(review);
        List<ReviewEntity> reviews = updatedTitle.getReviews();
        reviews.add(review);
        updatedTitle.setReviews(reviews);
        titleRepository.saveAndFlush(updatedTitle);

    }
}
