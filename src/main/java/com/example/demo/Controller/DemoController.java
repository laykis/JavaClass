package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DAO.UserMapper;
import com.example.demo.DTO.PlanDTO;
import com.example.demo.DTO.UserDTO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

@RestController
@CrossOrigin(origins = "http://192.168.173.150:3000")
public class DemoController {
	
	
	@Autowired
	UserMapper uMapper = null;
	
	// 사용자 이름 가져오기 
	@GetMapping("/getUNAME")
	public String getUNAME(String ID) {
		
		String result = "";
		
		try {
		
			result = uMapper.getUname(ID);
			System.out.println(result);
			return result;
		}
		catch(Exception e){
			e.printStackTrace();
			return result;
		}
	}
		//로그인 
	@GetMapping("/login")
	public String login(@RequestParam String ID, String PW) {
		
		String result = "";
		
		System.out.println(uMapper.login(ID, PW));
		
		if(uMapper.login(ID, PW)==null) {
			result = "noExist";
		}
		else {
			result = "success";
		}
		
		return result;
	
		
	}
	//회원 가입 
	@GetMapping("/signUp")
	public String signUp(@RequestParam String UNAME, String ID, String PW) {
		UserDTO user = new UserDTO();
		String result = "";
		try {
		if(uMapper.CheckUser(ID, UNAME) == null) {
			user.setID(ID);
			user.setPW(PW);
			user.setUNAME(UNAME);
			
			uMapper.InsertUser(user);
			
			result = "sucess";
			
			
		}
		else {
			result = "exist";
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	//계획 저장하기
	@GetMapping("/makePlan")
	public String makePlan(@RequestParam String ID, String PNAME, String PDATE, String PTEXT) {
		
		PlanDTO plan = new PlanDTO();
		String result = "";
		int result2 = uMapper.getUID(ID);
		try {
			plan.setUID(String.valueOf(result2));
			plan.setPNAME(PNAME);
			plan.setPDATE(PDATE);
			plan.setPTEXT(PTEXT);
			
			uMapper.InsertPlan(plan);
			result = "sucsess";
		}
		catch(Exception e) {
			result="fail";
			e.printStackTrace();
		}
		return result;
	}
	
	//계획 불러오기
	@GetMapping("/getPlan")
	public List<PlanDTO> getPlan(@RequestParam String ID) {
		@SuppressWarnings("unused")
		String result = "";
		
		int UID = uMapper.getUID(ID);
		
		List<PlanDTO> plan = null;

		try {
			if(String.valueOf(UID) != null) {
				plan = uMapper.getPlan(String.valueOf(UID));
				
				for(int i = 0; i<plan.size();i++) {
					System.out.println("계획명 : " + plan.get(i).getPNAME());
					System.out.println("계획내용 : " + plan.get(i).getPTEXT());
					System.out.println("날짜 : " + plan.get(i).getPDATE());
				}
				result = plan.toString();
			}
			else {
				result = "fail";
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return plan;
	}
	
	//계획 수정하기
	@GetMapping("/fixPlan")
	public String fixPlan(@RequestParam String PID, String PNAME, String PDATE, String PTEXT) {
		
		PlanDTO plan = new PlanDTO();
		String result = "";
		
		
		try {
				plan.setPID(PID);
				plan.setPNAME(PNAME);
				plan.setPDATE(PDATE);;
				plan.setPTEXT(PTEXT);
			
				uMapper.fixPlan(plan);
				result = "sucsess";
			
		}
		catch(Exception e) {
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}
	
	//계획 삭제하기 
	@GetMapping("/deletePlan")
	public String deletePlan(@RequestParam String PID) {
		String result = "";
		try {
			uMapper.deletePlan(PID);
			result = "sucsess";
		}
		catch(Exception e) {
			result = "fail";
			e.printStackTrace();
		}
		return result;
		
	}
	
	//날짜 계산하기
	@GetMapping("/restDate")
	public String restDate(String PID) {

		String result = "";
		String tz = "0";
	    try {
	    	
	           SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	           String day1 = null;
	           String day2 = null;
	           
	           
	           day1 = dateFormat.format(System.currentTimeMillis());
	           day2 = uMapper.getPDATE(PID);
	           Date FirstDate = dateFormat.parse(day1);
   	   		   Date SecondDate = dateFormat.parse(day2);
   	   		   
   	   		   long calDate = SecondDate.getTime() - FirstDate.getTime();
   	   		   String calDateDays = String.valueOf(calDate / (24*60*60*1000));
	           
	           if((calDateDays.compareTo(tz) >= 0) )  {
	        	   		result = calDateDays;
	               }
	           else {
	                  result = "end";
	           }
	               
	    	}catch(Exception e) {
	               e.printStackTrace();
	            }
	     
	     return result;
	  }
	
	@GetMapping("/test")
	public String gettuname(String Number) {
		String result = "";
		try {
			result = uMapper.gettuname(Number);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}