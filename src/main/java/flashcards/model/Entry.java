package flashcards.model;

public class Entry {
    private String polish;
    private String english;
    private String german;

    public Entry(String polish, String english, String german) {
        this.polish = polish;
        this.english = english;
        this.german = german;
    }

    public String getPolish() { return polish; }
    public void setPolish(String polish) { this.polish = polish; }

    public String getEnglish() { return english; }
    public void setEnglish(String english) { this.english = english; }

    public String getGerman() { return german; }
    public void setGerman(String german) { this.german = german; }

    @Override
    public String toString() {
        return String.format("Polish: %s, English: %s, German: %s", polish, english, german);
    }
}