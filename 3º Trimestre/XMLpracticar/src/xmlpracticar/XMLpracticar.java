package xmlpracticar;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLpracticar {

    public static void main(String[] args) {
        File fichero = new File("pruebaDocumento.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        String[] nombres = {"AGUSTIN SALGADO", "ELISABETH BONET", "MARIA JOSEFA LOZANO"};
        String[] genero = {"HOMBRE", "MUJER", "MUJER"};
        String[] calles = {"CARRETERA HORNO, 60", "CALLEJA REAL, 45", "RONDA NUEVA, 62"};
        String[] numeros = {"707032137", "689089135", "787768919"};

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document documento = db.newDocument();

            Element raiz = documento.createElement("raiz");
            raiz.setAttribute("version", "1");
            raiz.setAttribute("xmlns", "http://xspf.org/ns/0/");
            documento.appendChild(raiz);

            for (int i = 0; i < nombres.length; i++) {
                Element nombrePersona = documento.createElement("NombreGente");
                Element nombreCalle = documento.createElement("Calle");
                Element numero = documento.createElement("Numero");

                nombrePersona.setTextContent(nombres[i]);
                nombrePersona.setAttribute("genero", genero[i]);
                raiz.appendChild(nombrePersona);

                nombreCalle.setTextContent(calles[i]);
                nombrePersona.appendChild(nombreCalle);

                numero.setTextContent(numeros[i]);
                nombrePersona.appendChild(numero);
            }

            TransformerFactory tf = TransformerFactory.newInstance();
            try {
                Transformer prueba = tf.newTransformer();
                prueba.setOutputProperty(OutputKeys.INDENT, "yes");
                prueba.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

                StreamResult resultado = new StreamResult(new File(fichero.getAbsolutePath()));
                DOMSource ruta = new DOMSource(documento);

                try {
                    prueba.transform(ruta, resultado);
                } catch (TransformerException ex) {
                    Logger.getLogger(XMLpracticar.class.getName()).log(Level.SEVERE, null, ex);
                }

            } catch (TransformerConfigurationException ex) {
                Logger.getLogger(XMLpracticar.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLpracticar.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document documento = db.parse(fichero);

            // Obtener el nodo raíz
            Element raiz = documento.getDocumentElement();

            // Obtener la lista de nodos "NombreGente"
            NodeList nodeList = raiz.getChildNodes();

            // Recorrer la lista de nodos "NombreGente"
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nodo = nodeList.item(i);

                // Verificar si el nodo es de tipo Element
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element nombrePersona = (Element) nodo;
                    String nombre = nombrePersona.getTextContent();
                    String generos = nombrePersona.getAttribute("genero");
                    
                    // Obtener los nodos hijo de nombrePersona
                    NodeList hijosNombrePersona = nombrePersona.getChildNodes();
                    String calle = "";
                    String numero = "";
                    
                    // Recorrer los nodos hijo de nombrePersona
                    for (int j = 0; j < hijosNombrePersona.getLength(); j++) {
                        Node hijo = hijosNombrePersona.item(j);
                        
                        // Verificar si el hijo es de tipo Element y tiene el nombre deseado
                        if (hijo.getNodeType() == Node.ELEMENT_NODE && hijo.getNodeName().equals("Calle")) {
                            calle = hijo.getTextContent();
                        } else if (hijo.getNodeType() == Node.ELEMENT_NODE && hijo.getNodeName().equals("Numero")) {
                            numero = hijo.getTextContent();
                        }
                    }
                    
                    // Imprimir los datos
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Genero: "+ generos);
                    System.out.println("Calle: " + calle);
                    System.out.println("Número: " + numero);
                    System.out.println("-------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
