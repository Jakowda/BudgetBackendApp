package pl.jakowicki.budgetapp.category;

import org.springframework.stereotype.Service;
import pl.jakowicki.budgetapp.category.dto.CategoryDto;
import pl.jakowicki.budgetapp.category.dto.NewCategoryDto;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDto> findAllCategories() {
        return CategoryMapper.map(categoryRepository.findAll());
    }

    public void saveNewCategory(NewCategoryDto category) {
        categoryRepository.save(CategoryMapper.map(category));
    }

    public Optional<Category> findCategoryByName(String name) {
        return Optional.of(categoryRepository.findCategoryByName(name));
    }

    public Optional<Category> findCategoryById(Long categoryId) {
       return categoryRepository.findById(categoryId);
    }
}
