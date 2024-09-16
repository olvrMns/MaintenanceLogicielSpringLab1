package edu.mv.db.models;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Table(name = "rocket")
@Entity
public class Rocket {

    @Id
    private int id;

    private String name;

    private String type;

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
