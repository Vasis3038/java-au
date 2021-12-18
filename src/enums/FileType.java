package enums;

public enum FileType {
    HTML ("html"),
    MARKDOWN ("md"),
    LATEX ("tex");

    private String type;

    FileType(String fileType) {
        this.type = fileType;
    }

    public String getValue(){
        return type;
    }
}
