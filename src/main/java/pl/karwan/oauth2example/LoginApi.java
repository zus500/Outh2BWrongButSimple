package pl.karwan.oauth2example;



import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class LoginApi {

    @PostMapping("/login")
    public String login(@RequestBody User user)
    {
        long currentTiemeMillis = System.currentTimeMillis();
        return   Jwts.builder()
        .setSubject(user.getLogin())
        .claim("Roles" , "user")
        .setIssuedAt(new Date(currentTiemeMillis))
        .setExpiration(new Date(currentTiemeMillis + 20000))
        .signWith(SignatureAlgorithm.HS512, user.getHaslo()).compact();

    }
}
