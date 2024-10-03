package com.example.crrr.repository;

import com.example.crrr.BaseIT;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClientsRepositoryTest extends BaseIT {
    @Autowired
    ClientsRepository clientsRepository;


    @Test
    public void testFindAll() {
        assertEquals(2, clientsRepository.findAll().size());
    }
}