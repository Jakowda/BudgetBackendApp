package pl.jakowicki.budgetapp.planned_expense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jakowicki.budgetapp.budget.BudgetMapper;
import pl.jakowicki.budgetapp.budget.BudgetService;
import pl.jakowicki.budgetapp.category.CategoryService;
import pl.jakowicki.budgetapp.planned_expense.dto.NewPlannedExpenseDto;
import pl.jakowicki.budgetapp.planned_expense.dto.PlannedExpenseDto;

import java.util.List;
import java.util.NoSuchElementException;

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
}
