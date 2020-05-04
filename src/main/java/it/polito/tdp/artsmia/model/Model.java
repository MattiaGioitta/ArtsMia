package it.polito.tdp.artsmia.model;

import java.util.HashMap;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.artsmia.db.ArtsmiaDAO;

public class Model {

	private Graph<ArtObject,DefaultWeightedEdge> grafo;
	private Map<Integer,ArtObject> idMap;
	
	public Model() {
		this.idMap = new HashMap<Integer, ArtObject>();
		
	}
	
	public void creaGrafo() {
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		ArtsmiaDAO dao = new ArtsmiaDAO();
		dao.listObjects(idMap);
		//Aggiungere i vertici
		Graphs.addAllVertices(this.grafo, idMap.values());
		
		//Aggiungo gli archi ai vertici
		//Approccio 1 -->doppio ciclo for su tutti vertici
		//dati due vertici controllo se collegati
		//non va bene ci vorrebbero giorni 
		/*for(ArtObject a1 : this.grafo.vertexSet()) {
			for(ArtObject a2: this.grafo.vertexSet()) {
				//devo collegare a1 e a2
				//controllo se non esiste l'arco
				int peso = dao.getPeso(a1,a2);
				if(peso>0) {
				if(!this.grafo.containsEdge(a1, a2)) {
					 
						Graphs.addEdge(this.grafo, a1, a2, peso);
				}
				
				}
			}
		}*/
		
		//Approccio 2
		//Mi faccio dare dal db tutte le adiacenze
		for(Adiacenza a : dao.getAdiacenze()) {
			if(a.getPeso()>0) {
				Graphs.addEdge(this.grafo, this.idMap.get(a.getObj1()), this.idMap.get(a.getObj2()), a.getPeso());
			}
			
		}
		
		System.out.format("Grafo con %d archi e %d vertici",this.grafo.edgeSet().size(), this.grafo.vertexSet().size());
		
	}
	
	public int nVertici() {
		return this.grafo.vertexSet().size();
	}
	public int nArchi() {
		return this.grafo.edgeSet().size();
	}
	
	
}
