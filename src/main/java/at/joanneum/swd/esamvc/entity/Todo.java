package at.joanneum.swd.esamvc.entity;

import javax.persistence.*;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private Boolean done;

    @Column
    private String description;

    public Todo(String name, String description, Boolean done) {
        this.name = name;
        this.done = done;
        this.description = description;
    }

    //Default Constructor for JPA
    protected Todo(){

    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getDone() {
        return done;
    }
}
