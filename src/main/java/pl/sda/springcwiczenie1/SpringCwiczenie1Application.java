package pl.sda.springcwiczenie1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sda.springcwiczenie1.view.MenuView;

@SpringBootApplication
public class SpringCwiczenie1Application implements CommandLineRunner {


    @Autowired
    private MenuView menuView;

    public static void main(String[] args) {
        SpringApplication.run(SpringCwiczenie1Application.class, args);
        }

    @Override
    public void run(String... args) throws Exception {
        menuView.display();

    }
}
