package pkubatis.toolkit;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "data")
public class DicXmlResult {
    private List<DicXmlDto> list;

    public List<DicXmlDto> getList() {
        return list;
    }

    @XmlElement(name="row")
    public void setList(List<DicXmlDto> list) {
        this.list = list;
    }

    @XmlRootElement(name="row")
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
    @XmlType(name = "", propOrder = {
            "aspell",
            "spell",
            "text",
            "code"
    })
    public static class DicXmlDto{
        @XmlAttribute(name="DIC_CODE")
        private String code;
        @XmlAttribute(name="DIC_TEXT")
        private String text;
        @XmlAttribute(name="DIC_SPELL")
        private String spell;
        @XmlAttribute(name="DIC_ASPELL")
        private String aspell;
        public String getCode() {
            return code;
        }
        public void setCode(String code) {
            this.code = code;
        }
        public String getText() {
            return text;
        }
        public void setText(String text) {
            this.text = text;
        }
        public String getSpell() {
            return spell;
        }
        public void setSpell(String spell) {
            this.spell = spell;
        }
        public String getAspell() {
            return aspell;
        }
        public void setAspell(String aspell) {
            this.aspell = aspell;
        }
    }
}
