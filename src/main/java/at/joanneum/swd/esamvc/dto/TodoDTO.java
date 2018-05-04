package at.joanneum.swd.esamvc.dto;

import at.joanneum.swd.esamvc.entity.Todo;

public class TodoDTO {

    private int id;
    private String name;
    private String description;
    private Boolean done;

    public TodoDTO(String name, String description){
        this.name = name;
        this.description = description;
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
