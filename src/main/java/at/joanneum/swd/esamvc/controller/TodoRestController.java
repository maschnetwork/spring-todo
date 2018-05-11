package at.joanneum.swd.esamvc.controller;

import at.joanneum.swd.esamvc.dto.TodoDTO;
import at.joanneum.swd.esamvc.service.TodoService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @RequestMapping(value= "/todo/{id}/status", method = RequestMethod.PUT)
    public ResponseEntity updateTodoDoneStatus(@PathVariable int id, @RequestBody ObjectNode json){
        todoService.updateTodoDoneStatus(id, json.get("done").asBoolean());
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value= "/todo/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateTodo(@PathVariable int id, @RequestBody TodoDTO todoDTO){
        todoService.updateTodo(todoDTO, id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value= "/todo/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTodo(@PathVariable int id){
        todoService.deleteTodo(id);
        return ResponseEntity.ok().build();
    }

}
