package application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "counter_table")
public class Counter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int number;
}
