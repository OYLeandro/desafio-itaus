package com.mak.desafio_itaus.business;

import com.mak.desafio_itaus.controller.dtos.StatisticRequestDto;
import com.mak.desafio_itaus.controller.dtos.TransactionResquestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticService {
    private final TransactionService transactionService;

    public StatisticRequestDto calculateTransactionStatistic(Integer timeInterval){
        List<TransactionResquestDto> transaction = transactionService.finByTransaction(timeInterval);

        DoubleSummaryStatistics transactionStatistic = transaction.stream()
                .mapToDouble(TransactionResquestDto::valor).summaryStatistics();

        return new StatisticRequestDto(transactionStatistic.getCount(),
                transactionStatistic.getSum(),
                transactionStatistic.getAverage(),
                transactionStatistic.getMin(),
                transactionStatistic.getMax());
    }
}
