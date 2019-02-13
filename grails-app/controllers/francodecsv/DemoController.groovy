package francodecsv

class DemoController {

    DemoService demoService

    def index() {
        demoService.createAndDownloadExcelTuttiCampiRichiesta([])
    }
}
