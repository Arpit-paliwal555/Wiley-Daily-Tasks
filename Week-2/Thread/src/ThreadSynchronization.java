
class BankAccount {
        private double balance;

        public BankAccount(double balance) {
            this.balance = balance;
        }

        public double getBalance() {
            return balance;
        }

        public synchronized void deposit(double amount) {
            System.out.println("Depositing " + amount + "₹");

            double newBalance = balance + amount;
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
            balance = newBalance;
            System.out.println("Balance after depositing : " + balance + "₹");


        }

        public synchronized void withdraw(double amount) {
            System.out.println("Withdrawing " + amount + "₹");

            if(amount>balance){
                System.out.println("Insufficient Balance. Please deposit first");
                try {
                    wait(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if(amount>balance){
                System.out.println("Still Insufficient Balance. Try again later");
                return;
            }
            double newBalance = balance - amount;
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
            System.out.println("Withdrawn "+amount+ "₹");
            balance = newBalance;
            System.out.println("Balance after withdrawing : " + balance + "₹");

        }

    }
//    class DepositThread implements Runnable {
//        private BankAccount account;
//        private double depositAmount;
//
//        public DepositThread(BankAccount account, double depositAmount) {
//            this.account = account;
//            this.depositAmount = depositAmount;
//        }
//
//        public void run() {
//            account.deposit(depositAmount);
//        }
//    }
//
//    class WithdrawThread implements Runnable{
//        private BankAccount account;
//        private double withdrawAmount;
//
//        public WithdrawThread(BankAccount account, double withdrawAmount) {
//            this.account = account;
//            this.withdrawAmount = withdrawAmount;
//        }
//
//        public void run() {
//            account.withdraw(withdrawAmount);
//        }
//    }

    public class ThreadSynchronization {

        public static void main(String[] args) {
            BankAccount account = new BankAccount(0);

//            WithdrawThread withdrawThread = new WithdrawThread(account,5000);
//            DepositThread dpThread = new DepositThread(account,5000);
//            DepositThread dpThread2 = new DepositThread(account,2000);


            Thread threadWithdraw = new Thread(()->account.withdraw(5000));
            Thread thread1 = new Thread(()->account.deposit(2000));
            Thread thread2 = new Thread(()->account.deposit(2000));

            threadWithdraw.start();
            thread1.start();
            thread2.start();

            try {
                thread1.join();
                thread2.join();
                threadWithdraw.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Final Account Balance : " + account.getBalance());

        }

    }

