package pl.jakowicki.budgetapp.users;

import org.springframework.web.bind.annotation.*;
import pl.jakowicki.budgetapp.users.dto.UserProfileDto;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
class UserProfileController {

    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping("/{username}")
    Optional<UserProfileDto> getUserDetails(@PathVariable String username){
        return userProfileService.findUserDtoByUserName(username);
    }

    @GetMapping
    List<UserProfileDto> showUsersList(){
        return userProfileService.showUsersList();
    }
}
