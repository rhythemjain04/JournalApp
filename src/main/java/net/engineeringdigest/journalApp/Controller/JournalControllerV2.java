package net.engineeringdigest.journalApp.Controller;

import net.engineeringdigest.journalApp.Entity.JournalEntity;
import net.engineeringdigest.journalApp.Service.JournalService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/JournalV2")
public class JournalControllerV2 {

    @Autowired
    private JournalService journalService;

    @GetMapping("/healthcheck")
    public String healthCheck(){
        return "OK";
    }
    
    @PostMapping("/Entry")
    public ResponseEntity<JournalEntity> JournalEntry(@RequestBody JournalEntity abc){
        journalService.saveJournalEntry(abc);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> entries(){
        List<JournalEntity> entries =  journalService.getAll();
        if(entries.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(entries,HttpStatus.OK);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<JournalEntity> entry(@PathVariable String id){
        Optional<JournalEntity> journalEntry = journalService.getJournalEntry(id);
        if(journalEntry.isPresent()){
            return new ResponseEntity<>(journalEntry.orElse(null),HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @PutMapping("id/{id}")
    public ResponseEntity<JournalEntity> update(@RequestBody JournalEntity abc,@PathVariable String id){
        return journalService.updateEntry(abc, id);
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<?> deleteEntryFromMap(@PathVariable String id){
         return journalService.deleteById(id);
    }

    @DeleteMapping("/Entries")
    public ResponseEntity<?> deleteAllEntries(){
        journalService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
