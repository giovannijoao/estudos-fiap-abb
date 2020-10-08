package ABB;

public class ABBint {

	private class ARVORE {
		int dado;
		ARVORE dir, esq;
		int hEsq, hDir;
	}

	public ARVORE root = null;

	public ARVORE inserir(ARVORE p, int info) {
		// insere elemento em uma ABB
		if (p == null) {
			p = new ARVORE();
			p.dado = info;
			p.esq = null;
			p.dir = null;
			p.hEsq = 0;
			p.hDir = 0;
		} else if (info < p.dado) {
			p.esq = inserir(p.esq, info);
			if (p.esq.hDir > p.esq.hEsq) {
				p.hEsq = p.esq.hDir + 1;
			} else {
				p.hEsq = p.esq.hEsq + 1;
			}
		}
		else {
			p.dir = inserir(p.dir, info);
			if (p.dir.hDir > p.dir.hEsq) {
				p.hDir = p.dir.hDir + 1;
			} else {
				p.hDir = p.dir.hEsq + 1;
			}
		}
		return p;
	}

	public void inOrdem(ARVORE p) {
		if (p != null) {
			if (p.esq != null)
				inOrdem(p.esq);
			System.out.println("dado: " + p.dado);
			if (p.dir != null)
				inOrdem(p.dir);
		}
	}
	

	public int contaNos(ARVORE p, int total) {
		if (p == null) return 0;
		if (p.esq != null) total = contaNos(p.esq, total);			
		if (p.dir != null) total = contaNos(p.dir, total);
		total += 1;
		return total;
	}
	
	public int contaNosSe(ARVORE p, int total, int dado) {
		if (p == null) return 0;
		if (p.esq != null) total = contaNosSe(p.esq, total, dado);			
		if (p.dir != null) total = contaNosSe(p.dir, total, dado);
		if (p.dado == dado) total += 1;
		return total;
	}
	
	public boolean consulta(ARVORE p, int dado) {
		if (p == null) return false;
		if (dado == p.dado) return true;
		if (dado < p.dado)
			return consulta(p.esq, dado);
		else
			return consulta(p.dir, dado);
	}
	
	public ARVORE removerValor(ARVORE p, int info) {
		if (p != null) {
			if (info == p.dado) {
				if (p.esq == null && p.dir == null) return null;
				else if (p.esq == null) return p.dir;
				else if (p.dir == null) return p.esq;
				else {
					ARVORE aux, ref;
					ref = p.dir;
					aux = p.dir;
					while (aux.esq != null) aux = aux.esq;
					aux.esq = p.esq;
					return ref;					
				}
			}
			else {
				if (info < p.dado) p.esq = removerValor(p.esq, info);
				else p.dir = removerValor(p.dir, info);	
			}		
		}
		return p;
	}
	
	public int maximo(ARVORE p) {
		ARVORE aux = p;
		while (aux.esq != null) {
			aux = aux.esq;
		}
		return aux.dado;
	}
	
	public int minimo(ARVORE p) {
		ARVORE aux = p;		
		while (aux.dir != null) {
			aux = aux.dir;
		}
		return aux.dado;
	}
	
	public void posOrdem(ARVORE p) {
		if (p != null) {
			if (p.esq != null)
				inOrdem(p.esq);
			if (p.dir != null)
				inOrdem(p.dir);
			System.out.println("dado: " + p.dado);			
		}
	}
	
	public void mostraFB(ARVORE p) {
		if (p != null) {
			if (p.esq != null)
				mostraFB(p.esq);
			if (p.dir != null)
				mostraFB(p.dir);
			System.out.println("FB (nó: " + p.dado + "): " + (p.hDir - p.hEsq));			
		}
	}

}
