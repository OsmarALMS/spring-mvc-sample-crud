package br.com.sample.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.sample.model.User;
import br.com.sample.services.UserService;

@Controller
@RequestMapping("/mvc/users")
public class UsersController {
    
	@Autowired
    UserService userService;

    @RequestMapping(method=RequestMethod.GET)
    public String users(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users/users";
    }

    @RequestMapping(params="new", method=RequestMethod.GET)
    public String userAddView(Model model) {
        model.addAttribute(new User());
        return "users/edit";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addUserFromForm(@Valid User user, BindingResult bindingResult, @RequestParam(value="action", required=true) String action) {
        if (action.equals("save")) {
            if (bindingResult.hasErrors()) {
                return "users/edit";
            }
            user.setIsDeleted(!user.getIsDeleted());
            userService.add(user);
        }

        if (action.equals("delete")) {
            userService.delete(user);

        }
        return "redirect:/mvc/users";
    }



    @RequestMapping(value = "/edit/{userId}", method=RequestMethod.GET)
     public String userEditView(@PathVariable("userId") long userId, Model model) {
        User user = userService.get(userId);
        user.setIsDeleted(!user.getIsDeleted());
        model.addAttribute("user", user);
        return "users/edit";
    }


    @RequestMapping(value = "/edit/{userId}", method=RequestMethod.POST)
    public String userUpdate(@PathVariable("userId") long userId, Model model, @Valid User user, BindingResult bindingResult,  @RequestParam(value="action", required=true) String action ) {
        addUserFromForm(user, bindingResult, action);
        return "redirect:/mvc/users";
    }


    @RequestMapping(value = "/delete/{userId}", method=RequestMethod.GET)
    public String userDeleteView(@PathVariable("userId") long userId, Model model) {
        model.addAttribute("user", userService.get(userId));
        return "users/delete";
    }

    @RequestMapping(value = "/delete/{userId}", method=RequestMethod.POST)
    public String userDelete(@PathVariable("userId") long userId, Model model, @Valid User user, BindingResult bindingResult,  @RequestParam(value="action", required=true) String action ) {
        addUserFromForm(user, bindingResult, action);
        return "redirect:/mvc/users";
    }

    @RequestMapping(value = "/content",  method=RequestMethod.GET)
    public String testContent() {
        return "content";
    }

}
