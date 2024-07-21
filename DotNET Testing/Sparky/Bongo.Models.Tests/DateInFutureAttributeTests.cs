using Bongo.Models.ModelValidations;
using NUnit.Framework;

namespace Bongo.Models;

[TestFixture]
public class DateInFutureAttributeTests
{
  [TestCase(100, ExpectedResult = true)]
  [TestCase(-100, ExpectedResult = false)]
  [TestCase(0, ExpectedResult = false)]
  public bool DateValidator_InputExpectedDateRange_DateValidity(int addTime)
  {
    //arrange
    DateInFutureAttribute dateInFutureAttribute = new(() => DateTime.Now);

    //act
    return dateInFutureAttribute.IsValid(DateTime.Now.AddSeconds(addTime));
  }

  [Test]
  public void DateValidator_AnyDate_ReturnErrorMessage()
  {
    var result = new DateInFutureAttribute();
    Assert.That("Date must be in the future", Is.EqualTo(result.ErrorMessage));
  }
}
