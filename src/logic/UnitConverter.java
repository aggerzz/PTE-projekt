package logic;

import java.math.BigDecimal;

import presentation.FrontPage;
import presentation.FrontPageMediator;

public class UnitConverter {

	private BigDecimal convertFromGram(BigDecimal g){
		return g.divide(new BigDecimal("1000"));
	}
	private BigDecimal convertFromTon(BigDecimal ton){
		return ton.multiply(new BigDecimal("1000"));
	}
	public BigDecimal convertToKg(String currentWeightValue,String currentUnit){
		if(currentUnit == "G"){
			return convertFromGram( new BigDecimal(currentWeightValue) );
		}
		if(currentUnit == "Kg"){
			return new BigDecimal(currentWeightValue);
		}
		if(currentUnit == "T"){
			return convertFromTon(new BigDecimal(currentWeightValue));
		}
		return null;
	}
}
