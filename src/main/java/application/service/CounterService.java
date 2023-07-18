package application.service;

import application.entity.Counter;

public interface CounterService {
    Counter findByCounter(Integer id);
    Counter updateCounter(Counter counter);
    Counter createCounter(Counter counter);
}
