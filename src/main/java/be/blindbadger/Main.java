package be.blindbadger;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
     /*   //connectie met database
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("datasource");//factory opgestart
        //Driver heeft geen informatie meer nodig, daarom hebben wij een connection gecreerd


        EntityManager em = emf.createEntityManager();
        //entityManger hebben nodig die entity gaan manager

        //transactie nu aanmaken
        EntityTransaction tx = em.getTransaction();
        tx.begin();
      //  mijn entity aanbieden aan
        Message message = new Message().setId(1).setMessage("Hello Database");

        em.persist(message);//maak permanent message object


        tx.commit();*/
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("datasource");
        //dezelde naam in xml (name = datasource)
        EntityManager em = emf.createEntityManager();
//
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Message msg = new Message().setId(0).setMessage("Testing Persistence Context");
        //Message msg = em.find(Message.class, 1);
        //msg.setMessage("Hello cruel world");
        // EntityTransaction tx = em.getTransaction();
        em.persist(msg);

        tx.commit();
        em.close();
        emf.close(); //automatisch wordt em afgesluiten nadat emf wordt afgesloten


    }
}
