package PhotoService;

public class PhotoService implements AddPhoto, DeletePhoto, SetProfilePhoto{
    private final String addPhotoCommand = "addPhoto?%d&%d";
    private final String deletePhotoCommand = "deletePhoto?%d&%d";
    private final String setProfilePhotoCommand = "setProfilePhoto?%d&%d";
    @Override
    public String addPhoto(Long personId, Long photoId) {
        return String.format(addPhotoCommand,personId, photoId );
    }

    @Override
    public String deletePhoto(Long personId, Long photoId) {
        return String.format(deletePhotoCommand, personId, photoId);
    }

    @Override
    public String setProfilePhoto(Long personId, Long photoId) {
        return String.format(setProfilePhotoCommand, personId,photoId);
    }
}
