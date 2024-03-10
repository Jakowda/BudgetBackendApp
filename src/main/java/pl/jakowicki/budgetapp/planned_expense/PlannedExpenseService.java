package pl.jakowicki.budgetapp.planned_expense;

import org.springframework.stereotype.Service;
import pl.jakowicki.budgetapp.budget.Budget;
import pl.jakowicki.budgetapp.budget.BudgetService;
import pl.jakowicki.budgetapp.category.Category;
import pl.jakowicki.budgetapp.category.CategoryService;
import pl.jakowicki.budgetapp.planned_expense.dto.NewPlannedExpenseDto;
import pl.jakowicki.budgetapp.planned_expense.dto.PlannedExpenseDto;

import java.util.List;
import java.util.Optional;

@Service
public class PlannedExpenseService {
    private final PlannedExpenseRepository plannedExpenseRepository;
    private final BudgetService budgetService;
    private final CategoryService categoryService;

    public PlannedExpenseService(PlannedExpenseRepository plannedExpenseRepository, BudgetService budgetService, CategoryService categoryService) {
        this.plannedExpenseRepository = plannedExpenseRepository;
        this.budgetService = budgetService;
        this.categoryService = categoryService;
    }

    public List<PlannedExpenseDto> showPlannedExpenseList() {
       return PlannedExpenseMapper.map((List<PlannedExpense>)plannedExpenseRepository.findAll());
    }

    public void createNewPlannedExpense(NewPlannedExpenseDto newPlannedExpenseDto) {
        Optional<Category> category = categoryService.findCategoryById(newPlannedExpenseDto.getCategoryId());
        Optional<Budget> budget = budgetService.findBudgetById(newPlannedExpenseDto.getBudgetId());
        plannedExpenseRepository.save(new PlannedExpense(
                newPlannedExpenseDto.getName(),
                newPlannedExpenseDto.getAmount(),
                newPlannedExpenseDto.getPlannedExpenseState(),
                budget.get(),
                category.get()
        ));
    }
}
