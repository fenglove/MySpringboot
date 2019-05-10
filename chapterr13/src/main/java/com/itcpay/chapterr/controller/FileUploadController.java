package com.itcpay.chapterr.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 图片上传的几种方式
 */
@Controller
@RequestMapping("/uploads")
public class FileUploadController {

    private static final Logger log = LoggerFactory.getLogger(FileUploadController.class);

    @GetMapping
    public String index() {
        return "index";
    }

    /**
     * @RequestParam("file")中file对应的就是html中name="file"的input标签
     * 将文件真正的写入还是借助 commons-io 中的 FileUtils.copyInputStreamToFile(inputStream, file)
     */
    @ResponseBody
    @PostMapping("/upload1")
    public Map<String, String> upload1(@RequestParam("file")MultipartFile file) throws IOException {
        log.info("文件类型-{}", file.getContentType());
        log.info("文件名称-{}", file.getOriginalFilename());
        log.info("文件大小-{}", file.getSize());
        // 将文件写入指定目录（实际开发中可能是将文件写入到云存储或指定目录通过Ngin进行gzip压缩和反向代理，此处只是为了演示故将地址写成本地电脑指定目录）
        file.transferTo(new File("D:\\work\\IdeaWorkSpace\\MySpringboot\\chapterr13\\"+file.getOriginalFilename()));
        Map<String, String> result = new HashMap<>(16);
        result.put("contentType", file.getContentType());
        result.put("fileName", file.getOriginalFilename());
        result.put("fileSize", file.getSize() + "");
        return result;
    }

    @ResponseBody
    @PostMapping("/upload2")
    public List<Map<String, String>> upload2(@RequestParam("file") MultipartFile[] files) throws IOException {
        if (files == null || files.length == 0) {
            return null;
        }
        List<Map<String, String>> results = new ArrayList<>();
        for (MultipartFile file:files) {
            file.transferTo(new File("D:\\work\\IdeaWorkSpace\\MySpringboot\\chapterr13\\" + file.getOriginalFilename()));
            Map<String, String> map = new HashMap<>(16);
            map.put("contentType", file.getContentType());
            map.put("fileName", file.getOriginalFilename());
            map.put("fileSize", file.getSize() + "");
            results.add(map);
        }
        return results;
    }

    /**
     * 未实验成功
     * @param base64
     * @param a
     * @throws IOException
     */
    @ResponseBody
    @PostMapping("/upload3")
    public void upload3(String base64, String a) throws IOException {
        // BASE64 方式的格式和名字需要自己控制（如png图片编码后前缀就会是 data:image/png;base64,）
        File tempFile = new File("D:\\work\\IdeaWorkSpace\\MySpringboot\\chapterr13\\test.jpg");
        // 防止有的传了 data:image/png;base64，有的没穿的情况
        String[] d = base64.split("base64,");
        byte[] bytes = Base64Utils.decodeFromString(d.length > 1 ? d[1] : d[0]);
        FileCopyUtils.copy(bytes, tempFile);
    }

}
