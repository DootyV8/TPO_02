import controller.FlashcardsController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"config", "controller", "repository", "service"})
public class FlashcardsApp implements CommandLineRunner {

    private final FlashcardsController flashcardsController;

    @Autowired
    public FlashcardsApp(FlashcardsController flashcardsController) {
        this.flashcardsController = flashcardsController;
    }

    public static void main(String[] args) {
        SpringApplication.run(FlashcardsApp.class, args);
    }

    @Override
    public void run(String... args) {
        flashcardsController.start();
    }
}
