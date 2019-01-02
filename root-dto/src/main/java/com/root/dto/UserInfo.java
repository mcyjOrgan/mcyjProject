package com.root.dto;

import com.root.Base.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "用户详情")
public class UserInfo implements Serializable {

    @ApiModelProperty(value = "用户ID")
    private Long userId;

    @ApiModelProperty(value = "职务id")
    private Long posId;

    @ApiModelProperty(value = "职务名称")
    private String posName;

    @ApiModelProperty(value = "部门ID")
    private Long deptId;

    @ApiModelProperty(value = "部门名称")
    private String deptName;

    @ApiModelProperty(value = "学校编码")
    private String entSerno;

    @ApiModelProperty(value = "用户姓名")
    private String userName;

    @ApiModelProperty(value = "用户帐号")
    private String userAcc;

    @ApiModelProperty(value = "加密用")
    private String userHash;

    @ApiModelProperty(value = "用户密码")
    private String userPwd;

    @ApiModelProperty(value = "用户状态（0：正常状态，-1：停用状态）")
    private Integer userState;

    @ApiModelProperty(value = "登陆状态1:登陆 0:未登陆 -- 默认0")
    private Integer loginStatus;

    @ApiModelProperty(value = "手机号")
    private String mobilephone;

    @ApiModelProperty(value = "员工是否删除标志(0：未删除，1：已删除)")
    private Integer isDel;

    @ApiModelProperty(value = "登陆更新时间 5分钟更新一次")
    private String refreshTime;

    @ApiModelProperty(value = "操作人")
    private Long op;

    @ApiModelProperty(value = "帐号描述")
    private String aspRemark;

    @ApiModelProperty(value = "南瓜帐号(用于绑定使用)")
    private String n4Acc;

    @ApiModelProperty(value = "南瓜密码(用于绑定使用)")
    private String n4Pwd;

    public UserInfo() {
    }

    public String getAspRemark() {
        return aspRemark;
    }

    public void setAspRemark(String aspRemark) {
        this.aspRemark = aspRemark;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPosId() {
        return posId;
    }

    public void setPosId(Long posId) {
        this.posId = posId;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getEntSerno() {
        return entSerno;
    }

    public void setEntSerno(String entSerno) {
        this.entSerno = entSerno;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAcc() {
        return userAcc;
    }

    public void setUserAcc(String userAcc) {
        this.userAcc = userAcc;
    }

    public String getUserHash() {
        return userHash;
    }

    public void setUserHash(String userHash) {
        this.userHash = userHash;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    public Integer getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Integer loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public String getRefreshTime() {
        return refreshTime;
    }

    public void setRefreshTime(String refreshTime) {
        this.refreshTime = refreshTime;
    }

    public Long getOp() {
        return op;
    }

    public void setOp(Long op) {
        this.op = op;
    }

    public String getN4Acc() {
        return n4Acc;
    }

    public void setN4Acc(String n4Acc) {
        this.n4Acc = n4Acc;
    }

    public String getN4Pwd() {
        return n4Pwd;
    }

    public void setN4Pwd(String n4Pwd) {
        this.n4Pwd = n4Pwd;
    }
}
