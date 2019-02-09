package exam.controller;

import exam.model.*;
import exam.service.*;
import java.util.*;
import org.hibernate.metamodel.relational.ObjectName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @RequestMapping("/")
    public String goHome() {
        return "home";
    }

    @RequestMapping(value = "/recipe/add", method = RequestMethod.GET)
    public String addRecipe(Model model) {
        System.out.println("invoking addRecipe");
        model.addAttribute("Recipe", new Recipe());
        return "recipe_add";
    }

    @ExceptionHandler(Exception.class)
    public String handleError(Model model) {
        model.addAttribute("msg", "Error!");
        return "error_page";
    }

    @RequestMapping(value = "/recipe/add", method = RequestMethod.POST)
    public String saveRecipe(
            @ModelAttribute("Recipe") Recipe recipe,
            @RequestParam(value = "ingr[]", required = false) String[] ingr,
            @RequestParam(value = "quantity[]", required = false) Double[] quantity,
            @RequestParam(value = "unit[]", required = false) String[] unit,
            @RequestParam(value = "proc[]", required = false) String[] proc,
            Model model,
            RedirectAttributes attributes) {
        if (ingr.length < 1 || unit.length < 1) {
            return "error_page";
        }
        recipe.setId(1);
        Set<IngredientsList> ingridients = new HashSet();
        for (int i = 0; i < ingr.length; i++) {
            Ingredient ingri = recipeService.getIngredient(ingr[i]);
            Unit uniti = recipeService.getUnit(unit[i]);
            IngredientsList IListi = new IngredientsList(ingri, uniti, quantity[i]);
            ingridients.add(IListi);
        }
        List<Procedure> procedure = new ArrayList();
        for (int i = 0; i < proc.length; i++) {
            Procedure proci = new Procedure(proc[i]);
            procedure.add(proci);
        }

        recipe.setIngridients(ingridients);
        recipe.setProcedure(procedure);
        if (recipe.getName().length() > 0 && recipe.getName() != null) {
            recipeService.save(recipe);
            attributes.addAttribute("id", recipe.getId());
            return "redirect:/recipe/";
        } else {
            return "error_page";
        }
    }

    @RequestMapping(value = "/recipe")
    public String showRecipe(Model model,
            @RequestParam("id") Integer id) {
        Recipe recipe = recipeService.find(id);
        model.addAttribute("Recipe",
                recipe);
        return "recipe";
    }

    @RequestMapping(value = "/recipe/findall")
    public String shoeTable(Model model) {
        model.addAttribute("recipes",
                recipeService.findAll());
        return "recipes";
    }

    @RequestMapping(value = "/recipe/{id}")
    public @ResponseBody
    Recipe showAnotherRecipe(
            @PathVariable("id") Integer id
    ) {
        Recipe recipe = recipeService.find(id);
        return recipe;
    }

    @RequestMapping(value = "/recipe/delete", method = RequestMethod.POST)
    public String editRecipe(
            @RequestParam("act") String act,
            @RequestParam("id") Integer id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "ingr[]", required = false) String[] ingr,
            @RequestParam(value = "quantity[]", required = false) Double[] quantity,
            @RequestParam(value = "unit[]", required = false) String[] unit,
            @RequestParam(value = "proc[]", required = false) String[] proc
    ) {
        Recipe recipe_new = recipeService.find(id);
        List<Ingredient> listIngr = recipeService.getIngredientsOfRecipe(recipe_new);
        List<Unit> listUnit = recipeService.getUnitsOfRecipe(recipe_new);
        if (act.equals("delete")) {
            recipeService.delete(recipe_new);
            return "delete";
        }
        if (act.equals("edit")) {
            if (name.length() > 0) {
                Set<IngredientsList> ingridients = recipe_new.getIngridients();
                ingridients.clear();
                for (int i = 0; i < ingr.length; i++) {
                    Ingredient ingri = recipeService.getIngredient(ingr[i]);
                    Unit uniti = recipeService.getUnit(unit[i]);
                    IngredientsList IListi = new IngredientsList(ingri, uniti, quantity[i]);
                    ingridients.add(IListi);
                }
                List<Procedure> procedure = recipe_new.getProcedure();
                procedure.clear();
                for (int i = 0; i < proc.length; i++) {
                    Procedure proci = new Procedure(proc[i]);
                    procedure.add(proci);
                }

                recipe_new.setName(name);
                recipe_new.setIngridients(ingridients);
                recipe_new.setProcedure(procedure);
                recipeService.update(recipe_new, listIngr, listUnit);
                return "edit";
            } else {
                return "error_page";
            }

        }
        return "home";
    }

    @RequestMapping(value = "/recipe/search", method = RequestMethod.GET)
    public String search(Model model) {
        return "search";
    }

    @ModelAttribute("ingredients")
    public List<Ingredient> addIngredients() {
        return recipeService.getIngredients();
    }

    @RequestMapping(value = "/recipe/search", method = RequestMethod.POST)
    public String found(Model model, @RequestParam(value = "check[]", required = false) String[] check) {
        if (check == null) {
            return "error_page";
        } else {
            List<String> checked = Arrays.asList(check);
            model.addAttribute("recipes",
                    recipeService.search(checked, "ingredient"));
            return "recipes";
        }
    }

    @RequestMapping(value = "/exit")
    public void exit() {
        this.recipeService.exit();
    }
}
