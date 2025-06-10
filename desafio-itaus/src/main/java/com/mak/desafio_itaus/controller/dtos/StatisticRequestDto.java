package com.mak.desafio_itaus.controller.dtos;

public record StatisticRequestDto(Long count,
                                  Double sum,
                                  Double avg,
                                  Double min,
                                  Double max) {
}
