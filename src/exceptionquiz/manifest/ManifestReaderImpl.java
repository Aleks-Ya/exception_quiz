package exceptionquiz.manifest;

import exceptionquiz.ManifestReader;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

public class ManifestReaderImpl implements ManifestReader {
    private String version;

    public ManifestReaderImpl() {
        try {
            URLClassLoader cl = (URLClassLoader) getClass().getClassLoader();
            URL url = cl.findResource("META-INF/MANIFEST.MF");
            Manifest manifest = new Manifest(url.openStream());
            Attributes attrs = manifest.getMainAttributes();
            version = attrs.getValue("version");
        } catch (IOException e) {
            version = "error";
        }
    }

    @Override
    public String getVersion() {
        return version;
    }
}