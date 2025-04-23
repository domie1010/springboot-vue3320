package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Zizhuxinxi;

public interface ZizhuxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Zizhuxinxi record);

    int insertSelective(Zizhuxinxi record);

    Zizhuxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Zizhuxinxi record);
	
    int updateByPrimaryKey(Zizhuxinxi record);
	public Zizhuxinxi quchongZizhuxinxi(Map<String, Object> zizhupici);
	public List<Zizhuxinxi> getAll(Map<String, Object> map);
	public List<Zizhuxinxi> getsyzizhuxinxi1(Map<String, Object> map);
	public List<Zizhuxinxi> getsyzizhuxinxi3(Map<String, Object> map);
	public List<Zizhuxinxi> getsyzizhuxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Zizhuxinxi> getByPage(Map<String, Object> map);
	public List<Zizhuxinxi> select(Map<String, Object> map);
//	所有List
}

