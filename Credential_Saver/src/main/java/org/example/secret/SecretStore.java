package org.example.secret;

import org.example.general.AppConfig;
import org.example.model.Credential;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public final class SecretStore {
    private static final Path filePath = AppConfig.SECRET_FILE_PATH;
    public static void save(Credential credential) throws IOException {
        
        String content="key:"+credential.getKey()+" "+"password:"+credential.getPassword()+"\n";
        
        Files.writeString(filePath, content,StandardOpenOption.CREATE,StandardOpenOption.APPEND);
        
        System.out.println("Saved to "+filePath);
        
    }
}
