package common.audittrail.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Log {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long Guid;

    public String SystemId;
    public Level Level;
    public String Message;
    public String Data;
    public long Timestamp;

    public Log() {
        this.Timestamp = System.currentTimeMillis();
    }
    public Log(String SystemName, Level Level, String Message, String Data){
        this.SystemId = SystemName;
        this.Level = Level;
        this.Message = Message;
        this.Data = Data;
        this.Timestamp = System.currentTimeMillis();
    }

    public String getSystemId() {
        return SystemId;
    }

    public void setSystemId(String systemId) {
        SystemId = systemId;
    }

    public common.audittrail.models.Level getLevel() {
        return Level;
    }

    public void setLevel(common.audittrail.models.Level level) {
        Level = level;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    @Override
    public String toString() {
        return "Log{" +
                "Guid=" + Guid +
                ", SystemName='" + SystemId + '\'' +
                ", Level=" + Level +
                ", Message='" + Message + '\'' +
                ", Data='" + Data + '\'' +
                ", Timestamp=" + Timestamp +
                '}';
    }
}
