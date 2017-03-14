package com.produte.Bean;

import java.util.List;

public class Order {
	private String editionCode;
	private AddOnOfferingCode addonOfferingCode;
	private String pricingDuration;
	private List<Items> items;
	private List<CustomAttributes> customAttributes;
	public String getEditionCode() {
		return editionCode;
	}
	public void setEditionCode(String editionCode) {
		this.editionCode = editionCode;
	}
	public AddOnOfferingCode getAddonOfferingCode() {
		return addonOfferingCode;
	}
	public void setAddonOfferingCode(AddOnOfferingCode addonOfferingCode) {
		this.addonOfferingCode = addonOfferingCode;
	}
	public String getPricingDuration() {
		return pricingDuration;
	}
	public void setPricingDuration(String pricingDuration) {
		this.pricingDuration = pricingDuration;
	}
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}
	public List<CustomAttributes> getCustomAttributes() {
		return customAttributes;
	}
	public void setCustomAttributes(List<CustomAttributes> customAttributes) {
		this.customAttributes = customAttributes;
	}
	
	

}
