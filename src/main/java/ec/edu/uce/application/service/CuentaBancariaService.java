package ec.edu.uce.application.service;

import java.io.IOException;
import java.math.BigDecimal;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CuentaBancariaService {

    
    public BigDecimal agragarMonto(String numeroCuenta, BigDecimal monto){
        System.out.println("ID: "+Thread.currentThread().threadId());
        try{
            Thread.sleep(2000);
        }catch(Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        
        BigDecimal saldo = BigDecimal.valueOf(1000);
        saldo=saldo.add(monto);
        return saldo;
    }

    public BigDecimal restaMonto(String numeroCuenta, BigDecimal monto){
        System.out.println("ID: "+Thread.currentThread().threadId());
        try{
            Thread.sleep(2000);
        }catch(Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        BigDecimal saldo = BigDecimal.valueOf(2000);
        saldo=saldo.subtract(monto);
        return saldo;
    }

    public Uni<BigDecimal> agregarMontoPromesa(String numeroCuenta, BigDecimal monto){
        return Uni.createFrom().item(this.agragarMonto(numeroCuenta, monto));
    }

    public Uni<BigDecimal> restaMontoPromesa(String numeroCuenta, BigDecimal monto){
        return Uni.createFrom().item(()->
        //aqui dentro todo lo que me demora en ejecutar

        //Ejemplo seria para esto, en lugar del restar monto lo que se programo dentro del metodo iria aqui
        this.restaMonto(numeroCuenta, monto));
    }
}
