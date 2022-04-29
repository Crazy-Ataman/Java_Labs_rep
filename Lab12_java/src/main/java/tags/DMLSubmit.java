package tags;

import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

import java.io.IOException;

public class DMLSubmit extends TagSupport {
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public int doStartTag() {
        String output = String.format("<input type=\"submit\" value=\"%s\">", text);
        JspWriter out = pageContext.getOut();
        try {
            out.print(output);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return EVAL_BODY_INCLUDE;
    }
}
