package com.mak.desafio_itaus.controller;

import com.mak.desafio_itaus.business.TransactionService;
import com.mak.desafio_itaus.controller.dtos.TransactionResquestDto;
import com.mak.desafio_itaus.infrastructure.exceptions.UnprocessableEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jdk.jfr.Description;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.Descriptor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transacao")
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
    @Operation(description = "EndPoint responsavel por adicionar transação!")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transação feita com sucesso"),
            @ApiResponse(responseCode = "422", description = "Campos não atendem os requesitos da transação"),
            @ApiResponse(responseCode = "400", description = "Erro de requisição"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<Void> addTransaction(@RequestBody TransactionResquestDto dto){
            transactionService.addTransaction(dto);

            return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    @Operation(description = "EndPoint responsavel por deletar transação!")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transação deletada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de requisição"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<Void> deleteTransactions(){
        transactionService.deleteTransactions();
        return ResponseEntity.ok().build();
    }
}
