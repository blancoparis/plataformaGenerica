package org.tfc.bom;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import org.tfc.EntityBD;



/**
 * 
 * @author David Blanco París
 *
 */
@Entity
public class Menu implements EntityBD<Long>{
	
	  public enum TipoMenu{RAIZ,GRUPO,FLUJO,ENLACE};
      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      private Long id;
     
      private String descripcion;
     
      @ManyToOne()
      private Flujo flujo;
     
      @ManyToOne
      private Menu padre;
     
      @OneToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE},orphanRemoval=false,mappedBy="padre")
      private Set<Menu> hijos;
     
      @Enumerated(EnumType.STRING)
      @Column(nullable=false)
      private TipoMenu tipo;
     
      private String url;

      public Long getId() {
                     return id;
      }

      public void setId(Long id) {
                     this.id = id;
      }

      public String getDescripcion() {
                     return descripcion;
      }

      public void setDescripcion(String descripcion) {
                     this.descripcion = descripcion;
      }

      public Flujo getFlujo() {
                     return flujo;
      }

      public void setFlujo(Flujo flujo) {
                     this.flujo = flujo;
      }

      public Set<Menu> getHijos() {
                     return hijos;
      }

      public void setHijos(Set<Menu> menu) {
                     this.hijos = menu;
      }



      public TipoMenu getTipo() {
                     return tipo;
      }

      public void setTipo(TipoMenu tipo) {
                     this.tipo = tipo;
      }

      public String getUrl() {
                     return url;
      }

      public void setUrl(String url) {
                     this.url = url;
      }

      public Menu getPadre() {
                     return padre;
      }

      public void setPadre(Menu padre) {
                     this.padre = padre;
      }
     
	
	
}
