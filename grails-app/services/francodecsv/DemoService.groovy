package francodecsv

import grails.web.api.ServletAttributes
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVPrinter

class DemoService implements ServletAttributes {

    // result is ignored in this particular example... unclear from
    // the StackOverflow question what that is supposed to be used for
    void createAndDownloadExcelTuttiCampiRichiesta(ArrayList result) {
        response.setContentType('application/CSV')
        response.setHeader('Content-Disposition', 'Attachment;Filename="report.csv"')
        CharArrayWriter writer = new CharArrayWriter()
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("ID", "Name", "Designation", "Company"))
        csvPrinter.printRecord("1", "Test", "Test", "Test")
        csvPrinter.printRecord("2", "Test", "Test", "Test")
        csvPrinter.printRecord("3", "Test", "Test", "Test")
        csvPrinter.printRecord("4", "Test", "Test", "Test")
        csvPrinter.flush()
        response.outputStream << writer.toCharArray()
    }
}
