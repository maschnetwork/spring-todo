package at.joanneum.swd.esamvc.controller;

import at.joanneum.swd.esamvc.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @Autowired
    TodoService todoService;

    @RequestMapping("/todo")
    public void getTodos(){

    }
}
