package logic;

import java.text.DecimalFormat;
import exceptions.NegativKgException;

public class DimensionerendekraftImpl implements Dimensionerendekraft {
	private double kg = Double.NaN;
	private String mellemRegning;
	private double oevreGraense = 100000;
	private double nedreGraense = 0;	
	
	@Override
	public double setNewton(double newton) {
		// TODO Auto-generated method stub
		return 0;
	}
	public void setVaegt(double vaegt, Enhed enhed) throws NegativKgException{
		if (vaegt<=0)
			throw new NegativKgException();
		switch(enhed){
		case TON:
			setKg(vaegt*1000);
			break;
		case KG:
			setKg(vaegt);
			break;
		case GRAM:
			setKg(vaegt/1000);
			break;
		case NEWTON:
			setKg(vaegt/tyngdekraft);
			break;
		}
	}
	public double getNewton() {		
		return kg * tyngdekraft;
	}

	private void setKg(double kg) {
		DecimalFormat formatter = new DecimalFormat("#0.00000");
		
		this.kg = kg;
		String kgText = formatter.format(this.kg);
		String newtonText = formatter.format(getNewton());
		setMellemRegning("kg * g = FDim "  + "\n"  + kgText + " * " + tyngdekraft + " = " + newtonText + "\n");

	}

	@Override
	public double getKg() {		
		return kg;
	}

	@Override
	public void setMellemRegning(String mellemRegning) {
		this.mellemRegning = mellemRegning;
	}

	@Override
	public String getMellemRegning() {
		return mellemRegning;
	}

	@Override
	public boolean erVaegtNormal() {
		return(nedreGraense<kg && kg<=oevreGraense);
	}
}
