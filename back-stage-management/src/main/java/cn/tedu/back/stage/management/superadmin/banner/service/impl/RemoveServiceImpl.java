package cn.tedu.back.stage.management.superadmin.banner.service.impl;

import cn.tedu.back.stage.management.common.ex.ServiceException;
import cn.tedu.back.stage.management.common.web.JsonResult;
import cn.tedu.back.stage.management.common.web.ServiceCode;
import cn.tedu.back.stage.management.superadmin.banner.service.IRemoveService;
import com.fasterxml.jackson.annotation.JacksonInject;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import io.minio.http.Method;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.net.www.http.HttpClient;

import java.io.File;
import java.io.IOException;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
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

    @Value("${minio.endpoint}")
    private String url;


    @Override
    public void remove(String url) {
        //从minio服务上删除
        try {
            //// 创建 HttpClient 实例
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            log.debug("接受删除图片业务请求路径为:{}", url);

            //url截取去掉包括?部分地址
            String[] parts = url.split("\\?");
            log.debug(parts[0]);

            // 创建 HttpDelete 请求
            HttpDelete httpDelete = new HttpDelete(parts[0]);

            // 执行请求并获取响应
            HttpResponse response = httpClient.execute(httpDelete);

            // 获取响应状态码
            int responseCode = response.getStatusLine().getStatusCode();

            // 判断响应状态码是否为 200 或 204
            if (responseCode == 200 || responseCode == 204) {
                log.debug("图片删除成功");

            } else {
                log.debug("图片删除失败");
            }

            httpClient.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Autowired
    private MinioClient minioClient;

    @Override
    public String upload(MultipartFile file) throws IOException {

        String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
        Method method = Method.GET;
        // 上传文件到Minio服务器
        try {
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket("files")
                            .object(fileName)
                            .stream(file.getInputStream(), file.getSize(), -1)
                            .contentType(file.getContentType())
                            .build()
            );
            String url = minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder()
                    .bucket("files")
                    .object(fileName)
                    .method(method)
                    .build());
            log.debug("服务器返回url地址{}", url);
            return url;
        } catch (ErrorResponseException | InsufficientDataException | InternalException | InvalidKeyException |
                 InvalidResponseException | NoSuchAlgorithmException | XmlParserException | ServerException e) {
            String message = "连接minio服务器异常,请联系管理员!";
            throw new ServiceException(ServiceCode.ERROR_UNKNOWN, message);
        }


        //得到上传文件的名称
//        String fileName = file.getOriginalFilename();
//        log.debug("得到的文件文成:{}", fileName);
//        //得到文件的后缀名 从最后一个.的位置截取到最后 a.jpg    .jpg
//        String suffix = fileName.substring(fileName.lastIndexOf("."));
//        //得到唯一文件名   UUID.randomUUID()得到一个唯一标识符
//        fileName = UUID.randomUUID() + suffix;
//        log.debug("唯一文件名:{}", fileName);
//
//        //准备保存文件的文件夹路径  c:/files/2023/06/1/
//
//        // yyyy年 MM月 dd日   HH小时 mm分  ss秒
//        SimpleDateFormat f = new SimpleDateFormat("/yyyy/MM/dd/");
//        //new Date()当前的时间
//        String datePath = f.format(new Date());
//        log.debug("当前时间:{}", datePath);
//        File dirFile = new File(filePath + datePath);
//        log.debug("需要保存的文件路径:{}", dirFile);
//        //如果文件夹不存在 则创建
//        if (!dirFile.exists()) {
//            dirFile.mkdirs();//创建文件夹
//        }
//        //把图片保存进文件夹  c:/files/2023/06/1/xxxx.jpg  异常抛出
//        File a = new File(filePath + datePath + fileName);
//        file.transferTo(new File(filePath + datePath + fileName));
//        log.debug("最后保存的文件{}", a);
//        return datePath+fileName;
//        /*<img src='http://localhost:8080/2023/06/1/xxxx.jpg'>*/
//        //把图片路径  /2023/06/1/xxxx.jpg 响应给客户端

    }
}