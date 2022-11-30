package com.pr.gameserver.domain.entries;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class Ranking {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Getter
    @Setter
    private Integer id;

    @OneToOne
    @JoinColumn(name="user_id")
    @Getter
    @Setter
    private User user;

    @Getter
    @Setter
    private String points;
}

