package habit_tracker_api.service.Impl;

import habit_tracker_api.domain.model.User;
import habit_tracker_api.domain.repository.UserRepository;
import habit_tracker_api.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {

        if (userToCreate.getEmail() == null || userToCreate.getEmail().isBlank()){
            throw new IllegalArgumentException("Email must not be empty.");
        }

        if (userToCreate.getName() == null || userToCreate.getName().isBlank()){
            throw new IllegalArgumentException("Name must not be empty.");
        }

        if (userToCreate.getPassword() == null || userToCreate.getPassword().isBlank()){
            throw new IllegalArgumentException("Password must not be empty.");
        }


        if (userRepository.existsByEmail(userToCreate.getEmail())) {
            throw new IllegalArgumentException("This Account email already exists.");
        }


        return  userRepository.save(userToCreate);

    }
}
