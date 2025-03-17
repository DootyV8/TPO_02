package flashcards.service;

import flashcards.model.Entry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import flashcards.repository.EntryRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

@Service
public class FileService {
    private final String filePath;
    private final EntryRepository entryRepository;

    public FileService(@Value("${pl.edu.pja.tpo02}") String filePath, EntryRepository entryRepository) {
        this.filePath = filePath;
        this.entryRepository = entryRepository;
        loadEntriesFromFile();
    }

    private void loadEntriesFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    Entry entry = new Entry(parts[0].trim(), parts[1].trim(), parts[2].trim());
                    entryRepository.addEntry(entry);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveEntriesToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Entry entry : entryRepository.getAllEntries()) {
                writer.println(entry.getPolish() + "," + entry.getEnglish() + "," + entry.getGerman());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}