package common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import common.base.TokenClaim;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by cc on 2018/3/22.
 */
public class TokenUtil {

    private static final String SECRET = PropertiesFileUtil.getInstance("config").get("token.secret");
    private static final String ISSUER = PropertiesFileUtil.getInstance("config").get("token.issuer");
    private static final String SUBJECT = PropertiesFileUtil.getInstance("config").get("token.subject");

    public static String getToken(TokenClaim tokenClaim) throws UnsupportedEncodingException, IllegalArgumentException {

//        token 过期时间，目前暂定为一天
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.YEAR, 1);
        Date exp = calendar.getTime();

        String alg = tokenClaim.getAlg();
        Long opId = tokenClaim.getOpId();
        Long opType = tokenClaim.getOpType();

//        创建token头部信息
        HashMap<String, Object> headerClaims = new HashMap<>();
        headerClaims.put("alg", alg);

//        生成token
        Algorithm algorithm = Algorithm.HMAC256(SECRET);

        return JWT.create()
                .withIssuer(ISSUER)
                .withExpiresAt(exp)
                .withSubject(SUBJECT)
                .withClaim("iat", new Date())
                .withClaim("opId", opId)
                .withClaim("opType", opType)
                .withHeader(headerClaims)
                .sign(algorithm);
    }

    public static DecodedJWT verifyToken(String token) throws UnsupportedEncodingException {
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(ISSUER)
                .withSubject(SUBJECT)
                .build(); //Reusable verifier instance
        return verifier.verify(token);
    }
}
