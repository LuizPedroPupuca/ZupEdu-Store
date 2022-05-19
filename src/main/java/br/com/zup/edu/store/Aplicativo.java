package br.com.zup.edu.store;

import javax.persistence.*;

@Entity
public class Aplicativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String link;

    @OneToOne(mappedBy = "aplicativo", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private QuantidadeDownloads quantidadeDownloads;

    @OneToOne(mappedBy = "aplicativo", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private QuantidadeLikes quantidadeLikes;

    @Version
    private int version;

    public Aplicativo(String descricao, String link) {
        this.descricao = descricao;
        this.link = link;
        this.quantidadeDownloads = new QuantidadeDownloads(this);
        this.quantidadeLikes = new QuantidadeLikes(this);
    }

    @Deprecated
    public Aplicativo() {
    }

    public Long getId() {
        return id;
    }

    public String getLink() {
        return link;
    }

    public void aumentaQtdeDownloads(){
        this.quantidadeDownloads.incrementa();
    }

    public void aumentaQtdeLikes(){
        this.quantidadeLikes.incrementa();
    }

    public void atualiza(AplicativoRequest aplicativoRequest) {
        this.descricao = aplicativoRequest.getDescricao();
        this.link = aplicativoRequest.getLink();
    }
}
