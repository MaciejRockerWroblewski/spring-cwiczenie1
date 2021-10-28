package pl.sda.springcwiczenie1.view;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.springcwiczenie1.service.ApplicationService;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class InstallNewAppView {

    private final ApplicationService applicationService;
    private final Scanner scanner;

    public void display(){

        System.out.println("Podaj producenta");
        String producer = scanner.nextLine();
        System.out.println("Podaj nazwę aplikacji");
        String name = scanner.nextLine();
        System.out.println("Podaj wersję");
        String version = scanner.nextLine();

        try {
            applicationService.installNew(producer, name, version);
        } catch (RuntimeException ex) {
            System.out.println("BLĄD: " + ex.getMessage());
        }

    }
}
