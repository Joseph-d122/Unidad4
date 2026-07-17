package ec.edu.uce.web.resource;

import java.util.List;

import ec.edu.uce.application.service.ReporteService;
import ec.edu.uce.domain.model.Reporte;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;


//como esto es una aplicacion web debo especificarle una ruta para acceder a reportes
@Path("/reporte")
public class ReporteResource {
    @Inject
    public ReporteService reporteService;
    
    @Path("/porId/{id}")   //para llegar a este metodo http://localhost:8080/reporte/porId/1
    @GET
    public Reporte buscarPorId(@PathParam("id") Integer id){  //el "id" deber de igual a {id} pero ambos no necesariamente con id
        return this.reporteService.buscarReporteporId(id);
    }

    @Path("/todos")   //para llegar a este metodo http://localhost:8080/reporte/todos
    @GET
    public List<Reporte> buscarTodos(){
        return this.reporteService.buscarTodos();
    }

//desde el navegador solo se puede hacer peticiones get, para utilizar el guardar
//podemos utilizar postman

    @Path("/guardar")
    @POST
    public void guardar(Reporte reporte){
        this.reporteService.guardarReporte(reporte);
    }

    @Path("/actualizar/{id}")
    @PUT
    public void actualizar(Reporte reporte, @PathParam("id") Integer id){
        this.reporteService.actualizarReporte(reporte, id);
    }

    @Path("/eliminar/{id}")
    @DELETE
    public void eliminar(@PathParam("id") Integer id){
        this.reporteService.eliminarReporte(id);
    }
}
