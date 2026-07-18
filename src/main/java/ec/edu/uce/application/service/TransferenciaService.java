package ec.edu.uce.application.service;

import java.math.BigDecimal;

import ec.edu.uce.application.service.interceptors.MedirTiempo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
@Transactional
public class TransferenciaService {

    @Inject
    private CuentaBancariaService bancariaService;

    @Inject
    private MailService mailService;

    @Inject
    private AuditoriaService auditorService;

    //para datos como dinero se debe utilizar BigDecimal
    @MedirTiempo
    public String realizarTransferencia(String cuentaOrigen, String cuentaDestino, BigDecimal monto) {
        System.out.println("ID: "+Thread.currentThread().threadId());

        BigDecimal saldoDestino= this.bancariaService.agragarMonto(cuentaDestino, monto);
        BigDecimal saldoOrigen= this.bancariaService.restaMonto(cuentaDestino, monto);
        
        this.mailService.enviarMail("jdcondorl@uce.edu.ec", "asunto", "mensaje");
        this.auditorService.guardar("Auditoria");
        String mensaje = "Se realizo con exito, su saldo destino es " +saldoDestino+ " su saldo origen es "+saldoOrigen;
        return mensaje;
    }

    public String realizarTransferenciaReactiva(String cuentaOrigen, String cuentaDestino, BigDecimal monto) {
 
        System.out.println("nombre hilo main" + Thread.currentThread().threadId());
 
        Uni<BigDecimal> saldoDestno = this.bancariaService.agregarMontoPromesa(cuentaDestino, monto);
        Uni<BigDecimal> saldoOrigen = this.bancariaService.restaMontoPromesa(cuentaDestino, monto);this.mailService.enviarMail("jdcondorl@uce.edu.ec", "asunto", "mensaje");
        this.auditorService.guardar("Auditoria");
        
         Uni.combine().all().unis(saldoDestno, saldoOrigen).asTuple().map(resul -> {
            String mensaje = "Se realizo con exito la transferencia, su saldo destino es: "
                    + resul.getItem1() + " su saldo origen es: " + resul.getItem2();
                    System.out.println(mensaje);
            return mensaje;
        }).toString();
 
        return "Finalizado";
    }

}
