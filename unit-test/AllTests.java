import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.*;
import logic.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({ UnitTests.class, IntegrationTests.class})

public class AllTests {

}
