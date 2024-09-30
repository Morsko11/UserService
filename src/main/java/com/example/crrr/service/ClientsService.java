package com.example.crrr.service;

import com.example.crrr.dto.ClientsDTO;
import com.example.crrr.mapper.ClientsMapper;
import com.example.crrr.model.Clients;
import com.example.crrr.model.Group;
import com.example.crrr.repository.ClientsRepository;
import com.example.crrr.repository.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientsService {


    private ClientsRepository clientsRepository;

    private GroupRepository groupRepository;

    public ClientsDTO createClient(ClientsDTO clientsDTO) {
        Group group = groupRepository.findById(clientsDTO.getGroupId())
                .orElseThrow(() -> new RuntimeException("Group not found"));
        Clients client = ClientsMapper.toEntity(clientsDTO, group);
        Clients savedClient = clientsRepository.save(client);
        return ClientsMapper.toDTO(savedClient);
    }

    public List<ClientsDTO> getAllClients() {
        return clientsRepository.findAll().stream()
                .map(ClientsMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ClientsDTO getClientById(Integer id) {
        Clients client = clientsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        return ClientsMapper.toDTO(client);
    }

    public void deleteClient(Integer id) {
        clientsRepository.deleteById(id);
    }
}
