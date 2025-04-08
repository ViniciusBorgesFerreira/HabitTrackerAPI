package habit_tracker_api.service;

import habit_tracker_api.domain.model.Historic;

public interface HistoricService {
    Historic findById(Long id);
    Historic create(Long idHabit);
}
