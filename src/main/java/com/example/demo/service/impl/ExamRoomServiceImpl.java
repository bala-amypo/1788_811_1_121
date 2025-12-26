@Service
public class ExamRoomServiceImpl implements ExamRoomService {

    private final ExamRoomRepository repo;

    public ExamRoomServiceImpl(ExamRoomRepository repo) {
        this.repo = repo;
    }

    @Override
    public ExamRoom addRoom(ExamRoom room) {
        return repo.save(room);
    }

    @Override
    public List<ExamRoom> getAllRooms() {
        return repo.findAll();
    }
}
