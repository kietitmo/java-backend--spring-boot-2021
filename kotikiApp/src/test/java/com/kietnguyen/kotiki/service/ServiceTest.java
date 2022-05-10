package com.kietnguyen.kotiki.service;

import com.kietnguyen.models.Cat;
import com.kietnguyen.models.CatAndFriend;
import com.kietnguyen.models.Owner;
import com.kietnguyen.repositories.CatAndFriendRepository;
import com.kietnguyen.repositories.CatRepository;
import com.kietnguyen.repositories.OwnerRepository;
import com.kietnguyen.services.impl.CatServiceImpl;
import com.kietnguyen.services.impl.OwnerServiceImpl;
import com.kietnguyen.services.tools.ServicesException;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@Ignore
public class ServiceTest {
    @InjectMocks
    @Autowired
    private CatServiceImpl catService;

    @InjectMocks
    @Autowired
    private OwnerServiceImpl ownerService;

    @MockBean
    private CatRepository catRepository;

    @MockBean
    private OwnerRepository ownerRepository;

    @MockBean
    private CatAndFriendRepository catAndFriendRepository;

    @Test
    public void addCat_successful() throws ServicesException {
        Assertions.assertTrue(catService.add(new Cat()));
    }

    @Test
    public void getCat_successful() throws ServicesException {
        Cat cat = new Cat();
        when(catRepository.getById(1)).thenReturn(cat);
        Cat catExists = catService.get(1);
        Assertions.assertEquals(catExists, cat);
    }

    @Test
    public void addCatAndFriend_successful() throws ServicesException {
            Assertions.assertTrue(catService.addCatAndFriend(new CatAndFriend(new Cat(), new Cat())));
    }

    @Test
    public void removeCat_successful() throws ServicesException {
        Cat cat = new Cat();
        Assertions.assertTrue(catService.delete(cat.getId()));
    }

    @Test
    public void removeAllFriendsOfCat_successful() throws ServicesException {
        boolean isDeleted = catService.deleteAllFriendOfCat(new Cat().getId());
        Assertions.assertTrue(isDeleted);
    }

    @Test
    public void removeFriendOfCat_successful() throws ServicesException {

        boolean isDeleted = catService.deleteFriendOfCat(new Cat().getId(), new Cat().getId());
        Assertions.assertTrue(isDeleted);
    }

    @Test
    public void updateCat_successful() throws ServicesException {
        Cat cat = new Cat();
        when(catRepository.save(cat)).thenReturn(cat);
        boolean isUpdated = catService.update(cat);
        Assertions.assertTrue(isUpdated);
    }

    @Test
    public void getAllCats_successful() throws ServicesException {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        when(catRepository.findAll()).thenReturn(Arrays.asList(cat1,cat2));
        Assertions.assertEquals(catService.getAll(), Arrays.asList(cat1,cat2));
    }

    @Test
    public void addOwner_successful() throws ServicesException {
        Assertions.assertTrue(ownerService.add(new Owner()));
    }

    @Test
    public void getOwner_successful() throws ServicesException {
        Owner owner = new Owner();
        when(ownerRepository.getById(1)).thenReturn(owner);
        Owner ownerExist = ownerService.get(1);
        Assertions.assertEquals(ownerExist, owner);
    }

    @Test
    public void getAllOwner_successful() throws ServicesException {
        Owner owner1 = new Owner();
        Owner owner2 = new Owner();
        when(ownerRepository.findAll()).thenReturn(Arrays.asList(owner1,owner2));
        Assertions.assertEquals(ownerService.getAll(), Arrays.asList(owner1,owner2));
    }

    @Test
    public void removeOwner_successful() throws ServicesException {
        Owner owner = new Owner();
        Assertions.assertTrue(catService.delete(owner.getId()));
    }

    @Test
    public void updateOwner_successful() throws ServicesException {
        Owner owner = new Owner();
        when(ownerRepository.save(owner)).thenReturn(owner);
        boolean isUpdated = ownerService.update(owner);
        Assertions.assertTrue(isUpdated);
    }
}
