package common.audittrail.services;

import common.audittrail.models.entities.Platform;
import common.audittrail.repository.IPlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlatformService {

    @Autowired
    private IPlatformRepository platformRepository;

    public Optional<Platform> UpdatePlatform(String SystemName, Platform platformDetails) {
        Optional<Platform> optionalPlatform = Optional.of(platformRepository.FindBySystemName(SystemName));
        if (optionalPlatform.isPresent()) {
            Platform platform = optionalPlatform.get();
            platform.setSystemName(platformDetails.getSystemName());
            platform.setHost(platformDetails.getHost());
            platform.setHealthEndpoint(platformDetails.getHealthEndpoint());
            platform.setCondition(platformDetails.getCondition());
            platform.setLastCheckup(platformDetails.getLastCheckup());
            return Optional.of(platformRepository.save(platform));
        }
        return Optional.empty();
    }


}
