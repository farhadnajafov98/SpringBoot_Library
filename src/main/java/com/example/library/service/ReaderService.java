package com.example.library.service;


import com.example.library.request.RequestReader;
import com.example.library.response.Response;
import com.example.library.response.ResponseReader;
import com.example.library.response.ResponseStatusList;

import java.util.List;

public interface ReaderService {
    Response<List<ResponseReader>> getReaderList();

    Response<ResponseReader> getReaderListById(Long readerId);

    ResponseStatusList addReader(RequestReader requestReader);

    ResponseStatusList updateReader(RequestReader requestReader);

    ResponseStatusList deleteReader(Long readerId);

}
