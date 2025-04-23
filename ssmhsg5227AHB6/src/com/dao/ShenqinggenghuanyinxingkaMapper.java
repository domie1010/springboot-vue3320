package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shenqinggenghuanyinxingka;

public interface ShenqinggenghuanyinxingkaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shenqinggenghuanyinxingka record);

    int insertSelective(Shenqinggenghuanyinxingka record);

    Shenqinggenghuanyinxingka selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shenqinggenghuanyinxingka record);
	
    int updateByPrimaryKey(Shenqinggenghuanyinxingka record);
	public Shenqinggenghuanyinxingka quchongShenqinggenghuanyinxingka(Map<String, Object> shenqingren);
	public List<Shenqinggenghuanyinxingka> getAll(Map<String, Object> map);
	public List<Shenqinggenghuanyinxingka> getsyshenqinggenghuanyinxingka1(Map<String, Object> map);
	public List<Shenqinggenghuanyinxingka> getsyshenqinggenghuanyinxingka3(Map<String, Object> map);
	public List<Shenqinggenghuanyinxingka> getsyshenqinggenghuanyinxingka2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shenqinggenghuanyinxingka> getByPage(Map<String, Object> map);
	public List<Shenqinggenghuanyinxingka> select(Map<String, Object> map);
//	所有List
}

