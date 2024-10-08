package common.audittrail.repository;

import common.audittrail.models.entities.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPlatformRepository extends JpaRepository<Platform, Long> {

    @Query("SELECT p FROM Platform p WHERE p.systemName = :sysname")
    Platform FindBySystemName(@Param("sysname") String sysname);
}
