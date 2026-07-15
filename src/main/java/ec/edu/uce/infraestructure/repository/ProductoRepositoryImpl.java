package ec.edu.uce.infraestructure.repository;

import ec.edu.uce.domain.model.Producto;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class ProductoRepositoryImpl implements PanacheRepositoryBase<Producto, Integer> {
    
}
