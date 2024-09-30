package common.audittrail.controllers;

import common.audittrail.models.Platform;
import common.audittrail.repository.ILogRepository;
import common.audittrail.repository.IPlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Log") // Base URL mapping
public class LogController {

    @Autowired
    ILogRepository logRepository;

  
}
