using System.ComponentModel.DataAnnotations;
using Bongo.Models.Model.VM;

namespace Bongo.Models.Model
{
    public class StudyRoomBooking : StudyRoomBookingBase
    {
        [Key]
        public int BookingId { get; set; }
        public int StudyRoomId { get; set; }
    }
}
