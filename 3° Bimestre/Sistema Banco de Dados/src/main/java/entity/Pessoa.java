package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Pessoa")
@Table(name = "Pessoa")

public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //chaves primarias ja sao colunas, por isso nao e necessario declara-la
    private int id;
    @Column
    private String nome;
    @Column
    private String sobrenome;
    @Column
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "endereco_id")
    private Endereco endereco;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private List<Pedido> pedidos;

    public Pessoa(String nome, String sobrenome, String email, Endereco endereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", email='" + email + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
