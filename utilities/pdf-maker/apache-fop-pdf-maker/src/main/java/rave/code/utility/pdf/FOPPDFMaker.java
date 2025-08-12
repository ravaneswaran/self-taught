package rave.code.utility.pdf;

import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FOPPDFMaker {

    public static void main(String[] args) throws Exception {
        // Load FOP config with Tamil font
        InputStream configStream = FOPPDFMaker.class.getResourceAsStream("/fop.xconf");
        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI(), configStream);

        // Input XML and XSL
        Source xmlSource = new StreamSource(FOPPDFMaker.class.getResourceAsStream("/input.xml"));
        Source xslSource = new StreamSource(FOPPDFMaker.class.getResourceAsStream("/template.xsl"));

        // Output PDF
        try (OutputStream out = new FileOutputStream("output-tamil.pdf")) {
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, out);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(xslSource);

            // Transform XML to PDF via XSL-FO
            transformer.transform(xmlSource, new SAXResult(fop.getDefaultHandler()));
        }

        System.out.println("PDF generated: output-tamil.pdf");
    }
}
