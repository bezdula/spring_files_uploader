package com.example.uploader.web;

import com.example.uploader.model.FileClass;
import com.example.uploader.service.FilesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
public class UploaderController {

    private FilesService filesService;

    // FilesService instance is set up automatically by Spring - dependency injection
    public UploaderController(FilesService filesService) {
        this.filesService = filesService;
    }

    @GetMapping("/")
    // Due to @ResponseBody annotation "Welcome" is returned as just text.
    // This is default behavior is using @RestController instead of @Controller
    @ResponseBody
    public String welcome() {
        return "Welcome";
    }

    @GetMapping("/files")
    @ResponseBody
    public Map<String, FileClass> files() {
        return filesService.getFiles();
    }

    @RequestMapping("/upload")
    public String upload() {
        // Thymeleaf dependency added so "upload" will lead to file upload.html
        return "upload";
    }

    @PostMapping("/files")
    @ResponseBody
    public String addFile(@RequestPart("data") MultipartFile file) throws IOException {
        filesService.addFile(file.getOriginalFilename(), file.getBytes());
        return "Uploaded successfully";
    }
}
