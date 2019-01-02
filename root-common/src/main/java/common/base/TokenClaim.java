package common.base;

import java.io.Serializable;

/**
 * Created by cc on 2018/3/23.
 */
public class TokenClaim implements Serializable{

//    header
    private String alg;
    private String typ;
//    payload
    private Long opId;
    private Long opType;
    private String sub;
    private String issuer;
    private String secret;

    public TokenClaim() {
    }

    public TokenClaim(Long opId, Long opType) {
        this.opId = opId;
        this.opType = opType;
    }

    public String getAlg() {
        return alg;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public Long getOpId() {
        return opId;
    }

    public void setOpId(Long opId) {
        this.opId = opId;
    }

    public Long getOpType() {
        return opType;
    }

    public void setOpType(Long opType) {
        this.opType = opType;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getIssuer() {
        return issuer;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }
}
