package pl.jakowicki.budgetapp.planned_expense;

import org.springframework.web.bind.annotation.*;
import pl.jakowicki.budgetapp.planned_expense.dto.NewPlannedExpenseDto;
import pl.jakowicki.budgetapp.planned_expense.dto.PlannedExpenseDto;

import java.util.List;

@RestController
@RequestMapping("/api/planned_expense")
public class PlannedExpenseController {

    private final PlannedExpenseService plannedExpenseService;

    public PlannedExpenseController(PlannedExpenseService plannedExpenseService) {
        this.plannedExpenseService = plannedExpenseService;
    }

    @GetMapping()
    List<PlannedExpenseDto> showPlannedExpenseList(){
        return plannedExpenseService.showPlannedExpenseList();
    }

    @PostMapping()
    void createNewPlannedExpense(@RequestBody NewPlannedExpenseDto newPlannedExpenseDto){
        plannedExpenseService.createNewPlannedExpense(newPlannedExpenseDto);
    }
}
