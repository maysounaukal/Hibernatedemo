package messages;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Message {
    @Id//de annotatie staat altijd bij
    @GeneratedValue //gaat auotomatisch verhogen
    private int id;
    private String message;
    private String text;

    public Message() {
    }


    public int getId() {
        return id;
    }

    //getters en builders builder en niet default

    public Message setId(int id) {
        this.id = id;
        return this;

    }

    public String getMessage() {
        return message;
    }

    public Message setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}


