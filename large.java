package es.juntadeandalucia.ingresos.sur.forms.J000810.services;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;
import org.jdesktop.databuffer.DataRow.DataRowStatus;

import morphis.foundations.core.appdatalayer.*;
import morphis.foundations.core.appdatalayer.data.*;
import morphis.foundations.core.appdatalayer.events.*;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.*;

import morphis.foundations.core.appsupportlib.exceptions.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.core.appsupportlib.util.*;
import morphis.foundations.core.appsupportlib.runtime.*;
import morphis.foundations.core.appsupportlib.runtime.control.*;
import morphis.foundations.core.appsupportlib.runtime.events.*;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import morphis.foundations.core.appsupportlib.runtime.controlsModel.*;
import morphis.foundations.core.appsupportlib.runtime.controlsModel.items.*;
import morphis.foundations.core.appsupportlib.runtime.controlsModel.lovs.*;
import morphis.foundations.core.appsupportlib.runtime.controlsModel.containers.*;

import morphis.foundations.core.appsupportlib.runtime.controlsModel.alerts.*;
import static morphis.foundations.core.appsupportlib.runtime.TaskServices.*;
import static morphis.foundations.core.appsupportlib.runtime.ItemServices.*;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.*;
import static morphis.foundations.core.appsupportlib.runtime.ViewServices.*;
import static morphis.foundations.core.appsupportlib.runtime.MessageServices.*;
import static morphis.foundations.core.appsupportlib.runtime.ValueSetServices.*;
import static morphis.foundations.core.appsupportlib.runtime.LovServices.*;
import static morphis.foundations.core.appsupportlib.runtime.ListServices.*;
import static morphis.foundations.core.appsupportlib.runtime.TreeServices.*;

import morphis.foundations.flavors.forms.appsupportlib.runtime.*;

import static morphis.foundations.core.appsupportlib.Math.*;
import static morphis.foundations.core.appsupportlib.Lib.*;
import static es.juntadeandalucia.ingresos.sur.commons.Globals.*;
import static morphis.foundations.core.types.Types.*;
import morphis.foundations.core.util.*;
import morphis.foundations.flavors.forms.appsupportlib.runtime.*;


import es.juntadeandalucia.ingresos.sur.forms.J000810.*;

import es.juntadeandalucia.ingresos.sur.commons.*;

import es.juntadeandalucia.ingresos.sur.commons.dbservices.K000810;
import es.juntadeandalucia.ingresos.sur.commons.dbservices.K03datex;
import es.juntadeandalucia.ingresos.sur.commons.dbservices.K03util;
import es.juntadeandalucia.ingresos.sur.commons.dbservices.Kfirma;
import es.juntadeandalucia.ingresos.sur.commons.dbservices.Kfirma.TrFirmaRow;
import es.juntadeandalucia.ingresos.sur.commons.dbservices.Kgenrep;
import es.juntadeandalucia.ingresos.sur.commons.dbservices.Kgenrep.TaDatosMarcadorRow;
import es.juntadeandalucia.ingresos.sur.commons.dbservices.Kintcomu;
import es.juntadeandalucia.ingresos.sur.commons.dbservices.Kparplan;
import es.juntadeandalucia.ingresos.sur.commons.dbservices.Kusuari;
import es.juntadeandalucia.ingresos.sur.commons.dbservices.Kvisordoc;
import es.juntadeandalucia.ingresos.sur.commons.dbservices.StoredProcedures;
import es.juntadeandalucia.ingresos.sur.commons.dbtypes.*;
import es.juntadeandalucia.ingresos.sur.commons.forms.surbase.services.SurBaseServices;
import es.juntadeandalucia.ingresos.sur.libraries.Webutil.*;
import es.juntadeandalucia.ingresos.sur.libraries.Sur.*;
import es.juntadeandalucia.ingresos.sur.libraries.Surimp.*;
import es.juntadeandalucia.ingresos.sur.forms.J000810.model.*;
import es.juntadeandalucia.ingresos.sur.forms.J000810.services.Exceptions.EBorraTemporal;
import es.juntadeandalucia.ingresos.sur.forms.J000810.services.Exceptions.ECargaTemporal;
import es.juntadeandalucia.ingresos.sur.forms.J000810.services.Exceptions.EDocumento;
import es.juntadeandalucia.ingresos.sur.forms.J000810.services.Exceptions.EError;
import es.juntadeandalucia.ingresos.sur.forms.J000810.services.Exceptions.EFirma;
import es.juntadeandalucia.ingresos.sur.forms.J000810.services.Exceptions.EGeneraPdf;
import es.juntadeandalucia.ingresos.sur.forms.J000810.services.Exceptions.EInsertaFirma;
import es.juntadeandalucia.ingresos.sur.forms.J000810.services.Exceptions.EPdf;
import es.juntadeandalucia.ingresos.sur.forms.J000810.services.Exceptions.EPreview;
import es.juntadeandalucia.ingresos.sur.commons.dbservices.Kfirexc;
import es.juntadeandalucia.ingresos.sur.commons.dbservices.Kgenctrl;
import es.juntadeandalucia.ingresos.sur.commons.dbservices.Kliquida;
import es.juntadeandalucia.ingresos.sur.commons.dbservices.Kgesclie;




public class J000810Services extends SurBaseServices{
	
	
	public J000810Services(ISupportCodeContainer container) {
		super(container);
	}
	
	public J000810Task  getTask() {
		return (J000810Task )super.getContainer();
	}

	
	public es.juntadeandalucia.ingresos.sur.forms.J000810.model.J000810Model getFormModel() {
		return getTask().getModel();
	}

	/* Original PL/SQL code for Prog Unit MOSTRAR_MENSAJE
	
	procedure MOSTRAR_MENSAJE (
errc in varchar2,       
errt in VARCHAR2,       
rftf in boolean         
) is


begin
  qms$show_message(errc,errt,rftf);
end;
	*/
	//ID:360
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		* @param errc
		* @param errt
		* @param rftf
		*/
		public void mostrarMensaje(NString errc, NString errt, NBool rftf)
		{
			getTask().getSurimp().qmsShowMessage(errc, errt, rftf);
		}

	
	/* Original PL/SQL code for Prog Unit COLOREA_CAMPOS
	
	<multilinecomment> COLOREA_CAMPOS
** Procedimiento para asignar a cada item de un bloque el atributo visual
** correspondiente, en función del estado del sistema y de sus propiedades:
**
**      Campos de contexto del registro actual resaltados
**      Campos que son de query resaltados en modo ENTER-QUERY
**      Campos no modificables apagados (salvo que sean de contexto)
**
** Los atributos visuales que se emplean son
**
**            CAMPO_DE_CONTEXTO (caracteres en BLANCO, fondo AZUL)
**            CAMPO_NO_CUERI    (caracteres en NEGRO , fondo GRIS)
**            CAMPO_NO_UPDATE   (caracteres en NEGRO , fondo GRIS)
**
** Los campos que sean de contexto en los bloques con overflow right o below
** deben indicarse en la lista correspondiente (ver comentarios en el código)
**
**
</multilinecomment>
PROCEDURE colorea_campos IS
   bloque varchar2(50);
   primer_campo varchar2 (50);
   campo_actual varchar2(50);
   id_campo item;
BEGIN
bloque := name_in('SYSTEM.TRIGGER_BLOCK');
primer_campo := get_block_property(bloque,first_item);
campo_actual := primer_campo;
while campo_actual is not null loop
   id_campo:=find_item(bloque||'.'||campo_actual);
   if get_item_property(id_campo,displayed)='TRUE'
    and get_item_property(id_campo,item_type) in
        ('CHECK BOX','LIST','RADIO GROUP','TEXT ITEM')
    then
<multilinecomment>
**   Este if controla el atributo visual de los campos de contexto, esto es,
**   resalta la fila en la que nos encontramos en los bloques multirow.
**   Por cada campo de contexto AÑADIR SU NOMBRE EN MAYUSCULAS dentro
**   de la lista  IN ( 'Mi_campo_de_contexto_1' , '...') .
**   Si no hay campos de contexto borrar el if completo que se encuentra
**   entre las marcas PRINCIPIO Y FIN
** </multilinecomment>
<multilinecomment> *** PRINCIPIO ******************************************************* </multilinecomment>

       IF campo_actual IN ('NOMMARCA_MIRROR','VALOR_MIRROR'
       	                  , 'NIFCLIEN', 'NOMFIRTE', 'CARGO', 'ORDFIRMA'
       	                  , 'NIFCLIEN_SUS', 'NOMFIRTE_SUS', 'CARGO_SUS'
       	                  ) 
       THEN
           set_item_property(id_campo,current_record_attribute,'CAMPO_DE_CONTEXTO');
       END IF;

       if campo_actual in ('TEXLINEA_MIRROR','TEXLINEA','TEXLINEA_MARCADOR_ORIGEN') THEN
        set_item_property(id_campo,current_record_attribute,'CAMPO_DE_CONTEXTO2');
       end if;

<multilinecomment> *** FIN ************************************************************* </multilinecomment>


<multilinecomment> De aquí en adelante NO SE DEBE TOCAR </multilinecomment>

       if get_item_property(id_campo,current_record_attribute) =
          'CAMPO_NO_UPDATE' or
          get_item_property(id_campo,current_record_attribute) =
          'CAMPO_NO_CUERI' then
          if get_item_property(id_campo,item_type)='RADIO GROUP' then
            set_item_property
             (id_campo,current_record_attribute,'CG$MANDATORY_RADIO_BUTTON');
          elsif get_item_property(id_campo,item_type)='CHECK BOX' then
            set_item_property
             (id_campo,current_record_attribute,'CG$MANDATORY_CHECK_BOX');
          else
            set_item_property (id_campo,current_record_attribute,'CG$ITEM');
          end if;
       end if;
       if get_item_property(id_campo,insert_allowed)='FALSE'
          and name_in('SYSTEM.MODE')='NORMAL'
          and (:system.record_status = 'NEW'
           or :system.record_status = 'INSERT')
          and get_item_property(id_campo,current_record_attribute)
              not in  ( 'CAMPO_DE_CONTEXTO' , 'CAMPO_DE_CONTEXTO2')
       then
        set_item_property (id_campo,current_record_attribute,'CAMPO_NO_UPDATE');
       end if;

       if get_item_property(id_campo,queryable)='FALSE'
          and name_in('SYSTEM.MODE')='ENTER-QUERY'
          and get_item_property(id_campo,current_record_attribute)
              not in  ( 'CAMPO_DE_CONTEXTO' , 'CAMPO_DE_CONTEXTO2')
       then
        set_item_property (id_campo,current_record_attribute,'CAMPO_NO_CUERI');
       end if;
       if get_item_property(id_campo,updateable)='FALSE'
          and name_in('SYSTEM.MODE')='NORMAL'
          and get_item_property(id_campo,current_record_attribute)
              not in  ( 'CAMPO_DE_CONTEXTO' , 'CAMPO_DE_CONTEXTO2')
       then
        IF :system.record_status = 'NEW' or :system.record_status = 'INSERT'
          then
            null;
        else
        set_item_property (id_campo,current_record_attribute,'CAMPO_NO_UPDATE');
        end if;

    end if;
    end if;
    campo_actual:=get_item_property(id_campo,nextitem);
    end loop;
END;
	*/
	//ID:361
	/* <p>
		*  COLOREA_CAMPOS
		* ** Procedimiento para asignar a cada item de un bloque el atributo visual
		* ** correspondiente, en función del estado del sistema y de sus propiedades:
		* **
		* **      Campos de contexto del registro actual resaltados
		* **      Campos que son de query resaltados en modo ENTER-QUERY
		* **      Campos no modificables apagados (salvo que sean de contexto)
		* **
		* ** Los atributos visuales que se emplean son
		* **
		* **            CAMPO_DE_CONTEXTO (caracteres en BLANCO, fondo AZUL)
		* **            CAMPO_NO_CUERI    (caracteres en NEGRO , fondo GRIS)
		* **            CAMPO_NO_UPDATE   (caracteres en NEGRO , fondo GRIS)
		* **
		* ** Los campos que sean de contexto en los bloques con overflow right o below
		* ** deben indicarse en la lista correspondiente (ver comentarios en el código)
		* **
		* **
/* </p>
		*/
		public void coloreaCampos()
		{
			NString bloque = NString.getNull();
			NString primerCampo = NString.getNull();
			NString campoActual = NString.getNull();
			ItemDescriptor idCampo = null;
			bloque = getTriggerBlock();
			primerCampo = getBlockFirstItem(bloque);
			campoActual = primerCampo;
			while ( campoActual.isNotNull() ) {
				idCampo = findItem(bloque.append(".").append(campoActual));
				// F2J_TODO : Check if the function used in the expression below may be called more than once. See documentation for details.
				if ( getItemVisible(idCampo).equals("TRUE") && in(getItemType(idCampo), "CHECK BOX", "LIST", "RADIO GROUP", "TEXT ITEM").getValue() )
				{
					// **   Este if controla el atributo visual de los campos de contexto, esto es,
					// **   resalta la fila en la que nos encontramos en los bloques multirow.
					// **   Por cada campo de contexto AÑADIR SU NOMBRE EN MAYUSCULAS dentro
					// **   de la lista  IN ( 'Mi_campo_de_contexto_1' , '...') .
					// **   Si no hay campos de contexto borrar el if completo que se encuentra
					// **   entre las marcas PRINCIPIO Y FIN
					// ** 
					//  *** PRINCIPIO ******************************************************* 
					if ( in(campoActual, "NOMMARCA_MIRROR", "VALOR_MIRROR", "NIFCLIEN", "NOMFIRTE", "CARGO", "ORDFIRMA", "NIFCLIEN_SUS", "NOMFIRTE_SUS", "CARGO_SUS").getValue() )
					{
						// F2J_NOT_SUPPORTED : The property "ITEM's CURRENT_RECORD_ATTRIBUTE" is not supported. See documentation for details.
						//						SupportClasses.FORMS40.SetItemProperty(idCampo, SupportClasses.Property.CURRENT_RECORD_ATTRIBUTE, "CAMPO_DE_CONTEXTO");
						this.getLogger().trace(this, "// F2J_NOT_SUPPORTED : The property 'ITEM's CURRENT_RECORD_ATTRIBUTE' is not supported. See documentation for details.");
						
					}
					if ( in(campoActual, "TEXLINEA_MIRROR", "TEXLINEA", "TEXLINEA_MARCADOR_ORIGEN").getValue() )
					{
						// F2J_NOT_SUPPORTED : The property "ITEM's CURRENT_RECORD_ATTRIBUTE" is not supported. See documentation for details.
						//						SupportClasses.FORMS40.SetItemProperty(idCampo, SupportClasses.Property.CURRENT_RECORD_ATTRIBUTE, "CAMPO_DE_CONTEXTO2");
						this.getLogger().trace(this, "// F2J_NOT_SUPPORTED : The property 'ITEM's CURRENT_RECORD_ATTRIBUTE' is not supported. See documentation for details.");
						
					}
					//  *** FIN ************************************************************* 
					//  De aquí en adelante NO SE DEBE TOCAR 



















































//					if ( SupportClasses.FORMS40.GetItemProperty(idCampo, SupportClasses.Property.CURRENT_RECORD_ATTRIBUTE).equals("CAMPO_NO_UPDATE") || SupportClasses.FORMS40.GetItemProperty(idCampo, SupportClasses.Property.CURRENT_RECORD_ATTRIBUTE).equals("CAMPO_NO_CUERI") )
//					{
						// F2N_TODO: The above condition uses unsupported features. You should eliminate all references to SupportClasses.
						if ( getItemType(idCampo).equals("RADIO GROUP") )
						{
							// F2J_NOT_SUPPORTED : The property "ITEM's CURRENT_RECORD_ATTRIBUTE" is not supported. See documentation for details.
							//							SupportClasses.FORMS40.SetItemProperty(idCampo, SupportClasses.Property.CURRENT_RECORD_ATTRIBUTE, "CG$MANDATORY_RADIO_BUTTON");
							this.getLogger().trace(this, "// F2J_NOT_SUPPORTED : The property 'ITEM's CURRENT_RECORD_ATTRIBUTE' is not supported. See documentation for details.");
							
						}
						else if ( getItemType(idCampo).equals("CHECK BOX") ) {
							// F2J_NOT_SUPPORTED : The property "ITEM's CURRENT_RECORD_ATTRIBUTE" is not supported. See documentation for details.
							//							SupportClasses.FORMS40.SetItemProperty(idCampo, SupportClasses.Property.CURRENT_RECORD_ATTRIBUTE, "CG$MANDATORY_CHECK_BOX");
							this.getLogger().trace(this, "// F2J_NOT_SUPPORTED : The property 'ITEM's CURRENT_RECORD_ATTRIBUTE' is not supported. See documentation for details.");
							
						}
						else {
							// F2J_NOT_SUPPORTED : The property "ITEM's CURRENT_RECORD_ATTRIBUTE" is not supported. See documentation for details.
							//							SupportClasses.FORMS40.SetItemProperty(idCampo, SupportClasses.Property.CURRENT_RECORD_ATTRIBUTE, "CG$ITEM");
							this.getLogger().trace(this, "// F2J_NOT_SUPPORTED : The property 'ITEM's CURRENT_RECORD_ATTRIBUTE' is not supported. See documentation for details.");
							
						}







//					}
					// F2J_TODO : Check if the function used in the expression below may be called more than once. See documentation for details.
					// F2J_WARNING : The built-in  call was converted but there can be semantic differences in the resulting code.


//					if ( getItemInsertAllowed(idCampo).equals("FALSE") && getMode().equals("NORMAL") && (getRecordStatus().equals("NEW") || getRecordStatus().equals("INSERT")) && notIn(SupportClasses.FORMS40.GetItemProperty(idCampo, SupportClasses.Property.CURRENT_RECORD_ATTRIBUTE), "CAMPO_DE_CONTEXTO", "CAMPO_DE_CONTEXTO2").getValue() )
//					{
						// F2N_TODO: The above condition uses unsupported features. You should eliminate all references to SupportClasses.
						// F2J_NOT_SUPPORTED : The property "ITEM's CURRENT_RECORD_ATTRIBUTE" is not supported. See documentation for details.
						//						SupportClasses.FORMS40.SetItemProperty(idCampo, SupportClasses.Property.CURRENT_RECORD_ATTRIBUTE, "CAMPO_NO_UPDATE");



//						this.getLogger().trace(this, "// F2J_NOT_SUPPORTED : The property 'ITEM's CURRENT_RECORD_ATTRIBUTE' is not supported. See documentation for details.");
						
//					}
					// F2J_TODO : Check if the function used in the expression below may be called more than once. See documentation for details.

//					if ( getItemQueryAllowed(idCampo).equals("FALSE") && getMode().equals("ENTER-QUERY") && notIn(SupportClasses.FORMS40.GetItemProperty(idCampo, SupportClasses.Property.CURRENT_RECORD_ATTRIBUTE), "CAMPO_DE_CONTEXTO", "CAMPO_DE_CONTEXTO2").getValue() )
//					{
						// F2N_TODO: The above condition uses unsupported features. You should eliminate all references to SupportClasses.
						// F2J_NOT_SUPPORTED : The property "ITEM's CURRENT_RECORD_ATTRIBUTE" is not supported. See documentation for details.
						//						SupportClasses.FORMS40.SetItemProperty(idCampo, SupportClasses.Property.CURRENT_RECORD_ATTRIBUTE, "CAMPO_NO_CUERI");



//						this.getLogger().trace(this, "// F2J_NOT_SUPPORTED : The property 'ITEM's CURRENT_RECORD_ATTRIBUTE' is not supported. See documentation for details.");
						
//					}
					// F2J_TODO : Check if the function used in the expression below may be called more than once. See documentation for details.

//					if ( getItemUpdateAllowed(idCampo).equals("FALSE") && getMode().equals("NORMAL") && notIn(SupportClasses.FORMS40.GetItemProperty(idCampo, SupportClasses.Property.CURRENT_RECORD_ATTRIBUTE), "CAMPO_DE_CONTEXTO", "CAMPO_DE_CONTEXTO2").getValue() )
//					{
						// F2N_TODO: The above condition uses unsupported features. You should eliminate all references to SupportClasses.
						// F2J_WARNING : The built-in  call was converted but there can be semantic differences in the resulting code.
						if ( getRecordStatus().equals("NEW") || getRecordStatus().equals("INSERT") )
						{
						}
						else {
							// F2J_NOT_SUPPORTED : The property "ITEM's CURRENT_RECORD_ATTRIBUTE" is not supported. See documentation for details.
							//							SupportClasses.FORMS40.SetItemProperty(idCampo, SupportClasses.Property.CURRENT_RECORD_ATTRIBUTE, "CAMPO_NO_UPDATE");
							this.getLogger().trace(this, "// F2J_NOT_SUPPORTED : The property 'ITEM's CURRENT_RECORD_ATTRIBUTE' is not supported. See documentation for details.");
							
						}
//					}

				}
				campoActual = toStr(getItemNextItem(idCampo));
			}

		}


	
	/* Original PL/SQL code for Prog Unit SELEC_ACCION
	
	<multilinecomment> PROCEDIMIENTO QUE REALIZA LA OPCION SELECCIONADA EN EL TEXT_LIST </multilinecomment>
<multilinecomment> QUE APARECE AL PULSAR LA TECLA MAS </multilinecomment>
PROCEDURE SELEC_ACCION IS
BEGIN
<multilinecomment> Aqui ponemos tantos if como opciones tengamos en la lista, </multilinecomment>
<multilinecomment> para salir volveremos a pulsar la tecla MAS.               </multilinecomment>
<multilinecomment> la estructura a seguir es la siguiente:                    </multilinecomment>

<multilinecomment> Ejemplo de llamada a otro form </multilinecomment>
   IF :BLOQUE_ACCIONES.ACCIONES = 'CONSULTA' THEN
      BEGIN
         HIDE_WINDOW('WINDOW1');
         <multilinecomment> Antes de llamar al form hay que realizar el tratamiento </multilinecomment>
         <multilinecomment> necesario de variables globales o parametros </multilinecomment>

         <multilinecomment> Codigo de la accion a realizar para cada opcion </multilinecomment>
	  CALL_FORM('m000999',NO_HIDE,DO_REPLACE);
      END;

<multilinecomment> Ejemplo de ir a otro bloque </multilinecomment>
   ELSIF :BLOQUE_ACCIONES.ACCIONES ='ACC_2' THEN
      BEGIN
         <multilinecomment> Antes de ocultar la lista hay que irse a otro bloque </multilinecomment>
         GO_BLOCK('MI_BLOQUE');
         <multilinecomment> Después de elegir una opcion hay se oculta la lista </multilinecomment>
         HIDE_VIEW('MOSTRAR_ACCIONES');
         <multilinecomment> Codigo de la accion a realizar para cada opcion </multilinecomment>
         -- ACCION_A_REALIZAR3;
      END;
   END IF;
<multilinecomment> Opcion de salir que siempre debe existir </multilinecomment>
<multilinecomment> y siempre se ejecuta (para cualquier opcion) </multilinecomment>
-- Salir de opciones del bloque ACCIONES (Siempre)
   SHOW_VIEW('CG$PAGE_1');
   GO_BLOCK('XXXX'); <multilinecomment> configurar esto con el nombre de bloque correcto </multilinecomment>

<multilinecomment> Se configuran los botones según se necesite </multilinecomment>
-- Mostrar botones
   ACTIVA_BOTONES('MI_BLOQUE',FALSE,FALSE,TRUE,TRUE,TRUE,TRUE,TRUE);


END;
	*/
	//ID:362
	/* <p>
		*  PROCEDIMIENTO QUE REALIZA LA OPCION SELECCIONADA EN EL TEXT_LIST 
		*  QUE APARECE AL PULSAR LA TECLA MAS 
/* </p>
		*/
		public void selecAccion()
		{
			//  Aqui ponemos tantos if como opciones tengamos en la lista, 
			//  para salir volveremos a pulsar la tecla MAS.               
			//  la estructura a seguir es la siguiente:                    
			//  Ejemplo de llamada a otro form 
			if ( getFormModel().getBloqueAcciones().getAcciones().equals("CONSULTA") )
			{
				hideWindow("WINDOW1");
				//  Antes de llamar al form hay que realizar el tratamiento 
				//  necesario de variables globales o parametros 
				//  Codigo de la accion a realizar para cada opcion 
				callTask("m000999", TaskServices.NO_HIDE, TaskServices.DO_REPLACE);
			}
			else if ( getFormModel().getBloqueAcciones().getAcciones().equals("ACC_2") ) {
				//  Antes de ocultar la lista hay que irse a otro bloque 
				goBlock(toStr("MI_BLOQUE"));
				//  Después de elegir una opcion hay se oculta la lista 
				hideView("MOSTRAR_ACCIONES");
			}
			//  Opcion de salir que siempre debe existir 
			//  y siempre se ejecuta (para cualquier opcion) 
			//  Salir de opciones del bloque ACCIONES (Siempre)
			showView("CG$PAGE_1");
			goBlock(toStr("XXXX"));
			//  configurar esto con el nombre de bloque correcto 
			//  Se configuran los botones según se necesite 
			//  Mostrar botones
			getTask().getSur().activaBotones(toStr("MI_BLOQUE"), toBool(NBool.False), toBool(NBool.False), toBool(NBool.True), toBool(NBool.True), toBool(NBool.True), toBool(NBool.True), toBool(NBool.True));
		}













	
	/* Original PL/SQL code for Prog Unit INICIALIZAR_LISTADO
	
	PROCEDURE INICIALIZAR_LISTADO IS
BEGIN
<multilinecomment> ATENCION: A este procedimiento hay que llamarlo desde el program unit </multilinecomment>
<multilinecomment>           CG$WHEN_NEW_FORM_INSTANCE                                   </multilinecomment>


<multilinecomment> Items que se van a imprimir </multilinecomment>
<multilinecomment> <Tipo bloq.>||<Bloque>||'.'||<Item1>||'#'||<Descripcion item1>||'#'|| </multilinecomment>
<multilinecomment> <Tipo bloq.>||<Bloque>||'.'||<Item2>||'#'||<Descripcion item2>||'#'|| </multilinecomment>
<multilinecomment> ..........</multilinecomment>
   :BLOQUE_IMPRESION.G_ITEMS_IMPRIMIR := '';

<multilinecomment> Longitud de la linea  </multilinecomment>
<multilinecomment> Para listados horizontales con tamaño de letra 10 poner 121 </multilinecomment>
<multilinecomment> Para listados verticales   con tamaño de letra 10 poner  80 </multilinecomment>
   :BLOQUE_IMPRESION.G_LONG_REG := 0;

<multilinecomment> Valor de la propiedad RECORDS FETCHED del bloque detalle que se </multilinecomment>
<multilinecomment> desea imprimir                                                  </multilinecomment>
   :BLOQUE_IMPRESION.G_RECORDS_FETCHED := 1;




















END;
	*/
	//ID:363
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		*/
		public void inicializarListado()
		{
			//  ATENCION: A este procedimiento hay que llamarlo desde el program unit 
			//            CG$WHEN_NEW_FORM_INSTANCE                                   
			//  Items que se van a imprimir 
			//  <Tipo bloq.>||<Bloque>||'.'||<Item1>||'#'||<Descripcion item1>||'#'|| 
			//  <Tipo bloq.>||<Bloque>||'.'||<Item2>||'#'||<Descripcion item2>||'#'|| 
			//  ..........
			getFormModel().getBloqueImpresion().setGItemsImprimir(toStr(""));
			//  Longitud de la linea  
			//  Para listados horizontales con tamaño de letra 10 poner 121 
			//  Para listados verticales   con tamaño de letra 10 poner  80 
			getFormModel().getBloqueImpresion().setGLongReg(toNumber(0));
			//  Valor de la propiedad RECORDS FETCHED del bloque detalle que se 
			//  desea imprimir                                                  
			getFormModel().getBloqueImpresion().setGRecordsFetched(toNumber(1));








		}


	
	/* Original PL/SQL code for Prog Unit PONER_TITULO
	
	PROCEDURE PONER_TITULO IS
  nombre_modulo varchar2(80):= get_item_property('CG$CTRL.CG$MN',HINT_TEXT);
  current_canvas VARCHAR2(61) := get_item_property(:SYSTEM.CURSOR_ITEM, ITEM_CANVAS);
  ventana VARCHAR2(40);
BEGIN
  <multilinecomment> Títulos de las ventanas </multilinecomment>

	ventana := get_view_property( current_canvas, WINDOW_NAME);
	-- Cambiamos el nombre a las ventanas excepto a la ventana
	-- de la opción MAS
	IF ventana != 'WINDOW1' AND ventana != 'WINDOW2' THEN
		nombre_modulo :=
			upper(substr(nombre_modulo,1,1))
			||lower(substr(nombre_modulo,2))
			||' ('||get_application_property(current_form_name)||')';
		set_window_property( get_view_property( current_canvas, WINDOW_NAME ), TITLE,
					nombre_modulo);
	END IF;
END;
	*/
	//ID:364
	/* <p>
		* F2J_STRONG_PRESENTATION_LOGIC : The code of this procedure was identified as containing presentation logic. See documentation for details.
/* </p>
		*/
		public void ponerTitulo()
		{
			NString nombreModulo = getItemHint("CG$CTRL.CG$MN");
			NString currentCanvas = getItemCanvas(getCursorItem());
			NString ventana = NString.getNull();
			//  Títulos de las ventanas 
			ventana = getViewWindowName(currentCanvas);
			//  Cambiamos el nombre a las ventanas excepto a la ventana
			//  de la opción MAS
			if ( ventana.notEquals("WINDOW1") && ventana.notEquals("WINDOW2") )
			{
				nombreModulo = upper(substring(nombreModulo, toInt(1), toInt(1))).append(lower(substring(nombreModulo, toInt(2)))).append(" (").append(getCurrentTaskName()).append(")");
				setWindowTitle(getViewWindowName(currentCanvas), nombreModulo);
			}
		}

	
	/* Original PL/SQL code for Prog Unit CGTE$CHECK_CONSTRAINT_VIO
	
	<multilinecomment> CGTE$CHECK_CONSTRAINT_VIO </multilinecomment>
FUNCTION CGTE$CHECK_CONSTRAINT_VIO(
   P_SERVER_ERR IN NUMBER        <multilinecomment> Server error message </multilinecomment>
  ,P_SERVER_MSG IN VARCHAR2)     <multilinecomment> Server error number  </multilinecomment>
RETURN BOOLEAN IS
<multilinecomment> Check and report Primary/Unique Key, Check Constraint and User </multilinecomment>
<multilinecomment> Defined Constraint violations                                  </multilinecomment>
  constraint_name VARCHAR2(61);  <multilinecomment> Violated constraint </multilinecomment>
BEGIN
  <multilinecomment> Check if the error code is one we are interested in </multilinecomment>
  IF ( NOT (P_SERVER_ERR IN  (1, 2290) OR
           (P_SERVER_ERR >= 20000 AND P_SERVER_ERR <= 20999) ) )
  THEN
    RETURN( FALSE );
  END IF;

  <multilinecomment> Deal with user defined errors </multilinecomment>
  IF (P_SERVER_ERR >= 20000 AND P_SERVER_ERR <= 20999) THEN
    SUR$FORM_ERRORS.PUSH(''||CGTE$STRIP_FIRST_ERROR(P_SERVER_MSG), 'E', 'OFG', 0);
    RETURN( TRUE );
  END IF;

  <multilinecomment> Deal with Primary/Unique Key and Check Constraint violations </multilinecomment>
  constraint_name := CGTE$STRIP_CONSTRAINT(P_SERVER_MSG);
  IF (P_SERVER_ERR = 1) THEN
    SUR$FORM_ERRORS.PUSH(P_SERVER_MSG, 'I', 'OFG', 0);
  ELSIF (P_SERVER_ERR = 2290) THEN
    SUR$FORM_ERRORS.PUSH(P_SERVER_MSG, 'I', 'OFG', 0);
  END IF;
  RETURN( TRUE );
END;
	*/
	//ID:365
	/* <p>
		*  CGTE$CHECK_CONSTRAINT_VIO 
		* F2J_PURE_BUSINESS_LOGIC : The code of this function was identified as containing business logic. See documentation for details.
/* </p>
		* @param pServerErr
		* @param pServerMsg
		*/
		public NBool cgteCheckConstraintVio(NNumber pServerErr, NString pServerMsg)
		{
			//  Check and report Primary/Unique Key, Check Constraint and User 
			//  Defined Constraint violations                                  
			NString constraintName = NString.getNull();
			//  Check if the error code is one we are interested in 
			if ((!(in(pServerErr, 1, 2290).getValue() || (pServerErr.greaterOrEquals(20000) && pServerErr.lesserOrEquals(20999)))))
			{
				return  toBool( toBool(((NBool.False))));
			}
			//  Deal with user defined errors 
			if ((pServerErr.greaterOrEquals(20000) && pServerErr.lesserOrEquals(20999)))
			{
//				getTask().getSurFormErrors().push(toStr("").append(cgteStripFirstError(pServerMsg)), toStr("E"), toStr("OFG"), toInt(0));
				return  toBool( toBool(((NBool.True))));
			}
			//  Deal with Primary/Unique Key and Check Constraint violations 
//			constraintName = cgteStripConstraint(pServerMsg);
			if ((pServerErr.equals(1)))
			{
				getTask().getSurFormErrors().push(pServerMsg, toStr("I"), toStr("OFG"), toInt(0));
			}
			else if ((pServerErr.equals(2290))) {
				getTask().getSurFormErrors().push(pServerMsg, toStr("I"), toStr("OFG"), toInt(0));
			}
			return  toBool( toBool(((NBool.True))));
		}



	
	/* Original PL/SQL code for Prog Unit CGLY$DISPLAY_CANVASES
	
	<multilinecomment> CGLY$DISPLAY_CANVASES </multilinecomment>
PROCEDURE CGLY$DISPLAY_CANVASES(
   P_CANVAS_LIST    IN OUT VARCHAR2      <multilinecomment> List of displayed canvases </multilinecomment>
  ,P_CURRENT_CANVAS IN     VARCHAR2      <multilinecomment> Current canvas             </multilinecomment>
  ,P_BASE_CANVAS    IN     VARCHAR2) IS  <multilinecomment> Base canvas                </multilinecomment>
<multilinecomment> Display the current canvas plus any others in the canvas list </multilinecomment>
  canvas_list VARCHAR2(255);  <multilinecomment> List of displayed canvases </multilinecomment>
  canvas_to_raise VARCHAR2(255);  <multilinecomment> Canvas to raise to the top </multilinecomment>
BEGIN
  IF ( P_CURRENT_CANVAS = P_BASE_CANVAS) THEN
      P_CANVAS_LIST := P_CURRENT_CANVAS || ',';
  ELSE
      P_CANVAS_LIST := REPLACE(P_CANVAS_LIST, P_CURRENT_CANVAS || ',');
      IF ( get_view_property(P_BASE_CANVAS, VISIBLE) = 'FALSE') THEN
          canvas_list := P_CANVAS_LIST;
          WHILE (canvas_list IS NOT NULL) LOOP
              canvas_to_raise := SUBSTR(canvas_list, 1, INSTR(canvas_list, ','));
              canvas_list := REPLACE(canvas_list, canvas_to_raise);
             CGLY$RAISE_CANVAS(RTRIM(canvas_to_raise, ','));
          END LOOP;
      END IF;
      P_CANVAS_LIST := P_CANVAS_LIST || P_CURRENT_CANVAS || ',';
  END IF;
  CGLY$RAISE_CANVAS(P_CURRENT_CANVAS);
END;    
	*/
	//ID:366
	/* <p>
		*  CGLY$DISPLAY_CANVASES 
/* </p>
		* @param pCanvasList
		* @param pCurrentCanvas
		* @param pBaseCanvas
		*/
		public void cglyDisplayCanvases(Ref<NString> pCanvasList, NString pCurrentCanvas, NString pBaseCanvas)
		{
			//  Base canvas                
			//  Display the current canvas plus any others in the canvas list 
			NString canvasList = NString.getNull();
			//  List of displayed canvases 
			NString canvasToRaise = NString.getNull();
			if ((pCurrentCanvas.equals(pBaseCanvas)))
			{
				pCanvasList.val = pCurrentCanvas.append(",");
			}
			else {
				pCanvasList.val = replace(pCanvasList.val, pCurrentCanvas.append(","));
				if ((getViewVisible(pBaseCanvas).equals("FALSE")))
				{
					canvasList = pCanvasList.val;
					while ((canvasList.isNotNull())) {
						canvasToRaise = substring(canvasList, toInt(1), inStrNullable(canvasList, toStr(",")));
						canvasList = replace(canvasList, canvasToRaise);
						cglyRaiseCanvas(rtrim(canvasToRaise, ","));
					}
				}
				pCanvasList.val = pCanvasList.val.append(pCurrentCanvas).append(",");
			}
			cglyRaiseCanvas(pCurrentCanvas);
		}



	
	/* Original PL/SQL code for Prog Unit CGLY$GET_RELATED_CANVASES
	
	<multilinecomment> CGLY$GET_RELATED_CANVASES </multilinecomment>
PROCEDURE CGLY$GET_RELATED_CANVASES(
   P_CURRENT_CANVAS IN OUT VARCHAR2      <multilinecomment> Current canvas </multilinecomment>
  ,P_BASE_CANVAS    IN OUT VARCHAR2) IS  <multilinecomment> Base canvas    </multilinecomment>
<multilinecomment> Find the canvases associated with the current canvas and record which </multilinecomment>
<multilinecomment> base canvas is displayed in each window                               </multilinecomment>
BEGIN
  <multilinecomment> CFLT </multilinecomment>
  P_BASE_CANVAS := P_CURRENT_CANVAS;
  IF (get_view_property(P_CURRENT_CANVAS, WINDOW_NAME) = 'WINDOW1') THEN
    :CG$CTRL.CG$WINDOWWINDOW1_PAGE := P_BASE_CANVAS;
  ELSIF (get_view_property(P_CURRENT_CANVAS, WINDOW_NAME) = 'WINDOW') THEN
    :CG$CTRL.CG$WINDOWWINDOW_PAGE := P_BASE_CANVAS;
  ELSIF (get_view_property(P_CURRENT_CANVAS, WINDOW_NAME) = 'WINDOW0') THEN
    :CG$CTRL.CG$WINDOWWINDOW0_PAGE := P_BASE_CANVAS;
  END IF;
END;
	*/
	//ID:367
	/* <p>
		*  CGLY$GET_RELATED_CANVASES 
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		* @param pCurrentCanvas
		* @param pBaseCanvas
		*/
		public void cglyGetRelatedCanvases(Ref<NString> pCurrentCanvas, Ref<NString> pBaseCanvas)
		{
			//  CFLT 
			pBaseCanvas.val = pCurrentCanvas.val;
			if ((getViewWindowName(pCurrentCanvas.val).equals("WINDOW1")))
			{
				getFormModel().getCgCtrl().setCgWindowwindow1Page(pBaseCanvas.val);
			}
			else if ((getViewWindowName(pCurrentCanvas.val).equals("WINDOW"))) {
				getFormModel().getCgCtrl().setCgWindowwindowPage(pBaseCanvas.val);
			}
			else if ((getViewWindowName(pCurrentCanvas.val).equals("WINDOW0"))) {
				getFormModel().getCgCtrl().setCgWindowwindow0Page(pBaseCanvas.val);
			}
		}


	
	/* Original PL/SQL code for Prog Unit CGLY$RAISE_CANVAS
	
	-- Modificacion por cambio de versión a Forms10g
-- Reemplazada posicion de botonera

<multilinecomment> CGLY$RAISE_CANVAS </multilinecomment>
PROCEDURE CGLY$RAISE_CANVAS(
   P_CANVAS IN VARCHAR2) IS  <multilinecomment> Current canvas </multilinecomment>
<multilinecomment> Raise the current canvas, plus any dependant canvases to the top </multilinecomment>
BEGIN
  set_view_property(P_CANVAS, VISIBLE, PROPERTY_ON);
  IF ( P_CANVAS = 'CG$PAGE_1') THEN
      set_view_property('CG$STACKED_FOOTER_1', DISPLAY_POSITION, 0, 312);
      set_view_property('CG$STACKED_FOOTER_1', VISIBLE, PROPERTY_ON);
  ELSIF (P_CANVAS = 'CG$FIRMA') THEN
      SET_VIEW_PROPERTY('CG$PESTAÑA_FIRMA', VISIBLE, PROPERTY_ON);
   --   SET_VIEW_PROPERTY('TITULARES', VISIBLE, PROPERTY_ON);
  	
  END IF;
END;


	*/
	//ID:368
	/* <p>
		*  Modificacion por cambio de versión a Forms10g
		*  Reemplazada posicion de botonera
		*  CGLY$RAISE_CANVAS 
/* </p>
		* @param pCanvas
		*/
		public void cglyRaiseCanvas(NString pCanvas)
		{
			setViewVisible(pCanvas, true);
			if ((pCanvas.equals("CG$PAGE_1")))
			{
				// F2J_NOT_SUPPORTED : The property "VIEW's DISPLAY_POSITION" is not supported. See documentation for details.
				//				SupportClasses.FORMS4W.SetViewProperty("CG$STACKED_FOOTER_1", SupportClasses.Property.DISPLAY_POSITION, 0, 312);
				this.getLogger().trace(this, "// F2J_NOT_SUPPORTED : The property 'VIEW's DISPLAY_POSITION' is not supported. See documentation for details.");
				
				setViewVisible("CG$STACKED_FOOTER_1", true);
			}
			else if ((pCanvas.equals("CG$FIRMA"))) {
				setViewVisible("CG$PESTAÑA_FIRMA", true);
			}
		}


	
	/* Original PL/SQL code for Prog Unit CGLY$CANVAS_MANAGEMENT
	
	<multilinecomment> CGLY$CANVAS_MANAGEMENT </multilinecomment>
PROCEDURE CGLY$CANVAS_MANAGEMENT IS
<multilinecomment> Top level canvas management procedure </multilinecomment>
  current_canvas VARCHAR2(61) := get_item_property(:SYSTEM.CURSOR_ITEM, ITEM_CANVAS);
  base_canvas VARCHAR2(61);
  canvas_list VARCHAR2(255);
BEGIN
  IF ( (:CG$CTRL.CG$LAST_CANVAS IS NULL) OR (:CG$CTRL.CG$LAST_CANVAS != current_canvas) ) THEN
    :CG$CTRL.CG$LAST_CANVAS := current_canvas;
    set_window_property( get_view_property( current_canvas, WINDOW_NAME ), VISIBLE, PROPERTY_ON);
    CGLY$GET_RELATED_CANVASES(current_canvas, base_canvas);
    IF ( base_canvas = 'CG$PAGE_1') THEN
      canvas_list := :CG$CTRL.CG$PAGE_1_LIST;
    END IF;
    CGLY$DISPLAY_CANVASES(canvas_list, current_canvas, base_canvas);
    IF ( base_canvas = 'CG$PAGE_1') THEN
      :CG$CTRL.CG$PAGE_1_LIST := canvas_list;
    END IF;
  END IF;
END;
	*/
	//ID:369
	/* <p>
		*  CGLY$CANVAS_MANAGEMENT 
		* F2J_WEAK_PRESENTATION_LOGIC : The code of this procedure was identified as containing presentation logic. See documentation for details.
/* </p>
		*/
		public void cglyCanvasManagement()
		{
			//  Top level canvas management procedure 
			NString currentCanvas = getItemCanvas(getCursorItem());
			NString baseCanvas = NString.getNull();
			NString canvasList = NString.getNull();
			if (((getFormModel().getCgCtrl().getCgLastCanvas().isNull()) || (getFormModel().getCgCtrl().getCgLastCanvas().notEquals(currentCanvas))))
			{
				getFormModel().getCgCtrl().setCgLastCanvas(currentCanvas);
				// F2J_NOT_SUPPORTED : The property "WINDOW's VISIBLE" is not supported. See documentation for details.
				//				SupportClasses.FORMS4W.SetWindowProperty(getViewWindowName(currentCanvas), SupportClasses.Property.VISIBLE, true);
				this.getLogger().trace(this, "// F2J_NOT_SUPPORTED : The property 'WINDOW's VISIBLE' is not supported. See documentation for details.");
				
				Ref<NString> pCurrentCanvas_ref = new Ref<NString>(currentCanvas);
				Ref<NString> pBaseCanvas_ref = new Ref<NString>(baseCanvas);
				cglyGetRelatedCanvases(pCurrentCanvas_ref, pBaseCanvas_ref);
				currentCanvas = pCurrentCanvas_ref.val;
				baseCanvas = pBaseCanvas_ref.val;
				if ((baseCanvas.equals("CG$PAGE_1")))
				{
					canvasList = getFormModel().getCgCtrl().getCgPage1List();
				}
				Ref<NString> pCanvasList_ref = new Ref<NString>(canvasList);
				cglyDisplayCanvases(pCanvasList_ref, currentCanvas, baseCanvas);
				canvasList = pCanvasList_ref.val;
				if ((baseCanvas.equals("CG$PAGE_1")))
				{
					getFormModel().getCgCtrl().setCgPage1List(canvasList);
				}
			}
		}


	
	/* Original PL/SQL code for Prog Unit CG$WHEN_NEW_FORM_INSTANCE
	
	<multilinecomment> CG$WHEN_NEW_FORM_INSTANCE </multilinecomment>
PROCEDURE CG$WHEN_NEW_FORM_INSTANCE IS
BEGIN
    CGLY$CANVAS_MANAGEMENT;
	
	  FBean.Register_Bean('MI_BLOQUE.IMPRIME', 1, 'ManejadorShell');

    inicia_variables;
    comprobar_opc_inicial;

END;

	*/
	//ID:370
	/* <p>
		*  CG$WHEN_NEW_FORM_INSTANCE 
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		*/
		public void cgWhenNewFormInstance(MarcadorAdapter marcadorElement, EjemplaresAdapter ejemplaresElement)
		{
			cglyCanvasManagement();
//			Fbean.registerBean("MI_BLOQUE.IMPRIME", 1, "ManejadorShell");
			iniciaVariables();
			comprobarOpcInicial(marcadorElement, ejemplaresElement);
		}

	
	/* Original PL/SQL code for Prog Unit INICIA_VARIABLES
	
	PROCEDURE inicia_variables IS
BEGIN
    :temp.codmodel              := :parameter.p_codmodel;
    :temp.numvermo              := :parameter.p_numvermo;
    :temp.numerdoc              := :parameter.p_numerdoc;
    :temp.operacion             := :parameter.p_operacion;

    -- rrs: recuperamos el concepto del documento
    BEGIN
        SELECT concep_codconce
          INTO :temp.concepto
          FROM su_docuni
         WHERE vermod_codmodel = '047' 
           AND vermod_numvermo = '2' 
           AND numerdoc = :temp.numerdoc;
    EXCEPTION
        WHEN OTHERS THEN
            :temp.concepto  := NULL;
    END;

    SELECT DECODE(:temp.operacion, 'BO', '1', 'CO', '0', '2')
      INTO :temp.operacion_paquete
      FROM DUAL;

    :temp.fecha                 := :parameter.p_fecha;
    :temp.inicio_mar            := '#$';
    :temp.fin_mar               := '$#';
    :temp.do_commit             := 'N';

END;

	*/
	//ID:371
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		*/
		public void iniciaVariables()
		{
			int rowCount = 0;
			getFormModel().getTemp().setCodmodel(this.getFormModel().getParam("P_CODMODEL", NString.class));
			getFormModel().getTemp().setNumvermo(this.getFormModel().getParam("P_NUMVERMO", NString.class));
			getFormModel().getTemp().setNumerdoc(this.getFormModel().getParam("P_NUMERDOC", NString.class));
			getFormModel().getTemp().setOperacion(this.getFormModel().getParam("P_OPERACION", NString.class));
			try
			{
				String sql1 = "SELECT concep_codconce " +
	" FROM su_docuni " +
	" WHERE vermod_codmodel = '047' AND vermod_numvermo = '2' AND numerdoc = :TEMP_NUMERDOC ";
				DataCommand command1 = new DataCommand(sql1);
				//Setting query parameters
				command1.addParameter("TEMP_NUMERDOC", getFormModel().getTemp().getNumerdoc());
				ResultSet results1 = command1.executeQuery();
				rowCount = command1.getRowCount();
				if ( results1.hasData() ) {
					getFormModel().getTemp().setConcepto(results1.getStr(0));
				}
				results1.close();
			}
			catch(Exception  e)
			{
				getFormModel().getTemp().setConcepto(toStr(null));
			}
			String sql2 = "SELECT DECODE(:TEMP_OPERACION, 'BO', '1', 'CO', '0', '2') " +
	" FROM DUAL ";
			DataCommand command2 = new DataCommand(sql2);
			//Setting query parameters
			command2.addParameter("TEMP_OPERACION", getFormModel().getTemp().getOperacion());
			ResultSet results2 = command2.executeQuery();
			rowCount = command2.getRowCount();
			if ( results2.hasData() ) {
				getFormModel().getTemp().setOperacionPaquete(results2.getNumber(0));
			}
			results2.close();
			getFormModel().getTemp().setFecha(this.getFormModel().getParam("P_FECHA", NString.class));
			getFormModel().getTemp().setInicioMar(toStr("#$"));
			getFormModel().getTemp().setFinMar(toStr("$#"));
			getFormModel().getTemp().setDoCommit(toStr("N"));
		}
















	
	/* Original PL/SQL code for Prog Unit COMPRUEBA_OBLIGATORIOS
	
	PROCEDURE comprueba_obligatorios IS
    fila_actual VARCHAR2(4) := :SYSTEM.cursor_record;
BEGIN
    go_block('marcador');
    last_record;
    first_record;
    LOOP
        IF  :marcador.tipmarca = 'E' 
        	 AND :marcador.valor IS NULL 
        	 AND NVL(:marcador.indoblco, 'N') = 'S' 
        THEN
            -- RRS: Para el concepto 047 / 0101 el marcardor FORM_1 no es obligatorio, para el resto sí.
            IF (:temp.concepto = '0101' AND :temp.codmodel = '047' AND :marcador.marcador = 'FORM_1') THEN
                NULL;
            ELSE
                go_item('marcador.valor_mirror');
                mostrar_mensaje('SUR-00831', 'E', TRUE);
            END IF;
        END IF;

        EXIT WHEN :SYSTEM.last_record = 'TRUE';
        next_record;
    END LOOP;

    go_record(TO_NUMBER(fila_actual));
END;

	*/
	//ID:372
	/* <p>
		* F2J_WEAK_PRESENTATION_LOGIC : The code of this procedure was identified as containing presentation logic. See documentation for details.
/* </p>
		*/
		public void compruebaObligatorios(MarcadorAdapter marcadorElement)
		{
			NNumber filaActual = getCursorRecord();
			goBlock(toStr("marcador"));
			lastRecord(true);
			firstRecord(true);
			while (true) {
				if ( marcadorElement.getTipmarca().equals("E") && marcadorElement.getValor().isNull() && isNull(marcadorElement.getIndoblco(), "N").equals("S") )
				{
					//  RRS: Para el concepto 047 / 0101 el marcardor FORM_1 no es obligatorio, para el resto sí.
					if ((getFormModel().getTemp().getConcepto().equals("0101") && getFormModel().getTemp().getCodmodel().equals("047") && marcadorElement.getMarcador().equals("FORM_1")))
					{
					}
					else {
						goItem(toStr("marcador.valor_mirror"));
						mostrarMensaje(toStr("SUR-00831"), toStr("E"), toBool(NBool.True));
					}
				}
				if ( isInLastRecord(true) ) 
					break;
				nextRecord();
			}
			setCurrentRecord(filaActual);
		}

	
	/* Original PL/SQL code for Prog Unit MI_TRIM
	
	FUNCTION MI_TRIM(ent varchar2) RETURN varchar2 IS
BEGIN
    return(ltrim(rtrim(ent)));
END;
	*/
	//ID:373
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this function was identified as containing business logic. See documentation for details.
/* </p>
		* @param ent
		*/
		public NString miTrim(NString ent)
		{
			return  toStr(((ltrim(rtrim(ent)))));
		}



	
	/* Original PL/SQL code for Prog Unit TRATAR_LOVS
	
	PROCEDURE TRATAR_LOVS IS

    rg_id               recordgroup;
    gc_id               GroupColumn;
    v_posicion          NUMBER;
    i                   NUMBER;
    v_longitud          NUMBER;
    v_tamano            NUMBER;
    v_fila_actual       NUMBER;
    v_valores           VARCHAR2(5000);
    v_elemento          VARCHAR2(500):= NULL;    
    v_valor_primario    VARCHAR2(1000);
    v_unidad            VARCHAR2(4);
    v_codter            VARCHAR2(6);
    v_nombre            VARCHAR2(400);
    v_descripcion       VARCHAR2(200);
    v_codarticulo       VARCHAR2(1000);
    v_expedi_codcircu   su_tramit.expedi_codcircu%TYPE;
    v_expedi_codterri   su_tramit.expedi_codterri%TYPE;
    v_expedi_ejeexped   su_tramit.expedi_ejeexped%TYPE;
    v_expedi_numexped   su_tramit.expedi_numexped%TYPE;
    v_codcliac          su_cliact.codcliac%TYPE;
    v_tipex             su_segexp.tipexp_codtipex%TYPE;
    v_codter_rec        su_docuni.codter_codterri%TYPE;
   
    
    CURSOR c_inspectores (pc_unidad_administrativa IN VARCHAR2, pc_codigo_territorial IN VARCHAR2) IS
        SELECT nomusuar
    	    FROM su_usuari
    	   WHERE uniadm_coduniad = pc_unidad_administrativa
    	     AND codter_codterri = pc_codigo_territorial
    	     AND fecbajas IS NULL;
    
    CURSOR c_actuarios (pc_codter IN VARCHAR2) IS
        SELECT DISTINCT(kusuari.fnomusu(cliact.usuari_codusuar))||' - '||'( '||cliact.uniadm_coduniad||'  '||uniadm.desuniad||' )',
                        cliact.codcliac
          FROM su_cliact cliact, su_uniadm uniadm
         WHERE cliact.fecbajas IS NULL
           AND cliact.codter_codterri = pc_codter
           AND cliact.uniadm_coduniad = uniadm.coduniad;

    CURSOR c_concepto (pc_modelo IN VARCHAR2) IS
        SELECT codconce||' - '||desconce concepto 
          FROM su_concep
         WHERE modelo_codmodel = pc_modelo
         ORDER BY desconce;  
        
    CURSOR c_recurso (pc_modelo IN VARCHAR2, pc_tipex IN VARCHAR2)IS
        SELECT rv_abbreviation recurso
          FROM su_tipres
             , cg_ref_codes
         WHERE rv_domain = 'TIPO RECURSO DOC SALIDA'
           AND modelo_codmodel = pc_modelo
           AND tipexp_codtipex = pc_tipex
           AND tiprecur = rv_low_value;
           
    CURSOR c_desc_articulo IS
        SELECT TRIM(rv_meaning) articulo
          FROM cg_ref_codes
         WHERE rv_domain = 'ARTICULO INFRACCION TRIBUTARIA'
         ORDER BY rv_low_value; 
           
    CURSOR c_articulo(pc_descripcion IN VARCHAR2) IS
        SELECT rv_low_value articulo
          FROM cg_ref_codes
         WHERE rv_domain = 'ARTICULO INFRACCION TRIBUTARIA'
           AND rv_meaning = pc_descripcion
         ORDER BY rv_low_value;   

    CURSOR c_desgrinf(pc_artinftr IN VARCHAR2) IS
        SELECT desgrinf grado
          FROM su_parsan
         WHERE artinftr = pc_artinftr;
           
           
BEGIN

    v_tamano := 0;
    rg_id := Find_Group('RG_LISTA'); 
    IF NOT Id_Null(rg_id) THEN
        Delete_Group ('RG_LISTA');
    END IF;

    rg_id := Create_Group('RG_LISTA');
    gc_id := Add_Group_Column(rg_id, 'COL1', CHAR_COLUMN,2000); 

    -- Si el utlimo caracter no es ";" se lo añadimos
    v_valores := :marcador.listaval;

    IF :temp.codmodel = 'D00' AND :marcador.marcador = 'FORM_3' THEN
    	 
        v_fila_actual := :system.cursor_record;
	      first_record;
	      v_valor_primario := :marcador.valor;
	      go_record(v_fila_actual);
	      IF v_valor_primario = 'Transmisiones Patrimoniales y Actos Jurídicos Doc.' THEN
		        v_valores := 'Art. 6 de la Ley 30/1983 de 28 de diciembre;Art. 25 de la Ley 21/2001 de 27 de diciembre;Art. 33 de la Ley 22/2009, de 18 de diciembre;';
	      ELSE
		        v_valores :='Art. 5 de la Ley 30/1983 de 28 de diciembre;Art. 24 de la Ley 21/2001 de 27 de diciembre;Art. 32 de la Ley 22/2009, de 18 de diciembre;';
	      END IF;
    END IF;

    ----------------------------------------------------------------------------------------------
    -- Marcador de Actuarios
    ----------------------------------------------------------------------------------------------
        
    IF :marcador.marcador = 'CONNECT_1' THEN
        v_valores:=NULL;
        v_fila_actual := :SYSTEM.CURSOR_RECORD;
        first_record;
        LOOP
            IF :marcador.marcador = 'H1C019' THEN
                v_codter := :marcador.valor;
                exit;
            ELSE
                next_record;
            END IF;
	    END LOOP;
	    go_record(v_fila_actual);
        OPEN c_actuarios(v_codter);
        LOOP
            FETCH C_actuarios INTO v_nombre, v_codcliac;
            EXIT WHEN c_actuarios%NOTFOUND;
            v_valores := v_valores || v_nombre ||';';
        END LOOP;
    END IF;
    
    ----------------------------------------------------------------------------------------------
    -- Marcador de Concepto de Inspección
    ----------------------------------------------------------------------------------------------
    
    IF :marcador.marcador = 'CV_H1C025' AND :temp.codmodel <> '132' THEN 
        v_valores := NULL;
        v_fila_actual := :system.cursor_record;
        OPEN c_concepto (:temp.codmodel);
        LOOP
            FETCH c_concepto INTO v_descripcion;
            EXIT WHEN c_concepto%NOTFOUND;
            v_valores := v_valores || v_descripcion ||';';
        END LOOP;
        go_record(v_fila_actual);

    END IF;
    
    ----------------------------------------------------------------------------------------------
    -- Marcador de Inspector
    ----------------------------------------------------------------------------------------------    
    
    IF :temp.codmodel = '031' AND :marcador.marcador = 'H1C024' THEN
	      v_valores:=null;
	      v_fila_actual := :system.cursor_record;
	      first_record;
	      LOOP
		        IF :marcador.marcador = 'H1C021' THEN
			          v_expedi_codcircu := SUBSTR(:marcador.valor,1,8);
			          v_expedi_codterri := SUBSTR(:marcador.valor,10,6);
			          v_expedi_ejeexped := TO_NUMBER(substr(:marcador.valor,17,4));
			          v_expedi_numexped := TO_NUMBER(substr(:marcador.valor,22));
			          EXIT;
		        ELSE
			          next_record;
		        END IF;
	      END LOOP;
	      v_valor_primario := :marcador.valor;
	      go_record(v_fila_actual);
	
	      BEGIN
		        SELECT uniadm_coduniad
		          INTO v_unidad
		          FROM su_rutcir
		         WHERE (circui_codcircu, etitrami) =
		                   (SELECT rutcir_codcircu, rutcir_etitrami
		                      FROM su_tramit
       			             WHERE expedi_codcircu = v_expedi_codcircu
        		               AND expedi_codterri = v_expedi_codterri
	        	               AND expedi_ejeexped = v_expedi_ejeexped
		                       AND expedi_numexped = v_expedi_numexped
       			               AND codtra_codtrami = 'INSPECTO');
       			            
		        v_codter := :global.codigo_territorial;
		        OPEN c_inspectores (v_codter, v_unidad);
		        LOOP
			          FETCH c_inspectores INTO v_nombre;
			          EXIT WHEN c_inspectores%NOTFOUND;
			          v_valores := v_valores || v_nombre ||';';
		        END LOOP;
	      EXCEPTION
		        WHEN NO_DATA_FOUND THEN
			          NULL;
	      END;
    END IF;
    
    ----------------------------------------------------------------------------------------------
    -- Modelo R09 de Inspección
    ----------------------------------------------------------------------------------------------
    IF :temp.codmodel = 'R09' AND :marcador.marcador = 'CV_H1C050' THEN 
        
        BEGIN 
            SELECT expedi_codcircu, expedi_codterri, expedi_ejeexped, expedi_numexped
              INTO v_expedi_codcircu, v_expedi_codterri, v_expedi_ejeexped, v_expedi_numexped
              FROM su_escrit
             WHERE docuni_codmodel = :temp.codmodel
               AND docuni_numvermo = :temp.numvermo
               AND docuni_numerdoc = :temp.numerdoc;	
               
            SELECT docuni_codmodel || docuni_numvermo|| docuni_numerdoc
              INTO v_valores
              FROM su_docexp
             WHERE expedi_codcircu = v_expedi_codcircu
               AND expedi_codterri = v_expedi_codterri
               AND expedi_ejeexped = v_expedi_ejeexped
               AND expedi_numexped = v_expedi_numexped
               AND docuni_codmodel IN ('001', '002', '007', '008');   
     
        EXCEPTION
    	      WHEN NO_DATA_FOUND THEN
    	          v_valores := NULL;    
        END;  
    
    END IF;   
    
    ----------------------------------------------------------------------------------------------
    -- Tratamiento de los Pie de recursos que tiene disponible un modelo para un Cod. Territorial
    ----------------------------------------------------------------------------------------------
    IF :marcador.marcador IN ('T_RECURSO', 'REC_SSCC') THEN 
        BEGIN
            v_valores:= NULL;
            
            -- primero obtengo el cod. terr.
					  SELECT codter_codterri
					    INTO v_codter_rec
					    FROM su_docuni
					   WHERE vermod_codmodel = :parameter.p_codmodel
    		       AND vermod_numvermo = :parameter.p_numvermo
		    		   AND numerdoc = :parameter.p_numerdoc; 
 
 		        -- Obtengo el tipo al que pertenece el cod. Terr.
 		        SELECT tipexp_codtipex
              INTO v_tipex
              FROM su_segexp
             WHERE codter_codterri = v_codter_rec;		    		    
 
           FOR r_recurso IN c_recurso(:parameter.p_codmodel, v_tipex) LOOP
               v_valores := v_valores || r_recurso.recurso||';';
           END LOOP;
                                 
       EXCEPTION
           WHEN NO_DATA_FOUND THEN
    	          v_valores := NULL;
       END;   	
    END IF;	
    ----------------------------------------------------------------------------------------------
    -- Tratamiento de los artículo y grado de infracción para Acuerdo de Sanción
    ----------------------------------------------------------------------------------------------
    IF :marcador.marcador = 'ARTICINFR' 
    	AND :temp.codmodel = 'A25'
    THEN 
        v_valores := NULL;
        FOR r_desc_articulo IN c_desc_articulo LOOP
            v_valores := v_valores || r_desc_articulo.articulo||';';
        END LOOP;
    END IF;	
    IF :marcador.marcador = 'GRADOINFR' 
    	AND :temp.codmodel = 'A25'
    THEN 
        v_valores := NULL;
        -- Obtener primero el articulo de infracción
	      v_fila_actual := :system.cursor_record;
	      first_record;
	      LOOP
		        IF :marcador.marcador = 'ARTICINFR' 
		        	 AND :marcador.valor IS NOT NULL 
		        THEN
		        	  -- Encontrar el valor del articulo
		        	  v_codarticulo := NULL;
		        	  OPEN c_articulo(:marcador.valor);
		        	  FETCH c_articulo INTO v_codarticulo;
		        	  CLOSE c_articulo;
			          EXIT;
		        ELSIF :marcador.marcador = 'ARTICINFR'
		        	  AND :marcador.valor IS NULL
		        THEN
		            v_codarticulo := NULL;
		            EXIT;
		        ELSE
			          next_record;
		        END IF;
	      END LOOP;
	      go_record(v_fila_actual);
	      IF v_codarticulo IS NULL THEN
	      	  -- Error, Debe consignar un Artículo de Infraccción primero
	      	  mostrar_mensaje('SUR-04224', 'E',TRUE);
	      ELSE
	      	  -- Obtener los grados para el artículo
	      	  FOR r_desgrinf IN c_desgrinf(v_codarticulo) LOOP
                v_valores := v_valores || r_desgrinf.grado||';';
	      	  END LOOP;
	      END IF;
    END IF;	
   
    ----------------------------------------------------------------------------------------------
    -- Tratamiento de la Lista
    ----------------------------------------------------------------------------------------------
    v_longitud := NVL(LENGTH(v_valores), 0);
    
    IF SUBSTR(v_valores,v_longitud,1) != ';' THEN
 	    v_valores := v_valores || ';';
    END IF;

	  i := 1;
	  WHILE INSTR(v_valores,';') != 0 LOOP
        v_posicion := INSTR(v_valores,';');
        v_elemento := SUBSTR(v_valores,1,v_posicion-1);
        IF length (v_elemento ) > v_tamano THEN
            v_tamano := length(v_elemento);
        END IF;
	      v_valores := SUBSTR(v_valores,v_posicion + 1);
	      Add_Group_Row (rg_id, END_OF_GROUP);
	      Set_Group_Char_Cell ('RG_LISTA.COL1', i, mi_trim(v_elemento));
	      i := i + 1;
	  END LOOP;

    SET_LOV_PROPERTY('LV_LISTA',TITLE,'Valores posibles');
    SET_LOV_PROPERTY('LV_LISTA',GROUP_NAME,'RG_LISTA');
    SET_LOV_PROPERTY('LV_LISTA',LOV_SIZE ,(10*(v_tamano+1)),280 ); 
    SET_LOV_COLUMN_PROPERTY('LV_LISTA',1,WIDTH,10*(v_tamano+1) );
    SET_LOV_COLUMN_PROPERTY('LV_LISTA',1,TITLE,:marcador.nommarca);

EXCEPTION
    WHEN OTHERS THEN
        CGTe$OTHER_EXCEPTIONS;
END;


     
	*/
	//ID:374
	/* <p>
/* </p>
		*/
		public void tratarLovs(MarcadorAdapter marcadorElement)
		{
			int rowCount = 0;
			ValueSet rgId = null;
			ValueSetColumn gcId = null;
			NNumber vPosicion = NNumber.getNull();
			NNumber i = NNumber.getNull();
			NNumber vLongitud = NNumber.getNull();
			NNumber vTamano = NNumber.getNull();
			NNumber vFilaActual = NNumber.getNull();
			NString vValores = NString.getNull();
			NString vElemento = NString.getNull();
			NString vValorPrimario = NString.getNull();
			NString vUnidad = NString.getNull();
			NString vCodter = NString.getNull();
			NString vNombre = NString.getNull();
			NString vDescripcion = NString.getNull();
			NString vCodarticulo = NString.getNull();
			NString vExpediCodcircu = NString.getNull();
			NString vExpediCodterri = NString.getNull();
			NNumber vExpediEjeexped = NNumber.getNull();
			NNumber vExpediNumexped = NNumber.getNull();
			NString vCodcliac = NString.getNull();
			NString vTipex = NString.getNull();
			NString vCodterRec = NString.getNull();
			String sqlcInspectores = "SELECT nomusuar " +
	" FROM su_usuari " +
	" WHERE uniadm_coduniad = :P_PC_UNIDAD_ADMINISTRATIVA AND codter_codterri = :P_PC_CODIGO_TERRITORIAL AND fecbajas IS NULL ";
			DataCursor cInspectores = new DataCursor(sqlcInspectores);
			NString cInspectoresPcUnidadAdministrativa = NString.getNull();
			NString cInspectoresPcCodigoTerritorial = NString.getNull();
			String sqlcActuarios = "SELECT DISTINCT (kusuari.fnomusu(cliact.usuari_codusuar)) || ' - ' || '( ' || cliact.uniadm_coduniad || '  ' || uniadm.desuniad || ' )', cliact.codcliac " +
	" FROM su_cliact cliact, su_uniadm uniadm " +
	" WHERE cliact.fecbajas IS NULL AND cliact.codter_codterri = :P_PC_CODTER AND cliact.uniadm_coduniad = uniadm.coduniad ";
			DataCursor cActuarios = new DataCursor(sqlcActuarios);
			NString cActuariosPcCodter = NString.getNull();
			String sqlcConcepto = "SELECT codconce || ' - ' || desconce concepto " +
	" FROM su_concep " +
	" WHERE modelo_codmodel = :P_PC_MODELO " +
	" ORDER BY desconce";
			DataCursor cConcepto = new DataCursor(sqlcConcepto);
			NString cConceptoPcModelo = NString.getNull();
			String sqlcRecurso = "SELECT rv_abbreviation recurso " +
	" FROM su_tipres, cg_ref_codes " +
	" WHERE rv_domain = 'TIPO RECURSO DOC SALIDA' AND modelo_codmodel = :P_PC_MODELO AND tipexp_codtipex = :P_PC_TIPEX AND tiprecur = rv_low_value ";
			DataCursor cRecurso = new DataCursor(sqlcRecurso);
			NString cRecursoPcModelo = NString.getNull();
			NString cRecursoPcTipex = NString.getNull();
			String sqlcDescArticulo = "SELECT TRIM(rv_meaning) articulo " +
	" FROM cg_ref_codes " +
	" WHERE rv_domain = 'ARTICULO INFRACCION TRIBUTARIA' " +
	" ORDER BY rv_low_value";
			DataCursor cDescArticulo = new DataCursor(sqlcDescArticulo);
			String sqlcArticulo = "SELECT rv_low_value articulo " +
	" FROM cg_ref_codes " +
	" WHERE rv_domain = 'ARTICULO INFRACCION TRIBUTARIA' AND rv_meaning = :P_PC_DESCRIPCION " +
	" ORDER BY rv_low_value";
			DataCursor cArticulo = new DataCursor(sqlcArticulo);
			NString cArticuloPcDescripcion = NString.getNull();
			String sqlcDesgrinf = "SELECT desgrinf grado " +
	" FROM su_parsan " +
	" WHERE artinftr = :P_PC_ARTINFTR ";
			DataCursor cDesgrinf = new DataCursor(sqlcDesgrinf);
			NString cDesgrinfPcArtinftr = NString.getNull();



















































































































































			try {
				try
				{
					vTamano = toNumber(0);
					rgId = findGroup("RG_LISTA");
					if ( !(rgId == null) )
					{
						deleteGroup("RG_LISTA");






























					}
					rgId = createGroup("RG_LISTA");
					gcId = addGroupColumn(rgId, "COL1", ValueSetColumn.CHAR_COL, 2000);
					//  Si el utlimo caracter no es ";" se lo añadimos
					vValores = marcadorElement.getListaval();
					if ( getFormModel().getTemp().getCodmodel().equals("D00") && marcadorElement.getMarcador().equals("FORM_3") )
					{
						vFilaActual = getCursorRecord();
						firstRecord();
						vValorPrimario = marcadorElement.getValor();
						setCurrentRecord(vFilaActual);
						if ( vValorPrimario.equals("Transmisiones Patrimoniales y Actos Jurídicos Doc.") )
						{
							vValores = toStr("Art. 6 de la Ley 30/1983 de 28 de diciembre;Art. 25 de la Ley 21/2001 de 27 de diciembre;Art. 33 de la Ley 22/2009, de 18 de diciembre;");
						}
						else {
							vValores = toStr("Art. 5 de la Ley 30/1983 de 28 de diciembre;Art. 24 de la Ley 21/2001 de 27 de diciembre;Art. 32 de la Ley 22/2009, de 18 de diciembre;");
						}
					}
					// --------------------------------------------------------------------------------------------
					//  Marcador de Actuarios
					// --------------------------------------------------------------------------------------------
					if ( marcadorElement.getMarcador().equals("CONNECT_1") )
					{
						vValores = toStr(null);
						vFilaActual = getCursorRecord();
						firstRecord();
						while (true) {
							if ( marcadorElement.getMarcador().equals("H1C019") )
							{
								vCodter = marcadorElement.getValor();
									break;
							}
							else {
								nextRecord();
							}

						}
						setCurrentRecord(vFilaActual);
						cActuariosPcCodter = vCodter;
						//Setting query parameters
						cActuarios.addParameter("P_PC_CODTER", cActuariosPcCodter);
						//F2J_WARNING : Make sure that the method "Close" is being called over the variable cActuarios.
						cActuarios.open();
						while (true) {
							ResultSet cActuariosResults = cActuarios.fetchInto();
							if ( cActuariosResults != null ) {
								vNombre = cActuariosResults.getStr(0);
								vCodcliac = cActuariosResults.getStr(1);
							}
							if ( cActuarios.notFound() ) 
								break;
							vValores = vValores.append(vNombre).append(";");
						}

					}
					// --------------------------------------------------------------------------------------------
					//  Marcador de Concepto de Inspección
					// --------------------------------------------------------------------------------------------
					if ( marcadorElement.getMarcador().equals("CV_H1C025") && getFormModel().getTemp().getCodmodel().notEquals("132") )
					{
						vValores = toStr(null);
						vFilaActual = getCursorRecord();
						cConceptoPcModelo = getFormModel().getTemp().getCodmodel();
						//Setting query parameters
						cConcepto.addParameter("P_PC_MODELO", cConceptoPcModelo);
						//F2J_WARNING : Make sure that the method "Close" is being called over the variable cConcepto.
						cConcepto.open();
						while (true) {
							ResultSet cConceptoResults = cConcepto.fetchInto();
							if ( cConceptoResults != null ) {
								vDescripcion = cConceptoResults.getStr(0);
							}
							if ( cConcepto.notFound() ) 
								break;
							vValores = vValores.append(vDescripcion).append(";");


						}
						setCurrentRecord(vFilaActual);
					}
					// --------------------------------------------------------------------------------------------
					//  Marcador de Inspector
					// --------------------------------------------------------------------------------------------    
					if ( getFormModel().getTemp().getCodmodel().equals("031") && marcadorElement.getMarcador().equals("H1C024") )
					{
						vValores = toStr(null);
						vFilaActual = getCursorRecord();
						firstRecord();
						while (true) {
							if ( marcadorElement.getMarcador().equals("H1C021") )
							{
								vExpediCodcircu = substring(marcadorElement.getValor(), toInt(1), toInt(8));
								vExpediCodterri = substring(marcadorElement.getValor(), toInt(10), toInt(6));
								vExpediEjeexped = toNumber(substring(marcadorElement.getValor(), toInt(17), toInt(4)));
								vExpediNumexped = toNumber(substring(marcadorElement.getValor(), toInt(22)));
									break;
							}
							else {
								nextRecord();
							}
						}
						vValorPrimario = marcadorElement.getValor();
						setCurrentRecord(vFilaActual);
						try {
							try
							{
								String sql1 = "SELECT uniadm_coduniad " +
	" FROM su_rutcir " +
	" WHERE (circui_codcircu, etitrami) = (SELECT rutcir_codcircu, rutcir_etitrami " +
		" FROM su_tramit " +
		" WHERE expedi_codcircu = :P_V_EXPEDI_CODCIRCU AND expedi_codterri = :P_V_EXPEDI_CODTERRI AND expedi_ejeexped = :P_V_EXPEDI_EJEEXPED AND expedi_numexped = :P_V_EXPEDI_NUMEXPED AND codtra_codtrami = 'INSPECTO' ) ";
								DataCommand command1 = new DataCommand(sql1);
								//Setting query parameters
								command1.addParameter("P_V_EXPEDI_CODCIRCU", vExpediCodcircu);
								command1.addParameter("P_V_EXPEDI_CODTERRI", vExpediCodterri);
								command1.addParameter("P_V_EXPEDI_EJEEXPED", vExpediEjeexped);
								command1.addParameter("P_V_EXPEDI_NUMEXPED", vExpediNumexped);
								ResultSet results1 = command1.executeQuery();
								rowCount = command1.getRowCount();
								if ( results1.hasData() ) {
									vUnidad = results1.getStr(0);












								}
								results1.close();
								vCodter = getGlobal("CODIGO_TERRITORIAL");
								cInspectoresPcUnidadAdministrativa = vCodter;
								cInspectoresPcCodigoTerritorial = vUnidad;
								//Setting query parameters
								cInspectores.addParameter("P_PC_UNIDAD_ADMINISTRATIVA", cInspectoresPcUnidadAdministrativa);
								cInspectores.addParameter("P_PC_CODIGO_TERRITORIAL", cInspectoresPcCodigoTerritorial);
								//F2J_WARNING : Make sure that the method "Close" is being called over the variable cInspectores.
								cInspectores.open();
								while (true) {
									ResultSet cInspectoresResults = cInspectores.fetchInto();
									if ( cInspectoresResults != null ) {
										vNombre = cInspectoresResults.getStr(0);
									}
									if ( cInspectores.notFound() ) 
										break;
									vValores = vValores.append(vNombre).append(";");
								}

							}
							catch(NoDataFoundException e)
							{
							}
							}finally{
								cInspectores.close();
							}
					}
					// --------------------------------------------------------------------------------------------
					//  Modelo R09 de Inspección
					// --------------------------------------------------------------------------------------------
					if ( getFormModel().getTemp().getCodmodel().equals("R09") && marcadorElement.getMarcador().equals("CV_H1C050") )
					{
						try
						{
							String sql2 = "SELECT expedi_codcircu, expedi_codterri, expedi_ejeexped, expedi_numexped " +
	" FROM su_escrit " +
	" WHERE docuni_codmodel = :TEMP_CODMODEL AND docuni_numvermo = :TEMP_NUMVERMO AND docuni_numerdoc = :TEMP_NUMERDOC ";
							DataCommand command2 = new DataCommand(sql2);
							//Setting query parameters
							command2.addParameter("TEMP_CODMODEL", getFormModel().getTemp().getCodmodel());
							command2.addParameter("TEMP_NUMVERMO", getFormModel().getTemp().getNumvermo());
							command2.addParameter("TEMP_NUMERDOC", getFormModel().getTemp().getNumerdoc());
							ResultSet results2 = command2.executeQuery();
							rowCount = command2.getRowCount();
							if ( results2.hasData() ) {
								vExpediCodcircu = results2.getStr(0);
								vExpediCodterri = results2.getStr(1);
								vExpediEjeexped = results2.getNumber(2);
								vExpediNumexped = results2.getNumber(3);
							}
							results2.close();
							String sql3 = "SELECT docuni_codmodel || docuni_numvermo || docuni_numerdoc " +
	" FROM su_docexp " +
	" WHERE expedi_codcircu = :P_V_EXPEDI_CODCIRCU AND expedi_codterri = :P_V_EXPEDI_CODTERRI AND expedi_ejeexped = :P_V_EXPEDI_EJEEXPED AND expedi_numexped = :P_V_EXPEDI_NUMEXPED AND (docuni_codmodel) IN ('001', '002', '007', '008') ";
							DataCommand command3 = new DataCommand(sql3);
							//Setting query parameters
							command3.addParameter("P_V_EXPEDI_CODCIRCU", vExpediCodcircu);
							command3.addParameter("P_V_EXPEDI_CODTERRI", vExpediCodterri);
							command3.addParameter("P_V_EXPEDI_EJEEXPED", vExpediEjeexped);
							command3.addParameter("P_V_EXPEDI_NUMEXPED", vExpediNumexped);
							ResultSet results3 = command3.executeQuery();
							rowCount = command3.getRowCount();
							if ( results3.hasData() ) {
								vValores = results3.getStr(0);
							}
							results3.close();
						}
						catch(NoDataFoundException e)
						{
							vValores = toStr(null);
						}


					}
					// --------------------------------------------------------------------------------------------
					//  Tratamiento de los Pie de recursos que tiene disponible un modelo para un Cod. Territorial
					// --------------------------------------------------------------------------------------------
					if ( in(marcadorElement.getMarcador(), "T_RECURSO", "REC_SSCC").getValue() )
					{
						try
						{
							vValores = toStr(null);
							//  primero obtengo el cod. terr.
							String sql4 = "SELECT codter_codterri " +
	" FROM su_docuni " +
	" WHERE vermod_codmodel = :PARAMETER_P_CODMODEL AND vermod_numvermo = :PARAMETER_P_NUMVERMO AND numerdoc = :PARAMETER_P_NUMERDOC ";
							DataCommand command4 = new DataCommand(sql4);
							//Setting query parameters
							command4.addParameter("PARAMETER_P_CODMODEL", this.getFormModel().getParam("P_CODMODEL", NString.class));
							command4.addParameter("PARAMETER_P_NUMVERMO", this.getFormModel().getParam("P_NUMVERMO", NString.class));
							command4.addParameter("PARAMETER_P_NUMERDOC", this.getFormModel().getParam("P_NUMERDOC", NString.class));
							ResultSet results4 = command4.executeQuery();
							rowCount = command4.getRowCount();
							if ( results4.hasData() ) {
								vCodterRec = results4.getStr(0);
							}
							results4.close();
							//  Obtengo el tipo al que pertenece el cod. Terr.
							String sql5 = "SELECT tipexp_codtipex " +
	" FROM su_segexp " +
	" WHERE codter_codterri = :P_V_CODTER_REC ";
							DataCommand command5 = new DataCommand(sql5);
							//Setting query parameters
							command5.addParameter("P_V_CODTER_REC", vCodterRec);
							ResultSet results5 = command5.executeQuery();
							rowCount = command5.getRowCount();
							if ( results5.hasData() ) {
								vTipex = results5.getStr(0);
							}
							results5.close();
							cRecursoPcModelo = this.getFormModel().getParam("P_CODMODEL", NString.class);
							cRecursoPcTipex = vTipex;
							//Setting query parameters
							cRecurso.addParameter("P_PC_MODELO", cRecursoPcModelo);
							cRecurso.addParameter("P_PC_TIPEX", cRecursoPcTipex);
							try
							{
								cRecurso.open();
								while (true)
								{
									TableRow rRecurso = cRecurso.fetchRow();
									if ( cRecurso.notFound() ) break;
									vValores = vValores.append(rRecurso.getStr("recurso")).append(";");








































								}
							}finally{
								cRecurso.close();
							}


						}
						catch(NoDataFoundException e)
						{
							vValores = toStr(null);
						}
					}
					// --------------------------------------------------------------------------------------------
					//  Tratamiento de los artículo y grado de infracción para Acuerdo de Sanción
					// --------------------------------------------------------------------------------------------
					if ( marcadorElement.getMarcador().equals("ARTICINFR") && getFormModel().getTemp().getCodmodel().equals("A25") )
					{
						vValores = toStr(null);
						try
						{
							cDescArticulo.open();
							while (true)
							{
								TableRow rDescArticulo = cDescArticulo.fetchRow();
								if ( cDescArticulo.notFound() ) break;
								vValores = vValores.append(rDescArticulo.getStr("articulo")).append(";");
							}
						}finally{
							cDescArticulo.close();
						}


					}
					if ( marcadorElement.getMarcador().equals("GRADOINFR") && getFormModel().getTemp().getCodmodel().equals("A25") )
					{
						vValores = toStr(null);
						//  Obtener primero el articulo de infracción
						vFilaActual = getCursorRecord();
						firstRecord();
						while (true) {
							if ( marcadorElement.getMarcador().equals("ARTICINFR") && marcadorElement.getValor().isNotNull() )
							{
								//  Encontrar el valor del articulo
								vCodarticulo = toStr(null);
								cArticuloPcDescripcion = marcadorElement.getValor();
								//Setting query parameters
								cArticulo.addParameter("P_PC_DESCRIPCION", cArticuloPcDescripcion);
								//F2J_WARNING : Make sure that the method "Close" is being called over the variable cArticulo.
								cArticulo.open();
								ResultSet cArticuloResults = cArticulo.fetchInto();
								if ( cArticuloResults != null ) {
									vCodarticulo = cArticuloResults.getStr(0);
								}
								cArticulo.close();
									break;
							}
							else if ( marcadorElement.getMarcador().equals("ARTICINFR") && marcadorElement.getValor().isNull() ) {
								vCodarticulo = toStr(null);






















									break;
							}
							else {
								nextRecord();
							}
						}
						setCurrentRecord(vFilaActual);
						if ( vCodarticulo.isNull() )
						{
							//  Error, Debe consignar un Artículo de Infraccción primero
							mostrarMensaje(toStr("SUR-04224"), toStr("E"), toBool(NBool.True));
						}
						else {
							//  Obtener los grados para el artículo
							cDesgrinfPcArtinftr = vCodarticulo;
							//Setting query parameters
							cDesgrinf.addParameter("P_PC_ARTINFTR", cDesgrinfPcArtinftr);
							try
							{
								cDesgrinf.open();
								while (true)
								{
									TableRow rDesgrinf = cDesgrinf.fetchRow();
									if ( cDesgrinf.notFound() ) break;
									vValores = vValores.append(rDesgrinf.getStr("grado")).append(";");
								}
							}finally{
								cDesgrinf.close();
							}


						}
					}
					// --------------------------------------------------------------------------------------------
					//  Tratamiento de la Lista
					// --------------------------------------------------------------------------------------------
					vLongitud = toNumber(isNull(length(vValores), 0));
					if ( substring(vValores, toInt(vLongitud), toInt(1)).notEquals(";") )
					{
						vValores = vValores.append(";");
					}
					i = toNumber(1);
					while ( inStrNullable(vValores, toStr(";")).notEquals(0) ) {
						vPosicion = toNumber(inStrNullable(vValores, toStr(";")));
						vElemento = substring(vValores, toInt(1), toInt(vPosicion.subtract(1)));
						if ( length(vElemento).greater(vTamano) )
						{
							vTamano = toNumber(length(vElemento));
						}
						vValores = substring(vValores, toInt(vPosicion.add(1)));
						//WARNING: only adding rows at the end is supported
						addGroupRow(rgId);
						setGroupCharCell("RG_LISTA.COL1", i, miTrim(vElemento));
						i = i.add(1);
					}
					setLovTitle("LV_LISTA", "Valores posibles");
					setLovGroupName("LV_LISTA", "RG_LISTA");
					// F2J_NOT_SUPPORTED : The property "LOV's LOV_SIZE" is not supported. See documentation for details.
					//					SupportClasses.FORMS4W.SetLovProperty("LV_LISTA", SupportClasses.Constants.LOV_SIZE, ((toNumber(10).multiply((vTamano.add(1))))), 280);
					this.getLogger().trace(this, "// F2J_NOT_SUPPORTED : The property 'LOV's LOV_SIZE' is not supported. See documentation for details.");
					
					setLovColumnWidth("LV_LISTA", 1, toNumber(10).multiply((vTamano.add(1))));
					setLovColumnTitle("LV_LISTA", 1, marcadorElement.getNommarca());
				}
				catch(Exception  e)
				{
					throw e;



				}
				}finally{
					cActuarios.close();
					cConcepto.close();
					cArticulo.close();








				}

















		}


	
	/* Original PL/SQL code for Prog Unit COMPRUEBA_VALORLISTA
	
	PROCEDURE comprueba_valorlista IS
    v_elemento   VARCHAR2(30)  := NULL;
    v_pos        NUMBER;
    i            NUMBER;
    v_campos     VARCHAR2(300);
    v_valores    VARCHAR2(60);
    v_long       NUMBER(5);
    v_encontrado BOOLEAN := FALSE;
BEGIN
    IF  :marcador.listaval IS NOT NULL AND :marcador.valor IS NOT NULL THEN
        -- Si el utlimo caracter no es ";" se lo añadimos
        v_long     := NVL(LENGTH(:marcador.listaval), 0);
        v_valores  := :marcador.listaval;

        IF SUBSTR(v_valores, v_long, 1) != ';' THEN
            v_valores  := v_valores || ';';
        END IF;

        i:= 1;










































        WHILE INSTR(v_valores, ';') != 0 LOOP
            v_pos      := INSTR(v_valores, ';');
            v_elemento := SUBSTR(v_valores, 1, v_pos - 1);
            v_valores  := SUBSTR(v_valores, v_pos + 1);























































            IF :marcador.valor = v_elemento THEN
                v_encontrado  := TRUE;
                EXIT;
            END IF;


























































            i:= i + 1;
        END LOOP;












        IF NOT v_encontrado THEN
            mostrar_mensaje('SUR-00857', 'E', TRUE);
        END IF;
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        cgte$other_exceptions;
END;























	*/
	//ID:375
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		*/
		public void compruebaValorlista(MarcadorAdapter marcadorElement)
		{
			NString vElemento = NString.getNull();
			NNumber vPos = NNumber.getNull();
			NNumber i = NNumber.getNull();
			NString vCampos = NString.getNull();
			NString vValores = NString.getNull();
			NNumber vLong = NNumber.getNull();
			NBool vEncontrado = toBool(NBool.False);
			try
			{
				if ( marcadorElement.getListaval().isNotNull() && marcadorElement.getValor().isNotNull() )
				{
					//  Si el utlimo caracter no es ";" se lo añadimos
					vLong = toNumber(isNull(length(marcadorElement.getListaval()), 0));
					vValores = marcadorElement.getListaval();
					if ( substring(vValores, toInt(vLong), toInt(1)).notEquals(";") )
					{
						vValores = vValores.append(";");
					}
					i = toNumber(1);
					while ( inStrNullable(vValores, toStr(";")).notEquals(0) ) {
						vPos = toNumber(inStrNullable(vValores, toStr(";")));
						vElemento = substring(vValores, toInt(1), toInt(vPos.subtract(1)));
						vValores = substring(vValores, toInt(vPos.add(1)));
						if ( marcadorElement.getValor().equals(vElemento) )
						{
							vEncontrado = toBool(NBool.True);
								break;
						}
						i = i.add(1);
					}
					if ( vEncontrado.not() )
					{
						mostrarMensaje(toStr("SUR-00857"), toStr("E"), toBool(NBool.True));





















































					}
				}
			}
			catch(Exception  e)
			{
				throw e;
			}














		}


	
	/* Original PL/SQL code for Prog Unit COMPRUEBA_INDVALIDACION
	
	PROCEDURE comprueba_indvalidacion(w_editable VARCHAR2) IS
    -- SUDEAMM0 17/09/2002
    -- Le pasamos el parametro w_editable
    -- Si es N -> comprobara solo marcadores No editables
    -- Si es S -> comprobara solo marcadores editables
    -- Si es nulo -> comprobara todos los marcadores

    fila_actual VARCHAR2(4) := :SYSTEM.cursor_record;
BEGIN
    go_block('marcador');
    last_record;
    first_record;

    LOOP
        IF  :marcador.indvalid = 'S' AND :marcador.tipmarca = NVL(w_editable, :marcador.tipmarca) THEN
            pvaldato(:temp.plantilla, :marcador.marcador, :marcador.valor);
            IF  :marcador.formarca = 'N' AND :marcador.tipmarca = 'E' THEN
                :marcador.numero  := :marcador.valor;
            ELSIF  :marcador.formarca = 'F' AND :marcador.tipmarca = 'E' THEN
                :marcador.fecha  := TO_DATE(:marcador.valor, 'dd/mm/rrrr');
            END IF;
        END IF;
        EXIT WHEN :SYSTEM.last_record = 'TRUE';
        next_record;
    END LOOP;
    go_record(TO_NUMBER(fila_actual));
END;

	*/
	//ID:376
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		* @param wEditable
		*/
		public void compruebaIndvalidacion(MarcadorAdapter marcadorElement, NString wEditable)
		{
			//  SUDEAMM0 17/09/2002
			//  Le pasamos el parametro w_editable
			//  Si es N -> comprobara solo marcadores No editables
			//  Si es S -> comprobara solo marcadores editables
			//  Si es nulo -> comprobara todos los marcadores
			NString filaActual = toStr(getCursorRecord());
			goBlock(toStr("marcador"));
			lastRecord(true);
			firstRecord(true);
			while (true) {
				if ( marcadorElement.getIndvalid().equals("S") && marcadorElement.getTipmarca().equals(isNull(wEditable, marcadorElement.getTipmarca())) )
				{
					Ref<NString> wResultado_ref = new Ref<NString>(marcadorElement.getValor());
					pvaldato(marcadorElement, getFormModel().getTemp().getPlantilla(), marcadorElement.getMarcador(), wResultado_ref);
					marcadorElement.setValor(wResultado_ref.val);
					if ( marcadorElement.getFormarca().equals("N") && marcadorElement.getTipmarca().equals("E") )
					{
						try {
							marcadorElement.setNumero(toNumber(NumberFormat.getNumberInstance(Locale.getDefault()).parse(marcadorElement.getValor().getValue())));
						} catch (ParseException e) {
							throw new ApplicationException();


































































						}
					}
					else if ( marcadorElement.getFormarca().equals("F") && marcadorElement.getTipmarca().equals("E") ) {
						marcadorElement.setFecha(toDate(marcadorElement.getValor(), "dd/mm/rrrr"));










































































































					}
				}
				if ( isInLastRecord(true) ) 
					break;
				nextRecord();
			}
			setCurrentRecord(toNumber(filaActual));

		}


	
	/* Original PL/SQL code for Prog Unit EJECUTAR_REPORT
	
	PROCEDURE ejecutar_report(p_modo VARCHAR2, p_vista VARCHAR2, p_impresora VARCHAR2 DEFAULT NULL, p_copias NUMBER DEFAULT 1) IS
    v_retorno          kgenrep.tr_retorno;
    tabla              kgenrep.ta_datos_marcador;
    v_tabla_parametros kintcomu.ta_tabla;
    r_respuesta        kgenrep.tr_retorno;
    v_ejemplar         VARCHAR2(1000);
    v_servicio         VARCHAR2(50);
    v_url              VARCHAR2(25000);
    v_estado           VARCHAR2(100);
    i                  BINARY_INTEGER := 1;
    e_preview          EXCEPTION;
    e_carga_temporal   EXCEPTION;
    e_borra_temporal   EXCEPTION;
    e_pdf              EXCEPTION;
    e_genera_pdf       EXCEPTION;
    e_fecha_erronea    EXCEPTION;
    e_direccion        EXCEPTION;
    v_idopcion         VARCHAR2(2);
BEGIN
    set_application_property(cursor_style, 'BUSY');













    IF p_vista = 'PREVIEW' THEN
        go_block('marcador');
        first_record;




























































        LOOP
            tabla(i).nommarca  := :marcador.nommarca;
            tabla(i).valor     := :marcador.valor;
            tabla(i).marcador  := :marcador.marcador;
            tabla(i).tipmarca  := :marcador.tipmarca;
            tabla(i).indoblco  := :marcador.indoblco;
            tabla(i).indvalid  := :marcador.indvalid;
            tabla(i).formarca  := :marcador.formarca;
            tabla(i).lonmarca  := :marcador.lonmarca;
            tabla(i).masmarca  := :marcador.masmarca;
            tabla(i).listaval  := :marcador.listaval;
            tabla(i).masmarc2  := :marcador.masmarc2;
            tabla(i).valmarca  := :marcador.valmarca;
            tabla(i).maxocurr  := :marcador.maxocurr;
            EXIT WHEN :SYSTEM.last_record = 'TRUE';
            next_record;
            i                  := i + 1;
        END LOOP;

        first_record;
        --IF :temp.codmodel <> 'DA0' THEN
            kgenrep.preview(v_retorno, :temp.plantilla, :temp.totalmarca, tabla, :temp.codmodel, :temp.numvermo, :temp.numerdoc);
            

            IF NVL(v_retorno.codigo, 0) <> 0 THEN
                RAISE e_preview;
            END IF;
        --END IF;    


        -- Visualiza el PDF pero no inserta en la BD.
        v_idopcion := '9';
        ejecuta_pdf(:temp.codmodel, :temp.numvermo, :temp.numerdoc, v_idopcion, p_vista, v_estado);
   
    ELSE
        -- ES PRECISO COMPROBAR SI EXISTE EL PDF ANTES.
        IF NOT k000810.fexispdf(:temp.codmodel, :temp.numvermo, :temp.numerdoc) THEN
            crea_pdf(:temp.codmodel, :temp.numvermo, :temp.numerdoc, p_vista, :temp.plantilla, v_estado); -- ES NECESARIO INDICAR EL ESTADO
        END IF;

        IF  p_modo = 'NO_OCULTO' AND p_vista = 'IMPRESION' THEN
            IF lanza_pdf_2(:temp.codmodel, :temp.numvermo, :temp.numerdoc, 'V') THEN
                NULL;
            ELSE
                RAISE e_pdf;
            END IF;
        ELSIF  p_modo = 'OCULTO' AND p_vista = 'IMPRESION' THEN
            IF lanza_pdf_2(:temp.codmodel, :temp.numvermo, :temp.numerdoc, 'I') THEN
                NULL;
            ELSE
                RAISE e_pdf;
            END IF;
        ELSIF  p_modo = 'NO_OCULTO' AND p_vista = 'VISTA' THEN
            IF lanza_pdf_2(:temp.codmodel, :temp.numvermo, :temp.numerdoc, 'V') THEN
                NULL;
            ELSE
                RAISE e_pdf;
            END IF;
        END IF;
    END IF;

    set_application_property(cursor_style, 'DEFAULT');
EXCEPTION
    WHEN e_preview THEN
        :GLOBAL.ret_810  := '10';
        mostrar_mensaje('SUR-02004 #1'|| ' Error en Kgenrep.preview #2 ' || v_retorno.codigo || ' ' || v_retorno.texto, 'E', TRUE);
    WHEN e_carga_temporal THEN
        :GLOBAL.ret_810  := '10';
        mostrar_mensaje('SUR-02004 #1'|| ' Error en Kgenrep.carga_temporal #2 ' || v_retorno.codigo || ' ' || v_retorno.texto, 'E', TRUE);
    WHEN e_borra_temporal THEN
        :GLOBAL.ret_810  := '10';
        mostrar_mensaje('SUR-02004 #1'|| ' Error en Kgenrep.borra_temporal #2 ' || v_retorno.codigo || ' ' || v_retorno.texto, 'E', TRUE);
    WHEN e_pdf THEN
        :GLOBAL.ret_810  := '10';
        mostrar_mensaje('SUR-02004 #1'|| ' Error en fichero pdf #2 ' || '505' || ' ' || 'NO SE PUEDE MOSTRAR PDF', 'E', TRUE);
    WHEN OTHERS THEN
        :GLOBAL.ret_810  := '10';
        cgte$other_exceptions;
END;

	*/
	//ID:377
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		* @param pModo
		* @param pVista
		*/
		public void ejecutarReport(MarcadorAdapter marcadorElement, EjemplaresAdapter ejemplaresElement, NString pModo, NString pVista) {
			ejecutarReport(marcadorElement,ejemplaresElement,pModo, pVista, NString.getNull(), toNumber(1));


































































		}


/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		* @param pModo
		* @param pVista
		* @param pImpresora
		*/
//		public void ejecutarReport(MarcadorAdapter marcadorElement, EjemplaresAdapter ejemplaresElement, NString pModo, NString pVista, NString pImpresora) {
//			ejecutarReport(marcadorElement, ejemplaresElement, pImpresora, toStr(1));
//		}

/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		* @param pModo
		* @param pVista
		* @param pImpresora
		* @param pCopias
		*/
		public void ejecutarReport(MarcadorAdapter marcadorElement, EjemplaresAdapter ejemplaresElement, NString pModo, NString pVista, NString pImpresora, NNumber pCopias)
		{
			Kgenrep.TrRetornoRow vRetorno = new Kgenrep.TrRetornoRow();
			Kgenrep.TaDatosMarcador tabla = new Kgenrep.TaDatosMarcador();
			Kintcomu.TaTabla vTablaParametros = new Kintcomu.TaTabla();
			Kgenrep.TrRetornoRow rRespuesta = new Kgenrep.TrRetornoRow();
			NString vEjemplar = NString.getNull();
			NString vServicio = NString.getNull();
			NString vUrl = NString.getNull();
			NString vEstado = NString.getNull();
			NInteger i = toInt(1);
			NString vIdopcion = NString.getNull();
			try
			{
				
				if ( pVista.equals("PREVIEW") )
				{
					goBlock(toStr("marcador"));
					firstRecord();
					while (true) {
						
						TaDatosMarcadorRow tablaRow = new TaDatosMarcadorRow();
						tabla.set(i, tablaRow);
						tabla.get(i).nommarca = marcadorElement.getNommarca();
						tabla.get(i).valor = marcadorElement.getValor();
						tabla.get(i).marcador = marcadorElement.getMarcador();
						tabla.get(i).tipmarca = marcadorElement.getTipmarca();
						tabla.get(i).indoblco = marcadorElement.getIndoblco();
						tabla.get(i).indvalid = marcadorElement.getIndvalid();
						tabla.get(i).formarca = marcadorElement.getFormarca();
						tabla.get(i).lonmarca = marcadorElement.getLonmarca();
						tabla.get(i).masmarca = marcadorElement.getMasmarca();
						tabla.get(i).listaval = marcadorElement.getListaval();
						tabla.get(i).masmarc2 = marcadorElement.getMasmarc2();
						tabla.get(i).valmarca = marcadorElement.getValmarca();
						tabla.get(i).maxocurr = marcadorElement.getMaxocurr();
						if ( isInLastRecord(true)) 
							break;
						nextRecord();
						i = i.add(1);
					}
					firstRecord();
					// IF :temp.codmodel <> 'DA0' THEN
					Ref<Kgenrep.TrRetornoRow> r_retorno_ref = new Ref<Kgenrep.TrRetornoRow>(vRetorno);
					Kgenrep.preview(r_retorno_ref, getFormModel().getTemp().getPlantilla(), getFormModel().getTemp().getTotalmarca(), 
					tabla, getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getNumvermo(), getFormModel().getTemp().getNumerdoc());
					
					vRetorno = r_retorno_ref.val;
					if ( isNull(vRetorno.codigo, 0).notEquals(0) )
					{
						throw new EPreview();
					}
					// END IF;    
					//  Visualiza el PDF pero no inserta en la BD.
					vIdopcion = toStr("9");
					Ref<NInteger> pEstado_ref = new Ref<NInteger>(toInt(vEstado));
					ejecutaPdf(getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getNumvermo(), getFormModel().getTemp().getNumerdoc(), vIdopcion, pVista, pEstado_ref);
					vEstado = toStr(pEstado_ref.val);
				}
				else {
					//  ES PRECISO COMPROBAR SI EXISTE EL PDF ANTES.
					if ( K000810.fexispdf(getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getNumvermo(), getFormModel().getTemp().getNumerdoc()).not() )
					{
						Ref<NString> pPlantilla_ref = new Ref<NString>(getFormModel().getTemp().getPlantilla());
						Ref<NInteger> pEstado_ref = new Ref<NInteger>(toInt(vEstado));
						creaPdf(getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getNumvermo(), getFormModel().getTemp().getNumerdoc(), pVista, pPlantilla_ref, pEstado_ref);
						getFormModel().getTemp().setPlantilla(pPlantilla_ref.val);
						vEstado = toStr(pEstado_ref.val);
					}
					if ( pModo.equals("NO_OCULTO") && pVista.equals("IMPRESION") )
					{
						if ( lanzaPdf2(ejemplaresElement, getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getNumvermo(), getFormModel().getTemp().getNumerdoc(), toStr("V")).getValue() )
						{
						}
						else {
							throw new EPdf();
						}
					}
					else if ( pModo.equals("OCULTO") && pVista.equals("IMPRESION") ) {
						if ( lanzaPdf2(ejemplaresElement, getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getNumvermo(), getFormModel().getTemp().getNumerdoc(), toStr("I")).getValue() )
						{
						}
						else {
							throw new EPdf();
						}
					}
					else if ( pModo.equals("NO_OCULTO") && pVista.equals("VISTA") ) {
						if ( lanzaPdf2(ejemplaresElement, getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getNumvermo(), getFormModel().getTemp().getNumerdoc(), toStr("V")).getValue() )
						{
						}
						else {
							throw new EPdf();
						}
					}
				}
				// F2J_NOT_SUPPORTED : The property "APPLICATION's CURSOR_STYLE" is not supported. See documentation for details.
				//				SupportClasses.FORMS40.SetApplicationProperty(SupportClasses.Property.CURSOR_STYLE, "DEFAULT");
				this.getLogger().trace(this, "// F2J_NOT_SUPPORTED : The property 'APPLICATION's CURSOR_STYLE' is not supported. See documentation for details.");
				
			}
			catch(EPreview e)
			{
				setGlobal("RET_810", toStr("10"));
				mostrarMensaje(toStr("SUR-02004 #1").append(" Error en Kgenrep.preview #2 ").append(vRetorno.codigo).append(" ").append(vRetorno.texto), toStr("E"), toBool(NBool.True));
			}
			catch(EPdf e)
			{
				setGlobal("RET_810", toStr("10"));
				mostrarMensaje(toStr("SUR-02004 #1").append(" Error en fichero pdf #2 ").append("505").append(" ").append("NO SE PUEDE MOSTRAR PDF"), toStr("E"), toBool(NBool.True));
			}
			catch(Exception  e)
			{
				setGlobal("RET_810", toStr("10"));
				throw e;
			}
		}

	
	/* Original PL/SQL code for Prog Unit COMPROBAR_OPC_INICIAL
	
	PROCEDURE comprobar_opc_inicial IS
    salida            NUMBER;
    p_estado          PLS_INTEGER;
    v_resultado       BOOLEAN        := FALSE;
    v_fichero_salida  VARCHAR2(2000);
    v_error           NUMBER         := 0;
    v_servicio         VARCHAR2(80);
    v_ejemplar         VARCHAR2(1000);
    v_modo             VARCHAR2(3);
    v_url              VARCHAR2(25000);
    v_pdf              NUMBER:=0;
    v_texto_error      VARCHAR2(1000);
    v_tabla_parametros kintcomu.ta_tabla ;    
    v_idopcion         VARCHAR2(2) ;
BEGIN
	

	
IF CONTROL_REVOCADO THEN		
	
    salida        := NULL;
    :temp.oculto  := 'Comprobando opción ...';
    go_item('temp.oculto');
    synchronize;
    :temp.codterri := kusuari.fcodter;
    IF :temp.operacion = 'CO' THEN
        comprobar_opcion(:temp.codmodel, :temp.numvermo, :temp.numerdoc, :temp.operacion, salida);
       
        IF    kfirexc.fcodagen (:temp.codterri)
          AND kfirexc.fmodsinfi (:temp.codmodel, :temp.plantilla)
          AND NOT kfirexc.fmod094(:temp.codmodel, :temp.numvermo, :temp.numerdoc)
        THEN
            IF NOT pre_control_firma THEN
                MOSTRAR_MENSAJE('No está configurada la firma para este modelo. Debe configurarse antes de continuar.','E', FALSE);
                Default_Value('80','global.ret_810'); 
                do_key('Exit_Form');
            ELSE
           	-- CONTROL FIRMA PARA RAF SSCC. UA:8015 -> RESAFSEC  UA:6012 -> RESAFDEL CUALQUIER OTRA COMBINACION ES INCORRECTA
                IF NOT kfirexc.FMODRAFSSCC(:temp.codmodel, :temp.numvermo, :temp.numerdoc, kusuari.funiadm,kusuari.fcodter ) THEN
                    MOSTRAR_MENSAJE('Unidad administrativa del usuario incorrecta.','E', FALSE);
                    Default_Value('80','global.ret_810'); 
                    do_key('Exit_Form');            	  	
                END IF;
            END IF;
        END IF;

        IF salida = 0 THEN
--        	  IF :temp.codmodel <> 'DA0' THEN
                go_block('marcador');
                do_key('execute_query');
                synchronize;
                go_block('mi_bloque');
                synchronize;
                go_item('marcador.valor_mirror');
-- Queda preparado el código para la llamada a la generación del documento DA0
--        	  ELSE
--        	      PGENDA0(NULL, NULL, NULL
--                       , :parameter.p_expedi_codcircu
--                       , :parameter.p_expedi_codterri
--                       , :parameter.p_expedi_ejeexped
--                       , :parameter.p_expedi_numexped
--                       , :parameter.p_numordtr
--                       , 'E'   -- Tipo de firma
--                       , 'D'    -- Tipo accion
--                       , v_error
--                       , v_texto_error
--                       , :temp.codmodel, :temp.numvermo, :temp.numerdoc
--                       );
--                IF v_error = 1 THEN
--                	  mostrar_mensaje(SUBSTR(v_texto_error,1,250), 'I', FALSE);
                	  -- Se devuelve '2' (No es posible construir el documento)
--                	  :GLOBAL.ret_810  := '2';
--                    do_key('Exit_Form');
--                ELSE
--                    tratamiento_ejemplares;
--                END IF;
--        	  END IF;
        ELSIF salida <> 0 THEN
            :GLOBAL.ret_810  := salida;
            do_key('Exit_Form');
        ELSIF salida IS NULL THEN
            :GLOBAL.ret_810  := '10';
            do_key('Exit_Form');
        END IF;
    ELSIF :temp.operacion = 'BO' THEN
        comprobar_opcion(:temp.codmodel, :temp.numvermo, :temp.numerdoc, :temp.operacion, salida);

        IF salida = 0 THEN
            go_block('marcador');
            do_key('execute_query');
            synchronize;
            go_block('mi_bloque');
            synchronize;
            go_item('marcador.valor_mirror');
        ELSIF salida <> 0 THEN
            :GLOBAL.ret_810  := salida;
            do_key('Exit_Form');
        ELSIF salida IS NULL THEN
            :GLOBAL.ret_810  := '10';
            do_key('Exit_Form');
        END IF;
    ELSIF :temp.operacion = 'I1' THEN
        comprobar_opcion(:temp.codmodel, :temp.numvermo, :temp.numerdoc, :temp.operacion, salida);

        IF salida = 0 THEN
        	  v_idopcion := '22';
        	  pimpresion_directa(v_idopcion);
            mostrar_canvas_impresion;
            :GLOBAL.ret_810  := salida;
        ELSIF salida <> 0 THEN
            :GLOBAL.ret_810  := salida;
            do_key('Exit_Form');
        ELSIF salida IS NULL THEN
            :GLOBAL.ret_810  := '10';
            do_key('Exit_Form');
        END IF;
    ELSIF :temp.operacion = 'I2' THEN
        comprobar_opcion(:temp.codmodel, :temp.numvermo, :temp.numerdoc, :temp.operacion, salida);

        IF salida = 0 THEN
        	  v_idopcion := '23';
        	  pimpresion_directa(v_idopcion);
            :GLOBAL.ret_810  := salida;

        ELSIF salida <> 0 THEN
            :GLOBAL.ret_810  := salida;
            do_key('Exit_Form');
        ELSIF salida IS NULL THEN
            :GLOBAL.ret_810  := '10';
            do_key('Exit_Form');
        END IF;
    ELSIF :temp.operacion = 'DU' THEN
        comprobar_opcion(:temp.codmodel, :temp.numvermo, :temp.numerdoc, :temp.operacion, salida);

        IF salida = 0 THEN
            mostrar_canvas_impresion;
            ejecutar_report('NO_OCULTO', 'IMPRESION');
            :GLOBAL.ret_810  := salida;
            do_key('Exit_Form');
        ELSIF salida <> 0 THEN
            :GLOBAL.ret_810  := salida;
            do_key('Exit_Form');
        ELSIF salida IS NULL THEN
            :GLOBAL.ret_810  := '10';
            do_key('Exit_Form');
        END IF;
    ELSIF :temp.operacion = 'VI' THEN
        comprobar_opcion(:temp.codmodel, :temp.numvermo, :temp.numerdoc, :temp.operacion, salida);

        IF salida = 0 THEN
            mostrar_canvas_impresion;
            ejecutar_report('NO_OCULTO', 'VISTA');
            :GLOBAL.ret_810  := salida;
            do_key('Exit_Form');
        ELSIF salida <> 0 THEN
            :GLOBAL.ret_810  := salida;
            do_key('Exit_Form');
        ELSIF salida IS NULL THEN
            :GLOBAL.ret_810  := '10';
            do_key('Exit_Form');
        END IF;
    END IF;

ELSE

    Default_Value('80','global.ret_810'); 
    do_key('Exit_Form');

END IF;

EXCEPTION
    WHEN OTHERS THEN
        cgte$other_exceptions;
END;

	*/
	//ID:378
	/* <p>
/* </p>
		*/
		public void comprobarOpcInicial(MarcadorAdapter marcadorElement, EjemplaresAdapter ejemplaresElement)
		{
			NNumber salida = NNumber.getNull();
			NInteger pEstado = NInteger.getNull();
			NBool vResultado = toBool(NBool.False);
			NString vFicheroSalida = NString.getNull();
			NNumber vError = toNumber(0);
			NString vServicio = NString.getNull();
			NString vEjemplar = NString.getNull();
			NString vModo = NString.getNull();
			NString vUrl = NString.getNull();
			NNumber vPdf = toNumber(0);
			NString vTextoError = NString.getNull();
			Kintcomu.TaTabla vTablaParametros = new Kintcomu.TaTabla();
			NString vIdopcion = NString.getNull();
			try
			{
				if ( controlRevocado().getValue() )
				{
					salida = toNumber(null);
					getFormModel().getTemp().setOculto(toStr("Comprobando opción ..."));
					goItem(toStr("temp.oculto"));
					synchronize();
					getFormModel().getTemp().setCodterri(Kusuari.fcodter());
					if ( getFormModel().getTemp().getOperacion().equals("CO") )
					{
						Ref<NNumber> salida_ref = new Ref<NNumber>(salida);
						comprobarOpcion(getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getNumvermo(), getFormModel().getTemp().getNumerdoc(), getFormModel().getTemp().getOperacion(), salida_ref);
						salida = salida_ref.val;
						if ( Kfirexc.fcodagen(getFormModel().getTemp().getCodterri()).getValue() && 
								Kfirexc.fmodsinfi(getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getPlantilla()).getValue() && 
								Kfirexc.fmod094(getFormModel().getTemp().getCodmodel(), 
										getFormModel().getTemp().getNumvermo(),
										getFormModel().getTemp().getNumerdoc()).not() )
						{
							if ( preControlFirma().not() )
							{
								mostrarMensaje(toStr("No está configurada la firma para este modelo. Debe configurarse antes de continuar."), toStr("E"), toBool(NBool.False));
								setDefaultValue("80", "global.ret_810");
								executeAction(KeyFunction.EXIT);
							}
							else {
								//  CONTROL FIRMA PARA RAF SSCC. UA:8015 -> RESAFSEC  UA:6012 -> RESAFDEL CUALQUIER OTRA COMBINACION ES INCORRECTA
								if ( Kfirexc.fmodrafsscc(getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getNumvermo(), getFormModel().getTemp().getNumerdoc(), Kusuari.funiadm(), Kusuari.fcodter()).not() )
								{
									mostrarMensaje(toStr("Unidad administrativa del usuario incorrecta."), toStr("E"), toBool(NBool.False));
									setDefaultValue("80", "global.ret_810");
									executeAction(KeyFunction.EXIT);
								}
							}
						}
						if ( salida.equals(0) )
						{
							//         	  IF :temp.codmodel <> 'DA0' THEN
							goBlock(toStr("marcador"));
							executeAction(KeyFunction.EXECUTE_QUERY);
							synchronize();
							goBlock(toStr("mi_bloque"));
							synchronize();
							goItem(toStr("marcador.valor_mirror"));
						}
						else if ( salida.notEquals(0) ) {
							setGlobal("RET_810", toStr(salida));
							executeAction(KeyFunction.EXIT);
						}
						else if ( salida.isNull() ) {
							setGlobal("RET_810", toStr("10"));
							executeAction(KeyFunction.EXIT);
						}
					}
					else if ( getFormModel().getTemp().getOperacion().equals("BO") ) {
						Ref<NNumber> salida_ref = new Ref<NNumber>(salida);
						comprobarOpcion(getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getNumvermo(), getFormModel().getTemp().getNumerdoc(), getFormModel().getTemp().getOperacion(), salida_ref);
						salida = salida_ref.val;
						if ( salida.equals(0) )
						{
							goBlock(toStr("marcador"));
							executeAction(KeyFunction.EXECUTE_QUERY);
							synchronize();
							goBlock(toStr("mi_bloque"));
							synchronize();
							goItem(toStr("marcador.valor_mirror"));
						}
						else if ( salida.notEquals(0) ) {
							setGlobal("RET_810", toStr(salida));
							executeAction(KeyFunction.EXIT);
						}
						else if ( salida.isNull() ) {
							setGlobal("RET_810", toStr("10"));
							executeAction(KeyFunction.EXIT);
						}
					}
					else if ( getFormModel().getTemp().getOperacion().equals("I1") ) {
						Ref<NNumber> salida_ref = new Ref<NNumber>(salida);
						comprobarOpcion(getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getNumvermo(), getFormModel().getTemp().getNumerdoc(), getFormModel().getTemp().getOperacion(), salida_ref);
						salida = salida_ref.val;
						if ( salida.equals(0) )
						{
							vIdopcion = toStr("22");
							pimpresionDirecta(vIdopcion);
							mostrarCanvasImpresion();
							setGlobal("RET_810", toStr(salida));
							executeAction(KeyFunction.EXIT);
						}
						else if ( salida.notEquals(0) ) {
							setGlobal("RET_810", toStr(salida));
							executeAction(KeyFunction.EXIT);
						}
						else if ( salida.isNull() ) {
							setGlobal("RET_810", toStr("10"));
							executeAction(KeyFunction.EXIT);
						}
					}
					else if ( getFormModel().getTemp().getOperacion().equals("I2") ) {
						Ref<NNumber> salida_ref = new Ref<NNumber>(salida);
						comprobarOpcion(getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getNumvermo(), getFormModel().getTemp().getNumerdoc(), getFormModel().getTemp().getOperacion(), salida_ref);
						salida = salida_ref.val;
						if ( salida.equals(0) )
						{
							vIdopcion = toStr("23");
							pimpresionDirecta(vIdopcion);
							setGlobal("RET_810", toStr(salida));
						}
						else if ( salida.notEquals(0) ) {
							setGlobal("RET_810", toStr(salida));
							executeAction(KeyFunction.EXIT);
						}
						else if ( salida.isNull() ) {
							setGlobal("RET_810", toStr("10"));
							executeAction(KeyFunction.EXIT);
						}
					}
					else if ( getFormModel().getTemp().getOperacion().equals("DU") ) {
						Ref<NNumber> salida_ref = new Ref<NNumber>(salida);
						comprobarOpcion(getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getNumvermo(), getFormModel().getTemp().getNumerdoc(), getFormModel().getTemp().getOperacion(), salida_ref);
						salida = salida_ref.val;
						if ( salida.equals(0) )
						{
							mostrarCanvasImpresion();
							ejecutarReport(marcadorElement, ejemplaresElement, toStr("NO_OCULTO"), toStr("IMPRESION"));
							setGlobal("RET_810", toStr(salida));
							executeAction(KeyFunction.EXIT);
						}
						else if ( salida.notEquals(0) ) {
							setGlobal("RET_810", toStr(salida));
							executeAction(KeyFunction.EXIT);
						}
						else if ( salida.isNull() ) {
							setGlobal("RET_810", toStr("10"));
							executeAction(KeyFunction.EXIT);
						}
					}
					else if ( getFormModel().getTemp().getOperacion().equals("VI") ) {
						Ref<NNumber> salida_ref = new Ref<NNumber>(salida);
						comprobarOpcion(getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getNumvermo(), getFormModel().getTemp().getNumerdoc(), getFormModel().getTemp().getOperacion(), salida_ref);
						salida = salida_ref.val;
						if ( salida.equals(0) )
						{
							mostrarCanvasImpresion();
							ejecutarReport(marcadorElement, ejemplaresElement, toStr("NO_OCULTO"), toStr("VISTA"));
							setGlobal("RET_810", toStr(salida));
							executeAction(KeyFunction.EXIT);
						}
						else if ( salida.notEquals(0) ) {
							setGlobal("RET_810", toStr(salida));
							executeAction(KeyFunction.EXIT);
						}
						else if ( salida.isNull() ) {
							setGlobal("RET_810", toStr("10"));
							executeAction(KeyFunction.EXIT);
						}
					}
				}
				else {
					setDefaultValue("80", "global.ret_810");
					executeAction(KeyFunction.EXIT);
				}
			}
			catch(Exception  e)
			{
				throw e;
			}
		}

	
	/* Original PL/SQL code for Prog Unit MOSTRAR_CANVAS_IMPRESION
	
	PROCEDURE mostrar_canvas_impresion IS
BEGIN
   go_item('temp.oculto');
   if :parameter.p_operacion = 'I1' then
     :temp.oculto := 'Imprimiendo Documento ...';

   elsif :parameter.p_operacion = 'I2' then
     :temp.oculto := 'Imprimiendo Duplicado ...';

   elsif :parameter.p_operacion = 'DU' then
     :temp.oculto := 'Visualizando Duplicado ...';

   elsif :parameter.p_operacion = 'VI' then
     :temp.oculto := 'Visualizando Documento ...';

   end if;

   go_item('temp.oculto');  
   synchronize;
END;
	*/
	//ID:379
	/* <p>
		* F2J_WEAK_PRESENTATION_LOGIC : The code of this procedure was identified as containing presentation logic. See documentation for details.
/* </p>
		*/
		public void mostrarCanvasImpresion()
		{
			goItem(toStr("temp.oculto"));
			if ( this.getFormModel().getParam("P_OPERACION", NString.class).equals("I1") )
			{
				getFormModel().getTemp().setOculto(toStr("Imprimiendo Documento ..."));
			}
			else if ( this.getFormModel().getParam("P_OPERACION", NString.class).equals("I2") ) {
				getFormModel().getTemp().setOculto(toStr("Imprimiendo Duplicado ..."));
			}
			else if ( this.getFormModel().getParam("P_OPERACION", NString.class).equals("DU") ) {
				getFormModel().getTemp().setOculto(toStr("Visualizando Duplicado ..."));
			}
			else if ( this.getFormModel().getParam("P_OPERACION", NString.class).equals("VI") ) {
				getFormModel().getTemp().setOculto(toStr("Visualizando Documento ..."));
			}
			goItem(toStr("temp.oculto"));
			synchronize();
		}

	
	/* Original PL/SQL code for Prog Unit CONSTRUIR_MASCARA
	
	FUNCTION construir_mascara
    RETURN VARCHAR2 IS
    v_salida     VARCHAR2(100);
    v_lonmarca   VARCHAR2(100);
    v_pos_coma   NUMBER        := 0;
    LONG         NUMBER        := 0;
    entera       VARCHAR2(100) := 0;
    DECIMAL      VARCHAR2(100) := 0;
    n_entera     NUMBER        := 0;
    n_decimal    NUMBER        := 0;
    num_grupo_3  NUMBER        := 0;
    v_resto      NUMBER        := 0;
BEGIN
    v_lonmarca  := TO_CHAR(:marcador.lonmarca);
    v_pos_coma  := INSTR(v_lonmarca, ',', 1);
    LONG        := LENGTH(v_lonmarca);

    IF v_pos_coma = 0 THEN
        n_entera     := TO_NUMBER(v_lonmarca);
        num_grupo_3  := NVL(TRUNC(n_entera / 3), 0);
        v_resto      := MOD(n_entera, 3);

        FOR i IN 1 .. num_grupo_3 LOOP
            v_salida  := v_salida || 'G999';
        END LOOP;

        IF v_resto = 0 THEN
            v_salida  := SUBSTR(v_salida, 2, LENGTH(v_salida) - 1);
        ELSE
            v_salida  := LPAD(NVL(v_salida, '9'), v_resto + NVL(LENGTH(v_salida), 0), '9');
        END IF;
    ELSE
        entera       := SUBSTR(:marcador.lonmarca, 1, v_pos_coma - 1);
        DECIMAL      := SUBSTR(:marcador.lonmarca, v_pos_coma + 1, LONG - v_pos_coma + 1);
        n_entera     := TO_NUMBER(entera);
        num_grupo_3  := TRUNC(n_entera / 3);
        v_resto      := MOD(n_entera, 3);

        FOR i IN 1 .. num_grupo_3 LOOP
            v_salida  := v_salida || 'G999';
        END LOOP;

        IF v_resto = 0 THEN
            v_salida  := SUBSTR(v_salida, 2, LENGTH(v_salida) - 1);
        ELSE
            v_salida  := LPAD(NVL(v_salida, '9'), v_resto + NVL(LENGTH(v_salida), 0), '9');
        END IF;

        n_decimal    := TO_NUMBER(DECIMAL);
        v_salida       := v_salida || 'D' || RPAD('9', n_decimal - 1, '9') || '0';
    END IF;

    v_salida    := 'FM' || v_salida;
    RETURN (v_salida);
END;

	*/
	//ID:380

		
		public NString construirMascara(MarcadorAdapter marcadorElement) {
			
			NString vSalida = NString.getNull();	
			NString vLonmarca  = NString.getNull();
			NNumber vPosComa = toNumber(0);
			NNumber LONG =toNumber(0);
			NString entera  = new NString("0");
			NString DECIMAL  = new NString("0");
			NNumber nEntera = toNumber(0);
			NNumber nDecimal = toNumber(0);
			NNumber numGrupo3 = toNumber(0);
			NNumber vResto = toNumber(0);
				
			vLonmarca = toChar(marcadorElement.getLonmarca());
			vPosComa = toNumber(inStr(vLonmarca, toStr(','), 1));
			LONG = toNumber(length(vLonmarca));
			
			if (vPosComa.equals(toNumber(0))) {
				
				nEntera = toNumber(vLonmarca);
				numGrupo3 = isNull(trunc(nEntera.divide(toNumber(3))), 0);
				vResto = mod(nEntera, 3);
				
				for (int i = 0; i < numGrupo3.toInt32(); i++) {
					vSalida = vSalida.append(toStr("G999"));
				}
				if (vResto.equals(toNumber(0))) {
					vSalida = substring(vSalida, 2, toNumber(length(vSalida).subtract(1)));
				} else {
					vSalida = lpad(isNull(vSalida, "9"),vResto.add(isNull(length(vSalida), 0)) ,"9");
				}
			} else {
				
				entera = substring(toStr(marcadorElement.getLonmarca()), 1, vPosComa.subtract(1));
				DECIMAL = substring(toStr(marcadorElement.getLonmarca()), vPosComa.add(1), LONG.subtract(vPosComa).add(1));
				nEntera = toNumber(entera);
				numGrupo3 = trunc(nEntera.divide(3));
				vResto = mod(nEntera, 3);
				
				for (int i = 0; i < numGrupo3.toInt32(); i++) {
					vSalida = vSalida.append(toStr("G999"));
				}
				
				if (vResto.equals(toNumber(0))) {
					vSalida = substring(vSalida, 2, toNumber(length(vSalida).subtract(1)));
				} else {
					vSalida = lpad(isNull(vSalida, "9"),vResto.add(isNull(length(vSalida), 0)) ,"9");
				}
				
				nDecimal = toNumber(DECIMAL);
				vSalida = vSalida.append("D").append(rpad("9",nDecimal.subtract(1).toInt32(),"9")).append("0");
			}
			
			vSalida = toStr("FM").append(vSalida);
			return vSalida;
			
			}

	
	/* Original PL/SQL code for Prog Unit CONSTRUIR_ITEMS
	
	PROCEDURE construir_items IS
BEGIN
     -- Solo deja actualizar aquellos campos que son EDITABLES.
    IF :marcador.tipmarca = 'N' THEN
        set_item_property('marcador.valor',visible,property_TRUE); 
        set_item_property('marcador.valor',enabled,property_true); 
        set_item_property('marcador.valor',update_allowed,property_FALSE); 
        set_item_property('marcador.fecha',visible,property_FALSE); 
        set_item_property('marcador.numero',visible,property_FALSE); 
    ELSIF :marcador.tipmarca = 'E' AND :marcador.formarca = 'F' THEN
        set_item_property('marcador.valor',visible,property_FALSE); 
        set_item_property('marcador.fecha',visible,property_TRUE); 
        set_item_property('marcador.fecha',enabled,property_TRUE); 
        set_item_property('marcador.fecha',update_allowed,property_TRUE); 
        set_item_property('marcador.fecha',prompt_text,nls_initcap(lower(:marcador.nommarca))); 
        set_item_property('marcador.numero',visible,property_FALSE); 
    ELSIF :marcador.tipmarca = 'E' AND :marcador.formarca = 'N' THEN
        set_item_property('marcador.valor',visible,property_FALSE); 
        set_item_property('marcador.fecha',visible,property_FALSE); 
        set_item_property('marcador.numero',visible,property_TRUE); 
        set_item_property('marcador.numero',enabled,property_TRUE); 
        set_item_property('marcador.numero',update_allowed,property_true); 
        set_item_property('marcador.numero',prompt_text,nls_initcap(lower(:marcador.nommarca))); 

    ELSIF :marcador.tipmarca = 'E' AND NVL(:marcador.formarca,'A') = 'A' THEN
        set_item_property('marcador.valor',visible,property_TRUE); 
        set_item_property('marcador.valor',enabled,property_TRUE); 
        set_item_property('marcador.valor',update_allowed,property_true); 
        set_item_property('marcador.fecha',visible,property_FALSE); 
        set_item_property('marcador.numero',visible,property_FALSE); 
    END IF;   

    IF :marcador.listaval IS NOT NULL AND :marcador.tipmarca = 'E' THEN
        SET_ITEM_PROPERTY('marcador.PB_VALOR',DISPLAYED,PROPERTY_TRUE);
        SET_ITEM_PROPERTY('marcador.PB_VALOR',ENABLED,PROPERTY_TRUE);
        tratar_lovs;         
    ELSE     
        SET_ITEM_PROPERTY('marcador.PB_VALOR',DISPLAYED,PROPERTY_FALSE);
        SET_ITEM_PROPERTY('marcador.PB_VALOR',ENABLED,PROPERTY_FALSE);
    END IF;
END;
	*/
	//ID:381
	/* <p>
/* </p>
		*/
		public void construirItems(MarcadorAdapter marcadorElement)
		{
			//  Solo deja actualizar aquellos campos que son EDITABLES.
			if ( marcadorElement.getTipmarca().equals("N") )
			{
				setItemVisible("marcador.valor", true);
				setItemEnabled("marcador.valor", true);
				setItemUpdateAllowed("marcador.valor", false);
				setItemVisible("marcador.fecha", false);
				setItemVisible("marcador.numero", false);
			}
			else if ( marcadorElement.getTipmarca().equals("E") && marcadorElement.getFormarca().equals("F") ) {
				setItemVisible("marcador.valor", false);
				setItemVisible("marcador.fecha", true);
				setItemEnabled("marcador.fecha", true);
				setItemUpdateAllowed("marcador.fecha", true);
//				setItemPromptText("marcador.fecha", SupportClasses.STANDARD.NlsInitcap(lower(marcadorElement.getNommarca())));
				setItemVisible("marcador.numero", false);
			}
			else if ( marcadorElement.getTipmarca().equals("E") && marcadorElement.getFormarca().equals("N") ) {
				setItemVisible("marcador.valor", false);
				setItemVisible("marcador.fecha", false);
				setItemVisible("marcador.numero", true);
				setItemEnabled("marcador.numero", true);
				setItemUpdateAllowed("marcador.numero", true);
//				setItemPromptText("marcador.numero", SupportClasses.STANDARD.NlsInitcap(lower(marcadorElement.getNommarca())));
			}
			else if ( marcadorElement.getTipmarca().equals("E") && isNull(marcadorElement.getFormarca(), "A").equals("A") ) {
				setItemVisible("marcador.valor", true);
				setItemEnabled("marcador.valor", true);
				setItemUpdateAllowed("marcador.valor", true);
				setItemVisible("marcador.fecha", false);
				setItemVisible("marcador.numero", false);
			}
			if ( marcadorElement.getListaval().isNotNull() && marcadorElement.getTipmarca().equals("E") )
			{
				setItemVisible("marcador.PB_VALOR", true);
				setItemEnabled("marcador.PB_VALOR", true);
				tratarLovs(marcadorElement);
			}
			else {
				setItemVisible("marcador.PB_VALOR", false);
				setItemEnabled("marcador.PB_VALOR", false);
			}
		}

	
	/* Original PL/SQL code for Prog Unit COMPROBAR_OPCION
	
	PROCEDURE comprobar_opcion(P_MODELO IN VARCHAR2, P_VERSION IN VARCHAR2, P_DOCUMENTO IN VARCHAR2, 
                           P_OPERACION IN VARCHAR2 , salida out number) IS



P_IDPLANTI varchar2(12); -- sudeamm0 30/07/2003 de V(8) a V(12)
aux varchar2(3);
SERVER_ERR NUMBER;
SERVER_MSG VARCHAR2(2000);

BEGIN
<multilinecomment>************************************************************</multilinecomment> 
<multilinecomment> FUNCION FCTRDOSA (CONTROL DOCUMENTOS DE SALIDA)            </multilinecomment>
<multilinecomment> CODIGO DE RETORNO:                                         </multilinecomment>
<multilinecomment>  0 OK.                                                     </multilinecomment>
<multilinecomment>  1 NO EXISTE EN DOCUMENTO EN SU_DOCUNI                     </multilinecomment>
<multilinecomment>  2 NO ES POSIBLE CONSTRUIR EL DOCUMENTO                    </multilinecomment>
<multilinecomment>  3 NO ES POSIBLE DUPLICAR EL DOCUMENTO                     </multilinecomment>
<multilinecomment>  4 NO ES POSIBLE IMPRIMIR EL DOCUMENTO                     </multilinecomment>
<multilinecomment>  5 NO ES POSIBLE MODO BORRADOR (SIN CONSTRUIR)             </multilinecomment>
<multilinecomment>  6 NO ES POSIBLE MODO BORRADOR (TIPO DE MODELO INCORRECTO) </multilinecomment>
<multilinecomment>  7 NO ES POSIBLE MODO BORRADOR                             </multilinecomment>
<multilinecomment>  8 NO EXISTE PLANTILLA                                     </multilinecomment>
<multilinecomment>  9 NO EXISTE DOCUMENTO EN SU_ARCHIV                        </multilinecomment>
<multilinecomment>  SUR-01823 al SUR-01831                                    </multilinecomment>
<multilinecomment>************************************************************</multilinecomment>


   begin
      salida:=KGENCTRL.FCTRDOSA (P_MODELO, P_VERSION , P_DOCUMENTO ,P_OPERACION , P_IDPLANTI );
 
   exception 
   when others then
        salida := null;
        SERVER_ERR := DBMS_ERROR_CODE;
        SERVER_MSG := DBMS_ERROR_TEXT;
        CAPTURAR_ERROR(SERVER_ERR,SERVER_MSG);    
   end ;

   :temp.plantilla := p_idplanti;

   if salida = 0 then
     -- No se ha producido ningún error.
     null;
   elsif salida = 1 then
     mostrar_mensaje('SUR-01823','E',TRUE);
   elsif salida = 2 then
     mostrar_mensaje('SUR-01824','E',TRUE);
   elsif salida = 3 then
     mostrar_mensaje('SUR-01825','E',TRUE);
   elsif salida = 4 then
     mostrar_mensaje('SUR-01826','E',TRUE);
   elsif salida = 5 then
     mostrar_mensaje('SUR-01827','E',TRUE);
   elsif salida = 6 then
     mostrar_mensaje('SUR-01828','E',TRUE);
   elsif salida = 7 then
     mostrar_mensaje('SUR-01829','E',TRUE);
   elsif salida = 8 then
     mostrar_mensaje('SUR-01830','E',TRUE);
   elsif salida = 9 then
     mostrar_mensaje('SUR-01831','E',TRUE);
   end if;
exception
when others then
null;   
END;
	*/
	//ID:382
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		* @param pModelo
		* @param pVersion
		* @param pDocumento
		* @param pOperacion
		* @param salida
		*/
		public void comprobarOpcion(NString pModelo, NString pVersion, NString pDocumento, NString pOperacion, Ref<NNumber> salida)
		{
			NString pIdplanti = NString.getNull();
			//  sudeamm0 30/07/2003 de V(8) a V(12)
			NString aux = NString.getNull();
			NNumber serverErr = NNumber.getNull();
			NString serverMsg = NString.getNull();
			try
			{
				try
				{
					Ref<NString> p_idplanti_ref = new Ref<NString>(pIdplanti);
					salida.val = Kgenctrl.fctrdosa(pModelo, pVersion, pDocumento, pOperacion, p_idplanti_ref);
					pIdplanti = p_idplanti_ref.val;
				}
				catch(Exception  e)
				{
					salida.val = toNumber(null);
					serverErr = toNumber(errorCode());
					serverMsg = errorMessage();
					getTask().getSur().capturarError(serverErr, serverMsg);
				}
				getFormModel().getTemp().setPlantilla(pIdplanti);
				if ( salida.val.equals(0) )
				{
					//  No se ha producido ningún error.
				}
				else if ( salida.val.equals(1) ) {
					mostrarMensaje(toStr("SUR-01823"), toStr("E"), toBool(NBool.True));
				}
				else if ( salida.val.equals(2) ) {
					mostrarMensaje(toStr("SUR-01824"), toStr("E"), toBool(NBool.True));
				}
				else if ( salida.val.equals(3) ) {
					mostrarMensaje(toStr("SUR-01825"), toStr("E"), toBool(NBool.True));
				}
				else if ( salida.val.equals(4) ) {
					mostrarMensaje(toStr("SUR-01826"), toStr("E"), toBool(NBool.True));
				}
				else if ( salida.val.equals(5) ) {
					mostrarMensaje(toStr("SUR-01827"), toStr("E"), toBool(NBool.True));
				}
				else if ( salida.val.equals(6) ) {
					mostrarMensaje(toStr("SUR-01828"), toStr("E"), toBool(NBool.True));
				}
				else if ( salida.val.equals(7) ) {
					mostrarMensaje(toStr("SUR-01829"), toStr("E"), toBool(NBool.True));
				}
				else if ( salida.val.equals(8) ) {
					mostrarMensaje(toStr("SUR-01830"), toStr("E"), toBool(NBool.True));
				}
				else if ( salida.val.equals(9) ) {
					mostrarMensaje(toStr("SUR-01831"), toStr("E"), toBool(NBool.True));
				}
			}
			catch(Exception  e)
			{



















			}

		}


	
	/* Original PL/SQL code for Prog Unit PVALDATO
	
	procedure pvaldato (e_planti_codplant in varchar2, w_marcador in varchar2,
                    w_resultado out varchar2)
IS                    
    CURSOR c_articulo(pc_descripcion IN VARCHAR2) IS
        SELECT rv_low_value articulo
          FROM cg_ref_codes
         WHERE rv_domain = 'ARTICULO INFRACCION TRIBUTARIA'
           AND rv_meaning = pc_descripcion
         ORDER BY rv_low_value;   

    CURSOR c_grado(pc_artinftr IN VARCHAR2, pc_desgrinf IN VARCHAR2) IS
        SELECT gradinfr grado
          FROM su_parsan
         WHERE artinftr = pc_artinftr
           AND desgrinf = pc_desgrinf;

    CURSOR c_califica(pc_artinftr IN VARCHAR2, pc_desgrinf IN VARCHAR2) IS
        SELECT calinftr califica
          FROM su_parsan
         WHERE artinftr = pc_artinftr
           AND desgrinf = pc_desgrinf;
           
    CURSOR c_descgrado(pc_valor IN VARCHAR2) IS
        SELECT rv_abbreviation
          FROM cg_ref_codes
         WHERE rv_domain = 'GRADO INFRACCION TRIBUTARIA'
           AND rv_low_value = pc_valor;
 
    w_aux                 VARCHAR2(4000);
    w_tmp                 NUMBER;
    w_h1c065              NUMBER:=0;
    w_h1c075              NUMBER:=0;
    w_h1c085              NUMBER:=0;
    w_h1c084              NUMBER:=0;
    w_h1c089              NUMBER:=0;
    w_h1c052              NUMBER:=0;
    w_h1c061              NUMBER:=0;
    w_h1c062              NUMBER:=0;
    w_h1c064              NUMBER:=0;
    w_h1c031              VARCHAR2(10);
    w_h1c050              VARCHAR2(4000);
    w_h1c075_inspec       NUMBER:=0;
    v_conteo              NUMBER:=0;
    v_existe              NUMBER:=0;
    v_modelo              VARCHAR2(3);
    v_version             VARCHAR2(1);
    v_numerdoc            VARCHAR2(9);
    v_doc_orig            VARCHAR2(13);
    j                     binary_integer:=0;
    w_h1c004              VARCHAR2 (4000);
    w_h1c019              VARCHAR2 (6);
    w_h1c021              VARCHAR2 (4000); 
    w_h1c023              VARCHAR2 (4000);
    w_h1c024              VARCHAR2 (4000);
    w_h1c025              VARCHAR2 (4000);
    w_h1c027              VARCHAR2 (4000);
    w_h1c040              VARCHAR2 (4000);
    w_h1c041              VARCHAR2 (4000);
    w_h1c055              VARCHAR2 (4000);
    w_gradoinfr           VARCHAR2 (4000);
    w_articinfr           VARCHAR2 (4000);
    w_articulo            VARCHAR2 (4000);
    w_grado               VARCHAR2 (5);
    w_plazoing0           VARCHAR2 (4000);
    w_jun_tea_0           VARCHAR2 (4000);
    w_form_1              VARCHAR2 (4000);
    w_form_3              VARCHAR2 (4000);
    w_form_6              VARCHAR2 (4000);
    w_form_10             VARCHAR2 (4000);
    w_form_14             VARCHAR2 (4000);
    w_form_15             VARCHAR2 (4000);
    w_form_17             VARCHAR2 (4000);
    w_form_19             VARCHAR2 (4000);
    W_CONNECT_1           VARCHAR2 (4000);
    w_firrinsp            VARCHAR2 (4000);
    w_arti_0              VARCHAR2 (4000);
    w_codmodel            VARCHAR2 (3);
    w_numvermo            VARCHAR2 (1);
    w_codterri            VARCHAR2 (6);
    w_form_20             VARCHAR2 (4000);
    w_rec_sscc            VARCHAR2 (4000);    
    TEXTO1                VARCHAR2 (4000);
    TEXTO2                VARCHAR2 (4000);
    w_plazpago            VARCHAR2 (4000);
    w_viagenli            VARCHAR2 (1);
    w_conceptos_genericos VARCHAR2 (60);
    w_fecaccide           VARCHAR2 (10);
    w_fecha031            DATE;
    v_fecha_propuesta     DATE;
    v_recurso_1           VARCHAR2 (4000);
    v_INDVTONO            su_liquid.indvtono%TYPE;
    v_expedi_codcircu     su_docexp.expedi_codcircu%TYPE;
    v_expedi_codterri     su_docexp.expedi_codterri%TYPE;
    v_expedi_ejeexped     su_docexp.expedi_ejeexped%TYPE;
    v_expedi_numexped     su_docexp.expedi_numexped%TYPE;
    v_domici              NUMBER := 0;
    v_coddomic            VARCHAR2(10);  
    v_ejercici            NUMBER;
    v_inslar_codareac     VARCHAR2(2);
    v_inslar_codclase     VARCHAR2(1); 
    v_inslar_codlinar     VARCHAR2(2);
    v_inslej_ejercici     NUMBER;         
    v_inslej_codareac     VARCHAR2(2);
    v_inslej_codclase     VARCHAR2(1); 
    v_inslej_codlinar     VARCHAR2(2);    
    v_h1c021              VARCHAR2(50);
    ta_datos              K000810.ta_datos;
    fila_actual varchar2(4) := :system.cursor_record;
    v_linea_ok            NUMBER; 
    v_origen						  VARCHAR2(13);
    v_ejercicio_docins    NUMBER;

   
BEGIN
    w_codmodel := SUBSTR (E_PLANTI_CODPLANT,1,3);
    w_numvermo := SUBSTR (E_PLANTI_CODPLANT,4,1);
    
    TEXTO1 := 'que "las autoridades, cualesquiera que sea su naturaleza,los jefes o'||' '||
              'encargados de oficinas civiles o militares del Estado y de los demás'||' '||
              'entes públicos territoriales, los organismos autónomos y sociedades'||' '|| 
              'estatales; las Cámaras y corporaciones, colegios y asociaciones'||' '|| 
              'profesionales; las Mutualidades de Previsión Social; las demás entidades'||' '|| 
              'públicas, incluidas las gestoras de la Seguridad Social y quienes,'||' '|| 
              'en general, ejerzan funciones públicas, estarán obligados a suministrar'||' '|| 
              'a la Administración Tributaria cuantos datos y antecedentes con transcendencia'||' '|| 
              'tributaria recabe ésta mediante disposiciones de carácter general o a través de'||' '|| 
              'requerimientos concretos, y a prestarle a ella y a sus Agentes apoyo, concurso,'||' '||
              'auxilio y protección para el ejercicio de sus funciones"';
 
    TEXTO2 := 'la obligación de toda persona física o jurídica de proporcionar a la Administración'||' '||
              'Tributaria toda clase de datos, informes o antecedentes con trascendencia tributaria,'||' '||
              'deducidas de sus relaciones económicas, profesionales o financieras con otras persosnas';
 
    first_record;
 
    LOOP    
        w_aux:= mi_trim(:marcador.marcador);
        IF w_aux = 'CV_H1C075' THEN
            w_h1c075:= to_number(nvl(:marcador.valor,'0'));
        ELSIF w_aux = 'CV_H1C085' THEN
            w_h1c085:= to_number(nvl(:marcador.valor,'0'));
        ELSIF w_aux = 'CV_H1C084' THEN
            w_h1c084:= to_number(nvl(:marcador.valor,'0'));
        ELSIF w_aux = 'CV_H1C089' THEN
            w_h1c089:= to_number(nvl(:marcador.valor,'0'));
        ELSIF w_aux = 'CV_H1C052' THEN
            w_h1c052:= to_number(nvl(:marcador.valor,'0'));
        ELSIF w_aux = 'CV_H1C061' THEN
            w_h1c061:= to_number(nvl(:marcador.valor,'0'));  
            IF w_h1c061 != 0 THEN
                :temp.v_multa_proporcional:= 'S';
            ELSE
                :temp.v_multa_proporcional:= 'N';
            END IF;          
        ELSIF w_aux = 'CV_H1C023' THEN
            w_h1c023:= (:marcador.valor);
        ELSIF w_aux = 'CV_H1C024' THEN
            w_h1c024:= (:marcador.valor);
        ELSIF w_aux = 'CV_H1C025' THEN
            w_h1c025:= (:marcador.valor);            
        ELSIF w_aux = 'CV_H1C055' THEN
            w_h1c055:= (:marcador.valor);
        ELSIF w_aux = 'H1C021' THEN
            w_h1c021:= (:marcador.valor);            
        ELSIF w_aux = 'PLAZOING0' THEN
            w_plazoing0:= (:marcador.valor);
        ELSIF w_aux = 'JUN_TEA_0' THEN
            w_jun_tea_0:= (:marcador.valor);
        ELSIF w_aux = 'H1C019' THEN
            w_h1c019:= (:marcador.valor);
        ELSIF w_aux = 'FORM_1' THEN
            w_form_1:= (:marcador.valor);
        ELSIF w_aux = 'FORM_3' THEN
            w_form_3:= (:marcador.valor);
        ELSIF w_aux = 'FORM_10' THEN
            w_form_10:= (:marcador.valor);
        ELSIF w_aux = 'FORM_6' THEN
            w_form_6:= (:marcador.valor);
        ELSIF w_aux = 'FORM_14' THEN
            w_form_14:= (:marcador.valor);
        ELSIF w_aux = 'FORM_15' THEN
            w_form_15:= (:marcador.valor);
        ELSIF w_aux = 'FORM_17' THEN
            w_form_17:= (:marcador.valor);
        ELSIF w_aux = 'FORM_19' THEN
            w_form_19:= (:marcador.valor);
        ELSIF w_aux = 'CONNECT_1' THEN
            w_CONNECT_1:= (:marcador.valor);
        ELSIF w_aux = 'FIRRINSP' THEN
            w_FIRRINSP:= (:marcador.valor);            
        ELSIF w_aux = 'CV_H1C027' THEN
            w_h1c027:= (:marcador.valor);
        ELSIF w_aux = 'ARTI_0' THEN
            w_arti_0:= (:marcador.valor);
        ELSIF w_aux = 'PLAZPAGO' THEN
            w_plazpago:= (:marcador.valor);
        ELSIF w_aux = 'CV_H1C031' THEN
            w_h1c031:= (:marcador.valor);
        ELSIF w_aux = 'H1C004' THEN
            w_h1c004:= (:marcador.valor);
        ELSIF w_aux = 'FECACCIDE' THEN
            w_fecaccide := (:marcador.valor);
        ELSIF w_aux = 'RECURSO_1' THEN
            v_recurso_1 := (:marcador.valor);
        ELSIF w_aux = 'CV_H1C040' THEN
            w_h1c040 := (:marcador.valor);  
        ELSIF w_aux = 'CV_H1C065' THEN           
            w_h1c065 := to_number(nvl(:marcador.valor,'0'));
            IF w_h1c065 != 0 THEN
                :temp.v_multa_fija := 'S';
            ELSE
                :temp.v_multa_fija := 'N'; 
            END IF;
        ELSIF w_aux = 'GRADOINFR' THEN
            w_gradoinfr := (:marcador.valor);  
        ELSIF w_aux = 'ARTICINFR' THEN
            w_articinfr := (:marcador.valor);  
        ELSIF w_aux = 'H1C065' THEN
            w_h1c075_inspec := to_number(nvl(:marcador.valor,'0'));                   
            IF w_h1c075_inspec != 0 THEN
                :temp.v_multa_fija := 'S';
            ELSE
                :temp.v_multa_fija := 'N'; 
            END IF;
        ELSIF w_aux = 'FORM_20' THEN
            w_form_20 := (:marcador.valor); 
        ELSIF w_aux = 'REC_SSCC' THEN
            w_rec_sscc := (:marcador.valor);
        END IF;           
        IF w_aux = 'CV_H1C021' THEN
             --Pasamos a númerico todo lo que introduce el usuario mediante
             --expresiones regulares.
             SELECT regexp_replace(nvl(:marcador.valor,'0'), '[^[:digit:]]', '') 
               INTO v_h1c021
               FROM dual;
        ELSIF w_aux = 'CV_H1C050' THEN
            w_h1c050 := (:marcador.valor);
        END IF;    
        
        EXIT WHEN :SYSTEM.last_record='TRUE';
        
        next_record;
    END LOOP;
 
    go_record(to_number(fila_actual));    
    -----------------------------------------------------------------------------
    --  Se actualiza la fecha del documento con la fecha de construción del mismo.
    IF w_marcador = 'H1C020' THEN
       w_resultado := TO_CHAR(SYSDATE,'DD/MM/YYYY');   
    END IF;
    -----------------------------------------------------------------------------
    IF w_marcador = 'PLAZOING0' THEN
        IF w_plazoing0 = '(artículo 62.2)' THEN
            v_indvtono := '1';        -- plazo corto
        ELSIF w_plazoing0 = '(artículo 62.5)' THEN
            v_indvtono := '2';        -- plazo largo
        END IF;
        BEGIN
            UPDATE su_liquid 
               SET indvtono = v_indvtono
             WHERE docuni_codmodel = :temp.codmodel
               AND docuni_numvermo = :temp.numvermo
               AND docuni_numerdoc = :temp.numerdoc;
        EXCEPTION 
            WHEN OTHERS THEN
                NULL;
        END;
    END IF;

    -- Para el caso de PLAZOING0
    IF w_marcador = 'PLAZOING1' AND W_PLAZOING0 = '(artículo 62.2)' THEN
        w_resultado := '20 del mes posterior';
    ELSIF w_marcador = 'PLAZOING1' AND W_PLAZOING0 = '(artículo 62.5)' THEN
        w_resultado := '20 del mismo mes';
    END IF;
 
    IF w_marcador = 'PLAZOING2' AND W_PLAZOING0 = '(artículo 62.2)' THEN
        w_resultado := '5 del segundo mes posterior';
    ELSIF w_marcador = 'PLAZOING2' AND W_PLAZOING0 = '(artículo 62.5)' THEN
        w_resultado := '5 del mes siguiente';
    END IF;
     
    -- Para el caso de JUN_TEA_0 (Pie de recurso)
    IF w_marcador = 'JUN_TEA_1' AND W_JUN_TEA_0 = 'el Tribunal Económico-Administrativo Regional' THEN
        w_resultado := 'del Ministerio de Hacienda';
    ELSIF w_marcador = 'JUN_TEA_1'  AND W_JUN_TEA_0 = 'la Junta Provincial de Hacienda' THEN
        w_resultado := 'de la Consejería de Hacienda y Administración Pública';
    END IF;
 
    IF w_marcador = 'JUN_TEA_2' AND W_JUN_TEA_0 = 'el Tribunal Económico-Administrativo Regional' THEN       
        w_resultado:=k000810.fobteara(w_h1c019, '1');      
        --PFIRMANT(w_h1c019, w_codmodel, w_numvermo, ta_datos);  
        --w_resultado := ta_datos(1).desteara;     
    ELSIF w_marcador = 'JUN_TEA_2'  AND W_JUN_TEA_0 = 'la Junta Provincial de Hacienda'  THEN
        w_resultado:=k000810.fobteara(w_h1c019, '2');      
        --PFIRMANT(w_h1c019, w_codmodel, w_numvermo, ta_datos);  
        --w_resultado := ta_datos(1).desjunha;
    END IF;
 
    IF w_marcador = 'JUN_TEA_3' AND W_JUN_TEA_0 = 'el Tribunal Económico-Administrativo Regional' THEN
        w_resultado := 'Si por razón de la cuantía fuese aplicable lo establecido en el ' ||
         'artículo 5.b) del Real Decreto Legislativo 2795/1980, de 12 de diciembre, ' ||
         'por el que se articula la Ley 39/1980, de 5 de julio, de Bases sobre Procedimiento ' ||
         'Económico-Administrativo, según redacción dada al mismo por la Ley 1/1998, ' ||
         'de 26 de febrero, de Derechos y Garantías de los Contribuyentes, podrá ' ||
         'interponerse directamente reclamación económico-administrativa ante el Tribunal ' ||
         'Económico-Administrativo Central, igualmente dependiente del Ministerio de ' ||
         'Hacienda, en el mismo plazo.';
    
    ELSIF w_marcador = 'JUN_TEA_3' AND W_JUN_TEA_0 = 'la Junta Provincial de Hacienda' THEN
        w_resultado := 'Si por razón de la cuantía fuese aplicable lo establecido en el ' ||
         'artículo 5.b) del Real Decreto Legislativo 2795/1980, de 12 de diciembre, ' ||
         'por el que se articula la Ley 39/1980, de 5 de julio, de Bases sobre Procedimiento ' ||
         'Económico-Administrativo, según redacción dada al mismo por la Ley 1/1998, ' ||
         'de 26 de febrero, de Derechos y Garantías de los Contribuyentes, podrá ' ||
         'interponerse directamente reclamación económico-administrativa ante la Junta ' ||
         'Superior de Hacienda, igualmente dependiente de la Consejería de Hacienda y ' ||
         'Administración Pública, en el mismo plazo.';
    END IF;
 
    -- Tratamiento del pie de recurso para liquidaciones.
    IF w_marcador = 'RECURSO_2'  AND V_RECURSO_1 = 'el Tribunal Económico Administrativo Regional de Andalucía (Art. 226 y siguientes de la Ley 58/2003, de 17 de diciembre, General Tributaria)' THEN
        w_resultado:=k000810.fobteara(w_h1c019, '1');      
        ---PFIRMANT(w_h1c019, w_codmodel, w_numvermo, ta_datos);  
        --w_resultado := ta_datos(1).desteara;
 
    ELSIF w_marcador = 'RECURSO_2' AND V_RECURSO_1 = 'la Junta Provincial de Hacienda, regulada por Decreto 175/1987, de 14 de julio' THEN
        w_resultado:=k000810.fobteara(w_h1c019, '2');      
        --PFIRMANT(w_h1c019, w_codmodel, w_numvermo, ta_datos);  
        --w_resultado := ta_datos(1).desjunha;
    END IF;
 
    IF w_marcador = 'RECURSO_3' AND V_RECURSO_1 = 'el Tribunal Económico Administrativo Regional de Andalucía (R.D. 391/1996, de 1 de marzo)'   THEN
        w_resultado := 'el Tribunal Económico-Administrativo Central (Real Decreto Legislativo 2795/1980, de 12 de diciembre) ambos dependientes del Ministerio de Hacienda'; 
    ELSIF w_marcador = 'RECURSO_3' AND V_RECURSO_1 = 'la Junta Provincial de Hacienda, regulada por Decreto 175/1987, de 14 de julio' THEN
        w_resultado := 'la Junta Superior de Hacienda, ambas dependientes de la Consejería de Hacienda y Administración Pública'; 
    END IF;
 
    -- Marcador NIF actuario
    IF w_marcador = 'CV_H1C027' THEN
        BEGIN
            SELECT nifusuar
              INTO w_resultado
              FROM su_usuari
             WHERE LTRIM(RTRIM(nomusuar)) = LTRIM(RTRIM(w_connect_1)) 
               AND indconex = 'S';    
        EXCEPTION
            WHEN OTHERS THEN
                BEGIN
                  SELECT nifusuar
                    INTO w_resultado
                    FROM su_usuari
                   WHERE LTRIM(RTRIM(nomusuar)) = LTRIM(RTRIM(w_FIRRINSP)) 
                     AND indconex = 'S';             
                EXCEPTION
                    WHEN OTHERS THEN
                        w_resultado := NULL;
                END;    
        END;
    END IF;
 
    -- Codigo de actuario
    IF w_marcador = 'CV_H1C400' THEN
        IF :temp.operacion = 'BO' AND :temp.codcliac IS NULL THEN
			      :temp.codcliac := factuario_borrador;
        END IF;
        w_resultado := :temp.codcliac;
    END IF;
 
    IF w_marcador = 'CV_H1C023' AND k000810.fmodinsp(:temp.codmodel) THEN
    
        -- Control sobre la fecha del acta para los documentos de inspección.
        IF TO_DATE(w_h1c023,'DD/MM/YYYY') < TRUNC(SYSDATE) THEN
            -- MENSAJITO FECHA NO PUEDE SER INFERIOR AL DÍA
            mostrar_mensaje('SUR-11054','E',TRUE);
          
        ELSIF TO_DATE(w_h1c023,'DD/MM/YYYY') > TRUNC(SYSDATE)+15 THEN
            -- MENSAJITO FECHA NO PUEDE SER INFERIOR AL DÍA
            mostrar_mensaje( 'SUR-02504 #1'||TO_CHAR((SYSDATE+15),'DD/MM/YYYY'),'E',TRUE );          
        ELSE
            v_fecha_propuesta :=FFECOBLS (w_h1c019, 0 ,TO_DATE(w_h1c023,'DD/MM/YYYY'));
            IF TO_DATE(w_h1c023,'DD/MM/YYYY') <> TRUNC(v_fecha_propuesta)  THEN
                -- MENSAJITO CON 'FECHA NO VALIDA POR SER FESTIVO Y OFRECER LA FECHA W_FECHA31'
                mostrar_mensaje('SUR-02143 #1'||TO_CHAR(v_fecha_propuesta,'DD/MM/YYYY'),'E',TRUE);
            END IF;
        END IF;
        w_resultado := w_h1c023;    
    END IF;
    -- Validación de fecha de solicitud de devolución 
    IF w_marcador = 'CV_H1C055' THEN
    
       -- Control sobre la fecha de la solicitud de devolución de transferencia
       IF TO_DATE(w_h1c055,'DD/MM/YYYY') > TRUNC(SYSDATE) THEN
           -- MENSAJITO FECHA NO PUEDE SER MAYOR A LA ACTUAL
           mostrar_mensaje('SUR-05036 #1' ||'la fecha actual.','E',TRUE);
       ELSE
           v_fecha_propuesta :=FFECOBLS (w_h1c019, 0 ,TO_DATE(w_h1c055,'DD/MM/YYYY'));
           IF TO_DATE(w_h1c055,'DD/MM/YYYY') <> TRUNC(v_fecha_propuesta)  THEN
               -- MENSAJITO CON 'FECHA NO VALIDA POR SER FESTIVO Y OFRECER LA FECHA '
               mostrar_mensaje('SUR-02143 #1'||TO_CHAR(v_fecha_propuesta,'DD/MM/YYYY'),'E',TRUE);
           END IF;
       END IF;
       w_resultado := w_h1c055;    
    END IF;
 
    ------------------------------------------------------------------------------------
    -- Para el caso de ARTI_0 (documento de salida 0322)                                
    ------------------------------------------------------------------------------------
    IF w_codmodel = '032' AND K000810.fexisver(w_codmodel, w_numvermo) THEN
        IF W_ARTI_0 = 'artículo 111' THEN
            w_resultado := TEXTO2;
        ELSIF W_ARTI_0 = 'artículo 112' THEN
            w_resultado := TEXTO1;
        END IF;
    END IF; 
      
    -- Calculamos el valor del marcador según el modelo y versión 
    ------------------------------------------------------------------------------------
    -- DOCUMENTO D00 Y D01
    ------------------------------------------------------------------------------------
    IF (w_codmodel IN ('D00','D01') AND K000810.fexisver(w_codmodel, w_numvermo)) THEN
        IF w_marcador = 'FORM_2' AND W_FORM_1 = 'Transmisiones Patrimoniales y Actos Jurídicos Doc.' THEN
            w_resultado := 'Art. 103 del RD 828/1995, de 29 de mayo';
        ELSIF w_marcador = 'FORM_2' AND W_FORM_1 = 'Sucesiones y Donaciones' THEN
            w_resultado := 'Art. 70 del RD.1629/1991, de 8 de noviembre';
        END IF;
        
        IF w_marcador = 'FORM_3' AND W_FORM_1 = 'Transmisiones Patrimoniales y Actos Jurídicos Doc.' THEN
            IF  ( W_FORM_3 IN ('Art. 6 de la Ley 30/1983 de 28 de diciembre',
            	                 'Art. 25 de la Ley 21/2001 de 27 de diciembre',
            	                 'Art. 33 de la Ley 22/2009, de 18 de diciembre')) 
            THEN
                w_resultado := W_FORM_3;
            ELSE
                --w_resultado := NULL;
                 mostrar_mensaje('SUR-02510','E',TRUE);
            END IF;  
        END IF;
        
        IF w_marcador = 'FORM_3' AND W_FORM_1 = 'Sucesiones y Donaciones' THEN
           IF ( W_FORM_3 IN ('Art. 5 de la Ley 30/1983 de 28 de diciembre',
           	                 'Art. 24 de la Ley 21/2001 de 27 de diciembre',
           	                 'Art. 32 de la Ley 22/2009, de 18 de diciembre') )
            THEN
                w_resultado := W_FORM_3;
            ELSE
              --  w_resultado := NULL;
                 mostrar_mensaje('SUR-02510','E',TRUE);
            END IF;
        END IF;
        
    END IF;
    ------------------------------------------------------------------------------------
    -- DOCUMENTO 001
    ------------------------------------------------------------------------------------
    IF w_codmodel = '001' AND K000810.fexisver(w_codmodel, w_numvermo) THEN
        IF w_marcador = 'FORM_3' THEN
            w_resultado := W_H1C023;
        ELSIF w_marcador = 'FORM_20' THEN
            w_resultado := W_FORM_6;
        ELSIF w_marcador = 'FORM_18' THEN
            w_resultado := W_FORM_17;
        END IF;
    END IF;
    ------------------------------------------------------------------------------------
    -- DOCUMENTO 002 
    ------------------------------------------------------------------------------------
    IF w_codmodel ='002' AND K000810.fexisver(w_codmodel, w_numvermo) THEN
        IF w_marcador ='CV_H1C083' THEN
            w_tmp := w_h1c075 + w_h1c085 + w_h1c084;
            w_resultado := to_char(w_tmp);
        ELSIF w_marcador ='CV_H1C099' THEN
            w_tmp := w_h1c075 + w_h1c085 + w_h1c084 - w_h1c089; 
            w_resultado := to_char(w_tmp);
        ELSIF w_marcador = 'FORM_3' THEN
            w_resultado := W_H1C023;
        ELSIF w_marcador = 'FORM_24' THEN
            w_resultado := W_FORM_6;
        ELSIF w_marcador = 'FORM_21' THEN
            w_resultado := W_FORM_19;
        ELSIF w_marcador = 'CV_H1C075' THEN   
            IF w_h1c075 = 0 then
                w_resultado := to_char(w_h1c075,'9D99');
            ELSE
                w_resultado := to_char(w_h1c075);
            END IF;
        ELSIF w_marcador = 'CV_H1C084' THEN
            IF w_h1c084 = 0 then
                w_resultado := to_char(w_h1c084,'9D99');
            ELSE
                w_resultado := to_char(w_h1c084);
            END IF;
        ELSIF w_marcador = 'CV_H1C085' THEN
            IF w_h1c085 = 0 then
                w_resultado := to_char(w_h1c085,'9D99');
            ELSE
                w_resultado := to_char(w_h1c085);
            END IF;
        ELSIF w_marcador = 'CV_H1C089' THEN
           IF w_h1c089 = 0 then
                w_resultado := to_char(w_h1c089,'9D99');
           ELSE
               w_resultado := to_char(w_h1c089);
           END IF;

        ELSIF w_marcador = 'CV_H1C025' THEN
           w_resultado := w_h1c025;

           BEGIN
        	     UPDATE SU_DOCUNI
        	       SET CONCEP_CODCONCE = SUBSTR(w_h1c025,1,4),
        	           CONCEP_CODMODEL = W_CODMODEL
        	      WHERE VERMOD_CODMODEL = :parameter.p_codmodel
        	        AND VERMOD_NUMVERMO = :parameter.P_NUMVERMO
        	        AND NUMERDOC        = :parameter.P_NUMERDOC;
           EXCEPTION
           	   WHEN OTHERS THEN
           	       NULL;
           
           END;           
        END IF;
    END IF;
    
    ------------------------------------------------------------------------------------
    -- DOCUMENTO 003
    ------------------------------------------------------------------------------------
    IF w_codmodel ='003' THEN
        IF w_marcador = 'FORM_3' THEN
            w_resultado := W_H1C023;
        END IF;     
    END IF; 
    
    ------------------------------------------------------------------------------------
    -- DOCUMENTO 006
    ------------------------------------------------------------------------------------
    IF w_codmodel ='006' AND K000810.fexisver(w_codmodel, w_numvermo) THEN
        IF w_marcador = 'FORM_3' THEN
            w_resultado := W_H1C023;
        ELSIF w_marcador = 'FORM_20' THEN
            w_resultado := W_FORM_6;
        ELSIF w_marcador = 'FORM_19' THEN
            w_resultado := W_FORM_14;
        ELSIF w_marcador = 'FORM_16' THEN
            w_resultado := W_FORM_15;
        ELSIF w_marcador = 'FORM_18' THEN
            w_resultado := W_FORM_17;
        END IF;
    END IF;
 
    ------------------------------------------------------------------------------------
    -- DOCUMENTO 007
    ------------------------------------------------------------------------------------
    IF w_codmodel ='007' AND K000810.fexisver(w_codmodel, w_numvermo) THEN
        IF w_marcador = 'FORM_4' THEN
            w_resultado := W_H1C023;
        ELSIF w_marcador = 'FORM_19' THEN
            w_resultado := W_FORM_6;
        ELSIF w_marcador = 'FORM_18' THEN
            w_resultado := W_FORM_10;
        ELSIF w_marcador = 'FORM_17' THEN
            w_resultado := W_FORM_10;
        ELSIF w_marcador = 'FORM_16' THEN
            w_resultado := W_FORM_10;
        ELSIF w_marcador = 'FORM_15' THEN
            w_resultado := W_FORM_10;                 
       ELSIF w_marcador = 'H1C075' THEN
           w_resultado := w_h1c075_inspec;
        END IF;
    END IF;
    
    --------------------------------------------------------------------------------
    --- LÍNEAS INSPEC: VÁLIDO PARA TODOS LOS MÓDELOS DE INSPECCIÓN (007, 008 Y 050)
    -------------------------------------------------------------------------------
    -- Obtenemos las lineas de inspección a través de la unidad de programa.
    k000810.plinact(:temp.codmodel, :temp.v_multa_fija, v_ejercici, v_inslar_codareac, v_inslar_codclase, v_inslar_codlinar);

    IF w_marcador = 'CV_H1C300' THEN
        w_resultado := v_ejercici;
    ELSIF w_marcador = 'CV_H1C301' THEN
        w_resultado := v_inslar_codareac;
    ELSIF w_marcador = 'CV_H1C302' THEN
        w_resultado := v_inslar_codclase;      
    ELSIF w_marcador = 'CV_H1C303' THEN
       w_resultado := v_inslar_codlinar;
    END IF;
    
   
    ------------------------------------------------------------------------------------
    -- DOCUMENTO 008
    ------------------------------------------------------------------------------------     
    IF w_codmodel = '008'  AND K000810.fexisver(w_codmodel, w_numvermo)  THEN
        IF w_marcador = 'FORM_4' THEN
            w_resultado := W_H1C023;
        ELSIF w_marcador = 'FORM_18' THEN
            w_resultado := W_FORM_6;
        ELSIF w_marcador = 'FORM_17' THEN
            w_resultado := W_FORM_10;
        ELSIF w_marcador = 'FORM_16' THEN
            w_resultado := W_FORM_10;
        ELSIF w_marcador = 'FORM_15' THEN
            w_resultado := W_FORM_10;    
        ELSIF w_marcador = 'CV_H1C075' THEN
            w_tmp := (w_h1c052 * w_h1c061)/100; 
            w_resultado := to_char(w_tmp);
        ELSIF w_marcador ='CV_H1C099'  THEN
        
            IF w_h1c065 = 0 THEN
                w_tmp := ((w_h1c052 * w_h1c061)/100) - w_h1c089; 
                w_resultado := to_char(w_tmp);
            ELSE
                -- para asignar el importe de multa fija
                -- como el importe correcto en el modelo 008 versión 3.
                w_resultado := to_char(w_h1c065);
            END IF;          
        ELSIF w_marcador = 'CV_H1C052' THEN
            IF w_h1c052 = 0 THEN
                w_resultado := to_char(w_h1c052,'9D99');
            ELSE
                w_resultado := to_char(w_h1c052);
            END IF;
        ELSIF w_marcador = 'CV_H1C061' THEN
            IF w_h1c061 = 0 THEN
                w_resultado := to_char(w_h1c061,'9D99');
            ELSE
                w_resultado := to_char(w_h1c061);           
            END IF;
        ELSIF w_marcador = 'CV_H1C089' THEN
            IF w_h1c089 = 0 THEN
                w_resultado := to_char(w_h1c089,'9D99');
            ELSE
                w_resultado := to_char(w_h1c089);
            END IF;
        ELSIF w_marcador = 'CV_H1C065' THEN
            w_resultado := to_char(w_h1c065);
            
        ELSIF w_marcador = 'CV_H1C025' THEN
           w_resultado := w_h1c025;

           BEGIN
        	     UPDATE SU_DOCUNI
        	       SET CONCEP_CODCONCE = SUBSTR(w_h1c025,1,4),
        	           CONCEP_CODMODEL = W_CODMODEL
        	      WHERE VERMOD_CODMODEL = :parameter.p_codmodel
        	        AND VERMOD_NUMVERMO = :parameter.P_NUMVERMO
        	        AND NUMERDOC        = :parameter.P_NUMERDOC;
           EXCEPTION
           	   WHEN OTHERS THEN
           	       NULL;
           
           END;                    
                    
                    
        ELSIF w_marcador = 'CV_H1C050' THEN
        	  IF w_h1c050 IS NULL THEN
               
                SELECT valcasil
                  INTO v_origen
                  FROM su_casval
                 WHERE docuni_codmodel = :temp.codmodel
                   AND docuni_numvermo = :temp.numvermo
                   AND docuni_numerdoc = :temp.numerdoc
                   AND CASMOD_NUMCASIL = '050';

        	      W_H1C050:= v_origen;	
        	  END IF;
            IF  :temp.v_multa_proporcional= 'S' THEN        
                -- Vamos a asegurar que todos todos los documentos de Inspección tengan asociados
                -- un documento origen (ACTAS DE INSPECCIÓN).
                v_conteo:= length(NVL(v_h1c021,0));
          
                IF v_conteo = 13 THEN
                    -- debe de venir un documento con la estrucutra SUR cuál su longitud debe ser de 13 carácteres.
                    -- y además que se encuentre en al tabla de documentos.
                    v_modelo:= substr(v_h1c021,1,3);
                    v_version:=substr(v_h1c021,4,1);
                    v_numerdoc:=substr(v_h1c021,5);
              
                    SELECT COUNT(*) 
                      INTO v_existe
                      FROM su_docuni
                     WHERE vermod_codmodel = v_modelo
                       AND vermod_numvermo = v_version
                       AND numerdoc = v_numerdoc;
                 
                    IF v_existe != 0 THEN
                        v_doc_orig:= v_h1c021;
                    ELSE
                        v_doc_orig:= NULL; 
                    END IF;
                ELSE 
                    v_doc_orig:= NULL;     
                END IF;      
         
                -- El documento origen será la referencia a Acta que introduzca el usuario cuando
                -- venga vacio el doc. origen, sea una multa proporcional y lo que introduzca el usuario
                -- sea un documento válido en Sur.
                IF w_h1c050 IS NULL AND :temp.v_multa_proporcional= 'S' AND v_doc_orig IS NOT NULL THEN
                    w_resultado := v_doc_orig;
                ELSE 
                    w_resultado := w_h1c050; 
                END IF;       
            ELSIF :temp.v_multa_proporcional= 'N' AND w_h1c050 is null THEN
                NULL;
            ELSE
            	  w_resultado := w_h1c050; 
            END IF;  
        END IF;
        -- Controlamos que solo venga relleno un tipo de multa.
        controla_multas;
    END IF;

    ------------------------------------------------------------------------------------
    -- DOCUMENTO A25
    ------------------------------------------------------------------------------------     
    IF w_codmodel = 'A25' THEN
    	  IF w_articinfr IS NOT NULL THEN
    	  	  -- Obtener el valor del codigo de articulo
    	  	  w_articulo := NULL;
    	  	  OPEN c_articulo(w_articinfr);
    	  	  FETCH c_articulo INTO w_articulo;
    	  	  CLOSE c_articulo;
    	      IF w_marcador = 'CV_H1C066' THEN
    	          -- Grado infracción
    	          IF w_gradoinfr IS NOT NULL THEN
    	          	  OPEN c_grado(w_articulo, w_gradoinfr);
    	          	  FETCH c_grado INTO w_resultado;
    	          	  CLOSE c_grado;
    	          END IF;
    	      ELSIF w_marcador = 'CV_H1C067' THEN
    	  	      -- Articulo infraccion (su_parsan)
    	  	      w_resultado := w_articulo;
    	      ELSIF w_marcador = 'CV_H1C068' THEN
    	  	      -- Calificacion (su_parsan)
    	  	      IF w_gradoinfr IS NOT NULL THEN
    	  	      	  OPEN c_califica(w_articulo, w_gradoinfr);
    	  	      	  FETCH c_califica INTO w_resultado;
    	  	      	  CLOSE c_califica;
    	  	      END IF;
    	      ELSIF w_marcador = 'CV_H1C069' THEN
    	  	      -- Descripcion corta grado infraccion
    	  	      w_grado := NULL;
    	          IF w_gradoinfr IS NOT NULL THEN
    	          	  OPEN c_grado(w_articulo, w_gradoinfr);
    	          	  FETCH c_grado INTO w_grado;
    	          	  CLOSE c_grado;
    	          	  IF w_grado IS NOT NULL THEN
    	          	  	  OPEN c_descgrado(w_grado);
    	          	  	  FETCH c_descgrado INTO w_resultado;
    	          	  	  CLOSE c_descgrado;
    	          	  END IF;
    	          END IF;
    	  	  END IF;
    	  END IF;
    END IF;


    ------------------------------------------------------------------------------------------------------
    -- DOCUMENTO 026 AVRA
    -- Controlar que para la opción de devolución hay previamente una solicitud de devolución con su fecha
    ------------------------------------------------------------------------------------------------------
		IF w_codmodel = '026' AND k000810.fexisver(w_codmodel, w_numvermo) THEN
		
		    IF w_marcador = 'FORM_1' AND w_form_1 = 'Solicitud de documentación en devolución fianza' THEN
			
			    IF NVL(kparplan.ffechasol(w_h1c021),'NULO') = 'NULO' THEN
				
				    mostrar_mensaje('SUR-04457','E',TRUE);
				
		        ELSE
		            w_resultado := 	w_form_1;	
				
				END IF;
			
			ELSE
			
		        w_resultado := 	w_form_1;		    
			
			END IF;
		
		
		END IF;



    ------------------------------------------------------------------------------------
    -- DOCUMENTO R01
    ------------------------------------------------------------------------------------
    IF w_codmodel= 'R01' AND K000810.fexisver(w_codmodel, w_numvermo) THEN

        IF w_marcador = 'FORM_3' THEN
            w_resultado := W_H1C023;
        ELSIF w_marcador = 'FORM_23' THEN
            w_resultado := W_FORM_6;
        ELSIF w_marcador = 'FORM_18' THEN
            w_resultado := W_FORM_17;
        ELSIF w_marcador ='CV_H1C083' THEN
            w_tmp := w_h1c075 + w_h1c085 + w_h1c084;
            w_resultado := to_char(w_tmp);
        ELSIF w_marcador ='CV_H1C099' THEN
            w_tmp := w_h1c075 + w_h1c085 + w_h1c084 - w_h1c089; 
            w_resultado := to_char(w_tmp);
        ELSIF w_marcador = 'CV_H1C075' THEN
           IF w_h1c075 = 0 then
                w_resultado := to_char(w_h1c075,'9D99');
           ELSE
               w_resultado := to_char(w_h1c075);
           END IF;
        ELSIF w_marcador = 'CV_H1C084' THEN
           IF w_h1c084 = 0 then
                w_resultado := to_char(w_h1c084,'9D99');
           ELSE
               w_resultado := to_char(w_h1c084);
            END IF;
        ELSIF w_marcador = 'CV_H1C085' THEN
            IF w_h1c085 = 0 then
                w_resultado := to_char(w_h1c085,'9D99');
            ELSE
                w_resultado := to_char(w_h1c085);
            END IF;
        ELSIF w_marcador = 'CV_H1C089' THEN
            IF w_h1c089 = 0 then
                w_resultado := to_char(w_h1c089,'9D99');
           ELSE
               w_resultado := to_char(w_h1c089);
           END IF;
        END IF; 
    END IF;
 
    ------------------------------------------------------------------------------------
    -- DOCUMENTO 132
    ------------------------------------------------------------------------------------
    IF w_codmodel= '132' THEN
        IF w_marcador = 'CV_H1C025' THEN
            w_resultado:=K000810.FMOD132(w_h1c024);
        END IF;

	      IF w_marcador = 'CV_H1C040' THEN
	      
	          IF  LTRIM(RTRIM(W_h1c040)) IS  NULL THEN
	              -- mensajito "Introduzca un NIF"
	              mostrar_mensaje('SUR-01365','E',TRUE);   
	          ELSE
	              IF FVALFNIF(w_h1c040)='1' THEN
	                  MOSTRAR_MENSAJE('SUR-00902','E',TRUE);
	              ELSE
	                  -- Hacemos las comprobaciones necesarias al NIF
	                  PVALCLI ('marcador.valor',NULL,NULL,FALSE,TRUE);
	                  -- Esta procedimiento devuelve en las globales global.nifclien y global.codclien
	                  -- el nif y el código del cliente que hemos seleccionado en el modulo M000121.
	                  w_resultado := w_h1c040;
	              
	                  IF :GLOBAL.PREVIEW = 'I' THEN
	                      BEGIN
	                          v_expedi_codcircu := SUBSTR(w_h1c021,1,INSTR(w_h1c021,'-')-1);
	                          w_h1c021:= SUBSTR(w_h1c021,INSTR(w_h1c021,'-')+1);
	                          v_expedi_codterri := SUBSTR(w_h1c021,1,INSTR(w_h1c021,'-')-1);
	                          w_h1c021 := SUBSTR(w_h1c021,INSTR(w_h1c021,'-')+1);
	                          v_expedi_ejeexped := TO_NUMBER(SUBSTR(w_h1c021,1,INSTR(w_h1c021,'/')-1));
	                          v_expedi_numexped := TO_NUMBER (RTRIM(LTRIM(SUBSTR(w_h1c021,INSTR(w_h1c021,'/')+1))));
	                      EXCEPTION
	                          WHEN OTHERS THEN
	                              NULL;
	                      END;     
	                        
	                      BEGIN
	                          INSERT INTO su_nifexp( expedi_codcircu, expedi_codterri, expedi_ejeexped, expedi_numexped
	                                               , client_codclien, sujcir_codcircu, sujcir_codtipsu)
	                               VALUES ( v_expedi_codcircu, v_expedi_codterri, v_expedi_ejeexped, v_expedi_numexped
	                                      , :GLOBAL.codclien, v_expedi_codcircu, 'DE');
	                      EXCEPTION
	                          WHEN DUP_VAL_ON_INDEX THEN
	                              NULL;
	                          WHEN OTHERS THEN
	                              NULL;     
	                      END;
	                   
	                 END IF;        
	             END IF;
	         END IF;
	     END IF;
     
       IF w_marcador = 'CV_H1C041' THEN
            BEGIN
                SELECT SUBSTR(NOMCLIEN,1,60)
                  INTO w_resultado
                  FROM SU_CLIENT
                 WHERE CODCLIEN = :GLOBAL.CODCLIEN;
            EXCEPTION
                WHEN OTHERS THEN
                    NULL;
            END;       
       END IF;
   END IF; 
    ------------------------------------------------------------------------------------
    -- DOCUMENTO 050
    ------------------------------------------------------------------------------------
    IF w_codmodel= '050' THEN             
        -- Se inicializa a X para calcular la línea de inspección en la 
        -- unidad de programa Obtener_linea_inspección
        :temp.v_multa_fija := 'X'; 
        
        IF w_marcador = 'CV_H1C040' THEN
            IF  LTRIM(RTRIM(W_h1c040)) IS  NULL THEN
                -- mensajito "Introduzca un NIF"
                mostrar_mensaje('SUR-01365','E',TRUE);
            ELSE
                IF FVALFNIF(w_h1c040)= '1' THEN
                    MOSTRAR_MENSAJE('SUR-00902','E',TRUE);
                ELSE
                    -- Hacemos las comprobaciones necesarias al NIF
                    PVALCLI ('marcador.valor',NULL,NULL,FALSE,TRUE);
                    -- Esta procedimiento devuelve en las globales global.nifclien y global.codclien
                    -- el nif y el código del cliente que hemos seleccionado en el modulo M000121.
                    w_resultado := w_h1c040;           
                END IF;
             END IF;
         
             BEGIN
                 SELECT coddomic
                   INTO :temp.coddomic
                   FROM su_domici
                  WHERE client_codclien = :GLOBAL.CODCLIEN
                    AND inddomfi = 'S';
                     
             EXCEPTION
                 -- comprobamos que solo posee un domicilio fiscal          
                 WHEN too_many_rows THEN
                     MOSTRAR_MENSAJE('SUR-00769','E',TRUE); --Duplicidad en domicilio fiscal. Contacte con el DBA.
                 WHEN no_data_found THEN
                     MOSTRAR_MENSAJE('SUR-00770','E',TRUE); -- No hay domicilio fiscal.    
                 WHEN OTHERS THEN
                     NULL;
             END;
        END IF;
 
        -----------------------------------------------------------------------------------
        -- En la primera pasada el nif aún no está relleno por lo que no se van a recuperar
        -- datos en las consultas de los marcadores, se lanzará la excepción NO_DATA_FOUND 
        -- y dejamos que no haga nada, en el resto de pasadas si debería de recuperar datos.
        -----------------------------------------------------------------------------------
       -- dependiendo del marcador comenzamos a obtener los datos del domicilio.
       
       IF w_marcador = 'CV_H1C041' THEN
           BEGIN
               SELECT substr(nomclien, 1, 60)
                 INTO w_resultado
                 FROM su_client
                WHERE codclien = :GLOBAL.CODCLIEN;
           EXCEPTION
               WHEN NO_DATA_FOUND THEN
                   NULL;
           END;     
       ELSIF w_marcador = 'CV_H1C042' THEN
           BEGIN
               SELECT NVL(codviapu, NULL)
                 INTO w_resultado
                 FROM su_domici
                WHERE coddomic = :temp.coddomic;
           EXCEPTION
                WHEN NO_DATA_FOUND THEN
                    NULL;
            END;
       ELSIF w_marcador = 'CV_H1C043' THEN      
            BEGIN
                SELECT NVL(denviapu, NULL) 
                  INTO w_resultado
                  FROM su_domici
                 WHERE coddomic = :temp.coddomic;
            EXCEPTION
                WHEN NO_DATA_FOUND THEN
                    NULL;
            END; 
       ELSIF w_marcador = 'CV_H1C044' THEN      
            BEGIN
             SELECT NVL(numviapu, NULL)
               INTO w_resultado
               FROM su_domici
              WHERE coddomic = :temp.coddomic;
            EXCEPTION
                WHEN NO_DATA_FOUND THEN
                    NULL;
            END;      
       ELSIF  w_marcador = 'CV_H1C045' THEN 
            BEGIN
                SELECT NVL(letviapu , NULL)
                  INTO w_resultado
                  FROM su_domici
                 WHERE coddomic = :temp.coddomic;
            EXCEPTION
                WHEN NO_DATA_FOUND THEN
                    NULL;
            END;     
       ELSIF w_marcador = 'CV_H1C046' THEN
            BEGIN
             SELECT NVL(escviapu, NULL)
               INTO w_resultado
               FROM su_domici
              WHERE coddomic = :temp.coddomic;
            EXCEPTION
                WHEN NO_DATA_FOUND THEN
                    NULL;
            END;
       ELSIF w_marcador = 'CV_H1C047' THEN   
            BEGIN
             SELECT NVL(plaviapu, NULL)
               INTO w_resultado
               FROM su_domici
              WHERE coddomic = :temp.coddomic;
            EXCEPTION
                WHEN NO_DATA_FOUND THEN
                    NULL;
            END; 
       ELSIF w_marcador = 'CV_H1C048' THEN
            BEGIN
             SELECT NVL(pueviapu, NULL)
               INTO w_resultado
               FROM su_domici
              WHERE coddomic = :temp.coddomic;
            EXCEPTION
                WHEN NO_DATA_FOUND THEN
                    NULL;
            END; 
       ELSIF w_marcador = 'CV_H1C049' THEN      
            BEGIN
                SELECT mn.desmunic
                  INTO w_resultado
                  FROM su_domici dm
                     , su_munici mn
                 WHERE dm.codpaise = mn.provin_codpaise
                   AND dm.codprovi = mn.provin_codprovi
                   AND dm.codmunic = mn.codmunic
                   AND dm.coddomic = :temp.coddomic;
             EXCEPTION
                WHEN NO_DATA_FOUND THEN
                    NULL;
             END;
 
       ELSIF w_marcador = 'CV_H1C050' THEN     
           BEGIN
               SELECT pr.desprovi
                 INTO w_resultado
                 FROM su_domici dm
                    , su_munici mn
                    , su_provin pr
                WHERE dm.codpaise = mn.provin_codpaise
                  AND dm.codprovi = mn.provin_codprovi
                  AND dm.codmunic = mn.codmunic
                  AND dm.coddomic = :temp.coddomic
                  AND pr.paises_codpaise = mn.provin_codpaise
                  AND pr.codprovi = mn.provin_codprovi;
           EXCEPTION
               WHEN NO_DATA_FOUND THEN
                   NULL;
           END;
 
        ELSIF w_marcador = 'CV_H1C051' THEN    
            BEGIN
             SELECT NVL(codposta, NULL)
               INTO w_resultado
               FROM su_domici
              WHERE coddomic = :temp.coddomic;
            EXCEPTION
                WHEN NO_DATA_FOUND THEN
                    NULL;
            END;   
       END IF;         
    END IF;   
    ------------------------------------------------------------------------------------
    -- DOCUMENTO 0472
    ------------------------------------------------------------------------------------
    IF w_codmodel ='047'  AND K000810.fexisver(w_codmodel, w_numvermo) THEN
            
        -- Fecha de vencimiento de la liquidación 08/08/2002
        IF w_marcador = 'CV_H1C031' THEN
            -- OBLIGATORIA SI SU_LIQUID.VIAGENLI = 'C' Y PARA CIERTOS CONCEPTOS.
            SELECT viagenli
              INTO w_viagenli  
              FROM su_liquid
             WHERE docuni_codmodel = :temp.codmodel
               AND docuni_numvermo = :temp.numvermo
               AND docuni_numerdoc = :temp.numerdoc;
 
            IF w_viagenli <> 'C' THEN
                -- mensajito 'VIA DE GENERACION INCORRECTA'
                mostrar_mensaje('SUR-01949','E',TRUE);
            END IF;            
            w_conceptos_genericos := kliquida.fobtparl( 'PCONGENE',:TEMP.CODMODEL,:TEMP.NUMVERMO,'****',fsysdate, 
                                     NULL,NULL,NULL,NULL,NULL,:TEMP.CODMODEL,:TEMP.NUMERDOC,:TEMP.NUMVERMO);   
            IF instr (w_conceptos_genericos,w_h1c004) <> 0 THEN 
                IF  LTRIM(RTRIM(W_h1c031)) IS  NULL THEN
                    -- "FECHA OBLIGATORIA"
                    mostrar_mensaje('SUR-01950','E',TRUE);
                ELSE
                    -- VALIDAR LA FECHA: MENOR QUE FSYSDATE Y PARA FESTIVOS
                    IF TO_DATE(W_H1C031,'DD/MM/YYYY') < TRUNC(FSYSDATE) THEN
                        -- MENSAJITO FECHA NO PUEDE SER INFERIOR AL DÍA
                        mostrar_mensaje('SUR-01951','E',TRUE); 
                    ELSE   
                        W_FECHA031 :=FFECOBLS (w_h1c019, 0 ,to_date(W_H1C031,'DD/MM/YYYY'));
                        IF TO_DATE(w_h1c031,'DD/MM/YYYY') <> TRUNC(w_fecha031)  THEN 
                            -- MENSAJITO CON 'FECHA NO VALIDA POR SER FESTIVO Y OFRECER LA FECHA W_FECHA31'
                            mostrar_mensaje('SUR-02143 #1'||W_FECHA031,'E',TRUE); 
                        ELSE                                    
                            BEGIN
                                UPDATE su_liquid 
                                   SET fecvenci = to_date(W_H1C031,'DD/MM/YYYY')
                                 WHERE docuni_codmodel = :temp.codmodel
                                   AND docuni_numvermo = :temp.numvermo
                                   AND docuni_numerdoc = :temp.numerdoc;
                            EXCEPTION 
                                WHEN OTHERS THEN
                                    NULL;
                            END;
                        END IF;
                    END IF;
                END IF;
            END IF;
            w_resultado := w_h1c031;
        END IF;   
        -- Plazo de pago
        IF w_marcador = 'PLAZPAGO' THEN
            IF LTRIM(RTRIM(W_PLAZPAGO)) IS NOT NULL AND LTRIM(RTRIM(W_H1C031)) IS NOT NULL THEN
                w_resultado := W_PLAZPAGO;
            
            ELSIF LTRIM(RTRIM(W_PLAZPAGO)) IS NULL  AND LTRIM(RTRIM(W_H1C031)) IS NOT NULL THEN
                MOSTRAR_MENSAJE('SUR-01944','E', TRUE);
            
            ELSIF LTRIM(RTRIM(W_PLAZPAGO)) IS NULL  AND LTRIM(RTRIM(W_H1C031)) IS NULL THEN
                w_resultado := 'Articulos 148.1,98 15 y 152.2 de la Ley 4/1998 de Tasas y Precios Públicos';
            
            ELSIF LTRIM(RTRIM(W_PLAZPAGO)) IS  NOT NULL AND LTRIM(RTRIM(W_H1C031)) IS NULL THEN
                w_resultado := W_PLAZPAGO;
            
            END IF;           
        END IF;
 
        -- Fecha Accidente 
        IF w_marcador = 'FECACCIDE' THEN 
            IF to_date(W_FECACCIDE,'DD/MM/YYYY') > TRUNC(FSYSDATE) THEN
                -- MENSAJITO 'LA FECHA DEL ACCIDENTE NO PUEDE SER SUPERIOR A LA FECHA DEL SISTEMA'
                mostrar_mensaje('SUR-01952','E',TRUE);
            END IF;
            w_resultado := W_FECACCIDE;
        END IF;
    END IF;

    ------------------------------------------------------------------------------------
    -- DOCUMENTO 0162
    ------------------------------------------------------------------------------------
    IF w_codmodel ='016' AND K000810.fexisver(w_codmodel, w_numvermo) THEN
    
        
        IF w_marcador = 'REC_SSCC' THEN       
		     
		        IF w_form_20 = 'Sí' THEN
		            w_resultado := NULL;
		        ELSIF w_form_20 IS NULL THEN
		        	  w_resultado := w_rec_sscc;
		        ELSE
		            IF w_rec_sscc IS NOT NULL THEN
		                w_resultado := w_rec_sscc;
		            ELSE
		            	  mostrar_mensaje('SUR-02511','E',TRUE);
		            END IF;	
		        
		        END IF;	
        
        END IF;
    	
    END IF;	    
        
END pvaldato; 
 
 
	*/
	//ID:383
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		* @param ePlantiCodplant
		* @param wMarcador
		* @param wResultado
		*/
		public void pvaldato(MarcadorAdapter marcadorElement, NString ePlantiCodplant, NString wMarcador, Ref<NString> wResultado)
		{
			int rowCount = 0;
			String sqlcArticulo = "SELECT rv_low_value articulo " +
	" FROM cg_ref_codes " +
	" WHERE rv_domain = 'ARTICULO INFRACCION TRIBUTARIA' AND rv_meaning = :P_PC_DESCRIPCION " +
	" ORDER BY rv_low_value";
			DataCursor cArticulo = new DataCursor(sqlcArticulo);
			NString cArticuloPcDescripcion = NString.getNull();
			String sqlcGrado = "SELECT gradinfr grado " +
	" FROM su_parsan " +
	" WHERE artinftr = :P_PC_ARTINFTR AND desgrinf = :P_PC_DESGRINF ";
			DataCursor cGrado = new DataCursor(sqlcGrado);
			NString cGradoPcArtinftr = NString.getNull();
			NString cGradoPcDesgrinf = NString.getNull();
			String sqlcCalifica = "SELECT calinftr califica " +
	" FROM su_parsan " +
	" WHERE artinftr = :P_PC_ARTINFTR AND desgrinf = :P_PC_DESGRINF ";
			DataCursor cCalifica = new DataCursor(sqlcCalifica);
			NString cCalificaPcArtinftr = NString.getNull();
			NString cCalificaPcDesgrinf = NString.getNull();
			String sqlcDescgrado = "SELECT rv_abbreviation " +
	" FROM cg_ref_codes " +
	" WHERE rv_domain = 'GRADO INFRACCION TRIBUTARIA' AND rv_low_value = :P_PC_VALOR ";
			DataCursor cDescgrado = new DataCursor(sqlcDescgrado);
			NString cDescgradoPcValor = NString.getNull();
			NString wAux = NString.getNull();
			NNumber wTmp = NNumber.getNull();
			NNumber wH1c065 = toNumber(0);
			NNumber wH1c075 = toNumber(0);
			NNumber wH1c085 = toNumber(0);
			NNumber wH1c084 = toNumber(0);
			NNumber wH1c089 = toNumber(0);
			NNumber wH1c052 = toNumber(0);
			NNumber wH1c061 = toNumber(0);
			NNumber wH1c062 = toNumber(0);
			NNumber wH1c064 = toNumber(0);
			NString wH1c031 = NString.getNull();
			NString wH1c050 = NString.getNull();
			NNumber wH1c075Inspec = toNumber(0);
			NNumber vConteo = toNumber(0);
			NNumber vExiste = toNumber(0);
			NString vModelo = NString.getNull();
			NString vVersion = NString.getNull();
			NString vNumerdoc = NString.getNull();
			NString vDocOrig = NString.getNull();
			NInteger j = toInt(0);
			NString wH1c004 = NString.getNull();
			NString wH1c019 = NString.getNull();
			NString wH1c021 = NString.getNull();
			NString wH1c023 = NString.getNull();
			NString wH1c024 = NString.getNull();
			NString wH1c025 = NString.getNull();
			NString wH1c027 = NString.getNull();
			NString wH1c040 = NString.getNull();
			NString wH1c041 = NString.getNull();
			NString wH1c055 = NString.getNull();
			NString wGradoinfr = NString.getNull();
			NString wArticinfr = NString.getNull();
			NString wArticulo = NString.getNull();
			NString wGrado = NString.getNull();
			NString wPlazoing0 = NString.getNull();
			NString wJunTea0 = NString.getNull();
			NString wForm1 = NString.getNull();
			NString wForm3 = NString.getNull();
			NString wForm6 = NString.getNull();
			NString wForm10 = NString.getNull();
			NString wForm14 = NString.getNull();
			NString wForm15 = NString.getNull();
			NString wForm17 = NString.getNull();
			NString wForm19 = NString.getNull();
			NString wConnect1 = NString.getNull();
			NString wFirrinsp = NString.getNull();
			NString wArti0 = NString.getNull();
			NString wCodmodel = NString.getNull();
			NString wNumvermo = NString.getNull();
			NString wCodterri = NString.getNull();
			NString wForm20 = NString.getNull();
			NString wRecSscc = NString.getNull();
			NString texto1 = NString.getNull();
			NString texto2 = NString.getNull();
			NString wPlazpago = NString.getNull();
			NString wViagenli = NString.getNull();
			NString wConceptosGenericos = NString.getNull();
			NString wFecaccide = NString.getNull();
			NDate wFecha031 = NDate.getNull();
			NDate vFechaPropuesta = NDate.getNull();
			NString vRecurso1 = NString.getNull();
			NString vIndvtono = NString.getNull();
			NString vExpediCodcircu = NString.getNull();
			NString vExpediCodterri = NString.getNull();
			NNumber vExpediEjeexped = NNumber.getNull();
			NNumber vExpediNumexped = NNumber.getNull();
			NNumber vDomici = toNumber(0);
			NString vCoddomic = NString.getNull();
			NNumber vEjercici = NNumber.getNull();
			NString vInslarCodareac = NString.getNull();
			NString vInslarCodclase = NString.getNull();
			NString vInslarCodlinar = NString.getNull();
			NNumber vInslejEjercici = NNumber.getNull();
			NString vInslejCodareac = NString.getNull();
			NString vInslejCodclase = NString.getNull();
			NString vInslejCodlinar = NString.getNull();
			NString vH1c021 = NString.getNull();
			K000810.TaDatos taDatos = new K000810.TaDatos();
			NString filaActual = toStr(getCursorRecord());
			NNumber vLineaOk = NNumber.getNull();
			NString vOrigen = NString.getNull();
			NNumber vEjercicioDocins = NNumber.getNull();
			try {
				wCodmodel = substring(ePlantiCodplant, toInt(1), toInt(3));
				wNumvermo = substring(ePlantiCodplant, toInt(4), toInt(1));
				texto1 = toStr("que \"las autoridades, cualesquiera que sea su naturaleza,los jefes o").append(" ").append("encargados de oficinas civiles o militares del Estado y de los demás").append(" ").append("entes públicos territoriales, los organismos autónomos y sociedades").append(" ").append("estatales; las Cámaras y corporaciones, colegios y asociaciones").append(" ").append("profesionales; las Mutualidades de Previsión Social; las demás entidades").append(" ").append("públicas, incluidas las gestoras de la Seguridad Social y quienes,").append(" ").append("en general, ejerzan funciones públicas, estarán obligados a suministrar").append(" ").append("a la Administración Tributaria cuantos datos y antecedentes con transcendencia").append(" ").append("tributaria recabe ésta mediante disposiciones de carácter general o a través de").append(" ").append("requerimientos concretos, y a prestarle a ella y a sus Agentes apoyo, concurso,").append(" ").append("auxilio y protección para el ejercicio de sus funciones\"");
				texto2 = toStr("la obligación de toda persona física o jurídica de proporcionar a la Administración").append(" ").append("Tributaria toda clase de datos, informes o antecedentes con trascendencia tributaria,").append(" ").append("deducidas de sus relaciones económicas, profesionales o financieras con otras persosnas");
				firstRecord(true);
				while (true) {
					wAux = miTrim(marcadorElement.getMarcador());
					if ( wAux.equals("CV_H1C075") )
					{
						wH1c075 = toNumber(isNull(marcadorElement.getValor(), "0"));
					}
					else if ( wAux.equals("CV_H1C085") ) {
						wH1c085 = toNumber(isNull(marcadorElement.getValor(), "0"));
					}
					else if ( wAux.equals("CV_H1C084") ) {
						wH1c084 = toNumber(isNull(marcadorElement.getValor(), "0"));
					}
					else if ( wAux.equals("CV_H1C089") ) {
						wH1c089 = toNumber(isNull(marcadorElement.getValor(), "0"));
					}
					else if ( wAux.equals("CV_H1C052") ) {
						wH1c052 = toNumber(isNull(marcadorElement.getValor(), "0"));
					}
					else if ( wAux.equals("CV_H1C061") ) {
						wH1c061 = toNumber(isNull(marcadorElement.getValor(), "0"));
						if ( wH1c061.notEquals(0) )
						{
							getFormModel().getTemp().setVMultaProporcional(toStr("S"));
						}
						else {
							getFormModel().getTemp().setVMultaProporcional(toStr("N"));
						}
					}
					else if ( wAux.equals("CV_H1C023") ) {
						wH1c023 = ((marcadorElement.getValor()));
					}
					else if ( wAux.equals("CV_H1C024") ) {
						wH1c024 = ((marcadorElement.getValor()));
					}
					else if ( wAux.equals("CV_H1C025") ) {
						wH1c025 = ((marcadorElement.getValor()));
					}
					else if ( wAux.equals("CV_H1C055") ) {
						wH1c055 = ((marcadorElement.getValor()));
					}
					else if ( wAux.equals("H1C021") ) {
						wH1c021 = ((marcadorElement.getValor()));
					}
					else if ( wAux.equals("PLAZOING0") ) {
						wPlazoing0 = ((marcadorElement.getValor()));
					}
					else if ( wAux.equals("JUN_TEA_0") ) {
						wJunTea0 = ((marcadorElement.getValor()));
					}
					else if ( wAux.equals("H1C019") ) {
						wH1c019 = ((marcadorElement.getValor()));
					}
					else if ( wAux.equals("FORM_1") ) {
						wForm1 = ((marcadorElement.getValor()));
					}
					else if ( wAux.equals("FORM_3") ) {
						wForm3 = ((marcadorElement.getValor()));
					}
					else if ( wAux.equals("FORM_10") ) {
						wForm10 = ((marcadorElement.getValor()));
					}
					else if ( wAux.equals("FORM_6") ) {
						wForm6 = ((marcadorElement.getValor()));
					}
					else if ( wAux.equals("FORM_14") ) {
						wForm14 = ((marcadorElement.getValor()));
					}
					else if ( wAux.equals("FORM_15") ) {
						wForm15 = ((marcadorElement.getValor()));
					}
					else if ( wAux.equals("FORM_17") ) {
						wForm17 = ((marcadorElement.getValor()));
					}
					else if ( wAux.equals("FORM_19") ) {
						wForm19 = ((marcadorElement.getValor()));
					}
					else if ( wAux.equals("CONNECT_1") ) {
						wConnect1 = ((marcadorElement.getValor()));
					}
					else if ( wAux.equals("FIRRINSP") ) {
						wFirrinsp = ((marcadorElement.getValor()));
					}
					else if ( wAux.equals("CV_H1C027") ) {
						wH1c027 = ((marcadorElement.getValor()));
					}
					else if ( wAux.equals("ARTI_0") ) {
						wArti0 = ((marcadorElement.getValor()));
					}
					else if ( wAux.equals("PLAZPAGO") ) {
						wPlazpago = ((marcadorElement.getValor()));
					}
					else if ( wAux.equals("CV_H1C031") ) {
						wH1c031 = ((marcadorElement.getValor()));
					}
					else if ( wAux.equals("H1C004") ) {
						wH1c004 = ((marcadorElement.getValor()));
					}
					else if ( wAux.equals("FECACCIDE") ) {
						wFecaccide = ((marcadorElement.getValor()));
					}
					else if ( wAux.equals("RECURSO_1") ) {
						vRecurso1 = ((marcadorElement.getValor()));
					}
					else if ( wAux.equals("CV_H1C040") ) {
						wH1c040 = ((marcadorElement.getValor()));
					}
					else if ( wAux.equals("CV_H1C065") ) {
						wH1c065 = toNumber(isNull(marcadorElement.getValor(), "0"));
						if ( wH1c065.notEquals(0) )
						{
							getFormModel().getTemp().setVMultaFija(toStr("S"));
						}
						else {
							getFormModel().getTemp().setVMultaFija(toStr("N"));
						}
					}
					else if ( wAux.equals("GRADOINFR") ) {
						wGradoinfr = ((marcadorElement.getValor()));
					}
					else if ( wAux.equals("ARTICINFR") ) {
						wArticinfr = ((marcadorElement.getValor()));
					}
					else if ( wAux.equals("H1C065") ) {
						wH1c075Inspec = toNumber(isNull(marcadorElement.getValor(), "0"));
						if ( wH1c075Inspec.notEquals(0) )
						{
							getFormModel().getTemp().setVMultaFija(toStr("S"));
						}
						else {
							getFormModel().getTemp().setVMultaFija(toStr("N"));
						}
					}
					else if ( wAux.equals("FORM_20") ) {
						wForm20 = ((marcadorElement.getValor()));
					}
					else if ( wAux.equals("REC_SSCC") ) {
						wRecSscc = ((marcadorElement.getValor()));
					}
					if ( wAux.equals("CV_H1C021") )
					{
						// Pasamos a númerico todo lo que introduce el usuario mediante
						// expresiones regulares.
						String sql1 = "SELECT regexp_replace(nvl(:MARCADOR_VALOR, '0'), '[^[:digit:]]', '') " +
	" FROM dual ";
						DataCommand command1 = new DataCommand(sql1);
						//Setting query parameters
						command1.addParameter("MARCADOR_VALOR", marcadorElement.getValor());
						ResultSet results1 = command1.executeQuery();
						rowCount = command1.getRowCount();
						if ( results1.hasData() ) {
							vH1c021 = results1.getStr(0);
						}
						results1.close();
					}
					else if ( wAux.equals("CV_H1C050") ) {
						wH1c050 = ((marcadorElement.getValor()));
					}
					if ( isInLastRecord(true) ) 
						break;
					nextRecord();
				}
				setCurrentRecord(toNumber(filaActual));
				// ---------------------------------------------------------------------------
				//   Se actualiza la fecha del documento con la fecha de construción del mismo.
				if ( wMarcador.equals("H1C020") )
				{
					wResultado.val = toChar(DbManager.getDBDateTime(), "DD/MM/YYYY");
				}
				// ---------------------------------------------------------------------------
				if ( wMarcador.equals("PLAZOING0") )
				{
					if ( wPlazoing0.equals("(artículo 62.2)") )
					{
						vIndvtono = toStr("1");
					}
					else if ( wPlazoing0.equals("(artículo 62.5)") ) {
						vIndvtono = toStr("2");
					}
					try
					{
						String sql2 = "UPDATE su_liquid " +
	"SET indvtono = :P_V_INDVTONO " +
	" WHERE docuni_codmodel = :TEMP_CODMODEL AND docuni_numvermo = :TEMP_NUMVERMO AND docuni_numerdoc = :TEMP_NUMERDOC";
						DataCommand command2 = new DataCommand(sql2);
						//Setting query parameters
						command2.addParameter("P_V_INDVTONO", vIndvtono);
						command2.addParameter("TEMP_CODMODEL", getFormModel().getTemp().getCodmodel());
						command2.addParameter("TEMP_NUMVERMO", getFormModel().getTemp().getNumvermo());
						command2.addParameter("TEMP_NUMERDOC", getFormModel().getTemp().getNumerdoc());
						rowCount = command2.execute();
					}
					catch(Exception  e)
					{
					}
				}
				//  Para el caso de PLAZOING0
				if ( wMarcador.equals("PLAZOING1") && wPlazoing0.equals("(artículo 62.2)") )
				{
					wResultado.val = toStr("20 del mes posterior");
				}
				else if ( wMarcador.equals("PLAZOING1") && wPlazoing0.equals("(artículo 62.5)") ) {
					wResultado.val = toStr("20 del mismo mes");
				}
				if ( wMarcador.equals("PLAZOING2") && wPlazoing0.equals("(artículo 62.2)") )
				{
					wResultado.val = toStr("5 del segundo mes posterior");
				}
				else if ( wMarcador.equals("PLAZOING2") && wPlazoing0.equals("(artículo 62.5)") ) {
					wResultado.val = toStr("5 del mes siguiente");
				}
				//  Para el caso de JUN_TEA_0 (Pie de recurso)
				if ( wMarcador.equals("JUN_TEA_1") && wJunTea0.equals("el Tribunal Económico-Administrativo Regional") )
				{
					wResultado.val = toStr("del Ministerio de Hacienda");
				}
				else if ( wMarcador.equals("JUN_TEA_1") && wJunTea0.equals("la Junta Provincial de Hacienda") ) {
					wResultado.val = toStr("de la Consejería de Hacienda y Administración Pública");
				}
				if ( wMarcador.equals("JUN_TEA_2") && wJunTea0.equals("el Tribunal Económico-Administrativo Regional") )
				{
					wResultado.val = K000810.fobteara(wH1c019, toNumber("1"));
				}
				else if ( wMarcador.equals("JUN_TEA_2") && wJunTea0.equals("la Junta Provincial de Hacienda") ) {
					wResultado.val = K000810.fobteara(wH1c019, toNumber("2"));
				}
				if ( wMarcador.equals("JUN_TEA_3") && wJunTea0.equals("el Tribunal Económico-Administrativo Regional") )
				{
					wResultado.val = toStr("Si por razón de la cuantía fuese aplicable lo establecido en el ").append("artículo 5.b) del Real Decreto Legislativo 2795/1980, de 12 de diciembre, ").append("por el que se articula la Ley 39/1980, de 5 de julio, de Bases sobre Procedimiento ").append("Económico-Administrativo, según redacción dada al mismo por la Ley 1/1998, ").append("de 26 de febrero, de Derechos y Garantías de los Contribuyentes, podrá ").append("interponerse directamente reclamación económico-administrativa ante el Tribunal ").append("Económico-Administrativo Central, igualmente dependiente del Ministerio de ").append("Hacienda, en el mismo plazo.");
				}
				else if ( wMarcador.equals("JUN_TEA_3") && wJunTea0.equals("la Junta Provincial de Hacienda") ) {
					wResultado.val = toStr("Si por razón de la cuantía fuese aplicable lo establecido en el ").append("artículo 5.b) del Real Decreto Legislativo 2795/1980, de 12 de diciembre, ").append("por el que se articula la Ley 39/1980, de 5 de julio, de Bases sobre Procedimiento ").append("Económico-Administrativo, según redacción dada al mismo por la Ley 1/1998, ").append("de 26 de febrero, de Derechos y Garantías de los Contribuyentes, podrá ").append("interponerse directamente reclamación económico-administrativa ante la Junta ").append("Superior de Hacienda, igualmente dependiente de la Consejería de Hacienda y ").append("Administración Pública, en el mismo plazo.");
				}
				//  Tratamiento del pie de recurso para liquidaciones.
				if ( wMarcador.equals("RECURSO_2") && vRecurso1.equals("el Tribunal Económico Administrativo Regional de Andalucía (Art. 226 y siguientes de la Ley 58/2003, de 17 de diciembre, General Tributaria)") )
				{
					wResultado.val = K000810.fobteara(wH1c019, toNumber("1"));
				}
				else if ( wMarcador.equals("RECURSO_2") && vRecurso1.equals("la Junta Provincial de Hacienda, regulada por Decreto 175/1987, de 14 de julio") ) {
					wResultado.val = K000810.fobteara(wH1c019, toNumber("2"));
				}
				if ( wMarcador.equals("RECURSO_3") && vRecurso1.equals("el Tribunal Económico Administrativo Regional de Andalucía (R.D. 391/1996, de 1 de marzo)") )
				{
					wResultado.val = toStr("el Tribunal Económico-Administrativo Central (Real Decreto Legislativo 2795/1980, de 12 de diciembre) ambos dependientes del Ministerio de Hacienda");
				}
				else if ( wMarcador.equals("RECURSO_3") && vRecurso1.equals("la Junta Provincial de Hacienda, regulada por Decreto 175/1987, de 14 de julio") ) {
					wResultado.val = toStr("la Junta Superior de Hacienda, ambas dependientes de la Consejería de Hacienda y Administración Pública");
				}
				//  Marcador NIF actuario
				if ( wMarcador.equals("CV_H1C027") )
				{
					try
					{
						String sql3 = "SELECT nifusuar " +
	" FROM su_usuari " +
	" WHERE LTRIM(RTRIM(nomusuar)) = LTRIM(RTRIM(:P_W_CONNECT_1)) AND indconex = 'S' ";
						DataCommand command3 = new DataCommand(sql3);
						//Setting query parameters
						command3.addParameter("P_W_CONNECT_1", wConnect1);
						ResultSet results3 = command3.executeQuery();
						rowCount = command3.getRowCount();
						if ( results3.hasData() ) {
							wResultado.val = results3.getStr(0);
						}
						results3.close();
					}
					catch(Exception  e)
					{
						try
						{
							String sql4 = "SELECT nifusuar " +
	" FROM su_usuari " +
	" WHERE LTRIM(RTRIM(nomusuar)) = LTRIM(RTRIM(:P_W_FIRRINSP)) AND indconex = 'S' ";
							DataCommand command4 = new DataCommand(sql4);
							//Setting query parameters
							command4.addParameter("P_W_FIRRINSP", wFirrinsp);
							ResultSet results4 = command4.executeQuery();
							rowCount = command4.getRowCount();
							if ( results4.hasData() ) {
								wResultado.val = results4.getStr(0);
							}
							results4.close();
						}
						catch(Exception ex)
						{
							wResultado.val = toStr(null);
							//throw ex;
						}
					}
				}
				//  Codigo de actuario
				if ( wMarcador.equals("CV_H1C400") )
				{
					if ( getFormModel().getTemp().getOperacion().equals("BO") && getFormModel().getTemp().getCodcliac().isNull() )
					{
						getFormModel().getTemp().setCodcliac(factuarioBorrador());
					}
					wResultado.val = getFormModel().getTemp().getCodcliac();
				}
				if ( wMarcador.equals("CV_H1C023") && K000810.fmodinsp(getFormModel().getTemp().getCodmodel()).getValue() )
				{
					//  Control sobre la fecha del acta para los documentos de inspección.
					if ( toDate(wH1c023, "DD/MM/YYYY").lesser(trunc(DbManager.getDBDateTime())) )
					{
						//  MENSAJITO FECHA NO PUEDE SER INFERIOR AL DÍA
						mostrarMensaje(toStr("SUR-11054"), toStr("E"), toBool(NBool.True));
					}
					else if ( toDate(wH1c023, "DD/MM/YYYY").greater(trunc(DbManager.getDBDateTime()).add(15)) ) {
						//  MENSAJITO FECHA NO PUEDE SER INFERIOR AL DÍA
						mostrarMensaje(toStr("SUR-02504 #1").append(toChar(((DbManager.getDBDateTime().add(15))), "DD/MM/YYYY")), toStr("E"), toBool(NBool.True));
					}
					else {
						vFechaPropuesta = StoredProcedures.ffecobls(wH1c019, toNumber(0), toDate(wH1c023, "DD/MM/YYYY"));
						if ( toDate(wH1c023, "DD/MM/YYYY").notEquals(trunc(vFechaPropuesta)) )
						{
							//  MENSAJITO CON 'FECHA NO VALIDA POR SER FESTIVO Y OFRECER LA FECHA W_FECHA31'
							mostrarMensaje(toStr("SUR-02143 #1").append(toChar(vFechaPropuesta, "DD/MM/YYYY")), toStr("E"), toBool(NBool.True));
						}
					}
					wResultado.val = wH1c023;
				}
				//  Validación de fecha de solicitud de devolución 
				if ( wMarcador.equals("CV_H1C055") )
				{
					//  Control sobre la fecha de la solicitud de devolución de transferencia
					if ( toDate(wH1c055, "DD/MM/YYYY").greater(trunc(DbManager.getDBDateTime())) )
					{
						//  MENSAJITO FECHA NO PUEDE SER MAYOR A LA ACTUAL
						mostrarMensaje(toStr("SUR-05036 #1").append("la fecha actual."), toStr("E"), toBool(NBool.True));
					}
					else {
						vFechaPropuesta = StoredProcedures.ffecobls(wH1c019, toNumber(0), toDate(wH1c055, "DD/MM/YYYY"));
						if ( toDate(wH1c055, "DD/MM/YYYY").notEquals(trunc(vFechaPropuesta)) )
						{
							//  MENSAJITO CON 'FECHA NO VALIDA POR SER FESTIVO Y OFRECER LA FECHA '
							mostrarMensaje(toStr("SUR-02143 #1").append(toChar(vFechaPropuesta, "DD/MM/YYYY")), toStr("E"), toBool(NBool.True));
						}
					}
					wResultado.val = wH1c055;
				}
				// ----------------------------------------------------------------------------------
				//  Para el caso de ARTI_0 (documento de salida 0322)                                
				// ----------------------------------------------------------------------------------
				if ( wCodmodel.equals("032") && K000810.fexisver(wCodmodel, wNumvermo).getValue() )
				{
					if ( wArti0.equals("artículo 111") )
					{
						wResultado.val = texto2;
					}
					else if ( wArti0.equals("artículo 112") ) {
						wResultado.val = texto1;
					}
				}
				//  Calculamos el valor del marcador según el modelo y versión 
				// ----------------------------------------------------------------------------------
				//  DOCUMENTO D00 Y D01
				// ----------------------------------------------------------------------------------
				if ((in(wCodmodel, "D00", "D01").getValue() && K000810.fexisver(wCodmodel, wNumvermo).getValue()))
				{
					if ( wMarcador.equals("FORM_2") && wForm1.equals("Transmisiones Patrimoniales y Actos Jurídicos Doc.") )
					{
						wResultado.val = toStr("Art. 103 del RD 828/1995, de 29 de mayo");
					}
					else if ( wMarcador.equals("FORM_2") && wForm1.equals("Sucesiones y Donaciones") ) {
						wResultado.val = toStr("Art. 70 del RD.1629/1991, de 8 de noviembre");
					}
					if ( wMarcador.equals("FORM_3") && wForm1.equals("Transmisiones Patrimoniales y Actos Jurídicos Doc.") )
					{
						if ((in(wForm3, "Art. 6 de la Ley 30/1983 de 28 de diciembre", "Art. 25 de la Ley 21/2001 de 27 de diciembre", "Art. 33 de la Ley 22/2009, de 18 de diciembre").getValue()))
						{
							wResultado.val = wForm3;
						}
						else {
							// w_resultado := NULL;
							mostrarMensaje(toStr("SUR-02510"), toStr("E"), toBool(NBool.True));
						}
					}
					if ( wMarcador.equals("FORM_3") && wForm1.equals("Sucesiones y Donaciones") )
					{
						if ((in(wForm3, "Art. 5 de la Ley 30/1983 de 28 de diciembre", "Art. 24 de la Ley 21/2001 de 27 de diciembre", "Art. 32 de la Ley 22/2009, de 18 de diciembre").getValue()))
						{
							wResultado.val = wForm3;
						}
						else {
							//   w_resultado := NULL;
							mostrarMensaje(toStr("SUR-02510"), toStr("E"), toBool(NBool.True));
						}
					}
				}
				// ----------------------------------------------------------------------------------
				//  DOCUMENTO 001
				// ----------------------------------------------------------------------------------
				if ( wCodmodel.equals("001") && K000810.fexisver(wCodmodel, wNumvermo).getValue() )
				{
					if ( wMarcador.equals("FORM_3") )
					{
						wResultado.val = wH1c023;
					}
					else if ( wMarcador.equals("FORM_20") ) {
						wResultado.val = wForm6;
					}
					else if ( wMarcador.equals("FORM_18") ) {
						wResultado.val = wForm17;
					}
				}
				// ----------------------------------------------------------------------------------
				//  DOCUMENTO 002 
				// ----------------------------------------------------------------------------------
				if ( wCodmodel.equals("002") && K000810.fexisver(wCodmodel, wNumvermo).getValue() )
				{
					if ( wMarcador.equals("CV_H1C083") )
					{
						wTmp = wH1c075.add(wH1c085).add(wH1c084);
						wResultado.val = toChar(wTmp);
					}
					else if ( wMarcador.equals("CV_H1C099") ) {
						wTmp = wH1c075.add(wH1c085).add(wH1c084).subtract(wH1c089);
						wResultado.val = toChar(wTmp);
					}
					else if ( wMarcador.equals("FORM_3") ) {
						wResultado.val = wH1c023;
					}
					else if ( wMarcador.equals("FORM_24") ) {
						wResultado.val = wForm6;
					}
					else if ( wMarcador.equals("FORM_21") ) {
						wResultado.val = wForm19;
					}
					else if ( wMarcador.equals("CV_H1C075") ) {
						if ( wH1c075.equals(0) )
						{
							wResultado.val = toChar(wH1c075, "9D99");
						}
						else {
							wResultado.val = toChar(wH1c075);
						}
					}
					else if ( wMarcador.equals("CV_H1C084") ) {
						if ( wH1c084.equals(0) )
						{
							wResultado.val = toChar(wH1c084, "9D99");
						}
						else {
							wResultado.val = toChar(wH1c084);
						}
					}
					else if ( wMarcador.equals("CV_H1C085") ) {
						if ( wH1c085.equals(0) )
						{
							wResultado.val = toChar(wH1c085, "9D99");
						}
						else {
							wResultado.val = toChar(wH1c085);
						}
					}
					else if ( wMarcador.equals("CV_H1C089") ) {
						if ( wH1c089.equals(0) )
						{
							wResultado.val = toChar(wH1c089, "9D99");
						}
						else {
							wResultado.val = toChar(wH1c089);
						}
					}
					else if ( wMarcador.equals("CV_H1C025") ) {
						wResultado.val = wH1c025;
						try
						{
							String sql5 = "UPDATE SU_DOCUNI " +
	"SET CONCEP_CODCONCE = SUBSTR(:P_W_H1C025, 1, 4), CONCEP_CODMODEL = :P_W_CODMODEL " +
	" WHERE VERMOD_CODMODEL = :PARAMETER_P_CODMODEL AND VERMOD_NUMVERMO = :PARAMETER_P_NUMVERMO AND NUMERDOC = :PARAMETER_P_NUMERDOC";
							DataCommand command5 = new DataCommand(sql5);
							//Setting query parameters
							command5.addParameter("P_W_H1C025", wH1c025);
							command5.addParameter("P_W_CODMODEL", wCodmodel);
							command5.addParameter("PARAMETER_P_CODMODEL", this.getFormModel().getParam("P_CODMODEL", NString.class));
							command5.addParameter("PARAMETER_P_NUMVERMO", this.getFormModel().getParam("P_NUMVERMO", NString.class));
							command5.addParameter("PARAMETER_P_NUMERDOC", this.getFormModel().getParam("P_NUMERDOC", NString.class));
							rowCount = command5.execute();
						}
						catch(Exception  e)
						{
						}
					}
				}
				// ----------------------------------------------------------------------------------
				//  DOCUMENTO 003
				// ----------------------------------------------------------------------------------
				if ( wCodmodel.equals("003") )
				{
					if ( wMarcador.equals("FORM_3") )
					{
						wResultado.val = wH1c023;
					}
				}
				// ----------------------------------------------------------------------------------
				//  DOCUMENTO 006
				// ----------------------------------------------------------------------------------
				if ( wCodmodel.equals("006") && K000810.fexisver(wCodmodel, wNumvermo).getValue() )
				{
					if ( wMarcador.equals("FORM_3") )
					{
						wResultado.val = wH1c023;
					}
					else if ( wMarcador.equals("FORM_20") ) {
						wResultado.val = wForm6;
					}
					else if ( wMarcador.equals("FORM_19") ) {
						wResultado.val = wForm14;
					}
					else if ( wMarcador.equals("FORM_16") ) {
						wResultado.val = wForm15;
					}
					else if ( wMarcador.equals("FORM_18") ) {
						wResultado.val = wForm17;
					}
				}
				// ----------------------------------------------------------------------------------
				//  DOCUMENTO 007
				// ----------------------------------------------------------------------------------
				if ( wCodmodel.equals("007") && K000810.fexisver(wCodmodel, wNumvermo).getValue() )
				{
					if ( wMarcador.equals("FORM_4") )
					{
						wResultado.val = wH1c023;
					}
					else if ( wMarcador.equals("FORM_19") ) {
						wResultado.val = wForm6;
					}
					else if ( wMarcador.equals("FORM_18") ) {
						wResultado.val = wForm10;
					}
					else if ( wMarcador.equals("FORM_17") ) {
						wResultado.val = wForm10;
					}
					else if ( wMarcador.equals("FORM_16") ) {
						wResultado.val = wForm10;
					}
					else if ( wMarcador.equals("FORM_15") ) {
						wResultado.val = wForm10;
					}
					else if ( wMarcador.equals("H1C075") ) {
						wResultado.val = toStr(wH1c075Inspec);
					}
				}
				// ------------------------------------------------------------------------------
				// - LÍNEAS INSPEC: VÁLIDO PARA TODOS LOS MÓDELOS DE INSPECCIÓN (007, 008 Y 050)
				// -----------------------------------------------------------------------------
				//  Obtenemos las lineas de inspección a través de la unidad de programa.
				Ref<NNumber> p_ejercici_ref = new Ref<NNumber>(vEjercici);
				Ref<NString> p_inslar_codareac_ref = new Ref<NString>(vInslarCodareac);
				Ref<NString> p_inslar_codclase_ref = new Ref<NString>(vInslarCodclase);
				Ref<NString> p_inslar_codlinar_ref = new Ref<NString>(vInslarCodlinar);
				K000810.plinact(getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getVMultaFija(), p_ejercici_ref, p_inslar_codareac_ref, p_inslar_codclase_ref, p_inslar_codlinar_ref);
				vEjercici = p_ejercici_ref.val;
				vInslarCodareac = p_inslar_codareac_ref.val;
				vInslarCodclase = p_inslar_codclase_ref.val;
				vInslarCodlinar = p_inslar_codlinar_ref.val;
				if ( wMarcador.equals("CV_H1C300") )
				{
					wResultado.val = toStr(vEjercici);
				}
				else if ( wMarcador.equals("CV_H1C301") ) {
					wResultado.val = vInslarCodareac;
				}
				else if ( wMarcador.equals("CV_H1C302") ) {
					wResultado.val = vInslarCodclase;
				}
				else if ( wMarcador.equals("CV_H1C303") ) {
					wResultado.val = vInslarCodlinar;
				}
				// ----------------------------------------------------------------------------------
				//  DOCUMENTO 008
				// ----------------------------------------------------------------------------------     
				if ( wCodmodel.equals("008") && K000810.fexisver(wCodmodel, wNumvermo).getValue() )
				{
					if ( wMarcador.equals("FORM_4") )
					{
						wResultado.val = wH1c023;
					}
					else if ( wMarcador.equals("FORM_18") ) {
						wResultado.val = wForm6;
					}
					else if ( wMarcador.equals("FORM_17") ) {
						wResultado.val = wForm10;
					}
					else if ( wMarcador.equals("FORM_16") ) {
						wResultado.val = wForm10;
					}
					else if ( wMarcador.equals("FORM_15") ) {
						wResultado.val = wForm10;
					}
					else if ( wMarcador.equals("CV_H1C075") ) {
						wTmp = (wH1c052.multiply(wH1c061)).divide(100);
						wResultado.val = toChar(wTmp);
					}
					else if ( wMarcador.equals("CV_H1C099") ) {
						if ( wH1c065.equals(0) )
						{
							wTmp = ((wH1c052.multiply(wH1c061)).divide(100)).subtract(wH1c089);
							wResultado.val = toChar(wTmp);
						}
						else {
							//  para asignar el importe de multa fija
							//  como el importe correcto en el modelo 008 versión 3.
							wResultado.val = toChar(wH1c065);
						}
					}
					else if ( wMarcador.equals("CV_H1C052") ) {
						if ( wH1c052.equals(0) )
						{
							wResultado.val = toChar(wH1c052, "0D99");
						}
						else {
							wResultado.val = toChar(wH1c052);
						}
					}
					else if ( wMarcador.equals("CV_H1C061") ) {
						if ( wH1c061.equals(0) )
						{
							wResultado.val = toChar(wH1c061, "0D99");
						}
						else {
							wResultado.val = toChar(wH1c061);
						}
					}
					else if ( wMarcador.equals("CV_H1C089") ) {
						if ( wH1c089.equals(0) )
						{
							wResultado.val = toChar(wH1c089, "0D99");
						}
						else {
							wResultado.val = toChar(wH1c089);
						}
					}
					else if ( wMarcador.equals("CV_H1C065") ) {
						wResultado.val = toChar(wH1c065);
					}
					else if ( wMarcador.equals("CV_H1C025") ) {
						wResultado.val = wH1c025;
						try
						{
							String sql6 = "UPDATE SU_DOCUNI " +
	"SET CONCEP_CODCONCE = SUBSTR(:P_W_H1C025, 1, 4), CONCEP_CODMODEL = :P_W_CODMODEL " +
	" WHERE VERMOD_CODMODEL = :PARAMETER_P_CODMODEL AND VERMOD_NUMVERMO = :PARAMETER_P_NUMVERMO AND NUMERDOC = :PARAMETER_P_NUMERDOC";
							DataCommand command6 = new DataCommand(sql6);
							//Setting query parameters
							command6.addParameter("P_W_H1C025", wH1c025);
							command6.addParameter("P_W_CODMODEL", wCodmodel);
							command6.addParameter("PARAMETER_P_CODMODEL", this.getFormModel().getParam("P_CODMODEL", NString.class));
							command6.addParameter("PARAMETER_P_NUMVERMO", this.getFormModel().getParam("P_NUMVERMO", NString.class));
							command6.addParameter("PARAMETER_P_NUMERDOC", this.getFormModel().getParam("P_NUMERDOC", NString.class));
							rowCount = command6.execute();
						}
						catch(Exception  e)
						{
						}
					}
					else if ( wMarcador.equals("CV_H1C050") ) {
						if ( wH1c050.isNull() )
						{
							String sql7 = "SELECT valcasil " +
	" FROM su_casval " +
	" WHERE docuni_codmodel = :TEMP_CODMODEL AND docuni_numvermo = :TEMP_NUMVERMO AND docuni_numerdoc = :TEMP_NUMERDOC AND CASMOD_NUMCASIL = '050' ";
							DataCommand command7 = new DataCommand(sql7);
							//Setting query parameters
							command7.addParameter("TEMP_CODMODEL", getFormModel().getTemp().getCodmodel());
							command7.addParameter("TEMP_NUMVERMO", getFormModel().getTemp().getNumvermo());
							command7.addParameter("TEMP_NUMERDOC", getFormModel().getTemp().getNumerdoc());
							ResultSet results7 = command7.executeQuery();
							rowCount = command7.getRowCount();
							if ( results7.hasData() ) {
								vOrigen = results7.getStr(0);
							}
							results7.close();
							wH1c050 = vOrigen;
						}
						if ( getFormModel().getTemp().getVMultaProporcional().equals("S") )
						{
							//  Vamos a asegurar que todos todos los documentos de Inspección tengan asociados
							//  un documento origen (ACTAS DE INSPECCIÓN).
							vConteo = toNumber(length(toStr(isNull(vH1c021, 0))));
							if ( vConteo.equals(13) )
							{
								//  debe de venir un documento con la estrucutra SUR cuál su longitud debe ser de 13 carácteres.
								//  y además que se encuentre en al tabla de documentos.
								vModelo = substring(vH1c021, toInt(1), toInt(3));
								vVersion = substring(vH1c021, toInt(4), toInt(1));
								vNumerdoc = substring(vH1c021, toInt(5));
								String sql8 = "SELECT COUNT(*) " +
	" FROM su_docuni " +
	" WHERE vermod_codmodel = :P_V_MODELO AND vermod_numvermo = :P_V_VERSION AND numerdoc = :P_V_NUMERDOC ";
								DataCommand command8 = new DataCommand(sql8);
								//Setting query parameters
								command8.addParameter("P_V_MODELO", vModelo);
								command8.addParameter("P_V_VERSION", vVersion);
								command8.addParameter("P_V_NUMERDOC", vNumerdoc);
								ResultSet results8 = command8.executeQuery();
								rowCount = command8.getRowCount();
								if ( results8.hasData() ) {
									vExiste = results8.getNumber(0);
								}
								results8.close();
								if ( vExiste.notEquals(0) )
								{
									vDocOrig = vH1c021;
								}
								else {
									vDocOrig = toStr(null);
								}
							}
							else {
								vDocOrig = toStr(null);
							}
							//  El documento origen será la referencia a Acta que introduzca el usuario cuando
							//  venga vacio el doc. origen, sea una multa proporcional y lo que introduzca el usuario
							//  sea un documento válido en Sur.
							if ( wH1c050.isNull() && getFormModel().getTemp().getVMultaProporcional().equals("S") && vDocOrig.isNotNull() )
							{
								wResultado.val = vDocOrig;
							}
							else {
								wResultado.val = wH1c050;
							}
						}
						else if ( getFormModel().getTemp().getVMultaProporcional().equals("N") && wH1c050.isNull() ) {
						}
						else {
							wResultado.val = wH1c050;
						}
					}
					//  Controlamos que solo venga relleno un tipo de multa.
					controlaMultas();
				}
				// ----------------------------------------------------------------------------------
				//  DOCUMENTO A25
				// ----------------------------------------------------------------------------------     
				if ( wCodmodel.equals("A25") )
				{
					if ( wArticinfr.isNotNull() )
					{
						//  Obtener el valor del codigo de articulo
						wArticulo = toStr(null);
						cArticuloPcDescripcion = wArticinfr;
						//Setting query parameters
						cArticulo.addParameter("P_PC_DESCRIPCION", cArticuloPcDescripcion);
						//F2J_WARNING : Make sure that the method "Close" is being called over the variable cArticulo.
						cArticulo.open();
						ResultSet cArticuloResults = cArticulo.fetchInto();
						if ( cArticuloResults != null ) {
							wArticulo = cArticuloResults.getStr(0);
						}
						cArticulo.close();
						if ( wMarcador.equals("CV_H1C066") )
						{
							//  Grado infracción
							if ( wGradoinfr.isNotNull() )
							{
								cGradoPcArtinftr = wArticulo;
								cGradoPcDesgrinf = wGradoinfr;
								//Setting query parameters
								cGrado.addParameter("P_PC_ARTINFTR", cGradoPcArtinftr);
								cGrado.addParameter("P_PC_DESGRINF", cGradoPcDesgrinf);
								//F2J_WARNING : Make sure that the method "Close" is being called over the variable cGrado.
								cGrado.open();
								ResultSet cGradoResults = cGrado.fetchInto();
								if ( cGradoResults != null ) {
									wResultado.val = cGradoResults.getStr(0);
								}
								cGrado.close();
							}
						}
						else if ( wMarcador.equals("CV_H1C067") ) {
							//  Articulo infraccion (su_parsan)
							wResultado.val = wArticulo;
						}
						else if ( wMarcador.equals("CV_H1C068") ) {
							//  Calificacion (su_parsan)
							if ( wGradoinfr.isNotNull() )
							{
								cCalificaPcArtinftr = wArticulo;
								cCalificaPcDesgrinf = wGradoinfr;
								//Setting query parameters
								cCalifica.addParameter("P_PC_ARTINFTR", cCalificaPcArtinftr);
								cCalifica.addParameter("P_PC_DESGRINF", cCalificaPcDesgrinf);
								//F2J_WARNING : Make sure that the method "Close" is being called over the variable cCalifica.
								cCalifica.open();
								ResultSet cCalificaResults = cCalifica.fetchInto();
								if ( cCalificaResults != null ) {
									wResultado.val = cCalificaResults.getStr(0);
								}
								cCalifica.close();
							}
						}
						else if ( wMarcador.equals("CV_H1C069") ) {
							//  Descripcion corta grado infraccion
							wGrado = toStr(null);
							if ( wGradoinfr.isNotNull() )
							{
								cGradoPcArtinftr = wArticulo;
								cGradoPcDesgrinf = wGradoinfr;
								//Setting query parameters
								cGrado.addParameter("P_PC_ARTINFTR", cGradoPcArtinftr);
								cGrado.addParameter("P_PC_DESGRINF", cGradoPcDesgrinf);
								//F2J_WARNING : Make sure that the method "Close" is being called over the variable cGrado.
								cGrado.open();
								ResultSet cGradoResults = cGrado.fetchInto();
								if ( cGradoResults != null ) {
									wGrado = cGradoResults.getStr(0);
								}
								cGrado.close();
								if ( wGrado.isNotNull() )
								{
									cDescgradoPcValor = wGrado;
									//Setting query parameters
									cDescgrado.addParameter("P_PC_VALOR", cDescgradoPcValor);
									//F2J_WARNING : Make sure that the method "Close" is being called over the variable cDescgrado.
									cDescgrado.open();
									ResultSet cDescgradoResults = cDescgrado.fetchInto();
									if ( cDescgradoResults != null ) {
										wResultado.val = cDescgradoResults.getStr(0);
									}
									cDescgrado.close();
								}
							}
						}
					}
				}
				// ----------------------------------------------------------------------------------------------------
				//  DOCUMENTO 026 AVRA
				//  Controlar que para la opción de devolución hay previamente una solicitud de devolución con su fecha
				// ----------------------------------------------------------------------------------------------------
				if ( wCodmodel.equals("026") && K000810.fexisver(wCodmodel, wNumvermo).getValue() )
				{
					if ( wMarcador.equals("FORM_1") && wForm1.equals("Solicitud de documentación en devolución fianza") )
					{
						if ( isNull(Kparplan.ffechasol(wH1c021), "NULO").equals("NULO") )
						{
							mostrarMensaje(toStr("SUR-04457"), toStr("E"), toBool(NBool.True));
						}
						else {
							wResultado.val = wForm1;
						}
					}
					else {
						wResultado.val = wForm1;
					}
				}
				// ----------------------------------------------------------------------------------
				//  DOCUMENTO R01
				// ----------------------------------------------------------------------------------
				if ( wCodmodel.equals("R01") && K000810.fexisver(wCodmodel, wNumvermo).getValue() )
				{
					if ( wMarcador.equals("FORM_3") )
					{
						wResultado.val = wH1c023;
					}
					else if ( wMarcador.equals("FORM_23") ) {
						wResultado.val = wForm6;
					}
					else if ( wMarcador.equals("FORM_18") ) {
						wResultado.val = wForm17;
					}
					else if ( wMarcador.equals("CV_H1C083") ) {
						wTmp = wH1c075.add(wH1c085).add(wH1c084);
						wResultado.val = toChar(wTmp);
					}
					else if ( wMarcador.equals("CV_H1C099") ) {
						wTmp = wH1c075.add(wH1c085).add(wH1c084).subtract(wH1c089);
						wResultado.val = toChar(wTmp);
					}
					else if ( wMarcador.equals("CV_H1C075") ) {
						if ( wH1c075.equals(0) )
						{
							wResultado.val = toChar(wH1c075, "9D99");
						}
						else {
							wResultado.val = toChar(wH1c075);
						}
					}
					else if ( wMarcador.equals("CV_H1C084") ) {
						if ( wH1c084.equals(0) )
						{
							wResultado.val = toChar(wH1c084, "9D99");
						}
						else {
							wResultado.val = toChar(wH1c084);
						}
					}
					else if ( wMarcador.equals("CV_H1C085") ) {
						if ( wH1c085.equals(0) )
						{
							wResultado.val = toChar(wH1c085, "9D99");
						}
						else {
							wResultado.val = toChar(wH1c085);
						}
					}
					else if ( wMarcador.equals("CV_H1C089") ) {
						if ( wH1c089.equals(0) )
						{
							wResultado.val = toChar(wH1c089, "9D99");
						}
						else {
							wResultado.val = toChar(wH1c089);
						}
					}
				}
				// ----------------------------------------------------------------------------------
				//  DOCUMENTO 132
				// ----------------------------------------------------------------------------------
				if ( wCodmodel.equals("132") )
				{
					if ( wMarcador.equals("CV_H1C025") )
					{
						wResultado.val = K000810.fmod132(wH1c024);
					}
					if ( wMarcador.equals("CV_H1C040") )
					{
						if ( ltrim(rtrim(wH1c040))== null )
						{
							//  mensajito "Introduzca un NIF"
							mostrarMensaje(toStr("SUR-01365"), toStr("E"), toBool(NBool.True));
						}
						else {
							if ( StoredProcedures.fvalfnif(wH1c040).equals("1") )
							{
								mostrarMensaje(toStr("SUR-00902"), toStr("E"), toBool(NBool.True));
							}
							else {
								//  Hacemos las comprobaciones necesarias al NIF
								getTask().getSur().pvalcli(toStr("marcador.valor"), toStr(null), toStr(null), toBool(NBool.False), toBool(NBool.True));
								//  Esta procedimiento devuelve en las globales global.nifclien y global.codclien
								//  el nif y el código del cliente que hemos seleccionado en el modulo M000121.
								wResultado.val = wH1c040;
								if ( getGlobal("PREVIEW").equals("I") )
								{
									try
									{
										vExpediCodcircu = substring(wH1c021, toInt(1), inStrNullable(wH1c021, toStr("-")).subtract(1));
										wH1c021 = substring(wH1c021, inStrNullable(wH1c021, toStr("-")).add(1));
										vExpediCodterri = substring(wH1c021, toInt(1), inStrNullable(wH1c021, toStr("-")).subtract(1));
										wH1c021 = substring(wH1c021, inStrNullable(wH1c021, toStr("-")).add(1));
										vExpediEjeexped = toNumber(substring(wH1c021, toInt(1), inStrNullable(wH1c021, toStr("/")).subtract(1)));
										vExpediNumexped = toNumber(rtrim(ltrim(substring(wH1c021, inStrNullable(wH1c021, toStr("/")).add(1)))));
									}
									catch(Exception  e)
									{
									}
									try
									{
										String sql9 = "INSERT INTO su_nifexp " +
	"(expedi_codcircu, expedi_codterri, expedi_ejeexped, expedi_numexped, client_codclien, sujcir_codcircu, sujcir_codtipsu)" +
	"VALUES (:P_V_EXPEDI_CODCIRCU, :P_V_EXPEDI_CODTERRI, :P_V_EXPEDI_EJEEXPED, :P_V_EXPEDI_NUMEXPED, :GLOBAL_CODCLIEN, :P_V_EXPEDI_CODCIRCU, 'DE')";
										DataCommand command9 = new DataCommand(sql9);
										//Setting query parameters
										command9.addParameter("P_V_EXPEDI_CODCIRCU", vExpediCodcircu);
										command9.addParameter("P_V_EXPEDI_CODTERRI", vExpediCodterri);
										command9.addParameter("P_V_EXPEDI_EJEEXPED", vExpediEjeexped);
										command9.addParameter("P_V_EXPEDI_NUMEXPED", vExpediNumexped);
										command9.addParameter("GLOBAL_CODCLIEN", getGlobal("CODCLIEN"));
										rowCount = command9.execute();
									}
									catch(DataLayerException e)
									{
									}
									catch(Exception  e)
									{
									}
								}
							}
						}
					}
					if ( wMarcador.equals("CV_H1C041") )
					{
						try
						{
							String sql10 = "SELECT SUBSTR(NOMCLIEN, 1, 60) " +
	" FROM SU_CLIENT " +
	" WHERE CODCLIEN = :GLOBAL_CODCLIEN ";
							DataCommand command10 = new DataCommand(sql10);
							//Setting query parameters
							command10.addParameter("GLOBAL_CODCLIEN", getGlobal("CODCLIEN"));
							ResultSet results10 = command10.executeQuery();
							rowCount = command10.getRowCount();
							if ( results10.hasData() ) {
								wResultado.val = results10.getStr(0);
							}
							results10.close();
						}
						catch(Exception  e)
						{
						}
					}
				}
				// ----------------------------------------------------------------------------------
				//  DOCUMENTO 050
				// ----------------------------------------------------------------------------------
				if ( wCodmodel.equals("050") )
				{
					//  Se inicializa a X para calcular la línea de inspección en la 
					//  unidad de programa Obtener_linea_inspección
					getFormModel().getTemp().setVMultaFija(toStr("X"));
					if ( wMarcador.equals("CV_H1C040") )
					{
						if ( ltrim(rtrim(wH1c040))== null )
						{
							//  mensajito "Introduzca un NIF"
							mostrarMensaje(toStr("SUR-01365"), toStr("E"), toBool(NBool.True));
						}
						else {
							if ( StoredProcedures.fvalfnif(wH1c040).equals("1") )
							{
								mostrarMensaje(toStr("SUR-00902"), toStr("E"), toBool(NBool.True));
							}
							else {
								//  Hacemos las comprobaciones necesarias al NIF
								getTask().getSur().pvalcli(toStr("marcador.valor"), toStr(null), toStr(null), toBool(NBool.False), toBool(NBool.True));
								//  Esta procedimiento devuelve en las globales global.nifclien y global.codclien
								//  el nif y el código del cliente que hemos seleccionado en el modulo M000121.
								wResultado.val = wH1c040;
							}
						}
						try
						{
							String sql11 = "SELECT coddomic " +
	" FROM su_domici " +
	" WHERE client_codclien = :GLOBAL_CODCLIEN AND inddomfi = 'S' ";
							DataCommand command11 = new DataCommand(sql11);
							//Setting query parameters
							command11.addParameter("GLOBAL_CODCLIEN", getGlobal("CODCLIEN"));
							ResultSet results11 = command11.executeQuery();
							rowCount = command11.getRowCount();
							if ( results11.hasData() ) {
								getFormModel().getTemp().setCoddomic(results11.getStr(0));
							}
							results11.close();
						}
						catch(TooManyRowsException e)
						{
							mostrarMensaje(toStr("SUR-00769"), toStr("E"), toBool(NBool.True));
						}
						catch(NoDataFoundException e)
						{
							mostrarMensaje(toStr("SUR-00770"), toStr("E"), toBool(NBool.True));
						}
						catch(Exception  e)
						{
						}
					}
					// ---------------------------------------------------------------------------------
					//  En la primera pasada el nif aún no está relleno por lo que no se van a recuperar
					//  datos en las consultas de los marcadores, se lanzará la excepción NO_DATA_FOUND 
					//  y dejamos que no haga nada, en el resto de pasadas si debería de recuperar datos.
					// ---------------------------------------------------------------------------------
					//  dependiendo del marcador comenzamos a obtener los datos del domicilio.
					if ( wMarcador.equals("CV_H1C041") )
					{
						try
						{
							String sql12 = "SELECT substr(nomclien, 1, 60) " +
	" FROM su_client " +
	" WHERE codclien = :GLOBAL_CODCLIEN ";
							DataCommand command12 = new DataCommand(sql12);
							//Setting query parameters
							command12.addParameter("GLOBAL_CODCLIEN", getGlobal("CODCLIEN"));
							ResultSet results12 = command12.executeQuery();
							rowCount = command12.getRowCount();
							if ( results12.hasData() ) {
								wResultado.val = results12.getStr(0);
							}
							results12.close();
						}
						catch(NoDataFoundException e)
						{
						}
					}
					else if ( wMarcador.equals("CV_H1C042") ) {
						try
						{
							String sql13 = "SELECT NVL(codviapu, NULL) " +
	" FROM su_domici " +
	" WHERE coddomic = :TEMP_CODDOMIC ";
							DataCommand command13 = new DataCommand(sql13);
							//Setting query parameters
							command13.addParameter("TEMP_CODDOMIC", getFormModel().getTemp().getCoddomic());
							ResultSet results13 = command13.executeQuery();
							rowCount = command13.getRowCount();
							if ( results13.hasData() ) {
								wResultado.val = results13.getStr(0);
							}
							results13.close();
						}
						catch(NoDataFoundException e)
						{
						}
					}
					else if ( wMarcador.equals("CV_H1C043") ) {
						try
						{
							String sql14 = "SELECT NVL(denviapu, NULL) " +
	" FROM su_domici " +
	" WHERE coddomic = :TEMP_CODDOMIC ";
							DataCommand command14 = new DataCommand(sql14);
							//Setting query parameters
							command14.addParameter("TEMP_CODDOMIC", getFormModel().getTemp().getCoddomic());
							ResultSet results14 = command14.executeQuery();
							rowCount = command14.getRowCount();
							if ( results14.hasData() ) {
								wResultado.val = results14.getStr(0);
							}
							results14.close();
						}
						catch(NoDataFoundException e)
						{
						}
					}
					else if ( wMarcador.equals("CV_H1C044") ) {
						try
						{
							String sql15 = "SELECT NVL(numviapu, NULL) " +
	" FROM su_domici " +
	" WHERE coddomic = :TEMP_CODDOMIC ";
							DataCommand command15 = new DataCommand(sql15);
							//Setting query parameters
							command15.addParameter("TEMP_CODDOMIC", getFormModel().getTemp().getCoddomic());
							ResultSet results15 = command15.executeQuery();
							rowCount = command15.getRowCount();
							if ( results15.hasData() ) {
								wResultado.val = results15.getStr(0);
							}
							results15.close();
						}
						catch(NoDataFoundException e)
						{
						}
					}
					else if ( wMarcador.equals("CV_H1C045") ) {
						try
						{
							String sql16 = "SELECT NVL(letviapu, NULL) " +
	" FROM su_domici " +
	" WHERE coddomic = :TEMP_CODDOMIC ";
							DataCommand command16 = new DataCommand(sql16);
							//Setting query parameters
							command16.addParameter("TEMP_CODDOMIC", getFormModel().getTemp().getCoddomic());
							ResultSet results16 = command16.executeQuery();
							rowCount = command16.getRowCount();
							if ( results16.hasData() ) {
								wResultado.val = results16.getStr(0);
							}
							results16.close();
						}
						catch(NoDataFoundException e)
						{
						}
					}
					else if ( wMarcador.equals("CV_H1C046") ) {
						try
						{
							String sql17 = "SELECT NVL(escviapu, NULL) " +
	" FROM su_domici " +
	" WHERE coddomic = :TEMP_CODDOMIC ";
							DataCommand command17 = new DataCommand(sql17);
							//Setting query parameters
							command17.addParameter("TEMP_CODDOMIC", getFormModel().getTemp().getCoddomic());
							ResultSet results17 = command17.executeQuery();
							rowCount = command17.getRowCount();
							if ( results17.hasData() ) {
								wResultado.val = results17.getStr(0);
							}
							results17.close();
						}
						catch(NoDataFoundException e)
						{
						}
					}
					else if ( wMarcador.equals("CV_H1C047") ) {
						try
						{
							String sql18 = "SELECT NVL(plaviapu, NULL) " +
	" FROM su_domici " +
	" WHERE coddomic = :TEMP_CODDOMIC ";
							DataCommand command18 = new DataCommand(sql18);
							//Setting query parameters
							command18.addParameter("TEMP_CODDOMIC", getFormModel().getTemp().getCoddomic());
							ResultSet results18 = command18.executeQuery();
							rowCount = command18.getRowCount();
							if ( results18.hasData() ) {
								wResultado.val = results18.getStr(0);
							}
							results18.close();
						}
						catch(NoDataFoundException e)
						{
						}
					}
					else if ( wMarcador.equals("CV_H1C048") ) {
						try
						{
							String sql19 = "SELECT NVL(pueviapu, NULL) " +
	" FROM su_domici " +
	" WHERE coddomic = :TEMP_CODDOMIC ";
							DataCommand command19 = new DataCommand(sql19);
							//Setting query parameters
							command19.addParameter("TEMP_CODDOMIC", getFormModel().getTemp().getCoddomic());
							ResultSet results19 = command19.executeQuery();
							rowCount = command19.getRowCount();
							if ( results19.hasData() ) {
								wResultado.val = results19.getStr(0);
							}
							results19.close();
						}
						catch(NoDataFoundException e)
						{
						}
					}
					else if ( wMarcador.equals("CV_H1C049") ) {
						try
						{
							String sql20 = "SELECT mn.desmunic " +
	" FROM su_domici dm, su_munici mn " +
	" WHERE dm.codpaise = mn.provin_codpaise AND dm.codprovi = mn.provin_codprovi AND dm.codmunic = mn.codmunic AND dm.coddomic = :TEMP_CODDOMIC ";
							DataCommand command20 = new DataCommand(sql20);
							//Setting query parameters
							command20.addParameter("TEMP_CODDOMIC", getFormModel().getTemp().getCoddomic());
							ResultSet results20 = command20.executeQuery();
							rowCount = command20.getRowCount();
							if ( results20.hasData() ) {
								wResultado.val = results20.getStr(0);
							}
							results20.close();
						}
						catch(NoDataFoundException e)
						{
						}
					}
					else if ( wMarcador.equals("CV_H1C050") ) {
						try
						{
							String sql21 = "SELECT pr.desprovi " +
	" FROM su_domici dm, su_munici mn, su_provin pr " +
	" WHERE dm.codpaise = mn.provin_codpaise AND dm.codprovi = mn.provin_codprovi AND dm.codmunic = mn.codmunic AND dm.coddomic = :TEMP_CODDOMIC AND pr.paises_codpaise = mn.provin_codpaise AND pr.codprovi = mn.provin_codprovi ";
							DataCommand command21 = new DataCommand(sql21);
							//Setting query parameters
							command21.addParameter("TEMP_CODDOMIC", getFormModel().getTemp().getCoddomic());
							ResultSet results21 = command21.executeQuery();
							rowCount = command21.getRowCount();
							if ( results21.hasData() ) {
								wResultado.val = results21.getStr(0);
							}
							results21.close();
						}
						catch(NoDataFoundException e)
						{
						}
					}
					else if ( wMarcador.equals("CV_H1C051") ) {
						try
						{
							String sql22 = "SELECT NVL(codposta, NULL) " +
	" FROM su_domici " +
	" WHERE coddomic = :TEMP_CODDOMIC ";
							DataCommand command22 = new DataCommand(sql22);
							//Setting query parameters
							command22.addParameter("TEMP_CODDOMIC", getFormModel().getTemp().getCoddomic());
							ResultSet results22 = command22.executeQuery();
							rowCount = command22.getRowCount();
							if ( results22.hasData() ) {
								wResultado.val = results22.getStr(0);
							}
							results22.close();
						}
						catch(NoDataFoundException e)
						{
						}
					}
				}
				// ----------------------------------------------------------------------------------
				//  DOCUMENTO 0472
				// ----------------------------------------------------------------------------------
				if ( wCodmodel.equals("047") && K000810.fexisver(wCodmodel, wNumvermo).getValue() )
				{
					//  Fecha de vencimiento de la liquidación 08/08/2002
					if ( wMarcador.equals("CV_H1C031") )
					{
						//  OBLIGATORIA SI SU_LIQUID.VIAGENLI = 'C' Y PARA CIERTOS CONCEPTOS.
						String sql23 = "SELECT viagenli " +
	" FROM su_liquid " +
	" WHERE docuni_codmodel = :TEMP_CODMODEL AND docuni_numvermo = :TEMP_NUMVERMO AND docuni_numerdoc = :TEMP_NUMERDOC ";
						DataCommand command23 = new DataCommand(sql23);
						//Setting query parameters
						command23.addParameter("TEMP_CODMODEL", getFormModel().getTemp().getCodmodel());
						command23.addParameter("TEMP_NUMVERMO", getFormModel().getTemp().getNumvermo());
						command23.addParameter("TEMP_NUMERDOC", getFormModel().getTemp().getNumerdoc());
						ResultSet results23 = command23.executeQuery();
						rowCount = command23.getRowCount();
						if ( results23.hasData() ) {
							wViagenli = results23.getStr(0);
						}
						results23.close();
						if ( wViagenli.notEquals("C") )
						{
							//  mensajito 'VIA DE GENERACION INCORRECTA'
							mostrarMensaje(toStr("SUR-01949"), toStr("E"), toBool(NBool.True));
						}
						wConceptosGenericos = Kliquida.fobtparl(toStr("PCONGENE"), getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getNumvermo(), toStr("****"), StoredProcedures.fsysdate(), toStr(null), toStr(null), toStr(null), toStr(null), toStr(null), toStr(null), toStr(null), toStr(null), toStr(null), toStr(null), toNumber(null), toNumber(null), getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getNumerdoc(), toNumber(getFormModel().getTemp().getNumvermo()));
						if ( inStrNullable(wConceptosGenericos, wH1c004).notEquals(0) )
						{
							if ( ltrim(rtrim(wH1c031))== null )
							{
								//  "FECHA OBLIGATORIA"
								mostrarMensaje(toStr("SUR-01950"), toStr("E"), toBool(NBool.True));
							}
							else {
								//  VALIDAR LA FECHA: MENOR QUE FSYSDATE Y PARA FESTIVOS
								if ( toDate(wH1c031, "DD/MM/YYYY").lesser(trunc(StoredProcedures.fsysdate())) )
								{
									//  MENSAJITO FECHA NO PUEDE SER INFERIOR AL DÍA
									mostrarMensaje(toStr("SUR-01951"), toStr("E"), toBool(NBool.True));
								}
								else {
									wFecha031 = StoredProcedures.ffecobls(wH1c019, toNumber(0), toDate(wH1c031, "DD/MM/YYYY"));
									if ( toDate(wH1c031, "DD/MM/YYYY").notEquals(trunc(wFecha031)) )
									{
										//  MENSAJITO CON 'FECHA NO VALIDA POR SER FESTIVO Y OFRECER LA FECHA W_FECHA31'
										mostrarMensaje(toStr("SUR-02143 #1").append(wFecha031), toStr("E"), toBool(NBool.True));
									}
									else {
										try
										{
											String sql24 = "UPDATE su_liquid " +
	"SET fecvenci = to_date(:P_W_H1C031, 'DD/MM/YYYY') " +
	" WHERE docuni_codmodel = :TEMP_CODMODEL AND docuni_numvermo = :TEMP_NUMVERMO AND docuni_numerdoc = :TEMP_NUMERDOC";
											DataCommand command24 = new DataCommand(sql24);
											//Setting query parameters
											command24.addParameter("P_W_H1C031", wH1c031);
											command24.addParameter("TEMP_CODMODEL", getFormModel().getTemp().getCodmodel());
											command24.addParameter("TEMP_NUMVERMO", getFormModel().getTemp().getNumvermo());
											command24.addParameter("TEMP_NUMERDOC", getFormModel().getTemp().getNumerdoc());
											rowCount = command24.execute();
										}
										catch(Exception  e)
										{
										}
									}
								}
							}
						}
						wResultado.val = wH1c031;
					}
					//  Plazo de pago
					if ( wMarcador.equals("PLAZPAGO") )
					{
						if ( ltrim(rtrim(wPlazpago))!= null && ltrim(rtrim(wH1c031))!= null )
						{
							wResultado.val = wPlazpago;
						}
						else if ( ltrim(rtrim(wPlazpago))== null && ltrim(rtrim(wH1c031))!= null ) {
							mostrarMensaje(toStr("SUR-01944"), toStr("E"), toBool(NBool.True));
						}
						else if ( ltrim(rtrim(wPlazpago))== null && ltrim(rtrim(wH1c031))== null ) {
							wResultado.val = toStr("Articulos 148.1,98 15 y 152.2 de la Ley 4/1998 de Tasas y Precios Públicos");
						}
						else if ( ltrim(rtrim(wPlazpago))!= null && ltrim(rtrim(wH1c031))== null ) {
							wResultado.val = wPlazpago;
						}
					}
					//  Fecha Accidente 
					if ( wMarcador.equals("FECACCIDE") )
					{
						if ( toDate(wFecaccide, "DD/MM/YYYY").greater(trunc(StoredProcedures.fsysdate())) )
						{
							//  MENSAJITO 'LA FECHA DEL ACCIDENTE NO PUEDE SER SUPERIOR A LA FECHA DEL SISTEMA'
							mostrarMensaje(toStr("SUR-01952"), toStr("E"), toBool(NBool.True));
						}
						wResultado.val = wFecaccide;
					}
				}
				// ----------------------------------------------------------------------------------
				//  DOCUMENTO 0162
				// ----------------------------------------------------------------------------------
				if ( wCodmodel.equals("016") && K000810.fexisver(wCodmodel, wNumvermo).getValue() )
				{
					if ( wMarcador.equals("REC_SSCC") )
					{
						if ( wForm20.equals("Sí") )
						{
							wResultado.val = toStr(null);
						}
						else if ( wForm20.isNull() ) {
							wResultado.val = wRecSscc;
						}
						else {
							if ( wRecSscc.isNotNull() )
							{
								wResultado.val = wRecSscc;
							}
							else {
								mostrarMensaje(toStr("SUR-02511"), toStr("E"), toBool(NBool.True));
							}
						}
					}
				}
				}finally{
					cArticulo.close();
					cGrado.close();
					cCalifica.close();
					cDescgrado.close();
				}
		}

	
	/* Original PL/SQL code for Prog Unit CREA_PDF
	
	PROCEDURE crea_pdf( p_modelo IN VARCHAR2, p_version   IN VARCHAR2, p_documento IN VARCHAR2 
                  , p_accion IN VARCHAR2, p_plantilla IN OUT  VARCHAR2, p_estado OUT PLS_INTEGER)
IS
    v_url                VARCHAR2(25000);
    v_servicio           VARCHAR2(80);
    v_ejemplar           VARCHAR2(1000);
    r_respuesta          kgenrep.tr_retorno;
    v_tabla_parametros   kintcomu.ta_tabla;
    e_carga_temporal     EXCEPTION;
    e_borra_temporal     EXCEPTION;
    e_documento          EXCEPTION;	  
   	v_idopcion           VARCHAR2(2);
BEGIN

    IF   p_modelo IS NULL 
    	OR p_version IS NULL
    	OR p_documento IS NULL 
    THEN
        RAISE e_documento;
    END IF;
    
  
    :temp.do_commit := 'S';
    kgenrep.carga_temporal(r_respuesta, :temp.do_commit, p_modelo, p_version, p_documento, p_plantilla);
    :temp.do_commit := 'N';

    IF NVL(r_respuesta.codigo, 0) <> 0 THEN
          RAISE e_carga_temporal;
    END IF;
    
    -- AJUSTAR TIEMPOS DE EJECUCION CON EL SERVICIO WEB (FUNDAMENTAL NO BORRAR NI CAMBIAR)
	  SYNCHRONIZE;
	  	  	      
    -- v_ejemplar es el valor que se le pasa para obtener el ejemplar que queremos o Todo
    -- inicialmente vamos a indicarle que muestre todo el documento.

    v_ejemplar := 'Todo'; 
    K000810.POBTAPAR(p_modelo, p_version, p_documento, FALSE, NULL, v_ejemplar, v_tabla_parametros, v_servicio);
        
    v_url := kintcomu.fobturle(v_servicio, v_tabla_parametros, NULL);   



    v_idopcion := '10'; 
    ejecuta_pdf(p_modelo, p_version, p_documento, v_idopcion, p_accion, p_estado);
   
    IF NVL(r_respuesta.codigo, 0) <> 0 THEN
        RAISE e_borra_temporal;
    END IF;
EXCEPTION      
    WHEN e_carga_temporal THEN
        :global.ret_810 := '10'; 
        mostrar_mensaje('SUR-02004 #1' || ' Error en Kgenrep.carga_temporal #2 ' || 
                          r_respuesta.codigo || ' ' || r_respuesta.texto, 'E', TRUE);
    WHEN e_borra_temporal THEN
        :global.ret_810 := '10'; 
        mostrar_mensaje('SUR-02004 #1' || ' Error en Kgenrep.borra_temporal #2 ' || 
                          r_respuesta.codigo || ' ' || r_respuesta.texto, 'E', TRUE);   
    WHEN e_documento THEN
        :global.ret_810 := '10'; 
        mostrar_mensaje('SUR-02004 #1' || ' Error al crear el pdf, es necesario el documento origen. ', 'E', TRUE);                                     
END;
	*/
	//ID:384
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		* @param pModelo
		* @param pVersion
		* @param pDocumento
		* @param pAccion
		* @param pPlantilla
		* @param pEstado
		*/
		public void creaPdf(NString pModelo, NString pVersion, NString pDocumento, NString pAccion, Ref<NString> pPlantilla, Ref<NInteger> pEstado)
		{
			NString vUrl = NString.getNull();
			NString vServicio = NString.getNull();
			NString vEjemplar = NString.getNull();
			Kgenrep.TrRetornoRow rRespuesta = new Kgenrep.TrRetornoRow();
			Kintcomu.TaTabla vTablaParametros = new Kintcomu.TaTabla();
			NString vIdopcion = NString.getNull();
			try
			{
				if ( pModelo.isNull() || pVersion.isNull() || pDocumento.isNull() )
				{
					throw new EDocumento();
				}
				getFormModel().getTemp().setDoCommit(toStr("S"));
				Ref<Kgenrep.TrRetornoRow> r_retorno_ref = new Ref<Kgenrep.TrRetornoRow>(rRespuesta);
				Kgenrep.cargaTemporal(r_retorno_ref, getFormModel().getTemp().getDoCommit(), pModelo, pVersion, pDocumento, pPlantilla);
				rRespuesta = r_retorno_ref.val;
				getFormModel().getTemp().setDoCommit(toStr("N"));
				if ( isNull(rRespuesta.codigo, 0).notEquals(0) )
				{
					throw new ECargaTemporal();
				}
				//  AJUSTAR TIEMPOS DE EJECUCION CON EL SERVICIO WEB (FUNDAMENTAL NO BORRAR NI CAMBIAR)
				synchronize();
				//  v_ejemplar es el valor que se le pasa para obtener el ejemplar que queremos o Todo
				//  inicialmente vamos a indicarle que muestre todo el documento.
				vEjemplar = toStr("Todo");
				Ref<Kintcomu.TaTabla> p_tabla_ref = new Ref<Kintcomu.TaTabla>(vTablaParametros);
				Ref<NString> p_servicio_ref = new Ref<NString>(vServicio);
				K000810.pobtapar(pModelo, pVersion, pDocumento, toBool(NBool.False), NString.getNull(), vEjemplar, p_tabla_ref, p_servicio_ref);
				vTablaParametros = p_tabla_ref.val;
				vServicio = p_servicio_ref.val;
				vUrl = Kintcomu.fobturle(vServicio, vTablaParametros, NString.getNull());
				vIdopcion = toStr("10");
				ejecutaPdf(pModelo, pVersion, pDocumento, vIdopcion, pAccion, pEstado);
				if ( isNull(rRespuesta.codigo, 0).notEquals(0) )
				{
					throw new EBorraTemporal();










				}
			}
			catch(ECargaTemporal e)
			{
				setGlobal("RET_810", toStr("10"));
				mostrarMensaje(toStr("SUR-02004 #1").append(" Error en Kgenrep.carga_temporal #2 ").append(rRespuesta.codigo).append(" ").append(rRespuesta.texto), toStr("E"), toBool(NBool.True));

			}
			catch(EBorraTemporal e)
			{
				setGlobal("RET_810", toStr("10"));
				mostrarMensaje(toStr("SUR-02004 #1").append(" Error en Kgenrep.borra_temporal #2 ").append(rRespuesta.codigo).append(" ").append(rRespuesta.texto), toStr("E"), toBool(NBool.True));
			}
			catch(EDocumento e)
			{
				setGlobal("RET_810", toStr("10"));
				mostrarMensaje(toStr("SUR-02004 #1").append(" Error al crear el pdf, es necesario el documento origen. "), toStr("E"), toBool(NBool.True));

			}
		}

	
	/* Original PL/SQL code for Prog Unit EJECUTA_PDF
	
	PROCEDURE EJECUTA_PDF(p_codmodel IN su_modelo.codmodel%TYPE, 
                      p_numvermo IN su_vermod.numvermo%TYPE,
                      p_numerdoc IN su_docuni.numerdoc%TYPE,
                      p_idopcion IN VARCHAR2,
                      p_vista    IN VARCHAR2, 
                      p_estado  OUT PLS_INTEGER )
 IS
    v_codigo   pls_integer;
    v_salida   VARCHAR2(10000);  
    v_retorno  BOOLEAN;
    v_ruta     VARCHAR2(32767);  
    v_resultado NUMBER;
    v_servicio  VARCHAR2(500);
    v_url  VARCHAR2(500);
    v_txterror VARCHAR2(500);
   
   
BEGIN
    
    IF p_vista = 'PREVIEW' THEN
        v_retorno := mipvisorweb(p_codmodel, p_numvermo, p_numerdoc, p_idopcion);
	  ELSE		   	
        
        v_resultado := KVISORDOC.FURLVISOR(p_codmodel, p_numvermo, p_numerdoc, p_idopcion, v_servicio, v_url, v_txterror) ;
        
        IF v_resultado = 0 AND v_url IS NOT NULL THEN 
        --p_estado := fcallhttp(p_ruta);
        PCALLHTTP(v_url, v_codigo, v_salida);
       
        --Indico al estado el valor devuelto de la petición htttp.
        p_estado:= v_codigo;

        IF v_codigo != 200 THEN
            :global.ret_810 := '10'; 
            IF v_codigo BETWEEN 300 AND 399 THEN                 
                 mostrar_mensaje('SUR-02000 #1'|| 'Redirección de la petición #2 ' ,'E',TRUE);                                                                               	        	
            ELSIF v_codigo BETWEEN 400 AND 499 THEN
                 mostrar_mensaje('SUR-02000 #1'|| 'Código de error en el cliente. #2 ' ,'E',TRUE);                                                                               	        	                 
            ELSIF v_codigo BETWEEN 500 AND 510 THEN
            	   mostrar_mensaje('SUR-02000 #1'|| 'Código de error en el servidor. #2 ' ,'E',TRUE);                                                                               	        	                 
            ELSIF v_codigo = 511 THEN
		            mostrar_mensaje('SUR-02000 #1'|| 'Error al leer los temporales o alguno de los campos obligatorios de cabecera está vacío #2 ' ,'E',TRUE);                                                                               	        	
            ELSIF v_codigo = 512 THEN
		            mostrar_mensaje('SUR-02000 #1'|| 'Error al generar el pdf (FOP)#2 ' ,'E',TRUE);                                                                               	        	
            ELSIF v_codigo = 513 THEN
		            mostrar_mensaje('SUR-02000 #1'|| 'Error TDIN en los campos de la tabla de temporales #2 ' ,'E',TRUE);                                                                               	        	
            ELSIF v_codigo = 514 THEN
		            mostrar_mensaje('SUR-02000 #1'|| 'El fichero pdf no se ha podido almacenar en la Base de Datos #2 ' ,'E',TRUE);                                                                               	        	
            ELSE
                    mostrar_mensaje('SUR-02000 #1'|| 'Error. Se ha producido un error en PCALLHTTP. #2 ' ,'E',TRUE);                                                                               	                                                                                      		
                END IF; 
            END IF;   
        ELSE
            :global.ret_810 := '10'; 
            mostrar_mensaje('SUR-02000 #1'|| 'Error. No se ha obtenido una dirección URL #2 ' ,'E',TRUE);                
        END IF ;                       
    END IF; 
EXCEPTION
    WHEN sys.utl_http.init_failed THEN
        :global.ret_810 := '10'; 
	      mostrar_mensaje('SUR-02000 #1'|| 'Error. No se puede conectar con el servidor de aplicaciones. #2 ' , 'E', TRUE);                                 
    WHEN sys.utl_http.request_failed THEN
        :global.ret_810 := '10'; 
	     	mostrar_mensaje('SUR-02000 #1'|| 'Error. La url formada es inválida. #2 ' ,'E',TRUE);                                                                               	
    WHEN sys.utl_http.transfer_timeout THEN
        :global.ret_810 := '10'; 
        mostrar_mensaje('SUR-02000 #1'|| 'Error. El tiempo de la petición ha expirado #2 ' ,'E',TRUE);
    WHEN sys.utl_http.http_client_error THEN
        :global.ret_810 := '10'; 
        mostrar_mensaje('SUR-02000 #1'|| 'Error. Se ha producido un error en el cliente. #2 ' ,'E',TRUE);                                                                               	
    WHEN sys.utl_http.http_server_error THEN       
        IF v_codigo BETWEEN 511 AND 514 THEN 
            :global.ret_810 := '10'; 
            IF v_codigo = 511 then
		            mostrar_mensaje('SUR-02000 #1'|| 'Error al leer los temporales o alguno de los campos obligatorios de cabecera está vacío #2 ' ,'E',TRUE);                                                                               	        	
            ELSIF v_codigo = 512 THEN
		            mostrar_mensaje('SUR-02000 #1'|| 'Error al generar el pdf (FOP)#2 ' ,'E',TRUE);                                                                               	        	
            ELSIF v_codigo = 513 THEN
		            mostrar_mensaje('SUR-02000 #1'|| 'Error TDIN en los campos de la tabla de temporales #2 ' ,'E',TRUE);                                                                               	        	
            ELSIF v_codigo = 514 THEN
		            mostrar_mensaje('SUR-02000 #1'|| 'El fichero pdf no se ha podido almacenar en la Base de Datos #2 ' ,'E',TRUE);                                                                               	        	
            END IF;
        ELSE
            :global.ret_810 := '10'; 
            mostrar_mensaje('SUR-02000 #1'|| 'Error. Se ha producido un error en el servidor. #2 ' ,'E',TRUE);                                                                               	                                                                                      	
        END IF;
    WHEN OTHERS THEN    
            :global.ret_810 := '10';	     	
		        mostrar_mensaje('SUR-02000 #1'|| 'Error. Se ha producido un error en PCALLHTTP. #2 ' ,'E',TRUE);                                                                               			    		    
END;
	*/
	//ID:385
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		* @param pCodmodel
		* @param pNumvermo
		* @param pNumerdoc
		* @param pIdopcion
		* @param pVista
		* @param pEstado
		*/
		public void ejecutaPdf(NString pCodmodel, NString pNumvermo, NString pNumerdoc, NString pIdopcion, NString pVista, Ref<NInteger> pEstado)
		{
			Ref<NInteger> vCodigo = new Ref<NInteger>(NInteger.getNull());
			Ref<NString> vSalida = new Ref<NString>(NString.getNull());
			NBool vRetorno = NBool.getNull();
			NString vRuta = NString.getNull();
			NNumber vResultado = NNumber.getNull();
			NString vServicio = NString.getNull();
			NString vUrl = NString.getNull();
			NString vTxterror = NString.getNull();
			try
			{
				if ( pVista.equals("PREVIEW") )
				{
					vRetorno = mipvisorweb(toStr(pCodmodel), toStr(pNumvermo), pNumerdoc, pIdopcion);
				}
				else {
					Ref<NString> p_servicio_ref = new Ref<NString>(vServicio);
					Ref<NString> p_url_ref = new Ref<NString>(vUrl);
					Ref<NString> p_txterror_ref = new Ref<NString>(vTxterror);
					vResultado = Kvisordoc.furlvisor(pCodmodel, pNumvermo, pNumerdoc, pIdopcion, p_servicio_ref, p_url_ref, p_txterror_ref);
					vServicio = p_servicio_ref.val;
					vUrl = p_url_ref.val;
					vTxterror = p_txterror_ref.val;
					if ( vResultado.equals(0) && vUrl.isNotNull() )
					{
						// p_estado := fcallhttp(p_ruta);
						StoredProcedures.pCallHttp(vUrl, vCodigo, vSalida);
						// Indico al estado el valor devuelto de la petición htttp.
						pEstado.val = vCodigo.val;
						if ( vCodigo.val.notEquals(200) )
						{
							setGlobal("RET_810", toStr("10"));
							if ( between(vCodigo.val, 300, 399) )
							{
								mostrarMensaje(toStr("SUR-02000 #1").append("Redirección de la petición #2 "), toStr("E"), toBool(NBool.True));
							}
							else if ( between(vCodigo.val, 400, 499) ) {
								mostrarMensaje(toStr("SUR-02000 #1").append("Código de error en el cliente. #2 "), toStr("E"), toBool(NBool.True));
							}
							else if ( between(vCodigo.val, 500, 510) ) {
								mostrarMensaje(toStr("SUR-02000 #1").append("Código de error en el servidor. #2 "), toStr("E"), toBool(NBool.True));
							}
							else if ( vCodigo.equals(511) ) {
								mostrarMensaje(toStr("SUR-02000 #1").append("Error al leer los temporales o alguno de los campos obligatorios de cabecera está vacío #2 "), toStr("E"), toBool(NBool.True));
							}
							else if ( vCodigo.equals(512) ) {
								mostrarMensaje(toStr("SUR-02000 #1").append("Error al generar el pdf (FOP)#2 "), toStr("E"), toBool(NBool.True));
							}
							else if ( vCodigo.equals(513) ) {
								mostrarMensaje(toStr("SUR-02000 #1").append("Error TDIN en los campos de la tabla de temporales #2 "), toStr("E"), toBool(NBool.True));
							}
							else if ( vCodigo.equals(514) ) {
								mostrarMensaje(toStr("SUR-02000 #1").append("El fichero pdf no se ha podido almacenar en la Base de Datos #2 "), toStr("E"), toBool(NBool.True));
							}
							else {
								mostrarMensaje(toStr("SUR-02000 #1").append("Error. Se ha producido un error en PCALLHTTP. #2 "), toStr("E"), toBool(NBool.True));
							}
						}
					}
					else {
						setGlobal("RET_810", toStr("10"));
						mostrarMensaje(toStr("SUR-02000 #1").append("Error. No se ha obtenido una dirección URL #2 "), toStr("E"), toBool(NBool.True));
					}
				}
			}
			catch (DataLayerException e) {
                setGlobal("RET_810", toStr("10"));
                if(errorCode().equals(toInt(-20000))) {
                    
                    if(errorMessage().contains("Error. Se ha producido un error al conectar con el sistema")) {
                        mostrarMensaje(toStr("SUR-02000 #1").append("Error. No se puede conectar con el servidor de aplicaciones. #2 "), toStr("E"), toBool(NBool.True));
                    } else if(errorMessage().contains("Error. Existe un error en la url o en los argumentos pasados")) {
                        mostrarMensaje(toStr("SUR-02000 #1").append("Error. La url formada es inválida. #2 "), toStr("E"), toBool(NBool.True));
                    }else if(errorMessage().contains("Error. El tiempo de la peticion ha expirado")) {
                        mostrarMensaje(toStr("SUR-02000 #1").append("Error. El tiempo de la petición ha expirado #2 "), toStr("E"), toBool(NBool.True));
                    }else if(errorMessage().contains("Error. Se ha producido un error en el cliente")) {
                        mostrarMensaje(toStr("SUR-02000 #1").append("Error. Se ha producido un error en el cliente. #2 "), toStr("E"), toBool(NBool.True));
                    }else if(errorMessage().contains("Error. Se ha producido un error en el servidor")) {
                        if ( between(vCodigo.val, 511, 514) )
                        {
                            setGlobal("RET_810", toStr("10"));
                            if ( vCodigo.val.equals(511) )
                            {
                                mostrarMensaje(toStr("SUR-02000 #1").append("Error al leer los temporales o alguno de los campos obligatorios de cabecera está vacío #2 "), 
                                        toStr("E"), toBool(NBool.True));
                            }
                            else if ( vCodigo.val.equals(512) ) {
                                mostrarMensaje(toStr("SUR-02000 #1").append("Error al generar el pdf (FOP)#2 "), toStr("E"), toBool(NBool.True));
                            }
                            else if ( vCodigo.val.equals(513) ) {
                                mostrarMensaje(toStr("SUR-02000 #1").append("Error TDIN en los campos de la tabla de temporales #2 "), toStr("E"), toBool(NBool.True));
                            }
                            else if ( vCodigo.val.equals(514) ) {
                                mostrarMensaje(toStr("SUR-02000 #1").append("El fichero pdf no se ha podido almacenar en la Base de Datos #2 "), toStr("E"), toBool(NBool.True));
                            }
                        }
                        else {
                            setGlobal("RET_810", toStr("10"));
                            mostrarMensaje(toStr("SUR-02000 #1").append("Error. Se ha producido un error en el servidor. #2 "), toStr("E"), toBool(NBool.True));
                        }
                    }else {
                        mostrarMensaje(toStr("SUR-02000 #1").append("Error. Se ha producido un error en PCALLHTTP. #2 "), toStr("E"), toBool(NBool.True));
                    }
                }
            }
		}

	
	/* Original PL/SQL code for Prog Unit LANZA_PDF_2
	
	FUNCTION lanza_pdf_2(p_modelo IN VARCHAR2, p_version IN VARCHAR2, p_numero IN VARCHAR2, p_operacion IN VARCHAR2)
RETURN BOOLEAN 
IS
    v_ejemplares       VARCHAR2(1000);
    v_accion           VARCHAR2(3);
    v_previsualizar    BOOLEAN;
    v_idopcion         VARCHAR2(2) ; 
BEGIN
    -- v_ejemplar es el valor que se le pasa para obtener el ejemplar que queremos o Todo
    -- inicialmente vamos a indicarle que muestre todo el documento.
    configura_impresion(v_ejemplares, v_accion); 


    IF v_ejemplares IS NULL AND v_accion IS NULL THEN
        -- Nos aseguramos que vengan con valor.
        v_idopcion := '11';
    ELSIF :temp.v_097 IS NOT NULL AND p_modelo = '097' THEN 
        -- Para los documentos 097 de rec. extemp. se
        -- manda el documento completo.
        v_ejemplares := 'Todo';
    END IF;
    
    IF v_idopcion IS NULL THEN 
        -- Añadir a la tabla pl "a_param_servicio" del paquete kvisordoc una nueva fila.
        -- Esta nueva fila es 'Ejemplares = a los marcados por el usuario'
        
        KVISORDOC.PSETPARAM('Ejemplares', v_ejemplares) ;
        IF v_accion = 'ID1' THEN  -- Impresión a Doble cara
            v_idopcion := '20';	
        ELSIF v_accion = 'I1' THEN  -- Impresión Simpre
            v_idopcion := '21';	    
        END IF ;    
        
    END IF ;
    
    -- Levanta el navegador para visualizar el PDF.  
    IF mipvisorweb(p_modelo, p_version, p_numero, v_idopcion) THEN 
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF ;        

EXCEPTION
    WHEN OTHERS THEN
        RETURN FALSE;
END;











	*/
	//ID:386
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this function was identified as containing business logic. See documentation for details.
/* </p>
		* @param pModelo
		* @param pVersion
		* @param pNumero
		* @param pOperacion
		*/
		public NBool lanzaPdf2(EjemplaresAdapter ejemplaresElement, NString pModelo, NString pVersion, NString pNumero, NString pOperacion)
		{
			NString vEjemplares = NString.getNull();
			NString vAccion = NString.getNull();
			NBool vPrevisualizar = NBool.getNull();
			NString vIdopcion = NString.getNull();
			try
			{
				//  v_ejemplar es el valor que se le pasa para obtener el ejemplar que queremos o Todo
				//  inicialmente vamos a indicarle que muestre todo el documento.
				Ref<NString> pEjemplar_ref = new Ref<NString>(vEjemplares);
				Ref<NString> pModo_ref = new Ref<NString>(vAccion);
				configuraImpresion(ejemplaresElement, pEjemplar_ref, pModo_ref);
				vEjemplares = pEjemplar_ref.val;
				vAccion = pModo_ref.val;
				if ( vEjemplares.isNull() && vAccion.isNull() )
				{
					//  Nos aseguramos que vengan con valor.
					vIdopcion = toStr("11");
				}
				else if ( getFormModel().getTemp().getV097().isNotNull() && pModelo.equals("097") ) {
					//  Para los documentos 097 de rec. extemp. se
					//  manda el documento completo.
					vEjemplares = toStr("Todo");
				}
				if ( vIdopcion.isNull() )
				{
					//  Añadir a la tabla pl "a_param_servicio" del paquete kvisordoc una nueva fila.
					//  Esta nueva fila es 'Ejemplares = a los marcados por el usuario'
					Kvisordoc.psetparam(toStr("Ejemplares"), vEjemplares);
					if ( vAccion.equals("ID1") )
					{
						//  Impresión a Doble cara
						vIdopcion = toStr("20");
					}
					else if ( vAccion.equals("I1") ) {
						//  Impresión Simpre
						vIdopcion = toStr("21");









					}
				}
				//  Levanta el navegador para visualizar el PDF.  
				if ( mipvisorweb(pModelo, pVersion, pNumero, vIdopcion).getValue() )
				{
					return  toBool( toBool(NBool.True));
				}
				else {
					return  toBool( toBool(NBool.False));
				}
			}
			catch(Exception  e)
			{
				return  toBool( toBool(NBool.False));
			}
		}

	
	/* Original PL/SQL code for Prog Unit COMPRUEBA_CODTER
	
	PROCEDURE COMPRUEBA_CODTER IS
    v_sigvia_codviapu  su_codter.sigvia_codviapu%TYPE;
    v_denviapu         su_codter.denviapu%TYPE;
    v_numviapu         su_codter.numviapu%TYPE;
    v_letviapu         su_codter.letviapu%TYPE;
    v_escviapu         su_codter.escviapu%TYPE;
    v_plaviapu         su_codter.plaviapu%TYPE;
    v_pueviapu         su_codter.pueviapu%TYPE;
    v_codposta         su_codter.codposta%TYPE;
    v_munici_codmunic  su_codter.munici_codmunic%TYPE;
    v_munici_codprovi  su_codter.munici_codprovi%TYPE;
    v_munici_codpaise  su_codter.munici_codpaise%TYPE;
    v_numteldo         su_codter.numteldo%TYPE;
    v_numfaxdo         su_codter.numfaxdo%TYPE;
    v_desterri         su_codter.desterri%TYPE;
    v_desterr2         su_codter.desterr2%TYPE;
    v_codterri         su_codter.codterri%TYPE;
    v_mensaje_error    VARCHAR2(100);
    i                  BINARY_INTEGER := 1;
    v_encontrado       BOOLEAN;
BEGIN

     go_block('marcador');
     first_record;
     v_encontrado := FALSE;
     LOOP
     IF :marcador.marcador = 'H1C019' THEN
         v_codterri := :marcador.valor;
         v_encontrado := TRUE;
     END IF;   
         EXIT WHEN v_encontrado = TRUE;
         next_record;
         i := i + 1;
       END LOOP;
       first_record;

    SELECT sigvia_codviapu, denviapu, numviapu, letviapu, escviapu,plaviapu
         , pueviapu,codposta, munici_codmunic, munici_codprovi, munici_codpaise
         , numteldo, numfaxdo,desterri,desterr2
      INTO v_sigvia_codviapu, v_denviapu, v_numviapu, v_letviapu, v_escviapu
         , v_plaviapu, v_pueviapu, v_codposta, v_munici_codmunic, v_munici_codprovi
         , v_munici_codpaise, v_numteldo, v_numfaxdo, v_desterri, v_desterr2
      FROM su_codter
     WHERE codterri = v_codterri;
    

    -- Valida que los datos obligatorio de la cabecera vienen rellenos.
    IF v_sigvia_codviapu IS NULL   THEN
        v_mensaje_error := 'Sigla de la vía pública';
        mostrar_mensaje('SUR-02172 #1'||v_mensaje_error ,'E',TRUE);
    ELSIF v_denviapu IS NULL THEN
        v_mensaje_error := 'Nombre de la vía pública';
        mostrar_mensaje('SUR-02172 #1'||v_mensaje_error ,'E',TRUE);
    ELSIF v_codposta IS NULL THEN
        v_mensaje_error := 'Código postal';
        mostrar_mensaje('SUR-02172 #1'||v_mensaje_error ,'E',TRUE); 
    ELSIF v_munici_codmunic IS NULL THEN
        v_mensaje_error := 'Municipio';
        mostrar_mensaje('SUR-02172 #1'||v_mensaje_error ,'E',TRUE);
    ELSIF v_munici_codprovi IS NULL THEN
        v_mensaje_error := 'Provincia';
        mostrar_mensaje('SUR-02172 #1'||v_mensaje_error ,'E',TRUE);
    ELSIF v_munici_codpaise IS NULL THEN
        v_mensaje_error := 'País';
        mostrar_mensaje('SUR-02172 #1'||v_mensaje_error ,'E',TRUE);
    ELSIF v_desterri IS NULL THEN
        v_mensaje_error := 'Descripción órgano';
        mostrar_mensaje('SUR-02172 #1'||v_mensaje_error ,'E',TRUE);
    END IF;      
    

EXCEPTION
 WHEN NO_DATA_FOUND THEN
   NULL;
  
END;
	*/
	//ID:387
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		*/
		public void compruebaCodter(MarcadorAdapter marcadorElement)
		{
			int rowCount = 0;
			NString vSigviaCodviapu = NString.getNull();
			NString vDenviapu = NString.getNull();
			NNumber vNumviapu = NNumber.getNull();
			NString vLetviapu = NString.getNull();
			NString vEscviapu = NString.getNull();
			NString vPlaviapu = NString.getNull();
			NString vPueviapu = NString.getNull();
			NString vCodposta = NString.getNull();
			NString vMuniciCodmunic = NString.getNull();
			NString vMuniciCodprovi = NString.getNull();
			NString vMuniciCodpaise = NString.getNull();
			NString vNumteldo = NString.getNull();
			NString vNumfaxdo = NString.getNull();
			NString vDesterri = NString.getNull();
			NString vDesterr2 = NString.getNull();
			NString vCodterri = NString.getNull();
			NString vMensajeError = NString.getNull();
			NInteger i = toInt(1);
			NBool vEncontrado = NBool.getNull();
			try
			{
				goBlock(toStr("marcador"));
				firstRecord(true);
				vEncontrado = toBool(NBool.False);
				while (true) {
					if ( marcadorElement.getMarcador().equals("H1C019") )
					{
						vCodterri = marcadorElement.getValor();
						vEncontrado = toBool(NBool.True);
					}
					if ( vEncontrado.equals(NBool.True) ) 
						break;
					nextRecord();
					i = i.add(1);
				}
				firstRecord(true);
				String sql1 = "SELECT sigvia_codviapu, denviapu, numviapu, letviapu, escviapu, plaviapu, pueviapu, codposta, munici_codmunic, munici_codprovi, munici_codpaise, numteldo, numfaxdo, desterri, desterr2 " +
	" FROM su_codter " +
	" WHERE codterri = :P_V_CODTERRI ";
				DataCommand command1 = new DataCommand(sql1);
				//Setting query parameters
				command1.addParameter("P_V_CODTERRI", vCodterri);
				ResultSet results1 = command1.executeQuery();
				rowCount = command1.getRowCount();
				if ( results1.hasData() ) {
					vSigviaCodviapu = results1.getStr(0);
					vDenviapu = results1.getStr(1);
					vNumviapu = results1.getNumber(2);
					vLetviapu = results1.getStr(3);
					vEscviapu = results1.getStr(4);
					vPlaviapu = results1.getStr(5);
					vPueviapu = results1.getStr(6);
					vCodposta = results1.getStr(7);
					vMuniciCodmunic = results1.getStr(8);
					vMuniciCodprovi = results1.getStr(9);
					vMuniciCodpaise = results1.getStr(10);
					vNumteldo = results1.getStr(11);
					vNumfaxdo = results1.getStr(12);
					vDesterri = results1.getStr(13);
					vDesterr2 = results1.getStr(14);
				}
				results1.close();
				//  Valida que los datos obligatorio de la cabecera vienen rellenos.
				if ( vSigviaCodviapu.isNull() )
				{
					vMensajeError = toStr("Sigla de la vía pública");
					mostrarMensaje(toStr("SUR-02172 #1").append(vMensajeError), toStr("E"), toBool(NBool.True));
				}
				else if ( vDenviapu.isNull() ) {
					vMensajeError = toStr("Nombre de la vía pública");
					mostrarMensaje(toStr("SUR-02172 #1").append(vMensajeError), toStr("E"), toBool(NBool.True));



























				}
				else if ( vCodposta.isNull() ) {
					vMensajeError = toStr("Código postal");
					mostrarMensaje(toStr("SUR-02172 #1").append(vMensajeError), toStr("E"), toBool(NBool.True));








				}
				else if ( vMuniciCodmunic.isNull() ) {
					vMensajeError = toStr("Municipio");
					mostrarMensaje(toStr("SUR-02172 #1").append(vMensajeError), toStr("E"), toBool(NBool.True));

























































				}
				else if ( vMuniciCodprovi.isNull() ) {
					vMensajeError = toStr("Provincia");
					mostrarMensaje(toStr("SUR-02172 #1").append(vMensajeError), toStr("E"), toBool(NBool.True));




				}
				else if ( vMuniciCodpaise.isNull() ) {
					vMensajeError = toStr("País");
					mostrarMensaje(toStr("SUR-02172 #1").append(vMensajeError), toStr("E"), toBool(NBool.True));












				}
				else if ( vDesterri.isNull() ) {
					vMensajeError = toStr("Descripción órgano");
					mostrarMensaje(toStr("SUR-02172 #1").append(vMensajeError), toStr("E"), toBool(NBool.True));
















				}
			}
			catch(NoDataFoundException e)
			{




















			}
		}

	
	/* Original PL/SQL code for Prog Unit TRANSFIERE_FICHERO
	
	FUNCTION TRANSFIERE_FICHERO (v_fichero OUT VARCHAR2, v_error OUT NUMBER)
RETURN BOOLEAN 
IS
    v_ruta_cliente       VARCHAR2(2000);
--    v_rama_regedit       VARCHAR2(1000) := 'HKEY_CURRENT_USER\Environment';
--    v_variable_regedit   VARCHAR2(1000) := 'TEMP';
--    v_variable_regedit_2 VARCHAR2(1000) := 'TMP';
    v_clausula_where     VARCHAR2(1000);
    e_error              EXCEPTION;
    v_boolean            BOOLEAN:=TRUE;
    
BEGIN
   v_error := 0;    	
   BEGIN
       -- OBTINE RUTA DESTINO CLIENTE.
       v_ruta_cliente := client_win_api_environment.Get_Temp_Directory(v_boolean);
   EXCEPTION
       WHEN OTHERS THEN
           v_error := 1;
           RAISE e_error;
   END;
   BEGIN
      -- MOTAJE CLAUSULA WHERE
      v_clausula_where := 'docuni_codmodel='||chr(39)||:temp.codmodel||chr(39)||' and docuni_numvermo='
                   ||chr(39)||:temp.numvermo||chr(39)||' and docuni_numerdoc='||chr(39)||:temp.numerdoc||chr(39);
      -- REALIZA TRANSFERENCIA DEL FICEHRO
      v_fichero := v_ruta_cliente||'\'||:temp.codmodel||:temp.numvermo||:temp.numerdoc||'.pdf'; 
      IF webutil_file_transfer.db_to_client(v_fichero, 'SU_DOCPDF', 'DOCUPDFS', v_clausula_where) 
      THEN
         RETURN TRUE;
      ELSE
         RETURN FALSE;
      END IF;
   EXCEPTION 
      WHEN OTHERS THEN
          v_error := 2;
          RAISE e_error;
   END;   	  
EXCEPTION 
    WHEN e_error THEN
        RETURN FALSE;    	
END;
	*/
	//ID:388
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this function was identified as containing business logic. See documentation for details.
/* </p>
		* @param vFichero
		* @param vError
		*/
		public NBool transfiereFichero(Ref<NString> vFichero, Ref<NNumber> vError)
		{
			NString vRutaCliente = NString.getNull();
			//     v_rama_regedit       VARCHAR2(1000) := 'HKEY_CURRENT_USER\Environment';
			//     v_variable_regedit   VARCHAR2(1000) := 'TEMP';
			//     v_variable_regedit_2 VARCHAR2(1000) := 'TMP';
			NString vClausulaWhere = NString.getNull();
			NBool vBoolean = toBool(NBool.True);
			try
			{
				vError.val = toNumber(0);
				try
				{
					//  OBTINE RUTA DESTINO CLIENTE.
					vRutaCliente = getTask().getWebutil().getClientWinApiEnvironment().getTempDirectory(vBoolean);
				}
				catch(Exception  e)
				{
					vError.val = toNumber(1);
					throw e;
				}
				try
				{
					//  MOTAJE CLAUSULA WHERE
					vClausulaWhere = toStr("docuni_codmodel=").append(chr(39)).append(getFormModel().getTemp().getCodmodel()).append(chr(39)).append(" and docuni_numvermo=").append(chr(39)).append(getFormModel().getTemp().getNumvermo()).append(chr(39)).append(" and docuni_numerdoc=").append(chr(39)).append(getFormModel().getTemp().getNumerdoc()).append(chr(39));
					//  REALIZA TRANSFERENCIA DEL FICEHRO
					vFichero.val = vRutaCliente.append("\\").append(getFormModel().getTemp().getCodmodel()).append(getFormModel().getTemp().getNumvermo()).append(getFormModel().getTemp().getNumerdoc()).append(".pdf");
					if ( getTask().getWebutil().getWebutilFileTransfer().dbToClient(vFichero.val, toStr("SU_DOCPDF"), toStr("DOCUPDFS"), vClausulaWhere).getValue() )
					{
						return  toBool( toBool(NBool.True));
					}
					else {
						return  toBool( toBool(NBool.False));






































					}
				}
				catch(Exception  e)
				{
					vError.val = toNumber(2);
					throw e;
				}
			}
			catch(Exception e)
			{
				return  toBool( toBool(NBool.False));
			}
		}

	
	/* Original PL/SQL code for Prog Unit IMPRIME_DOCUMENTO
	
	PROCEDURE IMPRIME_DOCUMENTO(v_ruta_cliente IN VARCHAR2)
IS
     
BEGIN	  
    SET_CUSTOM_ITEM_PROPERTY('MI_BLOQUE.IMPRIME','PRINT',v_ruta_cliente);
END;
	*/
	//ID:389
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		* @param vRutaCliente
		*/
		public void imprimeDocumento(NString vRutaCliente)
		{
			// F2J_NOT_SUPPORTED : The property "CUSTOM_ITEM's "PRINT"" is not supported. See documentation for details.
			//			SupportClasses.FORMS40.SetCustomItemProperty("MI_BLOQUE.IMPRIME", "PRINT", vRutaCliente);
			this.getLogger().trace(this, "// F2J_NOT_SUPPORTED : The property 'CUSTOM_ITEM's 'PRINT'' is not supported. See documentation for details.");
			
		}

	
	/* Original PL/SQL code for Prog Unit CONSTRUYE_097
	
	PROCEDURE construye_097 IS

    -- Esta unidad de programa se utiliza para construir los 097 que tienen
    -- una reducción del 25% por recargo de extemporaneidad.

    v_texto_de_error      VARCHAR2(100);
    v_indimpre            su_docuni.indimpre%TYPE;
    v_codplant            su_planti.codplant%TYPE;
    v_tipmodel            su_modelo.tipmodel%TYPE;
    v_tipplant            su_modelo.tipplant%TYPE;
    v_existe_plantilla    NUMBER;
    v_indconma            su_planti.indconma%TYPE;
    v_retorno_codigo      NUMBER;
    v_retorno_texto       VARCHAR2(72);
    v_retorno_modulo      VARCHAR2(72);
    t_marcadores          kgenrep.ta_datos_marcador;
    v_total_marcadores    NUMBER;
    v_estado 							VARCHAR2(100);
    e_error               EXCEPTION;

BEGIN
    v_indimpre:= k000810.fobtestado(substr(:temp.v_097, 1, 3), substr(:temp.v_097, 4, 1),substr(:temp.v_097, 5, 9));

    IF v_indimpre IS NULL THEN     
                
        v_existe_plantilla := kgenctrl.fobtplan ( substr(:temp.v_097, 1, 3), substr(:temp.v_097, 4, 1), substr(:temp.v_097, 5, 9)
                                                , v_codplant, v_tipmodel, v_tipplant);

        IF v_existe_plantilla <> 0 THEN
            v_texto_de_error := 'SUR-02023';
            RAISE e_error;
        END IF;

        kgenrep.carga_tabla ( v_retorno_codigo, v_retorno_texto, v_retorno_modulo
                            , substr(:temp.v_097, 1, 3), substr(:temp.v_097, 4, 1), substr(:temp.v_097, 5, 9)
                            , '0', v_codplant, v_total_marcadores, t_marcadores);


        IF NVL(v_retorno_codigo, 0) <> 0 THEN
            v_texto_de_error := TO_CHAR(v_retorno_codigo)||'-'||v_retorno_texto||'-'||v_retorno_modulo;
            raise e_error;
        END IF;

        kgenrep.graba_tabla ( v_retorno_codigo, v_retorno_texto, v_retorno_modulo, 'S'
                            , substr(:temp.v_097, 1, 3), substr(:temp.v_097, 4, 1), substr(:temp.v_097, 5, 9)
                            , '0', v_codplant, v_total_marcadores, t_marcadores );

        crea_pdf(substr(:temp.v_097, 1, 3), substr(:temp.v_097, 4, 1), substr(:temp.v_097, 5, 9), :temp.operacion, v_codplant, v_estado);          
  
        IF NVL(v_retorno_codigo, 0) <> 0 THEN
            v_texto_de_error := TO_CHAR(v_retorno_codigo)||'-'||v_retorno_texto||'-'||v_retorno_modulo;
            raise e_error;
        END IF;
		
        BEGIN                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
			      --Actualizamos el indimpre del documento 097 asociado
						k000810.pindimpre(substr(:temp.v_097, 1, 3), substr(:temp.v_097, 4, 1), substr(:temp.v_097, 5, 9), '1');
					  kfirma.pindocomp(substr(:temp.v_097, 1, 3), substr(:temp.v_097, 4, 1), substr(:temp.v_097, 5, 9), 'F') ;	           	       	                						                        
                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
			  EXCEPTION                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
			      WHEN OTHERS THEN                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
			          mostrar_mensaje('SUR-02000 #1 ' || SQLERRM || ' #2 al construir el documento 097 de Recargo de Extemporaneidad', 'E', TRUE);                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		  	END;                                                                                                                                 
    ELSE
        v_texto_de_error := 'DOCUMENTO YA CONSTRUIDO';
        raise e_error;
    END IF;

EXCEPTION
    WHEN e_error THEN
        mostrar_mensaje('SUR-02000 #1 ' || v_texto_de_error || ' #2 al construir el documento 097 de Recargo de Extemporaneidad', 'E', TRUE);        
    WHEN OTHERS THEN
        IF SQLCODE >= -20999 AND SQLCODE <= -20000 THEN
            RAISE;
        ELSE
             mostrar_mensaje('SUR-02000 #1 ' || SQLERRM || ' #2 al construir el documento 097 de Recargo de Extemporaneidad', 'E', TRUE);             
        END IF;

END;

	*/
	//ID:390
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		*/
		public void construye097()
		{
			//  Esta unidad de programa se utiliza para construir los 097 que tienen
			//  una reducción del 25% por recargo de extemporaneidad.
			NString vTextoDeError = NString.getNull();
			NString vIndimpre = NString.getNull();
			NString vCodplant = NString.getNull();
			NString vTipmodel = NString.getNull();
			NString vTipplant = NString.getNull();
			NNumber vExistePlantilla = NNumber.getNull();
			NString vIndconma = NString.getNull();
			NNumber vRetornoCodigo = NNumber.getNull();
			NString vRetornoTexto = NString.getNull();
			NString vRetornoModulo = NString.getNull();
			Kgenrep.TaDatosMarcador tMarcadores = new Kgenrep.TaDatosMarcador();
			NNumber vTotalMarcadores = NNumber.getNull();
			NString vEstado = NString.getNull();
			try
			{
				vIndimpre = K000810.fobtestado(substring(getFormModel().getTemp().getV097(), toInt(1), toInt(3)), substring(getFormModel().getTemp().getV097(), toInt(4), toInt(1)), substring(getFormModel().getTemp().getV097(), toInt(5), toInt(9)));
				if ( vIndimpre.isNull() )
				{
					Ref<NString> p_plantilla_ref = new Ref<NString>(toStr(vCodplant));
					Ref<NString> p_tipmodel_ref = new Ref<NString>(toStr(vTipmodel));
					Ref<NString> p_tipplant_ref = new Ref<NString>(toStr(vTipplant));
					vExistePlantilla = Kgenctrl.fobtplan(substring(getFormModel().getTemp().getV097(), toInt(1), toInt(3)), substring(getFormModel().getTemp().getV097(), toInt(4), toInt(1)), substring(getFormModel().getTemp().getV097(), toInt(5), toInt(9)), p_plantilla_ref, p_tipmodel_ref, p_tipplant_ref);
					vCodplant = p_plantilla_ref.val;
					vTipmodel = p_tipmodel_ref.val;
					vTipplant = p_tipplant_ref.val;
					if ( vExistePlantilla.notEquals(0) )
					{
						vTextoDeError = toStr("SUR-02023");
						throw new EError();
					}
					Ref<NNumber> p_retorno_codigo_ref = new Ref<NNumber>(vRetornoCodigo);
					Ref<NString> p_retorno_texto_ref = new Ref<NString>(vRetornoTexto);
					Ref<NString> p_retorno_modulo_ref = new Ref<NString>(vRetornoModulo);
					p_plantilla_ref = new Ref<NString>(toStr(vCodplant));
					Ref<NNumber> p_total_marcadores_ref = new Ref<NNumber>(vTotalMarcadores);
					Ref<Kgenrep.TaDatosMarcador> a_tabla_ref = new Ref<Kgenrep.TaDatosMarcador>(tMarcadores);
					Kgenrep.cargaTabla(p_retorno_codigo_ref, p_retorno_texto_ref, p_retorno_modulo_ref, substring(getFormModel().getTemp().getV097(), toInt(1), toInt(3)), substring(getFormModel().getTemp().getV097(), toInt(4), toInt(1)), substring(getFormModel().getTemp().getV097(), toInt(5), toInt(9)), toNumber("0"), p_plantilla_ref, p_total_marcadores_ref, a_tabla_ref);
					vRetornoCodigo = p_retorno_codigo_ref.val;
					vRetornoTexto = p_retorno_texto_ref.val;
					vRetornoModulo = p_retorno_modulo_ref.val;
					vCodplant = p_plantilla_ref.val;
					vTotalMarcadores = p_total_marcadores_ref.val;
					tMarcadores = a_tabla_ref.val;
					if ( isNull(vRetornoCodigo, 0).notEquals(0) )
					{
						vTextoDeError = toChar(vRetornoCodigo).append("-").append(vRetornoTexto).append("-").append(vRetornoModulo);
						throw new EError();


















































					}
					p_retorno_codigo_ref = new Ref<NNumber>(vRetornoCodigo);
					p_retorno_texto_ref = new Ref<NString>(vRetornoTexto);
					p_retorno_modulo_ref = new Ref<NString>(vRetornoModulo);
					a_tabla_ref = new Ref<Kgenrep.TaDatosMarcador>(tMarcadores);
					Kgenrep.grabaTabla(p_retorno_codigo_ref, p_retorno_texto_ref, p_retorno_modulo_ref, toStr("S"), substring(getFormModel().getTemp().getV097(), toInt(1), toInt(3)), substring(getFormModel().getTemp().getV097(), toInt(4), toInt(1)), substring(getFormModel().getTemp().getV097(), toInt(5), toInt(9)), toNumber("0"), toStr(vCodplant), vTotalMarcadores, a_tabla_ref);
					vRetornoCodigo = p_retorno_codigo_ref.val;
					vRetornoTexto = p_retorno_texto_ref.val;
					vRetornoModulo = p_retorno_modulo_ref.val;
					tMarcadores = a_tabla_ref.val;
					Ref<NString> pPlantilla_ref = new Ref<NString>(toStr(vCodplant));
					Ref<NInteger> pEstado_ref = new Ref<NInteger>(toInt(vEstado));
					creaPdf(substring(getFormModel().getTemp().getV097(), toInt(1), toInt(3)), substring(getFormModel().getTemp().getV097(), toInt(4), toInt(1)), substring(getFormModel().getTemp().getV097(), toInt(5), toInt(9)), getFormModel().getTemp().getOperacion(), pPlantilla_ref, pEstado_ref);
					vCodplant = pPlantilla_ref.val;
					vEstado = toStr(pEstado_ref.val);
					if ( isNull(vRetornoCodigo, 0).notEquals(0) )
					{
						vTextoDeError = toChar(vRetornoCodigo).append("-").append(vRetornoTexto).append("-").append(vRetornoModulo);
						throw new EError();
					}
					try
					{
						// Actualizamos el indimpre del documento 097 asociado
						K000810.pindimpre(substring(getFormModel().getTemp().getV097(), toInt(1), toInt(3)), substring(getFormModel().getTemp().getV097(), toInt(4), toInt(1)), substring(getFormModel().getTemp().getV097(), toInt(5), toInt(9)), toStr("1"));
						Kfirma.pindocomp(substring(getFormModel().getTemp().getV097(), toInt(1), toInt(3)), substring(getFormModel().getTemp().getV097(), toInt(4), toInt(1)), substring(getFormModel().getTemp().getV097(), toInt(5), toInt(9)), toStr("F"));






































					}
					catch(Exception  e)
					{
						mostrarMensaje(toStr("SUR-02000 #1 ").append(errorMessage()).append(" #2 al construir el documento 097 de Recargo de Extemporaneidad"), toStr("E"), toBool(NBool.True));





















































					}
				}
				else {
					vTextoDeError = toStr("DOCUMENTO YA CONSTRUIDO");
					throw new EError();












				}
			}
			catch(EError e)
			{
				mostrarMensaje(toStr("SUR-02000 #1 ").append(vTextoDeError).append(" #2 al construir el documento 097 de Recargo de Extemporaneidad"), toStr("E"), toBool(NBool.True));



















































































































































































































			}
			catch(Exception  e)
			{
				if ( errorCode().greaterOrEquals(- (20999)) && errorCode().lesserOrEquals(- (20000)) )
				{
					throw  e;


































































				}
				else {
					mostrarMensaje(toStr("SUR-02000 #1 ").append(errorMessage()).append(" #2 al construir el documento 097 de Recargo de Extemporaneidad"), toStr("E"), toBool(NBool.True));










				}
			}
		}

	
	/* Original PL/SQL code for Prog Unit CONTROLA_MULTAS
	
	PROCEDURE controla_multas IS
BEGIN
    -- Esta unidad de programa se utiliza para controlar que el usuario
    -- no pueda introducir simultáneamente multas de tipo fijo y multas proporcionales.
    IF :temp.v_multa_fija = 'S' AND :temp.v_multa_proporcional = 'S' THEN
    	
       -- Si están rellenas las 2 indicamos al usuario que no se puede realizar dicha acción.
       mostrar_mensaje('SUR-02000#1#2'||'Simultáneamente no pueden venir rellenos el tipo de multa fija y multa proporcional. Revise los datos introducidos'||'', 'E', TRUE);
    END IF;
END;
	*/
	//ID:391
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		*/
		public void controlaMultas()
		{
			//  Esta unidad de programa se utiliza para controlar que el usuario
			//  no pueda introducir simultáneamente multas de tipo fijo y multas proporcionales.
			if ( getFormModel().getTemp().getVMultaFija().equals("S") && getFormModel().getTemp().getVMultaProporcional().equals("S") )
			{
				//  Si están rellenas las 2 indicamos al usuario que no se puede realizar dicha acción.
				mostrarMensaje(toStr("SUR-02000#1#2").append("Simultáneamente no pueden venir rellenos el tipo de multa fija y multa proporcional. Revise los datos introducidos").append(""), toStr("E"), toBool(NBool.True));
			}
		}

	
	/* Original PL/SQL code for Prog Unit FSUSTITUYE_TDIN
	
	FUNCTION FSUSTITUYE_TDIN RETURN BOOLEAN IS

    v_resultado  BOOLEAN := FALSE;
    v_conteo     NUMBER:=0;
BEGIN

    SELECT count(*)
      INTO v_conteo
      FROM su_plalin
     WHERE planti_codplant = :temp.plantilla
       AND tiplinea IN ('TDIN','DTDIN')
       AND texlinea like '%'||substr(:marcador.marcador, 3)||'%';       
       
       IF v_conteo > 0 THEN
       	 v_resultado:=TRUE;       	 
       END IF;
       
    RETURN v_resultado;
  
END;
	*/
	//ID:392
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this function was identified as containing business logic. See documentation for details.
/* </p>
		*/
		public NBool fsustituyeTdin(MarcadorAdapter marcadorElement)
		{
			int rowCount = 0;
			NBool vResultado = toBool(NBool.False);
			NNumber vConteo = toNumber(0);
			String sql1 = "SELECT count(*) " +
	" FROM su_plalin " +
	" WHERE planti_codplant = :TEMP_PLANTILLA AND (tiplinea) IN ('TDIN', 'DTDIN') AND texlinea LIKE '%' || substr(:MARCADOR_MARCADOR, 3) || '%' ";
			DataCommand command1 = new DataCommand(sql1);
			//Setting query parameters
			command1.addParameter("TEMP_PLANTILLA", getFormModel().getTemp().getPlantilla());
			command1.addParameter("MARCADOR_MARCADOR", marcadorElement.getMarcador());
			ResultSet results1 = command1.executeQuery();
			rowCount = command1.getRowCount();
			if ( results1.hasData() ) {
				vConteo = results1.getNumber(0);
			}
			results1.close();
			if ( vConteo.greater(0) )
			{
				vResultado = toBool(NBool.True);
			}
			return  toBool(vResultado);
		}

	
	/* Original PL/SQL code for Prog Unit MARCAR_EJEMPLARES
	
	PROCEDURE MARCAR_EJEMPLARES IS
BEGIN
    GO_BLOCK('EJEMPLARES');
    FIRST_RECORD;
    LOOP
        :ejemplares.check_ejemplar := 'S';
            
  	    EXIT WHEN :SYSTEM.LAST_RECORD = 'TRUE';
  	    NEXT_RECORD;
  	         
	  END LOOP;  
    
    :cg$ctrl.check_imp_todo:= 'S';		        
EXCEPTION
    WHEN NO_DATA_FOUND THEN
		    NULL;	
END;

	*/
	//ID:393
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		*/
		public void marcarEjemplares(EjemplaresAdapter ejemplaresElement)
		{
			try
			{
				goBlock(toStr("EJEMPLARES"));
				firstRecord();
				while (true) {
					ejemplaresElement.setCheckEjemplar(toStr("S"));
					if ( isInLastRecord() ) 
						break;
					nextRecord();
				}
				getFormModel().getCgCtrl().setCheckImpTodo(toStr("S"));
			}
			catch(NoDataFoundException e)
			{
			}
		}

	
	/* Original PL/SQL code for Prog Unit CONFIGURA_IMPRESION
	
	PROCEDURE configura_impresion(p_ejemplar OUT VARCHAR2, p_modo OUT VARCHAR2) IS
BEGIN
    -- Para configurar la impresión comprobamos las opciones que ha marcado el usuario.
    -- Por defecto sería (Imp. Simple y el doc. completo).
   
    IF :CG$CTRL.CHECK_IMP_SIMPLE = 'N' AND :CG$CTRL.CHECK_IMP_DUAL = 'S' THEN
  	    p_modo:='ID1';
  	    
    ELSE
  	    p_modo:='I1';	
    END IF;

    --Configuramos el ejemplar/es que se quiere imprimir
    IF :CG$CTRL.CHECK_IMP_TODO = 'S' THEN
        p_ejemplar:='Todo';
    ELSE	
        -- se recorre el bloque de ejemplares y se obtiene los ejemplares a imprimir
        p_ejemplar:=ejemplares_a_imprimir;
    END IF;                                                                  
    
END;
	*/
	//ID:394
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		* @param pEjemplar
		* @param pModo
		*/
		public void configuraImpresion(EjemplaresAdapter ejemplaresElement, Ref<NString> pEjemplar, Ref<NString> pModo)
		{
			//  Para configurar la impresión comprobamos las opciones que ha marcado el usuario.
			//  Por defecto sería (Imp. Simple y el doc. completo).
			if ( getFormModel().getCgCtrl().getCheckImpSimple().equals("N") && getFormModel().getCgCtrl().getCheckImpDual().equals("S") )
			{
				pModo.val = toStr("ID1");
			}
			else {
				pModo.val = toStr("I1");
			}
			// Configuramos el ejemplar/es que se quiere imprimir
			if ( getFormModel().getCgCtrl().getCheckImpTodo().equals("S") )
			{
				pEjemplar.val = toStr("Todo");
			}
			else {
				//  se recorre el bloque de ejemplares y se obtiene los ejemplares a imprimir
				pEjemplar.val = ejemplaresAImprimir(ejemplaresElement);
			}
		}

	
	/* Original PL/SQL code for Prog Unit EJEMPLARES_A_IMPRIMIR
	
	FUNCTION ejemplares_a_imprimir RETURN VARCHAR IS
    v_ejemplares VARCHAR2(1000);
BEGIN
    GO_BLOCK('EJEMPLARES');
    first_record;    
    v_ejemplares:=NULL;
    LOOP
        IF :ejemplares.check_ejemplar = 'S' THEN
             IF v_ejemplares IS NULL THEN
		             v_ejemplares:= :ejemplares.ejemplar;
             ELSE
          	     v_ejemplares:=v_ejemplares||','||:ejemplares.ejemplar;
             END IF;            
        END IF;      

        EXIT WHEN :SYSTEM.LAST_RECORD = 'TRUE';         	
  	    NEXT_RECORD;  	         
    END LOOP;  
    
    RETURN v_ejemplares; 

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN NULL;	
END;
	*/
	//ID:395
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this function was identified as containing business logic. See documentation for details.
/* </p>
		*/
		public NString ejemplaresAImprimir(EjemplaresAdapter ejemplaresElement)
		{
			NString vEjemplares = NString.getNull();
			try
			{
				goBlock(toStr("EJEMPLARES"));
				firstRecord();
				vEjemplares = toStr(null);
				while (true) {
					if ( ejemplaresElement.getCheckEjemplar().equals("S") )
					{
						if ( vEjemplares.isNull() )
						{
							vEjemplares = ejemplaresElement.getEjemplar();
						}
						else {
							vEjemplares = vEjemplares.append(",").append(ejemplaresElement.getEjemplar());
						}
					}
					if ( isInLastRecord() ) 
						break;
					nextRecord();
				}
				return  toStr(vEjemplares);
			}
			catch(NoDataFoundException e)
			{
				return  toStr(NString.getNull());
			}
		}

	
	/* Original PL/SQL code for Prog Unit TRATAMIENTO_EJEMPLARES
	
	PROCEDURE tratamiento_ejemplares IS
    v_ok    NUMBER:=0;
BEGIN 
    v_ok:=k000810.fcontejem(:temp.codmodel, :temp.numvermo, :temp.numerdoc);    
    
    --Nos vamos a la pantalla de Ejemplares para tratar la impresion de Ejemplares.
    IF v_ok = 1 THEN        
        go_block('EJEMPLARES');
        -- Ejecutamos la consulta;
        do_key('execute_query');
        marcar_ejemplares;
    ELSE
        mostrar_mensaje('SUR-02000 #1'|| 'Error al obtener ejemplares del documento: '||:temp.codmodel||'-'||:temp.numvermo||'-'||:temp.numerdoc , 'E', TRUE);         
    END IF;   
END;
	*/
	//ID:396
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		*/
		public void tratamientoEjemplares(EjemplaresAdapter ejemplaresElement)
		{
			NNumber vOk = toNumber(0);
			vOk = K000810.fcontejem(getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getNumvermo(), getFormModel().getTemp().getNumerdoc());
			// Nos vamos a la pantalla de Ejemplares para tratar la impresion de Ejemplares.
			if ( vOk.equals(1) )
			{
				goBlock(toStr("EJEMPLARES"));
				//  Ejecutamos la consulta;
				executeAction(KeyFunction.EXECUTE_QUERY);
				marcarEjemplares(ejemplaresElement);
			}
			else {
				mostrarMensaje(toStr("SUR-02000 #1").append("Error al obtener ejemplares del documento: ").append(getFormModel().getTemp().getCodmodel()).append("-").append(getFormModel().getTemp().getNumvermo()).append("-").append(getFormModel().getTemp().getNumerdoc()), toStr("E"), toBool(NBool.True));
			}





		}


	
	/* Original PL/SQL code for Prog Unit TRATAMIENTO_FIRMA
	
	PROCEDURE tratamiento_firma  IS
    v_tipo_firma VARCHAR2(1);
    v_resultado  VARCHAR2(1);

BEGIN
    -- Vbles utilizadas para firma electrónica.
    :temp.codterri              := kusuari.fcodter;
    :temp.coduniad              := kusuari.funiadm;
    :temp.v_tipo_firma          := 'M';
    :temp.firma_electronica_ok  := 'N';

    -- Se obtiene el tipo de firma.      
    v_tipo_firma:=kfirma.ftipofirm(:temp.codmodel, :temp.numvermo, :temp.numerdoc, :temp.codterri, :temp.coduniad);

    IF v_tipo_firma = 'A' THEN
        -- Tenemos las 2 opciones y resolvemos que tipo de firma vamos a usar.
         v_resultado:= resolver_tipo_firma;   
         :temp.v_tipo_firma:= v_resultado;           
    ELSIF v_tipo_firma = 'M' THEN
    	  -- Firma manual, se firma como se está realizando actualmente.
        :temp.v_tipo_firma:='M';            
    ELSIF v_tipo_firma = 'E' THEN
    	  -- Firma electrónica, se presentan y resuelven los firmantes.    	   	
        :temp.v_tipo_firma:='E';         
    ELSE
    	  --Es el caso donde no tenemos firmantes o el documento no se firma
         :temp.v_tipo_firma := 'M';
    END IF;   
    
    actualiza_marcador_tipofirma (:temp.v_tipo_firma);        
END;
	*/
	//ID:397
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		*/
		public void tratamientoFirma(MarcadorAdapter marcadorElement)
		{
			NString vTipoFirma = NString.getNull();
			NString vResultado = NString.getNull();
			//  Vbles utilizadas para firma electrónica.
			getFormModel().getTemp().setCodterri(Kusuari.fcodter());
			getFormModel().getTemp().setCoduniad(Kusuari.funiadm());
			getFormModel().getTemp().setVTipoFirma(toStr("M"));
			getFormModel().getTemp().setFirmaElectronicaOk(toStr("N"));
			//  Se obtiene el tipo de firma.      
			vTipoFirma = Kfirma.ftipofirm(getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getNumvermo(), getFormModel().getTemp().getNumerdoc(), getFormModel().getTemp().getCodterri(), getFormModel().getTemp().getCoduniad());
			if ( vTipoFirma.equals("A") )
			{
				//  Tenemos las 2 opciones y resolvemos que tipo de firma vamos a usar.
				vResultado = resolverTipoFirma();
				getFormModel().getTemp().setVTipoFirma(vResultado);









			}
			else if ( vTipoFirma.equals("M") ) {
				//  Firma manual, se firma como se está realizando actualmente.
				getFormModel().getTemp().setVTipoFirma(toStr("M"));





			}
			else if ( vTipoFirma.equals("E") ) {
				//  Firma electrónica, se presentan y resuelven los firmantes.    	   	
				getFormModel().getTemp().setVTipoFirma(toStr("E"));
			}
			else {
				// Es el caso donde no tenemos firmantes o el documento no se firma
				getFormModel().getTemp().setVTipoFirma(toStr("M"));









			}
			actualizaMarcadorTipofirma(marcadorElement, getFormModel().getTemp().getVTipoFirma());














		}


	
	/* Original PL/SQL code for Prog Unit OBTENER_FIRMANTES
	
	PROCEDURE obtener_firmantes IS
BEGIN	
    go_block('FIRMA');
    synchronize;
    do_key('execute_query');
    IF :temp.numero_firmantes = 0 THEN
        mostrar_mensaje('No existen firmantes dados de alta para firmar esté tipo de documento. Debe darse de alta un firmante para que el documento se pueda firmar.', 'I', FALSE);                
        OCULTA_CANVAS ('FIRMANTES');
    END IF;  
EXCEPTION
    WHEN OTHERS THEN
        mostrar_mensaje('SUR-02000 #1 ''#2 Error al obtener los firmantes de documento: '||:temp.codmodel||'-'||:temp.numvermo||'-'||:temp.numerdoc , 'E', TRUE);         	
END;
	*/
	//ID:398
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		*/
		public void obtenerFirmantes()
		{
			try
			{
				goBlock(toStr("FIRMA"));
				synchronize();
				executeAction(KeyFunction.EXECUTE_QUERY);
				if ( getFormModel().getTemp().getNumeroFirmantes().equals(0) )
				{
					mostrarMensaje(toStr("No existen firmantes dados de alta para firmar esté tipo de documento. Debe darse de alta un firmante para que el documento se pueda firmar."), toStr("I"), toBool(NBool.False));
					ocultaCanvas(toStr("FIRMANTES"));





































































































				}
			}
			catch(Exception  e)
			{
				mostrarMensaje(toStr("SUR-02000 #1 '#2 Error al obtener los firmantes de documento: ").append(getFormModel().getTemp().getCodmodel()).append("-").append(getFormModel().getTemp().getNumvermo()).append("-").append(getFormModel().getTemp().getNumerdoc()), toStr("E"), toBool(NBool.True));



















































			}
		}


	
	/* Original PL/SQL code for Prog Unit PFIRMANT_QRY
	
	PROCEDURE PFIRMANT_QRY
 ( p_datos      IN OUT  KFIRMA.ta_datos
 )
IS
    v_salida NUMBER;
    v_datos  KFIRMA.ta_datos;
BEGIN
    -- Pasamos aquí el control de la firma, en lugar de llamar directamente al paquete ya que puede dar problema
    -- por el trigger que monta de forma automática.
    kfirma.pfirmant(:temp.codterri, :temp.codmodel, :temp.numvermo, :temp.coduniad, :temp.v_tipo_firma, v_datos, NULL);
    -- Almacenamos el número total de firmantes para el documento.
    p_datos:= v_datos;
    :temp.numero_firmantes:= v_datos.count;
END;
	*/
	//ID:399
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		* @param pDatos
		*/
		public void pfirmantQry(Ref<Kfirma.TaDatosRow> pDatos)
		{
			NNumber vSalida = NNumber.getNull();
			Kfirma.TaDatosRow vDatos = new Kfirma.TaDatosRow();
			//  Pasamos aquí el control de la firma, en lugar de llamar directamente al paquete ya que puede dar problema
			//  por el trigger que monta de forma automática.
			Ref<Kfirma.TaDatosRow> p_datos_ref = new Ref<Kfirma.TaDatosRow>();
			Kfirma.pfirmant(getFormModel().getTemp().getCodterri(), getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getNumvermo(), getFormModel().getTemp().getCoduniad(), getFormModel().getTemp().getVTipoFirma(), p_datos_ref, toNumber(null));
			vDatos = p_datos_ref.val;
			//  Almacenamos el número total de firmantes para el documento.
			pDatos.val = vDatos;
			getFormModel().getTemp().setNumeroFirmantes(toNumber(vDatos.size()));
		}

	
	/* Original PL/SQL code for Prog Unit OCULTA_CANVAS
	
	PROCEDURE oculta_canvas (p_canvas VARCHAR2) IS

BEGIN
	
	  IF p_canvas = 'EJEMPLARES' THEN
        HIDE_WINDOW('WINDOW3');
	  ELSIF p_canvas = 'FIRMANTES' THEN
	      HIDE_WINDOW('WINDOW4');
	  ELSE
	  	NULL;
	  END IF;
    
    go_block('MARCADOR');    
END;

	*/
	//ID:400
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		* @param pCanvas
		*/
		public void ocultaCanvas(NString pCanvas)
		{
			if ( pCanvas.equals("EJEMPLARES") )
			{
				hideWindow("WINDOW3");
			}
			else if ( pCanvas.equals("FIRMANTES") ) {
				hideWindow("WINDOW4");
			}
			else {
			}
			goBlock(toStr("MARCADOR"));
		}

	
	/* Original PL/SQL code for Prog Unit RESOLVER_TIPO_FIRMA
	
	FUNCTION resolver_tipo_firma RETURN VARCHAR2 IS
    v_respuesta  NUMBER;
    v_salida     VARCHAR2(1);
BEGIN
    v_respuesta := SHOW_ALERT('DIALOGO_FIRMA');    
    IF v_respuesta = alert_button1 THEN    	
    	  -- Firma electrónica
        v_salida:= 'E';
    ELSE
        --Firma Manual		    
		    v_salida:= 'M';
    END IF;

    RETURN v_salida;
END;
	*/
	//ID:401
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this function was identified as containing business logic. See documentation for details.
/* </p>
		*/
		public NString resolverTipoFirma()
		{
			NNumber vRespuesta = NNumber.getNull();
			NString vSalida = NString.getNull();
			vRespuesta = toNumber(showAlert("DIALOGO_FIRMA"));
			if ( vRespuesta.equals(MessageServices.BUTTON1) )
			{
				//  Firma electrónica
				vSalida = toStr("E");
			}
			else {
				// Firma Manual		    
				vSalida = toStr("M");


			}
			return  toStr(vSalida);

		}


	
	/* Original PL/SQL code for Prog Unit GENERA_PDF
	
	PROCEDURE genera_pdf (p_estado NUMBER) IS
    v_estado             PLS_INTEGER;
    v_resultado          PLS_INTEGER;
    v_conteo_escrit      NUMBER:=0;
    v_conteo             NUMBER:=0;
    v_documento_firmado  VARCHAR2(2);
    v_borrar             BOOLEAN;
    e_inserta_firma      EXCEPTION;
    e_genera_pdf     	   EXCEPTION;
BEGIN          
    IF p_estado = 200 THEN  
        -- Aquí ya tenemos la firma resuelta y mandamos a firmar.
        IF :temp.v_tipo_firma ='E' 
        	 AND :temp.firma_electronica_ok = 'S'
        THEN                   	            
            v_resultado:= kfirma.findocfir( :firma.codmodel, :firma.numvermo, :firma.numerdoc
                                          , :firma.secuencia, :firma.numorden, :firma.codclien
                                          , :firma.codcargo, :temp.codterri
                                          , NVL(:cg$ctrl.check_indurgen, 'N'), :cg$ctrl.obsurgen);

            IF v_resultado = 0 THEN  --Todo correcto y enviado a firma
                k000810.pindimpre(:temp.codmodel, :temp.numvermo, :temp.numerdoc, 'P');	
            ELSE 
            	  RAISE e_inserta_firma;
            END IF;
        ELSE
            k000810.pindimpre(:temp.codmodel, :temp.numvermo, :temp.numerdoc, '1'); --Construido
        END IF;

        -- Asociamos al escrito.
        -- Revisamos que no exista el escrito en la tabla de escritos.
				SELECT COUNT (*) 
          INTO v_conteo_escrit
          FROM su_escrit
         WHERE docuni_codmodel = :temp.codmodel
           AND docuni_numvermo = :temp.numvermo
           AND docuni_numerdoc = :temp.numerdoc;
                    
        IF v_conteo_escrit = 0 THEN  
 				     k03util.PINSESC( :parameter.p_codmodel            , :parameter.p_numvermo           , :parameter.p_numerdoc
				                    , :parameter.p_expedi_codcircu     , :parameter.p_expedi_codterri    , :parameter.p_expedi_ejeexped
					                  , :parameter.p_expedi_numexped     , :parameter.p_numordtr           , FSYSDATE
					                  , NVL(:parameter.p_indnotif,'N')   , :parameter.p_codclien           , :parameter.p_codterri_des
					                  , :parameter.p_docuni_codmodel_ori , :parameter.p_docuni_numvermo_ori, :parameter.p_docuni_numerdoc_ori 
					                  , NULL, NULL
					                  , :parameter.p_codfil_codvista, :parameter.p_codfil_codterri);
        ELSE
        	  NULL;
        END IF;
        
        -- para solucionar problemas con microcortes. Realizamos commit.
        IF    :parameter.p_expedi_codcircu IS NOT NULL 
          AND :parameter.p_expedi_codterri IS NOT NULL 
          AND :parameter.p_expedi_ejeexped IS NOT NULL
          AND :parameter.p_expedi_numexped IS NOT NULL  
        THEN                                              
          
            k03util.pdocexp( :parameter.p_expedi_codcircu, :parameter.p_expedi_codterri, :parameter.p_expedi_ejeexped
                           , :parameter.p_expedi_numexped, :parameter.p_codmodel, :parameter.p_numvermo
                           , :parameter.p_numerdoc, :parameter.p_indapeex, :parameter.p_indestad);											           
                                                                    
        END IF;    
    ELSE
        SELECT count(*)
		      INTO v_conteo
		      FROM su_docpdf
		     WHERE docuni_codmodel = :temp.codmodel
		       AND docuni_numvermo = :temp.numvermo
		       AND docuni_numerdoc = :temp.numerdoc;
				
				IF v_conteo > 0 THEN  
				     -- Hemos tenido un error y hemos creado el pdf, con lo que borramos
						 -- el pdf y dejamos coherente la BD con lo que se ha ejecutado.  
						 v_borrar:= fborrpdf (:temp.codmodel, :temp.numvermo, :temp.numerdoc);
				END IF;	
        
        RAISE e_genera_pdf;               	
    
    END IF; 
    
    -- Confirmamos cambios                    
    do_key('COMMIT_FORM');    
    
    <multilinecomment> Activa *******blq****BO****NU***CO****AC****AN****SA***MAS**  </multilinecomment>
    activa_botones ('MI_BLOQUE',FALSE,FALSE,FALSE,FALSE, FALSE, TRUE,FALSE);
    SET_ITEM_PROPERTY('VISTA_PRELIMINAR',ENABLED,PROPERTY_FALSE);
    
EXCEPTION
    WHEN e_genera_pdf THEN
        mostrar_mensaje('SUR-02000 #1 '' #2 Error al generar el documento '||:temp.codmodel||'-'||:temp.numvermo||'-'||:temp.numerdoc||' en formato PDF.' , 'E', TRUE);        
    WHEN OTHERS THEN 
        IF :temp.v_tipo_firma ='E' THEN            	 
            v_documento_firmado:= kfirma.festafir(:temp.codmodel, :temp.numvermo, :temp.numerdoc);
            IF v_documento_firmado <> '0' THEN
                k000810.pindimpre(:temp.codmodel, :temp.numvermo, :temp.numerdoc, 'P');      
            ELSE
                mostrar_mensaje('SUR-02000 #1 '' #2 Error al firmar electrónicamente el documento '||:temp.codmodel||'-'||:temp.numvermo||'-'||:temp.numerdoc||' en formato PDF.' , 'E', TRUE);        	
            END IF;
        ELSE
            IF K000810.fexispdf(:temp.codmodel, :temp.numvermo, :temp.numerdoc) THEN
                k000810.pindimpre(:temp.codmodel, :temp.numvermo, :temp.numerdoc, '1');      
            END IF;    
        END IF;
END;

      
	*/
	//ID:402
	/* <p>
/* </p>
		* @param pEstado
		*/
		public void generaPdf(FirmaAdapter firmaElement, NNumber pEstado)
		{
			int rowCount = 0;
			NInteger vEstado = NInteger.getNull();
			NInteger vResultado = NInteger.getNull();
			NNumber vConteoEscrit = toNumber(0);
			NNumber vConteo = toNumber(0);
			NString vDocumentoFirmado = NString.getNull();
			NBool vBorrar = NBool.getNull();
			try
			{
				if ( pEstado.equals(200) )
				{
					//  Aquí ya tenemos la firma resuelta y mandamos a firmar.
					if ( getFormModel().getTemp().getVTipoFirma().equals("E") && getFormModel().getTemp().getFirmaElectronicaOk().equals("S") )
					{
						vResultado = toInt(Kfirma.findocfir(firmaElement.getCodmodel(), firmaElement.getNumvermo(), firmaElement.getNumerdoc(), firmaElement.getSecuencia(), firmaElement.getNumorden(), firmaElement.getCodclien(), firmaElement.getCodcargo(), getFormModel().getTemp().getCodterri(), isNull(getFormModel().getCgCtrl().getCheckIndurgen(), "N"), getFormModel().getCgCtrl().getObsurgen(), toStr(null)));
						if ( vResultado.equals(0) )
						{
							// Todo correcto y enviado a firma
							K000810.pindimpre(getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getNumvermo(), getFormModel().getTemp().getNumerdoc(), toStr("P"));
						}
						else {
							throw new EInsertaFirma();
						}
					}
					else {
						K000810.pindimpre(getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getNumvermo(), getFormModel().getTemp().getNumerdoc(), toStr("1"));
					}
					//  Asociamos al escrito.
					//  Revisamos que no exista el escrito en la tabla de escritos.
					String sql1 = "SELECT COUNT(*) " +
	" FROM su_escrit " +
	" WHERE docuni_codmodel = :TEMP_CODMODEL AND docuni_numvermo = :TEMP_NUMVERMO AND docuni_numerdoc = :TEMP_NUMERDOC ";
					DataCommand command1 = new DataCommand(sql1);
					//Setting query parameters
					command1.addParameter("TEMP_CODMODEL", getFormModel().getTemp().getCodmodel());
					command1.addParameter("TEMP_NUMVERMO", getFormModel().getTemp().getNumvermo());
					command1.addParameter("TEMP_NUMERDOC", getFormModel().getTemp().getNumerdoc());
					ResultSet results1 = command1.executeQuery();
					rowCount = command1.getRowCount();
					if ( results1.hasData() ) {
						vConteoEscrit = results1.getNumber(0);
					}
					results1.close();
					if ( vConteoEscrit.equals(0) )
					{
						K03util.pinsesc(this.getFormModel().getParam("P_CODMODEL", NString.class), this.getFormModel().getParam("P_NUMVERMO", NString.class), this.getFormModel().getParam("P_NUMERDOC", NString.class), this.getFormModel().getParam("P_EXPEDI_CODCIRCU", NString.class), this.getFormModel().getParam("P_EXPEDI_CODTERRI", NString.class), toNumber(this.getFormModel().getParam("P_EXPEDI_EJEEXPED", NString.class)), toNumber(this.getFormModel().getParam("P_EXPEDI_NUMEXPED", NString.class)), toNumber(this.getFormModel().getParam("P_NUMORDTR", NString.class)), StoredProcedures.fsysdate(), isNull(this.getFormModel().getParam("P_INDNOTIF", NString.class), "N"), this.getFormModel().getParam("P_CODCLIEN", NString.class), this.getFormModel().getParam("P_CODTERRI_DES", NString.class), this.getFormModel().getParam("P_DOCUNI_CODMODEL_ORI", NString.class), this.getFormModel().getParam("P_DOCUNI_NUMVERMO_ORI", NString.class), this.getFormModel().getParam("P_DOCUNI_NUMERDOC_ORI", NString.class), toNumber(null), toStr(null), this.getFormModel().getParam("P_CODFIL_CODVISTA", NString.class), this.getFormModel().getParam("P_CODFIL_CODTERRI", NString.class));
					}
					else {
					}
					//  para solucionar problemas con microcortes. Realizamos commit.
					if ( this.getFormModel().getParam("P_EXPEDI_CODCIRCU", NString.class).isNotNull() && this.getFormModel().getParam("P_EXPEDI_CODTERRI", NString.class).isNotNull() && this.getFormModel().getParam("P_EXPEDI_EJEEXPED", NString.class).isNotNull() && this.getFormModel().getParam("P_EXPEDI_NUMEXPED", NString.class).isNotNull() )
					{
						K03util.pdocexp(this.getFormModel().getParam("P_EXPEDI_CODCIRCU", NString.class), this.getFormModel().getParam("P_EXPEDI_CODTERRI", NString.class), toNumber(this.getFormModel().getParam("P_EXPEDI_EJEEXPED", NString.class)), toNumber(this.getFormModel().getParam("P_EXPEDI_NUMEXPED", NString.class)), this.getFormModel().getParam("P_CODMODEL", NString.class), this.getFormModel().getParam("P_NUMVERMO", NString.class), this.getFormModel().getParam("P_NUMERDOC", NString.class), this.getFormModel().getParam("P_INDAPEEX", NString.class), this.getFormModel().getParam("P_INDESTAD", NString.class));
					}
				}
				else {
					String sql2 = "SELECT count(*) " +
	" FROM su_docpdf " +
	" WHERE docuni_codmodel = :TEMP_CODMODEL AND docuni_numvermo = :TEMP_NUMVERMO AND docuni_numerdoc = :TEMP_NUMERDOC ";
					DataCommand command2 = new DataCommand(sql2);
					//Setting query parameters
					command2.addParameter("TEMP_CODMODEL", getFormModel().getTemp().getCodmodel());
					command2.addParameter("TEMP_NUMVERMO", getFormModel().getTemp().getNumvermo());
					command2.addParameter("TEMP_NUMERDOC", getFormModel().getTemp().getNumerdoc());
					ResultSet results2 = command2.executeQuery();
					rowCount = command2.getRowCount();
					if ( results2.hasData() ) {
						vConteo = results2.getNumber(0);
					}
					results2.close();
					if ( vConteo.greater(0) )
					{
						//  Hemos tenido un error y hemos creado el pdf, con lo que borramos
						//  el pdf y dejamos coherente la BD con lo que se ha ejecutado.  
						vBorrar = StoredProcedures.fborrpdf(getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getNumvermo(), getFormModel().getTemp().getNumerdoc());
					}
					throw new EGeneraPdf();
				}
				//  Confirmamos cambios                    
				//executeAction(KeyFunction.SAVE);
				formsDDL("COMMIT");
				//  Activa *******blq****BO****NU***CO****AC****AN****SA***MAS**  
				getTask().getSur().activaBotones(toStr("MI_BLOQUE"), toBool(NBool.False), toBool(NBool.False), toBool(NBool.False), toBool(NBool.False), toBool(NBool.False), toBool(NBool.True), toBool(NBool.False));
				setItemEnabled("VISTA_PRELIMINAR", false);
			}
			catch(EGeneraPdf e)
			{
				mostrarMensaje(toStr("SUR-02000 #1 ' #2 Error al generar el documento ").append(getFormModel().getTemp().getCodmodel()).append("-").append(getFormModel().getTemp().getNumvermo()).append("-").append(getFormModel().getTemp().getNumerdoc()).append(" en formato PDF."), toStr("E"), toBool(NBool.True));
			}
			catch(Exception  e)
			{
				if ( getFormModel().getTemp().getVTipoFirma().equals("E") )
				{
					vDocumentoFirmado = Kfirma.festafir(getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getNumvermo(), getFormModel().getTemp().getNumerdoc());
					if ( vDocumentoFirmado.notEquals("0") )
					{
						K000810.pindimpre(getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getNumvermo(), getFormModel().getTemp().getNumerdoc(), toStr("P"));
					}
					else {
						mostrarMensaje(toStr("SUR-02000 #1 ' #2 Error al firmar electrónicamente el documento ").append(getFormModel().getTemp().getCodmodel()).append("-").append(getFormModel().getTemp().getNumvermo()).append("-").append(getFormModel().getTemp().getNumerdoc()).append(" en formato PDF."), toStr("E"), toBool(NBool.True));
					}
				}
				else {
					if ( K000810.fexispdf(getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getNumvermo(), getFormModel().getTemp().getNumerdoc()).getValue() )
					{
						K000810.pindimpre(getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getNumvermo(), getFormModel().getTemp().getNumerdoc(), toStr("1"));
					}
				}


			}
		}

	
	/* Original PL/SQL code for Prog Unit HABILITA_FIRMANTES
	
	PROCEDURE habilita_firmantes(p_tipo BOOLEAN) IS

BEGIN
    IF p_tipo THEN     	 
     	  -- Si hay datos del firmante desactivamos la lista.       
        SET_ITEM_PROPERTY('FIRMA.BTN_LISTAR', ENABLED, PROPERTY_TRUE); 
        SET_ITEM_PROPERTY('FIRMA.BTN_LISTAR', NAVIGABLE, PROPERTY_TRUE);
    ELSE
     	  -- Si hay datos del firmante desactivamos la lista.
        SET_ITEM_PROPERTY('FIRMA.BTN_LISTAR', ENABLED, PROPERTY_FALSE); 
        SET_ITEM_PROPERTY('FIRMA.BTN_LISTAR', NAVIGABLE, PROPERTY_FALSE);    
    END IF;
    
END;
	*/
	//ID:403
	/* <p>
/* </p>
		* @param pTipo
		*/
		public void habilitaFirmantes(NBool pTipo)
		{
			if ( pTipo.getValue() )
			{
				//  Si hay datos del firmante desactivamos la lista.       
				setItemEnabled("FIRMA.BTN_LISTAR", true);
				setItemNavigable("FIRMA.BTN_LISTAR", true);
			}
			else {
				//  Si hay datos del firmante desactivamos la lista.
				setItemEnabled("FIRMA.BTN_LISTAR", false);
				setItemNavigable("FIRMA.BTN_LISTAR", false);


























			}
		}

	
	/* Original PL/SQL code for Prog Unit FACTUARIO_BORRADOR
	
	FUNCTION factuario_borrador RETURN VARCHAR2 
IS
    v_actuario  su_cliact.codcliac%TYPE;
BEGIN
    v_actuario:= fcasilla(:temp.codmodel, :temp.numvermo,:temp.numerdoc, '400', 1, NULL);  
    
    IF v_actuario IS NULL THEN
        SELECT cliact.codcliac
	        INTO v_actuario
          FROM su_cliact cliact
         WHERE cliact.fecbajas IS NULL
           AND cliact.codter_codterri = kusuari.fcodter
           AND cliact.uniadm_coduniad = kusuari.funiadm;    
    END IF;
    	
    RETURN v_actuario;
    
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        mostrar_mensaje('SUR-02000 #1 '' #2 No existe Actuario dado de alta para la Modificación del acuerdo', 'E', TRUE);         	
END;
	*/
	//ID:404
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this function was identified as containing business logic. See documentation for details.
/* </p>
		*/
		public NString factuarioBorrador()
		{
			int rowCount = 0;
			NString vActuario = NString.getNull();
			try
			{
				vActuario = StoredProcedures.fcasilla(getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getNumvermo(), getFormModel().getTemp().getNumerdoc(), toStr("400"), toNumber(1), toStr(null));
				if ( vActuario.isNull() )
				{
					String sql1 = "SELECT cliact.codcliac " +
	" FROM su_cliact cliact " +
	" WHERE cliact.fecbajas IS NULL AND cliact.codter_codterri = kusuari.fcodter AND cliact.uniadm_coduniad = kusuari.funiadm ";
					DataCommand command1 = new DataCommand(sql1);
					ResultSet results1 = command1.executeQuery();
					rowCount = command1.getRowCount();
					if ( results1.hasData() ) {
						vActuario = results1.getStr(0);
					}
					results1.close();
				}
				return  toStr(vActuario);
			}
			catch(NoDataFoundException e)
			{
				mostrarMensaje(toStr("SUR-02000 #1 ' #2 No existe Actuario dado de alta para la Modificación del acuerdo"), toStr("E"), toBool(NBool.True));



















			}
			return vActuario;

		}


	
	/* Original PL/SQL code for Prog Unit CONTROL_REVOCADO
	
	FUNCTION CONTROL_REVOCADO RETURN BOOLEAN  IS
    v_tipmodel   su_modelo.tipmodel%TYPE;
    v_codclien   su_docuni.client_codclien%TYPE;
    v_califica   VARCHAR2(1);
    v_parametro  su_pargen.valparge%TYPE;
BEGIN
    SELECT tipmodel
      INTO v_tipmodel
      FROM su_modelo
     WHERE codmodel = :temp.codmodel;
  
    SELECT client_codclien
      INTO v_codclien
      FROM su_docuni
     WHERE vermod_codmodel = :temp.codmodel 
       AND vermod_numvermo = :temp.numvermo
       AND numerdoc = :temp.numerdoc;

    IF NOT fctrlnif(v_codclien, v_califica) 
    	AND :temp.operacion ='CO'
    THEN 
        -- Para los NIF revocados se comprueba si se
		-- si no se permite la construcción
        
        v_parametro := fobtparg('MODPREVO');
    	IF INSTR(v_parametro, :temp.codmodel) > 0 THEN   
            mostrar_mensaje('SUR-10700','E',FALSE);
            RETURN FALSE;
        ELSE     
            mostrar_mensaje('SUR-10701','D', FALSE);
            IF :global.qms$dialog_answer = 'N' THEN
                RETURN FALSE;
            ELSIF :global.qms$dialog_answer = 'Y' THEN
                RETURN TRUE;
            END IF; 
        END IF;

    ELSIF NOT fctrlnif(v_codclien, v_califica) 
     	AND :temp.operacion <> 'CO' 
    THEN
        mostrar_mensaje('SUR-10701','D', FALSE);
       IF :global.qms$dialog_answer = 'N' THEN
            RETURN FALSE;
       ELSIF :global.qms$dialog_answer = 'Y' THEN
            RETURN TRUE;
       END IF;       
    ELSE
		    IF KGESCLIE.FESTA_BAJA (v_codclien) IS NOT NULL
		      AND v_tipmodel = '5' 
	        AND :temp.operacion ='CO' THEN
       
	            mostrar_mensaje('SUR-10705','D', FALSE);
	            IF :global.qms$dialog_answer = 'N' THEN
	                RETURN FALSE;
	            ELSIF :global.qms$dialog_answer = 'Y' THEN
	                RETURN TRUE;
	            END IF;
	        ELSE
	            RETURN TRUE;   	
	        END IF;
    END IF; 
EXCEPTION     
    WHEN NO_DATA_FOUND THEN
        RETURN TRUE;
END;
	*/
	//ID:405
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this function was identified as containing business logic. See documentation for details.
/* </p>
		*/
		public NBool controlRevocado()
		{
			int rowCount = 0;
			NString vTipmodel = NString.getNull();
			NString vCodclien = NString.getNull();
			Ref<NString> p_califica_ref = new Ref<NString>();
			NString vParametro = NString.getNull();
			try
			{
				String sql1 = "SELECT tipmodel " +
	" FROM su_modelo " +
	" WHERE codmodel = :TEMP_CODMODEL ";
				DataCommand command1 = new DataCommand(sql1);
				//Setting query parameters
				command1.addParameter("TEMP_CODMODEL", getFormModel().getTemp().getCodmodel());
				ResultSet results1 = command1.executeQuery();
				rowCount = command1.getRowCount();
				if ( results1.hasData() ) {
					vTipmodel = results1.getStr(0);
				}
				results1.close();
				String sql2 = "SELECT client_codclien " +
	" FROM su_docuni " +
	" WHERE vermod_codmodel = :TEMP_CODMODEL AND vermod_numvermo = :TEMP_NUMVERMO AND numerdoc = :TEMP_NUMERDOC ";
				DataCommand command2 = new DataCommand(sql2);
				//Setting query parameters
				command2.addParameter("TEMP_CODMODEL", getFormModel().getTemp().getCodmodel());
				command2.addParameter("TEMP_NUMVERMO", getFormModel().getTemp().getNumvermo());
				command2.addParameter("TEMP_NUMERDOC", getFormModel().getTemp().getNumerdoc());
				ResultSet results2 = command2.executeQuery();
				rowCount = command2.getRowCount();
				if ( results2.hasData() ) {
					vCodclien = results2.getStr(0);





























				}
				results2.close();
				if ( StoredProcedures.fctrlnif(vCodclien, p_califica_ref).not() && getFormModel().getTemp().getOperacion().equals("CO") )
				{
					//  Para los NIF revocados se comprueba si se
					//  si no se permite la construcción
					vParametro = StoredProcedures.fobtparg(toStr("MODPREVO"));
					if ( inStrNullable(vParametro, getFormModel().getTemp().getCodmodel()).greater(0) )
					{
						mostrarMensaje(toStr("SUR-10700"), toStr("E"), toBool(NBool.False));
						return  toBool( toBool(NBool.False));
					}
					else {
						mostrarMensaje(toStr("SUR-10701"), toStr("D"), toBool(NBool.False));
						if ( getGlobal("QMS$DIALOG_ANSWER").equals("N") )
						{
							return  toBool( toBool(NBool.False));
						}
						else if ( getGlobal("QMS$DIALOG_ANSWER").equals("Y") ) {
							return  toBool( toBool(NBool.True));
						}
					}
				}
				else if ( StoredProcedures.fctrlnif(vCodclien, p_califica_ref).not() && getFormModel().getTemp().getOperacion().notEquals("CO") ) {
					mostrarMensaje(toStr("SUR-10701"), toStr("D"), toBool(NBool.False));
					if ( getGlobal("QMS$DIALOG_ANSWER").equals("N") )
					{
						return  toBool( toBool(NBool.False));
					}
					else if ( getGlobal("QMS$DIALOG_ANSWER").equals("Y") ) {
						return  toBool( toBool(NBool.True));
					}
















				}
				else {
					if ( Kgesclie.festaBaja(vCodclien).isNotNull() && vTipmodel.equals("5") && getFormModel().getTemp().getOperacion().equals("CO") )
					{
						mostrarMensaje(toStr("SUR-10705"), toStr("D"), toBool(NBool.False));
						if ( getGlobal("QMS$DIALOG_ANSWER").equals("N") )
						{
							return  toBool( toBool(NBool.False));
						}
						else if ( getGlobal("QMS$DIALOG_ANSWER").equals("Y") ) {
							return  toBool( toBool(NBool.True));
						}
					}
					else {
						return  toBool( toBool(NBool.True));
					}


				}



			}
			catch(NoDataFoundException e)
			{
				return  toBool( toBool(NBool.True));










			}
			return NBool.False;
		}


	
	/* Original PL/SQL code for Prog Unit HABILITA_OBSERVACIONES
	
	PROCEDURE habilita_observaciones IS
























BEGIN
    :cg$ctrl.obsurgen:= NULL;  
    IF :cg$ctrl.check_indurgen = 'S' THEN 
     	  -- Si el envió a firma es urgente       
        SET_ITEM_PROPERTY('CG$CTRL.OBSURGEN', ENABLED, PROPERTY_TRUE); 
        SET_ITEM_PROPERTY('CG$CTRL.OBSURGEN', UPDATE_ALLOWED,PROPERTY_TRUE);        
        SET_ITEM_PROPERTY('CG$CTRL.OBSURGEN', NAVIGABLE, PROPERTY_TRUE);
        GO_ITEM('CG$CTRL.OBSURGEN');
    ELSE
        SET_ITEM_PROPERTY('CG$CTRL.OBSURGEN', ENABLED, PROPERTY_FALSE);
        SET_ITEM_PROPERTY('CG$CTRL.OBSURGEN', UPDATE_ALLOWED, PROPERTY_FALSE);
        SET_ITEM_PROPERTY('CG$CTRL.OBSURGEN', NAVIGABLE, PROPERTY_FALSE);  
    END IF;
    synchronize;  
END;
	*/
	//ID:406
	/* <p>
/* </p>
		*/
		public void habilitaObservaciones()
		{
			getFormModel().getCgCtrl().setObsurgen(toStr(null));
			if ( getFormModel().getCgCtrl().getCheckIndurgen().equals("S") )
			{
				//  Si el envió a firma es urgente       
				setItemEnabled("CG$CTRL.OBSURGEN", true);
				setItemUpdateAllowed("CG$CTRL.OBSURGEN", true);
				setItemNavigable("CG$CTRL.OBSURGEN", true);
				goItem(toStr("CG$CTRL.OBSURGEN"));
			}
			else {
				setItemEnabled("CG$CTRL.OBSURGEN", false);
				setItemUpdateAllowed("CG$CTRL.OBSURGEN", false);
				setItemNavigable("CG$CTRL.OBSURGEN", false);
			}
			synchronize();


		}



	
	/* Original PL/SQL code for Prog Unit ACTUALIZA_MARCADOR_TIPOFIRMA
	
	PROCEDURE actualiza_marcador_tipofirma (p_tipo varchar2) 
IS
    
BEGIN
    GO_BLOCK('MARCADOR');
    FIRST_RECORD;       
    LOOP
  	    IF :marcador.marcador = 'TIPOFIRMA' THEN
  	        :marcador.valor := p_tipo;
  	        EXIT;
        END IF;  	        
  	    EXIT WHEN :SYSTEM.LAST_RECORD = 'TRUE';
  	    NEXT_RECORD;  	         
    END LOOP;  
 
END;
	*/
	//ID:407
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		* @param pTipo
		*/
		public void actualizaMarcadorTipofirma(MarcadorAdapter marcadorElement, NString pTipo)
		{
			goBlock(toStr("MARCADOR"));
			firstRecord(true);
			while (true) {
				if ( marcadorElement.getMarcador().equals("TIPOFIRMA") )
				{
					marcadorElement.setValor(pTipo);
						break;
				}
				if ( isInLastRecord(true) ) 
					break;
				nextRecord();

			}


		}


	
	/* Original PL/SQL code for Prog Unit HABILITA_SUSTITUTOS
	
	PROCEDURE habilita_sustitutos IS
BEGIN
    GO_ITEM('FIRMA.CODMODEL');
    IF :firma.codclien_sus IS NOT NULL THEN    	
        SET_TAB_PAGE_PROPERTY('SUSTITUTOS', visible, property_true);     
    ELSE 
        SET_TAB_PAGE_PROPERTY('SUSTITUTOS', visible, property_false);     
    END IF;
END;
	*/
	//ID:408
	/* <p>
/* </p>
		*/
		public void habilitaSustitutos(FirmaAdapter firmaElement)
		{
			goItem(toStr("FIRMA.CODMODEL"));
			if ( firmaElement.getCodclienSus().isNotNull() )
			{
				setTabPageVisible("SUSTITUTOS", true);
			}
			else {
				setTabPageVisible("SUSTITUTOS", false);
			}














		}


	
	/* Original PL/SQL code for Prog Unit ACTUALIZA_MARCADORES_FIRMA
	
	PROCEDURE actualiza_marcadores_firma  IS
    i             NUMBER := 0;
    v_firma       kfirma.ta_datos;
    v_resultado   NUMBER := 0;
    v_mensaje     VARCHAR2(200);
    v_actual      NUMBER:=0;
    e_firma				EXCEPTION;
BEGIN    	  
    
    -- Recuperamos en el bloque de firma los firmantes del documento.
    GO_BLOCK('FIRMA');
    v_actual := :system.trigger_record;
    FIRST_RECORD;   
    i := 0;    
    LOOP
    	
        IF :firma.marcado = 'S' THEN 
        	  i := i+1;
            v_firma(i).codclien := :firma.codclien;
            v_firma(i).nifclien := :firma.nifclien;
            v_firma(i).nomfirte := :firma.nomfirte;
            v_firma(i).codcargo := :firma.codcargo;   	       	    
            v_firma(i).cargo    := :firma.cargo;   	       	    
            v_firma(i).cualificacion := :firma.cualificacion; 
            
            IF :firma.codclien_sus IS NOT NULL AND :cg$ctrl.check_sustituto = 'S' THEN
                v_firma(i).codclien_sus := :firma.codclien_sus;
                v_firma(i).nifclien_sus := :firma.nifclien_sus;
                v_firma(i).nomfirte_sus := :firma.nomfirte_sus;
                v_firma(i).codcargo_sus := :firma.codcargo_sus;   	       	    
                v_firma(i).cargo_sus    := :firma.cargo_sus;
                v_firma(i).cualificacion_sus := :firma.cualificacion_sus; 	
            END IF;
        ELSE
            NULL;    	
        END IF;
        
  	    EXIT WHEN :SYSTEM.LAST_RECORD = 'TRUE';
  	    NEXT_RECORD;  	           	    
    END LOOP;  
    
    go_record(v_actual);
    
    -- Actualizamos marcadores de firma.
    kfirma.pactfirma(:temp.codmodel, :temp.numvermo, :temp.numerdoc, v_firma, :temp.v_tipo_firma, v_resultado, v_mensaje);
    IF v_resultado != 0 THEN
        v_mensaje := 'Error al actualizar los firmantes.';
        RAISE e_firma;	
    END IF;               
EXCEPTION
    WHEN e_firma THEN
        mostrar_mensaje('SUR-02000 #1'|| v_mensaje ,'E',TRUE);   	
    WHEN OTHERS THEN
        mostrar_mensaje('SUR-02000 #1'|| 'Error al actualizar marcadores de firma. #2 ' ,'E',TRUE);                                                                               	        	    	
END;
	*/
	//ID:409
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		*/
		public void actualizaMarcadoresFirma(FirmaAdapter firmaElement)
		{
			NNumber i = toNumber(0);
			Kfirma.TaDatosRow vFirma = new Kfirma.TaDatosRow();
			NNumber vResultado = toNumber(0);
			NString vMensaje = NString.getNull();
			NNumber vActual = toNumber(0);
			try
			{
				//  Recuperamos en el bloque de firma los firmantes del documento.
				goBlock(toStr("FIRMA"));
				vActual = getTriggerRecord();
				firstRecord();
				i = toNumber(0);
				while (true) {
					if ( firmaElement.getMarcado().equals("S") )
					{
						i = i.add(1);
						vFirma.set(i, new Kfirma.TrFirmaRow());
						vFirma.get(i).codclien = firmaElement.getCodclien();
						vFirma.get(i).nifclien = firmaElement.getNifclien();
						vFirma.get(i).nomfirte = firmaElement.getNomfirte();
						vFirma.get(i).codcargo = firmaElement.getCodcargo();
						vFirma.get(i).cargo = firmaElement.getCargo();
						vFirma.get(i).cualificacion = firmaElement.getCualificacion();
						if ( firmaElement.getCodclienSus().isNotNull() && getFormModel().getCgCtrl().getCheckSustituto().equals("S") )
						{
							vFirma.get(i).codclienSus = firmaElement.getCodclienSus();
							vFirma.get(i).nifclienSus = firmaElement.getNifclienSus();
							vFirma.get(i).nomfirteSus = firmaElement.getNomfirteSus();
							vFirma.get(i).codcargoSus = firmaElement.getCodcargoSus();
							vFirma.get(i).cargoSus = firmaElement.getCargoSus();
							vFirma.get(i).cualificacionSus = firmaElement.getCualificacionSus();
						}
					}
					else {
					}
					if ( isInLastRecord() ) 
						break;
					nextRecord();
				}
				setCurrentRecord(vActual);
				//  Actualizamos marcadores de firma.
				Ref<NNumber> p_resultado_ref = new Ref<NNumber>(vResultado);
				Ref<NString> p_mensaje_ref = new Ref<NString>(vMensaje);
				Kfirma.pactfirma(getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getNumvermo(), getFormModel().getTemp().getNumerdoc(), vFirma, getFormModel().getTemp().getVTipoFirma(), p_resultado_ref, p_mensaje_ref);
				vResultado = p_resultado_ref.val;
				vMensaje = p_mensaje_ref.val;
				if ( vResultado.notEquals(0) )
				{
					vMensaje = toStr("Error al actualizar los firmantes.");
					throw new EFirma();
				}

			}
			catch(EFirma e)
			{
				mostrarMensaje(toStr("SUR-02000 #1").append(vMensaje), toStr("E"), toBool(NBool.True));
			}
			catch(Exception  e)
			{
				mostrarMensaje(toStr("SUR-02000 #1").append("Error al actualizar marcadores de firma. #2 "), toStr("E"), toBool(NBool.True));
			}
		}


	
	/* Original PL/SQL code for Prog Unit GENERA_DOCUMENTO
	
	PROCEDURE genera_documento IS

    v_estado          PLS_INTEGER;
BEGIN
    crea_pdf(:temp.codmodel, :temp.numvermo, :temp.numerdoc, :temp.operacion, :temp.plantilla, v_estado);    
    :temp.estado_peticion:= v_estado;
    genera_pdf(:temp.estado_peticion);
END;
	*/
	//ID:410
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		*/
		public void generaDocumento(FirmaAdapter firmaElement)
		{
			NInteger vEstado = NInteger.getNull();
			Ref<NString> pPlantilla_ref = new Ref<NString>(getFormModel().getTemp().getPlantilla());
			Ref<NInteger> pEstado_ref = new Ref<NInteger>(vEstado);
			creaPdf(getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getNumvermo(), getFormModel().getTemp().getNumerdoc(), getFormModel().getTemp().getOperacion(), pPlantilla_ref, pEstado_ref);
			getFormModel().getTemp().setPlantilla(pPlantilla_ref.val);
			vEstado = pEstado_ref.val;
			getFormModel().getTemp().setEstadoPeticion(toNumber(vEstado));
			generaPdf(firmaElement, getFormModel().getTemp().getEstadoPeticion());






		}


	
	/* Original PL/SQL code for Prog Unit ASIGNAR_FIRMANTE_A_CARGO
	
	PROCEDURE asignar_firmante_a_cargo IS

    v_resultado    number;
    v_nifclien     su_client.nifclien%type;
    v_nomfirte     su_clifir.nomfirte%type;
    v_descargo     su_cargos.descargf%type;
    v_codclien     su_client.codclien%type;
    v_cualifica    su_clifir.descualf%TYPE;
  
BEGIN	
    kfirma.pasigfir(:firma.secuencia, :temp.codterri, :firma.codcargo, v_resultado
                    , v_nifclien, v_nomfirte, v_descargo, v_codclien);                  

   
    IF  v_resultado = 0 then
     	  :firma.nifclien := v_nifclien;
        :firma.nomfirte := v_nomfirte;
        :firma.cargo    := v_descargo;
        :firma.codclien := v_codclien;

        BEGIN
           select   DESCUALF
             into v_cualifica
             from su_clifir
            where codter_codterri = :temp.codterri
              and indactiv = 'S'
              and cargos_codcargo = :firma.codcargo
              and client_codclien = :firma.codclien;
              
           :firma.cualificacion := v_cualifica;     
              
        EXCEPTION
            WHEN NO_DATA_FOUND THEN
                :firma.cualificacion := NULL;                         
        END;















        
         -- DETERMINAR SUPLENTES
    BEGIN
    	<multilinecomment>
    	           SELECT  clisus.clifir_codclien_sust codclien_sus
                         , clisus.clifir_codcargo_sust codcargo_sus
                    INTO :firma.codclien_sus, :firma.codcargo_sus      
                    FROM  su_clifir_sus clisus
                   WHERE clisus.clifir_codclien  = :firma.codclien
                     AND  clisus.clifir_codcargo  = :firma.codcargo
                     AND trunc(SYSDATE) >= clisus.fecinici
                     AND trunc(SYSDATE) <= clisus.fecfinal;
                     </multilinecomment>
                 SELECT clisus.clifir_codclien_sust codclien_sus
                       , clisus.clifir_codcargo_sust codcargo_sus
                    INTO :firma.codclien_sus, :firma.codcargo_sus      
                    FROM su_clifir_sus clisus, su_firmas_sus firmas
                   WHERE clisus.clifir_codclien  = :firma.codclien
                     AND clisus.clifir_codcargo  = :firma.codcargo
                     AND trunc(SYSDATE) >= clisus.fecinici
                     AND trunc(SYSDATE) <= clisus.fecfinal
                     AND firmas.firmas_seqmodfi = :firma.secuencia
                     AND clisus.seqclief = firmas.clifir_sus_seqclief;
                     RELLENA_SUPLENTES;
    	      EXCEPTION
    	      	WHEN NO_DATA_FOUND THEN
   	               :firma.codclien_sus := NULL;
   	               :firma.codcargo_sus := NULL;
    	      END;
    	       
             HABILITA_SUSTITUTOS;
    END IF;          




























































































END;
	*/
	//ID:411
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		*/
		public void asignarFirmanteACargo(FirmaAdapter firmaElement)
		{
			int rowCount = 0;
			NNumber vResultado = NNumber.getNull();
			NNumber vNifclien = NNumber.getNull();
			NString vNomfirte = NString.getNull();
			NString vDescargo = NString.getNull();
			NNumber vCodclien = NNumber.getNull();
			NString vCualifica = NString.getNull();
			Ref<NNumber> p_resultado_ref = new Ref<NNumber>(vResultado);
			Ref<NString> p_nifclien_ref = new Ref<NString>(toStr(vNifclien));
			Ref<NString> p_nomfirte_ref = new Ref<NString>(vNomfirte);
			Ref<NString> p_descargo_ref = new Ref<NString>(vDescargo);
			Ref<NString> p_codclien_ref = new Ref<NString>(toStr(vCodclien));
			Kfirma.pasigfir(firmaElement.getSecuencia(), getFormModel().getTemp().getCodterri(), toStr(firmaElement.getCodcargo()), p_resultado_ref, p_nifclien_ref, p_nomfirte_ref, p_descargo_ref, p_codclien_ref);
			vResultado = p_resultado_ref.val;
			vNifclien = toNumber(p_nifclien_ref.val);
			vNomfirte = p_nomfirte_ref.val;
			vDescargo = p_descargo_ref.val;
			vCodclien = toNumber(p_codclien_ref.val);
			if ( vResultado.equals(0) )
			{
				firmaElement.setNifclien(toStr(vNifclien));
				firmaElement.setNomfirte(vNomfirte);
				firmaElement.setCargo(vDescargo);
				firmaElement.setCodclien(toStr(vCodclien));
				try
				{
					String sql1 = "SELECT DESCUALF " +
	" FROM su_clifir " +
	" WHERE codter_codterri = :TEMP_CODTERRI AND indactiv = 'S' AND cargos_codcargo = :FIRMA_CODCARGO AND client_codclien = :FIRMA_CODCLIEN ";
					DataCommand command1 = new DataCommand(sql1);
					//Setting query parameters
					command1.addParameter("TEMP_CODTERRI", getFormModel().getTemp().getCodterri());
					command1.addParameter("FIRMA_CODCARGO", firmaElement.getCodcargo());
					command1.addParameter("FIRMA_CODCLIEN", firmaElement.getCodclien());
					ResultSet results1 = command1.executeQuery();
					rowCount = command1.getRowCount();
					if ( results1.hasData() ) {
						vCualifica = results1.getStr(0);














































					}
					results1.close();
					firmaElement.setCualificacion(vCualifica);
















				}
				catch(NoDataFoundException e)
				{
					firmaElement.setCualificacion(toStr(null));

















				}
				try
				{
					// SELECT  clisus.clifir_codclien_sust codclien_sus
					// , clisus.clifir_codcargo_sust codcargo_sus
					// INTO :firma.codclien_sus, :firma.codcargo_sus
					// FROM  su_clifir_sus clisus
					// WHERE clisus.clifir_codclien  = :firma.codclien
					// AND  clisus.clifir_codcargo  = :firma.codcargo
					// AND trunc(SYSDATE) >= clisus.fecinici
					// AND trunc(SYSDATE) <= clisus.fecfinal;
					String sql2 = "SELECT clisus.clifir_codclien_sust codclien_sus, clisus.clifir_codcargo_sust codcargo_sus " +
	" FROM su_clifir_sus clisus, su_firmas_sus firmas " +
	" WHERE clisus.clifir_codclien = :FIRMA_CODCLIEN AND clisus.clifir_codcargo = :FIRMA_CODCARGO AND trunc(SYSDATE) >= clisus.fecinici AND trunc(SYSDATE) <= clisus.fecfinal AND firmas.firmas_seqmodfi = :FIRMA_SECUENCIA AND clisus.seqclief = firmas.clifir_sus_seqclief ";
					DataCommand command2 = new DataCommand(sql2);
					//Setting query parameters
					command2.addParameter("FIRMA_CODCLIEN", firmaElement.getCodclien());
					command2.addParameter("FIRMA_CODCARGO", firmaElement.getCodcargo());
					command2.addParameter("FIRMA_SECUENCIA", firmaElement.getSecuencia());
					ResultSet results2 = command2.executeQuery();
					rowCount = command2.getRowCount();
					if ( results2.hasData() ) {
						firmaElement.setCodclienSus(results2.getStr(0));
						firmaElement.setCodcargoSus(results2.getNumber(1));
					}
					results2.close();
					rellenaSuplentes(firmaElement);








				}
				catch(NoDataFoundException e)
				{
					firmaElement.setCodclienSus(toStr(null));
					firmaElement.setCodcargoSus(toNumber(null));




































				}
				habilitaSustitutos(firmaElement);
			}
		}


	
	/* Original PL/SQL code for Prog Unit VALIDAR_FIRMA
	
	FUNCTION validar_firma RETURN BOOLEAN IS
   v_resultado boolean;   
BEGIN
    IF :temp.v_tipo_firma = 'E' THEN  
        v_resultado := valida_electronica;
    ELSE
        v_resultado := valida_manual;
    END IF;
    
    RETURN v_resultado;
END;
	*/
	//ID:412
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this function was identified as containing business logic. See documentation for details.
/* </p>
		*/
		public NBool validarFirma(FirmaAdapter firmaElement)
		{
			NBool vResultado = NBool.getNull();
			if ( getFormModel().getTemp().getVTipoFirma().equals("E") )
			{
				vResultado = validaElectronica(firmaElement);
			}
			else {
				vResultado = validaManual(firmaElement);
			}
			return  toBool(vResultado);
		}


	
	/* Original PL/SQL code for Prog Unit TRATA_FIRMA_OPCIONAL
	
	PROCEDURE trata_firma_opcional IS
   v_ordfirma    NUMBER:=0;
   v_actual      NUMBER:=0;
BEGIN
    v_actual   := :SYSTEM.TRIGGER_RECORD;
    v_ordfirma := :firma.ordfirma;
    
    go_block('FIRMA');
    first_record;
    LOOP
        IF :firma.ordfirma = v_ordfirma AND v_actual != :SYSTEM.TRIGGER_RECORD THEN
    	      :firma.marcado := 'N';
    	  END IF;      
        
        EXIT WHEN :SYSTEM.LAST_RECORD = 'TRUE';         	
  	    NEXT_RECORD;  	         
    END LOOP;  
    GO_RECORD(v_actual);
END;
	*/
	//ID:413
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		*/
		public void trataFirmaOpcional(FirmaAdapter firmaElement)
		{
			NNumber vOrdfirma = toNumber(0);
			NNumber vActual = toNumber(0);
			vActual = getTriggerRecord();
			vOrdfirma = firmaElement.getOrdfirma();
			goBlock(toStr("FIRMA"));
			firstRecord();
			while (true) {
				if ( firmaElement.getOrdfirma().equals(vOrdfirma) && vActual.notEquals(getTriggerRecord()) )
				{
					firmaElement.setMarcado(toStr("N"));
				}
				if ( isInLastRecord() ) 
					break;
				nextRecord();
			}
			setCurrentRecord(vActual);




		}



	
	/* Original PL/SQL code for Prog Unit VALIDA_ELECTRONICA
	
	FUNCTION valida_electronica RETURN BOOLEAN IS
    v_resultado  BOOLEAN := FALSE;
    v_posicion   NUMBER:=0;
    v_actual     NUMBER:= :system.trigger_record;
BEGIN  
    GO_BLOCK('FIRMA');
    first_record;        
    v_posicion:= v_posicion +1;
    LOOP
        IF firmante_ok THEN
            go_record(v_posicion);
            v_resultado:= TRUE;
            EXIT;
        END IF;      
        
        EXIT WHEN :SYSTEM.LAST_RECORD = 'TRUE';         	
  	    NEXT_RECORD;  	       
  	    v_posicion:= v_posicion +1;  
    END LOOP;   
    
    IF NOT v_resultado THEN
        mostrar_mensaje('Firmantes no definidos para la firma electrónica del documento. Revise e indique los firmantes para poder enviar a firma.', 'I', FALSE);                
    END IF;
               
    -- Vuelvo a la posición inicial y devuelvo el resultado de la validación
    IF NOT v_resultado THEN
        go_record( v_posicion);
    END IF;
    
    RETURN v_resultado; 
END;
  
	*/
	//ID:414
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this function was identified as containing business logic. See documentation for details.
/* </p>
		*/
		public NBool validaElectronica(FirmaAdapter firmaElement)
		{
			NBool vResultado = toBool(NBool.False);
			NNumber vPosicion = toNumber(0);
			NNumber vActual = getTriggerRecord();
			goBlock(toStr("FIRMA"));
			firstRecord();
			vPosicion = vPosicion.add(1);
			while (true) {
				if ( firmanteOk(firmaElement).getValue() )
				{
					setCurrentRecord(vPosicion);
					vResultado = toBool(NBool.True);
						break;
				}
				if ( isInLastRecord() ) 
					break;
				nextRecord();
				vPosicion = vPosicion.add(1);
			}
			if ( vResultado.not() )
			{
				mostrarMensaje(toStr("Firmantes no definidos para la firma electrónica del documento. Revise e indique los firmantes para poder enviar a firma."), toStr("I"), toBool(NBool.False));









			}
			//  Vuelvo a la posición inicial y devuelvo el resultado de la validación
			if ( vResultado.not() )
			{
				setCurrentRecord(vPosicion);

































			}
			return  toBool(vResultado);

		}



	
	/* Original PL/SQL code for Prog Unit VALIDA_MANUAL
	
	FUNCTION VALIDA_MANUAL RETURN BOOLEAN IS
        
    v_resultado  BOOLEAN := FALSE;
    v_posicion   NUMBER  := 0;
    v_actual     NUMBER;

BEGIN  
    GO_BLOCK('FIRMA');
    v_actual := :system.cursor_record;
    first_record;
    v_posicion := 1;

    LOOP
        IF :firma.marcado = 'S' THEN
            IF NOT firmante_ok THEN
                mostrar_mensaje('Complete los datos del firmante seleccionado para el orden de firma: '||:firma.ordfirma ||'.', 'I', FALSE);
                RETURN FALSE;             	
            END IF;
          
        ELSE  
            IF NOT existe_firmante_marcado(:firma.ordfirma, :firma.codcargo) THEN
            	  mostrar_mensaje('Firmante no definido para el orden de firma '||:firma.ordfirma ||' del documento. Revise e indique los firmantes para poder enviar a firma.', 'I', FALSE);
        	      RETURN FALSE;            
            END IF;
            go_record(v_posicion); -- Porque existe_firmante lo modifica
            
        END IF;                	   

        EXIT WHEN :SYSTEM.LAST_RECORD = 'TRUE';

        NEXT_RECORD;
        v_posicion := v_posicion + 1;  	       	  	
    
    END LOOP;   
















































    -- Vuelvo a la posición inicial y devuelvo el resultado de la validación
    
    go_record( v_posicion);
    RETURN TRUE; 
END;
  
	*/
	//ID:415
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this function was identified as containing business logic. See documentation for details.
/* </p>
		*/
		public NBool validaManual(FirmaAdapter firmaElement)
		{
			NBool vResultado = toBool(NBool.False);
			NNumber vPosicion = toNumber(0);
			NNumber vActual = NNumber.getNull();
			goBlock(toStr("FIRMA"));
			vActual = getCursorRecord();
			firstRecord();
			vPosicion = toNumber(1);
























			while (true) {
				if ( firmaElement.getMarcado().equals("S") )
				{
					if ( firmanteOk(firmaElement).not() )
					{
						mostrarMensaje(toStr("Complete los datos del firmante seleccionado para el orden de firma: ").append(firmaElement.getOrdfirma()).append("."), toStr("I"), toBool(NBool.False));
						return  toBool( toBool(NBool.False));
					}
				}
				else {
					if ( existeFirmanteMarcado(firmaElement, toStr(firmaElement.getOrdfirma()), toStr(firmaElement.getCodcargo())).not() )
					{
						mostrarMensaje(toStr("Firmante no definido para el orden de firma ").append(firmaElement.getOrdfirma()).append(" del documento. Revise e indique los firmantes para poder enviar a firma."), toStr("I"), toBool(NBool.False));
						return  toBool( toBool(NBool.False));




					}
					setCurrentRecord(vPosicion);
				}
				if ( isInLastRecord() ) 
					break;
				nextRecord();
				vPosicion = vPosicion.add(1);













			}
			//  Vuelvo a la posición inicial y devuelvo el resultado de la validación
			setCurrentRecord(vPosicion);
			return  toBool( toBool(NBool.True));



		}


	
	/* Original PL/SQL code for Prog Unit EXISTE_FIRMANTE_MARCADO
	
	FUNCTION existe_firmante_marcado (p_orden varchar2, p_cargo varchar2) RETURN BOOLEAN IS
    v_resultado   BOOLEAN:= FALSE;
    v_actual      NUMBER := :system.cursor_record;
BEGIN  
    first_record;            
    LOOP
        IF  :firma.ordfirma = p_orden  
        	AND firmante_ok  
        	AND :firma.codcargo != p_cargo 
        THEN
            v_resultado := TRUE;
            EXIT;
        ELSE           
  	        EXIT WHEN :SYSTEM.LAST_RECORD = 'TRUE';         	
  	        NEXT_RECORD;  	         	    
  	    END IF;               
    END LOOP;       
              
    -- Vuelvo a la posición inicial y devuelvo el resultado de la validación
    go_record( v_actual);
    RETURN v_resultado; 
END;
	*/
	//ID:416
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this function was identified as containing business logic. See documentation for details.
/* </p>
		* @param pOrden
		* @param pCargo
		*/
		public NBool existeFirmanteMarcado(FirmaAdapter firmaElement, NString pOrden, NString pCargo)
		{
			NBool vResultado = toBool(NBool.False);
			NNumber vActual = getCursorRecord();
			firstRecord();
			while (true) {
				if ( firmaElement.getOrdfirma().equals(pOrden) && firmanteOk(firmaElement).getValue() && firmaElement.getCodcargo().notEquals(pCargo) )
				{
					vResultado = toBool(NBool.True);
						break;



































































				}
				else {
					if ( isInLastRecord() ) 
						break;
					nextRecord();























				}





			}
			//  Vuelvo a la posición inicial y devuelvo el resultado de la validación
			setCurrentRecord(vActual);
			return  toBool(vResultado);
		}


	
	/* Original PL/SQL code for Prog Unit FIRMANTE_OK
	
	FUNCTION firmante_ok RETURN BOOLEAN IS

BEGIN
    -- Para que un firmante sea correcto debe estar marcado
    -- y tener cliente y cargo.
    IF    :firma.marcado = 'S'
    	AND :firma.nifclien IS NOT NULL
    	AND :firma.cargo  IS NOT NULL
    THEN
        RETURN TRUE;
    ELSE
    	  RETURN FALSE;
    END IF;   	







END;
	*/
	//ID:417
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this function was identified as containing business logic. See documentation for details.
/* </p>
		*/
		public NBool firmanteOk(FirmaAdapter firmaElement)
		{
			//  Para que un firmante sea correcto debe estar marcado
			//  y tener cliente y cargo.
			if ( firmaElement.getMarcado().equals("S") && firmaElement.getNifclien().isNotNull() && firmaElement.getCargo().isNotNull() )
			{
				return  toBool( toBool(NBool.True));












			}
			else {
				return  toBool( toBool(NBool.False));
			}

		}


	
	/* Original PL/SQL code for Prog Unit RELLENA_SUPLENTES
	
	PROCEDURE RELLENA_SUPLENTES IS
BEGIN

        SELECT clifir.nomfirte, client.nifclien, DECODE(clifir.indsexus, 1, cargos.descargm, cargos.descargf)
          INTO :firma.nomfirte_sus, :firma.nifclien_sus, :firma.cargo_sus
          FROM su_clifir clifir
             , su_client client
             , su_cargos cargos
         WHERE client.codclien = clifir.client_codclien
           AND client_codclien = :firma.codclien_sus
           AND cargos_codcargo = :firma.codcargo_sus
           AND cargos.codcargo = cargos_codcargo
     -- AND clifir.codter_codterri = rc_firmas.codter_codterri
           AND clifir.indactiv = 'S'
           AND trunc(SYSDATE) >= trunc(clifir.fecaltas)
           AND trunc(SYSDATE) <= NVL(trunc(clifir.fecbajas), SYSDATE)
           AND ROWNUM = 1;








































EXCEPTION 
	WHEN OTHERS THEN 
	    :firma.nomfirte_sus := NULL;
    	:firma.nifclien_sus := NULL;
	    :firma.cargo_sus    := NULL;
	
END;
	*/
	//ID:418
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		*/
		public void rellenaSuplentes(FirmaAdapter firmaElement)
		{
			int rowCount = 0;
			try
			{
				String sql1 = "SELECT clifir.nomfirte, client.nifclien, DECODE(clifir.indsexus, 1, cargos.descargm, cargos.descargf) " +
	" FROM su_clifir clifir, su_client client, su_cargos cargos " +
	" WHERE client.codclien = clifir.client_codclien AND client_codclien = :FIRMA_CODCLIEN_SUS AND cargos_codcargo = :FIRMA_CODCARGO_SUS AND cargos.codcargo = cargos_codcargo AND clifir.indactiv = 'S' AND trunc(SYSDATE) >= trunc(clifir.fecaltas) AND trunc(SYSDATE) <= NVL(trunc(clifir.fecbajas), SYSDATE) AND ROWNUM = 1 ";
				DataCommand command1 = new DataCommand(sql1);
				//Setting query parameters
				command1.addParameter("FIRMA_CODCLIEN_SUS", firmaElement.getCodclienSus());
				command1.addParameter("FIRMA_CODCARGO_SUS", firmaElement.getCodcargoSus());
				ResultSet results1 = command1.executeQuery();
				rowCount = command1.getRowCount();
				if ( results1.hasData() ) {
					firmaElement.setNomfirteSus(results1.getStr(0));
					firmaElement.setNifclienSus(results1.getStr(1));
					firmaElement.setCargoSus(results1.getStr(2));




















				}
				results1.close();









			}
			catch(Exception  e)
			{
				firmaElement.setNomfirteSus(toStr(null));
				firmaElement.setNifclienSus(toStr(null));
				firmaElement.setCargoSus(toStr(null));








































			}
		}





	
	/* Original PL/SQL code for Prog Unit PVALIDA_RELACION
	
	PROCEDURE pvalida_relacion IS
    CURSOR c_articulo(pc_descripcion IN VARCHAR2) IS
        SELECT rv_low_value articulo
          FROM cg_ref_codes
         WHERE rv_domain = 'ARTICULO INFRACCION TRIBUTARIA'
           AND rv_meaning = pc_descripcion
         ORDER BY rv_low_value;   
















    CURSOR c_desgrinf(pc_artinftr IN VARCHAR2) IS
        SELECT desgrinf grado
          FROM su_parsan
         WHERE artinftr = pc_artinftr;
    --
    v_encontrado        BOOLEAN;
    v_marcador_valor    VARCHAR2(1000);
    v_fila_actual       NUMBER;
    v_codarticulo       VARCHAR2(1000);
BEGIN
    -- Valida los valores de listas relacionadas
    IF :marcador.marcador = 'ARTICINFR' 
    	AND :temp.codmodel = 'A25'
    THEN 
        -- Obtener grado de infracción para validar
        v_marcador_valor := :marcador.valor;
	      v_fila_actual := :system.cursor_record;
	      first_record;
	      v_encontrado := FALSE;
	      LOOP 
		        IF :marcador.marcador = 'GRADOINFR' THEN
		        	  -- Validar el grado
		        	  IF v_marcador_valor IS NULL	THEN
		        	  	  :marcador.valor := NULL;
		        	  ELSIF v_marcador_valor IS NOT NULL THEN
		        	  	  -- Comprobar que el valor es correcto
		        	  	  v_codarticulo := NULL;
		        	      OPEN c_articulo(v_marcador_valor);
		        	      FETCH c_articulo INTO v_codarticulo;
		        	      CLOSE c_articulo;
		        	      IF v_codarticulo IS NULL THEN
		        	      	  :marcador.valor := NULL;
		        	      ELSE
	      	             FOR r_desgrinf IN c_desgrinf(v_codarticulo) LOOP
	      	             	   IF TRIM(:marcador.valor) = TRIM(r_desgrinf.grado) THEN
	      	             	   	  v_encontrado := TRUE;
	      	             	   	  EXIT;
	      	             	   END IF;
	      	             END LOOP;
	      	             IF NOT v_encontrado THEN
	      	             	   :marcador.valor := NULL;
	      	             END IF;
		        	      END IF;
		        	  END IF;
		            v_encontrado := TRUE;
		        END IF;
		        EXIT WHEN :SYSTEM.last_record='TRUE' OR v_encontrado;
        
            next_record;

	      END LOOP;
	      go_record(v_fila_actual);
	  END IF;
END;
	*/
	//ID:419
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		*/
		public void pvalidaRelacion(MarcadorAdapter marcadorElement)
		{
			int rowCount = 0;
			String sqlcArticulo = "SELECT rv_low_value articulo " +
	" FROM cg_ref_codes " +
	" WHERE rv_domain = 'ARTICULO INFRACCION TRIBUTARIA' AND rv_meaning = :P_PC_DESCRIPCION " +
	" ORDER BY rv_low_value";
			DataCursor cArticulo = new DataCursor(sqlcArticulo);
			NString cArticuloPcDescripcion = NString.getNull();
			String sqlcDesgrinf = "SELECT desgrinf grado " +
	" FROM su_parsan " +
	" WHERE artinftr = :P_PC_ARTINFTR ";
			DataCursor cDesgrinf = new DataCursor(sqlcDesgrinf);
			NString cDesgrinfPcArtinftr = NString.getNull();
			// 
			NBool vEncontrado = NBool.getNull();
			NString vMarcadorValor = NString.getNull();
			NNumber vFilaActual = NNumber.getNull();
			NString vCodarticulo = NString.getNull();
			try {
				//  Valida los valores de listas relacionadas
				if ( marcadorElement.getMarcador().equals("ARTICINFR") && getFormModel().getTemp().getCodmodel().equals("A25") )
				{
					//  Obtener grado de infracción para validar
					vMarcadorValor = marcadorElement.getValor();
					vFilaActual = getCursorRecord();
					firstRecord();
					vEncontrado = toBool(NBool.False);
					while (true) {
						if ( marcadorElement.getMarcador().equals("GRADOINFR") )
						{
							//  Validar el grado
							if ( vMarcadorValor.isNull() )
							{
								marcadorElement.setValor(toStr(null));
























							}
							else if ( vMarcadorValor.isNotNull() ) {
								//  Comprobar que el valor es correcto
								vCodarticulo = toStr(null);
								cArticuloPcDescripcion = vMarcadorValor;
								//Setting query parameters
								cArticulo.addParameter("P_PC_DESCRIPCION", cArticuloPcDescripcion);
								//F2J_WARNING : Make sure that the method "Close" is being called over the variable cArticulo.
								cArticulo.open();
								ResultSet cArticuloResults = cArticulo.fetchInto();
								if ( cArticuloResults != null ) {
									vCodarticulo = cArticuloResults.getStr(0);
								}
								cArticulo.close();
								if ( vCodarticulo.isNull() )
								{
									marcadorElement.setValor(toStr(null));
								}
								else {
									cDesgrinfPcArtinftr = vCodarticulo;
									//Setting query parameters
									cDesgrinf.addParameter("P_PC_ARTINFTR", cDesgrinfPcArtinftr);
									try
									{
										cDesgrinf.open();
										while (true)
										{
											TableRow rDesgrinf = cDesgrinf.fetchRow();
											if ( cDesgrinf.notFound() ) break;
											if ( trim(marcadorElement.getValor()).equals(trim(rDesgrinf.getStr("grado"))) )
											{
												vEncontrado = toBool(NBool.True);
													break;
											}
										}
									}finally{
										cDesgrinf.close();
									}
									if ( vEncontrado.not() )
									{
										marcadorElement.setValor(toStr(null));
									}





								}
							}
							vEncontrado = toBool(NBool.True);
						}
						if ( isInLastRecord() || vEncontrado.getValue() ) 
							break;
						nextRecord();
					}
					setCurrentRecord(vFilaActual);
				}
				}finally{
					cArticulo.close();
				}
		}

	
	/* Original PL/SQL code for Prog Unit PRE_CONTROL_FIRMA
	
	FUNCTION PRE_CONTROL_FIRMA 
RETURN BOOLEAN 
IS
    -- Cod. territorial del usuario
    v_codterri     su_codter.codterri%TYPE := kusuari.fcodter;
    -- Unidad administrativa del usuario
    v_coduniad     su_uniadm.coduniad%TYPE := kusuari.funiadm;    
    v_tiene_firma  NUMBER := 0;

    CURSOR c_tipo_firma IS
       SELECT rv_low_value, rv_abbreviation, rv_meaning
         FROM cg_ref_codes
        WHERE rv_domain = 'TIPO FIRMA'
        ORDER BY rv_low_value;
     
    r_tipo_firma c_tipo_firma%ROWTYPE;
    
BEGIN
    OPEN c_tipo_firma;
    LOOP
    	  FETCH c_tipo_firma INTO r_tipo_firma;
    	  EXIT WHEN c_tipo_firma%NOTFOUND OR v_tiene_firma = 1;
        v_tiene_firma :=  kfirma.fexisfirm (:temp.codmodel, :temp.numvermo, v_codterri
                                           , v_coduniad, r_tipo_firma.rv_low_value);
    END LOOP;
    CLOSE c_tipo_firma;
    IF v_tiene_firma = 0 THEN
        RETURN FALSE;
    ELSE
    	  RETURN TRUE;
    END IF;
END;
	*/
	//ID:420
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this function was identified as containing business logic. See documentation for details.
/* </p>
		*/
		public NBool preControlFirma()
		{
			int rowCount = 0;
			//  Cod. territorial del usuario
			NString vCodterri = Kusuari.fcodter();
			//  Unidad administrativa del usuario
			NString vCoduniad = Kusuari.funiadm();
			NNumber vTieneFirma = toNumber(0);
			String sqlcTipoFirma = "SELECT rv_low_value, rv_abbreviation, rv_meaning " +
	" FROM cg_ref_codes " +
	" WHERE rv_domain = 'TIPO FIRMA' " +
	" ORDER BY rv_low_value";
			DataCursor cTipoFirma = new DataCursor(sqlcTipoFirma);
			TableRow rTipoFirma = null;
			try {
				//F2J_WARNING : Make sure that the method "Close" is being called over the variable cTipoFirma.
				cTipoFirma.open();
				while (true) {
					rTipoFirma = cTipoFirma.fetchRow();
					if ( cTipoFirma.notFound() || vTieneFirma.equals(1) ) 
						break;
					vTieneFirma = Kfirma.fexisfirm(getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getNumvermo(), vCodterri, vCoduniad, rTipoFirma.getStr("rv_low_value"));
				}
				cTipoFirma.close();
				if ( vTieneFirma.equals(0) )
				{
					return  toBool( toBool(NBool.False));
				}
				else {
					return  toBool( toBool(NBool.True));
				}
				}finally{
					cTipoFirma.close();
				}




		}


	
	/* Original PL/SQL code for Prog Unit PIMPRESION_DIRECTA
	
	PROCEDURE pimpresion_directa (p_idopcion IN VARCHAR2) IS
    p_estado           PLS_INTEGER;
    v_url              VARCHAR2(25000);
    v_tabla_parametros kintcomu.ta_tabla ;    
    v_servicio         VARCHAR2(80);
    v_resultado NUMBER;
    v_txterror VARCHAR2(500);

BEGIN
    mostrar_canvas_impresion;

    IF NOT k000810.fexispdf(:temp.codmodel, :temp.numvermo, :temp.numerdoc) THEN
        crea_pdf(:temp.codmodel, :temp.numvermo, :temp.numerdoc, :temp.operacion, :temp.plantilla, p_estado);
        IF p_estado != 200 THEN
            :GLOBAL.ret_810  := 0;
            do_key('Exit_Form');
        END IF;
    END IF;

    v_resultado := KVISORDOC.FURLVISOR(:temp.codmodel, :temp.numvermo, :temp.numerdoc, p_idopcion, v_servicio, v_url, v_txterror) ;
      
    SET_CUSTOM_ITEM_PROPERTY('MI_BLOQUE.IMPRIME','HTTP_GET_PRINT',v_url);
END;





	*/
	//ID:421
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		* @param pIdopcion
		*/
		public void pimpresionDirecta(NString pIdopcion)
		{
			NInteger pEstado = NInteger.getNull();
			NString vUrl = NString.getNull();
			Kintcomu.TaTabla vTablaParametros = new Kintcomu.TaTabla();
			NString vServicio = NString.getNull();
			NNumber vResultado = NNumber.getNull();
			NString vTxterror = NString.getNull();
			mostrarCanvasImpresion();
			if ( K000810.fexispdf(getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getNumvermo(), getFormModel().getTemp().getNumerdoc()).not() )
			{
				Ref<NString> pPlantilla_ref = new Ref<NString>(getFormModel().getTemp().getPlantilla());
				Ref<NInteger> pEstado_ref = new Ref<NInteger>(pEstado);
				creaPdf(getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getNumvermo(), getFormModel().getTemp().getNumerdoc(), getFormModel().getTemp().getOperacion(), pPlantilla_ref, pEstado_ref);
				getFormModel().getTemp().setPlantilla(pPlantilla_ref.val);
				pEstado = pEstado_ref.val;
				if ( pEstado.notEquals(200) )
				{
					setGlobal("RET_810", toStr(0));
					executeAction(KeyFunction.EXIT);
				}



			}
			Ref<NString> p_servicio_ref = new Ref<NString>(vServicio);
			Ref<NString> p_url_ref = new Ref<NString>(vUrl);
			Ref<NString> p_txterror_ref = new Ref<NString>(vTxterror);
			vResultado = Kvisordoc.furlvisor(getFormModel().getTemp().getCodmodel(), getFormModel().getTemp().getNumvermo(), getFormModel().getTemp().getNumerdoc(), pIdopcion, p_servicio_ref, p_url_ref, p_txterror_ref);
			vServicio = p_servicio_ref.val;
			vUrl = p_url_ref.val;
			vTxterror = p_txterror_ref.val;
			showDocument(vUrl, "_blank");
			// F2J_NOT_SUPPORTED : The property "CUSTOM_ITEM's "HTTP_GET_PRINT"" is not supported. See documentation for details.
			//			SupportClasses.FORMS40.SetCustomItemProperty("MI_BLOQUE.IMPRIME", "HTTP_GET_PRINT", vUrl);
			this.getLogger().trace(this, "// F2J_NOT_SUPPORTED : The property 'CUSTOM_ITEM's 'HTTP_GET_PRINT'' is not supported. See documentation for details.");
			
		}


	
	/* Original PL/SQL code for Prog Unit GENERA_DA0
	
	PROCEDURE genera_DA0 IS
    v_resultado     NUMBER;
    v_mensaje       VARCHAR2(300);  
    v_codmodel_da0  su_docuni.vermod_codmodel%type;
    v_numvermo_da0  su_docuni.vermod_numvermo%type;
    v_numerdoc_da0  su_docuni.numerdoc%type;
    v_numordtr      NUMBER;
    v_etitramit     NUMBER;
    v_codtrami      VARCHAR2(300);
    v_error         VARCHAR2(2000); 
    v_conteo_escrit NUMBER:= 0;
BEGIN
	
 
    --tratamiento_firma;
    -- Se obtiene el número de documento que se ha generado previamente.
    v_codmodel_da0:= :parameter.p_codmodel;
    v_numvermo_da0:= :parameter.p_numvermo;
    v_numerdoc_da0:= :parameter.p_numerdoc;  
    
    -- Obtenemos el trámite de la generación de propuesta.  
    IF NOT k03datex.fpropdev( :parameter.p_expedi_codcircu, :parameter.p_expedi_codterri, :parameter.p_expedi_ejeexped, :parameter.p_expedi_numexped
                            , v_numordtr, v_etitramit, v_codtrami, v_error) 
    THEN                   
      
        mostrar_mensaje(v_error, 'I', TRUE);
    END IF;
    
    pgenda0G( NULL, NULL, NULL
           , :parameter.p_expedi_codcircu, :parameter.p_expedi_codterri, :parameter.p_expedi_ejeexped
           , :parameter.p_expedi_numexped, v_numordtr, 'E', 'D', v_resultado, v_mensaje
           , v_codmodel_da0, v_numvermo_da0, v_numerdoc_da0, TRUE);   
              
    IF v_resultado != 0 THEN    
        mostrar_mensaje(v_mensaje, 'I', TRUE);
    END IF;
     
    -- Asociamos el documento a escrit y al expediente
    UPDATE su_escrit
       SET numordtr        = :parameter.p_numordtr
     WHERE docuni_codmodel = :temp.codmodel
       AND docuni_numvermo = :temp.numvermo
       AND docuni_numerdoc = :temp.numerdoc;

    
    :GLOBAL.ret_810  :='0';

    mostrar_mensaje( ' El documento ' ||:parameter.p_codmodel ||'-'||:parameter.p_numvermo||'-'||:parameter.p_numerdoc 
                   ||' se ha enviado a firma electrónica.', 'I', FALSE); 
 
    activa_botones ('MI_BLOQUE',FALSE,FALSE,FALSE,FALSE, FALSE, TRUE,FALSE);
	  
   
                    
EXCEPTION
    WHEN OTHERS THEN
        mostrar_mensaje('SUR-02000 #1'|| 'Error al generar el documento: '||:parameter.p_codmodel||' '||:parameter.p_numvermo||' '||:parameter.p_numerdoc ||' #2 ' ,'E',TRUE);                                                                                          
END;
	*/
	//ID:422
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this procedure was identified as containing business logic. See documentation for details.
/* </p>
		*/
		public void generaDa0()
		{
			int rowCount = 0;
			NNumber vResultado = NNumber.getNull();
			NString vMensaje = NString.getNull();
			NString vCodmodelDa0 = NString.getNull();
			NString vNumvermoDa0 = NString.getNull();
			NString vNumerdocDa0 = NString.getNull();
			Ref<NNumber> p_numordtr_ref = new Ref<NNumber>();
			Ref<NNumber> p_etitrami_ref = new Ref<NNumber>();
			Ref<NString> p_codtrami_ref = new Ref<NString>();
			Ref<NString> p_error_ref = new Ref<NString>();
			NNumber vConteoEscrit = toNumber(0);
			try
			{
				// tratamiento_firma;
				//  Se obtiene el número de documento que se ha generado previamente.
				vCodmodelDa0 = this.getFormModel().getParam("P_CODMODEL", NString.class);
				vNumvermoDa0 = this.getFormModel().getParam("P_NUMVERMO", NString.class);
				vNumerdocDa0 = this.getFormModel().getParam("P_NUMERDOC", NString.class);
				//  Obtenemos el trámite de la generación de propuesta.  
				if ( K03datex.fpropdev(this.getFormModel().getParam("P_EXPEDI_CODCIRCU", NString.class), this.getFormModel().getParam("P_EXPEDI_CODTERRI", NString.class), toNumber(this.getFormModel().getParam("P_EXPEDI_EJEEXPED", NString.class)), toNumber(this.getFormModel().getParam("P_EXPEDI_NUMEXPED", NString.class)), p_numordtr_ref, p_etitrami_ref, p_codtrami_ref, p_error_ref).not() )
				{
					mostrarMensaje(p_error_ref.val, toStr("I"), toBool(NBool.True));
				}
				Ref<NNumber> p_resultado_ref = new Ref<NNumber>(vResultado);
				Ref<NString> p_mensaje_ref = new Ref<NString>(vMensaje);
				Ref<NString> p_codmodel_da0_ref = new Ref<NString>(vCodmodelDa0);
				Ref<NString> p_numvermo_da0_ref = new Ref<NString>(vNumvermoDa0);
				Ref<NString> p_numerdoc_da0_ref = new Ref<NString>(vNumerdocDa0);
				StoredProcedures.pgenda0g(toStr(null), toStr(null), toStr(null), this.getFormModel().getParam("P_EXPEDI_CODCIRCU", NString.class), this.getFormModel().getParam("P_EXPEDI_CODTERRI", NString.class), toNumber(this.getFormModel().getParam("P_EXPEDI_EJEEXPED", NString.class)), toNumber(this.getFormModel().getParam("P_EXPEDI_NUMEXPED", NString.class)), p_numordtr_ref.val, toStr("E"), toStr("D"), p_resultado_ref, p_mensaje_ref, p_codmodel_da0_ref, p_numvermo_da0_ref, p_numerdoc_da0_ref, toBool(NBool.True),toNumber(null));
				vResultado = p_resultado_ref.val;
				vMensaje = p_mensaje_ref.val;
				vCodmodelDa0 = p_codmodel_da0_ref.val;
				vNumvermoDa0 = p_numvermo_da0_ref.val;
				vNumerdocDa0 = p_numerdoc_da0_ref.val;
				if ( vResultado.notEquals(0) )
				{
					mostrarMensaje(vMensaje, toStr("I"), toBool(NBool.True));
				}
				//  Asociamos el documento a escrit y al expediente
				String sql1 = "UPDATE su_escrit " +
	"SET numordtr = :PARAMETER_P_NUMORDTR " +
	" WHERE docuni_codmodel = :TEMP_CODMODEL AND docuni_numvermo = :TEMP_NUMVERMO AND docuni_numerdoc = :TEMP_NUMERDOC";
				DataCommand command1 = new DataCommand(sql1);
				//Setting query parameters
				command1.addParameter("PARAMETER_P_NUMORDTR", this.getFormModel().getParam("P_NUMORDTR", NString.class));
				command1.addParameter("TEMP_CODMODEL", getFormModel().getTemp().getCodmodel());
				command1.addParameter("TEMP_NUMVERMO", getFormModel().getTemp().getNumvermo());
				command1.addParameter("TEMP_NUMERDOC", getFormModel().getTemp().getNumerdoc());
				rowCount = command1.execute();
				setGlobal("RET_810", toStr("0"));
				mostrarMensaje(toStr(" El documento ").append(this.getFormModel().getParam("P_CODMODEL", NString.class)).append("-").append(this.getFormModel().getParam("P_NUMVERMO", NString.class)).append("-").append(this.getFormModel().getParam("P_NUMERDOC", NString.class)).append(" se ha enviado a firma electrónica."), toStr("I"), toBool(NBool.False));
				getTask().getSur().activaBotones(toStr("MI_BLOQUE"), toBool(NBool.False), toBool(NBool.False), toBool(NBool.False), toBool(NBool.False), toBool(NBool.False), toBool(NBool.True), toBool(NBool.False));
			}
			catch(Exception  e)
			{
				mostrarMensaje(toStr("SUR-02000 #1").append("Error al generar el documento: ").append(this.getFormModel().getParam("P_CODMODEL", NString.class)).append(" ").append(this.getFormModel().getParam("P_NUMVERMO", NString.class)).append(" ").append(this.getFormModel().getParam("P_NUMERDOC", NString.class)).append(" #2 "), toStr("E"), toBool(NBool.True));
			}
		}
















	
	/* Original PL/SQL code for Prog Unit MIPVISORWEB
	
	FUNCTION mipvisorweb(p_codmodel IN VARCHAR2,
                     p_numvermo IN VARCHAR2,
                     p_numerdoc IN VARCHAR2,
                     p_idopcion IN VARCHAR2)
RETURN BOOLEAN IS
BEGIN
    -- Llama a PVISORWEB de la librería SURIMP. Este procedimiento hace el W EB.SHOW_DOCUMENT
    PVISORWEB(p_codmodel, p_numvermo, p_numerdoc, p_idopcion);
    RETURN TRUE;
EXCEPTION 
    WHEN OTHERS THEN 
        mostrar_mensaje(SUBSTR(SQLERRM, 1, 250), 'E', FALSE);
        RETURN FALSE;
END;
	*/
	//ID:423
	/* <p>
		* F2J_PURE_BUSINESS_LOGIC : The code of this function was identified as containing business logic. See documentation for details.
/* </p>
		* @param pCodmodel
		* @param pNumvermo
		* @param pNumerdoc
		* @param pIdopcion
		*/
		public NBool mipvisorweb(NString pCodmodel, NString pNumvermo, NString pNumerdoc, NString pIdopcion)
		{
			try
			{
				//  Llama a PVISORWEB de la librería SURIMP. Este procedimiento hace el W EB.SHOW_DOCUMENT
				getTask().getSurimp().pvisorweb(pCodmodel, pNumvermo, pNumerdoc, pIdopcion);
				return  toBool( toBool(NBool.True));






































			}
			catch(Exception  e)
			{
				mostrarMensaje(substring(errorMessage(), toInt(1), toInt(250)), toStr("E"), toBool(NBool.False));
				return  toBool( toBool(NBool.False));
















			}



























		}


	
	































}
