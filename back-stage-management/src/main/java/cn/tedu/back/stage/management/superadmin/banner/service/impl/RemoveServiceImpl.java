package cn.tedu.back.stage.management.superadmin.banner.service.impl;

import cn.tedu.back.stage.management.common.web.ServiceCode;
import cn.tedu.back.stage.management.superadmin.banner.service.IRemoveService;
import com.fasterxml.jackson.annotation.JacksonInject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Author = bianmy
 * DATE = 2023/6/16 23:39
 */

@Service
@Slf4j
public class RemoveServiceImpl implements IRemoveService {
    @Value("${filePath}")
    private String filePath;


    @Override
    public void remove(String url) {
        // url =  /2023/06/1/xxxx.jpg
        //完整路径   c:/files/2023/06/1/xxxx.jpg
        //删除和路径对应的图片文件
        new File(filePath + url).delete();
    }

    @Override
    public String upload(MultipartFile file) throws IOException {
        //得到上传文件的名称
        String fileName = file.getOriginalFilename();
        log.debug("得到的文件文成:{}", fileName);
        //得到文件的后缀名 从最后一个.的位置截取到最后 a.jpg    .jpg
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        //得到唯一文件名   UUID.randomUUID()得到一个唯一标识符
        fileName = UUID.randomUUID() + suffix;
        log.debug("唯一文件名:{}", fileName);

        //准备保存文件的文件夹路径  c:/files/2023/06/1/

        // yyyy年 MM月 dd日   HH小时 mm分  ss秒
        SimpleDateFormat f = new SimpleDateFormat("/yyyy/MM/dd/");
        //new Date()当前的时间
        String datePath = f.format(new Date());
        log.debug("当前时间:{}", datePath);
        File dirFile = new File(filePath + datePath);
        log.debug("需要保存的文件路径:{}", dirFile);
        //如果文件夹不存在 则创建
        if (!dirFile.exists()) {
            dirFile.mkdirs();//创建文件夹
        }
        //把图片保存进文件夹  c:/files/2023/06/1/xxxx.jpg  异常抛出
        File a = new File(filePath + datePath + fileName);
        file.transferTo(new File(filePath + datePath + fileName));
        log.debug("最后保存的文件{}", a);
        return datePath+fileName;
        /*<img src='http://localhost:8080/2023/06/1/xxxx.jpg'>*/
        //把图片路径  /2023/06/1/xxxx.jpg 响应给客户端

    }
}