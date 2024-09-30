package common.audittrail.repository;

import common.audittrail.models.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface ILogRepository extends JpaRepository<Log, Long> {

    @Query("SELECT e FROM Log e WHERE e.SystemId = :SystemId AND e.Timestamp >= :InitTimestamp AND e.Timestamp <= :EndTimestamp")
    Collection<Log> FindSystemLog(@Param("SystemId") String SystemId, @Param("InitTimestamp") long InitTimestamp, @Param("EndTimestamp") long EndTimestamp);

}
