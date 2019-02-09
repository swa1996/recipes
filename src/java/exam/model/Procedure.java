/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam.model;

import java.util.Comparator;

/**
 *
 * @author swa
 */
public class Procedure {
    private String procedure;
private Integer id;

    public String getProcedure() {
        return procedure;
    }


    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public Procedure() {
    }

    public Procedure(String procedure) {
        this.procedure = procedure;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Procedure{" + "procedure=" + procedure + '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

    
