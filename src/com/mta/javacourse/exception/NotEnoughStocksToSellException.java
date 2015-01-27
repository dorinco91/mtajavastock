package com.mta.javacourse.exception;

/**
 * not enough stocks to sell exception
 * @author dorin
 * 01-2015
 */ 
public class NotEnoughStocksToSellException extends Exception {
	
	public NotEnoughStocksToSellException()
	{
		super("Not enough stocks to sell");
	}

}
