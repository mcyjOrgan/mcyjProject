package com.root.dto;

import java.util.List;

public class LrzjlResultList<T> extends LrzjlResult {

    List<T> itemList;
    
    private Integer count;

    public LrzjlResultList() {
        super();
    }

    public List<T> getItemList() {
        return itemList;
    }

    public void setItemList(List<T> itemList) {
        this.itemList = itemList;
    }
    
        
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
    
    public void setValueEx(List<T> list, Integer cnt, Integer code, String msg, String desc){
        this.itemList = list;
        this.count = cnt;
        setValue(code, msg, desc);
    }

    public String toString() {
        String str = "";
        if (null != itemList){
            str = itemList.toString();
        }
        return "LrzjlResultItem [itemList=" + str + ", " + super.toString()  + "]" + "count: " + count;
    }
}
