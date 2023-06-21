package cn.tedu.back.stage.management.superadmin.banner.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Author = bianmy
 * DATE = 2023/6/16 23:38
 */
public interface IRemoveService {
    void remove(String url);

    String upload(MultipartFile file) throws IOException;
}