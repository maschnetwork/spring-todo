package at.joanneum.swd.esamvc.controller;

import at.joanneum.swd.esamvc.dto.TodoDTO;
import at.joanneum.swd.esamvc.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoController {

    @Autowired
    TodoService todoService;

    @RequestMapping("/todos")
    public String getTodos(Model model){
        model.addAttribute("todos", todoService.getTodos());
        return "todos";
    }

    @RequestMapping(value="/todo", method= RequestMethod.POST)
    public String addTodo(@ModelAttribute TodoDTO todoDTO){
        todoService.createTodo(todoDTO);
        return "index";
    }
}
