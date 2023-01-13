package com.pharmatunisie.pharmatunisie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pharmatunisie.pharmatunisie.repository.MedicamentDao;
import com.pharmatunisie.pharmatunisie.entity.MedicamentEntity;
import java.util.List;


@Service
public class MedicamentService implements Imedicament{
private  MedicamentDao medicamentDao;

	@Autowired
	public MedicamentService(MedicamentDao medicamentDao) {
		super();
		this.medicamentDao= medicamentDao;
	}

	@Override
	public List<MedicamentEntity> getAllMedicament() {
		List<MedicamentEntity>	x  = medicamentDao.findAll();
		return x;
	}

	@Override
	public MedicamentEntity createMedicament(MedicamentEntity medicament) {
		return medicamentDao.save(medicament);
	}

	@Override
	public MedicamentEntity updateMedicament(int id, MedicamentEntity medicamentRequest) {
		MedicamentEntity medicament = medicamentDao.findById(id)
				.orElseThrow();
			
		medicament.setNom_commercial(medicamentRequest.getNom_commercial());
		medicament.setDci(medicamentRequest.getDci());
		medicament.setDossage(medicamentRequest.getDossage());
		medicament.setNbre_stock(medicamentRequest.getNbre_stock());
		medicament.setPrix(medicamentRequest.getPrix());
		medicament.setPresentaion(medicamentRequest.getPresentaion());
			
		return medicamentDao.save(medicament);
	}

	@Override
	public void deleteMedicament(int id) {
		MedicamentEntity installation = medicamentDao.findById(id)
				.orElseThrow();
		
		medicamentDao.delete(installation);
	}

	@Override
	public MedicamentEntity getMedicamentById(int id) {
		MedicamentEntity result = medicamentDao.findById(id).orElseThrow();
		
			return result;
		
		

	}
}
