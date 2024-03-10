package pl.jakowicki.budgetapp.planned_expense.dto;

import pl.jakowicki.budgetapp.planned_expense.PlannedExpenseState;

public class NewPlannedExpenseDto {

    private String name;
    private Double amount;
    private PlannedExpenseState plannedExpenseState;
    private Long budgetId;
    private Long categoryId;

    public NewPlannedExpenseDto() {
    }

    public NewPlannedExpenseDto(String name, Double amount, PlannedExpenseState plannedExpenseState, Long budgetId, Long categoryId) {
        this.name = name;
        this.amount = amount;
        this.plannedExpenseState = plannedExpenseState;
        this.budgetId = budgetId;
        this.categoryId = categoryId;
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

    public Long getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(Long budgetId) {
        this.budgetId = budgetId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
