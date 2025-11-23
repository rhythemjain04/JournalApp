package net.engineeringdigest.journalApp.Controller;

import net.engineeringdigest.journalApp.Entity.JournalEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RequestMapping("/JournalV2")
public class JournalControllerV2 {

        HashMap<Integer, JournalEntity> journalEntry = new HashMap<>();

        @GetMapping("/healthcheck")
        public String healthCheck(){
            return "OK";
        }
        @PostMapping("/Entry")
        public void JournalEntry(@RequestBody JournalEntity abc){
            journalEntry.put(abc.getId(),abc);
        }
        @GetMapping("/Entries")
        public List<JournalEntity> entries(){
            return new ArrayList<>(journalEntry.values());
        }
        @GetMapping("/Entry")
        public JournalEntity entry(@RequestBody Integer id){
            try{
                JournalEntity journalEntity = journalEntry.get(id);
                return journalEntity;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @DeleteMapping("/Entry")
        public void deleteEntryFromMap(@RequestBody Integer id){
            if(journalEntry.get(id)!=null){
                journalEntry.remove(id);
            }
            else{
                throw new NullPointerException();
            }
        }
        @DeleteMapping("/Entries")
        public void deleteAllEntries(){
            journalEntry.clear();
        }

    }

}
