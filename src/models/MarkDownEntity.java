package models;

import java.util.*;

public class MarkDownEntity extends BaseEntity implements ItemEntity {
    public String mdTitle;
    public String mdLink;
    public String mdSolution;

    public MarkDownEntity(String taskTitle, String taskUrl, String taskSolution){
        this.taskTitle = taskTitle;
        this.taskUrl = taskUrl;
        this.taskSolution = taskSolution;
        mdTitle = getMdTitle(taskTitle);
        mdLink = getMdLink(taskTitle);
        mdSolution = getMdSolution(taskSolution);
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String getUrl() {
        return null;
    }

    @Override
    public String getSolution() {
        return null;
    }

    private String getMdSolution(String solution){
        return "```java" + solution + "```";
    }

    private String getMdTitle(String title){
        return "## " + title;
    }

    public static MarkDownEntity parseMDEntity(String data){
        var fields = parseEntity(data);
        return new MarkDownEntity(fields.get("title"), fields.get("url"), fields.get("solution"));
    }

    private String getFormatted() {
        return mdTitle + System.lineSeparator() + System.lineSeparator() + taskUrl + System.lineSeparator() + System.lineSeparator() + mdSolution;
    }

    public static ArrayList<BaseEntity> getMDListFromStringList(ArrayList<String> stringList)
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
                solutionsList.add(MarkDownEntity.parseMDEntity((solutionString)));
            }
        }
        return solutionsList;
    }

    private static String getSolutionBody(String MDBody){
        return MDBody.contains("```") ? "" : MDBody + System.lineSeparator();
    }

    private static String getTitle(String MDTitle){
        return MDTitle.split("# ")[1] + System.lineSeparator();
    }

    private static String getMdLink(String taskTitle) {
        return "+ [" + taskTitle + "](#" + String.join("-", taskTitle.toLowerCase().split(" ")) + ")" + System.lineSeparator();
    }

    public static String unitEntitiesInSolution(String fileName, List<BaseEntity> markDownEntities){
        var resultString = "# " + fileName + System.lineSeparator() + System.lineSeparator();
        for (BaseEntity entity: markDownEntities){
            resultString += getMdLink(entity.taskTitle);
        }
        resultString += System.lineSeparator();
        for (BaseEntity entity: markDownEntities){
            resultString += getTask(entity);
        }
        return resultString;
    }

    private static String getTask(BaseEntity entity){
        var task = "";
        task += "## " + entity.taskTitle + System.lineSeparator() + System.lineSeparator();
        task += entity.taskUrl + System.lineSeparator() + System.lineSeparator();
        task += "```java" + System.lineSeparator();
        task += entity.taskSolution + System.lineSeparator();
        task += "```" + System.lineSeparator() + System.lineSeparator();
        return task;
    }
}
