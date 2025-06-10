package com.mak.desafio_itaus.controller.dtos;

public record StatisticRequestDto(Integer count,
                                  Double sum,
                                  Double avg,
                                  Double min,
                                  Double max) {
}
