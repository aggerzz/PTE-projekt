package test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import logic.BeregnSigmaN;
import logic.BoejningsmomentTest;
import logic.ForskydningsSpaendingTest;
import logic.HalvProfilhoejdeTest;
import logic.InertimomentTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ OC3Test.class, OC4Test.class, OC5Test.class, OC6Test.class, OC7Test.class, OC9Test.class, OC13Test.class,
						BeregnSigmaN.class, HalvProfilhoejdeTest.class, InertimomentTest.class, OC15Test.class, BoejningsmomentTest.class, ForskydningsSpaendingTest.class})

public class AllTest {

}
