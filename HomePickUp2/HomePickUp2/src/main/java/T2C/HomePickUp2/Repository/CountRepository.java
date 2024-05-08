package T2C.HomePickUp2.Repository;

import T2C.HomePickUp2.Entity.Count;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface CountRepository extends JpaRepository<Count, Long> {
}