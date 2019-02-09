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
@XmlRootElement(name="Unit")
public class Unit {
    Integer id;
    String unit;

    public Integer getId() {
        return id;
    }

    public String getUnit() {
        return unit;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Unit() {
    }

    public Unit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Unit{" + "id=" + id + ", unit=" + unit + '}';
    }
    
}
