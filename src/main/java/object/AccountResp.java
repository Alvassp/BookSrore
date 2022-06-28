package object;

import java.util.Date;

public class AccountResp {
    public String getToken() {
        return token;
    }

    public Date getExpires() {
        return expires;
    }

    public String getStatus() {
        return status;
    }

    public String getResult() {
        return result;
    }

    public AccountResp(String token, Date expires, String status, String result) {
        this.token = token;
        this.expires = expires;
        this.status = status;
        this.result = result;
    }

    private String token;
    private Date expires;
    private String status;
    private String result;
}
