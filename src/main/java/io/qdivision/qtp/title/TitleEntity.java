package io.qdivision.qtp.title;

import io.qdivision.qtp.name.NameEntity;
import lombok.*;

import javax.persistence.*;

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
    private String title_type;
    private String primary_title;
    private String original_title;
    private Boolean is_adult;
    private Integer start_year;
    private Integer end_year;
    private Integer runtime_minutes;
    private String genres;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "name_id")
//    private NameEntity name;


}