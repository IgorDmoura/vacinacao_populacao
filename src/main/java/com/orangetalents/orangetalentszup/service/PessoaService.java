package com.orangetalents.orangetalentszup.service;

import com.orangetalents.orangetalentszup.domain.Pessoa;
import com.orangetalents.orangetalentszup.mapper.PessoaMapper;
import com.orangetalents.orangetalentszup.mapper.PessoaResponseMapper;
import com.orangetalents.orangetalentszup.repository.PessoaRepository;
import com.orangetalents.orangetalentszup.requests.PessoaPostRequestBody;
import com.orangetalents.orangetalentszup.response.PessoaPostResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PessoaService {
    private final PessoaRepository pessoaRepository;
    private final PessoaResponseMapper pessoaResponseMapper;
    private final PessoaMapper pessoaMapper;

    public PessoaService(PessoaRepository pessoaRepository, PessoaResponseMapper pessoaResponseMapper, PessoaMapper pessoaMapper) {
        this.pessoaRepository = pessoaRepository;
        this.pessoaResponseMapper = pessoaResponseMapper;
        this.pessoaMapper = pessoaMapper;
    }
       @Transactional
    public PessoaPostResponseBody criarNovaPessoa(PessoaPostRequestBody pessoaPostRequestBody){
        if(pessoaRepository.existsPessoaByCpf(pessoaPostRequestBody.getCpf()) || pessoaRepository.existsPessoaByEmail(pessoaPostRequestBody.getEmail())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cpf ou Email já está registrado");
        }
        Pessoa pessoa = pessoaMapper.toPessoa(pessoaPostRequestBody);
        pessoa = pessoaRepository.save(pessoa);
        return pessoaResponseMapper.toPessoaPostResponseBody(pessoa);
    }

}
