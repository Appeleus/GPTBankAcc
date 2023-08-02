### A small project of mine. I want to recreate a bank system with the requirement as followed.
---
Problem: Create a program that simulates a simple banking system. 
The program should allow users to perform the following actions:

1. Create a new bank account with an initial balance.
2. Deposit money into an existing bank account.
3. Withdraw money from an existing bank account (if sufficient balance is available).
4. Check the balance of an existing bank account.
5. Display the account details of all existing bank accounts.

### Requirements:

- Each bank account should have a unique account number.
- The program should handle invalid inputs gracefully and display appropriate error messages.
- The program should store the bank account information in a data structure (e.g., an array, list, or dictionary).
- The user should be able to perform multiple actions in a 
single session until they choose to exit the program.
---
### Example run

Welcome to the Simple Banking System!

1. Create a new bank account
2. Deposit money
3. Withdraw money
4. Check balance
5. Display all accounts
6. Exit

```
> Enter your choice: 1
> Enter account holder's name: John Doe
> Enter initial balance: 1000
> Account created successfully. Account number: 12345
```
```
> Enter your choice: 2
> Enter account number: 12345
> Enter amount to deposit: 500
> Amount deposited successfully. New balance: 1500
```
```
> Enter your choice: 3
> Enter account number: 12345
> Enter amount to withdraw: 800
> Amount withdrawn successfully. New balance: 700
```
```
> Enter your choice: 4
> Enter account number: 12345
> Account balance: 700
```
```
> Enter your choice: 5
> Account details for all accounts:
```
```
> Account Number: 12345
> Account Holder: John Doe
> Balance: $700
```
```
> Enter your choice: 6
> Thank you for using the Simple Banking System. Goodbye!
```

**Status** : Unfinished

**Why do I do this?**

I have been learning in university for 4 years, time to put those theories to test.

**Why is this project's name starts with GPT? Is there any reason?**


With the theme of "The problem that real people would ask me to program.", I asked the requirements from ChatGPT. So it would feel fresh, like really getting a requirement from customers. And also a reminder of how I got the requirement.