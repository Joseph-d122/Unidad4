package ec.edu.uce.application.service.interceptors;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@MedirTiempo
@Interceptor
@Priority(1)
public class MedirTiempoInterceptor { 

    @AroundInvoke
    public Object medir(InvocationContext context) throws Exception {
        String nombreMetodo = context.getMethod().getName();
        String nombreClase = context.getMethod().getDeclaringClass().getSimpleName();
        String nombreHilo = Thread.currentThread().getName();

        long inicio = System.currentTimeMillis();

        System.out.println("Iniciando método: " + nombreClase + "." + nombreMetodo);
        System.out.println("Hilo que atiende: " + nombreHilo);

        try {
            return context.proceed();
        } finally {
            long fin = System.currentTimeMillis();
            System.out.println("Tiempo de ejecución de " + nombreMetodo + ": " + (fin - inicio) + "ms");
        }
    }
}
