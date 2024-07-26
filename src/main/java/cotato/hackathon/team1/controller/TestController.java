package cotato.hackathon.team1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    public ResponseEntity<String> test() {
        return ResponseEntity.ok().body("ok");
    }
}
