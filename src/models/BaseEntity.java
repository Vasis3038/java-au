package models;

public abstract class BaseEntity {
    public String taskTitle;
    public String taskUrl;
    public String taskSolution;

    abstract String getTitle();

    abstract String getUrl();

    abstract String getSolution();
}