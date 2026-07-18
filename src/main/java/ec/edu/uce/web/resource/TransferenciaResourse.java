package ec.edu.uce.web.resource;

import java.math.BigDecimal;

public class TransferenciaResourse {
    private String cuentaOrigen;
    private String cuentaDestino;
    private BigDecimal monto;
    public String getCuentaOrigen() {
        return cuentaOrigen;
    }
    public void setCuentaOrigen(String cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }
    public String getCuentaDestino() {
        return cuentaDestino;
    }
    public void setCuentaDestino(String cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }
    public BigDecimal getMonto() {
        return monto;
    }
    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    

}
