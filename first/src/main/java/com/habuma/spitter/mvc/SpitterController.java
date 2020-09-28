package com.habuma.spitter.mvc;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.service.SpitterService;
import org.apache.commons.io.FileUtils;
import org.jets3t.service.S3Service;
import org.jets3t.service.S3ServiceException;
import org.jets3t.service.acl.AccessControlList;
import org.jets3t.service.acl.GroupGrantee;
import org.jets3t.service.acl.Permission;
import org.jets3t.service.impl.rest.httpclient.RestS3Service;
import org.jets3t.service.model.S3Bucket;
import org.jets3t.service.model.S3Object;
import org.jets3t.service.security.AWSCredentials;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import javax.validation.Valid;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/spitter") // Корневой урл
public class SpitterController {
    private final SpitterService spitterService;
    private String webRootPath="";
    private String s3SecretKey;
    private String s3AccessKey;

    @Inject
    public SpitterController(SpitterService spitterService) {
        this.spitterService = spitterService;
    }

    @RequestMapping(value = "/spittles", method = RequestMethod.GET)
    public String listSpittles(@RequestParam("spitter") String username, Model model) {
        Spitter spitter = spitterService.getSpitter(username);
        model.addAttribute(spitter);
        model.addAttribute(spitterService.getSpittlesForSpitter(username));
        return "spittles/list";
    }

    @RequestMapping(method = RequestMethod.GET, params = "new")
    public String createSpitterProfile(Model model) {
        model.addAttribute(new Spitter());
        return "spitters/edit";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addSpitterFromForm(@Valid Spitter spitter,
                                     BindingResult bindingResult,
                                     @RequestParam(value="image", required = false) MultipartFile image) { // Прием файла
        if (bindingResult.hasErrors()) {
            return "spitter/edit";
        }
        spitterService.saveSpitter(spitter);

        try {
            if (!image.isEmpty()) {
                validateImage(image);

                saveImage(spitter.getId() + ".jpg", image);
            }
        } catch (ImageUploadException e) {
            bindingResult.reject(e.getMessage());
        }
        // Переадресовать после запроса POST
        return "redirect:/spitters/" + spitter.getUsername();
    }

    private void saveImage(String filename, MultipartFile image) throws ImageUploadException{
        try{
            AWSCredentials awsCredentials = new AWSCredentials(s3AccessKey, s3SecretKey);
            S3Service s3 = new RestS3Service(awsCredentials); // Настройка S3

            // Создать объекты, представляющие хранилище и изображения
            S3Bucket imageBucket = s3.getBucket("spitterImages");
            S3Object imageObject = new S3Object(filename);

            // Скопировать данные изображения в объект
            imageObject.setDataInputStream(new ByteArrayInputStream(image.getBytes()));
            imageObject.setContentLength(image.getBytes().length);
            imageObject.setContentType("image/jpeg");

            // Определить разрешение
            AccessControlList acl = new AccessControlList();
            acl.setOwner(imageBucket.getOwner());
            acl.grantPermission(GroupGrantee.ALL_USERS, Permission.PERMISSION_READ);
            imageObject.setAcl(acl);

            s3.putObject(imageBucket, imageObject);

        } catch (Exception e) {
            throw new ImageUploadException("Unable to save image", e);
        }
    }

    private void validateImage(MultipartFile image) throws ImageUploadException {
        if (!image.getContentType().equals("image/jpg")) {
            throw new ImageUploadException("Only JPG images accepted");
        }
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username,
                                     Model model) {
        model.addAttribute(spitterService.getSpitter(username));
        return "spitters/view";
    }
}
