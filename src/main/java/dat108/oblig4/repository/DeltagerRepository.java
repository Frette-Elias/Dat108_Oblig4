package dat108.oblig4.repository;

import dat108.oblig4.entity.Deltager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeltagerRepository extends JpaRepository<Deltager, String> {
}
