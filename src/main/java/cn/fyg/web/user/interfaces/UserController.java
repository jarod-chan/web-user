package cn.fyg.web.user.interfaces;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.fyg.web.user.service.user.Retv;
import cn.fyg.web.user.service.user.UserService;

@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping("/user_list")
    public ModelAndView getListUsersView() {
        LOGGER.debug("Received request to get user list view");
        ModelMap model = new ModelMap();
        model.addAttribute("users", this.userService.list());
        return new ModelAndView("user_list", model);
    }
    
    @RequestMapping(value = "/user_create", method = RequestMethod.GET)
    public ModelAndView getCreateUserView() {
        LOGGER.debug("Received request for user create view");
        return new ModelAndView("user_create");
    }
    
    @RequestMapping(value = "/user_create", method = RequestMethod.POST)
    public String postCreateUserView(@RequestParam Map<String,Object> map) {
        LOGGER.debug("Received request for user create view");
        Retv<Long> retv = this.userService.create(map);
        return "redirect:/user_list";
    }

}
