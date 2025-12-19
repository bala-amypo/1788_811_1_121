@RestController
@RequestMapping("/sessions")
@Tag(name = "Sessions")
public class ExamSessionController {

    private final ExamSessionRepository repo;

    public ExamSessionController(ExamSessionRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    @Operation(summary = "Create exam session")
    public ExamSession create(@RequestBody ExamSession s) {
        return repo.save(s);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get session details")
    public ExamSession get(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }
}
