using System.Collections.Generic;
using Bongo.Models.Model;

namespace Bongo.DataAccess.Repository.IRepository
{
    public interface IStudyRoomRepository
    {
        IEnumerable<StudyRoom> GetAll();
    }
}
