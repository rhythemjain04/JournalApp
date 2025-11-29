package net.engineeringdigest.journalApp.Service;

import net.engineeringdigest.journalApp.Entity.JournalEntity;
import net.engineeringdigest.journalApp.Repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JournalService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public void saveJournalEntry(JournalEntity journalEntity){
        journalEntity.setDate(LocalDateTime.now());
        journalEntryRepository.save(journalEntity);
    }

    public Optional<JournalEntity> getJournalEntry(String id){
        return journalEntryRepository.findById(id);
    }

    public List<JournalEntity> getAll(){
        return journalEntryRepository.findAll();
    }

    public void deleteById(String id){
        journalEntryRepository.deleteById(id);
    }

    public void deleteAll(){
        journalEntryRepository.deleteAll();
    }

    public JournalEntity updateEntry(JournalEntity journalEntity, String id) throws NullPointerException{
        JournalEntity oldJournalEntity = journalEntryRepository.findById(id).orElse(null);
        if(oldJournalEntity!=null){
            if(!oldJournalEntity.getContent().equalsIgnoreCase(journalEntity.getContent())){
                oldJournalEntity.setContent(journalEntity.getContent());
            }
            if(!oldJournalEntity.getTitle().equalsIgnoreCase(journalEntity.getTitle())){
                oldJournalEntity.setTitle(journalEntity.getTitle());
            }
        }
        if (oldJournalEntity!=null) {
            journalEntryRepository.save(oldJournalEntity);
        }
        return oldJournalEntity;
    }
}
