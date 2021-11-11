package eu.kocka.jeopardyBackEnd.controller;

import eu.kocka.jeopardyBackEnd.dto.CategoryDto;
import eu.kocka.jeopardyBackEnd.enitity.Category;
import eu.kocka.jeopardyBackEnd.exception.NotFoundException;
import eu.kocka.jeopardyBackEnd.mapper.CategoryMapper;
import eu.kocka.jeopardyBackEnd.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper mapper;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
        this.mapper = new CategoryMapper();
    }

    @PostMapping("game/{gameId}")
    public ResponseEntity<CategoryDto> saveCategory(@RequestBody Category category, @PathVariable Long gameId) throws NotFoundException {
        return new ResponseEntity<>(mapper.mapToDto(categoryService.saveCategory(category, gameId)), HttpStatus.OK);
    }

    @PostMapping("game/{gameId}/batch")
    public ResponseEntity<List<CategoryDto>> saveBatchCategories(@RequestBody List<Category> categories, @PathVariable Long gameId) throws NotFoundException {
        return new ResponseEntity<>(mapper.mapListToDtos(categoryService.batchSaveCategories(categories, gameId)), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<CategoryDto>> listAllCategories(){
        return new ResponseEntity<>(mapper.mapListToDtos(categoryService.listAllCategories()), HttpStatus.OK);
    }

    @GetMapping("game/{gameId}")
    public ResponseEntity<List<CategoryDto>> getCategoriesByGameId(@PathVariable Long gameId){
        return new ResponseEntity<>(mapper.mapListToDtos(categoryService.findAllCategoriesByGameId(gameId)), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id) throws NotFoundException {
        return new ResponseEntity<>(mapper.mapToDto(categoryService.findCategoryById(id)),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable Long id){
        categoryService.deleteCategoryById(id);
        return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
    }
}
