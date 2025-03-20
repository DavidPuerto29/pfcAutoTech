/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package davidpuertocuenca.autotech.clases;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author David
 */

@Getter @Setter  @NoArgsConstructor
public class Vehiculos {
    /*
    @Id
    private String matricula;
    private String modelo;
    private int anoMatriculacion;
    @ManyToOne
    @JoinColumn(name = "cliente_usuario", referencedColumnName = "usuario")
    private Cliente cliente;
    @OneToMany(mappedBy = "vehiculos", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private ArrayList citas;

    public Vehiculos(String matricula, String modelo, int anoMatriculacion, Cliente cliente, ArrayList citas) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.anoMatriculacion = anoMatriculacion;
        this.cliente = cliente;
        this.citas = citas;
    }
*/
}
