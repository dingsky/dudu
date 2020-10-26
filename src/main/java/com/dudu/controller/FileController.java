package com.dudu.controller;

import com.dudu.dao.redis.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequestMapping("/file")
public class FileController {
    public static Logger log = LoggerFactory.getLogger(RedisUtil.class);

    @GetMapping("/download/{filename}")
    public void download(@PathVariable String filename, HttpServletResponse response) throws Exception {
        File file = new File(filename);
        if (!file.exists()) {
            throw new Exception(filename + "文件不存在");
        }

        response.setContentType("application/force-download");
        response.addHeader("Content-Disposition", "attachment;fileName=" + file);

        FileInputStream in = new FileInputStream(file);
        OutputStream out = response.getOutputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        while((len= in.read(buf)) != -1) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws Exception {
        if (file == null || file.isEmpty()) {
            throw new Exception("文件不存在或为空");
        }
        try {
            log.error(file.getOriginalFilename());
            File fileupload = new File("E://"+file.getOriginalFilename());
            file.transferTo(fileupload);
            return "success";
        } catch (IOException e) {
            throw new Exception("上传日志文件到服务器失败：" + e.toString());
        }
    }
}
