package main;
import java.util.HashMap;

public class Supermercado {
    private boolean abierto = false;
    private String nombre_tienda;
    private Integer cap_max;
    private Integer clientes_dentro = 0;
    private HashMap<String, Integer> stock = new HashMap<String, Integer>();

    public Supermercado(String nom_tienda, Integer cap_max) {
        this.nombre_tienda = nom_tienda;
        this.cap_max = cap_max;
    }

    public boolean getTiendaAbierta() {
        return this.abierto;
    }

    public void CerrarTienda() {
        if (this.abierto==true) {
            this.abierto = false;
            System.out.println("Cerrando tienda...");
        } else {
            System.out.println("Tienda ya esta cerrada");
        }
    }

    public String getNombreTienda() {
        return this.nombre_tienda;
    }

    public Integer getClientesDentro() {
        return this.clientes_dentro;
    }

    public void EntradaCliente() {
        if (this.clientes_dentro!=cap_max) {
            this.clientes_dentro++;
            System.out.println("Cliente a entrado...");
        } else {
            System.out.println("No puedes entrar numero máximo de clientes...");
        }
    }

    public void SalidaCliente() {
        if (this.clientes_dentro!=0) {
            this.clientes_dentro--;
            System.out.println("Cliente a salido...");
        } else {
            System.out.println("No pueden salir mas clientes porque hay 0...");
        }
        
    }

    public HashMap<String, Integer> getStock() {
        return this.stock;
    }

    public void addAlimento(Alimento obj_alim) {
        if (!this.stock.containsValue(obj_alim.getClass().getSimpleName())) {
            stock.put(obj_alim.getClass().getSimpleName(), 0);
            System.out.println("Añado producto a 0");
        } else {
            stock.put(obj_alim.getClass().getSimpleName(), stock.get(obj_alim.getClass().getSimpleName())+1);
            System.out.println("Añado producto +1 a"+obj_alim.getClass().getSimpleName());
        }
    }

    public void removeAlimento(Alimento obj_alim) {
        String tipo_alimento = obj_alim.getClass().getSimpleName();
    
        if (this.stock.containsKey(tipo_alimento)) {
            Integer contad_actual = this.stock.get(tipo_alimento);
            
            if (contad_actual > 0) {
                this.stock.put(tipo_alimento, contad_actual - 1);
                System.out.println("Elimino 1 " + tipo_alimento);
            } else {
                System.out.println(tipo_alimento + " Contador ya esta a cero");
            }
        } else {
            System.out.println(tipo_alimento + " Tipo de alimento no esta presente ¡añádelo!");
        }
    }
    
}
