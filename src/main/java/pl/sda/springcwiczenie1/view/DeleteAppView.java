package pl.sda.springcwiczenie1.view;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.springcwiczenie1.service.ApplicationService;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class DeleteAppView {

    private final ApplicationService applicationService;
    private final Scanner scanner;

    public void display() {
        System.out.println("Podaj ID aplikaacji do usunięcia");
        Long id = Long.valueOf(scanner.nextLine());

        try {
            applicationService.delete(id);
        } catch (RuntimeException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

}
