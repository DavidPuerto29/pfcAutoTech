/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package davidpuertocuenca.autotech.clases;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author David Puerto Cuenca
 */

@Entity @Getter @Setter  @NoArgsConstructor
public class Talleres {
    
    @Id
    private long numeroIdentificacion;
    private String nombre;
    private String direccion;
    @ManyToOne
    @JoinColumn(name = "cita", referencedColumnName = "numeroCita")
    private Citas cita;
    
    public Talleres(long numeroIdentificacion, String nombre, String taller) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombre = nombre;
        this.direccion = taller;
    }

}
