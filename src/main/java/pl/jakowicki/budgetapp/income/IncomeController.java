package pl.jakowicki.budgetapp.income;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/income")
@RequiredArgsConstructor
public class IncomeController {

    private final IncomeService incomeService;

    @GetMapping()
    @Operation(summary = "Get list of all Incomes")
    List<IncomeDto> showAllIncomes(){
       return incomeService.showAllIncomes();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get specyfic income")
    Optional<IncomeDto> getIncomeOfId(@PathVariable Long id){
        return incomeService.getIncomeOfId(id);
    }

    @PostMapping()
    @Operation(summary = "Create new Income")
    @ResponseStatus(HttpStatus.CREATED)
    void addNewIncome(@RequestBody NewIncomeDto newIncome){
        incomeService.createNewIncome(newIncome);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a specyfic income")
    @ResponseStatus(HttpStatus.OK)
    void updateIncome(@PathVariable Long id, @RequestBody IncomeDto updatedIncome){
        incomeService.updateIncome(id, updatedIncome);
    }

}
