package pl.sda.springcwiczenie1.infrastructure;

import pl.sda.springcwiczenie1.infrastructure.Application;

import java.util.List;
import java.util.Optional;

public interface ApplicationRepository {

    void save(Application application);

    void updateVersion (Long id, String newVersion);

    void delete (Long id);

    List<Application> getAll();

    Optional <Application> getOne(Long id);
}
