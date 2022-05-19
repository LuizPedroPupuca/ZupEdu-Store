package br.com.zup.edu.store;

import javax.persistence.*;

@Entity
public class QuantidadeDownloads {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer qtde;

    @OneToOne
    private Aplicativo aplicativo;

    @Version
    private int version;

    public QuantidadeDownloads(Aplicativo aplicativo) {
        this.aplicativo = aplicativo;
        this.qtde = 0;
    }

    @Deprecated
    public QuantidadeDownloads() {
    }

    public void incrementa(){
        this.qtde++;
    }
}
