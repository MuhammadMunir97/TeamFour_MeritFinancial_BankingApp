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

import com.meritameirca.banking.app.models.AddressType;
import com.meritameirca.banking.app.models.User;
import com.meritameirca.banking.app.models.UserAddress;
import com.meritameirca.banking.app.service.AddressService;
import com.meritameirca.banking.app.service.AddressTypeService;
import com.meritameirca.banking.app.service.UserService;

@Controller
public class AddressController {
	
	private final AddressService addressService;
	private final AddressTypeService addressTypeService;
	private final UserService userService;
	
	public AddressController(AddressService addressService,
			AddressTypeService addressTypeService , UserService userService) {
		this.addressService = addressService;
		this.addressTypeService = addressTypeService;
		this.userService = userService;
	}
	
	@RequestMapping("/updateProfile")
	public String showFormtoUpdateUserInfoAndAddresses(Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/login";
		}else {
			model.addAttribute("user", userService.findUserById(userId));
			return "/view/UpdateProfile.jsp";
		}
	}
	
	@PutMapping("/updateProfile")
	public String updateUserInfoAndAddresses(@Valid  @ModelAttribute("user") User user , BindingResult bindingResult, RedirectAttributes errorRedirect , HttpSession session) {
		if(bindingResult.hasErrors()) {
			errorRedirect.addFlashAttribute("errors", bindingResult.getAllErrors());
			return "/view/UpdateProfile.jsp";
		}else {
			Long userId = (Long) session.getAttribute("userId");
			user.setId(userId);
			userService.registerUser(user);
			return "redirect:/accounts";
		}
	}
	
	@RequestMapping("/addAddress")
	public String newAddress( @ModelAttribute("address") UserAddress userAddress , Model model) {
		model.addAttribute("addressTypes" , addressTypeService.findAllAddressTypes());
		return "/view/AddAddress.jsp";
	}
	
	@PostMapping("/addAddress")
	public String addAddress(@Valid @ModelAttribute("address") UserAddress userAddress  , BindingResult bindingResult ,  RedirectAttributes errorRedirect ,  HttpSession session) {
		if(bindingResult.hasErrors()) {
			errorRedirect.addFlashAttribute("errors", bindingResult.getAllErrors());
			return "/view/AddAddress.jsp";
		}else {
			Long userId = (Long) session.getAttribute("userId");
			userAddress.setUser(userService.findUserById(userId));
			addressService.saveAddress(userAddress);
			return "redirect:/accounts";
		}
	}
}
