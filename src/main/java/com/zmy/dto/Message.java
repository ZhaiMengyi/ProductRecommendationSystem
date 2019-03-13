package com.zmy.dto;

import java.util.HashMap;
import java.util.Map;

public class Message {
    private int code;
    private String msg;
    private Map<String,Object> extend=new HashMap<>();

    public Message(int code, String msg, Map<String, Object> extend) {
        this.code = code;
        this.msg = msg;
        this.extend = extend;
    }

    public Message() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
    public static Message success(){
        Message result = new Message();
        result.setCode(666);
        result.setMsg("对，很对，非常对");
        return result;
    }
    public static Message success(String message){
        Message result = new Message();
        result.setCode(666);
        result.setMsg(message);
        return result;
    }
    public static Message error(){
        Message result = new Message();
        result.setCode(555);
        result.setMsg("我套你个猴子");
        return result;
    }
    public static Message error(String message){
        Message result = new Message();
        result.setCode(555);
        result.setMsg(message);
        return result;
    }
    public Message addObject(String key,Object value){
        this.getExtend().put(key,value);
        return this;
    }
}
