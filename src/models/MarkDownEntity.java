package models;

import java.util.Arrays;
import java.util.LinkedList;

public class MarkDownEntity extends BaseEntity{

    @Override
    public String getTitle(){
        return this.taskTitle;
    }

    @Override
    public String getUrl(){
        return this.taskUrl;
    }

    @Override
    public String getSolution(){
        return this.taskSolution;
    }

    public static MarkDownEntity parseEntity(String data){
        var stringsFromData = new LinkedList<>(Arrays.asList(data.split(System.lineSeparator())));//
        var title = stringsFromData.pop();
        var url = stringsFromData.pop();
        var solution = String.join(System.lineSeparator(), stringsFromData);
        return new MarkDownEntity(title, url, solution);
    }

    public MarkDownEntity(String taskTitle, String taskUrl, String taskSolution){
        this.taskTitle = taskTitle;
        this.taskUrl = taskUrl;
        this.taskSolution = taskSolution;
    }
}