package rave.code.utility.qrcode;

import java.awt.image.BufferedImage;

public interface QRCode {

    public BufferedImage createImage(String data, String charset, int imageWidth, int imageHeight) throws Exception;

    public String scanImage(BufferedImage bufferedImage) throws Exception;
}
