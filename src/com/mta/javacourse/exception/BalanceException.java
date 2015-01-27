package com.mta.javacourse.exception;

/**
 * negative balance exception 
 * @author dorin
 *
 */
public class BalanceException extends Exception {
	
	public BalanceException()
	{
		super("you don't have enough money");
	}
}
