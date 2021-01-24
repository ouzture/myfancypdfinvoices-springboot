package com.ouzture.myfancypdfinvoicesspring.boot.web;

import com.ouzture.myfancypdfinvoicesspring.boot.dto.InvoiceDTO;
import com.ouzture.myfancypdfinvoicesspring.boot.model.Invoice;
import com.ouzture.myfancypdfinvoicesspring.boot.services.InvoiceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }


    @GetMapping("/invoices")
    public List<Invoice> findAll() {
        return invoiceService.findAll();
    }

    @PostMapping("/invoices")
    public Invoice createInvoice(@RequestBody @Valid InvoiceDTO invoiceDTO) {
        return invoiceService.create(invoiceDTO.getUserId(), invoiceDTO.getAmount());

    }

}
