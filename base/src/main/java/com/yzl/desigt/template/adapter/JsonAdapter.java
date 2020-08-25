package com.yzl.desigt.template.adapter;

public class JsonAdapter implements IJsonDocument {

    private XmlDocument xmlDocument;

    public JsonAdapter(XmlDocument xmlDocument) {
        this.xmlDocument = xmlDocument;
    }

    @Override
    public Document createJsonDocument() {
        Document document =  xmlDocument.createXmlDpcument();
        System.out.println("将xml的文档转换为Json文档");
        document.setType("json文档");
        return  document;
    }
}
