package io.qdivision.qtp.title;

import java.util.stream.Collectors;

import static io.qdivision.qtp.name.NameConversions.toName;
import static io.qdivision.qtp.review.ReviewConversions.toReview;

public class TitleConversions {
    public static Title toTitle(TitleEntity title) {
        return Title.builder()
                .id(title.getId())
                .tconst(title.getTconst())
                .title_type(title.getTitle_type())
                .primary_title(title.getPrimary_title())
                .original_title(title.getOriginal_title())
                .is_adult(title.getIs_adult())
                .start_year(title.getStart_year())
                .end_year(title.getEnd_year())
                .runtime_minutes(title.getRuntime_minutes())
                .genres(title.getGenres())
                .favorite(title.getFavorite())
                .names(title
                        .getNames()
                        .stream()
                        .map(nameEntity -> toName(nameEntity))
                        .collect(Collectors.toList()))
                .reviews(title
                        .getReviews()
                        .stream()
                        .map(reviewEntity -> toReview(reviewEntity))
                        .collect(Collectors.toList()))
                .build();
    }
}
