package org.springframework.core.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;

public class FileSystemResource implements Resource {
    private final String path;

    public FileSystemResource(String path) {
        this.path = path;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        try {
            File file = new File(path);
            return Files.newInputStream(file.toPath());
        }catch (NoSuchFileException e) {
            throw new FileNotFoundException(e.getMessage());
        }
    }
}
