package pl.jakowicki.budgetapp.expense;

import org.springframework.stereotype.Component;
import pl.jakowicki.budgetapp.category.Category;
import pl.jakowicki.budgetapp.expense.dto.ExpenseDto;
import pl.jakowicki.budgetapp.expense.dto.NewExpeenseDto;
import pl.jakowicki.budgetapp.users.UserProfile;
import pl.jakowicki.budgetapp.users.UserProfileMapper;
import pl.jakowicki.budgetapp.users.dto.UserDataDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ExpenseMapper {

    public static Expense map(ExpenseDto expenseDto, UserProfile user){
        return new Expense(expenseDto.name(),
                expenseDto.amount(),
                expenseDto.expense_date(),
                expenseDto.category(),
                user);
    }

    public static List<ExpenseDto> map(List<Expense> expenseList){
        List<ExpenseDto>expenseDtoList =new ArrayList<>();
        expenseList.forEach(expense -> expenseDtoList.add(
                new ExpenseDto(
                        expense.getName(),
                        expense.getAmount(),
                        expense.getExpense_date(),
                        expense.getCategory(),
                        createNewUserDataDto(expense.getUser())
                )
        ));
        return expenseDtoList;
    }

    private static UserDataDto createNewUserDataDto(UserProfile userProfile) {
        return new UserDataDto(userProfile.getId(),
                userProfile.getFirstName(),
                userProfile.getLastName(),
                userProfile.getEmail());
    }

    public static Expense map(NewExpeenseDto newExpenseDto, Category category, UserProfile userProfile) {
        return new Expense(
                newExpenseDto.name(),
                newExpenseDto.amount(),
                newExpenseDto.expense_date(),
                category,
                userProfile
        );
    }

    public static ExpenseDto mapExpenseToDto(Expense expense) {
        return new ExpenseDto(
                expense.getName(),
                expense.getAmount(),
                expense.getExpense_date(),
                expense.getCategory(),
                UserProfileMapper.mapUserToDataDto(expense.getUser())
        );
    }
}
