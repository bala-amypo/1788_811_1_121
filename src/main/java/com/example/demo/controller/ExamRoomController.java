@RestController
@RequestMapping("/rooms")
@Tag(name = "Rooms")
public class ExamRoomController {

    private final LocationRepository repo;

    public ExamRoomController(LocationRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    @Operation(summary = "Add room")
    public Location add(@RequestBody Location r) {
        return repo.save(r);
    }

    @GetMapping
    @Operation(summary = "List rooms")
    public List<Location> list() {
        return repo.findAll();
    }
}
