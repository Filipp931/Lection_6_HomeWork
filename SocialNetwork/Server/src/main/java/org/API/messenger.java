package org.API;

import org.DAO;

public class messenger {
    private static final String removeCommandGift = "removeGift?";
    private static final String giveCommandGift = "giveGift?";
    private static final String addFriendCommand = "addFriend?";
    private static final String deleteFriendCommand = "deleteFriend?";
    private static final String addPhotoCommand = "addPhoto?";
    private static final String deletePhotoCommand = "deletePhoto?";
    private static final String setProfilePhotoCommand = "setProfilePhoto?";
    public static void getMessage(String message){
        String key = message.substring(0,message.indexOf("?") + 1);
        Long[] params;
        switch (key) {
            case removeCommandGift:
                params = getParameters(message, removeCommandGift);
                DAO.removeGift(params[1], params[2]);
                break;
            case giveCommandGift:
                params = getParameters(message, giveCommandGift);
                break;
            case addFriendCommand:
                params = getParameters(message, addFriendCommand);
                break;
            case deleteFriendCommand:
                params = getParameters(message, deleteFriendCommand);
                break;
            case addPhotoCommand:
                params = getParameters(message, addPhotoCommand);
                break;
            case deletePhotoCommand:
                params = getParameters(message, deletePhotoCommand);
                break;
            case setProfilePhotoCommand:
                params = getParameters(message, setProfilePhotoCommand);
                break;


        }
    }
    private static Long[] getParameters(String message, String command){
        Long[] params = new Long[2];
        message.replace(command, "");
        params[1] = Long.parseLong(message.substring(0,message.indexOf("&")));
        params[2] = Long.parseLong(message.substring(message.indexOf("&")+1,message.length()));
        return params;
    }
}
