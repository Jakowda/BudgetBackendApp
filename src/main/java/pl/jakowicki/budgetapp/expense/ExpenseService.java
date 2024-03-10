package pl.jakowicki.budgetapp.expense;

import org.springframework.stereotype.Service;
import pl.jakowicki.budgetapp.category.Category;
import pl.jakowicki.budgetapp.category.CategoryService;
import pl.jakowicki.budgetapp.expense.dto.ExpenseDto;
import pl.jakowicki.budgetapp.expense.dto.NewExpeenseDto;

import pl.jakowicki.budgetapp.users.UserProfile;
import pl.jakowicki.budgetapp.users.UserProfileService;

import java.util.List;
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

    public void saveNewExpense(ExpenseDto expenseDto){
        Optional<Category> categoryByName = categoryService.findCategoryByName(expenseDto.getCategory().getName());
        expenseRepository.save(new Expense(
                expenseDto.getName(),
                expenseDto.getAmount(),
                expenseDto.getExpense_date(),
                categoryByName.get(),
                expenseDto.getUser()
        ));
    }
    public void saveNewExpense(Expense expense){
        expenseRepository.save(expense);
    }

    public List<ExpenseDto> showExpenseList() {
        return ExpenseMapper.map((List<Expense>)expenseRepository.findAll());
    }

    public void addNewExpense(NewExpeenseDto newExpenseDto) {
        Category category = categoryService.findCategoryByName(newExpenseDto.getCategoryName()).get();
        UserProfile userProfile = userProfileService.findUserByEmail(newExpenseDto.getUserEmail()).get();
        expenseRepository.save(new Expense(
                newExpenseDto.getName(),
                newExpenseDto.getAmount(),
                newExpenseDto.getExpense_date(),
                category,
                userProfile
        ));
    }
}
