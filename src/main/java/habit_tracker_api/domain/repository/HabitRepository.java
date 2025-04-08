package habit_tracker_api.domain.repository;

import habit_tracker_api.domain.model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitRepository extends JpaRepository<Habit, Long>{

}
