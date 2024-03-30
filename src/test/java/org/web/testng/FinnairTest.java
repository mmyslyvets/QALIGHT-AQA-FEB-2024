package org.web.testng;

import org.testng.annotations.Test;

public class FinnairTest extends AbstractNGTest {

    //TODO 1: add new table flight dest (City name, price tag)
    // TODO 2: open https://www.finnair.com/en/destinations?country=fi
    // TODO 3: tae four top destinations and for each:
    // TODO 3.1: If record for this dest is already in DB, compare price.
    //  If price has changed: update price and fail test
    //  If price did not change - test passes.
    // TODO 3.2: If record for this dest is not present, store it, test passes

    @Test
    public void myGoogleTest1() {
        System.out.println("my finnair ng 1");
    }

    @Test
    public void myGoogleTest2() {
        System.out.println("my finnair ng 2");
    }

    @Test
    public void myGoogleTest3() {
        System.out.println("my finnair ng 3");
    }
}
