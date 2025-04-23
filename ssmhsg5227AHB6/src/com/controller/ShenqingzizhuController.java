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

import com.entity.Shenqingzizhu;
import com.server.ShenqingzizhuServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ShenqingzizhuController {
	@Resource
	private ShenqingzizhuServer shenqingzizhuService;


   
	@RequestMapping("addShenqingzizhu.do")
	public String addShenqingzizhu(HttpServletRequest request,Shenqingzizhu shenqingzizhu,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shenqingzizhu.setAddtime(time.toString().substring(0, 19));
		shenqingzizhuService.add(shenqingzizhu);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shenqingzizhuList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shenqingzizhuList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShenqingzizhu.do")
	public String doUpdateShenqingzizhu(int id,ModelMap map,Shenqingzizhu shenqingzizhu){
		shenqingzizhu=shenqingzizhuService.getById(id);
		map.put("shenqingzizhu", shenqingzizhu);
		return "shenqingzizhu_updt";
	}
	
	
	
	@RequestMapping("doUpdateShenqingzizhulb.do")
	public String doUpdateShenqingzizhulb(int id,ModelMap map,Shenqingzizhu shenqingzizhu){
		shenqingzizhu=shenqingzizhuService.getById(id);
		map.put("shenqingzizhu", shenqingzizhu);
		return "shenqingzizhu_updtlb";
	}
	
@RequestMapping("updateShenqingzizhulb.do")
	public String updateShenqingzizhulb(int id,ModelMap map,Shenqingzizhu shenqingzizhu){
		shenqingzizhuService.updatelb(shenqingzizhu);
		return "redirect:shenqingzizhuList.do";
	}
	
//	后台详细
	@RequestMapping("shenqingzizhuDetail.do")
	public String shenqingzizhuDetail(int id,ModelMap map,Shenqingzizhu shenqingzizhu){
		shenqingzizhu=shenqingzizhuService.getById(id);
		map.put("shenqingzizhu", shenqingzizhu);
		return "shenqingzizhu_detail";
	}
//	前台详细
	@RequestMapping("sqzzDetail.do")
	public String sqzzDetail(int id,ModelMap map,Shenqingzizhu shenqingzizhu){
		shenqingzizhu=shenqingzizhuService.getById(id);
		map.put("shenqingzizhu", shenqingzizhu);
		return "shenqingzizhudetail";
	}
//	
	@RequestMapping("updateShenqingzizhu.do")
	public String updateShenqingzizhu(int id,ModelMap map,Shenqingzizhu shenqingzizhu,HttpServletRequest request,HttpSession session){
		shenqingzizhuService.update(shenqingzizhu);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shenqingzizhuList.do";
	}

//	分页查询
	@RequestMapping("shenqingzizhuList.do")
	public String shenqingzizhuList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shenqingzizhu shenqingzizhu, String zizhupici, String zizhujine, String zhuangtai, String shenqingren, String shenqingriqi1,String shenqingriqi2, String shenqingyangbiao, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(zizhupici==null||zizhupici.equals("")){pmap.put("zizhupici", null);}else{pmap.put("zizhupici", zizhupici);}
		if(zizhujine==null||zizhujine.equals("")){pmap.put("zizhujine", null);}else{pmap.put("zizhujine", zizhujine);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}
		if(shenqingriqi1==null||shenqingriqi1.equals("")){pmap.put("shenqingriqi1", null);}else{pmap.put("shenqingriqi1", shenqingriqi1);}
		if(shenqingriqi2==null||shenqingriqi2.equals("")){pmap.put("shenqingriqi2", null);}else{pmap.put("shenqingriqi2", shenqingriqi2);}
		if(shenqingyangbiao==null||shenqingyangbiao.equals("")){pmap.put("shenqingyangbiao", null);}else{pmap.put("shenqingyangbiao", shenqingyangbiao);}
		
		int total=shenqingzizhuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shenqingzizhu> list=shenqingzizhuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shenqingzizhu_list";
	}
	
	
	
	@RequestMapping("shenqingzizhuList3.do")
	public String shenqingzizhuList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shenqingzizhu shenqingzizhu, String zizhupici, String zizhujine, String zhuangtai, String shenqingren, String shenqingriqi1,String shenqingriqi2, String shenqingyangbiao, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(zizhupici==null||zizhupici.equals("")){pmap.put("zizhupici", null);}else{pmap.put("zizhupici", zizhupici);}
		if(zizhujine==null||zizhujine.equals("")){pmap.put("zizhujine", null);}else{pmap.put("zizhujine", zizhujine);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}
		if(shenqingriqi1==null||shenqingriqi1.equals("")){pmap.put("shenqingriqi1", null);}else{pmap.put("shenqingriqi1", shenqingriqi1);}
		if(shenqingriqi2==null||shenqingriqi2.equals("")){pmap.put("shenqingriqi2", null);}else{pmap.put("shenqingriqi2", shenqingriqi2);}
		if(shenqingyangbiao==null||shenqingyangbiao.equals("")){pmap.put("shenqingyangbiao", null);}else{pmap.put("shenqingyangbiao", shenqingyangbiao);}
		
		int total=shenqingzizhuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shenqingzizhu> list=shenqingzizhuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shenqingzizhu_list3";
	}
	
	
	
	
	@RequestMapping("shenqingzizhuList2.do")
	public String shenqingzizhuList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shenqingzizhu shenqingzizhu, String zizhupici, String zizhujine, String zhuangtai, String shenqingren, String shenqingriqi1,String shenqingriqi2, String shenqingyangbiao, String issh,HttpServletRequest request){
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
		if(zizhupici==null||zizhupici.equals("")){pmap.put("zizhupici", null);}else{pmap.put("zizhupici", zizhupici);}
		if(zizhujine==null||zizhujine.equals("")){pmap.put("zizhujine", null);}else{pmap.put("zizhujine", zizhujine);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(shenqingriqi1==null||shenqingriqi1.equals("")){pmap.put("shenqingriqi1", null);}else{pmap.put("shenqingriqi1", shenqingriqi1);}
		if(shenqingriqi2==null||shenqingriqi2.equals("")){pmap.put("shenqingriqi2", null);}else{pmap.put("shenqingriqi2", shenqingriqi2);}
		if(shenqingyangbiao==null||shenqingyangbiao.equals("")){pmap.put("shenqingyangbiao", null);}else{pmap.put("shenqingyangbiao", shenqingyangbiao);}
		
		
		int total=shenqingzizhuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shenqingzizhu> list=shenqingzizhuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shenqingzizhu_list2";
	}
	
	
	@RequestMapping("sqzzList.do")
	public String sqzzList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shenqingzizhu shenqingzizhu, String zizhupici, String zizhujine, String zhuangtai, String shenqingren, String shenqingriqi1,String shenqingriqi2, String shenqingyangbiao, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(zizhupici==null||zizhupici.equals("")){pmap.put("zizhupici", null);}else{pmap.put("zizhupici", zizhupici);}
		if(zizhujine==null||zizhujine.equals("")){pmap.put("zizhujine", null);}else{pmap.put("zizhujine", zizhujine);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}
		if(shenqingriqi1==null||shenqingriqi1.equals("")){pmap.put("shenqingriqi1", null);}else{pmap.put("shenqingriqi1", shenqingriqi1);}
		if(shenqingriqi2==null||shenqingriqi2.equals("")){pmap.put("shenqingriqi2", null);}else{pmap.put("shenqingriqi2", shenqingriqi2);}
		if(shenqingyangbiao==null||shenqingyangbiao.equals("")){pmap.put("shenqingyangbiao", null);}else{pmap.put("shenqingyangbiao", shenqingyangbiao);}
		
		int total=shenqingzizhuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shenqingzizhu> list=shenqingzizhuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shenqingzizhulist";
	}
	
	@RequestMapping("deleteShenqingzizhu.do")
	public String deleteShenqingzizhu(int id,HttpServletRequest request){
		shenqingzizhuService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shenqingzizhuList.do";
	}
	
	
}
