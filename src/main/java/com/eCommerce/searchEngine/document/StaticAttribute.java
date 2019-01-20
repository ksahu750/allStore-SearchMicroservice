package com.eCommerce.searchEngine.document;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName = "product")
public class StaticAttribute {
    @Id
    @Indexed(name = "attribute", type = "string")
    private String attribute;

    @Field
    @Indexed(name = "attributeDescription", type = "string")
    private String attributeDescription;

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getAttributeDescription() {
        return attributeDescription;
    }

    public void setAttributeDescription(String attributeDescription) {
        this.attributeDescription = attributeDescription;
    }
}
