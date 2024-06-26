package pl.jakowicki.budgetapp.users;

import org.springframework.stereotype.Component;

@Component
public class UserProfileDto {

    private Long id;
    private String userName;

    public UserProfileDto() {
    }

    public UserProfileDto(Long id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
