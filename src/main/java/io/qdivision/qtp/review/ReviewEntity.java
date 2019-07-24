package io.qdivision.qtp.review;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "review")

@Data
@Builder(toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String userReview;
    private int rating;

}
