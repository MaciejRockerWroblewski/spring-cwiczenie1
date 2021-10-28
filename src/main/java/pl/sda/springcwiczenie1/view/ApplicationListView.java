package pl.sda.springcwiczenie1.view;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.springcwiczenie1.infrastructure.Application;
import pl.sda.springcwiczenie1.service.ApplicationService;

@Component
@RequiredArgsConstructor
public class ApplicationListView {

    private final ApplicationService service;

    public void display() {
        service.listAll().forEach(this::displayAppRow);
    }
    public void displayAppRow (Application application) {
        System.out.println(String.format("%d | %s | %s | %s",
                application.getId(), application.getProducer(),
                application.getName(), application.getVersion()));
    }
}
