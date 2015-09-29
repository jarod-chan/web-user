package cn.fyg.web.user.interfaces.module.user;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.fyg.web.user.interfaces.shared.AppConstant;
import cn.fyg.web.user.service.user.Retv;
import cn.fyg.web.user.service.user.UserDto;
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
    public String postCreateUserView(@RequestParam Map<String,Object> map,RedirectAttributes redirectAttributes) {
        LOGGER.debug("Received request for user create view");
        Retv<Long> retv = this.userService.create(map);
        if(retv.fail()){
        	redirectAttributes.addFlashAttribute(AppConstant.MESSAGE_NAME, retv.getInfo());
        }
        return "redirect:/user_list";
    }
    
    @RequestMapping(value = "/user_edit", method = RequestMethod.GET)
    public String userEdit(@RequestParam("id") Long id, Map<String,Object> map) {
        LOGGER.debug("Received request for user create view");
        Retv<UserDto> retv = this.userService.find(id);
        map.put("user", retv.getData());
        return "user_edit";
    }
    
	@RequestMapping(value = "/user_edit/{id}", method = RequestMethod.POST)
	public String userUpdate(@PathVariable("id") Long id, @RequestParam Map<String, Object> map,
			RedirectAttributes redirectAttributes) {
		Retv<UserDto> retv = this.userService.update(id, map);
		if (retv.fail()) {
			redirectAttributes.addFlashAttribute(AppConstant.MESSAGE_NAME, retv.getInfo());
		}
		return "redirect:/user_list";
	}
	
	@RequestMapping(value="user_changestate",method=RequestMethod.POST)
	public String changeState(@RequestParam("id") Long id, @RequestParam("state")String state,RedirectAttributes redirectAttributes){
		Retv<Void> retv = this.userService.changeState(id, state);
		if(retv.fail()){
			redirectAttributes.addFlashAttribute(AppConstant.MESSAGE_NAME, retv.getInfo());
		}
		return "redirect:/user_list";
	}
	
	@RequestMapping(value="user_password",method=RequestMethod.GET)
	public String userPassword(@RequestParam("id") Long id, Map<String,Object> map){
		Retv<UserDto> retv = this.userService.find(id);
	    map.put("user", retv.getData());
		return "user_password";
	}
	
	@RequestMapping(value="user_password/{id}",method=RequestMethod.POST)
	public String changePassword(@PathVariable("id") Long id,@RequestParam("password")String password,RedirectAttributes redirectAttributes){
		Retv<Void> retv = this.userService.resetPassword(id, password);
		if(retv.fail()){
			redirectAttributes.addFlashAttribute(AppConstant.MESSAGE_NAME, retv.getInfo());
		}
		return "redirect:/user_list";
	}
}
