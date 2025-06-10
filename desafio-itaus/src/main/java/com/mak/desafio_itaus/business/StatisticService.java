package com.mak.desafio_itaus.business;

import com.mak.desafio_itaus.controller.dtos.StatisticRequestDto;
import com.mak.desafio_itaus.controller.dtos.TransactionResquestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StatisticService {
    private final TransactionService transactionService;

    public StatisticRequestDto calculateTransactionStatistic(Integer timeInterval){
      log.info("Calculando estatistica das transações...");
        List<TransactionResquestDto> transaction = transactionService.finByTransaction(timeInterval);

        DoubleSummaryStatistics transactionStatistic = transaction.stream()
                .mapToDouble(TransactionResquestDto::valor).summaryStatistics();
        log.info("Calculado com sucesso!");
        return new StatisticRequestDto(transactionStatistic.getCount(),
                transactionStatistic.getSum(),
                transactionStatistic.getAverage(),
                transactionStatistic.getMin(),
                transactionStatistic.getMax());
    }
}
