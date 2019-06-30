package pers.contacts.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pers.contacts.core.security.UserContext;
import pers.contacts.util.I18nUtils;

/**
 * 首页、用户登录页
 *
 * @author 李海涛 2016年8月25日
 */
@Controller
@RequestMapping
public class IndexController {
	
	/**
	 * 主页
	 * @return
	 */
	@RequestMapping
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("curUser", UserContext.getCurUser());
		mav.addObject("title", I18nUtils.getPageTitle("index.title"));
		return mav;
	}
	
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("curUser", UserContext.getCurUser());
		mav.addObject("title", I18nUtils.getPageTitle("index.title"));
		return mav;
	}
	
	/**
	 * 登录页
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		if (UserContext.getCurUser() != null) {
			mav.setViewName("redirect:/index");
		} else {
			mav.setViewName("login");
			mav.addObject("title", I18nUtils.getPageTitle("login.title"));
		}
		return mav;
	}
	
	/**
	 * 注册页
	 * @return
	 */
	@RequestMapping("/register")
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("title", I18nUtils.getPageTitle("register.title"));
		return mav;
	}
	
	/**
	 * 404页面
	 * @param msg
	 * @return
	 */
	@RequestMapping("/404")
	public ModelAndView noPage(String msg){
		ModelAndView mav = new ModelAndView("/404");
		return mav;
	}
	
	/**
	 * 注销
	 * @return
	 */
	@RequestMapping("/logout")
	public ModelAndView logout() {
		UserContext.logout();
		ModelAndView mav = new ModelAndView("redirect:/login");
		return mav;
	}
	
}
