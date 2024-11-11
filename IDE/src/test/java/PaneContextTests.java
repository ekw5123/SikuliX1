import org.junit.BeforeClass;
import org.sikuli.ide.EditorPane;
import org.sikuli.ide.SikulixIDE;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;


public class PaneContextTests extends SikulixIDE {

    private static SikulixIDE ide;
    private static SikulixIDE.PaneContext pane;

    @BeforeClass
    public static void setUp() {
        SikulixIDE.start();
        ide = SikulixIDE.get();
        pane = ide.getContext();
    }

    File directorySetup(String directory, Set<String> images)
    {
        File Dir = new File(directory);
        Dir.mkdir();
        for(String image : images)
        {
            File f = new File(directory+"\\"+image);
            try
            {
                f.createNewFile();
            }
            catch ( IOException e)
            {
                fail("Couldn't create files");
            }
        }
        return Dir;
    }

    @Test
    public void deleteNotUsedScreenshots_noDirectory() {
        File Dir = new File("I wont exist");
        try {
            pane.deleteNotUsedScreenshots(Dir,null);
        }
        catch (Exception e)
        {
            fail("Exception caught when passing an invalid dir to function");
        }
    }

    @Test
    public void deleteNotUsedScreenshots_noFiles() {
        Set<String> images = new HashSet<String>();
        File Dir = new File("./tmp");
        Dir.mkdir(); //I'm assuming you will work
        try {
            pane.deleteNotUsedScreenshots(Dir,images);
            if(!Dir.exists())
            {
                fail("Invalid test since the folder didnt exist");
            }
        }
        catch (Exception e)
        {
            fail("Exception caught when passing an invalid dir to function");
        }
        Dir.delete();
    }

    @Test
    public void deleteNotUsedScreenshots_usedFiles() {
        Set<String> images = new HashSet<String>();
        String dirName = "tmp";
        images.add("tmp1.jpg");
        images.add("tmp2.jpg");
        images.add("tmp3.jpg");
        File Dir = directorySetup(dirName, images);
        try {
            pane.deleteNotUsedScreenshots(Dir,images);
            if(!Dir.exists())
            {
                fail("Invalid test since the folder didnt exist");
            }
            assertTrue("Wrong file count ",Dir.listFiles().length == 3); //Function shouldn't delete anything, since they were used
        }
        catch (Exception e)
        {
            fail("Exception caught when passing an invalid dir to function");
        }
        for(File f : Dir.listFiles())
        {
            f.delete();
        }
        Dir.delete();
    }

    @Test
    public void deleteNotUsedScreenshots_unusedFiles() {
        Set<String> images = new HashSet<String>();
        Set<String> none = new HashSet<String>();
        String dirName = "./tmp";
        images.add("tmp1.jpg");
        images.add("tmp2.jpg");
        images.add("tmp3.jpg");
        File Dir = directorySetup("./tmp", images);
        try {
            pane.deleteNotUsedScreenshots(Dir,none);
            if(!Dir.exists())
            {
                fail("Invalid test since the folder didnt exist");
            }
            assertTrue("Wrong file count " + Dir.listFiles().length, Dir.listFiles().length == 0); //Function should have deleted every file, since none were used
        }
        catch (Exception e)
        {
            fail("Exception caught when passing an invalid dir to function");
        }
        for(File f : Dir.listFiles())
        {
            f.delete();
        }
        Dir.delete();
    }

    @Test
    public void deleteNotUsedScreenshots_mixedFiles() {
        Set<String> images = new HashSet<String>();
        String dirName = "tmp";
        images.add("tmp1.jpg");
        images.add("tmp2.jpg");
        images.add("tmp3.jpg");
        images.add("tmp4.jpg");
        images.add("tmp5.jpg");
        File Dir = directorySetup(dirName, images);
        Set<String> newimages = new HashSet<String>();
        newimages.add("tmp1.jpg");
        newimages.add("tmp2.jpg");
        try {
            pane.deleteNotUsedScreenshots(Dir,newimages);
            if(!Dir.exists())
            {
                fail("Invalid test since the folder didnt exist");
            }
            assertTrue("Wrong file count " + Dir.listFiles().length,Dir.listFiles().length == 2); //Function should leave 2 photos
        }
        catch (Exception e)
        {
            fail("Exception caught when passing an invalid dir to function");
        }
        for(File f : Dir.listFiles())
        {
            f.delete();
        }
        Dir.delete();
    }

    @Test
    public void testsetIDETitle_ASCII() {
        String germanString = "Entwickeln Sie mit Vergnügen";
        byte[] germanBytes = germanString.getBytes();
        String asciiEncodedString = new String(germanBytes, StandardCharsets.US_ASCII);
        ide.setIDETitle(asciiEncodedString);
        //ide.doShow(); //Debug and check encoding on strings
        assertEquals("Strings no longer match!", ide.getTitle(), asciiEncodedString);
    }

    @Test
    public void testsetIDETitle_UTF_8() {
        String germanString = "Entwickeln Sie mit Vergnügen";
        byte[] germanBytes = germanString.getBytes();
        String asciiEncodedString = new String(germanBytes, StandardCharsets.UTF_8);
        ide.setIDETitle(asciiEncodedString);
        //ide.doShow(); //Debug and check encoding on strings
        assertEquals("Strings no longer match!", ide.getTitle(), asciiEncodedString);
    }

    @Test
    public void testsetIDETitle_Unicode() {
        String encodedString = "Hello \u0057\u006F\u0072\u006C\u0064"; //Hello World in Unicode
        ide.setIDETitle(encodedString);
        //ide.doShow(); //Debug and check encoding on strings
        assertEquals("Strings no longer match!", ide.getTitle(), encodedString);
    }
}
