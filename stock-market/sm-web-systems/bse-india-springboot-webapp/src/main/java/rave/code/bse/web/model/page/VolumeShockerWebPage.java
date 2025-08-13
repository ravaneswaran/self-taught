package rave.code.bse.web.model.page;

import rave.code.bse.web.model.stock.VolumeShockerStock;

import java.util.List;

public class VolumeShockerWebPage extends WebPage {

    private List<VolumeShockerStock> volumeShockerStocks;

    public List<VolumeShockerStock> getVolumeShockerStocks() {
        return volumeShockerStocks;
    }

    public void setVolumeShockerStocks(List<VolumeShockerStock> volumeShockerStocks) {
        this.volumeShockerStocks = volumeShockerStocks;
    }
}
