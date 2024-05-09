package pl.jakowicki.budgetapp.users;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.jakowicki.budgetapp.users.dto.UserProfileDto;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
class UserProfileController {

    private final UserProfileService userProfileService;

    @GetMapping("/{username}")
    @Operation(summary = "Get user profile by username")
    ResponseEntity<UserProfileDto> getUserDetails(@PathVariable String username){
        return userProfileService.findUserByUserName(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @GetMapping
    @Operation(summary = "Get all users list")
    List<UserProfileDto> showUsersList(){
        return userProfileService.showUsersList();
    }
}
