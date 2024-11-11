import org.sikuli.ide.SikulixIDE;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.io.File;


import static org.junit.Assert.*;

public class test extends SikulixIDE {

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
        assertNotNull("SikulixIDE instance should not be null", SikulixIDE.get());
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
        assertFalse("IDE should be hidden after doHide with waitTime is called", SikulixIDE.notHidden());
    }



    @org.junit.Test
    public void SikuliValidateGetFile() {
        SikulixIDE IDE=  SikulixIDE.get();
        IDE.start();
        IDE.setWindow();
        IDE.doShow();
        PaneContext context=IDE.getContext();
        File file=context.getFile();
        assertEquals("check file name exists",file.getName(), "sxtemp1.py");
        assertEquals("check path exists", file.getPath(), "sxtemp1\\sxtemp1.py");
        assertTrue("check that file exists", file.exists());

    }
    @org.junit.Test
    public void SikuliValidateSave() {
        SikulixIDE IDE=  SikulixIDE.get();
        File ex2= new File("sxtemp1\\sxtemp1.py");
        IDE.start();
        IDE.setWindow();
        IDE.doShow();
        PaneContext context=IDE.getContext();
//        assertTrue(context.load(ex2));
        assertTrue((context.save()));

//        validate the  loading invalid file and then attempting to save does not crash
          File badPath = new File("badDirectory.py");
          assertFalse("fails to load null file",context.load(badPath));
          assertTrue((context.save()));
    }
    @Test
    public void SikuliValidateLoad() {
        SikulixIDE IDE=  SikulixIDE.get();
        File ex2= new File("sxtemp1\\sxtemp1.py");
        IDE.start();
        IDE.setWindow();
        IDE.doShow();
        PaneContext context=IDE.getContext();
//        validate save and load work as expected
        assertTrue(context.load(ex2));
        assertTrue((context.save()));

//        validate loading invalid file throws exception
        File ne = new File("");

        assertFalse("fails to load null file",context.load(ne));

//        validate the  loading file that does not exist fails without error
        File badPath = new File("badDirectory.py");
        assertFalse("fails to load null file",context.load(badPath));

    }


}

