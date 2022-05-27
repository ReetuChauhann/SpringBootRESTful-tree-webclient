package com.reetu.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.reetu.beans.Tree;

@Controller
public class ClientController {
	 
	RestTemplate rt=new RestTemplate();
	String URL="http://localhost:3333";
	
	//welcome
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/addtree")
	public String addtree(@ModelAttribute Tree t, MultipartFile image, Model model) {
		String API="/addtree";
		
		HttpHeaders header=new HttpHeaders();
		header.setContentType(MediaType.MULTIPART_FORM_DATA);
		
		LinkedMultiValueMap<String, Object> data=new LinkedMultiValueMap<>();
		data.add("Tree", t);
		data.add("image", convertf(image));
		
		HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity=new HttpEntity<>(data,header);
		ResponseEntity<String> S=rt.postForEntity(URL+API, requestEntity, String.class);
		if(S.getStatusCode()==HttpStatus.OK) {
			model.addAttribute("status", t.getName()+ "Added Successfully!");
		}else {
			model.addAttribute("status", t.getName()+"Already Exists!");
		}
		
		 return "index";
		
	}

	
	//code to change file into FileSystemResource
	public static FileSystemResource convertf(MultipartFile file) {
		File conf=new File(file.getOriginalFilename());
		try {
			conf.createNewFile();
			FileOutputStream fos=new FileOutputStream(conf);
			fos.write(file.getBytes());
			fos.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new FileSystemResource(conf);
	}
	
	//getall the tree
	@RequestMapping("/viewalltree")
	public String viewall(Model model){
		String API="/getall";
		List<Tree> t=rt.getForObject(URL+API, List.class);
		model.addAttribute("data",t);
		return "viewalltree";
	}
	
	//getimage
	@RequestMapping("/getimage")
	public void getimage(int tid, HttpServletResponse response) {
		String API="/getImage/"+tid;
		try {
			 byte[] b=rt.getForObject(URL+API, byte[].class);
			 response.getOutputStream().write(b);
				 
			 
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//getalltreeids only
	@ModelAttribute //common for all
	public void getallids(Model model) {
		String API="/getallids";
		List<Integer> list=rt.getForObject(URL+API, List.class);
		model.addAttribute("ids", list);
		}
	
	//update
	@RequestMapping("/update")
	public String update(@ModelAttribute  Tree t, MultipartFile image, Model model) {
		String API="/update";
		HttpHeaders header=new HttpHeaders();
		header.setContentType(MediaType.MULTIPART_FORM_DATA);
		
		LinkedMultiValueMap<String, Object> data=new LinkedMultiValueMap<>();
		data.add("Tree", t);
		data.add("image", convertf(image));
		
		HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity=new HttpEntity<>(data,header);
		ResponseEntity<String> s=rt.exchange(URL+API, HttpMethod.PUT, requestEntity, String.class);
		if(s.getStatusCode()==HttpStatus.OK) {
			model.addAttribute("result", t.getName()+ "Successfully Updated");
		}else {
			model.addAttribute("result", t.getName()+ "Not Updated!");
		}
		
		API="/getall";
		List<Tree> tree=rt.getForObject(URL+API, List.class);
		model.addAttribute("data",tree);
		
		
		return "update";
	}
	
	@RequestMapping("/updatet")
	public String page() {
		return "update";
	}
}
