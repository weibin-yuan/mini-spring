package org.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class UrlResource implements Resource {
    private final URL url;

    public UrlResource(URL url) {
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return url.openStream();
    }
}
