package common.audittrail.models.entities;

import common.audittrail.models.enums.Condition;
import jakarta.persistence.*;

@Entity
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(unique = true)
    public String systemName;

    @Column
    public String host;

    @Column
    public String healthEndpoint;

    @Column
    public Condition condition;

    @Column
    public long lastCheckup;

    public Platform() {
    }

    public Platform(String systemName, String host, String healthEndpoint, Condition condition, long lastCheckup) {
        systemName = systemName;
        host = host;
        healthEndpoint = healthEndpoint;
        condition = condition;
        lastCheckup = lastCheckup;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getHealthEndpoint() {
        return healthEndpoint;
    }

    public void setHealthEndpoint(String healthEndpoint) {
        this.healthEndpoint = healthEndpoint;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public long getLastCheckup() {
        return lastCheckup;
    }

    public void setLastCheckup(long lastCheckup) {
        this.lastCheckup = lastCheckup;
    }
}
