package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import enums.FileType;

public class SolutionFile {
    public List<BaseEntity> entityModelsList;
    private String fileName;

    public void add(BaseEntity entity){
        entityModelsList.add(entity);
    }

    @Override
    public String toString(){
        var resultString = "# " + fileName + System.lineSeparator() + System.lineSeparator();
        for (BaseEntity entity: entityModelsList){
            resultString += getMdLink(entity.taskTitle);
        }
        resultString += System.lineSeparator();
        for (BaseEntity entity: entityModelsList){
            resultString += getTask(entity);
        }
        return resultString;
    }

    private String getTask(BaseEntity entity){
        var task = "";
        task += "## " + entity.taskTitle + System.lineSeparator() + System.lineSeparator();
        task += entity.taskUrl + System.lineSeparator() + System.lineSeparator();
        task += "```java" + System.lineSeparator();;
        task += entity.taskSolution + System.lineSeparator();
        task += "```" + System.lineSeparator() + System.lineSeparator();
        return task;
    }

    private String getMdLink(String taskTitle)
    {
        return "+ [" + taskTitle + "](#" + String.join("-", taskTitle.toLowerCase().split(" ")) + ")" + System.lineSeparator();
    }

    private SolutionFile(List<BaseEntity> entityModelsList, String fileName){
        this.entityModelsList = entityModelsList;
        this.fileName = fileName;
    }

    public SolutionFile(){}

    public SolutionFile parseFile(String content, String fileType, String fileName){
        var solutionsList = new ArrayList<BaseEntity>();
        var stringsFromData = new ArrayList<>(Arrays.asList(content.split(System.lineSeparator())));
        if (fileType == "md"){
            solutionsList = getMDListFromStringList(stringsFromData);
        }
        if (fileType == "HTML"){
        }
        if (fileType == "XML"){
        }
        return new SolutionFile(solutionsList, fileName);
    }

    private String getTitle(String MDTitle){

        return MDTitle.split("# ")[1] + System.lineSeparator();
    }

    private String getSolutionBody(String MDBody){
        return MDBody.contains("```") ? "" : MDBody + System.lineSeparator();
    }

    private ArrayList<BaseEntity> getMDListFromStringList(ArrayList<String> stringList)
    {
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
                solutionsList.add(MarkDownEntity.parseEntity((solutionString)));
            }
        }
        return solutionsList;
    }
}