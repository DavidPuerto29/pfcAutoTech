package davidpuertocuenca.autotech.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import davidpuertocuenca.autotech.clases.Citas;
import davidpuertocuenca.autotech.clases.Usuarios;
import davidpuertocuenca.autotech.clases.Talleres;
import davidpuertocuenca.autotech.clases.UsuariosTalleres;
import davidpuertocuenca.autotech.clases.Vehiculos;

/**
 * Clase destinada a configuración para el gestor de datos
 * sql de hibernate.
 *
 * @author David Puerto Cuenca
 * @version 1.0
 */

public class HibernateUtil {
    
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try (StandardServiceRegistry registry = new
                    StandardServiceRegistryBuilder().build();) {
                sessionFactory = new MetadataSources(registry)
                        .addAnnotatedClass(Citas.class)
                        .addAnnotatedClass(Usuarios.class)
                         .addAnnotatedClass(UsuariosTalleres.class)
                        .addAnnotatedClass(Talleres.class)
                        .addAnnotatedClass(Vehiculos.class)
                        .buildMetadata().buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

}
