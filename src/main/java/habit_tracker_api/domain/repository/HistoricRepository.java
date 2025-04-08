package habit_tracker_api.domain.repository;

import habit_tracker_api.domain.model.Historic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricRepository extends JpaRepository<Historic, Long> {
}
