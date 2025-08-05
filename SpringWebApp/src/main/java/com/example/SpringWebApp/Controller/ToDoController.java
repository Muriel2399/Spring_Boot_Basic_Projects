package com.example.SpringWebApp.Controller;

import com.example.SpringWebApp.ToDo;
import com.example.SpringWebApp.ToDoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class ToDoController {
    @Autowired
private ToDoService toDoService;
    @RequestMapping("list-todos")
    public String getToDos( ModelMap model) {
       List<ToDo> todos = toDoService.findByUserName("Muriel");
       System.out.println(todos);
       model.addAttribute("todo", todos);
       return "listTodos";
     }

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showAddTodoPage(ModelMap model) {
        model.addAttribute("todo", new ToDo(0,  (String) model.get("name"), "Default Description",LocalDate.now().plusYears(1), false));
        return "Todo";
    }




    @RequestMapping(value="/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Valid ToDo todo, BindingResult result) {

        System.out.println("result.hasErrors() "+ result.hasErrors());
         if(result.hasErrors()) {

             return "Todo";
         }
         String username = (String) model.get("name");
         toDoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);
        return "redirect:list-todos";
    }
    @RequestMapping("delete-todo")
    public String deleteToDo( @RequestParam int id) {
        toDoService.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping("update-todo")
    public String showUpdateToDo(ModelMap model, @RequestParam int id) {
        ToDo todo = toDoService.findById(id);
        System.out.println("updateToDo todo "+todo);
      model.addAttribute("todo", todo);
        return "Todo";
    }

    @RequestMapping(value="update-todo", method = RequestMethod.POST)
    public String updateToDo(ModelMap model, @Valid ToDo todo, BindingResult result) {
     System.out.println("result.hasErrors() "+ result.hasErrors());
        if(result.hasErrors()) {

            return "Todo";
        }
        String username = (String) model.get("name");
        todo.setUsername(username);

        toDoService.updateTodo(todo);
        return "redirect:list-todos";
    }
}
