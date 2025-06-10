package com.mak.desafio_itaus.business;

import com.mak.desafio_itaus.controller.dtos.TransactionResquestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticService {
    private final TransactionService transactionService;
}
