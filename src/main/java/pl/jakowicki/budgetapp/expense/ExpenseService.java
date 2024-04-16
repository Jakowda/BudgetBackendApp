package pl.jakowicki.budgetapp.expense;

import org.springframework.stereotype.Service;
import pl.jakowicki.budgetapp.category.CategoryService;
import pl.jakowicki.budgetapp.expense.dto.ExpenseDto;
import pl.jakowicki.budgetapp.expense.dto.NewExpeenseDto;
import pl.jakowicki.budgetapp.users.UserProfile;
import pl.jakowicki.budgetapp.users.UserProfileService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final CategoryService categoryService;
    private final UserProfileService userProfileService;

    public ExpenseService(ExpenseRepository expenseRepository, CategoryService categoryService, UserProfileService userProfileService) {
        this.expenseRepository = expenseRepository;
        this.categoryService = categoryService;
        this.userProfileService = userProfileService;
    }

    public List<ExpenseDto> showExpenseList() {
        return ExpenseMapper.map(expenseRepository.findAll());
    }

    public void addNewExpense(NewExpeenseDto newExpenseDto) {
        //Find category object
        //Find userprofile object
        //Map data to create new Expense object and save it to DB.
        try{
            var category = categoryService.findCategoryByName(newExpenseDto.categoryName()).orElseThrow(
                    () -> new NoSuchElementException("Category not found for id" + newExpenseDto.categoryName())
            );
            var userProfile = userProfileService.findUserById(newExpenseDto.userId()).orElseThrow(
                    () -> new NoSuchElementException("User not found for id" + newExpenseDto.userId())
            );
            expenseRepository.save(ExpenseMapper.map(newExpenseDto, category, userProfile));
        }catch (NoSuchElementException nsee){
            System.out.println(nsee.getMessage());
        }
    }

    public Optional<ExpenseDto> findExpenseById(Long expenseId) {
        var expense = expenseRepository.findById(expenseId).orElseThrow();
        return Optional.of(ExpenseMapper.mapExpenseToDto(expense));
    }
}
