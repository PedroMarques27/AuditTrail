package common.audittrail.controllers;

import common.audittrail.models.entities.Platform;
import common.audittrail.repository.IPlatformRepository;
import common.audittrail.services.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Platform") // Base URL mapping
public class PlatformController {
    @Autowired
    IPlatformRepository platformRepository;

    @Autowired
    private PlatformService platformService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Platform>> GetPlatformStatus(){
        Optional<List<Platform>> platforms = Optional.of(platformRepository.findAll());
        return platforms.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Platform> AddPlatform(@RequestBody Platform platform){
        Optional<Platform> updatedPlatform = Optional.of(platformRepository.save(platform));
        return updatedPlatform.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @RequestMapping(value="/{SystemName}", method = RequestMethod.GET)
    public ResponseEntity<Platform> GetPlatformByName(@PathVariable String SystemName) {
        Optional<Platform> updatedPlatform = Optional.of(platformRepository.FindBySystemName(SystemName));
        return updatedPlatform.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @RequestMapping(value="/{SystemName}", method = RequestMethod.PUT)
    public ResponseEntity<Platform> updatePlatform(@PathVariable String SystemName, @RequestBody Platform platformDetails) {
        Optional<Platform> updatedPlatform = platformService.UpdatePlatform(SystemName, platformDetails);
        return updatedPlatform.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @RequestMapping(value="/{SystemName}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> updatePlatform(@PathVariable String SystemName) {
        return Optional.of(platformRepository.FindBySystemName(SystemName))
                .map(platform -> {
                    platformRepository.deleteById(platform.id);
                    return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @RequestMapping(value="/Id/{Id}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> updatePlatform(@PathVariable Long Id) {
        return Optional.of(platformRepository.findById(Id))
                .map(platform -> {
                    platformRepository.deleteById(Id);
                    return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
