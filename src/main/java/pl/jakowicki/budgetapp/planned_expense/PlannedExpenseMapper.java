package pl.jakowicki.budgetapp.planned_expense;

import org.springframework.stereotype.Component;
import pl.jakowicki.budgetapp.planned_expense.dto.PlannedExpenseDto;

import java.util.ArrayList;
import java.util.List;

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
}
