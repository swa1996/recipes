package exam.service;

import exam.model.*;
import exam.repository.RecipeRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("recipeService")
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public RecipeService() {
    }

    public List<Recipe> findAll() {
        return recipeRepository.getRecipes();
    }

    public Recipe find(Integer id) {
        System.out.println(recipeRepository.getRecipe(id));
        return recipeRepository.getRecipe(id);
    }

    public void save(Recipe recipe) {
        recipeRepository.saveRecipe(recipe);
    }

    public void delete(Recipe recipe) {
        recipeRepository.delete(recipe);
        Set<IngredientsList> iList = recipe.getIngridients();
        for (IngredientsList i : iList) {
            Ingredient i1 = i.getIngredient();
            if (this.search(Arrays.asList(i1.getDescription()), "ingredient").isEmpty()) {
                recipeRepository.delete(i1);
            }
            Unit u1 = i.getUnit();
            if (this.search(Arrays.asList(u1.getUnit()), "unit").isEmpty()) {
                recipeRepository.delete(u1);
            }
        }
    }

    public Recipe create(Integer id, String name) {
        Recipe recipe = new Recipe();
        recipe.setId(id);
        recipe.setName(name);
        return recipe;
    }


    public void update(Recipe newR, List<Ingredient> ingr, List<Unit> unit) {
        ingr.removeAll(this.getIngredientsOfRecipe(newR));
        unit.removeAll(this.getUnitsOfRecipe(newR));
        recipeRepository.update(newR);
        for (Ingredient i : ingr) {
            if (this.search(Arrays.asList(i.getDescription()), "ingredient").isEmpty()) {
                recipeRepository.delete(i);
            }
        }
        for (Unit u : unit) {
            if (this.search(Arrays.asList(u.getUnit()), "unit").isEmpty()) {
                recipeRepository.delete(u);
            }
        }
    }

    public List<Ingredient> getIngredients() {
        return recipeRepository.getIngridients();
    }

    public List<Recipe> search(List<String> strings, String what) {
        List<Recipe> result = new ArrayList();
        for (Recipe recipe : recipeRepository.getRecipes()) {
            List<String> inlist = new ArrayList();
            for (IngredientsList il : recipe.getIngridients()) {
                if (what.equals("ingredient")) {
                    inlist.add(il.getIngredient().getDescription());
                }
                if (what.equals("unit")) {
                    inlist.add(il.getUnit().getUnit());
                }
            }
            if (inlist.containsAll(strings)) {
                result.add(recipe);
            }
        }
        return result;
    }

    public Ingredient getIngredient(String a) {
        Ingredient i = recipeRepository.getIngredient(a);
        if (i == null) {
            i = new Ingredient(a);
            recipeRepository.saveRecipe(i);
        }
        return i;
    }

    public Unit getUnit(String a) {
        Unit u = recipeRepository.getUnit(a);
        if (u == null) {
            u = new Unit(a);
            recipeRepository.saveRecipe(u);
        }
        return u;
        }
      

    public void exit() {
        this.recipeRepository.closeSession();
    }

    public List<Ingredient> getIngredientsOfRecipe(Recipe recipe) {
        List<Ingredient> res = new ArrayList();
        for (IngredientsList il : recipe.getIngridients()) {
            res.add(il.getIngredient());
        }
        return res;
    }

    public List<Unit> getUnitsOfRecipe(Recipe recipe) {
        List<Unit> res = new ArrayList();
        for (IngredientsList il : recipe.getIngridients()) {
            res.add(il.getUnit());
        }
        return res;
    }
}
