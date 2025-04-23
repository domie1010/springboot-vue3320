package com.entity;

public class Shenqinggenghuanyinxingka {
    private Integer id;
	private String shenqingren;	private String xinyinxingka;	private String shenqingshijian;	private String shenqingyuanyin;	private String issh;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getShenqingren() {
        return shenqingren;
    }
    public void setShenqingren(String shenqingren) {
        this.shenqingren = shenqingren == null ? null : shenqingren.trim();
    }	public String getXinyinxingka() {
        return xinyinxingka;
    }
    public void setXinyinxingka(String xinyinxingka) {
        this.xinyinxingka = xinyinxingka == null ? null : xinyinxingka.trim();
    }	public String getShenqingshijian() {
        return shenqingshijian;
    }
    public void setShenqingshijian(String shenqingshijian) {
        this.shenqingshijian = shenqingshijian == null ? null : shenqingshijian.trim();
    }	public String getShenqingyuanyin() {
        return shenqingyuanyin;
    }
    public void setShenqingyuanyin(String shenqingyuanyin) {
        this.shenqingyuanyin = shenqingyuanyin == null ? null : shenqingyuanyin.trim();
    }	public String getIssh() {
        return issh;
    }
    public void setIssh(String issh) {
        this.issh = issh == null ? null : issh.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
