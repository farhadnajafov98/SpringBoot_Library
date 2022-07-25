package com.example.library.controller;

import com.example.library.request.RequestReader;
import com.example.library.response.Response;
import com.example.library.response.ResponseReader;
import com.example.library.response.ResponseStatusList;
import com.example.library.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/reader")
public class ReaderController {
    @Autowired
    ReaderService readerService;

    @GetMapping(value = "/readerList")
    public Response<List<ResponseReader>> getReaderList() {
        return readerService.getReaderList();
    }

    @PostMapping(value = "getReaderListById")
    public Response<ResponseReader> getReaderListById(@RequestParam Long readerId) {
        return readerService.getReaderListById(readerId);
    }

    @PostMapping(value = "/addReader")
    public ResponseStatusList addReader(@RequestBody RequestReader requestReader) {
        return readerService.addReader(requestReader);
    }

    @PutMapping(value = "/updateReader")
    public ResponseStatusList updateReader(@RequestBody RequestReader requestReader) {
        return readerService.updateReader(requestReader);
    }

    @PutMapping(value = "/deleteReader/{readerId}")
    public ResponseStatusList deleteReader(@PathParam("readerId") Long readeerId) {
        return readerService.deleteReader(readeerId);
    }

}
