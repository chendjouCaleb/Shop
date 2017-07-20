package fr.shop.entity;

/**
 * Created by Chendjou on 20/07/2017.
 */

public class Category {
    private int id;
    private String name;
    public Category(){}
    public Category(int id, String name){
        setId(id);
        setName(name);
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

    @Override
    public boolean equals(Object obj) {
        return id == ((Category) obj).getId();
    }
}
