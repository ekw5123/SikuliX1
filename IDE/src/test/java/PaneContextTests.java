import org.sikuli.ide.EditorPane;
import org.sikuli.ide.SikulixIDE;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.*;

public class PaneContextTests extends SikulixIDE {

    private SikulixIDE.PaneContext pane;

    @Before
    public void setUp() {
        pane = SikulixIDE.get().getContext(); // Is this right?
    }

    @Test
    public void testPaneContextgetPane() {
        EditorPane example = pane.getPane();
        //todo
    }

    @Test
    public void testfocus() {

    }

    @Test
    public void testgetPane() {

    }

    @Test
    public void testisValid() {

    }

    @Test
    public void testisText() {

    }

    @Test
    public void testisTemp() {

    }

    @Test
    public void testhasContent() {

    }

    @Test
    public void testgetSupport() {

    }

    @Test
    public void testgetType() {

    }

    @Test
    public void testgetFolder() {

    }

    @Test
    public void testgetFile() {

    }

    @Test
    public void testgetFileName() {

    }

    @Test
    public void testgetExt() {

    }

    @Test
    public void testisBundle() {

    }

    @Test
    public void testisBundleFile() {

    }

    @Test
    public void testgetImageFolder() {

    }

    @Test
    public void testsetImageFolder() {

    }

    @Test
    public void testgetScreenshotFolder() {

    }

    @Test
    public void testgetScreenshotFileString() {

    }

    @Test
    public void testgetScreenshotFileFile() {

    } //the one with the args

    @Test
    public void testgetShowThumbs() {

    }

    @Test
    public void testsetShowThumbs() {

    }

    @Test
    public void testclose() {

    }

    @Test
    public void testcloseSilent() {

    }

    @Test
    public void testdoClose() {

    }

    @Test
    public void testdeleteNotUsedImages() {

    }

    @Test
    public void testdeleteNotUsedScreenshots() {

    }

    @Test
    public void testisDirty() {

    }

    @Test
    public void testsetDirty() {

    }

    @Test
    public void testnotDirty() {

    }

    @Test
    public void testsetFileTabTitleDirty() {

    }

    @Test
    public void testsave() {

    }

    @Test
    public void testsaveAs() {

    }

    @Test
    public void testload() {

    }

    @Test
    public void testloadFile() {

    }

    @Test
    public void testloadContext() {

    }

    @Test
    public void testinsertImageButton() {

    }

    @Test
    public void testresetContenttotext() {

    }
}
