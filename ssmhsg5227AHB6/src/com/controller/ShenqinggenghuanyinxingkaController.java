package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Shenqinggenghuanyinxingka;
import com.server.ShenqinggenghuanyinxingkaServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ShenqinggenghuanyinxingkaController {
	@Resource
	private ShenqinggenghuanyinxingkaServer shenqinggenghuanyinxingkaService;


   
	@RequestMapping("addShenqinggenghuanyinxingka.do")
	public String addShenqinggenghuanyinxingka(HttpServletRequest request,Shenqinggenghuanyinxingka shenqinggenghuanyinxingka,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shenqinggenghuanyinxingka.setAddtime(time.toString().substring(0, 19));
		shenqinggenghuanyinxingkaService.add(shenqinggenghuanyinxingka);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shenqinggenghuanyinxingkaList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shenqinggenghuanyinxingkaList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShenqinggenghuanyinxingka.do")
	public String doUpdateShenqinggenghuanyinxingka(int id,ModelMap map,Shenqinggenghuanyinxingka shenqinggenghuanyinxingka){
		shenqinggenghuanyinxingka=shenqinggenghuanyinxingkaService.getById(id);
		map.put("shenqinggenghuanyinxingka", shenqinggenghuanyinxingka);
		return "shenqinggenghuanyinxingka_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("shenqinggenghuanyinxingkaDetail.do")
	public String shenqinggenghuanyinxingkaDetail(int id,ModelMap map,Shenqinggenghuanyinxingka shenqinggenghuanyinxingka){
		shenqinggenghuanyinxingka=shenqinggenghuanyinxingkaService.getById(id);
		map.put("shenqinggenghuanyinxingka", shenqinggenghuanyinxingka);
		return "shenqinggenghuanyinxingka_detail";
	}
//	前台详细
	@RequestMapping("sqghyxkDetail.do")
	public String sqghyxkDetail(int id,ModelMap map,Shenqinggenghuanyinxingka shenqinggenghuanyinxingka){
		shenqinggenghuanyinxingka=shenqinggenghuanyinxingkaService.getById(id);
		map.put("shenqinggenghuanyinxingka", shenqinggenghuanyinxingka);
		return "shenqinggenghuanyinxingkadetail";
	}
//	
	@RequestMapping("updateShenqinggenghuanyinxingka.do")
	public String updateShenqinggenghuanyinxingka(int id,ModelMap map,Shenqinggenghuanyinxingka shenqinggenghuanyinxingka,HttpServletRequest request,HttpSession session){
		shenqinggenghuanyinxingkaService.update(shenqinggenghuanyinxingka);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shenqinggenghuanyinxingkaList.do";
	}

//	分页查询
	@RequestMapping("shenqinggenghuanyinxingkaList.do")
	public String shenqinggenghuanyinxingkaList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shenqinggenghuanyinxingka shenqinggenghuanyinxingka, String shenqingren, String xinyinxingka1,String xinyinxingka2, String shenqingshijian1,String shenqingshijian2, String shenqingyuanyin, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}		if(xinyinxingka1==null||xinyinxingka1.equals("")){pmap.put("xinyinxingka1", null);}else{pmap.put("xinyinxingka1", xinyinxingka1);}		if(xinyinxingka2==null||xinyinxingka2.equals("")){pmap.put("xinyinxingka2", null);}else{pmap.put("xinyinxingka2", xinyinxingka2);}		if(shenqingshijian1==null||shenqingshijian1.equals("")){pmap.put("shenqingshijian1", null);}else{pmap.put("shenqingshijian1", shenqingshijian1);}		if(shenqingshijian2==null||shenqingshijian2.equals("")){pmap.put("shenqingshijian2", null);}else{pmap.put("shenqingshijian2", shenqingshijian2);}		if(shenqingyuanyin==null||shenqingyuanyin.equals("")){pmap.put("shenqingyuanyin", null);}else{pmap.put("shenqingyuanyin", shenqingyuanyin);}		
		int total=shenqinggenghuanyinxingkaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shenqinggenghuanyinxingka> list=shenqinggenghuanyinxingkaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shenqinggenghuanyinxingka_list";
	}
	
	@RequestMapping("shenqinggenghuanyinxingkaList2.do")
	public String shenqinggenghuanyinxingkaList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shenqinggenghuanyinxingka shenqinggenghuanyinxingka, String shenqingren, String xinyinxingka1,String xinyinxingka2, String shenqingshijian1,String shenqingshijian2, String shenqingyuanyin, String issh,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("shenqingren", (String)request.getSession().getAttribute("username"));
		if(xinyinxingka1==null||xinyinxingka1.equals("")){pmap.put("xinyinxingka1", null);}else{pmap.put("xinyinxingka1", xinyinxingka1);}		if(xinyinxingka2==null||xinyinxingka2.equals("")){pmap.put("xinyinxingka2", null);}else{pmap.put("xinyinxingka2", xinyinxingka2);}		if(shenqingshijian1==null||shenqingshijian1.equals("")){pmap.put("shenqingshijian1", null);}else{pmap.put("shenqingshijian1", shenqingshijian1);}		if(shenqingshijian2==null||shenqingshijian2.equals("")){pmap.put("shenqingshijian2", null);}else{pmap.put("shenqingshijian2", shenqingshijian2);}		if(shenqingyuanyin==null||shenqingyuanyin.equals("")){pmap.put("shenqingyuanyin", null);}else{pmap.put("shenqingyuanyin", shenqingyuanyin);}		
		
		int total=shenqinggenghuanyinxingkaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shenqinggenghuanyinxingka> list=shenqinggenghuanyinxingkaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shenqinggenghuanyinxingka_list2";
	}	
	
	@RequestMapping("sqghyxkList.do")
	public String sqghyxkList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shenqinggenghuanyinxingka shenqinggenghuanyinxingka, String shenqingren, String xinyinxingka1,String xinyinxingka2, String shenqingshijian1,String shenqingshijian2, String shenqingyuanyin, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}		if(xinyinxingka1==null||xinyinxingka1.equals("")){pmap.put("xinyinxingka1", null);}else{pmap.put("xinyinxingka1", xinyinxingka1);}		if(xinyinxingka2==null||xinyinxingka2.equals("")){pmap.put("xinyinxingka2", null);}else{pmap.put("xinyinxingka2", xinyinxingka2);}		if(shenqingshijian1==null||shenqingshijian1.equals("")){pmap.put("shenqingshijian1", null);}else{pmap.put("shenqingshijian1", shenqingshijian1);}		if(shenqingshijian2==null||shenqingshijian2.equals("")){pmap.put("shenqingshijian2", null);}else{pmap.put("shenqingshijian2", shenqingshijian2);}		if(shenqingyuanyin==null||shenqingyuanyin.equals("")){pmap.put("shenqingyuanyin", null);}else{pmap.put("shenqingyuanyin", shenqingyuanyin);}		
		int total=shenqinggenghuanyinxingkaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shenqinggenghuanyinxingka> list=shenqinggenghuanyinxingkaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shenqinggenghuanyinxingkalist";
	}
	
	@RequestMapping("deleteShenqinggenghuanyinxingka.do")
	public String deleteShenqinggenghuanyinxingka(int id,HttpServletRequest request){
		shenqinggenghuanyinxingkaService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shenqinggenghuanyinxingkaList.do";
	}
	
	
}
