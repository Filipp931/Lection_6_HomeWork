package PhotoService;

public class PhotoService implements AddPhoto, DeletePhoto, SetProfilePhoto{
    private final String addPhotoCommand = "addPhoto: %d&%d";
    private final String deletePhotoCommand = "deletePhoto: %d&%d";
    private final String setProfilePhotoCommand = "setProfilePhoto: %d&%d";
    @Override
    public String addPhoto(Long photoId, Long personId) {
        return String.format(addPhotoCommand, photoId, personId);
    }

    @Override
    public String deletePhoto(Long photoId, Long personId) {
        return String.format(deletePhotoCommand, photoId, personId);
    }

    @Override
    public String setProfilePhoto(Long photoId, Long personId) {
        return String.format(setProfilePhotoCommand, photoId, personId);
    }
}
