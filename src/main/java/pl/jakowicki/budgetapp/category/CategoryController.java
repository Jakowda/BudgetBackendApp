package pl.jakowicki.budgetapp.category;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.jakowicki.budgetapp.category.dto.CategoryDto;
import pl.jakowicki.budgetapp.category.dto.NewCategoryDto;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping()
    List<CategoryDto> showCategoryList(){
        return categoryService.findAllCategories();
    }

    @PostMapping()
    void addNewCategory(@RequestBody NewCategoryDto categoryName){
        categoryService.saveNewCategory(categoryName);
    }
}
