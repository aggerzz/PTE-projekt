package logic;

import exceptions.FDimEjDefineret;
import exceptions.NegativKgException;

public interface Dimensionerendekraft {

	public double getNewton() throws FDimEjDefineret;
	public double getKg();
	public void setMellemRegning(String mellemRegning);
	public String getMellemRegning();
	public static final double tyngdekraft = 9.816;
	public double setNewton(double newton);
	public void setVaegt(double vaegt, Enhed enhed) throws NegativKgException, FDimEjDefineret;
	public boolean erVaegtNormal();
	
}
