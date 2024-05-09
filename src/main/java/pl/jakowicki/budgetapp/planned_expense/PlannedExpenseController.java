package pl.jakowicki.budgetapp.planned_expense;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.jakowicki.budgetapp.planned_expense.dto.NewPlannedExpenseDto;
import pl.jakowicki.budgetapp.planned_expense.dto.PlannedExpenseDto;
import pl.jakowicki.budgetapp.planned_expense.dto.UpdatedPlannedExpenseDto;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/planned_expense")
public class PlannedExpenseController {

    private final PlannedExpenseService plannedExpenseService;

    public PlannedExpenseController(PlannedExpenseService plannedExpenseService) {
        this.plannedExpenseService = plannedExpenseService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a specyfic planned expense")
    Optional<PlannedExpenseDto>showPlannedExpense(@PathVariable Long id){
        return plannedExpenseService.showPlannedExpenseOfId(id);
    }

    @GetMapping()
    @Operation(summary = "Get all planned expenses list")
    List<PlannedExpenseDto> showPlannedExpenseList(){
        return plannedExpenseService.showPlannedExpenseList();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create new planned expense")
    void createNewPlannedExpense(@RequestBody NewPlannedExpenseDto newPlannedExpenseDto){
        plannedExpenseService.createNewPlannedExpense(newPlannedExpenseDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update planned expense")
    void updatePlannedExpense(@PathVariable Long id, @RequestBody UpdatedPlannedExpenseDto updatedPlannedExpense){
        plannedExpenseService.updatePlannedExpenseOfId(id, updatedPlannedExpense);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete planned expense")
    void deletePlannedExpenseById(@PathVariable Long id){
        plannedExpenseService.deletePlannedExpense(id);
    }

}
