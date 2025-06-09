package com.example.demo;

import com.example.demo.controller.HealthStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Health {
    private HealthStatus status;
}
