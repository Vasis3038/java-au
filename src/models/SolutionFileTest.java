package models;

import org.junit.jupiter.api.Test;
import utils.IOUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionFileTest {

    @Test
    void testToString() throws IOException {
        var expected = IOUtils.readFile("testArray.md");
        var solutionFile = new SolutionFile();
        var content = expected;
        var stringsFromData = new ArrayList<>(Arrays.asList(content.split(System.lineSeparator())));
        solutionFile.entityModelsList = getModelList(stringsFromData);
        solutionFile.fileName = "array";
        expected += System.lineSeparator() + System.lineSeparator();
        assertEquals(expected, solutionFile.toString());
    }

    @Test
    void parseFile() throws IOException {
        var expected = new SolutionFile();
        expected.fileName = "array";
        expected.fileType = "md";
        var stringsList = new ArrayList(Arrays.asList(getContent().split(System.lineSeparator())));
        expected.entityModelsList = getModelList(stringsList);;
        assertEquals(expected, new SolutionFile().parseFile(getContent(), "md", "array"));
    }

    private ArrayList<BaseEntity> getModelList(ArrayList<String> stringList){
        var solutionsList = new ArrayList<BaseEntity>();
        var subCounter = 0;
        for (int generalCounter = 0; generalCounter < stringList.size(); generalCounter++)
        {
            if (stringList.get(generalCounter).contains("## "))
            {
                var solutionString = getTitle(stringList.get(generalCounter));
                subCounter = generalCounter + 1;
                stringList.remove(subCounter);
                stringList.remove(subCounter + 1);
                while (subCounter < stringList.size() && !stringList.get(subCounter).contains("## ")) {
                    solutionString += getSolutionBody(stringList.get(subCounter));
                    subCounter++;
                }
                generalCounter = subCounter - 1;
                solutionsList.add(MarkDownEntity.parseMDEntity((solutionString)));
            }
        }
        return solutionsList;
    }

    private String getContent() throws IOException {
        return IOUtils.readFile("testArray.md");
    }

    private String getTitle(String MDTitle){

        return MDTitle.split("# ")[1] + System.lineSeparator();
    }

    private String getSolutionBody(String MDBody){
        return MDBody.contains("```") ? "" : MDBody + System.lineSeparator();
    }
}
