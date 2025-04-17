package habit_tracker_api.service;

import habit_tracker_api.domain.model.Habit;


public interface HabitService {

    Habit findById(Long idUser, Long idHabit);
    Habit create(Long idUser, Habit HabitToCreate);
    Habit completeHabit(Long idUser, Long idHabit);
    void delete(Long idUser, Long idHabit);
}
