package pl.jakowicki.budgetapp.income;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jakowicki.budgetapp.users.UserProfileService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IncomeService {
    private final IncomeRepository incomeRepository;
    private final UserProfileService userProfileService;

    public List<IncomeDto> showAllIncomes() {
        return IncomeMapper.mapListToIncomeDto(incomeRepository.findAll());
    }

    public void createNewIncome(NewIncomeDto newIncome) {
        var income = IncomeMapper.mapNewIncomeToIncome(newIncome);
        incomeRepository.save(income);
    }

    public Optional<IncomeDto> getIncomeOfId(Long incomeId) {
       return Optional.ofNullable(IncomeMapper.mapIncomeToDto(
               incomeRepository.findById(incomeId).orElseThrow()));
    }

    public void updateIncome(Long incomeId, IncomeDto updatedIncome) {
        var existingIncome = incomeRepository.findById(incomeId).orElseThrow();
        existingIncome = updateExistingIncome(existingIncome, updatedIncome);
        incomeRepository.save(existingIncome);
    }

    private Income updateExistingIncome(Income existingIncome, IncomeDto updatedIncome) {
        existingIncome.setAmount(updatedIncome.amount());
        existingIncome.setIncomeDate(updatedIncome.incomeDate());
        existingIncome.setUserProfile(userProfileService.findUserById(updatedIncome.userProfile().id()).orElseThrow());
        return existingIncome;
    }
}
