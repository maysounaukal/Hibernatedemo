package be.blindbadger;


import javax.persistence.*;


public class GetMessage {
    public static void main(String[] args) {
        EntityManagerFactory emp = Persistence.createEntityManagerFactory("datasource");
        EntityManager em = emp.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        Message message = em.find(Message.class, 8);
        System.out.println(message.getMessage());
        tr.commit();

    }
}
