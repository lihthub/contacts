package com.example.contacts.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.contacts.entity.Linkman;
import com.example.contacts.manager.security.UserContext;
import com.example.contacts.service.LinkmanService;
import com.example.contacts.util.QRCodeUtils;
import com.example.contacts.util.VCardUtils;
import com.example.contacts.web.AjaxResult;

/**
 * 联系人
 *
 * @author 李海涛 2016年8月25日
 */
@Controller
@RequestMapping("/linkmen")
public class LinkmanController {
	@Resource
	private LinkmanService linkmanService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult saveLinkman(Linkman linkman) {
		linkman.setUser(UserContext.getCurUser());
		linkman.setDate(new Date());
		linkmanService.save(linkman);
		return AjaxResult.successResult();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public AjaxResult deleteLinkman(@PathVariable Long id) {
		linkmanService.delete(id);
		return AjaxResult.successResult();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult findLinkmen(String name) {
		List<Linkman> linkmen = linkmanService.findAll(name);
		return AjaxResult.objectResult(linkmen);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult findlinkman(@PathVariable Long id) {
		Linkman linkman = linkmanService.findOne(id);
		return AjaxResult.objectResult(linkman);
	}
	
	@RequestMapping(value = "/{id}/qrcode", method = RequestMethod.GET)
	public void getQRCode(@PathVariable Long id, HttpServletResponse response) {
		Linkman linkman = linkmanService.findOne(id);
		ServletOutputStream sos = null;
		try {
			sos = response.getOutputStream();
			QRCodeUtils.encodeToStream(VCardUtils.format(linkman.getName(), linkman.getPhone(), linkman.getEmail(),
					linkman.getAddress(), linkman.getCompany(), linkman.getJob(), linkman.getBirthday()), sos, 260,
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
