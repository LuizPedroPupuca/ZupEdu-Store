package br.com.zup.edu.store;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class AplicativoRequest {

    @NotBlank
    private String descricao;
    @NotBlank
    private String link;

    public AplicativoRequest(String descricao, String link) {
        this.descricao = descricao;
        this.link = link;
    }

    public AplicativoRequest() {
    }

    public Aplicativo toModel() {
        return new Aplicativo(this.descricao, this.link);
    }

    public String getDescricao() {
        return descricao;
    }

    public String getLink() {
        return link;
    }
}
