package io.qdivision.qtp.name;

import io.qdivision.qtp.title.Title;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Name {
    private Long id;
    private String nconst;
    private String primary_name;
    private String birth_year;
    private String death_year;
    private String primary_profession;
    private String known_for_titles;
}
