package Test.test.project.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface plantRepository extends JpaRepository<plantEntity, Long> {
}
