package ec.edu.uce.web.resource;

import ec.edu.uce.application.service.ReporteService;
import ec.edu.uce.domain.model.Reporte;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;


//como esto es una aplicacion web debo especificarle una ruta para acceder a reportes
@Path("/reportes")
public class ReporteResource {
    @Inject
    public ReporteService reporteService;
    
    public Reporte buscarPorId(Integer id){
        return this.reporteService.buscarReporteporId(id);
    }
}
