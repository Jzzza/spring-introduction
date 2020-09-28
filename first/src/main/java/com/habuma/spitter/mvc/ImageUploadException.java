package com.habuma.spitter.mvc;

import java.io.IOException;

public class ImageUploadException extends Throwable {
    public ImageUploadException(String only_jpg_images_accepted) {
    }

    public ImageUploadException(String only_jpg_images_accepted, Exception e) {
    }
}
