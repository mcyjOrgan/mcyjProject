package common.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.io.File;

/**
 * Created by shusican on 2017/8/4.
 */
public class FileUtil {

    private static final Logger _log = Logger.getLogger(FileUtil.class);

    private static PropertiesFileUtil propertiesUtil = PropertiesFileUtil.getInstance("file_access");

    private static String txt_upload_local_dir = propertiesUtil.get("txt.upload.local.dir");

    /**
     * 读取商品详情文件
     *
     * @param detailsMobile
     * @param uid
     * @return
     */
    public static String getProductDetailFile(String detailsMobile, Long uid) {
        String subDirStr = uid % 20 + "";
        String detailsMobileUrl = "";
        String txtDirPath = txt_upload_local_dir + File.separator + subDirStr;

        if (StringUtils.isNotBlank(detailsMobile)) {
            File txtFile = new File(txtDirPath + File.separator + detailsMobile);
            try {
                detailsMobileUrl = FileUtils.readFileToString(txtFile, "utf-8");
            } catch (Exception e) {
                _log.error("商品mobile描述读取异常!", e);
                e.printStackTrace();
            }
        }
        return detailsMobileUrl;
    }
}
