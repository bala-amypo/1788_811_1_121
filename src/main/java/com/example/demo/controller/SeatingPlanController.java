@RestController
@RequestMapping("/plans")
@Tag(name = "Seating Plans")
public class SeatingPlanController {

    private final SeatingPlanRepository repo;

    public SeatingPlanController(SeatingPlanRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/generate/{sessionId}")
    @Operation(summary = "Generate seating plan")
    public SeatingPlan generate(@PathVariable Long sessionId) {
        SeatingPlan p = new SeatingPlan();
        p.setSessionId(sessionId);
        p.setPlanDetails("Auto-generated");
        return repo.save(p);
    }

    @GetMapping("/{planId}")
    @Operation(summary = "Get seating plan")
    public SeatingPlan get(@PathVariable Long planId) {
        return repo.findById(planId).orElse(null);
    }

    @GetMapping("/session/{sessionId}")
    @Operation(summary = "List plans for session")
    public List<SeatingPlan> list(@PathVariable Long sessionId) {
        return repo.findBySessionId(sessionId);
    }
}
