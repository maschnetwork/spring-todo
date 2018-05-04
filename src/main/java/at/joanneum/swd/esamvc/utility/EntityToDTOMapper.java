package at.joanneum.swd.esamvc.utility;

import at.joanneum.swd.esamvc.dto.TodoDTO;
import at.joanneum.swd.esamvc.entity.Todo;

public  class EntityToDTOMapper {

    public static TodoDTO createDTOFromEntity(Todo todo){
        TodoDTO todoDTO = new TodoDTO();
        todoDTO.id = todo.getId();
        todoDTO.name = todo.getName();
        todoDTO.description = todo.getDescription();
        todoDTO.done = todo.getDone();

        return todoDTO;
    }

    public static Todo createEntityFromDTO(TodoDTO todoDTO){
        Todo todo = new Todo(todoDTO.name,todoDTO.description, todoDTO.done);
        return todo;
    }
}


