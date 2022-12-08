package test.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;

public class AccountTests {
	
	@Test//deve realizar um deposito quando amount for positivo
	public void depositShouldIncreaseBalanceWhenPositiveAmount() {
		
		double amount = 200.0;
		double expectedValue = 196.0;
		
		Account acc = new Account(1L, 0.0);
		acc.deposit(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
	@Test//não faça nada quando amount for negativo 
	public void depositShouldDoNothigWhenNegativeAmount() {
		
		double expectedValue = 100.0;
		Account acc = new Account(1L, expectedValue);
		double amount = -2000.0;
		
		acc.deposit(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
		
	}

}
