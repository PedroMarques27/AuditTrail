package common.audittrail.models.entities;

import common.audittrail.models.enums.HttpCode;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ResponseInformation {

    @Column
    private HttpCode statusCode;

    @Column
    private String responseBody;

    public ResponseInformation() {}

    public ResponseInformation(HttpCode statusCode, String responseBody) {
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }


    public HttpCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpCode statusCode) {
        this.statusCode = statusCode;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

}
