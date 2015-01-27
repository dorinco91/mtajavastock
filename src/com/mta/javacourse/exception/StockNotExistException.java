package com.mta.javacourse.exception;

/**
 * stock not exist exception
 * @author dorin
 *
 */
public class StockNotExistException extends Exception {
	
	public StockNotExistException (String symbol)
	{
		super("Stock+ "+symbol+" not exists");
	}

}
