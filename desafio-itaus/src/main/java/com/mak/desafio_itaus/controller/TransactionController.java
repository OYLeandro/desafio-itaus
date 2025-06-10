package com.mak.desafio_itaus.controller;

import com.mak.desafio_itaus.business.TransactionService;
import com.mak.desafio_itaus.controller.dtos.TransactionResquestDto;
import com.mak.desafio_itaus.infrastructure.exceptions.UnprocessableEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transacao")
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Void> addTransaction(@RequestBody TransactionResquestDto dto){
            transactionService.addTransaction(dto);

            return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTransactions(){
        transactionService.deleteTransactions();
        return ResponseEntity.ok().build();
    }
}
