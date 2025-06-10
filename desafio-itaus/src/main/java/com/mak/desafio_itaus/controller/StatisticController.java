package com.mak.desafio_itaus.controller;

import com.mak.desafio_itaus.business.StatisticService;
import com.mak.desafio_itaus.controller.dtos.StatisticRequestDto;
import com.mak.desafio_itaus.controller.dtos.TransactionResquestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/estatistica")
@RequiredArgsConstructor
public class StatisticController {
    private final StatisticService statisticService;

    @GetMapping
    public ResponseEntity<StatisticRequestDto> calculeteTransactionStatistic(@RequestParam
                                                                             (value = "Intervalo de busca",
                                                                             required = false,
                                                                             defaultValue = "60")
                                                                             Integer timeInterval){
        return  ResponseEntity.ok(statisticService.calculateTransactionStatistic(timeInterval));
    }
}
