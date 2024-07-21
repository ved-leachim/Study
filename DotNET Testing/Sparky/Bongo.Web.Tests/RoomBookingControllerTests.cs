using Bongo.Core.Services.IServices;
using Bongo.Models.Model;
using Bongo.Models.Model.VM;
using Bongo.Web.Controllers;
using Microsoft.AspNetCore.Mvc;
using Moq;
using NUnit.Framework;

namespace Bongo.Web;

[TestFixture]
public class RoomBookingControllerTests
{
  private Mock<IStudyRoomBookingService> _studyRoomBookingService;
  private RoomBookingController _bookingController;

  [SetUp]
  public void Setup()
  {
    _studyRoomBookingService = new Mock<IStudyRoomBookingService>();
    _bookingController = new RoomBookingController(_studyRoomBookingService.Object);
  }

  [Test]
  public void IndexPage_CallRequest_VerifyGetAllInvoked()
  {
    _bookingController.Index();
    _studyRoomBookingService.Verify(x => x.GetAllBooking(), Times.Once);
  }

  [Test]
  public void BookRoomCheck_ModelStateInvalid_ReturnView()
  {
    _bookingController.ModelState.AddModelError("test", "test");
    var result = _bookingController.Book(new StudyRoomBooking());

    ViewResult viewResult = result as ViewResult;
    Assert.That(viewResult.ViewName, Is.EqualTo("Book"));
  }

  [Test]
  public void BookRoomCheck_NotSuccessful_NoRoomCode()
  {
    _studyRoomBookingService.Setup(x => x.BookStudyRoom(It.IsAny<StudyRoomBooking>()))
      .Returns(new StudyRoomBookingResult()
      {
        Code = StudyRoomBookingCode.NoRoomAvailable
      });

    var result = _bookingController.Book(new StudyRoomBooking());

    Assert.That(result, Is.InstanceOf<ViewResult>());
    ViewResult viewResult = result as ViewResult;
    Assert.That(viewResult.ViewData["Error"], Is.EqualTo("No Study Room available for selected date"));
  }

  [Test]
  public void BookRoomCheck_Successful_SuccessCodeAndRedirect()
  {
    //arrange
    _studyRoomBookingService.Setup(x => x.BookStudyRoom(It.IsAny<StudyRoomBooking>()))
      .Returns((StudyRoomBooking booking) => new StudyRoomBookingResult()
      {
        Code = StudyRoomBookingCode.Success,
        FirstName = booking.FirstName,
        LastName = booking.LastName,
        Date = booking.Date,
        Email = booking.Email
      });

    //act
    var result = _bookingController.Book(new StudyRoomBooking
    {
      Date = DateTime.Now,
      Email = "robert.zane@zanespecterlitt.com",
      FirstName = "Robert",
      LastName = "Zane",
      StudyRoomId = 1
    });

    //assert
    Assert.That(result, Is.InstanceOf<RedirectToActionResult>());
    RedirectToActionResult actionResult = result as RedirectToActionResult;
    Assert.That(actionResult.RouteValues["FirstName"], Is.EqualTo("Robert"));
    Assert.That(actionResult.RouteValues["Code"], Is.EqualTo(StudyRoomBookingCode.Success));
  }
}
