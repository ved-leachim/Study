using NUnit.Framework;

namespace Sparky;

[TestFixture]
public class FiboNUnitTests
{
  private Fibo _fibo;

  [SetUp]
  public void Setup()
  {
    _fibo = new Fibo();
  }

  [Test]
  public void CheckFiboNumbers_Range1_Return0()
  {
    //arrange
    _fibo.Range = 1;

    //act
    var fibos = _fibo.GetFiboSeries();
    List<int> expectedNumbers = new List<int> { 0 };

    //assert
    Assert.Multiple(() =>
    {
      Assert.That(fibos, Is.Not.Empty);
      Assert.That(fibos, Is.Ordered);
      Assert.That(fibos, Is.EqualTo(expectedNumbers));
    });
  }

  [Test]
  public void CheckFiboNumbers_Range6_Return011235()
  {
    //arrange
    _fibo.Range = 6;

    //act
    var fibos = _fibo.GetFiboSeries();
    List<int> expectedNumbers = new List<int> { 0, 1, 1, 2, 3, 5 };

    //assert
    Assert.Multiple(() =>
    {
      Assert.That(fibos, Does.Contain(3));
      Assert.That(fibos, Has.No.Member(4));
      Assert.That(fibos, Is.EqualTo(expectedNumbers));
      Assert.That(fibos.Count, Is.EqualTo(6));
    });
  }
}
