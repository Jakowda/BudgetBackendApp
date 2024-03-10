package pl.jakowicki.budgetapp.expense;

import org.springframework.web.bind.annotation.*;
import pl.jakowicki.budgetapp.expense.dto.ExpenseDto;
import pl.jakowicki.budgetapp.expense.dto.NewExpeenseDto;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping()
    List<ExpenseDto> showExpenseList(){
        return expenseService.showExpenseList();
    }

    @PostMapping()
    void addNewExpense(@RequestBody NewExpeenseDto newExpenseDto){
        expenseService.addNewExpense(newExpenseDto);
    }
}
