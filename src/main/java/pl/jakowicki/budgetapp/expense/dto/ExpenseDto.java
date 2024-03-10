package pl.jakowicki.budgetapp.expense;

import org.springframework.stereotype.Component;
import pl.jakowicki.budgetapp.category.Category;
import pl.jakowicki.budgetapp.users.UserProfile;

import java.time.LocalDate;

@Component
public class ExpenseDto {
    private String name;
    private Double amount;
    private LocalDate expense_date;
    private Category category;
    private UserProfile user;

    public ExpenseDto() {
    }

    public ExpenseDto(String name, Double amount, LocalDate expense_date, Category category, UserProfile user) {
        this.name = name;
        this.amount = amount;
        this.expense_date = expense_date;
        this.category = category;
        this.user = user;
    }
//
//    public ExpenseDto(Long id, String name, Double amount, LocalDate expense_date, Category category, UserProfile user) {
//        this.name = name;
//        this.amount = amount;
//        this.expense_date = expense_date;
//        this.category = category;
//        this.user = user;
//    }

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

    public LocalDate getExpense_date() {
        return expense_date;
    }

    public void setExpense_date(LocalDate expense_date) {
        this.expense_date = expense_date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public UserProfile getUser() {
        return user;
    }

    public void setUser(UserProfile user) {
        this.user = user;
    }
}
