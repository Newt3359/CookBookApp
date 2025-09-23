package swf.army.mil.cookbookapp.recipe;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RecipeServiceTest {

    @Mock RecipeRepository recipeRepository;

    @InjectMocks
    RecipeService recipeService;

    Recipe recipe1 = new Recipe(1L, "Meatloaf", "Loaf of Meat" ,"Ground beef",false);
    private ArrayList<Recipe> recipes = new ArrayList<Recipe>();
    Recipe recipe2 = new Recipe(2L,"Udon", "Udon Noodles with beef", "Noodles and beef",true);

    @Test
    public void shouldSaveRecipe(){
        when(recipeRepository.save(recipe1)).thenReturn(recipe1);

        Recipe actualRecipe = recipeService.saveRecipe(recipe1);

        verify(recipeRepository, times(1)).save(any(Recipe.class));
        assertThat(actualRecipe).isEqualTo(recipe1);
    }

    @Test
    public void shouldGetAllRecipes(){
        recipes.add(recipe1);
        recipes.add(recipe2);
        when(recipeRepository.findAll()).thenReturn(recipes);

        List<Recipe> listAllRecipes = recipeService.getAllRecipes();

        verify(recipeRepository, times(1)).findAll();
        assertThat(listAllRecipes).isEqualTo(recipes);
    }

    @Test
    public void shouldGetRecipeById(){
        when(recipeRepository.findById(1L)).thenReturn(Optional.of(recipe1));

        Recipe actualRecipeId = recipeService.getRecipeById(1L);

        verify(recipeRepository, times(1)).findById(1L);
        assertThat(actualRecipeId).isEqualTo(recipe1);
    }

}