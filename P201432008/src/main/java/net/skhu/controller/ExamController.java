package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.model.Pagination;
import net.skhu.service.CustomerService;
import net.skhu.service.PurchaseOrderDetailService;

@Controller
@RequestMapping("exam")
public class ExamController {

	@Autowired CustomerService customerService;
	@Autowired PurchaseOrderDetailService purchaseOrderDetailService;
	
	@RequestMapping("list5")
	public String list5(Model model) {
		model.addAttribute("list", customerService.findAll());
		return "exam/list5";
	}
	
	@RequestMapping("list6")
	public String list6(Model model) {
		model.addAttribute("list", purchaseOrderDetailService.findAll());
		return "exam/list6";
	}
	
	@RequestMapping("list7")
	public String list7(Pagination pagination, Model model) {
		model.addAttribute("list", customerService.findAll(pagination));
		model.addAttribute("orderBy", customerService.getOrderByOptions());
        model.addAttribute("searchBy", customerService.getSearchByOptions());
		return "exam/list7";
	}
}
