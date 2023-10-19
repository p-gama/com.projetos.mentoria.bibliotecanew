package com.projetos.mentoria.biblioteca.api.controller;

import com.projetos.mentoria.biblioteca.application.model.ClienteDTO;
import com.projetos.mentoria.biblioteca.application.usecases.ClienteUseCase;
import com.projetos.mentoria.biblioteca.application.mapper.ClienteMapper;
import com.projetos.mentoria.biblioteca.domain.entities.ClienteEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteUseCase clienteUseCase;
    private final ClienteMapper clienteMapper;

    public ClienteController(ClienteUseCase clienteUseCase, ClienteMapper clienteMapper) {
        this.clienteUseCase = clienteUseCase;
        this.clienteMapper = clienteMapper;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<ClienteDTO> cadastrarCliente(@RequestBody ClienteDTO cli) {
        try {
            ClienteEntity cliente = clienteUseCase.salvarClienteComEndereco(cli);
            ClienteDTO response = clienteMapper.toClienteDTO(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        try {
            List<ClienteEntity> clientes = clienteUseCase.listarClientes();
            List<ClienteDTO> clienteRespons = clientes.stream()
                    .map(clienteMapper::toClienteDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(clienteRespons);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
//@RestController
//@RequestMapping("/clientes")
//public class ClienteController {
//
//    @Autowired
//    private final ClienteUseCase clienteUseCase;
//    private final ClienteMapper clienteMapper;
//
//    public ClienteController(ClienteUseCase clienteUseCase, ClienteMapper clienteMapper) {
//        this.clienteUseCase = clienteUseCase;
//        this.clienteMapper = clienteMapper;
//    }
//
//
//    @PostMapping("/cadastrar")
//    public ResponseEntity<Object> cadastrarCliente(@RequestBody ClienteRequest req) {
//        try {
//            ClienteDTO response = clienteMapper.toResponse(clienteUseCase.salvarClienteComEndereco(req));
//            return ResponseEntity.status(HttpStatus.CREATED).body(response);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/listar")
//    public ResponseEntity<List<ClienteDTO>> listarClientes() {
//        try {
//            List<ClienteDTO> clientes = clienteUseCase.listarClientes().stream()
//                    .map(clienteMapper::toResponse)
//                    .collect(Collectors.toList());
//            return ResponseEntity.ok(clientes);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//}

