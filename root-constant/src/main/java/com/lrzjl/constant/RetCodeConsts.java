package com.lrzjl.constant;

/**
* 服务接口返回值常量
* @author Denzel Lin
* 
* @Date 2017-04-28
*/
public class RetCodeConsts {
	public static final Integer RET_OK = 200; //禁用	
	public static final String  RET_OK_MSG = "成功";
	
	public static final Integer RET_BAD_REQ = 400;
	public static final String RET_BAD_REQ_MSG = "您的输入不正确";
	
	public static final Integer RET_UNAUTHORIZED = 401;
	
	public static final Integer RET_FORBIDDEN = 403;
	public static final String  RET_FORBIDDEN_MSG = "您没有权限";
	
	public static final Integer RET_NOT_FOUND = 404;
	public static final String RET_NOT_FOUND_MSG = "没有找到您请求的内容";
	
	public static final Integer RET_UNSUPPORTED = 415;
	public static final String RET_UNSUPPORTED_MSG = "您的输入不正确";
	
	public static final Integer RET_BAD_PARAM = 422;
	public static final String RET_BAD_PARAM_MSG = "您的输入不正确";
	
	public static final Integer RET_INTERNAL_ERR = 500;
	public static final String RET_INTERNAL_ERR_MSG = "服务器忙";
	
	public static final String RET_INVALID_ID_NO_MSG = "身份证号无效";
	
	/*
	 * 登录与注册
	 * */
	
	public static final Integer RET_INVALID_ACCOUNT =  300001;
	public static final String RET_INVALID_ACCOUNT_MSG =  "账号无效";
	public static final String RET_INVALID_MOBILE_ACCOUNT =  "该号码的账号不存在";
	
	public static final Integer RET_INVALID_PASSWORD =  300002;
    public static final String RET_INVALID_PASSWORD_MSG =  "账号或者密码错误";
	
	public static final String RET_INVALID_MOBILE = "手机号码无效";
	public static final String RET_DULPLICATE_MOBILE = "该手机号码已被注册";
	
	public static final String RET_DULPLICATE_NAME_MSG = "存在同名的记录";
	public static final String RET_ACCOUNT_PASSWORD_ERR = "帐号或密码错误";
	
	public static final Integer RET_ACCOUNT_NAME_OCCUPIED = 300003;
	public static final String RET_ACCOUNT_NAME_OCCUPIED_MSG = "该账号已被使用";
	
	public static final Integer RET_ACCOUNT_VALIDATE_FAIL =  300004;
    public static final String RET_ACCOUNT_VALIDATE_FAIL_MSG = "账号必须由字母，数字，下划线组成，长度4~20";
    
    public static final Integer RET_OLD_PASSWORD_VALIDATE_FAIL =  300005;
    public static final String RET_OLD_PASSWORD_VALIDATE_FAIL_MSG = "您输入的原密码不正确";
    
    public static final Integer RET_ACCOUNT_NOT_EXIST =  300006;
    public static final String RET_ACCOUNT_NOT_EXIST_MSG = "您的账号不存在";
    public static final String RET_ACCOUNT_NOT_FOUND_MSG = "找不到该会员信息";
    public static final String RET_ACCOUNT_NOT_REGISTER="该手机号未注册，换个手机号试试!";
	
	public static final String RET_PASSWORD = "密码不匹配";
	
	public static final String RET_CHECKCODE_TIMEOUT = "验证码过期";
	
	public static final String RET_CHECKCODE_ERR = "验证码错误";
	
	public static final String RET_NULL_MOBILE = "手机号码为空";
	
	public static final String RET_STATE_NON_CONFORMITY = "状态不符合";
	
	public static final String RET_STATE_INNORMAL_ACCOUNT = "该账号状态异常";
	/*
	 * 店铺模块
	 * */
	public static final String RET_STORE_NULL_AREA = "无效的区域";
	public static final String RET_STORE_NULL_BRAND = "无效的品牌";
	public static final String RET_RESELLER_NOT_FOUND = "无法获取店铺的隶属的品牌商信息";
	public static final String RET_RESELLER_STATE_ERR = "该店铺所属的品牌商状态不正确";
	
	/*
     * 合伙人
     * */
    public static final String RET_DULPLICATE_PARTER_FOR_AEAR = "该区域已有合伙人";
	
	/*
     * 评论
     * */
	public static final Integer RET_COMMENT_BUSY = 400001;
    public static final String RET_COMMENT_BUSY_MSG = "系统忙, 请重试";
    
    /*
     * 导购
     * */

    public static final String RET_GUIDER_NOT_EXIST_MSG = "该导购不存在";
    public static final String RET_GUIDER_CERTIFIED_YET = "您的账户已经认证";
    public static final String RET_BAD_STATE_FOR_ORDER = "您暂无权限开单, 请确认是否已经实名认证";
    public static final String RET_EMPTY_CART = "您选择的购物车中没有商品, 无法提交";
    public static final String RET_AREA_NOT_SUPPORT = "您注册的区域暂未开通业务, 请等待";
    
    /*
     * 店铺
     * */

    public static final String RET_STORE_NOT_EXIST_MSG = "该店铺不存在";
    public static final String RET_STORE_CERTIFIED_YET = "您的账户已经认证";
    public static final String RET_BAD_STATE_FOR_SALE = "操作失败, 请确认是否已经实名认证";
    
    public static final Integer RET_DULPLICATE_GROUP_NAME =  500001;
    public static final String RET_DULPLICATE_GROUP_NAME_MSG = "该组已经存在";
    
    /*
     * 短信
     * */
    public static final Integer RET_SMS_BUSY = 800001;
    public static final String RET_SMS_BUSY_MSG = "短信缓存满";
    
    /*
     * 文件上传
     * */
    public static final Integer RET_OVER_SIZE = 900001;
    public static final String RET_OVER_SIZE_MSG = "文件超过最大上限";
    public static final Integer RET_NON_FILE = 900002;
    public static final String RET_NON_FILE_MSG = "未指定文件";
    public static final String RET_FAILED_TO_SAVE_IMG = "文件保存失败, 请重新上传";
    
    /*
     * 订单
     */
    public static final String RET_ORDER_CODE_CREATE_FAIL = "创建订单失败";
    
    public static final String RET_ORDER_STATE_FAIL = "订单状态不符";
    
    public static final String RET_ORDER_NO_SAME_STORE = "订单不属于该店铺";
    
    public static final String RET_ORDER_GUIDER_UNAUTH = "您没有权限操作此订单";
    
    public static final String RET_ORDER_NO_SAME_MEMBER = "订单不属于该会员";
    
    public static final String RET_COMMISSION_STATE_FAIL = "提成单状态不符";
    
    public static final String RET_ORDER_EXTERN_FAIL = "该订单已经设置了延迟收货";
    
    public static final String RET_ORDER_OUT_OF_TERITORY = "该店铺的商品不在配送范围内";
    
    public static final String RET_ORDER_INVALID_PRODUCT = "您所选择的商品已经失效";
    
    /*财务*/
    public static final String RET_INSUFFICIENT_BALANCE = "该账户余额不足";
    public static final String RET_INCONSISTENT_NAME = "银行账户名与实名认证的姓名不一致";
    public static final String RET_BILL_OP_FAILED = "操作失败, 刷新后重试";
    
    /*
     * 商品
     * */
    public static final String RET_INVALID_PRODUCT_MSG = "该商品无效, 请确认是否已下架";
}
