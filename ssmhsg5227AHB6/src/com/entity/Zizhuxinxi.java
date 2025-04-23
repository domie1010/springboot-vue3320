package com.entity;

public class Zizhuxinxi {
    private Integer id;
	private String zizhupici;	private String zizhujine;	private String xiangxi;	private String tupian;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getZizhupici() {
        return zizhupici;
    }
    public void setZizhupici(String zizhupici) {
        this.zizhupici = zizhupici == null ? null : zizhupici.trim();
    }	public String getZizhujine() {
        return zizhujine;
    }
    public void setZizhujine(String zizhujine) {
        this.zizhujine = zizhujine == null ? null : zizhujine.trim();
    }	public String getXiangxi() {
        return xiangxi;
    }
    public void setXiangxi(String xiangxi) {
        this.xiangxi = xiangxi == null ? null : xiangxi.trim();
    }	public String getTupian() {
        return tupian;
    }
    public void setTupian(String tupian) {
        this.tupian = tupian == null ? null : tupian.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
