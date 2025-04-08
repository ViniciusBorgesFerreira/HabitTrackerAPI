package habit_tracker_api.service;

import habit_tracker_api.domain.model.User;

public interface UserService {
    User findById(Long id);
    User create(User userToCreate);
}
