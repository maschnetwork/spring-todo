package at.joanneum.swd.esamvc.service;

import at.joanneum.swd.esamvc.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    List<TodoDTO> getTodos();
    TodoDTO getTodo(int id);
    void createTodo(TodoDTO todoDTO);
    void deleteTodo(int id);
    void updateTodo(TodoDTO todoDTO);


}
