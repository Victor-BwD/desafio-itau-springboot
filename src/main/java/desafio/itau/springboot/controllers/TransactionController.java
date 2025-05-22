package desafio.itau.springboot.controllers;

import desafio.itau.springboot.dto.TransactionRequest;
import desafio.itau.springboot.model.Transaction;
import desafio.itau.springboot.services.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/transacao")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping()
    public ResponseEntity<Void> create(@Valid @RequestBody TransactionRequest request) {
        var isInFuture = request.getDataHora().isAfter(OffsetDateTime.now());

        if(isInFuture || request.getValor() == null) {
            return ResponseEntity.unprocessableEntity().build();
        }

        transactionService.addTransaction(new Transaction(request.getValor(), request.getDataHora()));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @DeleteMapping()
    public ResponseEntity<Void> clear() {
        transactionService.clear();

        return ResponseEntity.ok().build();
    }
}
