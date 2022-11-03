package br.service.reajuste;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

public class ValidacaoPeriodicidadeEntreReajustes implements ValidacaoReajuste {
    
    public void validar(Funcionario funcionario, BigDecimal aumento) {
        
        LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
        LocalDate dataAtual = LocalDate.now();
        long mesesEntreReajustes = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);

        if (mesesEntreReajustes < 6) {
            throw new ValidacaoException("Intervalo entre reajustes deve ser no mínimo que 6 meses!");
        }
    }
}
