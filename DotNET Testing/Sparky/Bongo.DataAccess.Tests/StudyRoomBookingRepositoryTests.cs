using Bongo.DataAccess.Repository;
using Bongo.Models.Model;
using Microsoft.EntityFrameworkCore;
using NUnit.Framework;

namespace Bongo.DataAccess;

[TestFixture]
public class StudyRoomBookingRepositoryTests
{
  private StudyRoomBooking studyRoomBooking_One;
  private StudyRoomBooking studyRoomBooking_Two;
  private DbContextOptions<ApplicationDbContext> options;

  public StudyRoomBookingRepositoryTests()
  {
    studyRoomBooking_One = new StudyRoomBooking()
    {
      FirstName = "Jessica",
      LastName = "Pearson",
      Date = new DateTime(),
      Email = "jessica.pearson@pearsonhardman.com",
      BookingId = 11,
      StudyRoomId = 1
    };

    studyRoomBooking_Two = new StudyRoomBooking()
    {
      FirstName = "Daniel",
      LastName = "Hardman",
      Date = new DateTime(),
      Email = "daniel.hardman@pearsonhardman.com",
      BookingId = 22,
      StudyRoomId = 2
    };
  }

  [SetUp]
  public void Setup()
  {
    options = new DbContextOptionsBuilder<ApplicationDbContext>()
      .UseInMemoryDatabase(databaseName: "temp_Bongo").Options;
  }

  [Test]
  public void SaveBooking_Booking_One_CheckTheValuesFromDatabase()
  {
    //arrange

    //act
    using (var context = new ApplicationDbContext(options))
    {
      context.Database.EnsureDeleted(); // Make sure test is not influenced by another tests data
      var repository = new StudyRoomBookingRepository(context);
      repository.Book(studyRoomBooking_One);
    }

    //assert
    using (var context = new ApplicationDbContext(options))
    {
      var bookingFromDb = context.StudyRoomBookings.FirstOrDefault(u => u.BookingId == 11);
      Assert.That(studyRoomBooking_One.BookingId, Is.EqualTo(bookingFromDb!.BookingId));
      Assert.That(studyRoomBooking_One.FirstName, Is.EqualTo(bookingFromDb.FirstName));
      Assert.That(studyRoomBooking_One.LastName, Is.EqualTo(bookingFromDb.LastName));
      Assert.That(studyRoomBooking_One.Email, Is.EqualTo(bookingFromDb.Email));
      Assert.That(studyRoomBooking_One.Date, Is.EqualTo(bookingFromDb.Date));
    }
  }

  [Test]
  public void SaveBooking_BookingOneAndTwo_CheckBothTheBookingFromDatabase()
  {
    //arrange
    var expectedResult = new List<StudyRoomBooking> { studyRoomBooking_One, studyRoomBooking_Two };

    using (var context = new ApplicationDbContext(options))
    {
      context.Database.EnsureDeleted(); // Make sure test is not influenced by another tests data
      var repository = new StudyRoomBookingRepository(context);
      repository.Book(studyRoomBooking_One);
      repository.Book(studyRoomBooking_Two);
    }

    //act
    List<StudyRoomBooking> actualList;
    using (var context = new ApplicationDbContext(options))
    {
      var repository = new StudyRoomBookingRepository(context);
      actualList = repository.GetAll(null).ToList();
    }

    //assert
    Assert.That(actualList, Is.EqualTo(expectedResult).Using(new BookingCompare()));
  }
  
  private class BookingCompare : IComparer<StudyRoomBooking>
  {
    public int Compare(StudyRoomBooking? x, StudyRoomBooking? y)
    {
      return x.BookingId != y.BookingId ? 1 : 0;
    }
  }
}
