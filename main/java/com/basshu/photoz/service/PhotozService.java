package com.basshu.photoz.service;


import com.basshu.photoz.reporitory.PhotozRepository;
import org.springframework.stereotype.Service;

import com.basshu.photoz.model.Photo;

@Service
public class PhotozService {
    
    private final PhotozRepository photozRepository;

    public PhotozService(PhotozRepository photozRepository) {
        this.photozRepository = photozRepository;
    }

    public Iterable<Photo> get(){
        return photozRepository.findAll();
    }

    public Photo get(Integer id) {
        return photozRepository.findById(id).orElse(null);
    }

    public Photo put(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setContentType(contentType);
        photo.setFileName(fileName);
        photo.setData(data);
        photozRepository.save(photo);
        return photo;
    }

    public void remove(Integer id) {
        photozRepository.deleteById(id);
    }

}
