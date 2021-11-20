package utils;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathUtils {

    protected static String getFilePath(String fileName){
        Path resourceDirectory = Paths.get("src","resources", fileName);
        return ((Path) resourceDirectory).toFile().getAbsolutePath();
    }
}
