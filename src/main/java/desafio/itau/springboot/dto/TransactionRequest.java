package desafio.itau.springboot.dto;

import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public class TransactionRequest {
    @NotNull
    private Double valor;

    @NotNull
    private OffsetDateTime dataHora;

    public @NotNull Double getValor() {
        return valor;
    }

    public @NotNull OffsetDateTime getDataHora() {
        return dataHora;
    }
}
