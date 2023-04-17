package Service;

import model.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario(
                "Savio", LocalDate.now(), new BigDecimal("15000")));

        assertEquals(BigDecimal.ZERO, bonus);
    }

    @Test
    void bonusDeveriaSerDezPorcentoDoSalario(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario(
                "Savio", LocalDate.now(), new BigDecimal("1500")));

        assertEquals(new BigDecimal("150.0"), bonus);
    }
}