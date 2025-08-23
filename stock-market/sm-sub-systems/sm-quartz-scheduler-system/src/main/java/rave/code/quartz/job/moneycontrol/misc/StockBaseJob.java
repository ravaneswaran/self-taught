package rave.code.quartz.job.moneycontrol.misc;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import rave.code.quartz.enums.DailyPriceListDownloadLink;
import rave.code.quartz.job.AbstractQuartzJob;
import rave.code.stockmarket.entity.NSEStockBaseEntity;
import rave.code.stockmarket.entity.StockBaseEntity;
import rave.code.stockmarket.repository.StockBaseRepository;
import rave.code.utilities.file.SimpleFileReader;
import rave.code.utility.download.FileDownloader;
import rave.code.utility.zip.ZipFileReader;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StockBaseJob extends AbstractQuartzJob {

    protected Date date;

    public StockBaseJob() {
        this.date = new Date();
    }

    public StockBaseJob(Date date) {
        this.date = date;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //new BSEStockBaseJob().execute(jobExecutionContext);
        new NSEStockBaseJob(this.date).execute(jobExecutionContext);
    }

    class BSEStockBaseJob extends StockBaseJob {

        private static final Logger LOGGER = Logger.getLogger(BSEStockBaseJob.class.getName());

        private StockBaseRepository stockBaseRepository = new StockBaseRepository();

        @Override
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            String url = String.format(DailyPriceListDownloadLink.DAILY_PRICE_LIST_DOWNLOAD_LINK_BSE.get(), simpleDateFormat.format(this.date));
            FileDownloader fileDownloader = new FileDownloader();//new BSEStockBaseJob().execute(jobExecutionContext);

            /*try (InputStream inputStream = fileDownloader.downloadFile(url)) {
                ApacheCommonsCSVFileReader apacheCommonsCSVReader = new ApacheCommonsCSVFileReader();
                List<CSVRecord> csvRecords = apacheCommonsCSVReader.read(inputStream);
                List<StockBaseEntity> bseStockBaseEntities = new ArrayList<>();
                for (CSVRecord csvRecord : csvRecords) {
                    BSEStockBaseEntity bseStockBaseEntity = new BSEStockBaseEntity();

                    bseStockBaseEntity.setMkt(csvRecord.get(0));
                    bseStockBaseEntity.setSeries(csvRecord.get(0));
                    bseStockBaseEntity.setStockSymbol(csvRecord.get(0));
                    bseStockBaseEntity.setStockName(csvRecord.get(0));
                    bseStockBaseEntity.setOpenPrice(csvRecord.get(0));
                    bseStockBaseEntity.setHighPrice(csvRecord.get(0));
                    bseStockBaseEntity.setLowPrice(csvRecord.get(0));
                    bseStockBaseEntity.setClosePrice(csvRecord.get(0));
                    bseStockBaseEntity.setPreviousClosePrice(csvRecord.get(0));
                    bseStockBaseEntity.setNetTradedValue(csvRecord.get(0));
                    bseStockBaseEntity.setNetTradedQuantity(csvRecord.get(0));
                    bseStockBaseEntity.setIndexOrSecurity(csvRecord.get(0));
                    bseStockBaseEntity.setCorpIndex(csvRecord.get(0));
                    bseStockBaseEntity.setTrades(csvRecord.get(0));
                    bseStockBaseEntity.setHigh52Week(csvRecord.get(0));
                    bseStockBaseEntity.setLow52Week(csvRecord.get(0));
                    bseStockBaseEntity.setDailyClosePrice(csvRecord.get(0));
                    Date now = new Date();
                    bseStockBaseEntity.setCreatedDate(now);
                    bseStockBaseEntity.setModifiedDate(now);
                    bseStockBaseEntity.setCreatedBy("SYSTEM");
                    bseStockBaseEntity.setModifiedBy("SYSTEM");

                    bseStockBaseEntities.add(bseStockBaseEntity);
                }
                this.stockBaseRepository.bulkUpsert(bseStockBaseEntities);
            } catch (IOException ioException) {
                LOGGER.log(Level.SEVERE, ioException.getMessage(), ioException);
            }*/
        }
    }

    class NSEStockBaseJob extends StockBaseJob {

        private static final Logger LOGGER = Logger.getLogger(NSEStockBaseJob.class.getName());

        private StockBaseRepository stockBaseRepository = new StockBaseRepository();

        public NSEStockBaseJob() {
            super();
        }

        public NSEStockBaseJob(Date date) {
            super(date);
        }

        @Override
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyy");
            String url = String.format(DailyPriceListDownloadLink.DAILY_PRICE_LIST_DOWNLOAD_LINK_NSE.get(), simpleDateFormat.format(this.date));
            LOGGER.log(Level.INFO, String.format("Downloading file... %s", url));
            FileDownloader fileDownloader = new FileDownloader();
            String zipEntryFileName = String.format("Pd%s.csv", simpleDateFormat.format(this.date));
            List<StockBaseEntity> nseStockBaseEntities = new ArrayList<>();

            try (InputStream inputStream = fileDownloader.downloadFile(url);
                 InputStream csvFileInputStream = new ZipFileReader().read(inputStream, zipEntryFileName)) {

                List<String> lines = new SimpleFileReader().read(csvFileInputStream);
                int lineNumber = 1;
                for (String line : lines) {
                    String[] lineDetails = line.split(",");
                    if(1 == lineNumber){
                        LOGGER.log(Level.INFO, "skipping the header... ");
                        LOGGER.log(Level.INFO, "<<<<< paring indexes... >>>>>");
                        lineNumber = lineNumber + 1;
                        continue;
                    }
                    if("".equals(lineDetails[2].trim()) && "".equals(lineDetails[3].trim()) && "".equals(lineDetails[4].trim())){
                        continue;
                    }
                    if("".equals(lineDetails[2].trim()) && !"".equals(lineDetails[3].trim()) && "".equals(lineDetails[4].trim())){
                        LOGGER.log(Level.INFO, String.format("<<<<< paring the section... %s >>>>>", lineDetails[3]));
                        continue;
                    }

                    NSEStockBaseEntity nseStockBaseEntity = new NSEStockBaseEntity();
                    nseStockBaseEntity.setMkt(lineDetails[0]);
                    nseStockBaseEntity.setSeries(lineDetails[1]);
                    nseStockBaseEntity.setStockSymbol(lineDetails[2]);
                    nseStockBaseEntity.setStockName(lineDetails[3]);
                    nseStockBaseEntity.setPreviousClosePrice(lineDetails[4]);
                    nseStockBaseEntity.setOpenPrice(lineDetails[5]);
                    nseStockBaseEntity.setHighPrice(lineDetails[6]);
                    nseStockBaseEntity.setLowPrice(lineDetails[7]);
                    String closePrice = lineDetails[8];
                    nseStockBaseEntity.setClosePrice(closePrice);
                    nseStockBaseEntity.setNetTradedValue(lineDetails[9]);
                    nseStockBaseEntity.setNetTradedQuantity(lineDetails[10]);
                    String indexOrSecurity = lineDetails[11];
                    indexOrSecurity = "Y".equalsIgnoreCase(indexOrSecurity) ? "INDEX" : "SECURITY";
                    nseStockBaseEntity.setIndexOrSecurity(indexOrSecurity);
                    nseStockBaseEntity.setCorpIndex(lineDetails[12]);
                    nseStockBaseEntity.setTrades(lineDetails[13]);
                    nseStockBaseEntity.setHigh52Week(lineDetails[14]);
                    nseStockBaseEntity.setLow52Week(lineDetails[15]);
                    nseStockBaseEntity.setDailyClosePrice(closePrice);
                    Date now = new Date();
                    nseStockBaseEntity.setCreatedDate(now);
                    nseStockBaseEntity.setModifiedDate(now);
                    nseStockBaseEntity.setCreatedBy("SYSTEM");
                    nseStockBaseEntity.setModifiedBy("SYSTEM");

                    nseStockBaseEntities.add(nseStockBaseEntity);

                    LOGGER.log(Level.INFO, nseStockBaseEntity.toString());
                }
            } catch (IOException ioException) {
                LOGGER.log(Level.SEVERE, ioException.getMessage(), ioException);
            }

            System.out.println("1 ------------------->>>>>> "+nseStockBaseEntities.size());

            this.stockBaseRepository.bulkUpsert(nseStockBaseEntities);
        }
    }

    public static void main(String[] args) throws JobExecutionException {
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);

        Date toDate = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date yesterDate = Date.from(yesterday.atStartOfDay(ZoneId.systemDefault()).toInstant());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyy");

        StockBaseJob stockBaseJob = new StockBaseJob(yesterDate);
        stockBaseJob.execute(null);
    }
}


