package io.qdivision.qtp.title;

import io.qdivision.qtp.name.Name;
import io.qdivision.qtp.name.NameEntity;
import io.qdivision.qtp.review.ReviewEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movie")

@Data
@Builder(toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class TitleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
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

    @OneToMany
    @JoinTable (
        name = "title_name",
        joinColumns = {@JoinColumn(name = "title_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "name_id", referencedColumnName = "id", unique = true)}
    )
    private List<NameEntity> names;

    @OneToMany
    @JoinTable (
            name = "title_review",
            joinColumns = {@JoinColumn(name = "title_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "review_id", referencedColumnName = "id", unique = true)}
    )
    private List<ReviewEntity> reviews;



}