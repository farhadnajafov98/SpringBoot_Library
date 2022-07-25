package com.example.library.service.impl;


import com.example.library.entity.Reader;
import com.example.library.enums.EnumAvaliableStatus;
import com.example.library.exceptions.ExceptionsConstant;
import com.example.library.exceptions.LibraryException;
import com.example.library.repository.ReaderRepository;
import com.example.library.request.RequestReader;
import com.example.library.response.Response;
import com.example.library.response.ResponseReader;
import com.example.library.response.ResponseStatus;
import com.example.library.response.ResponseStatusList;
import com.example.library.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    ReaderRepository readerRepository;

    @Override
    public Response<List<ResponseReader>> getReaderList() {
        Response<List<ResponseReader>> response = new Response<>();
        try {
            List<Reader> reader = readerRepository.findAllByActive(EnumAvaliableStatus.ACTIVE.getValue());
            if (reader == null) {
                throw new LibraryException(ExceptionsConstant.READER_NOT_FOUND, "READER NOT FOUND");
            }
            List<ResponseReader> responseReaderList = new ArrayList<>();
            for (Reader readers : reader) {
                ResponseReader responseReader = new ResponseReader();
                responseReader.setId(readers.getId());
                responseReader.setName(readers.getName());
                responseReader.setSurname(readers.getSurName());
                responseReader.setDateOfBirth(readers.getDateOfBirth());
                responseReader.setAddress(readers.getAddress());
                responseReader.setContact(readers.getContact());
                responseReaderList.add(responseReader);
                response.setT(responseReaderList);
                response.setStatus(ResponseStatus.getSuccessMessage());
            }

        } catch (LibraryException ex) {
            response.setStatus(new ResponseStatus(ex.getCode(), ex.getMessage()));
        } catch (Exception exx) {
            exx.printStackTrace();
            response.setStatus(new ResponseStatus(ExceptionsConstant.INTERNAL_EXCEPTION, "INTERNAL EXCEPTION"));
        }
        return response;
    }

    @Override
    public Response<ResponseReader> getReaderListById(Long readerId) {
        Response<ResponseReader> response = new Response<>();
        try {
            if (readerId == null) {
                throw new LibraryException(ExceptionsConstant.INVALID_REQUEST_DATA, "INVALID REQUEST DATA");

            }
            Reader reader = readerRepository.findReaderByIdAndActive(readerId, EnumAvaliableStatus.ACTIVE.getValue());
            if (reader == null) {
                throw new LibraryException(ExceptionsConstant.READER_NOT_FOUND, "BOOK NOT FOUND");
            }
            ResponseReader responseReader = new ResponseReader();
            responseReader.setId(readerId);
            responseReader.setName(reader.getName());
            responseReader.setSurname(reader.getSurName());
            responseReader.setDateOfBirth(reader.getDateOfBirth());
            responseReader.setAddress(reader.getAddress());
            responseReader.setContact(reader.getContact());
            response.setT(responseReader);
            response.setStatus(ResponseStatus.getSuccessMessage());
        } catch (LibraryException ex) {
            response.setStatus(new ResponseStatus(ex.getCode(), ex.getMessage()));
        } catch (Exception exx) {
            exx.printStackTrace();
            response.setStatus(new ResponseStatus(ExceptionsConstant.INTERNAL_EXCEPTION, "INTERNAL EXCEPTION"));
        }
        return null;
    }

    @Override
    public ResponseStatusList addReader(RequestReader requestReader) {
        ResponseStatusList response = new ResponseStatusList();
        try {
            Long Id = requestReader.getId();
            String name = requestReader.getName();
            String surname = requestReader.getSurname();
            Date dateOfBirth = requestReader.getDateOfBirth();
            String address = requestReader.getAddress();
            Long contact = requestReader.getContact();
            if (Id == null || name == null || surname == null || dateOfBirth == null || address == null || contact == null) {
                throw new LibraryException(ExceptionsConstant.INVALID_REQUEST_DATA, "INVALID REQUEST DATA");

            }
            Reader reader = new Reader();
            reader.setId(Id);
            reader.setName(name);
            reader.setSurName(surname);
            reader.setDateOfBirth(dateOfBirth);
            reader.setAddress(address);
            reader.setContact(contact);
            readerRepository.save(reader);
            response.setStatus(ResponseStatus.getSuccessMessage());
        } catch (LibraryException ex) {
            response.setStatus(new ResponseStatus(ex.getCode(), ex.getMessage()));

        } catch (Exception exx) {
            exx.printStackTrace();
            response.setStatus(new ResponseStatus(ExceptionsConstant.INTERNAL_EXCEPTION, "INTERNAL EXCEPTION"));
        }
        return response;
    }

    @Override
    public ResponseStatusList updateReader(RequestReader requestReader) {
        ResponseStatusList response = new ResponseStatusList();
        try {
            Long Id = requestReader.getId();
            String name = requestReader.getName();
            String surname = requestReader.getSurname();
            Date dateOfBirth = requestReader.getDateOfBirth();
            String address = requestReader.getAddress();
            Long contact = requestReader.getContact();
            if (Id == null || name == null || surname == null || dateOfBirth == null || address == null || contact == null) {
                throw new LibraryException(ExceptionsConstant.INVALID_REQUEST_DATA, "INVALID REQUEST DATA");

            }
            Reader reader = readerRepository.findReaderByIdAndActive(requestReader.getId(), EnumAvaliableStatus.ACTIVE.getValue());
            if (reader == null) {
                throw new LibraryException(ExceptionsConstant.READER_NOT_FOUND, "READER NOT FOUND");
            }
            reader.setId(Id);
            reader.setName(name);
            reader.setSurName(surname);
            reader.setDateOfBirth(dateOfBirth);
            reader.setAddress(address);
            reader.setContact(contact);
            readerRepository.save(reader);
            response.setStatus(ResponseStatus.getSuccessMessage());
        } catch (LibraryException ex) {
            response.setStatus(new ResponseStatus(ex.getCode(), ex.getMessage()));
        } catch (Exception exx) {
            exx.printStackTrace();
            response.setStatus(new ResponseStatus(ExceptionsConstant.INTERNAL_EXCEPTION, "INTERNAL EXCEPTION"));
        }
        return response;
    }

    @Override
    public ResponseStatusList deleteReader(Long readerId) {
        ResponseStatusList response = new ResponseStatusList();
        try {
            if (readerId == null) {
                throw new LibraryException(ExceptionsConstant.INVALID_REQUEST_DATA, "INVALID REQUEST DATA");
            }
            Reader reader = readerRepository.findReaderByIdAndActive(readerId, EnumAvaliableStatus.ACTIVE.getValue());
            if (reader == null) {
                throw new LibraryException(ExceptionsConstant.READER_NOT_FOUND, "READER NOT FOUND");
            }
            reader.setActive(EnumAvaliableStatus.DEACTIVE.getValue());
            readerRepository.save(reader);
            response.setStatus(ResponseStatus.getSuccessMessage());

        } catch (LibraryException ex) {
            response.setStatus(new ResponseStatus(ex.getCode(), ex.getMessage()));
        } catch (Exception exx) {
            exx.printStackTrace();
            response.setStatus(new ResponseStatus(ExceptionsConstant.INTERNAL_EXCEPTION, "INTERNAL EXCEPTION"));
        }
        return response;
    }
}
