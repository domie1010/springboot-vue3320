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

import com.entity.Zizhuxinxi;
import com.server.ZizhuxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ZizhuxinxiController {
	@Resource
	private ZizhuxinxiServer zizhuxinxiService;


   
	@RequestMapping("addZizhuxinxi.do")
	public String addZizhuxinxi(HttpServletRequest request,Zizhuxinxi zizhuxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		zizhuxinxi.setAddtime(time.toString().substring(0, 19));
		zizhuxinxiService.add(zizhuxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "zizhuxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:zizhuxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateZizhuxinxi.do")
	public String doUpdateZizhuxinxi(int id,ModelMap map,Zizhuxinxi zizhuxinxi){
		zizhuxinxi=zizhuxinxiService.getById(id);
		map.put("zizhuxinxi", zizhuxinxi);
		return "zizhuxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("zizhuxinxiDetail.do")
	public String zizhuxinxiDetail(int id,ModelMap map,Zizhuxinxi zizhuxinxi){
		zizhuxinxi=zizhuxinxiService.getById(id);
		map.put("zizhuxinxi", zizhuxinxi);
		return "zizhuxinxi_detail";
	}
//	前台详细
	@RequestMapping("zzxxDetail.do")
	public String zzxxDetail(int id,ModelMap map,Zizhuxinxi zizhuxinxi){
		zizhuxinxi=zizhuxinxiService.getById(id);
		map.put("zizhuxinxi", zizhuxinxi);
		return "zizhuxinxidetail";
	}
//	
	@RequestMapping("updateZizhuxinxi.do")
	public String updateZizhuxinxi(int id,ModelMap map,Zizhuxinxi zizhuxinxi,HttpServletRequest request,HttpSession session){
		zizhuxinxiService.update(zizhuxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:zizhuxinxiList.do";
	}

//	分页查询
	@RequestMapping("zizhuxinxiList.do")
	public String zizhuxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zizhuxinxi zizhuxinxi, String zizhupici, String zizhujine1,String zizhujine2, String xiangxi, String tupian){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(zizhupici==null||zizhupici.equals("")){pmap.put("zizhupici", null);}else{pmap.put("zizhupici", zizhupici);}
		if(zizhujine1==null||zizhujine1.equals("")){pmap.put("zizhujine1", null);}else{pmap.put("zizhujine1", zizhujine1);}
		if(zizhujine2==null||zizhujine2.equals("")){pmap.put("zizhujine2", null);}else{pmap.put("zizhujine2", zizhujine2);}
		if(xiangxi==null||xiangxi.equals("")){pmap.put("xiangxi", null);}else{pmap.put("xiangxi", xiangxi);}
		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
		
		int total=zizhuxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zizhuxinxi> list=zizhuxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zizhuxinxi_list";
	}
	
	
	
	@RequestMapping("zzxxList.do")
	public String zzxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zizhuxinxi zizhuxinxi, String zizhupici, String zizhujine1,String zizhujine2, String xiangxi, String tupian){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(zizhupici==null||zizhupici.equals("")){pmap.put("zizhupici", null);}else{pmap.put("zizhupici", zizhupici);}
		if(zizhujine1==null||zizhujine1.equals("")){pmap.put("zizhujine1", null);}else{pmap.put("zizhujine1", zizhujine1);}
		if(zizhujine2==null||zizhujine2.equals("")){pmap.put("zizhujine2", null);}else{pmap.put("zizhujine2", zizhujine2);}
		if(xiangxi==null||xiangxi.equals("")){pmap.put("xiangxi", null);}else{pmap.put("xiangxi", xiangxi);}
		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
		
		int total=zizhuxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zizhuxinxi> list=zizhuxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zizhuxinxilist";
	}
	
	@RequestMapping("deleteZizhuxinxi.do")
	public String deleteZizhuxinxi(int id,HttpServletRequest request){
		zizhuxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:zizhuxinxiList.do";
	}
	
	
}
