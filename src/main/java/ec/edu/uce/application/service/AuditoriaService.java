package ec.edu.uce.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class AuditoriaService {

    public void guardar(String auditoria){
        System.out.println("ID: "+Thread.currentThread().threadId());

        try{
            Thread.sleep(2000);
        }catch(Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("Se registra la auditoria");
    }
}
