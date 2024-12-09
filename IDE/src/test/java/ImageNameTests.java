import org.junit.BeforeClass;
import org.sikuli.ide.SikulixIDE;
import org.junit.Test;
import org.sikuli.support.Commons;

import static org.junit.Assert.*;

public class ImageNameTests extends SikulixIDE {

    private static SikulixIDE ide;
    private static String testCursorLine;
    private static SikulixIDE.PaneContext pane;


    @BeforeClass
    public static void setUp() {
        SikulixIDE.start();
        ide = SikulixIDE.get();
        //ide.show();
        pane = ide.getContext();
        Commons.setTempFolder();
        testCursorLine = "";
    }

    @Test
    public void testGetImageNameFromLine_beforeAfterEquals() {
        // Test case 1: Standard valid input
        testCursorLine = "image123=path/to/image"; // Simulating input
        pane.getPane().insertString(testCursorLine + "\n");
        assertEquals("Valid. Will extract image name before '='.", "image123", ide.getImageNameFromLine());
    }

    @Test
        public void testGetImageNameFromLine_extraSpaces() {
        // Test case 2: Input with spaces
        testCursorLine = "   imageName_with_spaces   =path/to/image";
        pane.getPane().insertString(testCursorLine + "\n");
        assertEquals("Valid. Will handle leading/trailing spaces.", "imageName_with_spaces", ide.getImageNameFromLine());
    }

    @Test
    public void testGetImageNameFromLine_missingEquals() {
        // Test case 3: Input with no '='
        testCursorLine = "noEqualsSignHere";
        pane.getPane().insertString(testCursorLine + "\n");
        assertEquals("Return empty string if '=' is missing.", "", ide.getImageNameFromLine());
    }

    @Test
    public void testGetImageNameFromLine_emptyInput() {
        // Test case 4: Empty input
        testCursorLine = "";
        pane.getPane().insertString(testCursorLine + "\n");
        assertEquals("Return empty string for empty input.", "", ide.getImageNameFromLine());
    }

    @Test
    public void testGetImageNameFromLine_specialChars() {
        // Test case 5: Input with special characters
        testCursorLine = "special_chars!@#=path/to/image";
        pane.getPane().insertString(testCursorLine + "\n");
        assertEquals("Extract image name with special characters.", "special_chars", ide.getImageNameFromLine());
    }

    @Test
    public void testGetImageNameFromLine_onlyEquals() {
        // Test case 6: Input with only '='
        testCursorLine = "=";
        pane.getPane().insertString(testCursorLine + "\n");
        assertEquals("Return empty string when only '=' is present.", "", ide.getImageNameFromLine());
    }

    @Test
    public void testGetImageNameFromLine_multipleEquals() {
        // Test case 7: Input with multiple '='
        testCursorLine = "multi=equals=signs=path";
        pane.getPane().insertString(testCursorLine + "\n");
        assertEquals("Extract only the part before the first '='.", "multi", ide.getImageNameFromLine());
    }

    @Test
    public void testGetImageNameFromLine_numericValues() {
        // Test case 8: Input with numeric values
        testCursorLine = "12345=image.jpg";
        pane.getPane().insertString(testCursorLine + "\n");
        assertEquals("Extract numeric image name.", "12345", ide.getImageNameFromLine());
    }

    @Test
    public void testGetImageNameFromLine_longName() {
        // Test case 9: Input with a lengthy amount of characters
        testCursorLine = "verylongimagename123456789012345678901234567890=path";
        pane.getPane().insertString(testCursorLine + "\n");
        assertEquals("Extract numeric image name.", "verylongimagename123456789012345678901234567890", ide.getImageNameFromLine());
    }

    @Test
    public void testGetImageNameFromLine_onlyRightOfTwoEquals() {
        // Test case 10: Input that begins with to equals
        testCursorLine = "==image123=path";
        pane.getPane().insertString(testCursorLine + "\n");
        assertEquals("Extract numeric image name.", "", ide.getImageNameFromLine());
    }

    @Test
    public void testGetImageNameFromLine_singleName() {
        // Test case 11: Input that has a name of a single char
        testCursorLine = "a=path";
        pane.getPane().insertString(testCursorLine + "\n");
        assertEquals("Extract numeric image name.", "a", ide.getImageNameFromLine());
    }

}
