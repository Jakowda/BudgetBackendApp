package pl.jakowicki.budgetapp.planned_expense.dto;

import pl.jakowicki.budgetapp.budget.Budget;
import pl.jakowicki.budgetapp.category.Category;
import pl.jakowicki.budgetapp.planned_expense.PlannedExpenseState;

public record UpdatedPlannedExpenseDto (String name, Double amount,
                                        PlannedExpenseState plannedExpenseState,
                                        Budget budget, Category category){}
