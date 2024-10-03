package common.audittrail.models.entities;

import common.audittrail.models.enums.HttpRequestCode;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class RequestInformation {

    @Column
    private HttpRequestCode method;

    @Column
    private String url;

    @Column
    private String clientIp;

    @Column
    private String headers;

    @Column
    private String requestBody;

    public RequestInformation() {}

    public RequestInformation(HttpRequestCode method, String url, String clientIp, String headers, String requestBody) {
        this.method = method;
        this.url = url;
        this.clientIp = clientIp;
        this.headers = headers;
        this.requestBody = requestBody;
    }

    public HttpRequestCode getMethod() {
        return method;
    }

    public void setMethod(HttpRequestCode method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }
}
