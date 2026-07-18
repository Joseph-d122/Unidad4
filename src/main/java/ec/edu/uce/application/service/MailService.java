package ec.edu.uce.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class MailService {

    public void enviarMail(String destino, String asunto, String cuerpo) {
        System.out.println("ID: "+Thread.currentThread().threadId());
        try{
            Thread.sleep(1000);
        }catch(Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("Se envia un Mail a: " + destino);
    }
}
