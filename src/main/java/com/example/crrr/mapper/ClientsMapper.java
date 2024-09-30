package com.example.crrr.mapper;

import com.example.crrr.dto.ClientsDTO;
import com.example.crrr.model.Clients;
import com.example.crrr.model.Group;

public class ClientsMapper {
    public static ClientsDTO toDTO(Clients client) {
        ClientsDTO dto = new ClientsDTO();
        dto.setId(client.getId());
        dto.setName(client.getName());
        dto.setLastname(client.getLastname());
        dto.setDob(client.getDob());
        dto.setGroupId(client.getGroup().getId());
        return dto;
    }

    public static Clients toEntity(ClientsDTO dto, Group group) {
        Clients client = new Clients();
        client.setName(dto.getName());
        client.setLastname(dto.getLastname());
        client.setDob(dto.getDob());
        client.setGroup(group);
        return client;
    }
}
