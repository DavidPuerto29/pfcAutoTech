/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package davidpuertocuenca.autotech.clases;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author David
 */ 
@Getter @Setter  @NoArgsConstructor
public class Citas {
    /*
    @Id
    private long numeroCita;
    private Date fecha;
    @OneToOne
    private Vehiculos vehiculo;
    @OneToOne
    private Talleres taller;

    public Citas(Date fecha, Vehiculos vehiculo, Talleres taller) {
        this.fecha = fecha;
        this.vehiculo = vehiculo;
        this.taller = taller;
    }
*/
}
