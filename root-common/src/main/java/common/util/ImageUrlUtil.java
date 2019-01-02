package common.util;

import org.apache.log4j.Logger;

/**
 * 图片路径生成
 *
 * @author hasee
 */
public class ImageUrlUtil {

    private static final Logger logger = Logger.getLogger(ImageUrlUtil.class);

    private static PropertiesUtil propertiesUtil = PropertiesUtil.getInstance("config/image_assess");

    private static String IMAGE_HOST_URL = propertiesUtil.get("IMAGE_HOST_URL");

    private static String GUIDER_AVATAR_PATH = propertiesUtil.get("GUIDER_AVATAR_PATH");

    private static String GUIDER_ID_PATH = propertiesUtil.get("GUIDER_ID_PATH");

    private static String PRODUCT_LIST_PATH = propertiesUtil.get("PRODUCT_LIST_PATH");

    private static String MEMBER_AVATAR_PATH = propertiesUtil.get("MEMBER_AVATAR_PATH");

    private static String STORE_LOGO_PATH = propertiesUtil.get("STORE_LOGO_PATH");

    private static String BRAND_PATH = propertiesUtil.get("BRAND_PATH");

    private static String MARKETING_PATH = propertiesUtil.get("MARKETING_PATH");

    /**
     * 获取会员头像地址
     *
     * @param fileName
     * @param uid
     * @return
     */
    public static String getFullImageUrlForMemberAvatar(String fileName, Long uid) {
        if (fileName == null || fileName.trim().equals("") || uid == null) {
            return null;
        }
        return getImageFullUrl(IMAGE_HOST_URL, MEMBER_AVATAR_PATH, fileName, uid);
    }

    /**
     * 获取店铺logo地址
     *
     * @param fileName
     * @param uid
     * @return
     */
    public static String getFullImageUrlForStoreLogo(String fileName, Long uid) {
        if (fileName == null || fileName.trim().equals("") || uid == null) {
            return null;
        }
        return getImageFullUrl(IMAGE_HOST_URL, STORE_LOGO_PATH, fileName, uid);
    }

    /**
     * 获取导购头像地址
     *
     * @param fileName
     * @param uid
     * @return
     */
    public static String getFullImageUrlForGuiderAvatar(String fileName, Long uid) {
        return getImageFullUrl(IMAGE_HOST_URL, GUIDER_AVATAR_PATH, fileName, uid);
    }

    /**
     * 获取导购身份证图片地址
     *
     * @param fileName
     * @param uid
     * @return
     */
    public static String getFullImageUrlForGuiderID(String fileName, Long uid) {
        return getImageFullUrl(IMAGE_HOST_URL, GUIDER_ID_PATH, fileName, uid);
    }

    /**
     * 获取商品图片地址
     *
     * @param fileName
     * @param uid
     * @return
     */
    public static String getFullImageUrlForGuiderProductList(String fileName, Long uid) {
        return getImageFullUrl(IMAGE_HOST_URL, PRODUCT_LIST_PATH, fileName, uid);
    }

    /**
     * 获取品牌商图片地址
     *
     * @param fileName
     * @param uid
     * @return
     */
    public static String getFullImageUrlForBrand(String fileName, Long uid) {
        return getImageFullUrl(IMAGE_HOST_URL, BRAND_PATH, fileName, uid);
    }

    /**
     * 获取运营模块图片地址
     *
     * @param fileName
     * @param uid
     * @return
     */
    public static String getFullImageUrlForMarketing(String fileName, Long uid) {
        return getImageFullUrl(IMAGE_HOST_URL, MARKETING_PATH, fileName, uid);
    }

    private static String getImageFullUrl(String imageHostUrl, String typeUrl, String fileName, Long uid) {
        if (fileName == null || "".equals(fileName.trim()) || uid == null) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        sb.append(imageHostUrl);
        sb.append(typeUrl);
        long dirNum = uid % 20;
        sb.append(dirNum);
        sb.append("/").append(fileName);
        return sb.toString();
    }


}
