package pl.jakowicki.budgetapp.planned_expense;

import org.springframework.stereotype.Service;
import pl.jakowicki.budgetapp.budget.BudgetMapper;
import pl.jakowicki.budgetapp.budget.BudgetService;
import pl.jakowicki.budgetapp.category.CategoryService;
import pl.jakowicki.budgetapp.planned_expense.dto.NewPlannedExpenseDto;
import pl.jakowicki.budgetapp.planned_expense.dto.PlannedExpenseDto;
import pl.jakowicki.budgetapp.planned_expense.dto.UpdatedPlannedExpenseDto;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PlannedExpenseService {

    private  PlannedExpenseRepository plannedExpenseRepository;
    private  BudgetService budgetService;
    private  CategoryService categoryService;

    public PlannedExpenseService(PlannedExpenseRepository plannedExpenseRepository, BudgetService budgetService, CategoryService categoryService) {
        this.plannedExpenseRepository = plannedExpenseRepository;
        this.budgetService = budgetService;
        this.categoryService = categoryService;
    }

    public List<PlannedExpenseDto> showPlannedExpenseList() {
       return PlannedExpenseMapper.map(plannedExpenseRepository.findAll());
    }

    public void createNewPlannedExpense(NewPlannedExpenseDto newPlannedExpenseDto) {

        var category = categoryService.findCategoryById(
                newPlannedExpenseDto.categoryId()).orElseThrow(
                () -> new NoSuchElementException("Category not found for id"+newPlannedExpenseDto.categoryId())
        );
        var budget = budgetService.findBudgetById(
                newPlannedExpenseDto.budgetId()).orElseThrow(
                () -> new NoSuchElementException("Budget not found for id"+newPlannedExpenseDto.budgetId())
        );
        plannedExpenseRepository.save(PlannedExpenseMapper.mapOfNewPlannedExpenseDto(
                newPlannedExpenseDto, category, BudgetMapper.mapDtoToBudget(budget)));
    }

    public Optional<PlannedExpenseDto> showPlannedExpenseOfId(Long plannedExpenseId) {
        var plannedExpense = plannedExpenseRepository.findById(plannedExpenseId).orElseThrow();
        return Optional.ofNullable(PlannedExpenseMapper.mapPlannedExpenseDto(plannedExpense));
    }

    public void updatePlannedExpenseOfId(Long plannedExpenseId, UpdatedPlannedExpenseDto updatedPlannedExpense) {
        var existingPlannedExpense = plannedExpenseRepository.findById(plannedExpenseId).orElseThrow();
        existingPlannedExpense = updateExistingPlannedExpense(existingPlannedExpense, updatedPlannedExpense);
        plannedExpenseRepository.save(existingPlannedExpense);
    }

    private PlannedExpense updateExistingPlannedExpense(PlannedExpense existingPlannedExpense, UpdatedPlannedExpenseDto updatedPlannedExpense) {
        existingPlannedExpense.setName(updatedPlannedExpense.name());
        existingPlannedExpense.setAmount(updatedPlannedExpense.amount());
        existingPlannedExpense.setPlannedExpenseState(updatedPlannedExpense.plannedExpenseState());
        existingPlannedExpense.setBudget(updatedPlannedExpense.budget());
        existingPlannedExpense.setCategory(updatedPlannedExpense.category());
        return existingPlannedExpense;
    }

    public void deletePlannedExpense(Long plannedExpenseId) {
        plannedExpenseRepository.deleteById(plannedExpenseId);
    }
}














