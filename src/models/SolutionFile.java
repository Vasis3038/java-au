package models;

import enums.FileType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SolutionFile {
    public List<BaseEntity> entityModelsList;
    public String fileName;
    public String fileType;

    public SolutionFile(){}

    private SolutionFile(List<BaseEntity> entityModelsList, String fileName, String fileType){
        this.entityModelsList = entityModelsList;
        this.fileName = fileName;
        this.fileType = fileType;
    }

    public void add(BaseEntity entity){
        entityModelsList.add(entity);
    }

    public SolutionFile parseFile(String content, String fileType, String fileName){
        var solutionsList = new ArrayList<BaseEntity>();
        var stringsFromContent = new ArrayList<>(Arrays.asList(content.split(System.lineSeparator())));
        if (FileType.MARKDOWN.getValue().equals(fileType)){
            solutionsList = MarkDownEntity.getMDListFromStringList(stringsFromContent);
        }
        if (FileType.HTML.getValue().equals(fileType)){
        }
        if (FileType.LATEX.getValue().equals(fileType)){
        }
        return new SolutionFile(solutionsList, fileName, fileType);
    }

    @Override
    public String toString(){
        var resultString = new String();
        switch (fileType){
            case "md" -> resultString = MarkDownEntity.unitEntitiesInSolution(fileName, entityModelsList);
            default -> throw new IllegalStateException("Unexpected value: " + fileType);
        }
        return resultString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (SolutionFile) o;
        return Objects.equals(fileName, that.fileName) && Objects.equals(entityModelsList, that.entityModelsList);
    }
}
