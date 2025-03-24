/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package davidpuertocuenca.autotech.dao;

import davidpuertocuenca.autotech.clases.Cliente;
import jakarta.persistence.NoResultException;
import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;


/**
 *
 * @author David Puerto Cuenca
 */
public class ClienteDAO {
    public static void crearClienteSql(Cliente cliente) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
                session.persist(cliente);
                    session.getTransaction().commit();
        }
    }
    
    public static void eliminarClienteSql(Cliente cliente){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.getTransaction().begin();
            session.remove(cliente);
            session.getTransaction().commit();
        }
    }
    
    public static Cliente obtenerClientePorUsuarioSql(String usuario){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Cliente> q = session.createNamedQuery("get_cliente_username", Cliente.class);
                q.setParameter("username", usuario);
                    return (Cliente) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public static Cliente loginClienteSql(String usuario,String contrasena){    //Creo que obsoleto - PUEDE Q SOBRE COMPROBAR A FINAL DE PROYECTO
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Cliente> q = session.createNamedQuery("get_cliente_login", Cliente.class);
                q.setParameter("username", usuario);
                    q.setParameter("password", contrasena);
                        return (Cliente) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
     public static List<Cliente> obtenerTodosClientesSql(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Cliente> q = session.createNamedQuery("get_todos_clientes", Cliente.class);
                return q.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
    
     public static boolean actualizarClienteSql(Cliente cliente){
        try(Session session = HibernateUtil.getSessionFactory().openSession();){
            session.getTransaction().begin();
                session.merge(cliente);
                    session.getTransaction().commit();
                        return true;
        }
     }
     
     public static Cliente obtenerClienteSql(String usuario){  
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Cliente> q = session.createNamedQuery("get_cliente", Cliente.class);
                q.setParameter("username", usuario);
                    return (Cliente) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
