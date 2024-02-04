package pruebaficheroxml;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.SAXException;

public class PruebaFicheroXML {

    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            System.out.println("¡Error! No se ha podido cargar el documento XML.");
        }

        try {
            Document documento = db.parse("pedido.xml");
            File f = new File("pedido2.0.xml");
            TransformerFactory transformer = TransformerFactory.newInstance();
            try {
                Transformer prueba = transformer.newTransformer();

                prueba.setOutputProperty(OutputKeys.INDENT, "yes");
                prueba.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

                StreamResult result = new StreamResult(f);
                DOMSource source = new DOMSource(documento);
//---------------------------------------------------------------- Obtener el elemento raíz del documento.
                Element raiz = documento.getDocumentElement();
//---------------------------------------------------------------- Buscar un elemento en toda la jerarquía del documento
                NodeList listaNodos = documento.getElementsByTagName("cliente");
                Element cliente;
                if (listaNodos.getLength() == 1) {
                    cliente = (Element) listaNodos.item(0);
                }
//---------------------------------------------------------------- Añadir un nuevo elemento hijo a otro elemento
                Element direccionTag = documento.createElement("DIRECCION_ENTREGA");
                Text direccionTxt = documento.createTextNode("C/Zaidín S/N");
                direccionTag.appendChild(direccionTxt);
                documento.getDocumentElement().appendChild(direccionTag);
//---------------------------------------------------------------- Obtener la lista de hijos de un elemento y procesarla.               
                NodeList listaNodos2 = documento.getDocumentElement().getChildNodes();
                for (int i = 0; i < listaNodos2.getLength(); i++) {
                    Node nodo = listaNodos2.item(i);
                    switch (nodo.getNodeType()) {
                        case Node.ELEMENT_NODE:
                            Element elemento = (Element) nodo;
                            System.out.println("Etiqueta:" + elemento.getTagName());
                            break;
                        case Node.TEXT_NODE:
                            Text texto = (Text) nodo;
                            System.out.println("Texto:" + texto.getWholeText());
                            break;
                    }
                }
//----------------------------------------------------------------- Eliminar un elemento hijo de otro elemento.
                NodeList listaNodos3 = documento.getElementsByTagName("DIRECCION_ENTREGA");
                for (int i = 0; i < listaNodos3.getLength(); i++) {
                    Element elemento = (Element) listaNodos3.item(i);
                    Element padre = (Element) elemento.getParentNode();
                    padre.removeChild(elemento);
                }
//----------------------------------------------------------------- Cambiar el contenido de un elemento cuando solo es texto.
//                Element nuevo = documento.createElement("DIRECCION_RECOGIDA").setTextContent("C / Del Medio S/N");
//                System.out.println(nuevo.getTextContent());

//------------------------------------------------------------------ Manejar los atributos de un elemento.
                //Se crea el atributo “urgente” y se consulta
                documento.getDocumentElement().setAttribute("urgente", "no");
                System.out.println(documento.getDocumentElement().getAttribute("urgente"));
                //Se elimina el atributo “urgente”
                documento.getDocumentElement().removeAttribute("urgente");

                
                
                
                try {
                    prueba.transform(source, result);
                } catch (TransformerException ex) {
                    Logger.getLogger(PruebaFicheroXML.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (TransformerConfigurationException ex) {
                Logger.getLogger(PruebaFicheroXML.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SAXException ex) {
            System.out.println("¡Error! No se ha podido cargar el documento XML.");
        } catch (IOException ex) {
            System.out.println("¡Error! No se ha podido cargar el documento XML.");
        }

    }

}
