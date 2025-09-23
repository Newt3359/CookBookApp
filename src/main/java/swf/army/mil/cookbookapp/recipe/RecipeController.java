package swf.army.mil.cookbookapp.recipe;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/recipe")
public class RecipeController {


//    ArrayList<Recipe> recipes = new ArrayList<Recipe>();
//    Recipe recipe1 = new Recipe(1L, false, "Meatloaf", "Loaf of Meat");

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService){
        this.recipeService = recipeService;
    }

    @PostMapping
    public Recipe shouldSaveRecipe(@RequestBody Recipe recipe){

        return recipeService.saveRecipe(recipe);
//        return recipe1;
    }

    @GetMapping
    public List<Recipe> getAllRecipes(){
//        recipes.add(recipe1);
//        return recipes;
        return recipeService.getAllRecipes();
    }

    @GetMapping("/{id}")
    public Recipe getRecipeById (@PathVariable Long id){
//        return recipe1;
        return recipeService.getRecipeById(id);
    }
}
