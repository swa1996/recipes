package exam.repository;

import exam.model.*;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("recipeRepository")
@Transactional
public class RecipeRepository {

    private Session session;

    public RecipeRepository() throws Exception {
        this.session = HibUtil.getSession();
    }

    public List<Recipe> getRecipes() {
        Query q1 = session.createQuery("from Recipe order by id");
        List<Recipe> res1 = q1.list();
        return res1;
    }
public Recipe getRecipe(Integer id){
           Query q1 = session.createQuery("from Recipe where id=:value");
           q1.setParameter("value", id);
           Recipe res = (Recipe)q1.uniqueResult();
        return res;
}
    public List<Ingredient> getIngridients() {
        Query q1 = session.createQuery("from Ingredient order by id");
        List<Ingredient> res1 = q1.list();
        return res1;
    }
public Ingredient getIngredient(String a){
           Query q1 = session.createQuery("from Ingredient where description=:value");
           q1.setParameter("value", a);
           Ingredient res = (Ingredient)q1.uniqueResult();
        return res;
}
public Unit getUnit(String a){
           Query q1 = session.createQuery("from Unit where unit=:value");
           q1.setParameter("value", a);
           Unit res = (Unit)q1.uniqueResult();
        return res;
}

    public void saveRecipe(Object recipe) {
        this.session.beginTransaction();
        this.session.save(recipe);
        this.session.getTransaction().commit();
    }

    public void delete(Object recipe) {
        this.session.beginTransaction();
        this.session.delete(recipe);
        this.session.getTransaction().commit();
    }
    public void update(Object recipe) {
        this.session.beginTransaction();
        this.session.update(recipe);
        this.session.getTransaction().commit();
    }

    public void closeSession() {
        this.session.close();
        System.exit(0);
    }
}
