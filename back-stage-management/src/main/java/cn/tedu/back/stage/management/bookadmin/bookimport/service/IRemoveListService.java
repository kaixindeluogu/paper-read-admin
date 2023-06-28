package cn.tedu.back.stage.management.bookadmin.bookimport.service;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Author = bianmy
 * DATE = 2023/6/16 23:38
 */

public interface IRemoveListService {
    void remove(String url);

    String upload(MultipartFile file) throws IOException;
}