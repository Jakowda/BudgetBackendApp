package pl.jakowicki.budgetapp.planned_expense.dto;


import org.springframework.stereotype.Component;
import pl.jakowicki.budgetapp.budget.Budget;
import pl.jakowicki.budgetapp.category.Category;
import pl.jakowicki.budgetapp.planned_expense.PlannedExpenseState;

@Component
public class PlannedExpenseDto {

    private String name;
    private Double amount;
    private PlannedExpenseState plannedExpenseState;
    private Budget budget;
    private Category category;

    public PlannedExpenseDto() {
    }

    public PlannedExpenseDto(String name, Double amount, PlannedExpenseState plannedExpenseState, Budget budget, Category category) {
        this.name = name;
        this.amount = amount;
        this.plannedExpenseState = plannedExpenseState;
        this.budget = budget;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public PlannedExpenseState getPlannedExpenseState() {
        return plannedExpenseState;
    }

    public void setPlannedExpenseState(PlannedExpenseState plannedExpenseState) {
        this.plannedExpenseState = plannedExpenseState;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
