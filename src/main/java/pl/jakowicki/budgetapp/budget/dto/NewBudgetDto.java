package pl.jakowicki.budgetapp.budget.dto;
import java.time.LocalDate;
public record NewBudgetDto (String budgetName, Double amount, LocalDate startDate,
                            LocalDate endDate, String userLoginName, Long categoryId){}
