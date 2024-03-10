package pl.jakowicki.budgetapp.budget;

import org.springframework.stereotype.Component;
import pl.jakowicki.budgetapp.users.UserProfile;

import java.time.LocalDate;

@Component
public class BudgetDto {

    private Long id;
    private String name;
    private Double amount;
    private LocalDate startDate;
    private LocalDate endDate;
    private BudgetState state;

    private UserProfile user;

    public BudgetDto(Long id, String name, Double amount, LocalDate startDate, LocalDate endDate, BudgetState state, UserProfile user) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.state = state;
        this.user = user;
    }

    public UserProfile getUser() {
        return user;
    }

    public void setUser(UserProfile user) {
        this.user = user;
    }

    public BudgetDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BudgetState getState() {
        return state;
    }

    public void setState(BudgetState state) {
        this.state = state;
    }
}
