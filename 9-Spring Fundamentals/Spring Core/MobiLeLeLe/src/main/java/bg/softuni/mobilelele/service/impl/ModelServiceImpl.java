package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.data.repositories.ModelRepository;
import bg.softuni.mobilelele.service.ModelService;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }


    @Override
    public boolean isImported() {
        return false;
    }

    @Override
    public void seedData() {

    }
}
