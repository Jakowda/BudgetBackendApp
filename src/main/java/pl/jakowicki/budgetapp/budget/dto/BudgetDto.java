package pl.jakowicki.budgetapp.budget.dto;

import pl.jakowicki.budgetapp.budget.BudgetState;
import pl.jakowicki.budgetapp.category.Category;
import pl.jakowicki.budgetapp.users.dto.UserProfileDto;

import java.time.LocalDate;
public record BudgetDto (
     Long id,
     String name,
     Double amount,
     LocalDate startDate,
     LocalDate endDate,
     BudgetState state,
     UserProfileDto user,
     Category category
){
}
