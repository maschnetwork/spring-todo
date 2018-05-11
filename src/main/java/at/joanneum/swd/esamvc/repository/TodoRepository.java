package at.joanneum.swd.esamvc.repository;


import at.joanneum.swd.esamvc.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

    Todo findById(int id);
    List<Todo> findAllByOrderById();
}
