package de.teamLocster.user;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUploadUtilities {

    public static void saveFile(String fileName, MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get("profile-picture");

        if (!Files.exists(uploadPath))
            Files.createDirectories(uploadPath);

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioException) {
            throw new IOException("Could not save image file: " + fileName, ioException);
        }
    }

    public static void deleteFile(String fileName) throws IOException {
        Path uploadPath = Paths.get("profile-picture");

        try {
            Path filePath = uploadPath.resolve(fileName.substring("/profile-picture/".length()));
            Files.deleteIfExists(filePath);
        } catch (IOException ioException) {
            throw new IOException("Could not delete image file: " + fileName, ioException);
        }
    }

}
