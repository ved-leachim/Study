using Moq;
using NUnit.Framework;
using Range = Moq.Range;

namespace Sparky;

[TestFixture]
public class BankAccountNUnitTests
{
  private BankAccount account;

  [SetUp]
  public void Setup()
  {

  }

  // [Test]
  // public void BankDeposit_Add100_ReturnTrue()
  // {
  //   var logMock = new Mock<ILogBook>();
  //
  //   BankAccount bankAccount = new(logMock.Object);
  //   var result = bankAccount.Deposit(100);
  //
  //   Assert.That(result, Is.True);
  //   Assert.That(bankAccount.GetBalance(), Is.EqualTo(100));
  // }

  [Test]
  [TestCase(200,100)]
  [TestCase(200, 150)]
  public void BankWithdraw_Withdraw100With200Balance_ReturnsTrue(int balance, int withdraw)
  {
    //arrange
    var logMock = new Mock<ILogBook>();
    // Provide any value for mocked method parameter
    logMock.Setup(u => u.LogToDb(It.IsAny<string>())).Returns(true);
    logMock.Setup(u => u.LogBalanceAfterWithdrawal(It.Is<int>(x=>x>=0))).Returns(true);

    BankAccount bankAccount = new(logMock.Object);
    bankAccount.Deposit(balance);

    //act
    var result = bankAccount.Withdraw(withdraw);

    //assert
    Assert.That(result, Is.True);
  }

  [Test]
  [TestCase(200,300)]
  public void BankWithdraw_Withdraw300With200Balance_ReturnsFalse(int balance, int withdraw)
  {
    //arrange
    var logMock = new Mock<ILogBook>();
    logMock.Setup(u => u.LogBalanceAfterWithdrawal(It.Is<int>(x => x >= 0))).Returns(true);
    logMock.Setup(u => u.LogBalanceAfterWithdrawal(It.Is<int>(x => x < 0))).Returns(false);
    // logMock.Setup(u => u.LogBalanceAfterWithdrawal(It.IsInRange(int.MinValue, -1, Range.Inclusive))).Returns(false);

    BankAccount bankAccount = new(logMock.Object);
    bankAccount.Deposit(balance);

    //act
    var result = bankAccount.Withdraw(withdraw);

    //assert
    Assert.That(result, Is.False);
  }

  [Test]
  public void BankLogDummy_LogMockString_ReturnTrue()
  {
    var logMock = new Mock<ILogBook>();
    string desiredOutput = "hello";

    logMock.Setup(u => u.MessageWithReturnStr(It.IsAny<string>())).Returns((string str) => str.ToLower());

    Assert.That(logMock.Object.MessageWithReturnStr("HELLo"), Is.EqualTo(desiredOutput));
  }

  [Test]
  public void BankLogDummy_LogMockStringOutputStr_ReturnTrue()
  {
    var logMock = new Mock<ILogBook>();
    string desiredOutput = "Hello Rachel";

    logMock.Setup(u => u.LogWithOutputResult(It.IsAny<string>(), out It.Ref<string>.IsAny))
      .Returns((string input, out string output) =>
      {
        output = "Hello " + input;
        return true;
      });

    string result = "";

    Assert.That(logMock.Object.LogWithOutputResult("Rachel", out result));
    Assert.That(result, Is.EqualTo(desiredOutput));
  }

  [Test]
  public void BankLogDummy_LogRefChecker_ReturnTrue()
  {
    var logMock = new Mock<ILogBook>();
    Customer customer = new();
    Customer customerNotUsed = new();

    logMock.Setup(u => u.LogWithRefObj(ref customer)).Returns(true);

    Assert.That(logMock.Object.LogWithRefObj(ref customer));
    // Assert.That(logMock.Object.LogWithRefObj(ref customerNotUsed));
  }

  [Test]
  public void BankLogDummy_SetAndGetLogTypeAndSeverityMock_MockTest()
  {
    var logMock = new Mock<ILogBook>();
    // ! This does not work !
    logMock.Object.LogSeverity = 100;
    // It only works after allowing direct assignment using the SetupAllProperties() Method

    // !! Be Carefull --> If used needs to be in front of all the other prop assignments
    logMock.SetupAllProperties();
    logMock.Object.LogSeverity = 100;

    // !! Be Carefull --> .Setup() overrides all the properties set by Object.prop =
    // logMock.Setup(u => u.LogSeverity).Returns(10);
    logMock.Setup(u => u.LogType).Returns("warning");

    Assert.That(logMock.Object.LogSeverity, Is.EqualTo(100));
    Assert.That(logMock.Object.LogType, Is.EqualTo("warning"));
  }

  [Test]
  public void BankLogDummy_VerifyExample()
  {
    //arrange
    var logMock = new Mock<ILogBook>();

    BankAccount bankAccount = new BankAccount(logMock.Object);
    bankAccount.Deposit(100);

    //verification
    logMock.Verify(u => u.Message(It.IsAny<string>()), Times.Exactly(2));
    logMock.Verify(u => u.Message("Test"), Times.AtLeastOnce);
    logMock.VerifySet(u=>u.LogSeverity = 101, Times.Once);
  }
}
