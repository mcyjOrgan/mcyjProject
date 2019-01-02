package common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shusican on 2017/7/31.
 */
public class ConcatImgUrlUtil {

    /**
     * 商品图片路径拼接
     *
     * @param map
     * @param uid
     * @return
     */
    public static HashMap<String, String> getProductImgUrl(HashMap<String, String> map, Long uid) {
        if (null == map || map.isEmpty()) {
            return null;
        }

        if (null == uid || uid == 0L) {
            return null;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (null != entry.getValue() && !entry.getValue().isEmpty()) {
                String picUlr = ImageUrlUtil.getFullImageUrlForGuiderProductList(entry.getValue(), uid);
                entry.setValue(picUlr);
            }
        }
        return map;
    }
}
