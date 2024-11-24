import org.junit.Test

import org.junit.Assert.*
 class MainKtTest {

  @Test
  fun transferMoneyMir() {
   val userMoney = 16_000
   val card = "Мир"
   val amountOfPreviousTransfers = 50_000
   val result = transferMoney(card, amountOfPreviousTransfers, userMoney)
   assertEquals(100,result)
  }

  @Test
  fun transferMoneyVKPayZero() {
   val userMoney = 4000
   val card = "VK Pay"
   val amountOfPreviousTransfers = 0
   val result = transferMoney(card, amountOfPreviousTransfers, userMoney)
   assertEquals(0,result)
  }

  @Test
  fun transferMoneyVKPayMaxLimits() {
   val userMoney = 16_000
   val card = "VK Pay"
   val amountOfPreviousTransfers = 50_000
   val result = transferMoney(card, amountOfPreviousTransfers, userMoney)
   assertEquals(-1,result)
  }

  @Test
  fun transferMoneyVKPay() {
   val userMoney = 16_000
   val card = "VK Pay"
   val amountOfPreviousTransfers = 16_000
   val result = transferMoney(card, amountOfPreviousTransfers, userMoney)
   assertEquals(-1,result)
  }

  @Test
  fun transferMoneyMastercard() {
   val userMoney = 6_000
   val card = "Mastercard"
   val amountOfPreviousTransfers = 16_000
   val result = transferMoney(card, amountOfPreviousTransfers, userMoney)
   assertEquals(0,result)
  }

  @Test
  fun transferMoneyMaestro() {
   val userMoney = 60_000
   val card = "Maestro"
   val amountOfPreviousTransfers = 0
   val result = transferMoney(card, amountOfPreviousTransfers, userMoney)
   assertEquals(0,result)
  }

@Test
 fun transferMoney() {
 val userMoney = 60_000
 val card = "Visa"
 val amountOfPreviousTransfers = 16_000
 val result = transferMoney(card, amountOfPreviousTransfers, userMoney)
 assertEquals(450,result)
 }

@Test
 fun toMastercard() {
 val transferAmount = 10000
 val amountOfPreviousTransfers = 16_000
 val result = toMastercard(transferAmount, amountOfPreviousTransfers)
 assertEquals(0, result)
}
  @Test
  fun toMastercardMinLimits() {
   val transferAmount = 299
   val amountOfPreviousTransfers = 0
   val result = toMastercard(transferAmount, amountOfPreviousTransfers)
   assertEquals(21, result)
  }
}