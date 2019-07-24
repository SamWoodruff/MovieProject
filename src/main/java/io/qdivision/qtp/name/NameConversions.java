package io.qdivision.qtp.name;

public class NameConversions {
    public static Name toName(NameEntity nameEntity) {
        return Name.builder()
                .id(nameEntity.getId())
                .birthYear(nameEntity.getBirthYear())
                .deathYear(nameEntity.getDeathYear())
                .knownForTitles(nameEntity.getKnownForTitles())
                .nconst(nameEntity.getNconst())
                .primaryName(nameEntity.getPrimaryName())
                .primaryProfession(nameEntity.getPrimaryProfession())
                .build();
    }
}
