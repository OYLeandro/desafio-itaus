package com.mak.desafio_itaus.controller.dtos;

import java.time.OffsetDateTime;

public record TransactionResquestDto(Integer valor, OffsetDateTime dataHora) {
}
