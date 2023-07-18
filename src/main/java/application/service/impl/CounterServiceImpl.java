package application.service.impl;

import application.entity.Counter;
import application.repository.CounterRepository;
import application.service.CounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CounterServiceImpl implements CounterService {
    private final CounterRepository counterRepository;
    @Override
    public Counter findByCounter(Integer id) {
        Optional<Counter> optionalCounter = counterRepository.findById(id);
        Counter counter = optionalCounter.get();
        return optionalCounter.get();
    }

    @Override
    public Counter createCounter(Counter counter) {
        return counterRepository.save(counter);
    }

    @Override
    public Counter updateCounter(Counter counter) {
        counterRepository.save(counter);
        return counter;
    }
}
