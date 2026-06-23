package com.upSkillConnect.upSkillConnect_api.uploads;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.upSkillConnect.upSkillConnect_api.uploads.enums.UploadType;

@Service
public class UploadService {
    public String uploadFile(MultipartFile file, UploadType uploadType) throws IOException {

        String originalName = file.getOriginalFilename();

        if (originalName == null) {
            throw new RuntimeException("Invalid file name");
        }

        String fileName = UUID.randomUUID() + "-" + originalName;

        Path uploadPath = Paths.get(System.getProperty("user.dir"), "uploads", uploadType.name());

        Files.createDirectories(uploadPath);

        Path filePath = uploadPath.resolve(fileName);

        Files.copy(
                file.getInputStream(),
                filePath,
                StandardCopyOption.REPLACE_EXISTING);

        return "/uploads/" + uploadType.name().toLowerCase() + "/" + fileName;
    }
}