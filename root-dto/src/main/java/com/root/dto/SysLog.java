package com.root.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by huanghui on 2018/7/24
 */
public class SysLog implements Serializable {

    private Long logOperId;

    private String entSerno;

    private Long menuId;

    private String menuName;

    private String operateType;

    private String operateTypeName;

    private Long userId;

    private String userName;

    private String userAcc;

    private Date opDate;

    private Integer executeResult;

    private String ipAddress;

    private String executeResultJson;

    public Long getLogOperId() {
        return logOperId;
    }

    public void setLogOperId(Long logOperId) {
        this.logOperId = logOperId;
    }

    public String getEntSerno() {
        return entSerno;
    }

    public void setEntSerno(String entSerno) {
        this.entSerno = entSerno == null ? null : entSerno.trim();
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType == null ? null : operateType.trim();
    }

    public String getOperateTypeName() {
        return operateTypeName;
    }

    public void setOperateTypeName(String operateTypeName) {
        this.operateTypeName = operateTypeName == null ? null : operateTypeName.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserAcc() {
        return userAcc;
    }

    public void setUserAcc(String userAcc) {
        this.userAcc = userAcc == null ? null : userAcc.trim();
    }

    public Date getOpDate() {
        return opDate;
    }

    public void setOpDate(Date opDate) {
        this.opDate = opDate;
    }

    public Integer getExecuteResult() {
        return executeResult;
    }

    public void setExecuteResult(Integer executeResult) {
        this.executeResult = executeResult;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }

    public String getExecuteResultJson() {
        return executeResultJson;
    }

    public void setExecuteResultJson(String executeResultJson) {
        this.executeResultJson = executeResultJson == null ? null : executeResultJson.trim();
    }

    public SysLog() {
    }

    public SysLog(String entSerno, Long menuId, String menuName, String operateType, String operateTypeName, Long userId, String userName, String userAcc, Integer executeResult, String ipAddress, String executeResultJson, Date opDate) {
        this.entSerno = entSerno;
        this.menuId = menuId;
        this.menuName = menuName;
        this.operateType = operateType;
        this.operateTypeName = operateTypeName;
        this.userId = userId;
        this.userName = userName;
        this.userAcc = userAcc;
        this.executeResult = executeResult;
        this.ipAddress = ipAddress;
        this.executeResultJson = executeResultJson;
        this.opDate = opDate;
    }

    public SysLog(UserInfo userInfo) {
        this.userId = userInfo.getUserId();
        this.userName = userInfo.getUserName();
        this.userAcc = userInfo.getUserAcc();
        this.opDate = new Date();
        this.ipAddress = ipAddress;
    }
}
