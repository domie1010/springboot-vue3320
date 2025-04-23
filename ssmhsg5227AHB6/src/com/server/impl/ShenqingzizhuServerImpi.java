package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ShenqingzizhuMapper;
import com.entity.Shenqingzizhu;
import com.server.ShenqingzizhuServer;
@Service
public class ShenqingzizhuServerImpi implements ShenqingzizhuServer {
   @Resource
   private ShenqingzizhuMapper gdao;
	@Override
	public int add(Shenqingzizhu po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shenqingzizhu po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	@Override
	public int updatelb(Shenqingzizhu po) {
		return gdao.updateByPrimaryKeySelectivelb(po);
	}
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shenqingzizhu> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shenqingzizhu> getsyshenqingzizhu1(Map<String, Object> map) {
		return gdao.getsyshenqingzizhu1(map);
	}
	public List<Shenqingzizhu> getsyshenqingzizhu2(Map<String, Object> map) {
		return gdao.getsyshenqingzizhu2(map);
	}
	public List<Shenqingzizhu> getsyshenqingzizhu3(Map<String, Object> map) {
		return gdao.getsyshenqingzizhu3(map);
	}
	
	@Override
	public Shenqingzizhu quchongShenqingzizhu(Map<String, Object> account) {
		return gdao.quchongShenqingzizhu(account);
	}

	@Override
	public List<Shenqingzizhu> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shenqingzizhu> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shenqingzizhu getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

