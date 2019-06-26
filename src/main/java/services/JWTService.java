package services;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

/**
 * Service zum erstellen und prüfen des jwt
 */
@ApplicationScoped
public class JWTService {

    private List<String> validJWTTokens = new ArrayList();

    /**
     * generriert aus der mail einen jwt
     * @param mail
     * @return jwt
     */

    public String generateJWTToken(String mail) {
        // ...read user information from database...
        String token = Jwts.builder()
                .setSubject(mail)
                .claim("groups", new String[] { "user" })
                .claim("mail", mail)
                //TODO (s:)ecret auslagern
                .signWith(SignatureAlgorithm.HS512, "JWT-Key")
                .compact();

        this.validJWTTokens.add(token);
        return token;
    }

    /**
     * validiert jwt
     * @param token
     */

    public void valid(String token) {
        if (!this.validJWTTokens.contains(token)) {
            throw new RuntimeException("Token is not valid anymore");
        }

        JwtParser signed = Jwts.parser().setSigningKey("JWT-Key");

        String username = signed.parseClaimsJws(token).getBody().getSubject();
        System.out.println("Request is JWT-sigend with user: " + username);
    }

    /**
     * entfernt jwt
     * @param token
     */
    public void removeToken(String token) {
        this.validJWTTokens.remove(token);
    }
}