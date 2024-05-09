package pl.jakowicki.budgetapp.income;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.jakowicki.budgetapp.users.UserProfileMapper;
import pl.jakowicki.budgetapp.users.UserProfileService;

import java.util.ArrayList;
import java.util.List;
@Component
@RequiredArgsConstructor
public class IncomeMapper {

   static UserProfileService userProfileService;

   public static List<IncomeDto> mapListToIncomeDto(List<Income> incomeList){
       List<IncomeDto> incomeDtos = new ArrayList<>();
       incomeList.forEach(income -> incomeDtos.add( new IncomeDto(
               income.getAmount(),
               income.getIncomeDate(),
               UserProfileMapper.mapToUserProfileDto(income.getUserProfile())
       )));
       return incomeDtos;
   }

    public static Income mapNewIncomeToIncome(NewIncomeDto newIncome) {
       return new Income(
               newIncome.amount(),
               newIncome.incomeDate(),
               userProfileService.findUserById(newIncome.userId()).orElseThrow()
       );
    }

    public static IncomeDto mapIncomeToDto(Income income) {
        return new IncomeDto(
                income.getAmount(),
                income.getIncomeDate(),
                UserProfileMapper.mapToUserProfileDto(income.getUserProfile())
        );
   }
}
