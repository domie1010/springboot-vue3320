package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shenqinggenghuanyinxingka;

public interface ShenqinggenghuanyinxingkaServer {

  public int add(Shenqinggenghuanyinxingka po);

  public int update(Shenqinggenghuanyinxingka po);
  
  
  
  public int delete(int id);

  public List<Shenqinggenghuanyinxingka> getAll(Map<String,Object> map);
  public List<Shenqinggenghuanyinxingka> getsyshenqinggenghuanyinxingka1(Map<String,Object> map);
  public List<Shenqinggenghuanyinxingka> getsyshenqinggenghuanyinxingka2(Map<String,Object> map);
  public List<Shenqinggenghuanyinxingka> getsyshenqinggenghuanyinxingka3(Map<String,Object> map);
  public Shenqinggenghuanyinxingka quchongShenqinggenghuanyinxingka(Map<String, Object> acount);

  public Shenqinggenghuanyinxingka getById( int id);

  public List<Shenqinggenghuanyinxingka> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Shenqinggenghuanyinxingka> select(Map<String, Object> map);
}
//	所有List
