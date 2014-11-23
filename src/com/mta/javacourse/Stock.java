package com.mta.javacourse;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Stock  extends HttpServlet {
	private String symbol;
	private float Ask;
	private float Bid;
	private Date date;
	
	public String getSymbol()
	{
		return symbol;
	}
	public float getAsk()
	{
		return Ask;
	}
	public float getBid()
	{
		return Bid;
	}
	public Date getDate()
	{
		return date;
	}
	public void setSymbol(String symbol1)
	{
		symbol=symbol1;
	}
	public void setAsk(float ask1)
	{
		Ask=ask1;
	}
	public void setBid(float bid1)
	{
		Bid=bid1;
	}
	public void setdate(Date date1)
	{
		date=date1;
	}
	public String getHtmlDescription()
	{
		String stockHtmlDetailsString = "<b>Stock symbol: </b>"+getSymbol()+"<b> Ask: </b>"+getAsk()+"<b> Bid: </b>"+getBid()+"<b> Date: </b>" +getDate();
		return stockHtmlDetailsString;
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Stock s1=new Stock();
		Stock s2=new Stock();
		Stock s3=new Stock();
		
		java.util.Date date1=new java.util.Date();
		date1.setDate(15);
		date1.setMonth(10);
		date1.setYear(114);
		date1.setHours(0);
		date1.setMinutes(0);
		date1.setSeconds(0);
		
		s1.setSymbol("PIH");
		s1.setAsk(12.4f);
		s1.setBid(13.1f);
		s1.setdate(date1);
		
		s2.setSymbol("AAL");
		s2.setAsk(5.5f);
		s2.setBid(5.78f);
		s2.setdate(date1);
		
		s3.setSymbol("CAAS");
		s3.setAsk(31.5f);
		s3.setBid(31.2f);
		s3.setdate(date1);
		
		String s1String=s1.getHtmlDescription();
		String s2String=s2.getHtmlDescription();
		String s3String=s3.getHtmlDescription();
		
		resp.setContentType("text/html");
		resp.getWriter().println(s1String+"<br>"+s2String+"<br>"+s3String);
		
	}
	
}
