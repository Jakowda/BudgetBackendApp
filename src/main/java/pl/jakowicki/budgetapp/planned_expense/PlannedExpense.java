package pl.jakowicki.budgetapp.planned_expense;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.jakowicki.budgetapp.budget.Budget;
import pl.jakowicki.budgetapp.category.Category;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PlannedExpense {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private Double amount;
    @Getter
    @Setter
    private PlannedExpenseState plannedExpenseState;
    @ManyToOne
    @JoinColumn(name = "budget_id")
    @Getter
    @Setter
    private Budget budget;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @Getter
    @Setter
    private Category category;

    public PlannedExpense(String name, Double amount, PlannedExpenseState plannedExpenseState, Budget budget, Category category) {
        this.name = name;
        this.amount = amount;
        this.plannedExpenseState = plannedExpenseState;
        this.budget = budget;
        this.category = category;
    }
}
