namespace Sparky;

public class GradingCalculator
{
  public int Score { get; set; }
  public int AttendancePercentage { get; set; }

  public string GetGrade()
  {
    if (Score > 90 && AttendancePercentage > 70)
      return "A";
    if (Score > 80 && AttendancePercentage > 60)
      return "B";
    if (Score > 60 & AttendancePercentage > 60)
      return "C";

    return "F";
  }
}
