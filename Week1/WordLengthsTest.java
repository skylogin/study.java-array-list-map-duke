

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.duke.FileResource;

/**
 * The test class WordLengthsTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class WordLengthsTest
{
    private WordLengths wordlengths;
    private FileResource resource;
    private int[] counts;

    @Before
    public void setUp() throws Exception {
        this.wordlengths = new WordLengths();
        this.resource = new FileResource("./data/manywords.txt");
        this.counts = new int[1024];
    }

    @After
    public void tearDown() throws Exception {
        this.wordlengths = null;
    }

    @Test
    public void indexOfMaxTest() {
        wordlengths.countWordLengths(resource, counts);
        assertEquals(3, wordlengths.indexOfMax(counts));
    }
}
