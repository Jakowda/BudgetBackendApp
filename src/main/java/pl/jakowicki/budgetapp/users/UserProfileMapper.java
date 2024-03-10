package pl.jakowicki.budgetapp.users;

import org.springframework.stereotype.Component;
import pl.jakowicki.budgetapp.users.dto.UserCredentialsDto;
import pl.jakowicki.budgetapp.users.dto.UserProfileDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserProfileMapper {

    public static UserProfile map(UserProfileDto userProfileDto){
        return new UserProfile(userProfileDto.getUserName());
    }

    public static UserProfileDto map(UserProfile userProfile){
        return new UserProfileDto(userProfile.getId(), userProfile.getEmail());
    }

    public static List<UserProfileDto> map(List<UserProfile> userProfileList){
        List<UserProfileDto> mappedList = new ArrayList<>();
        userProfileList.forEach(
                userProfile -> mappedList.add(
                        new UserProfileDto(userProfile.getId(),
                                userProfile.getEmail())));
        return mappedList;
    }

    public static UserCredentialsDto mapToUserCredentials(UserProfile userProfile){
        Set<String> roles =userProfile.getRoles().stream()
                .map(role -> role.getName())
                .collect(Collectors.toSet());
        return new UserCredentialsDto(
                userProfile.getEmail(),
                userProfile.getPassword(),
                roles);
    }
}
