package by.anne.model.repositories;

import by.anne.model.entities.Country;
import by.anne.model.entities.Union;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CountryRepository extends JpaRepository<Country, Integer> {


    @Query(value = "select c from Country c Left JOIN FETCH c.unions")
   public List<Country> findFullList();


}
