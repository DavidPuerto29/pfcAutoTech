/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package davidpuertocuenca.autotech.clases;

import static davidpuertocuenca.autotech.cartografia.CifradoSHA256.verificarContraseña;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author David Puerto Cuenca
 */
@Entity @Getter @Setter  @NoArgsConstructor
@NamedQuery(name = "get_cliente_username", query = "FROM Cliente p WHERE p.usuario = :username")
@NamedQuery(name = "get_cliente", query = "FROM Cliente p WHERE p.usuario = :username AND p.contrasena = :password")
@NamedQuery(name = "get_todos_clientes", query = "FROM Cliente q ORDER BY q.usuario ASC")
public class Cliente {
    @Id
    private String usuario;
    private String contrasena; //PROVISIONAL
    private String randomizador;   //cifrado
    
    private String dni;
    private String nombre;
    private String apellidos;
    private String correoElectronico;
    private int numeroTelefono;
    private String direccion;
    private boolean administrador;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Vehiculos> vehiculos;
    
    public Cliente(String usuario, String contrasena, String randomizador, String dni, String nombre, String apellidos, String correoElectronico, int numeroTelefono, String direccion, boolean administrador) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.randomizador = randomizador;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
        this.numeroTelefono = numeroTelefono;
        this.direccion = direccion;
        this.administrador = administrador;
    }
    
    public static boolean comprobacionAutenticacionUsuario(Cliente cliente, String contrasena){
        if (cliente == null) {
         return false;
        }
        return verificarContraseña(contrasena, cliente.getRandomizador(), cliente.getContrasena());
    }
  
}
