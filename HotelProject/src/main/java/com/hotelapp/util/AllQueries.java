package com.hotelapp.util;

public class AllQueries {
	public static final String ALLBOOKINGSQUERY="select * from booking";
	public static final String SHOWQUERY="SELECT * from booking b join hotel h on (b.hotelid=h.hotelid) where b.contact=? ";
	public static final String INSERTQUERY="insert into booking(customername,checkindate,checkoutdate,noofpersons,contact,breakfast,hotelid,totalnoofdays) values(?,?,?,?,?,?,?,?)";
	
	public static final String addsql="insert into hotel values(?,?,?,?,?,?)";
	public static final String deletesql="delete from hotel where hotelid=?";
	public static final String getbyidsql="select * from hotel where hotelid=?";
	public static final String updatesql="update hotel set priceperday=?,ratings=? where hotelid=?";
	public static final String getallsql="select * from hotel";
	public static final String hotelbycitysql="select * from hotel where city=?";
	public static final String hotelbygradesql="select * from hotel where grade=?";
	public static final String hotelbynamesql="select * from hotel where name=?";
	
}
