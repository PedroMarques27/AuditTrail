package common.audittrail.models.entities;

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

    public Platform() {
    }

    public Platform(String systemName, String host, String healthEndpoint) {
        systemName = systemName;
        host = host;
        healthEndpoint = healthEndpoint;
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
}
