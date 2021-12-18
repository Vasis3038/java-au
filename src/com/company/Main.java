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
        var tests = "tests.txt";
        var other = "other.txt";
        var userSolutionContent = IOUtils.readFile(userSource);
        var oldFileContent = IOUtils.readFile(source);
        var arrayMD = new SolutionFile().parseFile(oldFileContent, FileType.MARKDOWN.getValue(), "array");
        var stringTests = IOUtils.readFile(tests);
        var stringOther = IOUtils.readFile(other);
        var a = MarkDownEntity.parseMDEntity(userSolutionContent, stringTests, stringOther);
        arrayMD.add(MarkDownEntity.parseMDEntity(userSolutionContent, stringTests, stringOther));
        new IOUtils().writeInFile(source, arrayMD.toString());
    }
}
