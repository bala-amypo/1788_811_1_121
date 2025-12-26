@Service
public class ExamSessionServiceImpl implements ExamSessionService {

    private final ExamSessionRepository repo;

    public ExamSessionServiceImpl(ExamSessionRepository repo) {
        this.repo = repo;
    }

    @Override
    public ExamSession createSession(ExamSession session) {
        return repo.save(session);
    }

    @Override
    public ExamSession getSession(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Session not found"));
    }

    @Override
    public List<ExamSession> getAllSessions() {
        return repo.findAll();
    }
}
