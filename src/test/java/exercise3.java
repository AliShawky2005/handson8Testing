import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/* Ali Ahmed Shawky       2022170910        SWE */

public class exercise3 {

    @BeforeGroups("Smoke")
    public void startSmoke() {
        System.out.println("Starting Smoke group...");
    }

    @BeforeGroups("Regression")
    public void startRegression() {
        System.out.println("Starting Regression group...");
    }

    @Test(groups = {"Smoke"})
    public void testHomepageLoads() {
        System.out.println("  [Smoke] Running: testHomepageLoads");
    }

    @Test(groups = {"Smoke"})
    public void testLoginPageVisible() {
        System.out.println("  [Smoke] Running: testLoginPageVisible");
    }

    @Test(groups = {"Smoke"})
    public void testFooterLinks() {
        System.out.println("  [Smoke] Running: testFooterLinks");
    }

    @Test(groups = {"Regression"})
    public void testLoginValidCreds() {
        System.out.println("  [Regression] Running: testLoginValidCreds");
    }

    @Test(groups = {"Regression"})
    public void testLoginInvalidCreds() {
        System.out.println("  [Regression] Running: testLoginInvalidCreds");
    }

    @Test(groups = {"Regression"})
    public void testPasswordReset() {
        System.out.println("  [Regression] Running: testPasswordReset");
    }

    @Test(groups = {"Regression"})
    public void testAccountBalance() {
        System.out.println("  [Regression] Running: testAccountBalance");
    }

    @AfterGroups("Smoke")
    public void endSmoke() {
        System.out.println("Finished Smoke group execution.");
    }

    @AfterGroups("Regression")
    public void endRegression() {
        System.out.println("Finished Regression group execution.");
    }
}