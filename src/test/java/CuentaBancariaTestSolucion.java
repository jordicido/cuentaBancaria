import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CuentaBancariaTest {

    @Test
    void testCrearCuentaConSaldoValido() {
        CuentaBancaria cuenta = new CuentaBancaria("Joan", 100.0);
        assertEquals("Joan", cuenta.getTitular());
        assertEquals(100.0, cuenta.getSaldo());
    }

    @Test
    void testCrearCuentaConSaldoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new CuentaBancaria("Anna", -50.0));
    }

    @Test
    void testDepositarCantidadValida() {
        CuentaBancaria cuenta = new CuentaBancaria("Marc", 200.0);
        cuenta.depositar(100.0);
        assertEquals(300.0, cuenta.getSaldo());
    }

    @Test
    void testDepositarCantidadInvalida() {
        CuentaBancaria cuenta = new CuentaBancaria("Marc", 200.0);
        assertThrows(IllegalArgumentException.class, () -> cuenta.depositar(0));
        assertThrows(IllegalArgumentException.class, () -> cuenta.depositar(-20));
    }

    @Test
    void testRetirarCantidadValida() {
        CuentaBancaria cuenta = new CuentaBancaria("Laura", 150.0);
        cuenta.retirar(50.0);
        assertEquals(100.0, cuenta.getSaldo());
    }

    @Test
    void testRetirarCantidadInvalida() {
        CuentaBancaria cuenta = new CuentaBancaria("Laura", 150.0);
        assertThrows(IllegalArgumentException.class, () -> cuenta.retirar(0));
        assertThrows(IllegalArgumentException.class, () -> cuenta.retirar(-10));
    }

    @Test
    void testRetirarMasDelSaldo() {
        CuentaBancaria cuenta = new CuentaBancaria("Laura", 150.0);
        assertThrows(IllegalArgumentException.class, () -> cuenta.retirar(200.0));
    }
}
