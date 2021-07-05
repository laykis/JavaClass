package com.example.demo.DAO;

import org.springframework.stereotype.Repository;

import com.example.demo.DTO.PlanDTO;
import com.example.demo.DTO.UserDTO;


import java.util.List;

@Repository
public interface UserMapper {
	
	//사용자 이름 불러오기 
	public String getUname(String ID);
	
	//로그인 
	public String login(String ID, String PW);
	
	//회원 확인 
	public String CheckUser(String ID, String UNAME);
	
	//회원가입 정보 삽입 
	List<UserDTO> InsertUser(UserDTO user);
	
	//ID를 비교해서 UID 불러오기 
	public int getUID(String ID);
	
	//계획 삽입 
	public void InsertPlan(PlanDTO plan);
	
	//계획 불러오기 
	List<PlanDTO> getPlan(String UID);
	
	//계획 수정하기 
	public String fixPlan(PlanDTO plan);
	
	// PID 불러오기 
	public String getPID(String PNAME);
	
	//계획 삭제하기
	public String deletePlan(String PID);
	
	//기간날짜 불러오기 
	public String getPDATE(String PID);
	
	//튜터 이름불러오가
	public String gettuname(String Number);
}
