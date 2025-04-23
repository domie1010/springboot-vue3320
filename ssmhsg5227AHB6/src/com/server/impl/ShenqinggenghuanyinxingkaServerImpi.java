package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ShenqinggenghuanyinxingkaMapper;
import com.entity.Shenqinggenghuanyinxingka;
import com.server.ShenqinggenghuanyinxingkaServer;
@Service
public class ShenqinggenghuanyinxingkaServerImpi implements ShenqinggenghuanyinxingkaServer {
   @Resource
   private ShenqinggenghuanyinxingkaMapper gdao;
	@Override
	public int add(Shenqinggenghuanyinxingka po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shenqinggenghuanyinxingka po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shenqinggenghuanyinxingka> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shenqinggenghuanyinxingka> getsyshenqinggenghuanyinxingka1(Map<String, Object> map) {
		return gdao.getsyshenqinggenghuanyinxingka1(map);
	}
	public List<Shenqinggenghuanyinxingka> getsyshenqinggenghuanyinxingka2(Map<String, Object> map) {
		return gdao.getsyshenqinggenghuanyinxingka2(map);
	}
	public List<Shenqinggenghuanyinxingka> getsyshenqinggenghuanyinxingka3(Map<String, Object> map) {
		return gdao.getsyshenqinggenghuanyinxingka3(map);
	}
	
	@Override
	public Shenqinggenghuanyinxingka quchongShenqinggenghuanyinxingka(Map<String, Object> account) {
		return gdao.quchongShenqinggenghuanyinxingka(account);
	}

	@Override
	public List<Shenqinggenghuanyinxingka> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shenqinggenghuanyinxingka> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shenqinggenghuanyinxingka getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

