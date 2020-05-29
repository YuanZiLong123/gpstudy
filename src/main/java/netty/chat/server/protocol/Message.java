package netty.chat.server.protocol;

/**
 * <p>
 *
 * </p>
 *
 * @author admin
 * @since 2020/5/25
 */
@org.msgpack.annotation.Message
public class Message {


    private String type;

    private String nickName;

    private int onlineNumber;

    private String content;

    private Long sysTime;

    private String toName;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getSysTime() {
        return sysTime;
    }

    public void setSysTime(Long sysTime) {
        this.sysTime = sysTime;
    }

    public int getOnlineNumber() {
        return onlineNumber;
    }

    public void setOnlineNumber(int onlineNumber) {
        this.onlineNumber = onlineNumber;
    }

    public Message() {
    }

    public Message(String nickName, Long sysTime) {
        this.nickName = nickName;
        this.sysTime = sysTime;
    }

    public Message(String nickName,String content) {
        this.content = content;
        this.nickName = nickName;
    }

    public Message(String type, Long sysTime, String nickName ) {
        this.type = type;
        this.nickName = nickName;
        this.sysTime = sysTime;
    }
    public Message(String type, Long sysTime, String nickName, String content) {
        this.type = type;
        this.nickName = nickName;
        this.content = content;
        this.sysTime = sysTime;
    }
    public Message(String type,String toName, Long sysTime, String nickName, String content) {
        this.type = type;
        this.nickName = nickName;
        this.content = content;
        this.sysTime = sysTime;
        this.toName = toName;
    }

    public Message(String type, String nickName, int onlineNumber, String content, Long sysTime) {
        this.type = type;
        this.nickName = nickName;
        this.onlineNumber = onlineNumber;
        this.content = content;
        this.sysTime = sysTime;
    }

    public Message(String type, String nickName, int onlineNumber, String content, Long sysTime, String toName) {
        this.type = type;
        this.nickName = nickName;
        this.onlineNumber = onlineNumber;
        this.content = content;
        this.sysTime = sysTime;
        this.toName = toName;
    }

    @Override
    public String toString() {
        return "Message{" +
                "type='" + type + '\'' +
                ", nickName='" + nickName + '\'' +
                ", onlineNumber=" + onlineNumber +
                ", content='" + content + '\'' +
                ", sysTime=" + sysTime +
                ", toName='" + toName + '\'' +
                '}';
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }
}
