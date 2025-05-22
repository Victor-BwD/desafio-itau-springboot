package desafio.itau.springboot.controllers;

import desafio.itau.springboot.dto.StatisticsResponse;
import desafio.itau.springboot.services.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/estatistica")
@RestController
public class StatisticsController {
    private final TransactionService transactionService;

    public StatisticsController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<StatisticsResponse> getStatistics() {
        var statistics = transactionService.getStatistics();

        return ResponseEntity.ok(new StatisticsResponse(statistics));
    }
}
