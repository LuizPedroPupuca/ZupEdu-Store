package br.com.zup.edu.store;

import javax.persistence.*;

@Entity
public class Aplicativos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String link;

    @OneToOne
    private QuantidadeDownloads quantidadeDownloads;

    OneToOne
    private QuantidadeLikes quantidadeLikes;

    public Aplicativos(String descricao, String link) {
        this.descricao = descricao;
        this.link = link;
    }

    public Aplicativos() {
    }
}
