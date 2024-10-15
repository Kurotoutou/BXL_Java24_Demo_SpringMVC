package be.digitalycity.java.bxl_java24_demospringmvc.dl.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

public record Director(
        int id,
        String firstName,
        String lastName
) {
}
