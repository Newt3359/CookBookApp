package swf.army.mil.cookbookapp.recipe;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.ArrayList;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RecipeController.class)
@AutoConfigureMockMvc
class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockitoBean
    RecipeService recipeService;

    Recipe recipe1 = new Recipe(1L, "Meatloaf", "Loaf of Meat", "Ground beef", false);
    private ArrayList<Recipe> recipes = new ArrayList<Recipe>();
    Recipe recipe2 = new Recipe(2L,"Udon", "Udon Noodles with beef", "Noodles and beef", true);

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldSaveRecipe()throws Exception{
        Mockito.when(recipeService.saveRecipe(any(Recipe.class))).thenReturn(recipe1);
        String recipeJson = objectMapper.writeValueAsString(recipe1);
        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/recipe")
                .contentType(MediaType.APPLICATION_JSON)
                .content(recipeJson))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.favorite").value(false))
                .andExpect(jsonPath("$.title").value("Meatloaf"))
                .andExpect(jsonPath("$.description").value("Loaf of Meat"));
        Mockito.verify(recipeService).saveRecipe(any(Recipe.class));

    }

    @Test
    public void shouldGetAllRecipes()throws Exception{
        recipes.add(recipe1);
        recipes.add(recipe2);
        Mockito.when(recipeService.getAllRecipes()).thenReturn(recipes);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/recipe"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*").isArray());
        Mockito.verify(recipeService).getAllRecipes();
    }

    @Test
    public void shouldGetRecipeById()throws Exception{
        Mockito.when(recipeService.getRecipeById(1L)).thenReturn(recipe1);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/recipe/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
        Mockito.verify(recipeService).getRecipeById(1L);
    }
}