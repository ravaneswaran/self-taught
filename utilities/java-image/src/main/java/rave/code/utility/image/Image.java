package rave.code.utility.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public interface Image {

    public byte[] toByteArray(String imageFileFullPath) throws IOException;

    public byte[] toByteArray(File file) throws IOException;

    public byte[] toByteArray(URL fileUrl) throws IOException;

    public byte[] toByteArray(InputStream inputStream) throws IOException;

    public File toFileObj(byte[] imageAsBytes) throws IOException;

    public File toFileObj(BufferedImage image) throws IOException;

    public BufferedImage toBufferedImage(byte[] imageAsBytes) throws IOException;

    public BufferedImage toThumbnail(byte[] imageAsBytes) throws IOException;

    public BufferedImage toTransparentBackground(byte[] imageAsBytes) throws IOException;

}
