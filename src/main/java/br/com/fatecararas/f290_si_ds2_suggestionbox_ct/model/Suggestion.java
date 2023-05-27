package br.com.fatecararas.f290_si_ds2_suggestionbox_ct.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Suggestion {
    private Integer id;
    private String description;
    private LocalDate data;
}
