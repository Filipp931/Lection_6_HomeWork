package GiftsService;



public class GiftsService implements Give, Remove{
    private final String removeGiftCommand = "removeGift?%d&%d";
    private final String giveGiftCommand = "giveGift?%d&%d";
    @Override
    public String remove(Long personId, Long giftId) {
        return String.format(removeGiftCommand, personId, giftId);
    }

    @Override
    public String giveGift(Long personId, Long giftId) {
        return String.format(giveGiftCommand, personId, giftId);
    }

    public void getExceptionMessage(String message){
        System.err.println(message);
    }
}
