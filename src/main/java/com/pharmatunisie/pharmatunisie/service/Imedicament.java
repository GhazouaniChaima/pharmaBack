package com.pharmatunisie.pharmatunisie.service;
import com.pharmatunisie.pharmatunisie.entity.MedicamentEntity;
import java.util.List;

public interface Imedicament {
	
	List<MedicamentEntity> getAllMedicament();

	MedicamentEntity createMedicament(MedicamentEntity medicament);

	MedicamentEntity updateMedicament(int id, MedicamentEntity medicament);

	void deleteMedicament(int id);

	MedicamentEntity getMedicamentById(int id);
}
