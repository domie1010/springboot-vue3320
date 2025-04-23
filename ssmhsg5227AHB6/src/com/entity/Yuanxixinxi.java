package com.entity;

public class Yuanxixinxi {
    private Integer id;
	private String yuanxi;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getYuanxi() {
        return yuanxi;
    }
    public void setYuanxi(String yuanxi) {
        this.yuanxi = yuanxi == null ? null : yuanxi.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
