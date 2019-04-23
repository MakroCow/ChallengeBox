import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

public class main {

    @Transactional
    public static void main(String[]args){
        TestConnection tc = new TestConnection();
        try{
            tc.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        }

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("abc");
        EntityManager entityManager =  factory.createEntityManager();

        entityManager.close();


    }
}
