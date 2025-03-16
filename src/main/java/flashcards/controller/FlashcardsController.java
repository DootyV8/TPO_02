package controller;

import config.Format;
import model.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import repository.EntryRepository;
import service.FileService;

import java.util.List;
import java.util.Scanner;

@Controller
public class FlashcardsController {

    private final EntryRepository entryRepository;
    private final FileService fileService;
    private final Format format;
    private final Scanner scanner = new Scanner(System.in);

    @Autowired
    public FlashcardsController(EntryRepository entryRepository, FileService fileService, Format format) {
        this.entryRepository = entryRepository;
        this.fileService = fileService;
        this.format = format;
    }

    public void start() {
        while (true) {
            System.out.println("1. Add a new word");
            System.out.println("2. Display all words");
            System.out.println("3. Take a test");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addWord();
                case 2 -> displayAllWords();
                case 3 -> takeTest();
                case 4 -> { return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private void addWord() {
        System.out.println("Enter Polish word:");
        String polish = scanner.nextLine();
        System.out.println("Enter English word:");
        String english = scanner.nextLine();
        System.out.println("Enter German word:");
        String german = scanner.nextLine();

        Entry entry = new Entry(polish, english, german);
        entryRepository.addEntry(entry);
        System.out.println("Word added successfully!");
    }

    private void displayAllWords() {
        List<Entry> entries = entryRepository.getAllEntries();
        for (Entry entry : entries) {
            // Format each word using the Format bean
            String formattedPolish = format.format(entry.getPolish());
            String formattedEnglish = format.format(entry.getEnglish());
            String formattedGerman = format.format(entry.getGerman());
            System.out.printf("Polish: %s, English: %s, German: %s%n",
                    formattedPolish, formattedEnglish, formattedGerman);
        }
    }

    private void takeTest() {
        Entry entry = entryRepository.getRandomEntry();
        if (entry == null) {
            System.out.println("No words available for testing.");
            return;
        }

        // Format the test word using the Format bean
        String formattedPolish = format.format(entry.getPolish());
        System.out.println("Translate the word: " + formattedPolish);

        System.out.println("Enter English translation:");
        String englishAnswer = scanner.nextLine();
        System.out.println("Enter German translation:");
        String germanAnswer = scanner.nextLine();

        // Format the correct answers for comparison
        String formattedEnglish = format.format(entry.getEnglish());
        String formattedGerman = format.format(entry.getGerman());

        if (englishAnswer.equalsIgnoreCase(formattedEnglish)) {
            System.out.println("Correct English translation!");
        } else {
            System.out.println("Incorrect English translation!");
        }

        if (germanAnswer.equalsIgnoreCase(formattedGerman)) {
            System.out.println("Correct German translation!");
        } else {
            System.out.println("Incorrect German translation!");
        }
    }
}