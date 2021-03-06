package entities;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Jesus Larez
 */
@Embeddable
public class CocktailRecipeAndDescription implements Serializable{
    
    private String description;
    private String recipe;

    public CocktailRecipeAndDescription(String description, String recipe) {
        this.description = description;
        this.recipe = recipe;
    }

    public CocktailRecipeAndDescription() {
    }
    
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }
    
    
}
