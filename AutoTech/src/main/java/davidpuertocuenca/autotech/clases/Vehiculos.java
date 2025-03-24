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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author David Puerto Cuenca
 */
@NamedQuery(name = "get_todos_vehiculos_usuario", query = "FROM Vehiculos q Where q.cliente = :client ORDER BY q.matricula ASC ")
@NamedQuery(name = "get_todos_vehiculos", query = "FROM Vehiculos q ORDER BY q.matricula ASC ")
@NamedQuery(name = "get_vehiculo", query = "FROM Vehiculos q Where q.matricula = :identificacion ")
@Entity @Getter @Setter  @NoArgsConstructor
public class Vehiculos {
    
    @Id
    private String matricula;
    private String modelo;
    private String anoMatriculacion;
    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "usuario")
    private Cliente cliente;
    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Citas> citas;

    public Vehiculos(String matricula, String modelo, String anoMatriculacion, Cliente cliente, ArrayList citas) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.anoMatriculacion = anoMatriculacion;
        this.cliente = cliente;
        this.citas = citas;
    }

}
