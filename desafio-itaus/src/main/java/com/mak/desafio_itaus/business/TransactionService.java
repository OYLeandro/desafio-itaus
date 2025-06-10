package com.mak.desafio_itaus.business;

import com.mak.desafio_itaus.controller.dtos.TransactionResquestDto;
import com.mak.desafio_itaus.infrastructure.exceptions.UnprocessableEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionService {

        private final List<TransactionResquestDto> listTransactions = new ArrayList<>();

        public void addTransaction(TransactionResquestDto dto){
            log.info("Iniciando processamento de adicionar dados...");

            if(dto.dataHora().isAfter(OffsetDateTime.now())){
                log.info("Erro!! data e hora maiores que a data atual!");
                throw new UnprocessableEntity("");
            }

            if(dto.valor() < 0){
                log.info("Err!! valor da transação não pode ser negativo!");
                throw new UnprocessableEntity("");
            }

            listTransactions.add(dto);
            log.info("Dados da Transação adicionado com sucesso!");
        }

        public void deleteTransactions(){
            log.info("Apagando dados de transação...");
            listTransactions.clear();
            log.info("Dados da transações apagado!");
        }

        public List<TransactionResquestDto> finByTransaction(Integer timeInterval){
            log.info("Buscando Transações...");
            OffsetDateTime dateTimeInterval =  OffsetDateTime.now().minusSeconds(timeInterval);
            log.info("Busca concluida com sucesso!");
            return listTransactions.stream()
                    .filter(transaction -> transaction.dataHora().isAfter(dateTimeInterval))
                    .toList();
        }
}
