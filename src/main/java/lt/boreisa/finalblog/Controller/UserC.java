package lt.boreisa.finalblog.Controller;

import lt.boreisa.finalblog.Model.Role;
import lt.boreisa.finalblog.Model.User;
import lt.boreisa.finalblog.Repository.RoleRepo;
import lt.boreisa.finalblog.Repository.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserC {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    public UserC(UserRepo userRepo, RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    @RequestMapping(path = "/log", method = RequestMethod.GET)
    public String getLog () {
        return "user/signup";
    }

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String addUser (@ModelAttribute (name = "user") User user, Model model) {
        //[FIND ROLES]
        List<Role> getRoles = roleRepo.findAll();
        model.addAttribute("roles", getRoles);
        return "user/register";
    }

    @RequestMapping(path = "/registered", method = RequestMethod.POST)
    public String addUsers (@Valid @ModelAttribute ("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<Role> getRoles = roleRepo.findAll();
            model.addAttribute("roles", getRoles);
            return "user/register";
        }
        userRepo.save(user);
        return "redirect:/log";
    }
}
