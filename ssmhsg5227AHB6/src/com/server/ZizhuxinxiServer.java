package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Zizhuxinxi;

public interface ZizhuxinxiServer {

  public int add(Zizhuxinxi po);

  public int update(Zizhuxinxi po);
  
  
  
  public int delete(int id);

  public List<Zizhuxinxi> getAll(Map<String,Object> map);
  public List<Zizhuxinxi> getsyzizhuxinxi1(Map<String,Object> map);
  public List<Zizhuxinxi> getsyzizhuxinxi2(Map<String,Object> map);
  public List<Zizhuxinxi> getsyzizhuxinxi3(Map<String,Object> map);
  public Zizhuxinxi quchongZizhuxinxi(Map<String, Object> acount);

  public Zizhuxinxi getById( int id);

  public List<Zizhuxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Zizhuxinxi> select(Map<String, Object> map);
}
//	所有List
