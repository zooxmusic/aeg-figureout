package com.aeg.controller;

import com.aeg.ims.batch.CRHPWESService;
import com.aeg.ims.batch.CRSftpGatewayService;
import com.aeg.ims.transfer.TransferResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    @Autowired
    private CRSftpGatewayService crSftpGatewayService;

    @Autowired
    private CRHPWESService crhpwesService;


    @RequestMapping("/transferCr")
    public TransferResult transferCr() {

        try {
            crSftpGatewayService.transfer();

        } catch(Exception e) {
            return TransferResult.failed();
        }
        return TransferResult.success();

    }

    @RequestMapping("/transferCr2")
    public TransferResult transferCr2() {

        try {
            crhpwesService.transfer();

        } catch(Exception e) {
            return TransferResult.failed();
        }
        return TransferResult.success();

    }
}
