package models;

import org.junit.jupiter.api.Test;
import utils.IOUtils;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class MarkDownEntityTest {

    @Test
    void parseMDEntity() throws IOException {
        var expected = new MarkDownEntity(getTestTitle(), getTestUrl(), getTestSolution());
        var a = MarkDownEntity.parseMDEntity(getSolution());
        assertEquals(expected, MarkDownEntity.parseMDEntity(getSolution()));
    }

    private String getTestSolution() throws IOException { return IOUtils.readFile("testSolution.txt"); }

    private String getTestTitle() throws IOException { return IOUtils.readFile("testTitle.txt"); }

    private String getTestUrl() throws IOException { return IOUtils.readFile("testUrl.txt"); }

    private String getSolution() throws IOException { return IOUtils.readFile("solution.txt"); }
}
