package io.qdivision.qtp.name;
import io.qdivision.qtp.title.TitleEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "name")

@Data
@Builder(toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class NameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String tconst;
    private String title_type;
    private String primary_title;
    private String original_title;
    private Boolean is_adult;
    private String start_year;
    private String end_year;
    private Integer runtime_minutes;
    private String genres;

    @OneToMany
    @JoinTable (
            name = "name_id",
            joinColumns = {@JoinColumn(name = "name_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "title_id", referencedColumnName = "id", unique = true)}
    )
    private List<TitleEntity> titles;

}
