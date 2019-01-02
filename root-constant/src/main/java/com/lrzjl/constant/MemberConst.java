package com.lrzjl.constant;


/**
* 财务中心状态常亮
* @author Denzel Lin
* 
* @Date 2017-04-28
*
*/
public class MemberConst extends CommonConsts{
	
	/**
	 * 账号状态
	 * */
	public static final Byte DELETED = 0; //删除
	public static final Byte NEW = 1; //新建(未用)
	public static final Byte SUBMITTED = 2; //待审核(未用)
	public static final Byte ACTIVE = 3; //激活(未用)
	public static final Byte ONLINE = 4; //上线
	public static final Byte OFFLINE = 5; //下线(未用)
	public static final Byte BLOCKED = 6; //封号
	
	/*
	 * 会员的导购开发状态
	 * */
	public static final Byte GUIDER_NONE = 0; //未关联
    public static final Byte GUIDER_CONNECTED = 1; //关联中
    public static final Byte GUIDER_DIS_CONNECT = 2; //已解除
	
	/*
     * 店铺收藏夹的seller属性
     * */
    public static final Byte FAVORIT_SELLER_RESELLER = 0; //收藏类型：品牌商
    public static final Byte FAVORIT_SELLER_STORE = 1; //收藏类型：店铺
	
   
    /*
     * 收货地址状态
     * */
    public static final Byte DELIVER_ADDR_STATE_NORMAL = 0; //正常状态的收货地址
    public static final Byte DELIVER_ADDR_STATE_DEFAULT = 1; //默认收货地址
    
    
}
