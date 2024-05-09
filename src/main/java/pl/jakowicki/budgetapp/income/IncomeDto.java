package pl.jakowicki.budgetapp.income;

import pl.jakowicki.budgetapp.users.dto.UserProfileDto;

import java.time.LocalDate;

public record IncomeDto(Double amount, LocalDate incomeDate, UserProfileDto userProfile) {
}
