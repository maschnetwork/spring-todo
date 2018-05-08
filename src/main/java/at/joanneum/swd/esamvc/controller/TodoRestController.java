package at.joanneum.swd.esamvc.controller;


import at.joanneum.swd.esamvc.dto.TodoDTO;
import at.joanneum.swd.esamvc.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoRestController {

    private TodoService todoService;

    @Autowired
    public TodoRestController (TodoService todoService){
        this.todoService = todoService;
    }

    @RequestMapping(value= "/todo", method = RequestMethod.POST)
    public ResponseEntity createTodo(@RequestBody TodoDTO todoDTO){
        todoService.createTodo(todoDTO);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value= "/todo", method = RequestMethod.PUT)
    public ResponseEntity updateTodo(@RequestBody TodoDTO todoDTO){
        todoService.updateTodo(todoDTO);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value= "/todo", method = RequestMethod.DELETE)
    public ResponseEntity deleteTodo(int todoId){
        todoService.deleteTodo(todoId);
        return ResponseEntity.ok().build();
    }

}
