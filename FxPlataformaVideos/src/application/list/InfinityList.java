package application.list;

public class InfinityList<T> {
private T valor;
	
	private InfinityList<T> proximo;
	
	private InfinityList<T> anterior;
	
	private int index;
	
	public InfinityList() {
	}
	
	public InfinityList(T valor) {
		this.valor = valor;
	}
	
	public T getValor() {
		return valor;
	}
	
	public void setValor(T valor) {
		this.valor = valor;
	}
		
	public void addNovo(T valor) {
		if(valor == null) {
			this.valor = valor;
		} else {
			if (proximo == null) {
				proximo = new InfinityList<T>();
				proximo.setValor(valor);
				proximo.setAnterior(this);
			} else {
				proximo.addNovo(valor);
			}
		}
	}
	
	public InfinityList<T> getProximo() {
		return proximo;
	}
	
	public void setProximo(InfinityList<T> proximo) {
		this.proximo = proximo;
	}

	public InfinityList<T> getAnterior() {
		return anterior;
	}

	public void setAnterior(InfinityList<T> anterior) {
		this.anterior = anterior;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
