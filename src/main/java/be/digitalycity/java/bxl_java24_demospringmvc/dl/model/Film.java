package be.digitalycity.java.bxl_java24_demospringmvc.dl.model;

import jakarta.persistence.*;
import lombok.*;

public record Film(
        int id,
        String title,
        Director director
) {
}
