package com.example.crrr.service;

import com.example.crrr.BaseIT;
import com.example.crrr.model.Clients;
import com.example.crrr.model.Group;
import com.example.crrr.repository.ClientsRepository;
import com.example.crrr.repository.GroupRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

class GroupServiceTest extends BaseIT {

    @Autowired
    GroupService groupService;
//    @MockBean
    ClientsRepository clientsRepository;
//    @MockBean
//    GroupRepository groupRepository;
//
//    @BeforeEach
//    void setUp(){
//        Mockito.when(clientsRepository.findById(any())).thenReturn(Optional.of(new Clients(1, "test", LocalDate.now(), "test", null)));
//        Mockito.when(groupRepository.findById(any())).thenReturn(Optional.of(new Group(1, "Java", null, null, null)));
//    }

    @Test
    void addClient() {
        groupService.addClient(1L, 1L);



        Assertions.assertEquals(1, clientsRepository.findById(1L).get().getGroup().getId());
    }
}