package com.example.jointableinheritance.service;

import com.example.jointableinheritance.dao.ExternalVetDao;
import com.example.jointableinheritance.dao.InHouseVetDao;
import com.example.jointableinheritance.entity.External_Vet;
import com.example.jointableinheritance.entity.InHouse_Vet;
import com.example.jointableinheritance.entity.Vet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VetService {

    @Autowired
    private ExternalVetDao externalVetDao;

    @Autowired
    private InHouseVetDao inHouseVetDao;

    @Transactional
    public void saveVet() {

        InHouse_Vet inHouse_vet1 = new InHouse_Vet("Xiaoting", "Msc", 3400);
        InHouse_Vet inHouse_vet2 = new InHouse_Vet("Minjeong", "Msc", 2400);

        External_Vet exHouse_vet1 = new External_Vet("Gisselle", "Phd", "Japan", 230);
        External_Vet exHouse_vet2 = new External_Vet("Karina", "Phd", "Korea", 730);

        inHouseVetDao.save(inHouse_vet1);
        inHouseVetDao.save(inHouse_vet2);

        externalVetDao.save(exHouse_vet1);
        externalVetDao.save(exHouse_vet2);
    }

    public void findAllVets() {
        System.out.println("InHouse Vets--------------------");
        inHouseVetDao.findAll().forEach(System.out::println);

        System.out.println("ExHouse Vets----------------");

        externalVetDao.findAll().forEach(System.out::println);
    }


}
