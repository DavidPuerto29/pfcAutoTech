/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package davidpuertocuenca.autotech.dao;

import davidpuertocuenca.autotech.clases.Citas;
import davidpuertocuenca.autotech.clases.Cliente;
import davidpuertocuenca.autotech.clases.Vehiculos;
import jakarta.persistence.NoResultException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author David
 */
public class CitasDAO {
    public static List<Citas> obtenerTodasCitasSql(Cliente cliente){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Citas> q = session.createNamedQuery("get_todas_citas_usuario", Citas.class);
                q.setParameter("vehiculos", cliente.getVehiculos());
            return q.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
