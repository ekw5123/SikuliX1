import org.sikuli.ide.EditorPane;
import org.sikuli.ide.SikulixIDE;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.*;

public class PaneContextTests extends SikulixIDE{

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

}
