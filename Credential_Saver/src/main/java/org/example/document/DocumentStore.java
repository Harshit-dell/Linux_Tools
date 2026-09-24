package org.example.document;

import org.example.general.AppConfig;
import org.example.model.Credential;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DocumentStore {
    private static Path path=AppConfig.SECRET_FILE_PATH.getParent();
    public static void save(Credential credential) throws IOException {
        //got just name to work with here
        Path file = Path.of(path.toString(), credential.getKey()).toAbsolutePath();

        Files.createFile(file);

        ProcessBuilder builder = new ProcessBuilder(
                "nano",
                file.toString()
        );
        builder.inheritIO();
        builder.redirectInput(new File("/dev/tty"));
        builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        builder.redirectError(ProcessBuilder.Redirect.INHERIT);

        Process process = builder.start();
        try{
            process.waitFor();
        }
        catch (Exception e){
        }
    }
}
