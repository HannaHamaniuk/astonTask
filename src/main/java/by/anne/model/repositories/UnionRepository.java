package by.anne.model.repositories;

import by.anne.model.entities.Union;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface UnionRepository extends JpaRepository <Union, Integer>{

    @Query(value="SELECT u from Union u LEFT JOIN FETCH u.countries c where c.id=?1")
    public List<Union> getAllUnions(int id);

}
