package pl.jakowicki.budgetapp.users;

import org.springframework.stereotype.Service;
import pl.jakowicki.budgetapp.users.dto.UserCredentialsDto;
import pl.jakowicki.budgetapp.users.dto.UserProfileDto;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService {

    private final UserRepository userRepository;

    public UserProfileService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserProfileDto> findUserDtoByUserName(String userName){
        Optional<UserProfile> userProfile = userRepository.findByEmail(userName);
        return Optional.of(UserProfileMapper.map(userProfile.get()));
    }

    public Optional<UserProfile> findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public void saveNewUserProfile(UserProfile user){
        userRepository.save(user);
    }

    public List<UserProfileDto> showUsersList() {
        return UserProfileMapper.map((List<UserProfile>)userRepository.findAll());
    }

    public Optional<UserCredentialsDto> findCredentialsByEmail(String email){
        return userRepository.findByEmail(email).map(UserProfileMapper::mapToUserCredentials);
    }
}
