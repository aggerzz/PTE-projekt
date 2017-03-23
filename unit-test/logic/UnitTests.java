package logic;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.BoejningsspaendingTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	BeregnSigmaN.class, 
	BoejningsmomentTest.class, 
	FlydespaendingTest.class,
	ForskydningsSpaendingTest.class,
	HalvProfilhoejdeTest.class, 
	InertimomentTest.class, 
	NormalkraftTest.class,
	SikkerhedsfaktorTest.class,
	BoejningsspaendingTest.class})

public class UnitTests {

}
