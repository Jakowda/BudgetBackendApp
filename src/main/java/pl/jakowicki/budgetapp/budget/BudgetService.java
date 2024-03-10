package pl.jakowicki.budgetapp.budget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jakowicki.budgetapp.budget.dto.BudgetDto;
import pl.jakowicki.budgetapp.budget.dto.NewBudgetDto;
import pl.jakowicki.budgetapp.category.Category;
import pl.jakowicki.budgetapp.category.CategoryService;
import pl.jakowicki.budgetapp.users.UserProfile;
import pl.jakowicki.budgetapp.users.UserProfileMapper;
import pl.jakowicki.budgetapp.users.UserProfileService;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;
    @Autowired
    private UserProfileService userProfileService;
    @Autowired
    private CategoryService categoryService;


    Optional<BudgetDto> getBudgetById(Long id){
        return Optional.of(
                BudgetMapper.map(budgetRepository.findById(id).get()));
    }

    public void saveNewBudget(Budget budget) {
        budgetRepository.save(budget);
    }

    public List<BudgetDto> showListOfBudgets() {
      return BudgetMapper.map((List<Budget>) budgetRepository.findAll());
    }

    public void saveNewBudgetObject(NewBudgetDto newBudgetDto) {
        var userProfile= userProfileService.findUserByEmail(newBudgetDto.userLoginName()).get();
        var category = categoryService.findCategoryById(newBudgetDto.categoryId()).get();
        budgetRepository.save(BudgetMapper.map(newBudgetDto, userProfile, category));
    }

    public Optional<Budget> findBudgetById(Long budgetId) {
        return budgetRepository.findById(budgetId);
    }
}
