package common.audittrail.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.springframework.http.HttpStatus;

@Embeddable
public class ResponseInformation {

    @Column
    private HttpStatus statusCode;

    @Column
    private String responseBody;

    public ResponseInformation() {}

    public ResponseInformation(HttpStatus statusCode, String responseBody) {
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }


    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

}
