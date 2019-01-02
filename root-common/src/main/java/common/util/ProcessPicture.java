package common.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class ProcessPicture {
    static final Logger logger = LoggerFactory.getLogger(ProcessPicture.class);

    public static void removeImg(Long uid, String filename, PicAttr attr) {
        String strDestFile = attr.getPath() + File.separator + (uid % 20) + File.separator + filename;
        try {
            File oldPic = new File(strDestFile);
            oldPic.delete();

        } catch (Exception e) {
            logger.info("failed to delete img: {} filename: {}", uid, filename);
            logger.error(e.getMessage());
            return;
        }
    }

    public static String ProcessImg(Long uid, String srcImgName, PicAttr attr, String picSourcePath) {
        String uuid = UUID.randomUUID().toString();

        String fileName = uuid + "!" + uid;

        String strDestPath = attr.getPath() + File.separator + (uid % 20);
        File toDir = new File(strDestPath);

        if (!toDir.exists()) {
            if (true != toDir.mkdirs()) {
                return null;
            }
        }

        String filePostfix = ".png";

        int width = attr.getWidth();
        int height = attr.getHeigth();
        if (width > 0 && height > 0) {
            filePostfix = "-" + attr.getWidth() + "x" + attr.getHeigth() + ".png";
        }

        String strDestFile = strDestPath + File.separator + fileName + filePostfix;

        logger.debug("file path: {}", strDestFile);
        try {

            String filePathName = picSourcePath + File.separator + srcImgName;

            File fromPic = new File(filePathName);
            File toPic = new File(strDestFile);

            BufferedImage image = ImageIO.read(fromPic);

            int imageWidth = image.getWidth();
            int imageHeitht = image.getHeight();
            Thumbnails.Builder<BufferedImage> builder = null;

            if (width > 0 && height > 0) {

                if ((float) width / height != (float) imageWidth / imageHeitht) {
                    if ((float) (width / imageWidth) * imageHeitht > height) {
                        image = Thumbnails.of(filePathName).width(width).asBufferedImage();
                    } else {
                        image = Thumbnails.of(filePathName).height(height).asBufferedImage();
                    }
                    builder = Thumbnails.of(image).sourceRegion(Positions.CENTER, width, height).size(width, height);
                } else {
                    builder = Thumbnails.of(image).size(width, height);
                }
            } else {
                builder = Thumbnails.of(image).size(imageWidth, imageHeitht);
            }


            builder.outputFormat("png").toFile(toPic);

            fromPic.delete();
        } catch (IOException e) {
            logger.info("failed to save img: {}  imgname: {}", uid, srcImgName);
            logger.error("{}", e);
            return null;
        }

        return fileName + filePostfix;
    }

    public static String ProcessImgEx(Long uid, String destImgName, String srcImgName, PicAttr attr, String picSourcePath) {

        String strDestPath = attr.getPath() + File.separator + (uid % 20);
        File toDir = new File(strDestPath);

        if (!toDir.exists()) {
            if (true != toDir.mkdirs()) {
                return null;
            }
        }

        String strDestFile = strDestPath + File.separator + destImgName;

        try {

            String filePathName = picSourcePath + File.separator + srcImgName;

            File fromPic = new File(filePathName);
            File toPic = new File(strDestFile);

            BufferedImage image = ImageIO.read(fromPic);

            int imageWidth = image.getWidth();
            int imageHeitht = image.getHeight();
            Thumbnails.Builder<BufferedImage> builder = null;

            int width = attr.getWidth();
            int height = attr.getHeigth();

            if (width > 0 && height > 0) {

                if ((float) width / height != (float) imageWidth / imageHeitht) {
                    if ((float) (width / imageWidth) * imageHeitht > height) {
                        image = Thumbnails.of(filePathName).width(width).asBufferedImage();
                    } else {
                        image = Thumbnails.of(filePathName).height(height).asBufferedImage();
                    }
                    builder = Thumbnails.of(image).sourceRegion(Positions.CENTER, width, height).size(width, height);
                } else {
                    builder = Thumbnails.of(image).size(width, height);
                }
            } else {
                builder = Thumbnails.of(image).size(imageWidth, imageHeitht);
            }

            builder.outputFormat("png").toFile(toPic);

        } catch (IOException e) {
            logger.info("failed to save img: {}  imgname: {}", uid, srcImgName);
            logger.error("{}", e);
            return null;
        }

        return destImgName;
    }
}
