package com.mak.desafio_itaus.controller;

import com.mak.desafio_itaus.business.StatisticService;
import com.mak.desafio_itaus.controller.dtos.StatisticRequestDto;
import com.mak.desafio_itaus.controller.dtos.TransactionResquestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(description = "EndPoint responsavel por buscar transação!")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca efetuada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na busca da estastitica das transações"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<StatisticRequestDto> calculeteTransactionStatistic(@RequestParam
                                                                             (value = "Intervalo de busca",
                                                                             required = false,
                                                                             defaultValue = "60")
                                                                             Integer timeInterval){
        return  ResponseEntity.ok(statisticService.calculateTransactionStatistic(timeInterval));
    }
}
