package rave.code.utility.image;

import org.apache.commons.io.FileUtils;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.Date;


public class JavaImage implements Image {

    private static final String SUFFIX = "png";
    private static final String THUMBNAIL = "thumbnail";

    public byte[] toByteArray(String imageFileFullPath) throws IOException {
        return this.toByteArray(new File(imageFileFullPath));
    }

    public byte[] toByteArray(File file) throws IOException {
        return this.toByteArray(new FileInputStream(file));
    }

    public byte[] toByteArray(URL fileUrl) throws IOException {
        return this.toByteArray(fileUrl.openStream());
    }

    public byte[] toByteArray(InputStream inputStream) throws IOException {
        BufferedImage originalImage = ImageIO.read(inputStream);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write( originalImage, SUFFIX, baos );
        baos.flush();
        byte[] imageAsBytes = baos.toByteArray();
        baos.close();
        return imageAsBytes;
    }

    public File toFileObj(byte[] imageAsBytes) throws IOException {
        File tempFile = File.createTempFile(THUMBNAIL+"-"+String.valueOf(new Date().getTime()), SUFFIX, null);
        FileUtils.writeByteArrayToFile(tempFile, imageAsBytes);
        return tempFile;
    }

    public BufferedImage toBufferedImage(byte[] imageAsBytes) throws IOException {
        return ImageIO.read(new ByteArrayInputStream(imageAsBytes));
    }

    public BufferedImage toThumbnail(byte[] imageAsBytes) throws IOException {
        BufferedImage originalBufferedImage = this.toBufferedImage(imageAsBytes);
        int thumbnailWidth = 150;
        int widthToScale = 0;
        int heightToScale = 0;
        if (originalBufferedImage.getWidth() > originalBufferedImage.getHeight()) {
            heightToScale = (int)(1.1 * thumbnailWidth);
            widthToScale = (int)((heightToScale * 1.0) / originalBufferedImage.getHeight()
                    * originalBufferedImage.getWidth());
        } else {
            widthToScale = (int)(1.1 * thumbnailWidth);
            heightToScale = (int)((widthToScale * 1.0) / originalBufferedImage.getWidth()
                    * originalBufferedImage.getHeight());
        }

        BufferedImage resizedImage = new BufferedImage(widthToScale,
                heightToScale, originalBufferedImage.getType());
        Graphics2D g = resizedImage.createGraphics();
        g.setComposite(AlphaComposite.Src);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage(originalBufferedImage, 0, 0, widthToScale, heightToScale, null);
        g.dispose();

        int x = (resizedImage.getWidth() - thumbnailWidth) / 2;
        int y = (resizedImage.getHeight() - thumbnailWidth) / 2;

        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Width of new thumbnail is bigger than original image");
        }

        return resizedImage.getSubimage(x, y, thumbnailWidth, thumbnailWidth);
    }

    public File toFileObj(BufferedImage image) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write( image, SUFFIX, baos );
        baos.flush();
        byte[] byteArray = baos.toByteArray();
        baos.close();
        return this.toFileObj(byteArray);
    }
}