/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam.model;

/**
 *
 * @author swa
 */
public class IngredientsList {
    private Ingredient ingredient;
    private Unit unit;
    private Double quantity;
    private Integer id;

    public Ingredient getIngredient() {
        return ingredient;
    }

    public Unit getUnit() {
        return unit;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public IngredientsList(Ingredient ingredient, Unit unit, Double quantity) {
        this.ingredient = ingredient;
        this.unit = unit;
        this.quantity = quantity;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "IngredientsList{" + "ingredient=" + ingredient + ", unit=" + unit + ", quantity=" + quantity + ", id=" + id + '}';
    }

    public IngredientsList() {
    }

   
    
}
