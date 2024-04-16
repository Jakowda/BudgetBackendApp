package pl.jakowicki.budgetapp.budget.dto;

import java.time.LocalDate;

public record UpdatedBudget(String budgetName, Double amount, LocalDate startDate,
                            LocalDate endDate, Long categoryId) {}
