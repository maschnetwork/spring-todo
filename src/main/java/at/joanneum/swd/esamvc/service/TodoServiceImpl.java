package at.joanneum.swd.esamvc.service;

import at.joanneum.swd.esamvc.dto.TodoDTO;
import at.joanneum.swd.esamvc.entity.Todo;
import at.joanneum.swd.esamvc.repository.TodoRepository;
import at.joanneum.swd.esamvc.utility.EntityToDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;


    @Override
    public List<TodoDTO> getTodos() {
        List<TodoDTO> todoDTOList = todoRepository.findAll().stream().map(EntityToDTOMapper :: createDTOFromEntity).collect(Collectors.toList());

        return todoDTOList;
    }

    @Override
    public TodoDTO getTodo(int id) {
        TodoDTO todoDTO = new TodoDTO("", "");
        todoDTO.getEntityFromDTO(todoRepository.findById(id));
        return todoDTO;
    }

    @Override
    public void createTodo(TodoDTO todoDTO) {
        Todo todo = new Todo(todoDTO.getName(), todoDTO.getDescription(), todoDTO.getDone());
        todoRepository.save(todo);
    }

    @Override
    public void deleteTodo(int id) {
        Todo todo = todoRepository.findById(id);
        todoRepository.delete(todo);
    }

    @Override
    public void updateTodo(TodoDTO todoDTO) {
        Todo todo = todoRepository.findById(todoDTO.getId());
        todo.setName(todoDTO.getName());
        todo.setDescription(todoDTO.getDescription());
        todo.setDone(todoDTO.getDone());

        todoRepository.save(todo);
    }
}
