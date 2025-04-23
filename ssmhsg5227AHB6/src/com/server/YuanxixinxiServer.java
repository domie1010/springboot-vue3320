package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Yuanxixinxi;

public interface YuanxixinxiServer {

  public int add(Yuanxixinxi po);

  public int update(Yuanxixinxi po);
  
  
  
  public int delete(int id);

  public List<Yuanxixinxi> getAll(Map<String,Object> map);
  public List<Yuanxixinxi> getsyyuanxixinxi1(Map<String,Object> map);
  public List<Yuanxixinxi> getsyyuanxixinxi2(Map<String,Object> map);
  public List<Yuanxixinxi> getsyyuanxixinxi3(Map<String,Object> map);
  public Yuanxixinxi quchongYuanxixinxi(Map<String, Object> acount);

  public Yuanxixinxi getById( int id);

  public List<Yuanxixinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Yuanxixinxi> select(Map<String, Object> map);
}
//	所有List
