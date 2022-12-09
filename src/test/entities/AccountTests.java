package test.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import test.factory.AccountFactory;

public class AccountTests {
	
	@Test//deve realizar um deposito quando amount for positivo
	public void depositShouldIncreaseBalanceWhenPositiveAmount() {
		
		double amount = 200.0;
		double expectedValue = 196.0;
		
		Account acc = AccountFactory.createEmptyAccount();
		acc.deposit(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
	@Test//não faça nada quando amount for negativo 
	public void depositShouldDoNothigWhenNegativeAmount() {
		
		double expectedValue = 100.0;
		Account acc = AccountFactory.createAccount(expectedValue);
		double amount = -2000.0;
		
		acc.deposit(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
		
	}
	
	@Test//testar o saque do valor total
	public void  fullWitdhrawShouldClearBalanceAndReturnFullBalance() {
		
		double expectedValue = 0;
		double initialBalnce = 800.0;
		Account acc = AccountFactory.createAccount(800.0);
		
		double result = acc.fullWithdraw();
		
		Assertions.assertTrue(expectedValue == acc.getBalance());
		Assertions.assertEquals(expectedValue, acc.getBalance());
		Assertions.assertTrue(result == initialBalnce);//esta testando se o valor total sacado é igual ao valor em conta
	}
	
	@Test//vai testar o fluxo perfeito do withdraw
	public void withDrawShouldDecreaseBalanceWhenShouldWhenSufficientBalance() {
		
		Account acc = AccountFactory.createAccount(800.0);
		
		acc.withdraw(500);
		
		Assertions.assertEquals(300, acc.getBalance()); 
	}

	@Test//vai testar o fluxo que retorna uma exception
	public void withDrawShouldThrowExceptionWhenInsufficientBalance() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Account acc = AccountFactory.createAccount(800.0);

			acc.withdraw(801.0);
		});

	}
}
