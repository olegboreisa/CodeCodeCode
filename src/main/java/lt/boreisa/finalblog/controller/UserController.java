package lt.boreisa.finalblog.controller;

import lt.boreisa.finalblog.model.Role;
import lt.boreisa.finalblog.model.User;
import lt.boreisa.finalblog.repository.RoleRepo;
import lt.boreisa.finalblog.repository.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
//@RequestMapping("/public")
public class UserController {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    public UserController(UserRepo userRepo, RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }
    // [SIGN UP]
    @RequestMapping(path = "/public/login")
    public String login() {
        return "user/signup";
    }

    @RequestMapping(path = "/public/login-error")
    public String loginError (Model model) {
        model.addAttribute("loginError", true);
        return "user/signup";
    }

//    // [SIGN OUT]
//    @RequestMapping(path = "/public/logout")
//    public String logout() {
//        return "user/signup";
//    }

    // [REGISTER]
    @RequestMapping(path = "/public/register", method = RequestMethod.GET)
    public String addUser (@ModelAttribute (name = "user") User user, Model model) {
        //[FIND ROLES]
        List<Role> getRoles = roleRepo.findAll();
        model.addAttribute("roles", getRoles);
        return "user/register";
    }

    @RequestMapping(path = "/public/registered", method = RequestMethod.POST)
    public String addUsers (@Valid @ModelAttribute ("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<Role> getRoles = roleRepo.findAll();
            model.addAttribute("roles", getRoles);
            return "user/register";
        }
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
//        user.setPassword(encoder.encode(user.getPassword()));
//        user.setMatchPassword(encoder.encode(user.getMatchPassword()));
        userRepo.save(user);
        return "redirect:/public/login";
    }
}
