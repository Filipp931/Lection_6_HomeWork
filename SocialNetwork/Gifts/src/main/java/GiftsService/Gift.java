package GiftsService;


public class Gift {
    private Long giftId;
    private long giverId;
    private long receiverId;

    public Long getGiftId() {
        return giftId;
    }

    public void setGiftId(Long giftId) {
        this.giftId = giftId;
    }

    public long getGiverId() {
        return giverId;
    }

    public void setGiverId(long giverId) {
        this.giverId = giverId;
    }

    public long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(long receiverId) {
        this.receiverId = receiverId;
    }
}
