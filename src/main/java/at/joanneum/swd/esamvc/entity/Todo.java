package at.joanneum.swd.esamvc.entity;

import javax.persistence.*;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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

    public void setName(String name) {
        this.name = name;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
