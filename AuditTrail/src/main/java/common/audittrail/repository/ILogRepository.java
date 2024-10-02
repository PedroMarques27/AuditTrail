package common.audittrail.repository;

import common.audittrail.models.entities.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface ILogRepository extends JpaRepository<Log, Long> {

    @Query("SELECT e FROM Log e WHERE e.systemName = :sysname")
    Collection<Log> FindSystemLog(@Param("sysname") String sysname);

}
