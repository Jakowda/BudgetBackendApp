package pl.jakowicki.budgetapp.category;

import org.springframework.stereotype.Service;
import pl.jakowicki.budgetapp.category.dto.CategoryDto;
import pl.jakowicki.budgetapp.category.dto.NewCategoryDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryMapper {

    public static CategoryDto map(Category category){
        return new CategoryDto(category.getId(), category.getName());
    }

    public static Category map(CategoryDto category){
        return new Category(category.id(), category.name());
    }

    public static Category map(NewCategoryDto category){
        return new Category(category.name());
    }

    public static List<CategoryDto> map(List<Category> categoryList){
        List<CategoryDto> mappedList = new ArrayList<>();
        categoryList.forEach(category -> mappedList.add(new CategoryDto(category.getId(), category.getName())));
        return mappedList;
    }
}
