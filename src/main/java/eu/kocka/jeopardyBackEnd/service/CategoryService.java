package eu.kocka.jeopardyBackEnd.service;

import eu.kocka.jeopardyBackEnd.entity.Category;
import eu.kocka.jeopardyBackEnd.entity.Game;
import eu.kocka.jeopardyBackEnd.exception.NotFoundException;
import eu.kocka.jeopardyBackEnd.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    private GameService gameService;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, GameService gameService) {
        this.categoryRepository = categoryRepository;
        this.gameService = gameService;
    }

    public Category saveCategory(Category category, Long id) throws NotFoundException {
        Game game = gameService.getGameById(id);
        category.setGame(game);
        return categoryRepository.save(category);
    }

    public List<Category> listAllCategories(){
        List<Category> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(categories::add);
        return categories;
    }

    public List<Category> findAllCategoriesByGameId(Long id){
        return categoryRepository.findAllByGame_Id(id);
    }

    public Category findCategoryById(Long id) throws NotFoundException {
        return categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Category not found with id : " + id));
    }

    public List<Category> batchSaveCategories(List<Category> categories, Long gameId) throws NotFoundException {
        Game game = gameService.getGameById(gameId);

        categories.forEach(c -> c.setGame(game));
        List<Category> savedCategories = new ArrayList<>();
        categoryRepository.saveAll(categories).forEach(savedCategories::add);
        return savedCategories;
    }

    public void deleteCategoryById(Long id){
        categoryRepository.deleteById(id);
    }

    public void deleteCategory(Category category){
        categoryRepository.delete(category);
    }
}
