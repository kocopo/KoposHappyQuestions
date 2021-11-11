package eu.kocka.jeopardyBackEnd.mapper;

import eu.kocka.jeopardyBackEnd.dto.CategoryDto;
import eu.kocka.jeopardyBackEnd.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {


    public CategoryDto mapToDto(Category category){
        return new CategoryDto(category.getId(), category.getCategoryName(), category.getGame().getId());
    }

    public List<CategoryDto> mapListToDtos(List<Category> categories){
        List<CategoryDto> dtos = new ArrayList<>();
        categories.forEach(c -> dtos.add(new CategoryDto(c.getId(), c.getCategoryName(), c.getGame().getId())));
        return dtos;
    }

    public List<CategoryDto> mapCategoriesWithQuestions(List<Category> categories){
        QuestionMapper questionMapper = new QuestionMapper();
        List<CategoryDto> dtos = new ArrayList<>();
        categories.forEach(c -> dtos.add(new CategoryDto(c.getId(), c.getCategoryName(), c.getGame().getId(), questionMapper.mapListToDtos(c.getQuestions()))));
        return dtos;
    }
}
