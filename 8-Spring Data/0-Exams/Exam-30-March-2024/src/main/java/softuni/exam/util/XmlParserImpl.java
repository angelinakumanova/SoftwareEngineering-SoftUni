package softuni.exam.util;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@Component
public class XmlParserImpl implements XmlParser {


    @Override
    public <T> T fromFile(String filePath, Class<T> tClass) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(tClass);

            return (T) jaxbContext.createUnmarshaller().unmarshal(new File(filePath));
        } catch (JAXBException e) {
            System.err.println(e.getMessage());
        }

        return null;
    }
}
