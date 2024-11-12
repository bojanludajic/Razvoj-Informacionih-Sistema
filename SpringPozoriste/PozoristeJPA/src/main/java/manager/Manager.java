package manager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.EntityManager;
import model.Glumac;
import model.GlumiUIzvodjenju;
import model.Izvodjenje;
import model.Karta;
import model.Predstava;
import model.Zanr;

public class Manager {
	
	public static List<Zanr> sviZanrovi() {
		EntityManager em = JPAUtils.getEntityManager();
		return em.createNamedQuery("Zanr.findAll", Zanr.class).getResultList();
	}

	public static List<Predstava> predstavePoZanru(int idZanr) {
		EntityManager em = JPAUtils.getEntityManager();
		List<Predstava> predstave = new ArrayList<>();
		predstave = em.createQuery("SELECT zp.predstava FROM ZanrPredstave zp WHERE zp.zanr.idZanr = :idZ", Predstava.class)
				.setParameter("idZ", idZanr)
				.getResultList();
		return predstave;
	}
	
	public static List<Karta> sveKarte() {
		EntityManager em = JPAUtils.getEntityManager();
		return em.createNamedQuery("Karta.findAll", Karta.class).getResultList();
	}
	
	public static List<Karta> filtriraneKarte(String datum) {
		return sveKarte().stream()
				.filter(k -> k.getDatumRezervacije().toString().equals(datum))
				.collect(Collectors.toList());
	}
	
	public static List<Izvodjenje> izvodjenjaPoNazivu(String nazivPredstave) {
		EntityManager em = JPAUtils.getEntityManager();
		try {
			List<Izvodjenje> izvodjenja = em.createQuery("SELECT i FROM Izvodjenje i "
					+ "WHERE i.predstava.naziv = :x", Izvodjenje.class)
					.setParameter("x", nazivPredstave)
					.getResultList();
			return izvodjenja;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public static List<Glumac> glumciUIzvodjenju(int idIzvodjenja) {
		EntityManager em = JPAUtils.getEntityManager();
		try {
			List<Glumac> glumci = em.createQuery("SELECT g from Glumac g "
					+ "INNER JOIN g.glumis gl INNER JOIN gl.glumiUizvodjenjus gi "
					+ "WHERE gi.izvodjenje.idIzvodjenje = :x", Glumac.class)
					.setParameter("x", idIzvodjenja)
					.getResultList();
			return glumci;
			
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	// main za debagovanje upita
	public static void main(String[] args) {
		for(int i = 0; i < glumciUIzvodjenju(1).size(); i++) {
			System.out.println(glumciUIzvodjenju(1).get(i).getIme());
		}
	}

	
	
}
