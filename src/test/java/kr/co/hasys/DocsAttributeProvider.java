package kr.co.hasys;

import org.springframework.restdocs.snippet.Attributes;

import static org.springframework.restdocs.snippet.Attributes.key;

public interface DocsAttributeProvider {
    static Attributes.Attribute getExampleAttribute(Object example) {
        return key("example").value(example);
    }
}
