package io.qdivision.qtp.name;

public class NameConversions {
    public static Name toName(NameEntity nameEntity) {
        return Name.builder()
                .id(nameEntity.getId())
                .birth_year(nameEntity.getBirth_year())
                .death_year(nameEntity.getDeath_year())
                .known_for_titles(nameEntity.getKnown_for_titles())
                .nconst(nameEntity.getNconst())
                .primary_name(nameEntity.getPrimary_name())
                .primary_profession(nameEntity.getPrimary_profession())
                .build();
    }
}
