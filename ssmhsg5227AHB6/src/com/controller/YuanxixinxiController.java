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

import com.entity.Yuanxixinxi;
import com.server.YuanxixinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class YuanxixinxiController {
	@Resource
	private YuanxixinxiServer yuanxixinxiService;


   
	@RequestMapping("addYuanxixinxi.do")
	public String addYuanxixinxi(HttpServletRequest request,Yuanxixinxi yuanxixinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		yuanxixinxi.setAddtime(time.toString().substring(0, 19));
		yuanxixinxiService.add(yuanxixinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "yuanxixinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:yuanxixinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateYuanxixinxi.do")
	public String doUpdateYuanxixinxi(int id,ModelMap map,Yuanxixinxi yuanxixinxi){
		yuanxixinxi=yuanxixinxiService.getById(id);
		map.put("yuanxixinxi", yuanxixinxi);
		return "yuanxixinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("yuanxixinxiDetail.do")
	public String yuanxixinxiDetail(int id,ModelMap map,Yuanxixinxi yuanxixinxi){
		yuanxixinxi=yuanxixinxiService.getById(id);
		map.put("yuanxixinxi", yuanxixinxi);
		return "yuanxixinxi_detail";
	}
//	前台详细
	@RequestMapping("yxxxDetail.do")
	public String yxxxDetail(int id,ModelMap map,Yuanxixinxi yuanxixinxi){
		yuanxixinxi=yuanxixinxiService.getById(id);
		map.put("yuanxixinxi", yuanxixinxi);
		return "yuanxixinxidetail";
	}
//	
	@RequestMapping("updateYuanxixinxi.do")
	public String updateYuanxixinxi(int id,ModelMap map,Yuanxixinxi yuanxixinxi,HttpServletRequest request,HttpSession session){
		yuanxixinxiService.update(yuanxixinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:yuanxixinxiList.do";
	}

//	分页查询
	@RequestMapping("yuanxixinxiList.do")
	public String yuanxixinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yuanxixinxi yuanxixinxi, String yuanxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yuanxi==null||yuanxi.equals("")){pmap.put("yuanxi", null);}else{pmap.put("yuanxi", yuanxi);}
		
		int total=yuanxixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yuanxixinxi> list=yuanxixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yuanxixinxi_list";
	}
	
	
	
	@RequestMapping("yxxxList.do")
	public String yxxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yuanxixinxi yuanxixinxi, String yuanxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yuanxi==null||yuanxi.equals("")){pmap.put("yuanxi", null);}else{pmap.put("yuanxi", yuanxi);}
		
		int total=yuanxixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yuanxixinxi> list=yuanxixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yuanxixinxilist";
	}
	
	@RequestMapping("deleteYuanxixinxi.do")
	public String deleteYuanxixinxi(int id,HttpServletRequest request){
		yuanxixinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:yuanxixinxiList.do";
	}
	
	@RequestMapping("quchongYuanxixinxi.do")
	public void quchongYuanxixinxi(Yuanxixinxi yuanxixinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("yuanxi", yuanxixinxi.getYuanxi());
		   System.out.println("yuanxi==="+yuanxixinxi.getYuanxi());
		   System.out.println("yuanxi222==="+yuanxixinxiService.quchongYuanxixinxi(map));
		   JSONObject obj=new JSONObject();
		   if(yuanxixinxiService.quchongYuanxixinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "院校可以用！");
				  
			   }
		   response.setContentType("text/html;charset=utf-8");
		   PrintWriter out=null;
		   try {
			out=response.getWriter();
			out.print(obj);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
