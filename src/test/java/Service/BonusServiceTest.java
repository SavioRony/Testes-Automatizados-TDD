package Service;

import model.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        BonusService service = new BonusService();
        assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(new Funcionario(
                        "Savio", LocalDate.now(), new BigDecimal("15000"))));
    }

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAltoTry() {
        BonusService service = new BonusService();
        try {
            service.calcularBonus(new Funcionario(
                    "Savio", LocalDate.now(), new BigDecimal("15000")));
            fail("Nao deu a IllegalArgunmentExceptio.");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Funcionario com salario maior que R$10000.");
        }
    }

    @Test
    void bonusDeveriaSerDezPorcentoDoSalario() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario(
                "Savio", LocalDate.now(), new BigDecimal("1500")));

        assertEquals(new BigDecimal("150.0"), bonus);
    }
}