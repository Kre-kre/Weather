package Helper.properties;

public enum PropertiesEnum {
    XML_FILE("yearXml"),
    XSD_SCHEMA("yearXsd"),

    ;

    private final String path;

    public String getPath() { return PropertiesReader.getProperties(this.path);
    }

    PropertiesEnum(String path) {
        this.path = path;
    }
}
