package com.bmarques.store.domain.purchase;

import com.bmarques.store.domain.supplier.PurchaseOrderResponse;
import com.bmarques.store.domain.supplier.SupplierClient;
import com.bmarques.store.domain.supplier.SupplierInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

    private static final Logger LOG = LoggerFactory.getLogger(PurchaseService.class);
    //    private final RestTemplate restTemplate;
//    private DiscoveryClient discoveryClient;
    private SupplierClient supplierClient;

    public PurchaseService(SupplierClient supplierClient) {
        this.supplierClient = supplierClient;
    }

    public PurchaseEntity generatePurchase(PurchaseDto purchaseDto) {
//        ResponseEntity<SupplierInfo> exchange = restTemplate.exchange("http://supplier/supplier/" + purchaseEntity.getAdress().getState(),
//                HttpMethod.GET, null, SupplierInfo.class);
// This is to list all instances
//        discoveryClient.getInstancesById("supplier")
//                .forEach(supplier -> System.out.println("localhost:"+supplier.getPort()));

        String state = purchaseDto.getAdress().getState();
        LOG.info("get supplier informations by {}", state);

        SupplierInfo supplierByState = supplierClient.getSupplierByState(state);

        LOG.info("generate a purchase");
        PurchaseOrderResponse purchaseOrderResponse = supplierClient.generatePurchaseOrder(purchaseDto.getItems());

        return PurchaseEntity.builder()
                .purchaseOrderId(purchaseOrderResponse.getId())
                .preparationTime(purchaseOrderResponse.getPreparationTime())
                .addressDestiny(supplierByState.getAddress())
                .build();
    }
}
