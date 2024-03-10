package pl.jakowicki.budgetapp.expense;

import org.springframework.stereotype.Component;
import pl.jakowicki.budgetapp.expense.dto.ExpenseDto;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExpenseMapper {

    public static Expense map(ExpenseDto expenseDto){
        return new Expense(expenseDto.getName(),
                expenseDto.getAmount(),
                expenseDto.getExpense_date(),
                expenseDto.getCategory(),
                expenseDto.getUser());
    }

    public static List<ExpenseDto> map(List<Expense> expenseList){
        List<ExpenseDto>expenseDtoList =new ArrayList<>();
        expenseList.forEach(expense -> expenseDtoList.add(
                new ExpenseDto(
                        expense.getName(),
                        expense.getAmount(),
                        expense.getExpense_date(),
                        expense.getCategory(),
                        expense.getUser()
                )
        ));
        return expenseDtoList;
    }
}
