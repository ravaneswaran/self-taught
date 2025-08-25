package rave.code.quartz.job.moneycontrol.misc;

import org.apache.commons.csv.CSVRecord;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import rave.code.quartz.enums.ASCIIColorCodes;
import rave.code.quartz.enums.DailyPriceListDownloadLink;
import rave.code.quartz.enums.NSEClassification;
import rave.code.quartz.job.AbstractQuartzJob;
import rave.code.quartz.job.AbstractStockMarketEntityMakerJob;
import rave.code.stockmarket.entity.BSEStockBaseEntity;
import rave.code.stockmarket.entity.NSEStockBaseEntity;
import rave.code.stockmarket.entity.StockBaseEntity;
import rave.code.stockmarket.repository.StockBaseRepository;
import rave.code.utilities.file.SimpleFileReader;
import rave.code.utility.csv.ApacheCommonsCSVFileReader;
import rave.code.utility.download.FileDownloader;
import rave.code.utility.log.JavaUtilLogDecor;
import rave.code.utility.zip.ZipFileReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
        new NSEStockBaseJob().execute(jobExecutionContext);
        //new BSEStockBaseJob().execute(jobExecutionContext);
    }

    class BSEStockBaseJob extends AbstractStockMarketEntityMakerJob<List<CSVRecord>, List<StockBaseEntity>> {

        private static final Logger LOGGER = Logger.getLogger(BSEStockBaseJob.class.getName());

        private StockBaseRepository stockBaseRepository = new StockBaseRepository();

        @Override //new BSEStockBaseJob().execute(jobExecutionContext);
        public List<CSVRecord> getDataFromSource() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            String url = String.format(DailyPriceListDownloadLink.DAILY_PRICE_LIST_DOWNLOAD_LINK_BSE.get(), simpleDateFormat.format(StockBaseJob.this.date));
            LOGGER.log(Level.INFO, String.format("Downloading file... %s", url));
            FileDownloader fileDownloader = new FileDownloader();
            List<CSVRecord> csvRecords = new ArrayList<>();
            try (InputStream inputStream = fileDownloader.downloadFile(url)) {
                ApacheCommonsCSVFileReader apacheCommonsCSVReader = new ApacheCommonsCSVFileReader();
                csvRecords = apacheCommonsCSVReader.read(inputStream);
            } catch (FileNotFoundException fileNotFoundException) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                LOGGER.log(Level.SEVERE, String.format("Resource(%s) not found...", url));
                LOGGER.log(Level.SEVERE, "Possibly could be the following reason(s)...");
                LOGGER.log(Level.SEVERE, String.format("the day which the date(%s) referring to could be either HOLIDAY or WEEKEND(SATURDAY or SUNDAY)", sdf.format(StockBaseJob.this.date)));
            } catch (IOException ioException) {
                LOGGER.log(Level.SEVERE, ioException.getMessage(), ioException);
            }
            return csvRecords;
        }

        @Override
        public List<StockBaseEntity> transformSourceData(List<CSVRecord> sourceData) {
            List<StockBaseEntity> bseStockBaseEntities = new ArrayList<>();
            for (CSVRecord csvRecord : sourceData) {
                BSEStockBaseEntity bseStockBaseEntity = new BSEStockBaseEntity();

                bseStockBaseEntity.setMkt(csvRecord.get(2));
                bseStockBaseEntity.setSeries(csvRecord.get(3));
                bseStockBaseEntity.setFinancialInstrumentType(csvRecord.get(4));
                bseStockBaseEntity.setFinancialInstrumentId(csvRecord.get(5));
                bseStockBaseEntity.setISIN(csvRecord.get(6));
                bseStockBaseEntity.setStockSymbol(csvRecord.get(7));
                bseStockBaseEntity.setStockName(csvRecord.get(13));
                bseStockBaseEntity.setOpenPrice(csvRecord.get(14));
                bseStockBaseEntity.setHighPrice(csvRecord.get(15));
                bseStockBaseEntity.setLowPrice(csvRecord.get(16));
                bseStockBaseEntity.setClosePrice(csvRecord.get(17));
                bseStockBaseEntity.setPreviousClosePrice(csvRecord.get(19));
                bseStockBaseEntity.setNetTradedQuantity(csvRecord.get(24));
                bseStockBaseEntity.setNetTradedValue(csvRecord.get(25));
                bseStockBaseEntity.setIndexOrSecurity("N/A");
                bseStockBaseEntity.setCorpIndex("N/A");
                bseStockBaseEntity.setTrades("N/A");
                bseStockBaseEntity.setHigh52Week("N/A");
                bseStockBaseEntity.setLow52Week("N/A");
                bseStockBaseEntity.setDailyClosePrice(csvRecord.get(17));
                Date now = new Date();
                bseStockBaseEntity.setCreatedDate(now);
                bseStockBaseEntity.setModifiedDate(now);
                bseStockBaseEntity.setCreatedBy("SYSTEM");
                bseStockBaseEntity.setModifiedBy("SYSTEM");

                bseStockBaseEntities.add(bseStockBaseEntity);
            }
            return bseStockBaseEntities;
        }

        @Override
        public void saveTransformedData(List<StockBaseEntity> transformedData) {
            //this.stockBaseRepository.bulkUpsert(transformedData);
        }
    }

    class NSEStockBaseJob extends AbstractStockMarketEntityMakerJob<List<String>, List<StockBaseEntity>> {

        private static final Logger LOGGER = Logger.getLogger(NSEStockBaseJob.class.getName());

        private StockBaseRepository stockBaseRepository = new StockBaseRepository();

        public NSEStockBaseJob() {
            super();
        }

        @Override
        public List<String> getDataFromSource() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyy");
            String formattedDate = simpleDateFormat.format(StockBaseJob.this.date);
            String url = String.format(DailyPriceListDownloadLink.DAILY_PRICE_LIST_DOWNLOAD_LINK_NSE.get(), formattedDate);
            LOGGER.log(Level.INFO, String.format("Downloading file... %s", url));
            FileDownloader fileDownloader = new FileDownloader();
            String zipEntryFileName = String.format("Pd%s.csv", formattedDate);

            List<String> lines = new ArrayList<>();
            try (InputStream inputStream = fileDownloader.downloadFile(url);
                 InputStream csvFileInputStream = new ZipFileReader().read(inputStream, zipEntryFileName);) {
                lines = new SimpleFileReader().read(csvFileInputStream);
            } catch (FileNotFoundException ioException) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                LOGGER.log(Level.SEVERE, String.format("Resource(%s) not found...", url));
                LOGGER.log(Level.SEVERE, "Possibly could be the following reason(s)...");
                LOGGER.log(Level.SEVERE, String.format("the day the date(%s) referring to could be either HOLIDAY or WEEKEND(SATURDAY or SUNDAY)", sdf.format(StockBaseJob.this.date)));
            } catch (IOException ioException) {
                LOGGER.log(Level.SEVERE, ioException.getMessage(), ioException);
            }
            return lines;
        }

        @Override
        public List<StockBaseEntity> transformSourceData(List<String> sourceData) {
            List<StockBaseEntity> nseStockBaseEntities = new ArrayList<>();
            int lineNumber = 1;

            for (String line : sourceData) {
                String[] lineDetails = line.split(",");

                if (1 == lineNumber) {
                    LOGGER.log(Level.INFO, "skipping the header... ");
                    LOGGER.log(Level.INFO, "<<<<< paring indexes... >>>>>");
                    lineNumber = lineNumber + 1;
                    continue;
                }
                if ("".equals(lineDetails[2].trim()) && "".equals(lineDetails[3].trim()) && "".equals(lineDetails[4].trim())) {
                    continue;
                }
                if ("".equals(lineDetails[2].trim()) && !"".equals(lineDetails[3].trim()) && "".equals(lineDetails[4].trim())) {
                    LOGGER.log(Level.INFO, String.format("<<<<< paring the section... %s >>>>>", lineDetails[3]));
                    continue;
                }

                String series = lineDetails[1].trim();
                if ("".equals(series)) {
                    series = "Empty";
                }

                switch (series) {
                    case "Empty":
                        series = NSEClassification.EMPTY.getClassification();
                        break;
                    case "EQ":
                        series = NSEClassification.EQ.getClassification();
                        break;
                    case "SM":
                        series = NSEClassification.SM.getClassification();
                        break;
                    case "IV":
                        series = NSEClassification.IV.getClassification();
                        break;
                    case "RR":
                        series = NSEClassification.RR.getClassification();
                        break;
                    case "T0":
                        series = NSEClassification.T0.getClassification();
                        break;
                    case "E1":
                        series = NSEClassification.E1.getClassification();
                        break;
                    case "BE":
                        series = NSEClassification.BE.getClassification();
                        break;
                    case "BZ":
                        series = NSEClassification.BZ.getClassification();
                        break;

                    default:
                        series = NSEClassification.DEFAULT.getClassification();
                        break;
                }

                StockBaseEntity stockBaseEntity = new NSEStockBaseEntity();
                stockBaseEntity.setMkt(lineDetails[0].trim());
                stockBaseEntity.setSeries(series);
                stockBaseEntity.setStockSymbol(lineDetails[2].trim());
                stockBaseEntity.setStockName(lineDetails[3].trim());
                stockBaseEntity.setPreviousClosePrice(lineDetails[4].trim());
                stockBaseEntity.setOpenPrice(lineDetails[5].trim());
                stockBaseEntity.setHighPrice(lineDetails[6].trim());
                stockBaseEntity.setLowPrice(lineDetails[7].trim());
                String closePrice = lineDetails[8].trim();
                stockBaseEntity.setClosePrice(closePrice);
                stockBaseEntity.setNetTradedValue(lineDetails[9].trim());
                stockBaseEntity.setNetTradedQuantity(lineDetails[10].trim());
                stockBaseEntity.setIndexOrSecurity(lineDetails[11].trim());
                stockBaseEntity.setCorpIndex(lineDetails[12].trim());
                stockBaseEntity.setTrades(lineDetails[13].trim());
                stockBaseEntity.setHigh52Week(lineDetails[14].trim());
                stockBaseEntity.setLow52Week(lineDetails[15].trim());
                stockBaseEntity.setDailyClosePrice(closePrice);
                Date now = new Date();
                stockBaseEntity.setCreatedDate(now);
                stockBaseEntity.setModifiedDate(now);
                stockBaseEntity.setCreatedBy("SYSTEM");
                stockBaseEntity.setModifiedBy("SYSTEM");

                nseStockBaseEntities.add(stockBaseEntity);
            }

            return nseStockBaseEntities;
        }

        @Override
        public void saveTransformedData(List<StockBaseEntity> transformedData) {
            String source = "NSE";
            Map<String, StockBaseEntity> mappedStockBaseEntities = this.stockBaseRepository.findBySource(source);

            if (mappedStockBaseEntities.size() == 0) {
                LOGGER.log(Level.INFO, String.format("%sLoading fresh set of stocks into the repository for the first time...", ASCIIColorCodes.WHITE.get()));
                this.stockBaseRepository.bulkUpsert(transformedData);
            } else {
                if (mappedStockBaseEntities.size() == 0) {
                    LOGGER.log(Level.INFO, String.format("%sLoading fresh set of stocks into the repository for the first time...", ASCIIColorCodes.WHITE.get()));
                    this.stockBaseRepository.bulkUpsert(transformedData);
                } else {
                    List<StockBaseEntity> stockBaseEntities = new ArrayList<>();
                    for (StockBaseEntity stockBaseEntity : transformedData) {
                        if (mappedStockBaseEntities.size() > 0) {
                            String key = String.format("%s:%s:%s:%s:%s", source, stockBaseEntity.getMkt(), stockBaseEntity.getSeries(), stockBaseEntity.getStockSymbol(), stockBaseEntity.getStockName());
                            StockBaseEntity mappedStockBaseEntity = mappedStockBaseEntities.get(key);
                            if (null != mappedStockBaseEntity) {
                                LOGGER.log(Level.INFO, String.format("[%s] - Stock is already available in the repository hence updating it...", key));
                                stockBaseEntity.setNewEntity(false);
                                stockBaseEntities.add(mappedStockBaseEntity);
                            } else {
                                LOGGER.log(Level.INFO, String.format("%s[%s]%s - Stock is not available in the repository hence creating it......", ASCIIColorCodes.WHITE.get(), key, ASCIIColorCodes.GREEN.get()));
                                stockBaseEntities.add(stockBaseEntity);
                            }
                        }
                    }
                    this.stockBaseRepository.bulkUpsert(stockBaseEntities);
                }
            }
        }
    }

    public static void main(String[] args) throws JobExecutionException {
        JavaUtilLogDecor.setupLogDecor();

        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(6);

        Date toDate = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date yesterDate = Date.from(yesterday.atStartOfDay(ZoneId.systemDefault()).toInstant());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyy");

        StockBaseJob stockBaseJob = new StockBaseJob(yesterDate);
        stockBaseJob.execute(null);
    }
}


