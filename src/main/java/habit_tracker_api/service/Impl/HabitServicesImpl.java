package habit_tracker_api.service.Impl;


import habit_tracker_api.domain.model.Habit;
import habit_tracker_api.domain.model.User;
import habit_tracker_api.domain.repository.HabitRepository;
import habit_tracker_api.domain.repository.UserRepository;
import habit_tracker_api.service.HabitService;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class HabitServicesImpl implements HabitService {

    private final HabitRepository habitRepository;
    private final UserRepository userRepository;

    public HabitServicesImpl(HabitRepository habitRepository, UserRepository userRepository) {
        this.habitRepository = habitRepository;
        this.userRepository= userRepository;
    }

    @Override
    public Habit findById(Long id) {
        return habitRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Transactional
    public Habit create(Long idUser, Habit habitToCreate) {
        User user = userRepository.findById(idUser)
                .orElseThrow(NoSuchElementException::new);

        habitToCreate.setIdUser(user.getId());

        if (habitToCreate.getName() == null || habitToCreate.getName().isBlank()){
            throw new IllegalArgumentException("Habit name must not be empty.");
        };


        return habitRepository.save(habitToCreate);

    }

    @Transactional
    public Habit completeHabit(Long idHabit) {
        Habit habit = habitRepository.findById(idHabit)
                .orElseThrow(NoSuchElementException::new);

        habit.setConcluido();
        return habitRepository.save(habit);

    }
}

