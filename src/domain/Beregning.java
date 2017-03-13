package domain;

import java.math.BigDecimal;

public class Beregning {
String resultName;
String equation;
BigDecimal result;
public String getResultName() {
	return resultName;
}
public void setResultName(String resultName) {
	this.resultName = resultName;
}
public String getEquation() {
	return equation;
}
public void setEquation(String equation) {
	this.equation = equation;
}
public BigDecimal getResult() {
	return result;
}
public void setResult(BigDecimal result) {
	this.result = result;
}
@Override
public String toString() {
	return "Beregning: resultName=" + resultName + ", equation=" + equation + ", result=" + result;
}




}
