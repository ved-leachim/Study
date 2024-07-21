using NUnit.Framework;

namespace Sparky;

[TestFixture]
public class GradingCalculatorNUnitTests
{
  private GradingCalculator _calc;
  [SetUp]
  public void Setup()
  {
    _calc = new GradingCalculator();
  }

  [Test]
  public void GetGrade_Score95Attendance90_ReturnsGradeA()
  {
    //arrange
    _calc.Score = 95;
    _calc.AttendancePercentage = 90;

    //act
    var grade = _calc.GetGrade();

    //assert
    Assert.That(grade, Is.EqualTo("A"));
  }

  [Test]
  public void GetGrade_Score85Attendance90_ReturnsGradeB()
  {
    //arrange
    _calc.Score = 85;
    _calc.AttendancePercentage = 90;

    //act
    var grade = _calc.GetGrade();

    //assert
    Assert.That(grade, Is.EqualTo("B"));
  }


  [Test]
  public void GetGrade_Score65Attendance90_ReturnsGradeC()
  {
    //arrange
    _calc.Score = 65;
    _calc.AttendancePercentage = 90;

    //act
    var grade = _calc.GetGrade();

    //assert
    Assert.That(grade, Is.EqualTo("C"));
  }

  [Test]
  public void GetGrade_Score95Attendance65_ReturnsGradeB()
  {
    //arrange
    _calc.Score = 95;
    _calc.AttendancePercentage = 65;

    //act
    var grade = _calc.GetGrade();

    //assert
    Assert.That(grade, Is.EqualTo("B"));
  }

  [Test]
  [TestCase(95, 55)]
  [TestCase(65, 55)]
  [TestCase(50, 90)]
  public void GetGrade_ScoreAttendance_ReturnsGradeF(int score, int attendance)
  {
    //arrange
    _calc.Score = score;
    _calc.AttendancePercentage = attendance;

    //act
    var grade = _calc.GetGrade();

    //assert
    Assert.That(grade, Is.EqualTo("F"));
  }

  [Test]
  [TestCase(95, 90, ExpectedResult = "A")]
  [TestCase(85, 90, ExpectedResult = "B")]
  [TestCase(65, 90, ExpectedResult = "C")]
  [TestCase(95, 65, ExpectedResult = "B")]
  [TestCase(95, 55, ExpectedResult = "F")]
  [TestCase(65, 55, ExpectedResult = "F")]
  [TestCase(50, 90, ExpectedResult = "F")]
  public string GetGrades_MultipleInputs_ReturnGrades(int score, int attendance)
  {
    //arrange
    _calc.Score = score;
    _calc.AttendancePercentage = attendance;

    //act
    var grade = _calc.GetGrade();

    //assert
    return grade;
  }
}
