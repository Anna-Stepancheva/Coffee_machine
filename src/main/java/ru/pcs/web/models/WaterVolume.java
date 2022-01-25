package ru.pcs.web.models;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class WaterVolume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int volume;
}
