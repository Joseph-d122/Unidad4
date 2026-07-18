package ec.edu.uce.web.resource;

import ec.edu.uce.application.service.TransferenciaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/transferencia")
public class RecursoTransferencia {

    @Inject
    private TransferenciaService service;

    @Path("/realizar")
    @POST
    public String realizarTransferencia(TransferenciaResourse transferencia){
        return this.service.realizarTransferencia(transferencia.getCuentaOrigen(), transferencia.getCuentaDestino(), transferencia.getMonto());
    }

    @Path("/realizarReactiva")
    @POST
    public String realizarTransferenciaReactiva(TransferenciaResourse transferencia){
        return this.service.realizarTransferencia(transferencia.getCuentaOrigen(), transferencia.getCuentaDestino(), transferencia.getMonto());
    }
}
