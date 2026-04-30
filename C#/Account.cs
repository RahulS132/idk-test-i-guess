public class Account
{
    private decimal balance;
    public Account(decimal initialBalance)
    {
        balance = initialBalance;

    }
    public void Credit(decimal amount)
    {
        balance = balance + amount;
    }
    public decimal Balance
    {
        get
        {
            return balance;
        }
        set
        {
            if (value >= 0)
            {
                balance = value;
            }
        }
    }
}