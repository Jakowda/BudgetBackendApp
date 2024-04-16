package pl.jakowicki.budgetapp.planned_expense.dto;
import pl.jakowicki.budgetapp.planned_expense.PlannedExpenseState;
public record NewPlannedExpenseDto (String name, Double amount, PlannedExpenseState plannedExpenseState, Long budgetId, Long categoryId ){ }
