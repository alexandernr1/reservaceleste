
package Logica;
import Presentacion.Jmenuhotel;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author Usuario
 */
public class ActualizadorColores implements Runnable {
    
     private final Jmenuhotel ventana;
    private final ScheduledExecutorService scheduler;
    private final ScheduledExecutorService statusChecker;

    public ActualizadorColores(Jmenuhotel ventana) {
        this.ventana = ventana;
        this.scheduler = Executors.newScheduledThreadPool(1);
        this.statusChecker = Executors.newScheduledThreadPool(1);
    }

    @Override
    public void run() {
//        System.out.println("ActualizadorColores se está ejecutando: " + System.currentTimeMillis());
        ventana.actualizarColoresBotones();
    }

    public void iniciarHilo() {
        scheduler.scheduleAtFixedRate(this, 0, 5, TimeUnit.SECONDS);
        
        // Verificación periódica del estado del Scheduler
        statusChecker.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if (!scheduler.isShutdown()) {
//                    System.out.println("Scheduler está activo: " + System.currentTimeMillis());
                } else {
//                    System.out.println("Scheduler ha sido apagado.");
                }
            }
        }, 0, 5, TimeUnit.SECONDS);
        
    }
    public void detener() {
        scheduler.shutdown();
        statusChecker.shutdown();
    }
    

}
