namespace Sparky;

public interface ILogBook
{
  public int LogSeverity { get; set; }

  public string LogType { get; set; }

  void Message(string message);

  bool LogToDb(string message);

  bool LogBalanceAfterWithdrawal(int balanceAfterWithdrawal);

  string MessageWithReturnStr(string message);

  bool LogWithOutputResult(string str, out string outputStr);

  bool LogWithRefObj(ref Customer customer);
}

public class LogBook : ILogBook
{
  public int LogSeverity { get; set; }
  public string LogType { get; set; }

  public void Message(string message)
  {
    Console.WriteLine(message);
  }

  public bool LogToDb(string message)
  {
    Console.WriteLine(message);
    return true;
  }

  public bool LogBalanceAfterWithdrawal(int balanceAfterWithdrawal)
  {
    if (balanceAfterWithdrawal >= 0)
    {
      Console.WriteLine("Success");
      return true;
    }
    else
    {
      Console.WriteLine("Failure");
      return false;
    }
  }

  public string MessageWithReturnStr(string message)
  {
    Console.WriteLine(message);
    return message.ToLower();
  }

  public bool LogWithOutputResult(string str, out string outputStr)
  {
    outputStr = "Hello " + str;
    return true;
  }

  public bool LogWithRefObj(ref Customer obj)
  {
    return true;
  }
}
