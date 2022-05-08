package com.domain.hotel.util;

public class AllQueries {
	public static final String ALLBOOKINGSQUERY="select * from booking";
	public static final String SHOWQUERY="SELECT * from booking b join hotel h on (b.hotelid=h.hotelid) where b.contact=? ";
	public static final String INSERTQUERY="insert into booking(customername,checkindate,checkoutdate,noofpersons,contact,breakfast,hotelid,totalnoofdays) values(?,?,?,?,?,?,?,?)";
	
	public static final String ADDSQL="insert into hotel values(?,?,?,?,?,?)";
	public static final String DELETESQL="delete from hotel where hotelid=?";
	public static final String GETBYIDSQL="select * from hotel where hotelid=?";
	public static final String UPDATESQL="update hotel set priceperday=?,ratings=? where hotelid=?";
	public static final String GETALLSQL="select * from hotel";
	public static final String HOTELBYCITYSQL="select * from hotel where city=?";
	public static final String HOTELBYGRADESQL="select * from hotel where grade=?";
	public static final String HOTELBYNAMESQL="select * from hotel where hotelname=?";
	
}
