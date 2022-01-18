package com.company;
import enums.FileType;
import utils.IOUtils;
import models.MarkDownEntity;
import models.SolutionFile;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        var userSource = "solution.txt";
        var source = "array.md";
        var userSolutionContent = IOUtils.readFile(userSource);
        var oldFileContent = IOUtils.readFile(source);
        var arrayMD = new SolutionFile().parseFile(oldFileContent, FileType.MARKDOWN.getValue(), "array");
        arrayMD.add(MarkDownEntity.parseMDEntity(userSolutionContent));
        new IOUtils().writeInFile(source, arrayMD.toString());
    }
}
