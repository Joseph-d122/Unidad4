package ec.edu.uce.application.service;

import java.util.List;

import ec.edu.uce.domain.model.Reporte;
import ec.edu.uce.infraestructure.repository.ReposrteRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class ReporteService {

    @Inject
    private ReposrteRepositoryImpl reposrteRepositoryImpl;


    public List<Reporte> buscarTodos(){
        return (List<Reporte>) this.reposrteRepositoryImpl.findAll();
    }

    //@MedirTiempo
    public void guardarReporte(Reporte reporte){
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("nombre del hilo Reporte: " + nombreHilo);
        System.out.println("ID:" + Thread.currentThread().threadId());
        
        /* try {
            Thread.sleep(1000); 
        } catch(Exception e) {
            e.printStackTrace();
        }
         */
        //reporte.persist();
        this.reposrteRepositoryImpl.persist(reporte);
    }

    //@Auditar
    public void guardarListaReportes(List<Reporte> lista){
        /* for(Reporte p : lista){
            this.guardarReporte(p);
        } */

            lista.stream().forEach(repote -> {
                //aqui programo toda la logica que quiero que se aplique a cada item de la lista
                this.guardarReporte(repote);
            });
    }

    //@Auditar
    public void guardarListaReportesParalelo(List<Reporte> lista){
        lista.parallelStream().forEach(repote -> {
            //aqui programo toda la logica que quiero que se aplique a cada item de la lista
            this.guardarReporte(repote);
        });
    }

    public Reporte buscarReporteporId(Integer id){
        return Reporte.findById(id);
    }

    public void actualizarReporte(Reporte reporteActualizado, Integer id){
        Reporte reporteBase = this.buscarReporteporId(id);
        reporteBase.setNumero(reporteActualizado . getNumero());
        reporteBase.setTexto(reporteActualizado.getTexto());
        //no hace falta realizar explicitamente un update
    }

    public void actualizar2(Reporte reporte){
        Reporte reporteBase = this.buscarReporteporId(reporte.getId());
    }

    public void eliminarReporte(Integer id){
        this.reposrteRepositoryImpl.delete(this.buscarReporteporId(id));
    } 


}