package com.cultodeportivo.backendpruebaperalta.dao;

import com.cultodeportivo.backendpruebaperalta.models.Binomio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@ApplicationScoped
public class BinomioDAO {

    @PersistenceContext(unitName = "com.cultodeportivoPersistenceUnit")
    private EntityManager em;

    public Binomio getBinomioById(Long id) {
        return em.find(Binomio.class, id);
    }

    public List<Binomio> getAllBinomios() {
        return em.createQuery("select b from Binomio b", Binomio.class).getResultList();
    }

    public void guardarBinomio(Binomio binomio) {
        em.persist(binomio);
        em.flush();
    }
}
