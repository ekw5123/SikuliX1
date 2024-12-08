import org.sikuli.ide.SikulixIDE;
import org.junit.Before;
import org.junit.Test;
import org.sikuli.support.Commons;

import static org.junit.Assert.*;

public class ImageNameTests extends SikulixIDE {

    private  SikulixIDE ide;
    private String testCursorLine;
    private  SikulixIDE.PaneContext pane;

    @Override
    public String getLineTextAtCaret() { // Override the existing method
        System.out.println("Overridden method called!");
        return testCursorLine;
    }

    @Before
    public void setUp() {
        SikulixIDE.start();
        ide = SikulixIDE.get();

        pane = ide.getContext();
        Commons.setTempFolder();
        testCursorLine = "";
    }

    @Test
    public void testGetImageNameFromLine_beforeAfterEquals() {
        // Test case 1: Standard valid input
        ImageNameTests myTest = new ImageNameTests();
        testCursorLine = "image123=path/to/image"; // Simulating input
        String temp = myTest.getImageNameFromLine();
        assertEquals("Valid. Will extract image name before '='.", "image123", temp);
    }

    @Test
        public void testGetImageNameFromLine_extraSpaces() {
        // Test case 2: Input with spaces
        ImageNameTests myTest = new ImageNameTests();
        testCursorLine = "   imageName_with_spaces   =path/to/image";
        assertEquals("Valid. Will handle leading/trailing spaces.", "imageName_with_spaces", ide.getImageNameFromLine());
    }

    @Test
    public void testGetImageNameFromLine_missingEquals() {
        // Test case 3: Input with no '='
        ImageNameTests myTest = new ImageNameTests();
        testCursorLine = "noEqualsSignHere";
        assertEquals("Return empty string if '=' is missing.", "", ide.getImageNameFromLine());
    }

    @Test
    public void testGetImageNameFromLine_emptyInput() {
        // Test case 4: Empty input
        ImageNameTests myTest = new ImageNameTests();
        testCursorLine = "";
        assertEquals("Return empty string for empty input.", "", ide.getImageNameFromLine());
    }

    @Test
    public void testGetImageNameFromLine_specialChars() {
        // Test case 5: Input with special characters
        ImageNameTests myTest = new ImageNameTests();
        testCursorLine = "special_chars!@#=path/to/image";
        assertEquals("Extract image name with special characters.", "special_chars!@#", ide.getImageNameFromLine());
    }

    @Test
    public void testGetImageNameFromLine_onlyEquals() {
        // Test case 6: Input with only '='
        ImageNameTests myTest = new ImageNameTests();
        testCursorLine = "=";
        assertEquals("Return empty string when only '=' is present.", "", ide.getImageNameFromLine());
    }

    @Test
    public void testGetImageNameFromLine_multipleEquals() {
        // Test case 7: Input with multiple '='
        ImageNameTests myTest = new ImageNameTests();
        testCursorLine = "multi=equals=signs=path";
        assertEquals("Extract only the part before the first '='.", "multi", ide.getImageNameFromLine());
    }

    @Test
    public void testGetImageNameFromLine_numericValues() {
        // Test case 8: Input with numeric values
        ImageNameTests myTest = new ImageNameTests();
        testCursorLine = "12345=image.jpg";
        assertEquals("Extract numeric image name.", "12345", ide.getImageNameFromLine());
    }

    @Test
    public void testGetImageNameFromLine_longName() {
        // Test case 9: Input with a lengthy amount of characters
        ImageNameTests myTest = new ImageNameTests();
        testCursorLine = "verylongimagename123456789012345678901234567890=path";
        assertEquals("Extract numeric image name.", "verylongimagename123456789012345678901234567890", ide.getImageNameFromLine());
    }

    @Test
    public void testGetImageNameFromLine_onlyRightOfTwoEquals() {
        // Test case 10: Input that begins with to equals
        ImageNameTests myTest = new ImageNameTests();
        testCursorLine = "==image123=path";
        assertEquals("Extract numeric image name.", "", ide.getImageNameFromLine());
    }

    @Test
    public void testGetImageNameFromLine_singleName() {
        // Test case 11: Input that has a name of a single char
        ImageNameTests myTest = new ImageNameTests();
        testCursorLine = "a=path";
        assertEquals("Extract numeric image name.", "a", ide.getImageNameFromLine());
    }

}
