package com.vaadin.tests.layouts.layouttester.HLayout;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;

import com.vaadin.testbench.elements.HorizontalLayoutElement;
import com.vaadin.tests.layouts.layouttester.BaseIconTest;

public class HIconTest extends BaseIconTest {

    @Override
    public void LayoutIcon() throws IOException {
        super.LayoutIcon();

        // The layout is too wide to fit into one screenshot, we need to scroll
        // and take another.

        List<HorizontalLayoutElement> layouts = $(HorizontalLayoutElement.class)
                .all();
        assertEquals(8, layouts.size());
        HorizontalLayoutElement lastOfRow1 = layouts.get(3);
        HorizontalLayoutElement lastOfRow2 = layouts.get(7);

        // scroll to both to ensure both contents are fully in view,
        // moveToElement fails on Firefox since the component is out of viewport
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", lastOfRow1);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", lastOfRow2);

        compareScreen("icon-scrolled");
    }
}
