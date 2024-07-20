package br.senac.cantina.produto.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.cantina.operador.dto.CreateOperadorDto;
import br.senac.cantina.shared.models.Produto;


@Service
public class ProdutoServiceImpl implements ProdutoService {}