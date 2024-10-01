package common.audittrail.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Log {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="systemName")
    public String systemName;

    @Column
    public Level level;

    @Column
    public String message;

    @Column
    public String data;

    @Column
    public long timestamp;

    public Log() {
        this.timestamp = System.currentTimeMillis();
    }
    public Log(String SystemName, Level Level, String Message, String Data){
        this.systemName = SystemName;
        this.level = Level;
        this.message = Message;
        this.data = Data;
        this.timestamp = System.currentTimeMillis();
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
