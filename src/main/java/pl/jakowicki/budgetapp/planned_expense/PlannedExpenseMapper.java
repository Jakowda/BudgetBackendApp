package pl.jakowicki.budgetapp.planned_expense;

import org.springframework.stereotype.Component;
import pl.jakowicki.budgetapp.budget.Budget;
import pl.jakowicki.budgetapp.category.Category;
import pl.jakowicki.budgetapp.planned_expense.dto.NewPlannedExpenseDto;
import pl.jakowicki.budgetapp.planned_expense.dto.PlannedExpenseDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PlannedExpenseMapper {


    public static List<PlannedExpenseDto> map(List<PlannedExpense> plannedExpenseList){
        List<PlannedExpenseDto> mappedList = new ArrayList<>();
        plannedExpenseList.forEach(expense -> mappedList.add(
                new PlannedExpenseDto(
                        expense.getName(),
                        expense.getAmount(),
                        expense.getPlannedExpenseState(),
                        expense.getBudget(),
                        expense.getCategory()
                )
        ));
        return mappedList;
    }

    public static PlannedExpense mapOfNewPlannedExpenseDto(NewPlannedExpenseDto newPlannedExpenseDto, Category category, Budget budget) {
        return new PlannedExpense(
                newPlannedExpenseDto.name(),
                newPlannedExpenseDto.amount(),
                newPlannedExpenseDto.plannedExpenseState(),
                budget,
                category);
    }

    public static PlannedExpenseDto mapPlannedExpenseDto(PlannedExpense plannedExpense) {
        return new PlannedExpenseDto(
                plannedExpense.getName(),
                plannedExpense.getAmount(),
                plannedExpense.getPlannedExpenseState(),
                plannedExpense.getBudget(),
                plannedExpense.getCategory()
        );
    }
}
