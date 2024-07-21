using System.Collections.Generic;
using Bongo.Models.Model;
using Bongo.Models.Model.VM;

namespace Bongo.Core.Services.IServices
{
    public interface IStudyRoomBookingService
    {
        StudyRoomBookingResult BookStudyRoom(StudyRoomBooking request);
        IEnumerable<StudyRoomBooking> GetAllBooking();
    }
}
