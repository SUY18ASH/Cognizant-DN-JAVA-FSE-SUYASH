package com.cognizant.account;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/accounts/{number}")
    public Account getAccount(@PathVariable String number) {

        return new Account(number, "savings", 234343);
    }

    public static class Account {
        private String number;
        private String type;
        private int balance;


        public Account() {
        }


        public Account(String number, String type, int balance) {
            this.number = number;
            this.type = type;
            this.balance = balance;
        }


        public String getNumber() {
            return number;
        }

        public String getType() {
            return type;
        }

        public int getBalance() {
            return balance;
        }


        public void setNumber(String number) {
            this.number = number;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }
    }
}
