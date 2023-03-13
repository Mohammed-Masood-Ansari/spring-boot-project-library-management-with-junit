package com.jsp.librarymanagementsystemspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.librarymanagementsystemspringboot.dto.Admin;
import com.jsp.librarymanagementsystemspringboot.dto.ResponseStructure;
import com.jsp.librarymanagementsystemspringboot.service.AdminService;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@RestController
public class AdminController extends HttpServlet{

	@Autowired
	HttpServletRequest httpServletRequest;

	@Autowired
	HttpSession httpSession ;

	@Autowired
	AdminService adminService;

	@PostMapping(value = "/saveAdmin")
	public ResponseStructure<Admin> saveAdmin(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}

	@GetMapping(value = "/loginAdmin/{adminName}/{adminEmail}")
	public String loginAdmin(@PathVariable String adminName, @PathVariable String adminEmail) {

		List<Admin> admins = adminService.getAllAdmins();

		for (Admin admin : admins) {
			
			if((admin.getAdminName().equalsIgnoreCase(adminName))&&(admin.getAdminEmail().equalsIgnoreCase(adminEmail))) {
				
				httpSession.setAttribute("adminEmail", adminName);
				
				return "admin logged in successfully";
				
			}else {
				return "Please Check Your UserName and Password";
			}
		}
		return null;
	}
	
	@GetMapping(value = "/logoutAdmin")
	public String logoutAdmin() {
		
		if(httpSession.getAttribute("adminEmail")!=null){
			
			httpSession.invalidate();
			
			return "admin logout successfully";
		}else {
			return "please login again then logout";
		}
	}
}
