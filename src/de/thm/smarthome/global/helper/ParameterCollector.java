package de.thm.smarthome.global.helper;

import de.thm.smarthome.global.beans.ManufacturerBean;
import de.thm.smarthome.global.beans.ModelVariantBean;

public class ParameterCollector {
    private String modelVariant;
    private String manufacturer;
    private ModelVariantBean modelVariantBean;
    private ManufacturerBean manufacturerBean;
    private String serialnumber;
    private boolean proceed;

    public ParameterCollector(String modelVariant, String manufacturer, String serialnumber) {
        this.modelVariant = modelVariant;
        this.manufacturer = manufacturer;
        this.serialnumber = serialnumber;
    }

    public String getModelVariant() {
        return modelVariant;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public ModelVariantBean getModelVariantBean() {
        return modelVariantBean;
    }

    public ManufacturerBean getManufacturerBean() {
        return manufacturerBean;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public boolean isProceed() {
        return proceed;
    }

    public void setModelVariant(String modelVariant) {
        this.modelVariant = modelVariant;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModelVariantBean(ModelVariantBean modelVariantBean) {
        this.modelVariantBean = modelVariantBean;
    }

    public void setManufacturerBean(ManufacturerBean manufacturerBean) {
        this.manufacturerBean = manufacturerBean;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public void setProceed(boolean proceed) {
        this.proceed = proceed;
    }
}
