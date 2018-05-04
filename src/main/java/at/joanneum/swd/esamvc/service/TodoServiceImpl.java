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

    private final TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<TodoDTO> getTodos() {
        return todoRepository.findAll().stream().map(EntityToDTOMapper :: createDTOFromEntity).collect(Collectors.toList());
    }

    @Override
    public TodoDTO getTodo(int id) {
        return EntityToDTOMapper.createDTOFromEntity(todoRepository.findById(id));
    }

    @Override
    public void createTodo(TodoDTO todoDTO) {
        Todo todo = new Todo(todoDTO.name, todoDTO.description, todoDTO.done);
        todoRepository.save(todo);
    }

    @Override
    public void deleteTodo(int id) {
        Todo todo = todoRepository.findById(id);
        todoRepository.delete(todo);
    }

    @Override
    public void updateTodo(TodoDTO todoDTO) {
        Todo todo = todoRepository.findById(todoDTO.id);
        EntityToDTOMapper.createEntityFromDTO(todoDTO);
        todoRepository.save(todo);
    }
}
