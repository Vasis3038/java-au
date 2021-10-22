package utils;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PathUtils {
    public static String getFilePath(String fileName){
        Path resourceDirectory = Paths.get("src","resources", fileName);
        return ((Path) resourceDirectory).toFile().getAbsolutePath();
    }
}