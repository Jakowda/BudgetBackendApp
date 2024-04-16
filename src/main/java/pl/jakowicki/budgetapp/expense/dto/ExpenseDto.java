package pl.jakowicki.budgetapp.expense.dto;

import pl.jakowicki.budgetapp.category.Category;
import pl.jakowicki.budgetapp.users.dto.UserDataDto;

import java.time.LocalDate;

public record ExpenseDto (String name, Double amount, LocalDate expense_date,
                          Category category, UserDataDto user){ }
