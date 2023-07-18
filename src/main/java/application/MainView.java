package application;

import application.entity.Counter;
import application.service.CounterService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;



@Route("main")
public class MainView extends VerticalLayout {
    private final CounterService counterService;

    public MainView(CounterService counterService) {
        this.counterService = counterService;

        Counter counter = new Counter(1, 2);
        counterService.createCounter(counter);
        TextField textField = new TextField();
        String text = String.valueOf(counterService.findByCounter(1).getNumber());
        textField.setValue(text);
        add(new H3(textField, new Button("Увеличить значение на 1") {
            {
                addClickListener(click -> {
                    counter.setNumber(counter.getNumber() + 1);
                    counterService.updateCounter(counter);
                    textField.setValue(String.valueOf(counterService.findByCounter(1).getNumber()));
                });
                textField.getElement().addEventListener("keyup", e -> {
                    counter.setNumber(Integer.parseInt(textField.getValue()));
                    counterService.updateCounter(counter);
                    textField.setValue(String.valueOf(counterService.findByCounter(1).getNumber()));
                });
            }
        }));

    }
}
