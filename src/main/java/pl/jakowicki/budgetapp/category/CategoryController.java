package pl.jakowicki.budgetapp.category;

import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Get category list")
    List<CategoryDto> showCategoryList(){
        return categoryService.findAllCategories();
    }

    @PostMapping()
    @Operation(summary = "Create new category")
    void addNewCategory(@RequestBody NewCategoryDto categoryName){
        categoryService.saveNewCategory(categoryName);
    }
}
