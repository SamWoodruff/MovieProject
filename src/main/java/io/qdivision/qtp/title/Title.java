package io.qdivision.qtp.title;

import io.qdivision.qtp.name.Name;
import io.qdivision.qtp.review.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Title {

    private Long id;
    private String tconst;
    private String titleType;
    private String primaryTitle;
    private String originalTitle;
    private Boolean isAdult;
    private Integer startYear;
    private Integer endYear;
    private Integer runtimeMinutes;
    private String genres;
    private Boolean favorite;
    private List<Name> names;

    private List<Review> reviews;

}
