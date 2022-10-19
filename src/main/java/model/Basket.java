package model;

public class Basket {
	Integer bId;
	String bName;
	Double bPrice;
	Integer bQuantity;
	
	public Basket() {
		super();
	}
	
	

	public Basket(String bName, Double bPrice) {
		super();
		this.bName = bName;
		this.bPrice = bPrice;
	}



	public Basket(String bName, Double bPrice, Integer bQuantity) {
		super();
		this.bName = bName;
		this.bPrice = bPrice;
		this.bQuantity = bQuantity;
	}


	public Basket(Integer bId, String bName, Double bPrice, Integer bQuantity) {
		super();
		this.bId = bId;
		this.bName = bName;
		this.bPrice = bPrice;
		this.bQuantity = bQuantity;
	}

	public Integer getbId() {
		return bId;
	}

	public String getbName() {
		return bName;
	}

	public Double getbPrice() {
		return bPrice;
	}

	public Integer getbQuantity() {
		return bQuantity;
	}

	public void setbId(Integer bId) {
		this.bId = bId;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public void setbPrice(Double bPrice) {
		this.bPrice = bPrice;
	}

	public void setbQuantity(Integer bQuantity) {
		this.bQuantity = bQuantity;
	}

	@Override
	public String toString() {
		return "Basket [bId=" + bId + ", bName=" + bName + ", bPrice=" + bPrice + ", bQuantity=" + bQuantity + "]";
	}
	
	
	
}
