package io.qdivision.qtp.title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitleRepository extends JpaRepository<TitleEntity, Long> {
    List<TitleEntity> findByStartYearIsBetween(Integer start_year, Integer end_year);
    List<TitleEntity> findByPrimaryTitleContaining(String adsfadsfs);
}
