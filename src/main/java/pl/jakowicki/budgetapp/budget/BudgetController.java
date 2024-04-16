package pl.jakowicki.budgetapp.budget;

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
    Optional<BudgetDto> getBudget(@PathVariable Long id){
        return budgetService.getBudgetById(id);
    }
    @GetMapping()
    List<BudgetDto> showBudgetsList(){
        return budgetService.showListOfBudgets();
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    void addNewBudget(@RequestBody NewBudgetDto newBudgetDto){
        budgetService.saveNewBudgetObject(newBudgetDto);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    void updateBudget(@PathVariable Long id, @RequestBody UpdatedBudget updatedBudget){
        budgetService.findAndUpdateBudget(id, updatedBudget);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteBudget(@PathVariable Long id){
        budgetService.deleteBudgetById(id);
    }
}
