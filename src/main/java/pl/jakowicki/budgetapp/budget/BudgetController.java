package pl.jakowicki.budgetapp.budget;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.jakowicki.budgetapp.budget.dto.BudgetDto;
import pl.jakowicki.budgetapp.budget.dto.NewBudgetDto;
import pl.jakowicki.budgetapp.budget.dto.UpdatedBudget;

import java.util.List;
import java.util.Optional;


@RestController()
@RequestMapping("/api/budget")
//@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RequiredArgsConstructor
public class BudgetController {
    private final BudgetService budgetService;

    @GetMapping("/{id}")
    @Operation(summary = "Find a budget by ID")
    Optional<BudgetDto> getBudget(@PathVariable Long id){
        return budgetService.getBudgetById(id);
    }
    @GetMapping()
    @Operation(summary = "Get all budgets")
    List<BudgetDto> showBudgetsList(){
        return budgetService.showListOfBudgets();
    }

    @GetMapping("/user/{id}")
    @Operation(summary = "Find all budgets by user id")
    List<BudgetDto> showListOfUsersBudgets(@PathVariable Long id){
        return budgetService.showUsersListOfBudgets(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create new budget")
    void addNewBudget(@RequestBody NewBudgetDto newBudgetDto){
        budgetService.saveNewBudgetObject(newBudgetDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update budget")
    void updateBudget(@PathVariable Long id, @RequestBody UpdatedBudget updatedBudget){
        budgetService.findAndUpdateBudget(id, updatedBudget);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete budget")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteBudget(@PathVariable Long id){
        budgetService.deleteBudgetById(id);
    }
}
