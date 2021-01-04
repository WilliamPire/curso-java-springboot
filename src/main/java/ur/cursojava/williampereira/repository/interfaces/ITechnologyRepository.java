package ur.cursojava.williampereira.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import ur.cursojava.williampereira.domain.Rps;
import ur.cursojava.williampereira.domain.Technology;

public interface ITechnologyRepository extends JpaRepository<Technology, Long> {
    Technology findByName(String name);
}