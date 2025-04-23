package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shenqingzizhu;

public interface ShenqingzizhuServer {

  public int add(Shenqingzizhu po);

  public int update(Shenqingzizhu po);
  
  public int updatelb(Shenqingzizhu po);
  
  public int delete(int id);

  public List<Shenqingzizhu> getAll(Map<String,Object> map);
  public List<Shenqingzizhu> getsyshenqingzizhu1(Map<String,Object> map);
  public List<Shenqingzizhu> getsyshenqingzizhu2(Map<String,Object> map);
  public List<Shenqingzizhu> getsyshenqingzizhu3(Map<String,Object> map);
  public Shenqingzizhu quchongShenqingzizhu(Map<String, Object> acount);

  public Shenqingzizhu getById( int id);

  public List<Shenqingzizhu> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Shenqingzizhu> select(Map<String, Object> map);
}
//	所有List
