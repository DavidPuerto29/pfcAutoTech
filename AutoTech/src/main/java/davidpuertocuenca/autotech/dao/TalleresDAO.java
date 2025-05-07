/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package davidpuertocuenca.autotech.dao;

import davidpuertocuenca.autotech.clases.Talleres;
import jakarta.persistence.NoResultException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author David Puerto Cuenca
 */
public class TalleresDAO {
    public static List<Talleres> obtenerTodosTalleresSql(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Talleres> q = session.createNamedQuery("get_todos_talleres", Talleres.class);
                return q.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
            
    public static Talleres obtenerTallerPorNumeroSql(Long numeroTaller){  
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Talleres> q = session.createNamedQuery("get_taller", Talleres.class);
                q.setParameter("identificacion", numeroTaller);
                    return (Talleres) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }       
    
    public static Talleres obtenerTallerPorCifSql(String identificacionFiscal){  
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Talleres> q = session.createNamedQuery("get_taller_cif", Talleres.class);
                q.setParameter("identificacion", identificacionFiscal);
                    return (Talleres) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }       
    
    public static void crearTallerSql(Talleres taller) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
                session.persist(taller);
                    session.getTransaction().commit();
        }
    }
    
    public static void eliminarTallerSql(Talleres taller){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.getTransaction().begin();
                session.remove(taller);
                    session.getTransaction().commit();
        }
    }
    
    public static void actualizarTallerSql(Talleres taller){
        try(Session session = HibernateUtil.getSessionFactory().openSession();){
            session.getTransaction().begin();
                session.merge(taller);
                    session.getTransaction().commit();
        }
    }
    
}
