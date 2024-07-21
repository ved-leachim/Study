using NUnit.Framework;
using NUnit.Framework.Legacy;

namespace Sparky;

[TestFixture]
public class CustomerNUnitTests
{
  private Customer customer;
  // Initial Setup inside the class
  [SetUp]
  public void Setup()
  {
    customer = new Customer();
  }

  [Test]
  public void CombineName_InputFirstAndLastName_ReturnFullName()
  {
    //Arrange

    //Act
    customer.GreetAndCombineNames("Harvey", "Specter");

    // Assert
    // Assert multiple statements
    Assert.Multiple(() =>
    {
    Assert.That(customer.GreetMessage, Is.EqualTo("Hello, Harvey Specter"));
    Assert.That(customer.GreetMessage, Does.Contain("harvey Specter").IgnoreCase); // Contain is Case-Sensitive by default
    Assert.That(customer.GreetMessage, Does.StartWith("Hello"));
    Assert.That(customer.GreetMessage, Does.EndWith("Specter"));
    Assert.That(customer.GreetMessage, Does.Match("Hello, [A-Z]{1}[a-z]+ [A-Z]{1}[a-z]+"));

    // Legacy
    ClassicAssert.AreEqual(customer.GreetMessage, "Hello, Harvey Specter");
    });

  }

  [Test]
  public void GreetMessage_NotGreeted_ReturnsNull()
  {
    //Arrange

    //Act

    //Assert
    Assert.That(customer.GreetMessage, Is.Null);
  }

  [Test]
  public void DiscountCheck_DefaultCustomer_ReturnsDiscountInRange()
  {
    int result = customer.Discount;

    //Check between a range
    Assert.That(result, Is.InRange(10,25));
  }

  // Null / Not Null Testing
  [Test]
  public void GreetMessage_GreetedWithoutLastName_ReturnsNotNull()
  {
    customer.GreetAndCombineNames("Mike", "");

    Assert.That(customer.GreetMessage, Is.Not.Null);
    Assert.That(customer.GreetMessage, Is.Not.Null.And.Not.Empty);
  }

  // Test for Exception.Message value
  [Test]
  public void GreetChecker_EmptyFirstName_ThrowsExceptionMessage()
  {
    var exceptionDetail = Assert.Throws<ArgumentException>((() => customer.GreetAndCombineNames("", "Litt")));

    Assert.That("Empty First Name", Is.EqualTo(exceptionDetail.Message));
    // () => Actual Value, Expected Exception.Message value
    Assert.That(() => customer.GreetAndCombineNames("", "Litt"), Throws.ArgumentException.With.Message.EqualTo("Empty First Name"));
  }

  // Test for an Exception Type
  [Test]
  public void GreetChecker_EmptyFirstName_ThrowsException()
  {
    Assert.That(() => customer.GreetAndCombineNames("", "Litt"),
      Throws.ArgumentException);
  }

  [Test]
  public void CustomerType_CreateCustomerWithLessThan100Order_ReturnBasicCustomer()
  {
    // arrange
    customer.OrderTotal = 10;

    //act
    var result = customer.GetCustomerDetails();

    //assert
    Assert.That(result, Is.TypeOf<BasicCustomer>());
  }

  [Test]
  public void CustomerType_CreateCustomerWithMoreThan100Order_ReturnPlatinumCustomer()
  {
    // arrange
    customer.OrderTotal = 101;

    //act
    var result = customer.GetCustomerDetails();

    //assert
    Assert.That(result, Is.TypeOf<PlatinumCustomer>());
  }
}
