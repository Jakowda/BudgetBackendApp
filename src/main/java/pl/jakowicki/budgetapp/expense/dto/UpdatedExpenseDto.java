package pl.jakowicki.budgetapp.expense.dto;

import java.time.LocalDate;

public record UpdatedExpenseDto(String name, Double amount, LocalDate expense_date, String categoryName) {
}
