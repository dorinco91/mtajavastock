package com.mta.javacourse.model;

import java.util.Date;

/**
 * class represent Portfolio
 * member int portfolioSize includes stocks array size
 * @author dorin
 * @date December 2014
 */
public class Portfolio {

	private final static int MAX_PORTFOLIO_SIZE=5;
	public enum ALGO_RECOMMENDATION {DO_NOTHING,BUY,SELL};
	private int portfolioSize;
	private String title;
	private float balance;
	private StockStatus[] stockStatus;


	//constructors 
	/**
	 *  portfolio constructor
	 */
	public Portfolio()
	{
		balance=0;
		portfolioSize=0;
		this.setTitle("portfolio");
		stockStatus=new StockStatus[MAX_PORTFOLIO_SIZE];
		
	}


	/**
	 * copy constructor Portfolio
	 * @param portfolio
	 */
	public Portfolio(Portfolio portfolio)
	{

		this();
		setTitle(portfolio.getTitle());
		setPortfolioSize(portfolio.getPotfilioSize());		


		for(int i = 0; i < portfolioSize; i++)
		{
			stockStatus[i] = new StockStatus(portfolio.getStockStatus()[i]);
		}

	}

	//setters

	public void setPortfolioSize(int portfolioSize)
	{
		this.portfolioSize=portfolioSize;
	}
	public void setTitle(String title1)
	{
		title=title1;
	}
	public void setStockStatus(StockStatus[] stockStatus1)
	{
		stockStatus=stockStatus1;
	}
	public void setBalance(float balance)
	{
		this.balance=balance;
	}

	//getters 
	public int getPotfilioSize()
	{
		return portfolioSize;
	}

	public StockStatus[] getStockStatus()
	{
		return stockStatus;
	}
	public String getTitle()
	{
		return title;
	}

	public float getBalance()
	{
		return balance;
	}

	//methods/
	/**
	 * addStock method
	 * @param stock s 
	 * insert new stock to stocks array and change portfolioSize 
	 */
	public void addStock(Stock s)
	{
		if (portfolioSize < stockStatus.length)
		{
			
			stockStatus[portfolioSize] = new StockStatus(s);
			portfolioSize++;
		}
		else 
			System.out.println("Can't add new stock,portfolio can have only "+MAX_PORTFOLIO_SIZE +" stocks");
	}
	

	/**
	 * update the balance after sell/buy
	 * @param amount
	 */

	public void updateBalance(float amount)
	{
		balance+=amount;
	}

	/**
	 * removes stock from portfolio array
	 * @param symbol
	 * @return
	 */
	public boolean removeStock(String symbol)
	{
		sellStock(symbol,-1);
		for (int i=0;i<stockStatus.length;i++)
		{
			if (symbol.equals(stockStatus[i].getSymbol()))
			{
				stockStatus[i]=stockStatus[portfolioSize-1];
				stockStatus[portfolioSize-1]=null;
				portfolioSize--;
				return true;
			}

		}
		return false;
	}



	/**
	 * sell stocks and update the balance
	 * @param symbol
	 * @param quantity
	 * @return
	 */
	public boolean sellStock(String symbol, int quantity )
	{

		for(int i=0; i<stockStatus.length; i++)
			if(symbol.equals(stockStatus[i].getSymbol()))
			{
				if(quantity == -1) {
					float amount1=stockStatus[i].getStockQuantity()*stockStatus[i].getBid();
					updateBalance(amount1);
					stockStatus[i].setStockQuantity(0);
				}
				else if(stockStatus[i].getStockQuantity()-quantity < 0){
						System.out.println("Not enough stocks to sell");
				}
				else if (stockStatus[i].getStockQuantity()-quantity >= 0){
					stockStatus[i].setStockQuantity(stockStatus[i].getStockQuantity()-quantity);
					float amount = quantity*stockStatus[i].getBid();
					updateBalance(amount);
				}
				return true;
			}
		return false;
	}

	/**
	 * buy stocks and update the balance
	 * @param symbol
	 * @param quantity
	 * @return
	 */
	public boolean buyStock(String symbol, int quantity )
	{

		for(int i=0; i<stockStatus.length;i++)
			if(symbol.equals(stockStatus[i].getSymbol()))
			{
				if( quantity == -1) {
					stockStatus[i].setStockQuantity(stockStatus[i].getStockQuantity()+ (int)(balance/stockStatus[i].getAsk()));
					float spent = ((int)(balance/stockStatus[i].getAsk()) *stockStatus[i].getAsk())/(-1); //how much bought
					updateBalance(spent);
				}
				else{
					stockStatus[i].setStockQuantity(stockStatus[i].getStockQuantity()+quantity);
					float spent1=(quantity*stockStatus[i].getAsk())/(-1);
					updateBalance(spent1);
				}
				return true;
			}
		return false;
	}
	/**
	 * method 
	 * @returns  HTML string description in bold font and break between lines 
	 * @date December 2014
	 */
	public String getHtmlString() 
	{
		String stockStr = "<h1>" + getTitle() + "</h1>" + "<br/>";
		
		stockStr+="<b> Total Protfolio Value: </b>"+ getTotalValue()+"$ <b> Total Stocks Value: </b>"+ getStocksValue()+ "$ <b> Balance </b>"+getBalance()+ "$ </br>";
		for (int i = 0; i < portfolioSize;i++ )
		{
			stockStr += stockStatus[i].getHtmlDescription()+"<br>";
		}
		
		return stockStr;
	}

	/**
	 * calculate value of stocks
	 * @return
	 */
	public float getStocksValue()
	{
		float sum=0;
		for (int i=0;i<portfolioSize;i++)
			sum+=stockStatus[i].getStockQuantity() * stockStatus[i].getBid();	
		
		return sum;
	}

	/**
	 * returns total value (balance +stocks value)
	 * @return
	 */
	public float getTotalValue()
	{
		return getBalance()+getStocksValue();
	}
	
}




