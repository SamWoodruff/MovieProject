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
    private String title_type;
    private String primary_title;
    private String original_title;
    private Boolean is_adult;
    private Integer start_year;
    private Integer end_year;
    private Integer runtime_minutes;
    private String genres;
    private Boolean favorite;
    private List<Name> names;

    private List<Review> reviews;

}
