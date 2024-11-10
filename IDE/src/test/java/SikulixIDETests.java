import org.sikuli.ide.SikulixIDE;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.*;

public class SikulixIDETests extends SikulixIDE {

    private SikulixIDE ide;

    @Before
    public void setUp() {
        ide = SikulixIDE.get();
    }

    @Test
    public void testSikuliIDESetWindow() {
        // Set the window and verify it's set
        ide.setWindow();
        JFrame frame = (JFrame) ide;
        assertNotNull("IDE window should be set and not null", frame);
    }

    @Test
    public void testGetInstance() {
        // Verify that the singleton instance is non-null
        assertNotNull("SikulixIDE instance should not be null", SikulixIDE.get()); //This returns the singleton
    }


    @Test
    public void testGetWindowRect() {
        // Verify that the window rectangle is defined and has minimum dimensions
        Rectangle rect = SikulixIDE.getWindowRect();
        assertNotNull("Window rectangle should not be null", rect);
        assertTrue("Window width should be at least 800", rect.width >= 800);
        assertTrue("Window height should be at least 600", rect.height >= 600);
    }

    @Test
    public void testGetWindowCenter() {
        // Verify that the center point of the window is calculated correctly
        Point center = SikulixIDE.getWindowCenter();
        assertNotNull("Window center should not be null", center);
    }

    @Test
    public void testGetWindowTop() {
        // Verify that the top point of the window is calculated correctly
        Point top = SikulixIDE.getWindowTop();
        assertNotNull("Window top should not be null", top);
    }

    @Test
    public void testSetIDETitle() {
        //Good for Domain Modeling

        // Set the title and verify it's set correctly
        String title = "Test Title";
        ide.setIDETitle(title);
        assertEquals("IDE window title should match the set title", title, ide.getTitle());
    }

    @org.junit.Test
    public void SikuliValidateHidden() {
        SikulixIDE IDE=  SikulixIDE.get();
        IDE.start();
        IDE.setWindow();
//        IDE.start();
//      validate that sikulixIDE is hidden by default baseline test
        assertEquals(IDE.notHidden(),false);
        IDE.doShow();

        assertEquals(IDE.notHidden(),true);
//        IDE.terminate();

    }

    @org.junit.Test
    public void SikuliValidateGetFileName() {
        SikulixIDE IDE=  SikulixIDE.get();
        IDE.start();
        IDE.setWindow();
        IDE.doShow();
        PaneContext context=IDE.getContext();
        context.getFileName();
        assertEquals(context.getFileName(),"sxtemp1.py");

    }
    @org.junit.Test
    public void SikuliValidateGetExt() {
        SikulixIDE IDE = SikulixIDE.get();
        IDE.start();
        IDE.setWindow();
        IDE.doShow();
        PaneContext context = IDE.getContext();
        context.getExt();
        assertEquals(context.getExt(), "py");
    }


    @Test
    public void testDoHideWithWaitTime() {
        // Hide IDE with wait time and verify visibility
        float waitTime = 0.5f;
        ide.doHide(waitTime);
        assertFalse("IDE should be hidden after doHide with waitTime is called", SikulixIDE.notHidden()); //Do we need to thread sleep here?
    }


    @Test
    public void SikuliValidateGetFile() {
        SikulixIDE IDE=  SikulixIDE.get();
        IDE.start();
        IDE.setWindow();
        IDE.doShow();

    }
    @Test
    public void SikuliValidateSave() {
        SikulixIDE IDE=  SikulixIDE.get();
        IDE.start();
        IDE.setWindow();
        IDE.doShow();

    }

    @Test
    public void SikuliValidateSaveAs() {
        SikulixIDE IDE=  SikulixIDE.get();
        IDE.start();
        IDE.setWindow();
        IDE.doShow();

    }

    @Test
    public void SikuliValidateshowAfterStart() {
        //Could do some interesting threaded tests here
    }

    @Test
    public void SikuliValidateselectFileToOpen() {
        //todo
    }
    @Test
    public void SikuliValidatefileSelected() {
        //todo
    }
    @Test
    public void SikuliValidateselectFileForSave() {
        //todo
    }
    @Test
    public void SikuliValidateexportAsZip() {
        //todo
    }
    @Test
    public void SikuliValidatereparseOnRenameImage() {
        //todo
    }
    @Test
    public void SikuliValidateReparseRenameImages() {
        //todo
    }
    @Test
    public void SikuliValidateGetImageNameFromLine() {
        //todo
    }
    @Test
    public void SikuliValidateShowPreferencesWindow() {
        //todo
    }
    @Test
    public void SikuliValidateRunNormal() {
        //todo
    }
    @Test
    public void SikuliValidateRunShowActions() {
        //todo
    }
    @Test
    public void SikuliValidateRunSelected() {
        //todo
    }
}
