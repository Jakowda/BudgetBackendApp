package pl.jakowicki.budgetapp.planned_expense;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlannedExpenseRepository extends CrudRepository<PlannedExpense, Long> {
}
