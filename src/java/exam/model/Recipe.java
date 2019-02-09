
package exam.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.xml.bind.annotation.XmlRootElement;
//import org.hibernate.validator.constraints.NotBlank;

public class Recipe {

    Integer id;
    String name;
    Set<IngredientsList> ingridients = new HashSet();
    List<Procedure> procedure = new ArrayList();

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<IngredientsList> getIngridients() {
        return ingridients;
    }

    public List<Procedure> getProcedure() {
        return procedure;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngridients(Set<IngredientsList> ingridients) {
        this.ingridients = ingridients;
    }

    public void setProcedure(List<Procedure> procedure) {
        this.procedure = procedure;
    }






    public Recipe() {
    }

    @Override
    public String toString() {
        return "Recipe{" + "id=" + id + ", name=" + name + ", ingridients=" + ingridients + ", procedure=" + procedure + '}';
    }

}
