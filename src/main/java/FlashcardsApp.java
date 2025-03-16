import controller.FlashcardsController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = {"config", "controller", "repository", "service"})
class FlashcardsApp implements CommandLineRunner {

    private FlashcardsController flashcardsController;

    @Override
    public void run(String... args) {
        flashcardsController.start();
    }

    public static void main(String[] args) {
        SpringApplication.run(FlashcardsApp.class, args);
    }
}