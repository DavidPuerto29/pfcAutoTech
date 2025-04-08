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
 * @author David
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
}
