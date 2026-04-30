using System;
using System.Diagnostics;
using System.IO.Compression;

    public class AccountTest
    {
        static void Main(string[] args)
        {
            Account account1 = new Account(50M);
            Account account2 = new Account(-22M);
            Console.WriteLine("acc1balance: {0:C}", account1.Balance);
            Console.WriteLine("acc2 balance: {0:C}", account2.Balance);
            decimal depositAmount;
            Console.Write("Enter deposit amoutn for acc1: ");
            depositAmount = Convert.ToDecimal(Console.ReadLine());
            Console.WriteLine("adding {0:C} to acc1 balance\n", depositAmount);
            account1.Credit(depositAmount);

            Console.WriteLine("acc1 balance: {0:C}", account1.Balance);
            Console.WriteLine("acc1 balance: {0:C}", account2.Balance);

            Console.Write(" Enter Deposit amount for acc2: ");
            depositAmount = Convert.ToDecimal(Console.ReadLine());
            Console.WriteLine("addint {0:C} to acc2 balance\n", depositAmount);
            account2.Credit(depositAmount);

            Console.WriteLine("acc1 balance: {0:C}", account1.Balance);
            Console.WriteLine("acc2 balance: {0:C}", account2.Balance);
    
        }
    }
