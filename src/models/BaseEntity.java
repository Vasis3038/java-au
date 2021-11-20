package models;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

public abstract class BaseEntity {
    protected String taskTitle;
    protected String taskUrl;
    protected String taskSolution;

    protected static Map<String,String> parseEntity(String data){
        var stringsFromData = new LinkedList<>(Arrays.asList(data.split(System.lineSeparator())));
        var resultMap = new HashMap<String, String>();
        resultMap.put("title", stringsFromData.pop());
        resultMap.put("url", stringsFromData.pop());
        resultMap.put("solution", String.join(System.lineSeparator(), stringsFromData));
        return resultMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarkDownEntity that = (MarkDownEntity) o;
        return Objects.equals(taskTitle, that.taskTitle) && Objects.equals(taskUrl, that.taskUrl) && Objects.equals(taskSolution, that.taskSolution);
    }
}
