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
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author David Puerto Cuenca
 */
@NamedQuery(name = "get_todos_talleres", query = "FROM Talleres q ")
@Entity @NoArgsConstructor @Data
public class Talleres {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numeroTaller;
    
    private String nombre;
    private String direccion;
    private String codigoPostal;
    private String teléfono;
    private String cif;
    private String localidad;

    public Talleres(String nombre, String direccion, String codigoPostal, String teléfono, String cif, String localidad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.teléfono = teléfono;
        this.cif = cif;
        this.localidad = localidad;
    }
    
}
