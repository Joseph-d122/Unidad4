package ec.edu.uce.application.service;

import java.util.List;

import ec.edu.uce.application.service.interceptors.Auditar;
import ec.edu.uce.domain.model.Producto;
import ec.edu.uce.infraestructure.repository.ProductoRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class ProductoService {

    @Inject
    ProductoRepositoryImpl productoReporitoryImpl;

    public void guardarProducto(Producto producto) {
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo Producto" + nombreHilo);
        System.out.println("ID:" +Thread.currentThread().threadId());
        
        this.productoReporitoryImpl.persist(producto);;
    }

    //@Auditar
    public void guardarListaProductos(List<Producto> lista){
        for(Producto p : lista){
            this.guardarProducto(p);
        }
    }

    //@Auditar
    public void guardarListaProductosParalelo(List<Producto> lista) {
        lista.parallelStream().forEach(producto -> {
            this.guardarProducto(producto);
        });
    }

    public Producto buscarProductoPorId(Integer id) {
        return Producto.findById(id);
    }

    public void actualizarProducto(Producto prodActualizado, Integer id){
        Producto prodBase = this.buscarProductoPorId(id);
        prodBase.setNombre(prodActualizado.getNombre());
        prodBase.setPrecio(prodActualizado.getPrecio());
        prodBase.setCategoria(prodActualizado.getCategoria());
    }

    public void actualizar2(Producto producto){
        Producto producto2 = this.buscarProductoPorId(producto.getId());
    }

    public void eliminarProducto(Integer id){
        this.productoReporitoryImpl.delete(this.buscarProductoPorId(id));
    }
}
