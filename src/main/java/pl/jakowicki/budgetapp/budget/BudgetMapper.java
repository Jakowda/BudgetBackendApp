package pl.jakowicki.budgetapp.budget;

import org.springframework.stereotype.Component;
import pl.jakowicki.budgetapp.budget.dto.BudgetDto;
import pl.jakowicki.budgetapp.budget.dto.NewBudgetDto;
import pl.jakowicki.budgetapp.category.Category;
import pl.jakowicki.budgetapp.users.UserProfile;
import pl.jakowicki.budgetapp.users.UserProfileMapper;

import java.util.ArrayList;
import java.util.List;

@Component
public class BudgetMapper {


    static public Budget mapDtoToBudget(BudgetDto budgetDto){
        return new Budget(
                budgetDto.name(),
                budgetDto.amount(),
                budgetDto.startDate(),
                budgetDto.endDate(),
                budgetDto.state(),
                UserProfileMapper.map(budgetDto.user()),
                budgetDto.category());
    }

    public static BudgetDto map(Budget budget){
        return new BudgetDto(
                budget.getId(),
                budget.getName(),
                budget.getAmount(),
                budget.getStartDate(),
                budget.getEndDate(),
                budget.getState(),
                UserProfileMapper.mapToUserProfileDto(budget.getUser()),
                budget.getCategory());
    }

    public static List<BudgetDto> mapListToBudgetDto(List<Budget> budgetsList){
        List<BudgetDto> mappedList = new ArrayList<>();
        budgetsList.forEach(
                budget -> mappedList.add(
                        new BudgetDto(
                        budget.getId(),
                        budget.getName(),
                        budget.getAmount(),
                        budget.getStartDate(),
                        budget.getEndDate(),
                        budget.getState(), UserProfileMapper.mapToUserProfileDto(budget.getUser()),
                                budget.getCategory())));
        return mappedList;
    }

    public static Budget mapNewBudgetDtoToBudget(NewBudgetDto newBudgetDto, UserProfile userProfile, Category category) {
        return new Budget(
                newBudgetDto.budgetName(),
                newBudgetDto.amount(),
                newBudgetDto.startDate(),
                newBudgetDto.endDate(),
                BudgetState.OPEN,
                userProfile,
                category);
    }

    public static BudgetDto mapToBudgetDto(Budget budget) {
        return new BudgetDto(
                budget.getId(),
                budget.getName(),
                budget.getAmount(),
                budget.getStartDate(),
                budget.getEndDate(),
                budget.getState(),
                UserProfileMapper.mapToUserProfileDto(budget.getUser()),
                budget.getCategory()
                );
    }
}
