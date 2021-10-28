package pl.sda.springcwiczenie1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.springcwiczenie1.infrastructure.Application;
import pl.sda.springcwiczenie1.infrastructure.ApplicationRepository;

import java.util.List;
import java.util.Optional;

import static org.apache.logging.log4j.util.Strings.isBlank;

@Service
@RequiredArgsConstructor
public class ApplicationService {
    private final ApplicationRepository repository;


    public void installNew(String producer, String name, String version) {
        if (isBlank(producer) || isBlank(name) || isBlank(version)) {
            throw new IllegalStateException("All datas are required");
        }
        Optional<Long> maybeAppId = listAll()
                .stream()
                .filter(app -> app.getName().equals(name) && app.getProducer().equals(producer))
                        .findFirst()
                        .map(Application::getId);
        if (maybeAppId.isPresent()) {
            update(maybeAppId.get(), version);
    } else {
            repository.save(Application.builder()
                    .name(name)
                    .producer(producer)
                    .version(version)
                    .build());
        }
}
    public void update(Long id, String version) {
        if (!repository.getOne(id).isPresent()){
            throw new IllegalStateException("The app doesn't exist.");
        }
        repository.updateVersion(id, version);
    }

    public void delete(Long id) {
        if (!repository.getOne(id).isPresent()){
            throw new IllegalStateException("The app doesn't exist.");
        }
        repository.delete(id);

    }

    public List<Application> listAll() {
        return repository.getAll();
    }


}

