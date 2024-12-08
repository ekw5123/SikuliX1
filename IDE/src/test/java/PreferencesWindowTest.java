import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sikuli.ide.PreferencesWin;
import org.sikuli.ide.SikulixIDE;
import org.sikuli.support.Commons;

import javax.swing.*;
import static org.junit.Assert.*;

public class PreferencesWindowTest extends SikulixIDE {
    private  static SikulixIDE ide;
    private static PreferencesWin preferencesWin;
    private static SikulixIDE.PaneContext pane;


    @BeforeClass
    public static void setUp() {
        SikulixIDE.start();
        ide = SikulixIDE.get();
        preferencesWin = new PreferencesWin();
        Commons.setTempFolder();
    }

    @Test
    public void testWindowVisible() {
        ide.showPreferencesWindow();
        assertTrue("Preferences window should be visible.", preferencesWin.isVisible());
    }

    @Test
    public void testAlwaysOnTop() {
        ide.showPreferencesWindow();
        assertTrue("Preferences window should be always on top.", preferencesWin.isAlwaysOnTop());
    }

    @Test
    public void testDefaultCloseOperation() {
        ide.showPreferencesWindow();
        assertEquals("Close operation should be DO_NOTHING_ON_CLOSE.",
                JFrame.DO_NOTHING_ON_CLOSE, preferencesWin.getDefaultCloseOperation());
    }

    @Test
    public void testFullBehavior() {
        ide.showPreferencesWindow();
        assertTrue("Preferences window should be visible.", preferencesWin.isVisible());
        assertTrue("Preferences window should be always on top.", preferencesWin.isAlwaysOnTop());
        assertEquals("Close operation should be DO_NOTHING_ON_CLOSE.",
                JFrame.DO_NOTHING_ON_CLOSE, preferencesWin.getDefaultCloseOperation());
    }
}
