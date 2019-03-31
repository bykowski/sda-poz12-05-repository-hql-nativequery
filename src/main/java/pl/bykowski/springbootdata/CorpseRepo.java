package pl.bykowski.springbootdata;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CorpseRepo extends CrudRepository<Corpse, Long> {

    List<Corpse> findByName(String name);

    List<Corpse> findByCorpseSize(CorpseSize corpseSize);

// nativeQuery
    @Query(value = "SELECT AVG(AGE_OF_DEATH), CORPSE_SIZE FROM Corpse GROUP BY CORPSE_SIZE", nativeQuery = true)
    List<Object> getAvgByAgeOfDeath();

// HQL
    @Query(value = "FROM Corpse", nativeQuery = false)
    List<Corpse> getAllElements();



}
