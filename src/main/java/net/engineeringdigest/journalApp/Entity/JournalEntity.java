package net.engineeringdigest.journalApp.Entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document
public class JournalEntity {
    private String title;
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private String id;
    private String content;
    private LocalDateTime Date;

}