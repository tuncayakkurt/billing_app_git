package com.billing.installcustomerws.controller;

import com.billing.installcustomerws.service.CustomerService;
import com.blg.client.payload.request.CorporateSubscriptionRequest;
import com.blg.client.payload.request.IndividualSubscriptionRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@RestController
@RequestMapping("/api/customer")
@Tag(name = "Customer Controller", description = "Customer transactions are carried out")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/individual")
    @Operation(summary = "Creates an Individual Subscription Customer",
            responses = {
                    @ApiResponse(responseCode = "200", description = "success"),
                    @ApiResponse(responseCode = "600", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = "{'customer.name' : 'Name cannot be empty!'}")), description = "Returning fields and error messages that do not match validation as hashmap"),
                    @ApiResponse(responseCode = "601", content = @Content(mediaType = "application/json", schema = @Schema(allOf = {com.billing.installcustomerws.exceptions.ErrorMessage.class})), description = "CustomerAlreadyExistsException"),
            })
    public ResponseEntity<?> createIndividualSubs(@RequestBody @Valid IndividualSubscriptionRequest subscriptionRequest) {
        customerService.createIndividualCustomer(subscriptionRequest);
        return ResponseEntity.ok().body("success");
    }

    @PostMapping("/corporate")
    @Operation(summary = "Creates an Corporate Subscription Customer",
            responses = {
                    @ApiResponse(responseCode = "200", description = "success"),
            })
    public ResponseEntity<?> createCorporateSubs(@Valid @RequestBody CorporateSubscriptionRequest subscriptionRequest) {
        customerService.createCorporateCustomer(subscriptionRequest);
        return ResponseEntity.ok().body("success");
    }

    //@Content(mediaType = "application/json", schema = @Schema(allOf = {com.billing.installcustomerws.entity.postgre.IndividualCustomer.class})))
    @GetMapping
    @Operation(summary = "You can query the customer by identity/tax number",
            responses = {
                    @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "204", content = @Content(mediaType = "application/json"))
            })
    public ResponseEntity<?> checkAndFetchCustomer(
            @NotEmpty
            @RequestParam
            @Parameter(example = "11111111110", description = "identity or tax number")
            String identityOrTaxNumber
    ) {
        Boolean existsCustomer = customerService.checkAndFetchCustomer(identityOrTaxNumber);
        if (!existsCustomer) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().build();
    }


}

