package flashcards.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("uppercase")
class Uppercase implements Format {
    @Override
    public String format(String word) {
        return word.toUpperCase();
    }
}
