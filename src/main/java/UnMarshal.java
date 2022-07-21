import Helper.properties.PropertiesEnum;
import Helper.properties.XmlValidator;
import model.Year;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class UnMarshal {
    public static Year getYear() {
        try {
            XmlValidator.check(PropertiesEnum.XML_FILE.getPath(), PropertiesEnum.XSD_SCHEMA.getPath());
            JAXBContext jc = JAXBContext.newInstance(Year.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            FileReader reader = new FileReader(PropertiesEnum.XML_FILE.getPath());
            return (Year) unmarshaller.unmarshal(reader);
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(UnMarshal.getYear());
    }

}