package net.engineeringdigest.journalApp.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JournalEntity {
    private String title;

    @NotNull
    private Integer id;

    private String content;

}