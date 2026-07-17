package ec.edu.uce.web.resource;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.inject.Inject;

import java.util.List;

import ec.edu.uce.application.service.ProductoService;
import ec.edu.uce.domain.model.Producto;

@Path("/producto")
public class ProductoResource {
    @Inject
    public ProductoService productoService;

    @Path("/porId/{id}")
    @GET
    public Producto buscarPorId(@PathParam("id") Integer id){
        return this.productoService.buscarProductoPorId(id);
    }

     @Path("/todos")   
    @GET
    public List<Producto> buscarTodos(){
        return this.productoService.buscarTodos();
    }

    @Path("/guardar")
    @POST
    public void guardar(Producto producto){
        this.productoService.guardarProducto(producto);
    }

    @Path("/actualizar/{id}")
    @PUT
    public void actualizar(Producto producto, @PathParam("id") Integer id){
        this.productoService.actualizarProducto(producto, id);
    }

    @Path("/eliminar/{id}")
    @DELETE
    public void eliminar(@PathParam("id") Integer id){
        this.productoService.eliminarProducto(id);
    }

}
