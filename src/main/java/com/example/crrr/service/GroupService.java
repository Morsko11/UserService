package com.example.crrr.service;

import com.example.crrr.dto.GroupDTO;
import com.example.crrr.mapper.GroupMapper;
import com.example.crrr.model.Clients;
import com.example.crrr.model.Course;
import com.example.crrr.model.Group;
import com.example.crrr.repository.ClientsRepository;
import com.example.crrr.repository.CourseRepository;
import com.example.crrr.repository.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GroupService {


    private GroupRepository groupRepository;

    private CourseRepository courseRepository;
    private ClientsRepository clientsRepository;

    public GroupDTO createGroup(GroupDTO groupDTO) {
        Course course = courseRepository.findById(groupDTO.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Group group = GroupMapper.toEntity(groupDTO, course);
        Group savedGroup = groupRepository.save(group);
        return GroupMapper.toDTO(savedGroup);
    }

    public List<GroupDTO> getAllGroups() {
        return groupRepository.findAll().stream()
                .map(GroupMapper::toDTO)
                .collect(Collectors.toList());
    }

    public GroupDTO getGroupById(Integer id) {
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Group not found"));
        return GroupMapper.toDTO(group);
    }

    public void deleteGroup(Integer id) {
        groupRepository.deleteById(id);
    }

    @Transactional
    public boolean addClient(Integer groupId, Integer clientId) {
        Optional<Group> optionalGroup = groupRepository.findById(groupId);
        Optional<Clients> clientsOptional = clientsRepository.findById(clientId);
        optionalGroup.ifPresent(group -> clientsOptional.ifPresent(client -> {
            client.setGroup(group);
            clientsRepository.save(client);
        }));
        return true;
    }
}
