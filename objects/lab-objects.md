# Lab for Objects and Classes

1. Go to this URL to accept the lab and create your repository: [https://classroom.github.com/a/ubpc4JQ8](https://classroom.github.com/a/ubpc4JQ8)
2. Clone the repository to your workspace. The command is similar to this:
```shell
cmd> git clone https://github.com/OOP2018/objectslab-yourname.git objectslab
```
3. Do the problems. Test and review your code. "Review" means carefully read it from start to end.
4. Commit to local repository and push to Github:
```shell
cmd> git status
cmd> git add src/banking/BankTest.java
cmd> git add src/banking/BankAccountTest.java
cmd> etc.
cmd> git commit -m "Finished the lab"
cmd> git push
```

### Problems

There are 4 problems.  The classes and packages are:

| Problem   | Package       | Files to complete            |
|-----------|---------------|:-----------------------------|
| 1. Person | `person`      | `Person.java` `Main.java`  |
|           | (none)        | `README.md` - answer the question |
| 2. BankAccount | `banking` | `BankAccount.java` and `BankAccountTest.java` |
| 3. Bank    | `banking`     | `Bank.java` and `BankTest.java` |
| 4. BankApp | `banking`     | `BankApp.java` |


## Problem 1. Write a Person class and create Person objects

1.1 Write a **Person** class in the **person** package, with these attributes and methods:

<table border="1">
<tr valign="top">
<td markdown="span">String name</td><td>person's name, private</td>
</tr>
<tr valign="top">
<td markdown="span">String email</td><td>person's email, private</td>
</tr>
<tr valign="top">
<td markdown="span">Person(String name)</td><td>constructor that initializes a person's name. email is empty string (not null)</td>
</tr>
<tr valign="top">
<td markdown="span">String getName()<br/>void setName(String newname)</td>
<td>Getter and Setter for Person's name</td>
</tr>
<tr valign="top">
<td markdown="span">String getEmail()<br/>void setEmail(String email)</td>
<td>Getter and Setter for Person's email</td>
</tr>
<tr valign="top">
<td markdown="span">String toString()</td>
<td>Return string description such as: "Bill Gates &lt;bill@msft.com&gt;". </td>
</tr>
</table>
<p></p>

```java
package person;
/**
 * Write a description of Person.
 * @author your name
 */
public class Person {
    //TODO declare the attributes

    /** initialize a new person with a name */
    public Person(String name) {
        //TODO write the constructor
    }
```
    
1.2 Write a **Main** class in the **person** package to test the Person class.
In the **main** method, ask for the name and email of 2-3 friends.  Save them in an ArrayList (ok to use array if stuck on ArrayList), and then print each person using `System.out.println`.
Note the `println(person)` will invoke `person.toString()`.

Example of running Main:
```shell
Input friend name (blank line to end): Bill Gates
Email: bill@msft.com
Input friend name (blank line to end): Donald Trump
Email: [ENTER]
Input friend name (blank line to end): Harry Hacker
Email: hacker@blackhat.org
Input friend name (blank line to end): [ENTER]  <-- blank input to exit loop

Your friends are:
Bill Gates <bill@msft.com>
Donald Trump
Harry Hacker <hacker@blackhat.org>
```

**Hint:** Use scanner.nextLine() to read entire line and string.trim() to remove leading/trailing spaces.

1.3 Modify **Person** to make the **name** attribute be **static**, like this:
```java
public class Person {
    private static String name;
```
Run **Main** again. Explain *why* the output is different.
Write your answer is **README.md** and submit README.md with your code.

Eclipse and Netbeans give a warning about accessing static attributes through instance references -- its legal but usually not what you want.

1.4 Fix the code. Make **name** be an instance attribute again.

## Problem 2. **BankAccount** and **BankAccountTest**

Use the package **banking** for Problems 2-4.

2.1 Create a **BankAccount** class in **banking** package with these attributes, constructor, and methods.  The attributes should be private.

<table border="1">
<tr>
<th width="30%">Member</th> <th>Description</th>
</tr>
<tr valign="top">
<td markdown="span">Long accountNumber</td><td>the bank account number</td>
</tr>
<tr valign="top">
<td markdown="span">String accountName</td><td>the account name. Usually a person's name.</td>
</tr>
<tr valign="top">
<td markdown="span">double balance</td><td>account balance, initially 0.0.</td>
</tr>
<tr valign="top">
<td markdown="span">BankAccount(String name)</td>
<td markdown="span">constructor with a bank account name. The balance is 0. Get an accountNumber from the **Bank** (use starter code) like this: <br/>
```
accountNumber = Bank.getNextAccountNumber();
```
</td>
</tr>
<tr valign="top">
<td markdown="span">BankAccount(String name, long accountNum)</td>
<td markdown="span">constructor for BankAccount with a specified account name and account number (don't get accountNumber from Bank).
</td>
</tr>
<tr valign="top">
<td markdown="span">String getName()<br/>void setName(String newname)</td>
<td>Getter and Setter for the account name</td>
</tr>
<tr valign="top">
<td markdown="span">double getAccountNumber()</td>
<td>Get the account number. <b>No</b> setAccountNumber method. (You can't change a bank account number.)</td>
</tr>
<tr valign="top">
<td markdown="span">double getBalance()</td>
<td>Return the balance. <b>No</b> setBalance method.</td>
</tr>
<tr valign="top">
<td markdown="span">void deposit(double amount)</td>
<td>Deposit money to account. amount must be positive.</td>
</tr>
<tr valign="top">
<td markdown="span">boolean withdraw(double amount)</td>
<td markdown="span">Withdraw money from account. amount must be postive and not exceed the balance. Return **true** if withdraw succeeds, **false** if not allowed (amount not valid).
</td>
</tr>
<tr valign="top">
<td markdown="span">String toString()</td>
<td>Return description of account in the format:<br/> "[1234567890] Bill Gates, balance: 2,000,000,000.00 Bt" 
</td>
</tr>
</table>
<p></p>

2.2 **BankAccountTest** class:  Design and code this class yourself.  

You should test **all** the BankAccount methods and show results.  It can be interactive (prompt for input) or just run fixed code.  Example:
```shell
Enter Account name:  Taksin
Enter Account number: 1234567890
  Created new account. 
  toString(): [1234567890] Taksin, balance: 0.00 Bt
  getBalance(): 0.00
Deposit (+) or withdraw (-): +1000000000
  Deposit 1,000,000,000.00 Bt
  toString(): [1234567890] Taksin, balance: 1,000,000,000.00 Bt
  getBalance(): 1,000,000,000.00
Deposit (+) or withdraw (-): +5.99
  Deposit 5.99 Bt
  toString(): [1234567890] Taksin, balance: 1,000,000,005.99 Bt
  getBalance(): 1,000,000,005.99
Deposit (+) or withdraw (-): -999000000
  withdraw 999,999,999.00 Bt succeeded
  toString(): [1234567890] Taksin, balance: 1,000,005.99 Bt
  getBalance(): 1,000,005.99
Deposit (+) or withdraw (-): -2000000
  withdraw 2,000,000.00 Bt failed
  toString(): [1234567890] Taksin, balance: 1,000,005.99 Bt
  getBalance(): 1,000,005.99
Deposit (+) or withdraw (-): -1000005.99    (try to withdraw everything)
  withdraw 1,000.005.99 Bt succeeded
  toString(): [1234567890] Taksin, balance: 0.00 Bt
  getBalance(): 0.00
```


## Problem 3. **Bank** and **BankTest**

The Bank is responsible for knowing about all bank accounts, adding accounts, finding accounts, and assigning account numbers. Starter code is provided.

There should only be one Bank class.  For now, you will let the Bank behavior be **static**.

<table border="1">
<tr>
<th width="30%">Member</th> <th>Description</th>
</tr>
<tr valign="top">
<td markdown="span">static long nextAccountNumber</td>
<td>the next available account number.</td>
</tr>
<tr valign="top">
<td markdown="span">static List&lt;BankAccount&gt; accounts</td>
<td>all the bank accounts</td>
</tr>
<tr valign="top">
<td markdown="span">private Bank()</td>
<td>private constructor to guarantee that no other code creates Bank objects. (Try it! In another class try to write `new Bank()`.)</td>
</tr>
<tr valign="top">
<td markdown="span">static long getNextAccountNumber()</td>
<td>return the next available account number, and then increment it by 1.</td>
</tr>
<tr valign="top">
<td markdown="span">static void addAccount(BankAccount acct)</td>
<td>Add a new bank account to List of accounts.  If another account with same account number is already in List, then don't add it! (Account numbers should be unique.)</td>
</tr>
<tr valign="top">
<td markdown="span">static BankAccount getAccount(long accountNum)</td>
<td>Find account with requested account number and return it. null if no match.</td>
</tr>
<tr valign="top">
<td markdown="span">static List&lt;BankAccount&gt; getAccounts()</td>
<td>Return List of all the bank accounts.</td>
</tr>
</table>
<p></p>

Note: There is a better design that avoids using static, called the *Singleton Pattern*. You'll learn that later.

3.2 **BankTest**: Write a BankTest class with a `main` method to test the Bank. Starter code is provided, but you must write more tests.  Test every Bank method:
  * Bank.getNextAccountNumber() always increases by 1
  * Bank.addAccount( bankAccount ) really adds accounts
  * Bank.addAccount( bankAccount ) won't let you add 2 accounts (or same account twice) with same account number
  * Bank.getAccount(number) returns the correct account, or null if no such account number
  * Bank.getAccounts() returns all accounts


## Problem 4. **BankApp**  

An "application class" that simulates a banking operation. It interacts with the user and uses BankAccount and Bank.  Starter code is provided, but you need to complete several methods.

Please see the **TODO** comments in code.

This class won't compile until you complete **BankAccount** and **Bank**.

Sample run:
```shell
Input one of the following:
n              - (new) create a new bank account
d              - deposit to an account
w              - withdraw from an account
l              - list all accounts with balances
p acctNumber   - print info for one account (e.g. p 123456)
q              - quit
?              - print this menu again

Input: n
Create a new account
Enter account name: Bill Gates
Created new account no. 100, name "Bill Gates".
Input: d
Please enter account number: 100
Account [100] Bill Gates
Amount to deposit: 500000
Deposited 500,000 Bt. Balance is 500,000 Bt.
Input: w
Please enter account number: 100
Account [100] Bill Gates
Amount to withdraw: 200000
Withdrew 200,000 Bt. Balance is 300,000 Bt.
Input: n
Create a new account
Enter account name: George Bush
Created new account no. 101, name "George Bush".
Input: d
Please enter account number: 101
Account [101] George Bush
Amount to deposit: 1000000
Deposited 1,000,000 Bt. Balance is 1,000,000 Bt.
Input: l
Acct No.   Name           Balance
  100      Bill Gates      300,000.00
  101      George Bush   1,000,000.00
Input: 
```
