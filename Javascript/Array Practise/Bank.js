class Bank {
    constructor(accountNumber, accountHolderName, balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }
}


bankAccounts = [
    new Bank('123456', 'Raj', 1000),
    new Bank('789012', 'Kumar', 2000),
    new Bank('499012', 'Balaji', 5000)
];

function getBalance(name) {

    const account = bankAccounts.filter(account => account.accountHolderName === name);

    account.forEach(account => {
        console.log(`${account.accountHolderName}: ${account.balance}`);
    });
}

function getTotalBal() {
    totalBalance = bankAccounts.reduce((total, account) => total + account.balance, 0);
    // totBal = 0;
    // bankAccounts.forEach(element => {
    //     totBal += element.balance;
    // });
    console.log(`Total balance : ${totalBalance}`);
    //console.log(totBal);
}

function getTotalWithInterest() {
    tot = 0;
    bankAccounts.map(account => {
        const interestAmount = account.balance + account.balance * (interestRate / 100);
        tot += interestAmount;
    });
    console.log(`Total balance with interest : ${tot}`);
}

//console.log(bankAccounts);

getTotalBal();

interestRate = 10;
getTotalWithInterest(interestRate);

accHolderName = 'Kumar';
getBalance(accHolderName);


