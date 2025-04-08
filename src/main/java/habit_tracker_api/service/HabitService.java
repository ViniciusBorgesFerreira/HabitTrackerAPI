package habit_tracker_api.service;

import habit_tracker_api.domain.model.Habit;


public interface HabitService {

    Habit findById(Long id);
    Habit create(Long idUser, Habit HabitToCreate);
    Habit completeHabit(Long idHabit);
}
