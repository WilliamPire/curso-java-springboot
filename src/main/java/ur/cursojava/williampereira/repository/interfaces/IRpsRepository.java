package ur.cursojava.williampereira.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import ur.cursojava.williampereira.domain.Rps;

public interface IRpsRepository extends JpaRepository<Rps, Long>  {
}