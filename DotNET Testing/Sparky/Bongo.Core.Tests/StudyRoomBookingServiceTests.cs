using Bongo.Core.Services;
using Bongo.DataAccess.Repository.IRepository;
using Bongo.Models.Model;
using Bongo.Models.Model.VM;
using Moq;
using NUnit.Framework;

namespace Bongo.Core;

[TestFixture]
public class StudyRoomBookingServiceTests
{
  private StudyRoomBooking _request;
  private List<StudyRoom> _availableStudyRoom;

  private Mock<IStudyRoomBookingRepository> _studyRoomBookingRepoMock;
  private Mock<IStudyRoomRepository> _studyRoomRepoMock;
  private StudyRoomBookingService _bookingService;

  [SetUp]
  public void Setup()
  {
    _request = new StudyRoomBooking
    {
      FirstName = "Donna",
      LastName = "Paulson",
      Email = "donna.paulson@pearsonhardman.com",
      Date = new DateTime(2024, 7, 18)
    };

    _availableStudyRoom = new List<StudyRoom>
    {
      new StudyRoom
      {
        Id = 10,
        RoomName = "Matterhorn",
        RoomNumber = "A202"
      }
    };

    _studyRoomBookingRepoMock = new Mock<IStudyRoomBookingRepository>();
    _studyRoomRepoMock = new Mock<IStudyRoomRepository>();
    _studyRoomRepoMock.Setup(x => x.GetAll()).Returns(_availableStudyRoom);
    _bookingService = new StudyRoomBookingService(
      _studyRoomBookingRepoMock.Object,
      _studyRoomRepoMock.Object
    );
  }

  [TestCase]
  public void GetAllBooking_InvokeMethod_CheckIfRepoIsCalled()
  {
    _bookingService.GetAllBooking();
    _studyRoomBookingRepoMock.Verify(x => x.GetAll(null), Times.Once);
  }

  [TestCase]
  public void BookingException_NullRequest_ThrowsException()
  {
    //arrange
    //act
    var exception = Assert.Throws<ArgumentNullException>(
      () => _bookingService.BookStudyRoom(null));

    //assert
    Assert.That(exception.Message, Is.EqualTo("Value cannot be null. (Parameter 'request')"));
    Assert.That(exception.ParamName, Is.EqualTo("request"));
  }

  [Test]
  public void StudyRoomBooking_SaveBookingWithAvailableRoom_ReturnsResultsWithAllValues()
  {
    //arrange
    StudyRoomBooking? savedStudyRoomBooking = null;
    _studyRoomBookingRepoMock.Setup(x => x.Book(It.IsAny<StudyRoomBooking>()))
      .Callback<StudyRoomBooking>(booking => { savedStudyRoomBooking = booking; });

    //act
    _bookingService.BookStudyRoom(_request);

    //assert
    _studyRoomBookingRepoMock.Verify(x => x.Book(It.IsAny<StudyRoomBooking>()), Times.Once);
    Assert.That(savedStudyRoomBooking, Is.Not.Null);
    Assert.That(_request.FirstName, Is.EqualTo(savedStudyRoomBooking!.FirstName));
    Assert.That(_request.LastName, Is.EqualTo(savedStudyRoomBooking.LastName));
    Assert.That(_request.Email, Is.EqualTo(savedStudyRoomBooking.Email));
    Assert.That(_request.Date, Is.EqualTo(savedStudyRoomBooking.Date));
    Assert.That(_availableStudyRoom.First().Id, Is.EqualTo(savedStudyRoomBooking.StudyRoomId));
  }

  [Test]
  public void StudyRoomBookingResultCheck_InputRequest_ValuesMatchInResult()
  {
    StudyRoomBookingResult result = _bookingService.BookStudyRoom(_request);

    Assert.That(result, Is.Not.Null);

    Assert.That(_request.FirstName, Is.EqualTo(result.FirstName));
    Assert.That(_request.LastName, Is.EqualTo(result.LastName));
    Assert.That(_request.Email, Is.EqualTo(result.Email));
    Assert.That(_request.Date, Is.EqualTo(result.Date));
  }

  [TestCase(true, ExpectedResult = StudyRoomBookingCode.Success)]
  [TestCase(false, ExpectedResult = StudyRoomBookingCode.NoRoomAvailable)]
  public StudyRoomBookingCode ResultCodeSuccess_RoomAvailability_ReturnsSuccessResultCode(bool roomAvailability)
  {
    if (!roomAvailability)
      _availableStudyRoom.Clear();

    return _bookingService.BookStudyRoom(_request).Code;
  }

  [TestCase(55, true)]
  public void StudyRoomBooking_BookRoomWithAvailability_ReturnsBookingId(int expectedBookingId, bool roomAvailability)
  {
    _studyRoomBookingRepoMock.Setup(x => x.Book(It.IsAny<StudyRoomBooking>()))
      .Callback<StudyRoomBooking>(booking => { booking.BookingId = 55; });

    var result = _bookingService.BookStudyRoom(_request);
    Assert.That(result.BookingId, Is.EqualTo(expectedBookingId));
  }

  [Test]
  public void BookNotInvoked_SaveBookingWithoutAvailableRoom_BookMethodNotInvoked()
  {
      _availableStudyRoom.Clear();

      var result = _bookingService.BookStudyRoom(_request);
      _studyRoomBookingRepoMock.Verify(x => x.Book(It.IsAny<StudyRoomBooking>()), Times.Never);
  }
}
