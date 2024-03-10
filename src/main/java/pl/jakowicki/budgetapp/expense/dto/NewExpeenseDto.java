package pl.jakowicki.budgetapp.expense.dto;

import org.springframework.stereotype.Component;


import java.time.LocalDate;

@Component
public class NewExpeenseDto {

    private String name;
    private Double amount;
    private LocalDate expense_date;
    private String categoryName;
    private String userEmail;

    public NewExpeenseDto() {
    }

    public NewExpeenseDto(String name, Double amount, LocalDate expense_date, String categoryName, String userName) {
        this.name = name;
        this.amount = amount;
        this.expense_date = expense_date;
        this.categoryName = categoryName;
        this.userEmail = userName;
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

    public LocalDate getExpense_date() {
        return expense_date;
    }

    public void setExpense_date(LocalDate expense_date) {
        this.expense_date = expense_date;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
