package at.joanneum.swd.esamvc.utility;

import at.joanneum.swd.esamvc.dto.TodoDTO;
import at.joanneum.swd.esamvc.entity.Todo;

public  class EntityToDTOMapper {

    public static TodoDTO createDTOFromEntity(Todo todo){
        return new TodoDTO(todo.getName(), todo.getDescription());
    }
}


