package pl.jakowicki.budgetapp.users;

import org.springframework.stereotype.Service;
import pl.jakowicki.budgetapp.users.dto.UserCredentialsDto;
import pl.jakowicki.budgetapp.users.dto.UserProfileDto;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserProfileService {
    private final UserRepository userRepository;
    public UserProfileService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserProfileDto> findUserByUserName(String userName){
        try{
            var userProfile = userRepository.findByEmail(userName).orElseThrow();
            return Optional.of(UserProfileMapper.mapToUserProfileDto(userProfile));
        }catch (NoSuchElementException nsee){
            return Optional.empty();
        }
    }

    public void saveNewUserProfile(UserProfile user){
        userRepository.save(user);
    }

    public List<UserProfileDto> showUsersList() {
        return UserProfileMapper.map(userRepository.findAll());
    }

    public Optional<UserCredentialsDto> findCredentialsByEmail(String email){
        return userRepository.findByEmail(email).map(UserProfileMapper::mapToUserCredentials);
    }

    public Optional<UserProfile> findUserById(Long userId){
        return userRepository.findById(userId);
    }
}
