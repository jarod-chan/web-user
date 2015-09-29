package cn.fyg.web.user.interfaces.module.app;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.fyg.web.user.interfaces.shared.AppConstant;
import cn.fyg.web.user.service.app.AppDto;
import cn.fyg.web.user.service.app.AppService;
import cn.fyg.web.user.service.appuser.AppuserService;
import cn.fyg.web.user.service.user.Retv;
import cn.fyg.web.user.service.user.UserDto;

@Controller
@RequestMapping(value = "app")
public class AppController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);

	@Autowired
	AppService appService;

	@RequestMapping("list")
	public String toList(Map<String, Object> map) {
		LOGGER.debug("Received request to get all app");
		List<AppDto> list = this.appService.list();
		map.put("apps", list);
		return "app/list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String toCreate() {
		return "app/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@RequestParam Map<String, Object> map, RedirectAttributes redirectAttributes) {
		Retv<Long> retv = this.appService.create(map);
		if (retv.fail()) {
			redirectAttributes.addFlashAttribute(AppConstant.MESSAGE_NAME, retv.getInfo());
		}
		return "redirect:/app/list";
	}

	@RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
	public String toEdit(@PathVariable("id") Long id, Map<String, Object> map) {
		Retv<AppDto> retv = this.appService.find(id);
		map.put("app", retv.getData());
		return "app/edit";
	}

	@RequestMapping(value = "{id}/edit", method = RequestMethod.POST)
	public String edit(@PathVariable("id") Long id, @RequestParam Map<String, Object> map,
			RedirectAttributes redirectAttributes) {
		Retv<AppDto> retv = this.appService.update(id, map);
		if (retv.fail()) {
			redirectAttributes.addFlashAttribute(AppConstant.MESSAGE_NAME, retv.getInfo());
		}
		return "redirect:/app/list";
	}

	@RequestMapping(value = "{id}/delete", method = RequestMethod.POST)
	public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		Retv<Void> retv = this.appService.delete(id);
		if (retv.fail()) {
			redirectAttributes.addFlashAttribute(AppConstant.MESSAGE_NAME, retv.getInfo());
		}
		return "redirect:/app/list";
	}
	
	@Autowired
	AppuserService appuserService;

	@RequestMapping(value = "{id}/appuser", method = RequestMethod.GET)
	public String toAppUser(@PathVariable("id") Long id, Map<String, Object> map,
			RedirectAttributes redirectAttributes) {
		List<UserDto> users = this.appuserService.appUser(id);
		map.put("users", users);
		return "app/appuser";
	}
}
