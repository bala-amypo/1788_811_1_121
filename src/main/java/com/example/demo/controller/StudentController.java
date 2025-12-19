@RestController
@RequestMapping("/students")
@Tag(name = "Students")
public class StudentController {

    private final StudentRepository repo;

    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    @Operation(summary = "Add student")
    public StudentEntity add(@RequestBody StudentEntity s) {
        return repo.save(s);
    }

    @GetMapping
    @Operation(summary = "List students")
    public List<StudentEntity> list() {
        return repo.findAll();
    }
}
