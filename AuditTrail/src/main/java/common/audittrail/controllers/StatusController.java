package common.audittrail.controllers;

import common.audittrail.models.entities.Platform;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1.0.1/Status")
public class StatusController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity GetStatus(){
        return ResponseEntity.ok(System.currentTimeMillis());
    }
}
