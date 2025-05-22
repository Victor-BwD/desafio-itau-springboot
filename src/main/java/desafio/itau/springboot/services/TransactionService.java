package desafio.itau.springboot.services;

import desafio.itau.springboot.model.Transaction;
import org.springframework.stereotype.Service;


import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import static java.time.LocalTime.now;


@Service
public class TransactionService {
    List<Transaction> transactionList = Collections.synchronizedList(new ArrayList<>());


    public void addTransaction(Transaction transaction) {
        System.out.println("Transação adicionada: " + transaction);
        transactionList.add(transaction);
    }

    public void clear() {
        transactionList.clear();
    }

    public DoubleSummaryStatistics getStatistics() {
        return transactionList.stream()
                .filter(t -> t.getDataHora().isAfter(OffsetDateTime.now().minusSeconds(60)))
                .mapToDouble(Transaction::getValor).summaryStatistics();
    }
}
