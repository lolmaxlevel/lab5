package managers;

import myCollection.Product;
import utils.ListHolder;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.ArrayList;


public class FileManager {
    public FileManager() {}
    public static void saveToFile(String filePath, CollectionManager collectionManager) throws JAXBException, FileNotFoundException {
        ListHolder holder = new ListHolder();
        holder.setList(collectionManager.getCollection());
        String listXML = marshalIt(holder);
        final OutputStream os = new FileOutputStream(filePath+"collection.xml");
        final PrintStream printStream = new PrintStream(os);
        printStream.print(listXML);
        printStream.close();
    }
    public static ArrayList<Product> loadFromFile(String filePath) throws JAXBException {
        StringBuilder listXML = new StringBuilder();
        File file;
        if (filePath.endsWith(".xml"))
            file = new File(filePath);
        else
            file = new File(filePath + "collection.xml");

        try (InputStream in = new FileInputStream(file))
        {
            int content;
            while ((content = in.read()) != -1) {
                listXML.append((char) content);
            }
        } catch (IOException e) {
            System.out.println("Не удалось открыть файл(проверьте верный ли путь и права доступа к файлу)");
            return new ArrayList<>();
        }
        ListHolder newHolder = (ListHolder) unmarshalIt(ListHolder.class, listXML.toString());
        return newHolder.getList();
    }

    public static String marshalIt(Object objectName) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(objectName.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter writer = new StringWriter();
        marshaller.marshal(objectName, writer);

        return writer.toString();

    }

    public static Object unmarshalIt(Class<?> className, String xml) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(className);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        StringReader reader = new StringReader(xml);

        return unmarshaller.unmarshal(reader);

    }
}
