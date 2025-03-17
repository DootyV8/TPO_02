package flashcards.repository;

import flashcards.model.Entry;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EntryRepository {
    private final List<Entry> entries = new ArrayList<>();

    public void addEntry(Entry entry) {
        entries.add(entry);
    }

    public List<Entry> getAllEntries() {
        return entries;
    }

    public Entry getRandomEntry() {
        if (entries.isEmpty()) {
            return null;
        }
        int randomIndex = (int) (Math.random() * entries.size());
        return entries.get(randomIndex);
    }
}