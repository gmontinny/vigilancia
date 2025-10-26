package br.gov.mt.vigilancia.saude.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "saude")
public class Saude {

    @Id
    @SequenceGenerator(name = "saude_idsaude_seq", sequenceName = "saude_idsaude_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "saude_idsaude_seq")
    private Integer id;

    private Integer acuputura;
    private Integer aids;
    private Integer at;
    private Integer bancoLeite;
    private Integer bancoOrgaos;
    private Integer banco;
    private Integer buco;
    private Integer cardioco;
    private Integer cardiologia;
    private Integer cirurgiaGeral;
    private Integer citologia;
    private Integer clinica;
    private Integer clinicoGeral;
    private Integer coleta;
    private Integer cronicos;
    private Integer dermatologista;
    private Integer dialise;
    private Integer endocrinologia;
    private Integer endoscopia;
    private Integer enteral;
    private Integer fisioterapia;
    private Integer fonoaudiologia;
    private Integer gastroenterologia;
    private Integer geriatria;
    private Integer ginecologia;
    private Integer hansenologia;
    private Integer hematologia;
    private Integer hemodialise;
    private Integer hemodinamica;
    private Integer hiperbarica;
    private Integer homecare;
    private Integer lactario;
    private Integer leitoDia;
    private Integer leito;
    private Integer litotripsia;
    private Integer medicoRadio;
    private Integer medico;
    private Integer misoprostol;
    private Integer nefrologia;
    private Integer neonatologia;
    private Integer neurocirurgia;
    private Integer neurologia;
    private Integer nutricao;
    private Integer obstetrica;
    private Integer obstetriciaSaude;
    private Integer odontologicoCirurgico;
    private Integer odontologicoRadio;
    private Integer odontologico;
    private Integer oftalmologia;
    private Integer oncologia;
    private Integer oncologista;
    private Integer otorrinolaringologia;
    private Integer parenteral;
    private Integer patologia;
    private Integer pediatria;
    private Integer plastica;
    private Integer pneumologia;
    private Integer procedimento;
    private Integer psicologia;
    private Integer psiquiatria;
    private Integer reabilitacao;
    private Integer ressonancia;
    private Integer substitutiva;
    private Integer tisiologia;
    private Integer toraxica;

    @Column(name = "transporte_a")
    private Integer transporteA;

    @Column(name = "transporte_b")
    private Integer transporteB;

    @Column(name = "transporte_c")
    private Integer transporteC;

    @Column(name = "transporte_d")
    private Integer transporteD;

    private Integer traumatologia;
    private Integer uan;
    private Integer uct;
    private Integer ultrassonografia;
    private Integer unidadeIsolamento;
    private Integer unidadeNeo;
    private Integer unidade;
    private Integer urologia;
    private Integer utiAdulto;
    private Integer utiInfantil;
    private Integer utiNeonatal;
    private Integer veterinarioRadio;

    @ManyToOne
    @JoinColumn(name = "numprocesso")
    private Processo processo;
}
