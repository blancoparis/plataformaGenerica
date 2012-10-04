package org.tfc.controller.json;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tfc.EntityCombo;
import org.tfc.form.core.json.ElementoListaJsonForm;
import org.tfc.form.core.json.ListaFormJson;
import org.tfc.service.AbstractComboService;

public abstract class AbstractComboJsonController <T extends EntityCombo<Long>>{

	private AbstractComboService<T,Long> service;
	
	public AbstractComboJsonController() {
		super();
		
	}
	
	public enum TipoLista{
		NADA(false,false),
		BLANCO(true,false),
		ORDENACION(false,true),
		BLANCOORDENACION(true,true)
		;
		private Boolean isBlanco;
		private Boolean isOrdenado;
		private TipoLista(Boolean isBlanco, Boolean isOrdenado) {
			this.isBlanco = isBlanco;
			this.isOrdenado = isOrdenado;
		}
		
	}

	@RequestMapping("/json/{tipo}/lista")
	public @ResponseBody  ListaFormJson lista(@PathVariable TipoLista tipo) throws Exception{
		ListaFormJson json=new ListaFormJson();
		json.setElementos(new ArrayList<ElementoListaJsonForm>());
		ElementoListaJsonForm item = null;
		if(tipo.isBlanco){
			establecerValorBlanco(json);
		}
		if(tipo.isOrdenado){
			cargarElementos(json, this.getService().findAllOrder());
		}else{
			cargarElementos(json, this.getService().findAll());
		}
		return json;
	}
	/**
	 * Se encarga de cargar todos los elementos en el JSON.
	 * @param json
	 * @param elementos
	 */
	private void cargarElementos(ListaFormJson json, List<T> elementos) {
		ElementoListaJsonForm item;
		for(T elemento: elementos){
			item = new ElementoListaJsonForm();
			item.setId(elemento.getId());
			item.setDescripcion(elemento.getDescripcion());
			json.getElementos().add(item);
		}
	}
	/**
	 * Se encarga de establecer un elemento en blanco.
	 * @param json
	 */

	private void establecerValorBlanco(ListaFormJson json) {
		ElementoListaJsonForm item;
		item = new ElementoListaJsonForm();
		item.setId(-1L);
		item.setDescripcion("");
		json.getElementos().add(item);
	}
	
	public AbstractComboService<T, Long> getService() {
		return service;
	}

	public void setService(AbstractComboService<T, Long> service) {
		this.service = service;
	}

	
	
}