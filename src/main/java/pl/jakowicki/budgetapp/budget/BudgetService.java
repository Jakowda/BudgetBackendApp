package pl.jakowicki.budgetapp.budget;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jakowicki.budgetapp.budget.dto.BudgetDto;
import pl.jakowicki.budgetapp.budget.dto.NewBudgetDto;
import pl.jakowicki.budgetapp.budget.dto.UpdatedBudget;
import pl.jakowicki.budgetapp.category.CategoryService;
import pl.jakowicki.budgetapp.users.UserProfileService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BudgetService {

    private BudgetRepository budgetRepository;
    private UserProfileService userProfileService;
    private CategoryService categoryService;

    Optional<BudgetDto> getBudgetById(Long id) {
        return Optional.of(
                BudgetMapper.map(budgetRepository.findById(id).get()));
    }

    public void saveNewBudget(Budget budget) {
        budgetRepository.save(budget);
    }

    public List<BudgetDto> showListOfBudgets() {
        return BudgetMapper.mapListToBudgetDto(budgetRepository.findAll());
    }

    public void saveNewBudgetObject(NewBudgetDto newBudgetDto) throws NoSuchElementException {
        //Find userprofile by id
        //Find category by id
        //Map new budgetObject to a Budget and save it into DB
        try {
            var userProfile = userProfileService.findUserById(newBudgetDto.userId())
                    .orElseThrow(() -> new NoSuchElementException("User not found for id" + newBudgetDto.userId())
                    );
            var category = categoryService.findCategoryById(newBudgetDto.categoryId())
                    .orElseThrow(() -> new NoSuchElementException("Category not found for id" + newBudgetDto.categoryId())
                    );
            budgetRepository.save(BudgetMapper.mapNewBudgetDtoToBudget(
                            newBudgetDto, userProfile, category));
        } catch (NoSuchElementException nsee) {
            System.out.println(nsee.getMessage());
        }
    }

    public Optional<BudgetDto> findBudgetById(Long budgetId) {
        try{
            return Optional.of(BudgetMapper.mapToBudgetDto(
                    budgetRepository.findById(budgetId).orElseThrow()));
        }catch(NoSuchElementException nsee){
            return Optional.empty();
        }
    }

    public void findAndUpdateBudget(Long budgetId, UpdatedBudget updatedBudget) {
        var existingBudget = budgetRepository.findById(budgetId).orElseThrow();
        existingBudget = updateExistingBudget(existingBudget, updatedBudget);
        budgetRepository.save(existingBudget);
    }

    private Budget updateExistingBudget(Budget existingBudget, UpdatedBudget updatedBudget) {
        existingBudget.setName(updatedBudget.budgetName());
        existingBudget.setAmount(updatedBudget.amount());
        existingBudget.setStartDate(updatedBudget.startDate());
        existingBudget.setEndDate(updatedBudget.endDate());
        existingBudget.setCategory(categoryService.findCategoryById(
                updatedBudget.categoryId()).orElseThrow());
        return existingBudget;
    }

    public void deleteBudgetById(Long budgetId) {
        budgetRepository.deleteById(budgetId);
    }
}
