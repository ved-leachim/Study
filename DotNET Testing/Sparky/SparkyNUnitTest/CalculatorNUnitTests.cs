using NUnit.Framework;
using NUnit.Framework.Legacy;

namespace Sparky;

[TestFixture]
public class CalculatorNUnitTests
{
  private Calculator calc;

  [SetUp]
  public void Setup()
  {
    calc = new Calculator();
  }

  [Test]
  public void AddNumbers_InputTwoInt_GetCorrectAddition()
  {
    //Arrange

    //Act
    int result = calc.AddNumbers(10, 20);

    //Assert
    ClassicAssert.AreEqual(30, result);
  }

  [Test]
  public void IsOddNumber_InputEvenNumber_ReturnFalse()
  {
    //Arrange

    //Act
    bool isOddNumber = calc.IsOddNumber(4);

    //Assert
    Assert.That(isOddNumber, Is.EqualTo(false));
  }

  [Test]
  [TestCase(11)]
  [TestCase(13)]
  public void IsOddNumber_InputOddNumber_ReturnTrue(int a)
  {
    //Arrange

    //Act
    bool isOddNumber = calc.IsOddNumber(a);

    //Assert
    ClassicAssert.IsTrue(isOddNumber);
  }

  [Test]
  [TestCase(10, ExpectedResult = false)]
  [TestCase(11, ExpectedResult = true)]
  public bool IsOddChecker_InputNumber_ReturnTrueIfOdd(int a)
  {

    bool result = calc.IsOddNumber(a);

    return calc.IsOddNumber(a);
  }

  [Test]
  [TestCase(5.4, 10.5)] //15.9
  [TestCase(5.6, 10.49)] //16.09
  [TestCase(5.49, 10.59)] //16.08
  public void AddNumbersDouble_InputTwoDouble_GetCorrectAddition(double a, double b)
  {
    //Arrange

    //Act
    double result = calc.AddNumbersDouble(a, b);

    //Assert
    ClassicAssert.AreEqual(15.9, result, .2);
  }

  [Test]
  public void OddRanger_InputMinAndMaxRange_ReturnsValidOddNumberRange()
  {
    //arrange
    List<int> expectedOddRange = new() { 5, 7, 9 }; // 5-10

    //act
    var result = calc.GetOddRange(5, 10);

    //assert
    Assert.That(result, Is.EquivalentTo(expectedOddRange));
    Assert.That(result, Does.Contain(7));
    Assert.That(result, Has.No.Member(6));
    Assert.That(result, Is.Not.Empty);
    Assert.That(result.Count, Is.EqualTo(3));

    Assert.That(result, Is.Ordered); // Is Ascending per default
    Assert.That(result, Is.Unique);
  }
}
