package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IOUtils {

    public static String readFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(PathUtils.getFilePath(fileName))));
    }

    public static void writeInFile(String fileName, String data) {
        try {
            Files.write(Paths.get(PathUtils.getFilePath(fileName)), data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
