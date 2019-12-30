package messages;

import be.blindbadger.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestMessage {
    private static EntityManagerFactory emf;

    private static void print(int pos, Message memMessage) {
        EntityManager em = emf.createEntityManager();
        Message dbMessage = em.find(Message.class, memMessage.getId());
        em.close();
        System.out.println(pos + ": " + memMessage.getMessage() + "\t" + ((dbMessage != null) ?
                dbMessage.getMessage() : "null"));
    }

    public static void main(String[] args) {
        EntityManager em = null;
        // EntityManagerFactory emf = null;
        try {

            emf = Persistence.createEntityManagerFactory("datasource");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Message m = em.find(Message.class, 1);
            if (m != null) {
                em.remove(m);
            }
            tx.commit();

            tx.begin();
            m = new Message("AAA");
            print(1, m);
            em.persist(m);
            tx.commit();
            print(2, m);
            m.setMessage("BBB");
            tx.begin();
            em.refresh(m);
            print(3, m);
            em.detach(m);
            m.setMessage("CCC");
            print(4, m);
            tx.commit();
            print(5, m);
            tx.begin();
            m = em.merge(m);
            print(6, m);
            tx.commit();
            print(7, m);
            em.clear();
            m.setMessage("DDD");
            print(8, m);
            tx.begin();
            tx.commit();
            print(9, m);
            m = em.find(Message.class, 2);
            print(10, m);
            m.setMessage("EEE");
            print(11, m);
            tx.begin();
            tx.commit();
            m.setMessage("FFF");
            tx.begin();
            em.flush();
            m.setMessage("GGG");
            print(12, m);
            em.refresh(m);
            print(13, m);
            tx.rollback();
            print(14, m);
            tx.begin();
            m.setMessage("HHH");
            print(15, m);
            tx.commit();
            print(16, m);
            tx.begin();
            m = em.merge(m);
            print(17, m);
            tx.commit();
            print(18, m);
            em.close();


        } finally {
            if (em != null)
                em.close();
            if (emf != null)
                emf.close();
        }

    }
}
