package com.orangetalents.orangetalentszup.requests;

import com.orangetalents.orangetalentszup.domain.Vacina;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
import java.time.LocalDate;

public class PessoaPostRequestBody {
    @NotBlank(message = "O campo 'nome' não pode estar vazio")
    private String nome;
    @NotBlank(message = "O campo 'email' não pode estar vazio")
    @Email
    private String email;
    @CPF
    @Size(message = "O campo 'cpf' deve conter 11 dígitos",min = 11,max = 11)
    private String cpf;
    @Past(message = "A data de nascimento deve estar no passado")
    @NotNull(message = "O campo 'nascimento' não pode estar vazio")
    private LocalDate nascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
}
