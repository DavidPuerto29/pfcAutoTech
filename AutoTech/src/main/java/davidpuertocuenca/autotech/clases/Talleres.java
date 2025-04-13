/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package davidpuertocuenca.autotech.clases;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author David Puerto Cuenca
 */
@NamedQuery(name = "get_todos_talleres", query = "FROM Talleres q ")
@Entity @Getter @Setter  @NoArgsConstructor
public class Talleres {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numeroTaller;
    
    private String nombre;
    private String direccion;
    //private String codigoPostal;
    //private String teléfono;
    
    
    public Talleres(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

}
