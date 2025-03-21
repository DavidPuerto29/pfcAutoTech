/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package davidpuertocuenca.autotech.clases;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author David
 */ 
@Entity @Getter @Setter  @NoArgsConstructor
public class Citas {
    
    @Id
    private long numeroCita;
    private Date fecha;
    @ManyToOne
    @JoinColumn(name = "vehiculo", referencedColumnName = "matricula")
    private Vehiculos vehiculo;
    @ManyToOne
    @JoinColumn(name = "taller", referencedColumnName = "numeroIdentificacion")
    private Talleres taller;

    public Citas(Date fecha, Vehiculos vehiculo, Talleres taller) {
        this.fecha = fecha;
        this.vehiculo = vehiculo;
       // this.taller = taller;
    }

}
