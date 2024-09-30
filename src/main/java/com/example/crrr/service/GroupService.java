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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public boolean addClient(Integer groupId, Integer clientId) {
        Optional<Group> byId1 = groupRepository.findById(groupId);
        Optional<Clients> byId = clientsRepository.findById(clientId);
        if (byId1.isPresent()){
            if (byId.isPresent()){
                Clients clients = byId.get();
                clients.setGroup(byId1.get());
                clientsRepository.save(clients);
                return true;
            }
        }
        return false;

    }
}
