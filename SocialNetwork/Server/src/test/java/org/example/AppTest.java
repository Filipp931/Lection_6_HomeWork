package org.example;

import PhotoService.PhotoService;
import org.API.messenger;
import org.junit.Test;

;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void shouldAnswerWithTrue()
    {
        PhotoService photoService = new PhotoService();
        String message = photoService.addPhoto(12l,125l);
        messenger.getMessage(message);
    }
}
