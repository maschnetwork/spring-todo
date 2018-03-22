package at.joanneum.swd.esamvc.dto;

import at.joanneum.swd.esamvc.entity.Todo;

public class TodoDTO {

    private int id;

    private String name;
    private String description;
    private Boolean done;
    public TodoDTO(Todo todo){
        this.id = todo.getId();
        this.name = todo.getName();
        this.done = todo.getDone();
        this.description = todo.getDescription();
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getDone() {
        return done;
    }

    public String getName() {
        return name;
    }
}
