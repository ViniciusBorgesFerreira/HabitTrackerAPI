package habit_tracker_api.service.Impl;

import habit_tracker_api.domain.model.Habit;
import habit_tracker_api.domain.model.Historic;
import habit_tracker_api.domain.repository.HabitRepository;
import habit_tracker_api.domain.repository.HistoricRepository;
import habit_tracker_api.service.HistoricService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.NoSuchElementException;

@Service
public class HistoricServiceImpl implements HistoricService {
    private final HabitRepository habitRepository;
    private final HistoricRepository historicRepository;

    public HistoricServiceImpl(HabitRepository habitRepository, HistoricRepository historicRepository) {
        this.habitRepository = habitRepository;
        this.historicRepository = historicRepository;
    }

    @Transactional
    public Historic create(Long habitId) {
        Habit habit = habitRepository.findById(habitId)
                .orElseThrow(() -> new RuntimeException("Hábito não encontrado"));

        Historic newHistoric = new Historic();
        newHistoric.setDate(LocalDateTime.now());
        newHistoric.setCompleted(true);
        newHistoric.setHabit(habit);

        historicRepository.save(newHistoric);

        if (habit.getHistoricList() == null) {
            habit.setHistoricList(new ArrayList<>());
        }


        habit.getHistoricList().add(newHistoric);
        habitRepository.save(habit);



        return newHistoric;
    }

    @Override
    public Historic findById(Long id) {
        return historicRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }


}