package FriendsService;


public class FriendsService implements AddFriend, DeleteFriend{
    private final String addFriendCommand = "addFriend: %d&%d";
    private final String deleteFriendCommand = "deleteFriend: %d&%d";
    @Override
    public String addFriend(Long personId, Long friedId)  {
       return String.format(addFriendCommand,personId,friedId);
    }

    @Override
    public String deleteFriend(Long personId, Long friedId)  {
        return String.format(deleteFriendCommand,personId,friedId);
    }
    public void getExceptionMessage(String message){
        System.err.println(message);
    }
}
