package com.ait.qa31.hws;

import org.testng.annotations.Test;

public class HWTests extends TestBase{

    @Test
    public void findElementsByCssSelector() {
        findTenElementsByCssSelector();
    }

    @Test
    public void findElementsByXpath() {
        findTenElementsByXpath();
    }

}
