package pl.sda.springcwiczenie1.view;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.springcwiczenie1.service.ApplicationService;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class UpdateAppView {

    private final ApplicationService applicationService;

    public void display() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ID aplikaacji do aktualizacji");
        Long id = Long.valueOf(scanner.nextLine());
        System.out.println("Podaj nową wersję");
        String newVersion = scanner.nextLine();

        try {
            applicationService.update(id, newVersion);
        } catch (RuntimeException ex){
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

}


