package be.blindbadger;

import javax.persistence.*;

public class main2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("datasource");
        EntityManager em = emf.createEntityManager();

        Message message = new Message();

        EntityTransaction tx = em.getTransaction();

        tx.begin();
        message.setMessage("Hello World");
        // message.setId(1);

        em.persist(message);

        tx.commit();

        em.close();
        emf.close();
    }
}
