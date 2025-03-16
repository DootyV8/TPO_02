package config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
class Default implements Format {
    @Override
    public String format(String word) {
        return word;
    }
}