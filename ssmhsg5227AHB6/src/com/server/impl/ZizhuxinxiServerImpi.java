package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ZizhuxinxiMapper;
import com.entity.Zizhuxinxi;
import com.server.ZizhuxinxiServer;
@Service
public class ZizhuxinxiServerImpi implements ZizhuxinxiServer {
   @Resource
   private ZizhuxinxiMapper gdao;
	@Override
	public int add(Zizhuxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Zizhuxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Zizhuxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Zizhuxinxi> getsyzizhuxinxi1(Map<String, Object> map) {
		return gdao.getsyzizhuxinxi1(map);
	}
	public List<Zizhuxinxi> getsyzizhuxinxi2(Map<String, Object> map) {
		return gdao.getsyzizhuxinxi2(map);
	}
	public List<Zizhuxinxi> getsyzizhuxinxi3(Map<String, Object> map) {
		return gdao.getsyzizhuxinxi3(map);
	}
	
	@Override
	public Zizhuxinxi quchongZizhuxinxi(Map<String, Object> account) {
		return gdao.quchongZizhuxinxi(account);
	}

	@Override
	public List<Zizhuxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Zizhuxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Zizhuxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

