package pl.sda.springcwiczenie1.infrastructure;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryApplicationRepository implements ApplicationRepository{

    //pole do wyznaczania id. W tym momencie nie ma możliwości, aby zrobiła to automatycznie baza danych.
    private Long id = 1L;

private List<Application> applications = new ArrayList<>();
    @Override
    public void save(Application application) {
        application.setId(id++);

        applications.add(application);

    }

    @Override
    public void updateVersion(Long id, String newVersion) {
applications.stream().filter(app-> app.getId().equals(id))
        .findFirst()
        .ifPresent(app ->app.setVersion(newVersion) );
    }

    @Override
    public void delete(Long id) {
        applications.removeIf(app -> app.getId().equals(id));

    }

    @Override
    public List<Application> getAll() {
        return applications;
    }

    @Override
    public Optional<Application> getOne(Long id) {
        return applications.stream()
                .filter(app -> app.getId().equals(id))
                .findFirst();
    }
}
