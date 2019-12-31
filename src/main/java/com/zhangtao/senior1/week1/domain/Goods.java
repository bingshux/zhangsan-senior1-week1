package com.zhangtao.senior1.week1.domain;

public class Goods {
	private Integer gid;
	private String gname;
	private String ename;
	private Integer bid;
	private Integer kid;
	private String size;
	private double price;
	private Integer num;
	private String tab;
	private String pic;
	private String bname;
	private String kname;
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public Integer getKid() {
		return kid;
	}
	public void setKid(Integer kid) {
		this.kid = kid;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getTab() {
		return tab;
	}
	public void setTab(String tab) {
		this.tab = tab;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getKname() {
		return kname;
	}
	public void setKname(String kname) {
		this.kname = kname;
	}
	public Goods(Integer gid, String gname, String ename, Integer bid, Integer kid, String size, double price,
			Integer num, String tab, String pic, String bname, String kname) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.ename = ename;
		this.bid = bid;
		this.kid = kid;
		this.size = size;
		this.price = price;
		this.num = num;
		this.tab = tab;
		this.pic = pic;
		this.bname = bname;
		this.kname = kname;
	}
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Goods [gid=" + gid + ", gname=" + gname + ", ename=" + ename + ", bid=" + bid + ", kid=" + kid
				+ ", size=" + size + ", price=" + price + ", num=" + num + ", tab=" + tab + ", pic=" + pic + ", bname="
				+ bname + ", kname=" + kname + "]";
	}
	
}
