package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.YuanxixinxiMapper;
import com.entity.Yuanxixinxi;
import com.server.YuanxixinxiServer;
@Service
public class YuanxixinxiServerImpi implements YuanxixinxiServer {
   @Resource
   private YuanxixinxiMapper gdao;
	@Override
	public int add(Yuanxixinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Yuanxixinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Yuanxixinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Yuanxixinxi> getsyyuanxixinxi1(Map<String, Object> map) {
		return gdao.getsyyuanxixinxi1(map);
	}
	public List<Yuanxixinxi> getsyyuanxixinxi2(Map<String, Object> map) {
		return gdao.getsyyuanxixinxi2(map);
	}
	public List<Yuanxixinxi> getsyyuanxixinxi3(Map<String, Object> map) {
		return gdao.getsyyuanxixinxi3(map);
	}
	
	@Override
	public Yuanxixinxi quchongYuanxixinxi(Map<String, Object> account) {
		return gdao.quchongYuanxixinxi(account);
	}

	@Override
	public List<Yuanxixinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Yuanxixinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Yuanxixinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

