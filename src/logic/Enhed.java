package logic;

public enum Enhed {
	GRAM("g"),
	KG("kg"),
	TON("t"),
	NEWTON("N");
	private String enheder;
	Enhed(String enheder){
		this.enheder = enheder;
	}
	public String toString(){
		return enheder;
	}
}
