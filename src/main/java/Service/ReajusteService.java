package Service;

import model.Desempenho;
import model.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {
    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
        BigDecimal reajuste = desempenho.reajuste(funcionario);
        funcionario.reajustarSalario(reajuste);
    }
}
