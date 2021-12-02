import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.gdpu.entity.User;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//token生成与解析测试
public class TokenTest {
    @Test
    public void test() throws InterruptedException {
        User user = new User();
        String password = "123456";
        user.setUsername("admin");
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        Date iatDate = new Date();
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.SECOND, 3);
        Date expiresDate = nowTime.getTime();

        //服务器私钥
        String secret = "gdpubooksys";

        //生成token
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("alg", "HS256");
        map.put("type", "JWT");
        String token = JWT.create().withHeader(map)
                .withClaim("username", user.getUsername())
                .withExpiresAt(expiresDate)
                .withIssuedAt(iatDate)
                .sign(Algorithm.HMAC256(secret));
        System.out.println(token);

        //解析token
        Thread.sleep(5000);
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).build();
        DecodedJWT jwt = null;
        try {
            jwt = verifier.verify(token);
            Map<String, Claim> result = jwt.getClaims();
            jwt.getKeyId();
            jwt.getToken();
            System.out.println(jwt.getExpiresAt().after(new Date()));
            String info = jwt.getClaim("username").asString();
            System.out.println(info);
        } catch (JWTVerificationException e) {
            System.out.println("Failed to verify.");
        }

    }
}
