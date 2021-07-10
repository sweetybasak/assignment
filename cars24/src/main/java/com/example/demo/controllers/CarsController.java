package com.example.demo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Cars;

import com.example.demo.repository.CarsRepository;


@Controller
public class CarsController {
	

	@Autowired
	private Cars cars;
	@Autowired
	private CarsRepository repo;
	@RequestMapping(value="/cars",method=RequestMethod.GET)
	public String initForm(Model model)
	{
		
		model.addAttribute("command",cars);
		return "addCars";
	}
	
	@RequestMapping(value="/cars",method=RequestMethod.POST)	
	public String submitForm(@ModelAttribute("command") Cars cars, Model model)
	{
		int rowAdded = repo.addCars(cars);
		model.addAttribute("rowAdded",rowAdded);
		return "addCars";
	}
	
	 @ModelAttribute("status")
		public String[] status(){
			return new String[]{"sold","unsold"};

		}
//	 @ModelAttribute("brand")
//		public String[] brand(){
//			return new String[]{"Maruti","Tata"};
//
//		}
	 @ModelAttribute("brands")
		public String[] brand(){
			String[] brands = repo.getBrand();
			
			
			return brands;

		}
	
	 @RequestMapping(value="/cars/all",method=RequestMethod.GET)
		public String findAllCars(Model model)
		{
			List<Cars> list = repo.getAllCars();
			model.addAttribute("list",list);
			return "showCars";
			
		}
	 
	 @RequestMapping(value="/cars/unsold",method=RequestMethod.GET)
		public String findCarsUnsold(Model model)
		{
			List<Cars> list = repo.getUnsoldCars();
			model.addAttribute("list",list);
			return "showUnsoldCars";
			
		}
	 @RequestMapping(value="/cars/showByBrand",method=RequestMethod.GET)
		public String initFormBrand(Model model)
		{
		 
			model.addAttribute("command",cars);
			return "selectBrand";
		}
	 @RequestMapping(value="/cars/brand",method=RequestMethod.POST)	
		public String findCarsByBrand(@ModelAttribute("command") @RequestParam("brand")String brand, Model model)
		{
			List<Cars> list = repo.getCarsByBrand(brand);
			
			model.addAttribute("list",list);
			return "carsByBrand";
		}
		
}
