package com.example.ims.aksisstent02.objects;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Noah on 05.02.2018.
 */

public class User {
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String klasse;

    @Getter
    @Setter
    private Date lastUpdate;
}
