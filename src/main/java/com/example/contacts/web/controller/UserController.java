package pers.contacts.web.controller;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pers.contacts.core.security.Md5PasswordService;
import pers.contacts.core.security.UserContext;
import pers.contacts.entity.User;
import pers.contacts.service.UserService;
import pers.contacts.util.QRCodeUtils;
import pers.contacts.util.VCardUtils;
import pers.contacts.web.AjaxResult;

/**
 * 用户
 *
 * @author 李海涛 2016年8月25日
 */
@Controller
@RequestMapping("/users")
public class UserController {
	@Resource
	private UserService userService;

	/**
	 * 保存用户
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ModelAndView saveUser(User user) {
		Md5PasswordService md5PasswordService = new Md5PasswordService();
		user.setPassword(md5PasswordService.encryptPassword(user.getPassword()));
		user.setDate(new Date());
		User saveUser = userService.saveUser(user);
		ModelAndView mav = new ModelAndView();
		if (saveUser != null) {
			mav.setViewName("redirect:/users/success");
		} else {
			mav.setViewName("/404");
		}
		return mav;
	}
	
	/**
	 * 跳转到注册成功页面
	 * @return
	 */
	@RequestMapping("/success")
	public ModelAndView toSuccess() {
		ModelAndView mav = new ModelAndView("/success");
		return mav;
	}
	
	@RequestMapping("/findCurUser")
	@ResponseBody
	public AjaxResult findCurUser() {
		return AjaxResult.objectResult(UserContext.getCurUser());
	}
	
	@RequestMapping(value = "/{id}/qrcode", method = RequestMethod.GET)
	public void getQRCode(@PathVariable Long id, HttpServletResponse response) {
		User user = UserContext.getCurUser();
		ServletOutputStream sos = null;
		try {
			sos = response.getOutputStream();
			QRCodeUtils.encodeToStream(VCardUtils.format(user.getName(), user.getPhone(), user.getEmail(),
					user.getAddress(), user.getCompany(), user.getJob(), user.getBirthday()), sos, 260,
					260);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				sos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
