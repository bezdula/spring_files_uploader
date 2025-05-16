package com.example.uploader.service;

import com.example.uploader.model.FileClass;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class FilesService {

    private final Map<String, FileClass> files = new HashMap<>();

    public Map<String, FileClass> getFiles() {
        return files;
    }

    public void addFile(String fileName, byte[] data) {
        FileClass file = new FileClass();
        // TODO: define Id
        file.setId(1);
        file.setFileName(fileName);
        file.setData(data);
        files.put(fileName, file);
    }
}
