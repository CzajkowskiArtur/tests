package billennium.tests.repository.test;

import billennium.tests.entity.IdentyfierTests;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IdentyfierTestsRepository extends JpaRepository<IdentyfierTests, UUID> {

}
