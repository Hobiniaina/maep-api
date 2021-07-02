package mg.maep.api.services;

import java.util.List;

import mg.maep.api.models.Fokontany;

public interface FokontanyServices extends CRUDServices<Fokontany>{

	List<Object> prendListeFokontany();
}
