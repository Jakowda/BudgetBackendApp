package pl.jakowicki.budgetapp.category;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Optional<List<CategoryDto>> findAllCategories() {
        return Optional.of(CategoryMapper.map((List<Category>) categoryRepository.findAll()));
    }

    public void saveNewCategory(CategoryDto category) {
        categoryRepository.save(CategoryMapper.map(category));
    }

    public Optional<Category> findCategoryByName(String name) {
        return Optional.of(categoryRepository.findCategoryByName(name));
    }

    public Optional<Category> findCategoryById(Long categoryId) {
       return categoryRepository.findById(categoryId);
    }
}
