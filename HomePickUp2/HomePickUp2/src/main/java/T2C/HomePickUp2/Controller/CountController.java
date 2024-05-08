package T2C.HomePickUp2.Controller;

import T2C.HomePickUp2.DTO.CountDTO;
import T2C.HomePickUp2.Service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/rest")
public class CountController {

    private final CountService countService;

    @GetMapping("/secure")
    public String secureMethod() {
        return "secure rest endpoint";
    }

    @Autowired
    public CountController(CountService countService) {
        this.countService = countService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountDTO> getCountById(@PathVariable Long id) {
        CountDTO countDTO = countService.getCountById(id);
        return countDTO != null ?
                ResponseEntity.ok(countDTO) :
                ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<CountDTO>> getAllCounts() {
        return ResponseEntity.ok(countService.getAllCounts());
    }

    @PostMapping
    public ResponseEntity<CountDTO> createCount(@RequestBody CountDTO countDTO) {
        return new ResponseEntity<>(countService.createCount(countDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCount(@PathVariable Long id) {
        countService.deleteCount(id);
        return ResponseEntity.noContent().build();
    }
}