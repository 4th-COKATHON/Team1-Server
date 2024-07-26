package cotato.hackathon.team1.controller;

import cotato.hackathon.team1.controller.dto.ImageUploadRequest;
import cotato.hackathon.team1.common.exception.ImageException;
import cotato.hackathon.team1.common.s3.S3Uploader;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class TestController {

    private final S3Uploader s3Uploader;

    @GetMapping
    public ResponseEntity<String> test() {
        return ResponseEntity.ok().body("ok");
    }

    @PostMapping(value = "/image", consumes = "multipart/form-data")
    public ResponseEntity<Void> uploadImage(@ModelAttribute ImageUploadRequest request) throws ImageException {
        s3Uploader.uploadFiles(request.image(), "test");
        return ResponseEntity.noContent().build();
    }
}
