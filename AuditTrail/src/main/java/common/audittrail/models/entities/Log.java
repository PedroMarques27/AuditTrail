package common.audittrail.models.entities;

import common.audittrail.models.enums.Level;
import jakarta.persistence.*;

@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "systemName")
    public String systemName;

    @Column
    public Level level;

    @Column
    public String message;

    @Column
    public long timestamp;

    @Embedded
    public RequestInformation requestInformation; // Embedded request info

    @Embedded
    public ResponseInformation responseInformation; // Embedded response info

    public Log() {
        this.timestamp = System.currentTimeMillis();
    }

    public Log(String systemName, Level level, String message, RequestInformation requestInformation, ResponseInformation responseInformation) {
        this.systemName = systemName;
        this.level = level;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
        this.requestInformation = requestInformation;
        this.responseInformation = responseInformation;
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

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public RequestInformation getRequestInformation() {
        return requestInformation;
    }

    public void setRequestInformation(RequestInformation requestInformation) {
        this.requestInformation = requestInformation;
    }

    public ResponseInformation getResponseInformation() {
        return responseInformation;
    }

    public void setResponseInformation(ResponseInformation responseInformation) {
        this.responseInformation = responseInformation;
    }
}
