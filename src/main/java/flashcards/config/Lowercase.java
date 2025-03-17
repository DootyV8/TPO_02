package flashcards.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("lowercase")
class Lowercase implements Format {
    @Override
    public String format(String word) {
        return word.toLowerCase();
    }
}
