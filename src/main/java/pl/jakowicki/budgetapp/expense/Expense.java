package pl.jakowicki.budgetapp.expense;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.jakowicki.budgetapp.category.Category;
import pl.jakowicki.budgetapp.planned_expense.PlannedExpense;
import pl.jakowicki.budgetapp.users.UserProfile;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private Double amount;
    @Getter
    @Setter
    private LocalDate expense_date;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @Getter
    @Setter
    private Category category;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @Getter
    @Setter
    private UserProfile user;

//    @ManyToOne(optional = true)
//    @JoinColumn(name = "planned_expense_id")
//    private PlannedExpense plannedExpense;


    public Expense(String name, Double amount, LocalDate expense_date, Category category, UserProfile user) {
        this.name = name;
        this.amount = amount;
        this.expense_date = expense_date;
        this.category = category;
        this.user = user;
    }
}
