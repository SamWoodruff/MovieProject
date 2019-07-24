package io.qdivision.qtp.title;

import java.util.stream.Collectors;

import static io.qdivision.qtp.name.NameConversions.toName;
import static io.qdivision.qtp.review.ReviewConversions.toReview;

public class TitleConversions {
    public static Title toTitle(TitleEntity title) {
        return Title.builder()
                .id(title.getId())
                .tconst(title.getTconst())
                .titleType(title.getTitleType())
                .primaryTitle(title.getPrimaryTitle())
                .originalTitle(title.getOriginalTitle())
                .isAdult(title.getIsAdult())
                .startYear(title.getStartYear())
                .endYear(title.getEndYear())
                .runtimeMinutes(title.getRuntimeMinutes())
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
