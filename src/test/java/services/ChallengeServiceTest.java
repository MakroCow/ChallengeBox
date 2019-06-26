package services;

import entities.Challenge;
import org.mockito.Mock;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.Date;

public class ChallengeServiceTest {

    @Mock
    EntityManager em;

    @Test
    public static void createChallengeTest()
    {
        Challenge c = new Challenge(
                "Titel",
                "Description",
                null,
                0,
                1,
                2);
        ChallengeService cs = new ChallengeService();
        cs.createChallenge(c);
    }

}
