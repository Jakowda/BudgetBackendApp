package pl.jakowicki.budgetapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.jakowicki.budgetapp.budget.Budget;
import pl.jakowicki.budgetapp.budget.BudgetService;
import pl.jakowicki.budgetapp.budget.BudgetState;
//import pl.jakowicki.budgetapp.budget_category.BudgetCategoryService;
import pl.jakowicki.budgetapp.category.Category;
import pl.jakowicki.budgetapp.category.CategoryDto;
import pl.jakowicki.budgetapp.category.CategoryService;
import pl.jakowicki.budgetapp.expense.dto.ExpenseDto;
import pl.jakowicki.budgetapp.expense.ExpenseService;
import pl.jakowicki.budgetapp.users.UserProfile;
import pl.jakowicki.budgetapp.users.UserProfileService;

import java.time.LocalDate;


@SpringBootApplication
public class BudgetAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BudgetAppApplication.class, args);
    }

}
