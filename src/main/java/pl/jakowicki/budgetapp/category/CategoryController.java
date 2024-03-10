package pl.jakowicki.budgetapp.category;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    ResponseEntity<List<CategoryDto>> showCategoryList(){
        System.out.println("Działa");
        return categoryService.findAllCategories()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

//    @GetMapping()
//    String showCategoryList(){
//        System.out.println("Działa");
//        return "Działa!!";
//    }

    @PostMapping()
    void addNewCategory(@RequestBody CategoryDto categoryName){
        categoryService.saveNewCategory(categoryName);
    }
}
