package common.util;

/**
 * 状态映射工具类
 * Created by shusican on 2017/8/23.
 */
public class MappingUtil {

    /**
     * 预约列表状态映射
     */
    private static final String APPOINTMENT_CREATED = "01";
    private static final String APPOINTMENT_CONFIRM = "2456";
    private static final String APPOINTMENT_CANCEL = "3";

    private static final Byte APPOINTMENT_OPERATION_NORMAL = 0;
    private static final Byte APPOINTMENT_OPERATION_CANCEL = 1;

    public static String mappingAppointment(Byte state) {
        String s = "0";
        if (null != state) {
            s = state.toString().trim();
        }
        if (APPOINTMENT_CREATED.contains(s)) {
//            已创建
            return "预约中";
        } else if (APPOINTMENT_CONFIRM.contains(s)) {
//            已完成
            return "已完成";
        } else if (APPOINTMENT_CANCEL.contains(s)) {
//            已取消
            return "已取消";
        } else {
//            默认返回已创建
            return "预约中";
        }
    }

    public static Byte mappingAppointmentOperation(Byte state){
        String s = "0";
        if (null != state) {
            s = state.toString().trim();
        }
        if (APPOINTMENT_CREATED.contains(s)) {
//            可删除
            return APPOINTMENT_OPERATION_CANCEL;
        }else {
//            无操作
            return APPOINTMENT_OPERATION_NORMAL;
        }
    }
}
