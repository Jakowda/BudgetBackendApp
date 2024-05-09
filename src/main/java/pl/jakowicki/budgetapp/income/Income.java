package pl.jakowicki.budgetapp.income;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.jakowicki.budgetapp.users.UserProfile;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    @Getter
    @Setter
    private Double amount;
    @Getter
    @Setter
    private LocalDate incomeDate;
    @Getter
    @Setter
    @ManyToOne(optional = true)
    @JoinColumn(name = "user_id")
    private UserProfile userProfile;

    public Income(Double amount, LocalDate incomeDate, UserProfile userProfile) {
        this.amount = amount;
        this.incomeDate = incomeDate;
        this.userProfile = userProfile;
    }
}
