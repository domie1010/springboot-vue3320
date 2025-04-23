package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Yuanxixinxi;

public interface YuanxixinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Yuanxixinxi record);

    int insertSelective(Yuanxixinxi record);

    Yuanxixinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Yuanxixinxi record);
	
    int updateByPrimaryKey(Yuanxixinxi record);
	public Yuanxixinxi quchongYuanxixinxi(Map<String, Object> yuanxi);
	public List<Yuanxixinxi> getAll(Map<String, Object> map);
	public List<Yuanxixinxi> getsyyuanxixinxi1(Map<String, Object> map);
	public List<Yuanxixinxi> getsyyuanxixinxi3(Map<String, Object> map);
	public List<Yuanxixinxi> getsyyuanxixinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Yuanxixinxi> getByPage(Map<String, Object> map);
	public List<Yuanxixinxi> select(Map<String, Object> map);
//	所有List
}

