package ru.pcs.web.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "commands")
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String command;

    private int coffeeId;

    private int waterVolumeId;
}
