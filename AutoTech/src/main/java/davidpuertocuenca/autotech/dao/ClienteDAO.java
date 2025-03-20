/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package davidpuertocuenca.autotech.dao;

import davidpuertocuenca.autotech.clases.Cliente;
import jakarta.persistence.NoResultException;
import org.hibernate.query.Query;
import org.hibernate.Session;


/**
 *
 * @author David
 */
public class ClienteDAO {
    public static void crearClienteSql(Cliente cliente) {
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            session.getTransaction().begin();
            session.persist(cliente);
            session.getTransaction().commit();
        }
    }
    
    public static Cliente loginClienteSql(String usuario,String contrasena){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Cliente> q = session.createNamedQuery("get_cliente", Cliente.class);
            q.setParameter("username", usuario);
            q.setParameter("password", contrasena);
            return (Cliente) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
