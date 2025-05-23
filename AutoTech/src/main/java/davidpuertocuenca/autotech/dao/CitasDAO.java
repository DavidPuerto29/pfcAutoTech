/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package davidpuertocuenca.autotech.dao;

import davidpuertocuenca.autotech.clases.Citas;
import davidpuertocuenca.autotech.clases.Talleres;
import davidpuertocuenca.autotech.clases.Vehiculos;
import jakarta.persistence.NoResultException;
import java.time.LocalDateTime;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author David Puerto Cuenca
 */
public class CitasDAO {
    
    public static List<Citas> obtenerTodasCitasMatriculaSql(Vehiculos vehiculo){    
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Citas> q = session.createNamedQuery("get_todas_citas_matricula", Citas.class);
                q.setParameter("matricula", vehiculo.getMatricula());
                    return q.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
        
    public static List<Citas> obtenerTodasCitasSql(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Citas> q = session.createNamedQuery("get_todas_citas", Citas.class);
                return q.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public static void crearCitaSql(Citas cita) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
                session.persist(cita);
                    session.getTransaction().commit();
        }
    }
    
    public static void eliminarCitaSql(Citas citas){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.getTransaction().begin();
                session.remove(citas);
                    session.getTransaction().commit();
        }
    }
    
    public static Citas obtenerCitaPorNumeroSql(Long numeroCita){  
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Citas> q = session.createNamedQuery("get_cita", Citas.class);
                q.setParameter("identificacion", numeroCita);
                    return (Citas) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public static int obtenerNumeroCitasSql(Talleres taller, LocalDateTime fechaHora) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Citas> q = session.createNamedQuery("get_citas_taller_horario", Citas.class);
                q.setParameter("taller", taller);
                q.setParameter("fecha", fechaHora);
                List<Citas> citas = q.getResultList();
                    return citas.size();
        } catch (NoResultException e) {
            return 0;
        }
    }
    
    public static boolean actualizarCitaSql(Citas cita){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.getTransaction().begin();
                session.merge(cita);
                    session.getTransaction().commit();
                        return true;
        }
    }

}
