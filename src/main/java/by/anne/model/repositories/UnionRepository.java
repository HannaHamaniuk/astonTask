package by.anne.model.repositories;

import by.anne.model.entities.Union;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UnionRepository extends JpaRepository <Union, Integer>{
}
