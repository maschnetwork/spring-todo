package at.joanneum.swd.esamvc.controller;

import at.joanneum.swd.esamvc.dto.TodoDTO;
import at.joanneum.swd.esamvc.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoController {

    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @RequestMapping("/todos")
    public String getTodos(Model model){
        model.addAttribute("todos", todoService.getTodos());
        return "todos";
    }

    @RequestMapping(value= "/todos/{id}", method = RequestMethod.GET)
    public String getTodo(Model model, @PathVariable int id){
        model.addAttribute("todo", todoService.getTodo(id));
        return "todo_detail";
    }
}
