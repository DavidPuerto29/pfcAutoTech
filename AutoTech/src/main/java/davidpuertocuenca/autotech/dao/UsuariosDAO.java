/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package davidpuertocuenca.autotech.dao;

import davidpuertocuenca.autotech.clases.Usuarios;
import jakarta.persistence.NoResultException;
import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;


/**
 *
 * @author David Puerto Cuenca
 */
public class UsuariosDAO {
    public static void crearClienteSql(Usuarios cliente) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
                session.persist(cliente);
                    session.getTransaction().commit();
        }
    }
    
    public static void eliminarClienteSql(Usuarios cliente){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.getTransaction().begin();
                session.remove(cliente);
                    session.getTransaction().commit();
        }
    }
    
    public static Usuarios obtenerClienteUsuarioSql(String usuario){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Usuarios> q = session.createNamedQuery("get_cliente_username", Usuarios.class);
                q.setParameter("username", usuario);
                    return (Usuarios) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public static Usuarios obtenerClientePorDniSql(String dni){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Usuarios> q = session.createNamedQuery("get_cliente_dni", Usuarios.class);
                q.setParameter("dniCliente", dni);
                    return (Usuarios) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public static Usuarios loginClienteSql(String usuario,String contrasena){    //Creo que obsoleto - PUEDE Q SOBRE COMPROBAR A FINAL DE PROYECTO
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Usuarios> q = session.createNamedQuery("get_cliente_login", Usuarios.class);
                q.setParameter("username", usuario);
                    q.setParameter("password", contrasena);
                        return (Usuarios) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
     public static List<Usuarios> obtenerTodosClientesSql(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Usuarios> q = session.createNamedQuery("get_todos_clientes", Usuarios.class);
                return q.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
    
     public static boolean actualizarClienteSql(Usuarios cliente){
        try(Session session = HibernateUtil.getSessionFactory().openSession();){
            session.getTransaction().begin();
                session.merge(cliente);
                    session.getTransaction().commit();
                        return true;
        }
     }
     
     public static Usuarios obtenerClienteSql(String usuario){  
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Usuarios> q = session.createNamedQuery("get_cliente", Usuarios.class);
                q.setParameter("username", usuario);
                    return (Usuarios) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
