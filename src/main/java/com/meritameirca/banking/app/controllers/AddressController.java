package com.meritameirca.banking.app.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.meritameirca.banking.app.models.User;
import com.meritameirca.banking.app.models.UserAddress;
import com.meritameirca.banking.app.service.AddressService;
import com.meritameirca.banking.app.service.UserService;

@Controller
public class AddressController {
	
	private final AddressService addressService;
	private final UserService userService;
	
	public AddressController(AddressService addressService, UserService userService) {
		this.addressService = addressService;
		this.userService = userService;
	}
	
	@RequestMapping("/updateProfile")
	public String showFormtoUpdateUserInfoAndAddresses(Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/login";
		}else {
			User user = userService.findUserById(userId);
			model.addAttribute("user", user);
			if(user.getUserAddress().getId() != null) {
				session.setAttribute("addressId", user.getUserAddress().getId());
			}
			return "/view/UpdateProfile.jsp";
		}
	}
	
	@PutMapping("/updateProfile")
	public String updateUserInfoAndAddresses(@Valid  @ModelAttribute("user") User user , BindingResult bindingResult, RedirectAttributes errorRedirect , HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/login";
		}else {
			if(bindingResult.hasErrors()) {
				errorRedirect.addFlashAttribute("errors", bindingResult.getAllErrors());
				return "/view/UpdateProfile.jsp";
			}else {
				user.setId(userId);
				Long addressId = (Long) session.getAttribute("addressId");
				if(addressId == null) {
					user.getUserAddress().setUser(user);
					addressService.saveAddress(user.getUserAddress());
				}else {
					user.getUserAddress().setId(addressId);
					addressService.saveAddress(user.getUserAddress());
				}
				userService.registerUser(user);
				return "redirect:/accounts";
			}
		}
	}
}
