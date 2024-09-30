package com.example.crrr.mapper;

import com.example.crrr.dto.GroupDTO;
import com.example.crrr.model.Clients;
import com.example.crrr.model.Course;
import com.example.crrr.model.Group;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GroupMapper {

    // Преобразование сущности Group в DTO
    public static GroupDTO toDTO(Group group) {
        GroupDTO dto = new GroupDTO();
        dto.setId(group.getId());
        dto.setTitle(group.getTitle());
        dto.setCourseId(group.getCourse() != null ? group.getCourse().getId() : null); // Безопасная проверка на null

        // Маппинг списка клиентов
        if (group.getClients() != null) {
            dto.setClientIds(
                    group.getClients().stream()
                            .map(Clients::getId)
                            .collect(Collectors.toList())
            );
        }

        return dto;
    }

    // Преобразование DTO в сущность Group
    public static Group toEntity(GroupDTO dto, Course course) {
        Group group = new Group();
        group.setTitle(dto.getTitle());
        group.setCourse(course);

        // Преобразование DTO в сущность без циклических зависимостей
        if (dto.getClientIds() != null && !dto.getClientIds().isEmpty()) {
            List<Clients> clients = new ArrayList<>();
            for (Integer clientId : dto.getClientIds()) {
                Clients client = new Clients();
                client.setId(clientId);
                clients.add(client);
            }
            group.setClients(clients);
        }

        return group;
    }
}

