package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shenqingzizhu;

public interface ShenqingzizhuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shenqingzizhu record);

    int insertSelective(Shenqingzizhu record);

    Shenqingzizhu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shenqingzizhu record);
	int updateByPrimaryKeySelectivelb(Shenqingzizhu record);
    int updateByPrimaryKey(Shenqingzizhu record);
	public Shenqingzizhu quchongShenqingzizhu(Map<String, Object> shenqingren);
	public List<Shenqingzizhu> getAll(Map<String, Object> map);
	public List<Shenqingzizhu> getsyshenqingzizhu1(Map<String, Object> map);
	public List<Shenqingzizhu> getsyshenqingzizhu3(Map<String, Object> map);
	public List<Shenqingzizhu> getsyshenqingzizhu2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shenqingzizhu> getByPage(Map<String, Object> map);
	public List<Shenqingzizhu> select(Map<String, Object> map);
//	所有List
}

