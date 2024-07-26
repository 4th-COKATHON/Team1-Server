package cotato.hackathon.team1.s3;

import cotato.hackathon.team1.exception.ErrorCode;
import cotato.hackathon.team1.exception.ImageException;
import org.springframework.web.multipart.MultipartFile;

public class S3Util {

    private static final String[] ALLOWED_IMAGE_FILE_EXTENSIONS = {"png", "jpg", "jpeg", "heif"};

    public static String extractFileExtension(MultipartFile file) throws ImageException {
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null || !originalFilename.contains(".")) {
            throw new ImageException(ErrorCode.IMAGE_EXCEPTION);
        }

        return originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
    }
}
