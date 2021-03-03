package io.hari.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Hariom Yadav
 * @create 02-03-2021
 */
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"seats", "movies"}, callSuper = true)
@AllArgsConstructor
@Builder
@Entity
@Table(name = "shows")
public class Show extends BaseEntity {
    String showName;

    @ManyToMany(fetch = FetchType.EAGER)//+ 1 dao method
    List<Seat> seats = new ArrayList<>();

    @OneToMany
//			(fetch = FetchType.EAGER)//not working - error cant fetch multiple bags since above also we are fetching
    //test locally how to fetch or fetch at run time and see
    List<Movie> movies = new ArrayList<>();

    //other metadata
}