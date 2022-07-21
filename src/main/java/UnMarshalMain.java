import Helper.properties.PropertiesEnum;
import model.Year;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class UnMarshalMain {
    public static void main(String[ ] args) {
        try {
            JAXBContext jc = JAXBContext.newInstance(Year.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            FileReader reader = new FileReader(PropertiesEnum.XML_FILE.getPath());
            Year year = (Year) unmarshaller.unmarshal(reader);
            System.out.println(year);
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}