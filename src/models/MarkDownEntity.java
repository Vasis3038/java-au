package models;

import java.lang.reflect.Array;
import java.util.*;

public class MarkDownEntity extends BaseEntity implements ItemEntity {
    public String mdTitle;
    public String mdLink;
    public String mdSolution;

    public MarkDownEntity(String taskTitle, String taskUrl, String taskSolution, List<List<String>> extraCode){
        this.taskTitle = taskTitle;
        this.taskUrl = taskUrl;
        this.taskSolution = taskSolution;
        this.extraCode = extraCode;
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

    public static MarkDownEntity parseMDEntity(String data, String... extraCodeBlocks){
        var fields = parseEntity(data);
        List<List<String>> listOfCodeBlocks = new ArrayList<>();
        for (String codeBlock: extraCodeBlocks) {
            listOfCodeBlocks.add(List.of(codeBlock.split(System.lineSeparator())));
        }
        return new MarkDownEntity(fields.get("title"), fields.get("url"), fields.get("solution"), listOfCodeBlocks);
    }

    private String getFormatted() {
        return mdTitle + System.lineSeparator() + System.lineSeparator() + taskUrl + System.lineSeparator() + System.lineSeparator() + mdSolution;
    }



    public static ArrayList<BaseEntity> getMDListFromStringList(ArrayList<String> stringList)
    {
        var solutionsList = new ArrayList<BaseEntity>();
        var subCounter = 0;
        var details = takeDetails(stringList);
        var detCount = 0;
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

                List<String> lstOfDet = new ArrayList<>();
                for (List<String> lstOfStr: details.get(detCount)) {
                    lstOfDet.add(String.join(System.lineSeparator(), lstOfStr));
                }
                //String[] arr = {lstOfDet.get(0), lstOfDet.get(1)};
                String[] arr = lstOfDet.toArray(String[]::new);;
                var realSolutionString = new StringBuilder(solutionString).delete(solutionString.indexOf("<details><summary>Test Cases</summary><blockquote>"), solutionString.indexOf("</blockquote></details>") + 25);
                solutionsList.add(MarkDownEntity.parseMDEntity(realSolutionString.toString(), arr));
                detCount++;
            }
        }
        return solutionsList;
    }


    private static List<List<List<String>>> takeDetails(ArrayList<String> stringList){
        List<List<List<String>>> details = new ArrayList<>();
        var result = new ArrayList<String>();

        var counter = 0;
        for (int i = 0; i < stringList.size(); i++) {
            if(stringList.get(i).contains("<details><summary>Test Cases</summary><blockquote>")){
                List<List<String>> listOfCodeBlocks = new ArrayList<>();
                while(!stringList.get(i).contains("</blockquote></details>")){
                    if(stringList.get(i).contains("```java")){
                        i++;
                        var codeBlock = new ArrayList<String>();
                        while(!stringList.get(i).contains("```")){
                            codeBlock.add(stringList.get(i));
                            i++;
                        }
                        listOfCodeBlocks.add(codeBlock);
                    }
                    i++;
                }
                details.add(listOfCodeBlocks);
            }
        }
        return details;
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
            resultString += getTaskTitleAndUrl(entity);
            resultString += getMdExtraCode(entity);
            resultString += getTask(entity);
        }
        return resultString;
    }

    private static String getMdExtraCode(BaseEntity entity){
        var mdCode = "";
        for (List<String> code: entity.extraCode) {
            mdCode += getExtraCodeBlock(code);
        }
        return "<details><summary>Test Cases</summary><blockquote>" + System.lineSeparator() + System.lineSeparator()
                + mdCode + System.lineSeparator() + "</blockquote></details>" + System.lineSeparator() + System.lineSeparator();
    }

    private static String getExtraCodeBlock(List<String> code){
        return "```java" + System.lineSeparator() + String.join(System.lineSeparator(), code)
                + System.lineSeparator() + "```" + System.lineSeparator();
    }

    private static String getTaskTitleAndUrl(BaseEntity entity){
        return "## " + entity.taskTitle + System.lineSeparator() + System.lineSeparator() + entity.taskUrl + System.lineSeparator() + System.lineSeparator();
    }

    private static String getTask(BaseEntity entity){
        var task = "";
        task += "```java" + System.lineSeparator();
        task += entity.taskSolution + System.lineSeparator();
        task += "```" + System.lineSeparator() + System.lineSeparator();
        return task;
    }

    private String mdCode(String code){
        return "```java" + System.lineSeparator() + code + "```" + System.lineSeparator();
    }
}
