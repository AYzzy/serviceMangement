package com.servermanagement.data.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Server {
    @Id
    @GeneratedValue(strategy =AUTO)
    private Long id;
    @Column(unique = true)
    @NotEmpty(message = "IP ADDRESS CANNOT BE EMPTY OR NULL")
    private String ipAddress;
    private String name;
    private String memory;
    private String Type;
    private String imageUrl;
    private Status status;
}
