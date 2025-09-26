package swf.army.mil.cookbookapp.recipe;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }

//    private ArrayList<Recipe> recipes = new ArrayList<Recipe>();

    public Recipe saveRecipe(Recipe recipe){
//        recipes.add(recipe);
//        return recipe;
        return recipeRepository.save(recipe);
    }

    public List<Recipe> getAllRecipes(){
//        return recipes;
        return recipeRepository.findAll();
    }

    public Recipe getRecipeById(Long id){
//        for (Recipe r : recipes)
//            if (r.getId().equals(id)) {
//                return r;
//            }
//        return null;
        return recipeRepository.findById(id).orElse(null);
    }

    public List<Recipe> searchRecipeByKeyword(String keyword){
        return recipeRepository.findByTitleContainingIgnoreCase(keyword);
    }
}
