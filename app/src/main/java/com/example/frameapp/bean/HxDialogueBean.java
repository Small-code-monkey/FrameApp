package com.example.frameapp.bean;

/**
 * 环信聊天消息对象类
 * 2020-02-18
 *
 * @author
 */
public class HxDialogueBean {
    /**
     * 消息的类型:接收
     */
    public static final int TYPE_RECEIVED = 0;
    /**
     * 消息的类型:发送
     */
    public static final int TYPE_SEND = 1;

    private int type;
    private String content;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "HxDialogueBean{" +
                "type=" + type +
                ", content='" + content + '\'' +
                '}';
    }
}
