package model;

import java.math.BigDecimal;

public enum Desempenho {
    A_DESEJAR{
        @Override
        public BigDecimal reajuste(Funcionario funcionario) {
            return funcionario.getSalario().multiply(new BigDecimal("0.03"));
        }
    },
    BOM{
        @Override
        public BigDecimal reajuste(Funcionario funcionario) {
            return funcionario.getSalario().multiply(new BigDecimal("0.15"));
        }
    },
    OTIMO{
        @Override
        public BigDecimal reajuste(Funcionario funcionario) {
            return funcionario.getSalario().multiply(new BigDecimal("0.2"));
        }
    };

    public abstract BigDecimal reajuste(Funcionario funcionario);
}
