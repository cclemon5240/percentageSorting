package sorting;

import java.math.BigDecimal;

public class invest {

	public String investName;
	
	public BigDecimal investNum;

	public invest(String investName,BigDecimal investNum) {
		this.investName = investName;
		this.investNum = investNum;
	}
	public String getInvestName() {
		return investName;
	}

	public void setInvestName(String investName) {
		this.investName = investName;
	}

	public BigDecimal getInvestNum() {
		return investNum;
	}

	public void setInvestNum(BigDecimal investNum) {
		this.investNum = investNum;
	}
}
