package pl.jakowicki.budgetapp.budget;

import org.springframework.web.bind.annotation.*;
import pl.jakowicki.budgetapp.budget.dto.BudgetDto;
import pl.jakowicki.budgetapp.budget.dto.NewBudgetDto;

import java.util.List;
import java.util.Optional;


@RestController()
@RequestMapping("/api/budget")
public class BudgetController {
    private final BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @GetMapping("/{id}")
    BudgetDto getBudget(@PathVariable Long id){
        Optional<BudgetDto> budgetById = budgetService.getBudgetById(id);
        return budgetById.get();
    }

    @GetMapping()
    List<BudgetDto> showBudgetsList(){
        System.out.println("Działa!!!");
        return budgetService.showListOfBudgets();
    }

    @PostMapping()
    void addNewBudget(@RequestBody NewBudgetDto newBudgetDto){
        budgetService.saveNewBudgetObject(newBudgetDto);
    }
}
