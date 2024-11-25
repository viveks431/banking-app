package net.javaguides.banking.controller;

import com.zaxxer.hikari.util.FastList;
import net.javaguides.banking.dto.AccountDto;
import net.javaguides.banking.dto.TransactionDto;
import net.javaguides.banking.dto.TransferFundDto;
import net.javaguides.banking.entity.Account;
import net.javaguides.banking.repository.AccountRepository;
import net.javaguides.banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountRepository accountRepository;
    private AccountService accountService;

    public AccountController(AccountService accountService, AccountRepository accountRepository) {
        this.accountService = accountService;
        this.accountRepository = accountRepository;
    }

    // Rest API- addAccount
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    // Rest API- getAccount
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto = accountService.getAccountById(id);
        return new ResponseEntity<>(accountDto, HttpStatus.OK);
    }

    //Rest API- deposit amount
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id,
                                              @RequestBody Map<String, Double> request){
        Double amount = request.get("amount");
        AccountDto accountDto = accountService.deposit(id, amount);
        return ResponseEntity.ok(accountDto);
    }

    //Rest API- withdraw amount
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,
                                               @RequestBody Map<String, Double> request){
        Double amount = request.get("amount");
        AccountDto accountDto = accountService.withdraw(id, amount);
        return ResponseEntity.ok(accountDto);
    }

    //Rest API- get all accounts
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto>accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    //Rest API- delete account
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccountById(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted");
    }

    //Rest API- transfer
    @PostMapping("/transfer")
    public ResponseEntity<String> transferFund(@RequestBody TransferFundDto transferFundDto){
        accountService.transferFund(transferFundDto);
        return ResponseEntity.ok("Transfer Succesfull");
    }

    //Rest API- transactions
    @GetMapping("/{id}/transactions")
    public ResponseEntity<List<TransactionDto>> fetchAccountTransactions(@PathVariable("id") Long accountId){
        List<TransactionDto> transactions = accountService.getAccountTransactions(accountId);
        return ResponseEntity.ok(transactions);
    }
}
