package managers;

import myCollection.Product;
import utils.ListHolder;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.ArrayList;

/**
 * класс для работы с файлами(чтения и записи коллекции в файл)
 */

public class FileManager {

    public FileManager() {}

    /**
     * функция, которая сохраняет коллекцию в файл
     *
     * @param collectionManager менеджер коллекции откуда брать коллекцию
     * @param filepath путь к месту куда нужно сохранить коллекцию
     * @throws JAXBException         исключение, которое вызывается если что-то не так с коллекцией
     * @throws FileNotFoundException исключение, которое вызывается если что-то не так с файлом(нет прав или файла)
     */
    public static void saveToFile(CollectionManager collectionManager, String filepath) throws JAXBException, FileNotFoundException {
        ListHolder holder = new ListHolder();
        holder.setList(collectionManager.getCollection());
        String listXML = marshalIt(holder);
        final OutputStream os = new FileOutputStream(filepath+"collection.xml");
        final PrintStream printStream = new PrintStream(os);
        printStream.print(listXML);
        printStream.close();
    }
    /**
     * функция, которая загружает коллекцию из файла
     * @param filePath путь к файлу
     * @throws JAXBException исключение, которое вызывается если что-то не так с коллекцией
     * @return коллекция, прочитанная из файла
     */
    public static ArrayList<Product> loadFromFile(String filePath) throws JAXBException {
        defaultPath = (filePath.endsWith(".xml")) ? filePath : filePath+"collection.xml";
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

    /**
     * дополнительная функция преобразования коллекции в текст
     * @param objectName объект коллекции который нужно сохранить
     * @return текстовое представление того что нужно сохранить
     * @throws JAXBException вызывается если невозможно преобразовать коллекцию в текст
     */
    public static String marshalIt(Object objectName) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(objectName.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter writer = new StringWriter();
        marshaller.marshal(objectName, writer);

        return writer.toString();

    }

    /**
     * дополнительная функция которая преобразует текст в коллекции
     * @param className объект коллекции
     * @param xml строка из которой нужно сделать коллекции
     * @return объект коллекции
     * @throws JAXBException вызывается если невозможно преобразовать текст в коллекцию
     */
    public static Object unmarshalIt(Class<?> className, String xml) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(className);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        StringReader reader = new StringReader(xml);

        return unmarshaller.unmarshal(reader);

    }

    static String defaultPath = "";
}
