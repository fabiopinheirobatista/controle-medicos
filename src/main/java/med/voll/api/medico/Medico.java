package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;
    private Boolean ativo;

    public Medico(DadosCadastroMedico dadosCadastroMedico) {
        this.ativo = true;
        this.nome = dadosCadastroMedico.nome();
        this.email = dadosCadastroMedico.email();
        this.crm = dadosCadastroMedico.crm();
        this.telefone = dadosCadastroMedico.telefone();
        this.especialidade = dadosCadastroMedico.especialidade();
        this.endereco = new Endereco(dadosCadastroMedico.endereco());
    }

    public void atualizarInformacoes(DadosAtualizarMedico dadosAtualizarMedico) {
        if(dadosAtualizarMedico.nome() != null){
            this.nome = dadosAtualizarMedico.nome();
        }

        if(dadosAtualizarMedico.telefone() != null){
            this.nome = dadosAtualizarMedico.telefone();
        }

        if(dadosAtualizarMedico.endereco() != null){
            this.endereco.atualizarInformacoes(dadosAtualizarMedico.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
