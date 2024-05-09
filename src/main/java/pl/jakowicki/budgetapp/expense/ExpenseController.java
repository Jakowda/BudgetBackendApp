package pl.jakowicki.budgetapp.expense;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.jakowicki.budgetapp.expense.dto.ExpenseDto;
import pl.jakowicki.budgetapp.expense.dto.NewExpeenseDto;
import pl.jakowicki.budgetapp.expense.dto.UpdatedExpenseDto;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/expense")
@RequiredArgsConstructor
public class ExpenseController {
    private final ExpenseService expenseService;

    @GetMapping()
    @Operation(summary = "Get all Expenses list")
    List<ExpenseDto> showExpenseList(){
        return expenseService.showExpenseList();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a specyfic expense")
    Optional<ExpenseDto> getExpenseById(@PathVariable Long id){
        return expenseService.findExpenseById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create new expense")
    void addNewExpense(@RequestBody NewExpeenseDto newExpenseDto){
        expenseService.addNewExpense(newExpenseDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update a specyfic expense")
    void updateExpense(@PathVariable Long id, @RequestBody UpdatedExpenseDto updatedExpense){
        expenseService.updateExpense(id, updatedExpense);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete expense")
    void deleteExpense(@PathVariable Long id){
        expenseService.deleteExpenseById(id);
    }
}
