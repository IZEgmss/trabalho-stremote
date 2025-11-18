package com.fatec.comercio.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

public class Tipo {
     @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer codtipo;
    
        @Column
        private String nometipo;

        public Integer getCodtipo() {
            return codtipo;
        }

        public void setCodtipo(Integer codtipo) {
            this.codtipo = codtipo;
        }

        public String getNometipo() {
            return nometipo;
        }

        public void setNometipo(String nometipo) {
            this.nometipo = nometipo;
        }

        
}
