package test;

import main.Supermercado;
import org.junit.Test;
import static org.junit.Assert.*;
// https://stackoverflow.com/questions/62075442/why-does-vscode-not-recognize-the-import-org-junit#comment131641240_67079723
public class test_Supermercado {

    @Test
    public void test_getTiendaAbierta() {
        Supermercado s1 = new Supermercado();
        boolean esta_abierto = s1.getTiendaAbierta();
        assertEquals(false, esta_abierto);
    }

    @Test
    public void test_CerrarTienda() {
        Supermercado s1 = new Supermercado();
        s1.CerrarTienda();
        assertFalse(s1.getTiendaAbierta());
    }

    @Test
    public void test_getNombreTienda() {
        Supermercado s1 = new Supermercado("Mi Supermercado", 100);
        assertEquals("Mi Supermercado", s1.getNombreTienda());
    }

    @Test
    public void test_getClientesDentro() {
        Supermercado s1 = new Supermercado();
        assertEquals(Integer.valueOf(0), s1.getClientesDentro());
    }

    @Test
    public void test_EntradaCliente() {
        Supermercado s1 = new Supermercado("Mi Supermercado", 1);
        s1.EntradaCliente();
        assertEquals(Integer.valueOf(1), s1.getClientesDentro());
    }

    @Test
    public void test_SalidaCliente() {
        Supermercado s1 = new Supermercado("Mi Supermercado", 1);
        s1.EntradaCliente();
        s1.SalidaCliente();
        assertEquals(Integer.valueOf(0), s1.getClientesDentro());
    }

    @Test
    public void test_addAlimento() {
        Supermercado s1 = new Supermercado();
        Alimento alimento = new Alimento(); // Debes proporcionar la definición de Alimento
        s1.addAlimento(alimento);
        assertEquals(Integer.valueOf(1), s1.getStock().get(alimento.getClass().getSimpleName()));
    }

    @Test
    public void test_removeAlimento() {
        Supermercado s1 = new Supermercado();
        Alimento alimento = new Alimento(); // Debes proporcionar la definición de Alimento
        s1.addAlimento(alimento);
        s1.removeAlimento(alimento);
        assertEquals(Integer.valueOf(0), s1.getStock().get(alimento.getClass().getSimpleName()));
    }


}