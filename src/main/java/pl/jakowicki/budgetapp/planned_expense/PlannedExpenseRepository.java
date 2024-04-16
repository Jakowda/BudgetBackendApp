package pl.jakowicki.budgetapp.planned_expense;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlannedExpenseRepository extends JpaRepository<PlannedExpense, Long> {
}
