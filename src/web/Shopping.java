package web;

public class Shopping {
	private String name;
	private String content;
	private int price;
	private int extraCount;
	private int count;
	private int mileage;
	private boolean isCount;
	private boolean isMileage;
	
	public Shopping(){}
	

	public void setIsCount(boolean isCount){
		this.isCount = isCount;
	}
	
	public void setIsMileage(boolean isMileage){
		this.isMileage = isMileage;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public void setCount(int count){
		this.count = count;
	}
	
	public void setMileage(int mileage){
		this.mileage = mileage;
	}
	public void setContent(String content){
		this.content = content;
	}
	public void setPrice(int price){
		this.price = price;
	}
	public void setExtraCount(int extraCount){
		this.extraCount = extraCount;
	}
	
	public String getName(){
		return name;
	}
	public String getContent(){
		return content;
	}
	public int getPrice(){
		return price;
	}
	public int getExtraCount(){
		return extraCount;
	}
	public int getCount(){
		return count;
	}
	
	public int getMileage(){
		return mileage;
	}
	public boolean getIsCount(){
		return isCount;
	}
	
	public boolean getIsMileage(){
		return isMileage;
	}
}
