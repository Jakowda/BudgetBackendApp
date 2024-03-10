package pl.jakowicki.budgetapp.budget;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.jakowicki.budgetapp.category.Category;
import pl.jakowicki.budgetapp.users.UserProfile;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Budget {

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
    private LocalDate startDate;
    @Getter
    @Setter
    private LocalDate endDate;
    @Getter
    @Setter
    private BudgetState state;
    @Getter
    @Setter
    @ManyToOne(optional = true)
    @JoinColumn(name = "user_id")
    private UserProfile user;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Budget(String name, Double amount, LocalDate startDate, LocalDate endDate, BudgetState state, UserProfile user, Category category) {
        this.name = name;
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.state = state;
        this.user = user;
        this.category = category;
    }
}
