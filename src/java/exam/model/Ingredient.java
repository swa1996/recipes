/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author swa
 */
@XmlRootElement(name="Ingredient")
public class Ingredient {
     String description;
    Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Ingredient(String description) {
        this.description = description;
    }

    public Ingredient() {
    }

    @Override
    public String toString() {
        return "Ingredient{" + "description=" + description + ", id=" + id + '}';
    }

}
