package pl.jakowicki.budgetapp.expense.dto;
import java.time.LocalDate;
public record NewExpeenseDto(String name, Double amount, LocalDate expense_date, String categoryName, Long userId) { }
