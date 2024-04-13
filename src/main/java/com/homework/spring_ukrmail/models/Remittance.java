package com.homework.spring_ukrmail.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@EqualsAndHashCode(of = {"money", "number", "description","date"})
@ToString(of = {"money", "number", "description","date"})
@Table(name = "'remittances'")
public class Remittance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int money;
    @Column(length = 50)
    private String number;

    private String description;
   // @JsonFormat( pattern = "dd.MM.yyyy") // work
    // @Temporal(value = TemporalType.DATE) // work
   //  @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) // work
    private LocalDate date;

    public Remittance(int money, String number, String description) {
        this.money = money;
        this.number = number;
        this.description = description;

    }
}
