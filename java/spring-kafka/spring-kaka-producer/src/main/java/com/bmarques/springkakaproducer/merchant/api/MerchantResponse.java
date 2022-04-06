package com.bmarques.springkakaproducer.merchant.api;


import java.util.UUID;

public class MerchantResponse {
    private UUID id;
    private String name;
    private String slug;
    private String whatsAppPhone;
    private Boolean delivery;

    public MerchantResponse(UUID id, String name, String slug, String whatsAppPhone, Boolean delivery) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.whatsAppPhone = whatsAppPhone;
        this.delivery = delivery;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getWhatsAppPhone() {
        return whatsAppPhone;
    }

    public void setWhatsAppPhone(String whatsAppPhone) {
        this.whatsAppPhone = whatsAppPhone;
    }

    public Boolean getDelivery() {
        return delivery;
    }

    public void setDelivery(Boolean delivery) {
        this.delivery = delivery;
    }
}
