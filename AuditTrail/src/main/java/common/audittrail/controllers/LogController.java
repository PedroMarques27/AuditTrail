package common.audittrail.controllers;

import common.audittrail.models.entities.Log;
import common.audittrail.models.entities.Platform;
import common.audittrail.repository.ILogRepository;
import common.audittrail.repository.IPlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1.0.1/Logs") // Base URL mapping
public class LogController {

    @Autowired
    ILogRepository logRepository;
    @Autowired
    IPlatformRepository platformRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Log>> GetLogs(){
        Optional<List<Log>> logs = Optional.of(logRepository.findAll());
        return logs.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity DeleteLogById(@PathVariable Long id){
        logRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Log> AddLog(@RequestBody Log log){
        String SystemName = log.getSystemName();
        Platform platform = platformRepository.FindBySystemName(SystemName);
        if (platform == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        Optional<Log> newLog = Optional.of(logRepository.save(log));
        return newLog.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @RequestMapping(value = "/{SystemName}", method = RequestMethod.GET)
    public ResponseEntity<Collection<Log>> GetLogs(@PathVariable String SystemName)
    {
        Optional<Collection<Log>> logs = Optional.of(logRepository.FindSystemLog(SystemName));
        return logs.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
