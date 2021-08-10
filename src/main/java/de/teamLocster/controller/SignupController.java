package de.teamLocster.controller;

import de.teamLocster.user.SignupUser;
import de.teamLocster.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Transactional
@Controller
public class SignupController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView showSignupForm (
            Model model
    ) {
        model.addAttribute("title", "Locster.de.SignUp");
        model.addAttribute(new SignupUser());
        return new ModelAndView("signup");
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ModelAndView signUp(
            @ModelAttribute @Valid SignupUser userDto,
            Errors errors,
            Model model
    ) {
        if (errors.hasErrors()) {
            return new ModelAndView("signup");
        }
        else {
            try {
                userService.registerNewUser(userDto);
                return new ModelAndView("login");
            } catch (Exception uaeEx) { // TODO UserAlreadyExistException
                ModelAndView mav = new ModelAndView("signup");
                mav.addObject("message", "Für diese Email-Adresse existiert bereits ein Profil.");
                System.out.println(uaeEx); // TODO LOGGING
                return mav;
            }
        }
    }
}
