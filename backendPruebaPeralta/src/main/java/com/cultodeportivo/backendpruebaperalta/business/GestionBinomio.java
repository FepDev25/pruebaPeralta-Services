package com.cultodeportivo.backendpruebaperalta.business;

import com.cultodeportivo.backendpruebaperalta.dao.BinomioDAO;
import com.cultodeportivo.backendpruebaperalta.models.Binomio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class GestionBinomio {

    @Inject
    private BinomioDAO binomioDAO;

    public List<Binomio> getBinomios() {
        return binomioDAO.getAllBinomios();
    };

    public Binomio getBinomio(Long id) {
        return binomioDAO.getBinomioById(id);
    }

    public void guardarBinomio(Binomio binomio) {
        binomioDAO.guardarBinomio(binomio);
    }

}
