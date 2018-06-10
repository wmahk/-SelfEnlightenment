package beans;

import java.io.Serializable;
import java.math.BigDecimal;

public class LimitValue implements Serializable{

	//指値用beans


	//この金額になったら売るor買う！
	private String userID;
	private BigDecimal limitSell;
	private BigDecimal limitBuy;

	//いくら分売るかor買うか
	private BigDecimal SellValue;
	private BigDecimal BuyValue;


	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public BigDecimal getLimitSell() {
		return limitSell;
	}
	public void setLimitSell(BigDecimal limitSell) {
		this.limitSell = limitSell;
	}
	public BigDecimal getLimitBuy() {
		return limitBuy;
	}
	public void setLimitBuy(BigDecimal limitBuy) {
		this.limitBuy = limitBuy;
	}

	public BigDecimal getSellValue() {
		return SellValue;
	}
	public void setSellValue(BigDecimal sellValue) {
		SellValue = sellValue;
	}
	public BigDecimal getBuyValue() {
		return BuyValue;
	}
	public void setBuyValue(BigDecimal buyValue) {
		BuyValue = buyValue;
	}
	@Override
	public String toString() {
		return "LimitValue [userID=" + userID + ", limitSell=" + limitSell + ", limitBuy=" + limitBuy + "]";
	}



	//IOをここに書く

}
