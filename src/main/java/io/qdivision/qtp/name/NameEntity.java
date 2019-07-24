package io.qdivision.qtp.name;

import lombok.*;

import javax.persistence.*;

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
    private String nconst;
    private String primary_name;
    private String birth_year;
    private String death_year;
    private String primary_profession;
    private String known_for_titles;

}
