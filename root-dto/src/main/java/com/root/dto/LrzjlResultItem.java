package com.root.dto;

public class LrzjlResultItem<T> extends LrzjlResult{
    
    private T item;

    public LrzjlResultItem() {
        super();
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public void setValueEx(T item, Integer code, String msg, String desc){
        this.item = item;
        setValue(code, msg, desc);
    }
    
    @Override
    public String toString() {
        String str = "";
        if (null != item){
            str = item.toString();
        }
        return "LrzjlResultItem [item=" + str + ", " + super.toString()  + "]";
    }
    
}
