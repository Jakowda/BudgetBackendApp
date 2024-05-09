package pl.jakowicki.budgetapp.income;

import java.time.LocalDate;

public record NewIncomeDto(Double amount, LocalDate incomeDate, Long userId) {
}
