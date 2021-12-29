package com.example.norx.bnm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Currency implements Serializable {
    private int id;
    private String numCode;
    private String charCode;
    private Integer nominal;
    private String name;
    private Double value;
}
